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

    public static HashMap<String, Type> findAllCoefType() {
        HashMap<String, Type> allTypes = new HashMap<>();

        try (Connection connection = Controller.connect();
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM coeftype");
             ResultSet set = statement.executeQuery()) {


            while (set.next()) {
                // Remplace les noms entre guillemets par le nom exact de tes colonnes phpMyAdmin
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

    public static HashMap<String, Attack> findAllAttacks(HashMap<String, Type> allTypes,HashMap<String, Pokemon> allPokemon) {
        HashMap<String, Attack> allAttacks = new HashMap<>();
        try (Connection connection = Controller.connect();
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM attaques");
             ResultSet set = statement.executeQuery()) {

            while (set.next()) {
                String namePokemon = set.getString("name_pokemon");
                String nameAttack = set.getString("name_attack");
                int power = set.getInt("power");
                String category = set.getString("category");
                String typeAttack = set.getString("type");

                if (!allAttacks.containsKey(nameAttack)) {
                    allAttacks.put(nameAttack, new Attack(nameAttack, power, category,allTypes.get(typeAttack)));
                }

                Attack a = allAttacks.get(nameAttack);

                Pokemon p=allPokemon.get(namePokemon);
                p.addListAttacks(a);


            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return allAttacks;

    }
}



