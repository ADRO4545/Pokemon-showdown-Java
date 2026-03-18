package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.util.List;

public class FightController {

    @FXML
    private Button testButton;

    private List<String> playerTeam;
    private List<String> enemyTeam;
    private int playerLeadIndex;

    public void initData(List<String> playerTeam, List<String> enemyTeam, int leadIndex) {
        this.playerTeam = playerTeam;
        this.enemyTeam = enemyTeam;
        this.playerLeadIndex = leadIndex;
        String leadPokemonName = playerTeam.get(leadIndex);
        testButton.setText(leadPokemonName);
    }
}