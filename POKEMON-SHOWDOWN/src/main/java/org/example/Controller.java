package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Controller {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/pokemon_db";
    private static final String USER = "root";
    private static final String PASS = "";

    private Connection connection;

    private static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    public static HashMap<String, Status> findAllStatut() {
        HashMap<String, Status> allStatus = new HashMap<>();
        allStatus.put("NONE", new Status("NONE", 0, 1.0, 1.0));
        allStatus.put("BURNED", new Status("BURNED", 0.0625, 0.5, 1.0));
        allStatus.put("PARALYZED", new Status("PARALYZED", 0, 1.0, 0.5));
        allStatus.put("POISONED", new Status("POISONED", 0.125, 1.0, 1.0));
        return allStatus;
    }

    public static HashMap<String, Type> findAllCoefType() {
        HashMap<String, Type> allTypes = new HashMap<>();

        try (Connection connection = Controller.connect();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM coeftype");
                ResultSet set = statement.executeQuery()) {

            while (set.next()) {
                String typeAttacker = set.getString("attacker_type");
                String typeDefender = set.getString("defender_type");
                double coef = set.getDouble("coefficient");

                if (!allTypes.containsKey(typeAttacker)) {
                    allTypes.put(typeAttacker, new Type(typeAttacker));
                }

                Type t = allTypes.get(typeAttacker);
                t.addEfficiency(typeDefender, coef);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return allTypes;
    }

    public static HashMap<String, Pokemon> findAllPokemon(HashMap<String, Type> allTypes,
            HashMap<String, Status> allStatus) {
        HashMap<String, Pokemon> allPokemon = new HashMap<>();
        try (Connection connection = Controller.connect();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM pokemon");
                ResultSet set = statement.executeQuery()) {

            while (set.next()) {
                String namePokemon = set.getString("name");
                double hp = set.getDouble("hp");
                int maxHp = set.getInt("maxHp");
                int speed = set.getInt("speed");
                int specialAttack = set.getInt("specialAttack");
                int classicAttack = set.getInt("classicAttack");
                int specialDefense = set.getInt("specialDefense");
                int classicDefense = set.getInt("classicDefense");
                String type = set.getString("type");
                String type2 = set.getString("type2");

                if (!allPokemon.containsKey(namePokemon)) {
                    if (type2 != null && allTypes.containsKey(type2)) {
                        allPokemon.put(namePokemon, new Pokemon(namePokemon, hp, maxHp,
                                speed, specialAttack, classicAttack,
                                specialDefense, specialDefense,
                                classicDefense, classicDefense,
                                allTypes.get(type), allTypes.get(type2),
                                allStatus.get("NONE"), null));
                    } else {
                        allPokemon.put(namePokemon, new Pokemon(namePokemon, hp, maxHp,
                                speed, specialAttack, classicAttack,
                                specialDefense, specialDefense,
                                classicDefense, classicDefense,
                                allTypes.get(type),
                                allStatus.get("NONE"), null));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return allPokemon;
    }

    public static HashMap<String, Attack> findAllAttacks(HashMap<String, Type> allTypes,
            HashMap<String, Pokemon> allPokemon,
            HashMap<String, Status> allStatus) {
        HashMap<String, Attack> allAttacks = new HashMap<>();
        try (Connection connection = Controller.connect();
                PreparedStatement statement = connection
                        .prepareStatement("SELECT a.name_pokemon, a.name_attack, a.power, " +
                                "a.category, a.type, e.influenced_variable, e.coefficient, " +
                                "e.probability, e.valeur_statut " +
                                "FROM attaques a " +
                                "LEFT JOIN effects e ON a.name_attack = e.name_attack");
                ResultSet set = statement.executeQuery()) {

            while (set.next()) {
                String namePokemon = set.getString("name_pokemon");
                String nameAttack = set.getString("name_attack");
                int power = set.getInt("power");
                String category = set.getString("category");
                String typeAttack = set.getString("type");
                String influencedVariable = set.getString("influenced_variable");
                int proba = set.getInt("probability");
                double coef = set.getDouble("coefficient");
                String valeurStatut = set.getString("valeur_statut");

                if (!allAttacks.containsKey(nameAttack)) {
                    Attack nouvelleAttaque;

                    if (influencedVariable == null) {
                        nouvelleAttaque = new Attack(nameAttack, power, category,
                                allTypes.get(typeAttack));
                    } else if (influencedVariable.equals("hpwinattacker")) {
                        nouvelleAttaque = new HpWinAttacker(nameAttack, power, category,
                                allTypes.get(typeAttack), proba, coef);
                    } else if (influencedVariable.equals("hpdamageattacker")) {
                        nouvelleAttaque = new HpDamageAttacker(nameAttack, power, category,
                                allTypes.get(typeAttack), proba, coef);
                    } else if (influencedVariable.equals("status")) {
                        Status statusToApply = allStatus.get(valeurStatut);
                        nouvelleAttaque = new StatusChange(nameAttack, power, category,
                                allTypes.get(typeAttack), proba, statusToApply);
                    } else if (influencedVariable.equals("classicDefense")) {
                        nouvelleAttaque = new classicDefenseInfluence(nameAttack, power, category,
                                allTypes.get(typeAttack), proba, coef);
                    } else {
                        nouvelleAttaque = new Attack(nameAttack, power, category,
                                allTypes.get(typeAttack));
                    }

                    allAttacks.put(nameAttack, nouvelleAttaque);
                }

                // Associer l'attaque au pokémon
                Attack a = allAttacks.get(nameAttack);
                Pokemon p = allPokemon.get(namePokemon);
                if (p != null && a != null) {
                    p.addListAttacks(a);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return allAttacks;
    }
}
