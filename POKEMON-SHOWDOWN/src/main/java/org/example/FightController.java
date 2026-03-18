package org.example;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.Arrays;
import java.util.List;

public class FightController {

    @FXML
    private Label namePlayerActive;
    @FXML
    private Button btnAtk1, btnAtk2, btnAtk3, btnAtk4;
    @FXML
    private ImageView imgPlayerActive;
    @FXML
    private Label hpPlayerActive;

    @FXML
    private ImageView imgEnemyActive;
    @FXML
    private Label nameEnemyActive;
    @FXML
    private Label hpEnemyActive;

    @FXML
    private Button btnSwitch1, btnSwitch2, btnSwitch3, btnSwitch4;
    @FXML
    private TextArea historyLog;

    private List<Pokemon> playersTeam;
    private List<Pokemon> enemiesTeam;

    private Pokemon activePlayerPokemon;
    private Pokemon activeEnemyPokemon;

    private boolean isPlayerForcedToSwitch = false;

    @FXML
    private ImageView imgAttackAnimation;

    public void initData(List<Pokemon> playersTeam, List<Pokemon> enemiesTeam, int leadIndex) {
        this.playersTeam = playersTeam;
        this.enemiesTeam = enemiesTeam;
        this.activePlayerPokemon = playersTeam.get(leadIndex);
        this.activeEnemyPokemon = enemiesTeam.get(0);

        namePlayerActive.setText(activePlayerPokemon.getName());
        updateAttackButtons(activePlayerPokemon);
        updateVisuals(activePlayerPokemon, true);
        updateVisuals(activeEnemyPokemon, false);
        updateDeckButtons();

        historyLog.setText("Un " + activeEnemyPokemon.getName() + " sauvage apparaît !");
    }

    private void updateAttackButtons(Pokemon activePoke) {
        List<Button> atkButtons = Arrays.asList(btnAtk1, btnAtk2, btnAtk3, btnAtk4);
        List<Attack> pokesAttacks = activePoke.getListAttacks();

        for (int i = 0; i < 4; i++) {
            if (i < pokesAttacks.size()) {
                atkButtons.get(i).setText(pokesAttacks.get(i).getName());
                atkButtons.get(i).setVisible(true);
            } else {
                atkButtons.get(i).setVisible(false);
            }
        }
    }

    private void updateVisuals(Pokemon pokemon, boolean isPlayer) {
        ImageView imgView = isPlayer ? imgPlayerActive : imgEnemyActive;
        Label nameLabel = isPlayer ? namePlayerActive : nameEnemyActive;
        Label hpLabel = isPlayer ? hpPlayerActive : hpEnemyActive;

        nameLabel.setText(pokemon.getName());
        hpLabel.setText("HP : " + pokemon.getHp() + " / " + pokemon.getMaxHp());

        try {
            String imagePath = "/images/" + pokemon.getName() + ".png";
            imgView.setImage(new Image(getClass().getResource(imagePath).toExternalForm()));
        } catch (Exception e) {
            System.out.println("Image introuvable pour : " + pokemon.getName());
        }
    }

    private void updateDeckButtons() {
        List<Button> switchButtons = Arrays.asList(btnSwitch1, btnSwitch2, btnSwitch3, btnSwitch4);

        for (int i = 0; i < 4; i++) {
            if (i < playersTeam.size()) {
                Pokemon pokeInDeck = playersTeam.get(i);
                switchButtons.get(i).setText(pokeInDeck.getName() + " (" + pokeInDeck.getHp() + " PV)");

                if (pokeInDeck == activePlayerPokemon || pokeInDeck.getHp() <= 0) {
                    switchButtons.get(i).setDisable(true);
                } else {
                    switchButtons.get(i).setDisable(false);
                }
            } else {
                switchButtons.get(i).setVisible(false);
            }
        }
    }

    @FXML
    public void handleAttackClick(ActionEvent event) {

        SoundManager.playAttackSound("sncf.wav");

        playAttackAnimation("arrow.gif");

        Button boutonClique = (Button) event.getSource();
        List<Button> atkButtons = Arrays.asList(btnAtk1, btnAtk2, btnAtk3, btnAtk4);
        int indexAttaque = atkButtons.indexOf(boutonClique);

        Attack attaqueJoueur = activePlayerPokemon.getListAttacks().get(indexAttaque);

        java.util.Random rand = new java.util.Random();
        List<Attack> attaquesEnnemies = activeEnemyPokemon.getListAttacks();
        Attack attaqueEnnemie = attaquesEnnemies.get(rand.nextInt(attaquesEnnemies.size()));

        Rules rules = new Rules();
        Pokemon[] order = rules.whoStart(activePlayerPokemon, activeEnemyPokemon);
        Pokemon premier = order[0];
        Pokemon second = order[1];

        Attack attaquePremier = (premier == activePlayerPokemon) ? attaqueJoueur : attaqueEnnemie;
        Attack attaqueSecond = (second == activePlayerPokemon) ? attaqueJoueur : attaqueEnnemie;

        historyLog.appendText("\n--- Nouveau Tour ---\n");

        String logPremier = TourManager.playTurn(premier, second, attaquePremier);
        historyLog.appendText(logPremier);

        if (TourManager.isPokemonKO(activePlayerPokemon, activeEnemyPokemon)) {
            handleBattleEnd();
            return;
        }

        String logSecond = TourManager.playTurn(second, premier, attaqueSecond);
        historyLog.appendText(logSecond);

        if (TourManager.isPokemonKO(activePlayerPokemon, activeEnemyPokemon)) {
            handleBattleEnd();
            return;
        }

        historyLog.appendText(TourManager.applyEndOfTurnItem(activePlayerPokemon));
        historyLog.appendText(TourManager.applyEndOfTurnItem(activeEnemyPokemon));
        historyLog.appendText(TourManager.applyEndOfTurnStatus(activePlayerPokemon));
        historyLog.appendText(TourManager.applyEndOfTurnStatus(activeEnemyPokemon));

        if (TourManager.isPokemonKO(activePlayerPokemon, activeEnemyPokemon)) {
            handleBattleEnd();
            return;
        }

        updateVisuals(activePlayerPokemon, true);
        updateVisuals(activeEnemyPokemon, false);
        updateDeckButtons();
    }

    @FXML
    public void handleSwitchClick(ActionEvent event) {

        SoundManager.playAttackSound("cri.wav");

        playAttackAnimation("explosion.gif");

        Button btnClique = (Button) event.getSource();
        List<Button> switchBtns = Arrays.asList(btnSwitch1, btnSwitch2, btnSwitch3, btnSwitch4);
        int index = switchBtns.indexOf(btnClique);

        Pokemon nouveauPoke = playersTeam.get(index);

        historyLog.appendText("\nReviens " + activePlayerPokemon.getName() + " ! Go " + nouveauPoke.getName() + " !\n");
        activePlayerPokemon = nouveauPoke;

        namePlayerActive.setText(activePlayerPokemon.getName());
        updateAttackButtons(activePlayerPokemon);
        updateVisuals(activePlayerPokemon, true);
        updateDeckButtons();

        if (isPlayerForcedToSwitch) {
            isPlayerForcedToSwitch = false;
            enableAttacks();
        } else {
            enemyFreeAttack();
        }
    }

    private void enemyFreeAttack() {
        java.util.Random rand = new java.util.Random();
        List<Attack> attaquesEnnemies = activeEnemyPokemon.getListAttacks();
        Attack attaqueEnnemie = attaquesEnnemies.get(rand.nextInt(attaquesEnnemies.size()));

        historyLog.appendText("L'ennemi profite de votre changement de Pokémon !\n");

        String logAttaque = TourManager.playTurn(activeEnemyPokemon, activePlayerPokemon, attaqueEnnemie);
        historyLog.appendText(logAttaque);

        historyLog.appendText(TourManager.applyEndOfTurnItem(activePlayerPokemon));
        historyLog.appendText(TourManager.applyEndOfTurnItem(activeEnemyPokemon));
        historyLog.appendText(TourManager.applyEndOfTurnStatus(activePlayerPokemon));
        historyLog.appendText(TourManager.applyEndOfTurnStatus(activeEnemyPokemon));

        updateVisuals(activePlayerPokemon, true);
        updateVisuals(activeEnemyPokemon, false);
        updateDeckButtons();

        if (activePlayerPokemon.getHp() <= 0 || activeEnemyPokemon.getHp() <= 0) {
            handleBattleEnd();
        }
    }

    private void playAttackAnimation(String gifFileName) {
        try {
            // Charge le GIF
            String gifPath = "/images/" + gifFileName;
            imgAttackAnimation.setImage(new Image(getClass().getResource(gifPath).toExternalForm()));
            imgAttackAnimation.setVisible(true); // Rend le GIF visible

            // Crée un minuteur pour cacher le GIF après 1.5 secondes (ajustez selon la
            // durée de votre GIF)
            PauseTransition pause = new PauseTransition(Duration.seconds(1.5));
            pause.setOnFinished(event -> imgAttackAnimation.setVisible(false));
            pause.play();

        } catch (Exception e) {
            System.err.println("GIF d'attaque introuvable : " + gifFileName);
        }
    }

    private void handleBattleEnd() {

        SoundManager.playAttackSound("fusil.wav");

        updateVisuals(activePlayerPokemon, true);
        updateVisuals(activeEnemyPokemon, false);
        updateDeckButtons();

        if (activePlayerPokemon.getHp() <= 0) {
            if (isTeamWipedOut(playersTeam)) {
                historyLog.appendText("\nTOUTE VOTRE ÉQUIPE EST K.O ! VOUS AVEZ PERDU...");
                disableAttacks();
                disableSwitches();
            } else {
                historyLog.appendText("\n" + activePlayerPokemon.getName()
                        + " est KO ! Choisissez un autre Pokémon dans votre deck.");
                disableAttacks();
                isPlayerForcedToSwitch = true;
            }
        }

        if (activeEnemyPokemon.getHp() <= 0) {
            if (isTeamWipedOut(enemiesTeam)) {
                historyLog.appendText("\nTOUS LES POKÉMON ADVERSES SONT K.O ! VOUS AVEZ GAGNÉ !");
                disableAttacks();
                disableSwitches();
            } else {
                for (Pokemon p : enemiesTeam) {
                    if (p.getHp() > 0) {
                        activeEnemyPokemon = p;
                        historyLog.appendText("\nL'adversaire envoie " + p.getName() + " !");
                        updateVisuals(activeEnemyPokemon, false);
                        break;
                    }
                }
            }
        }
    }

    private boolean isTeamWipedOut(List<Pokemon> team) {
        for (Pokemon p : team) {
            if (p.getHp() > 0)
                return false;
        }
        return true;
    }

    private void disableAttacks() {
        btnAtk1.setDisable(true);
        btnAtk2.setDisable(true);
        btnAtk3.setDisable(true);
        btnAtk4.setDisable(true);
    }

    private void enableAttacks() {
        btnAtk1.setDisable(false);
        btnAtk2.setDisable(false);
        btnAtk3.setDisable(false);
        btnAtk4.setDisable(false);
    }

    private void disableSwitches() {
        btnSwitch1.setDisable(true);
        btnSwitch2.setDisable(true);
        btnSwitch3.setDisable(true);
        btnSwitch4.setDisable(true);
    }
}