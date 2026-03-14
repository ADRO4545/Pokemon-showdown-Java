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

    public static HashMap<String, HashMap<String, Double>> findAllCoefType() {
        HashMap<String, HashMap<String, Double>> typeCombination = new HashMap<>();

        try {

            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM coeftype");
            ResultSet set = statement.executeQuery();


            while (set.next()) {
                // Remplace les noms entre guillemets par le nom exact de tes colonnes phpMyAdmin
                String attacker = set.getString("attacker_type");
                String defender = set.getString("defender_type");
                double coef = set.getDouble("coefficient");

                if (!typeCombination.containsKey(attacker)) {
                    typeCombination.put(attacker, new HashMap<>());
                }

                typeCombination.get(attacker).put(defender, coef);
            }



        } catch (SQLException e) {
            System.out.println(e);
        }

        return typeCombination;

    }
}

