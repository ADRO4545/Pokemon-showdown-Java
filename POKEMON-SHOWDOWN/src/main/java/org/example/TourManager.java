package org.example;

public class TourManager {

    public static boolean isPokemonKO(Pokemon pokemon1, Pokemon pokemon2) {
        return pokemon1.getHp() <= 0 || pokemon2.getHp() <= 0;
    }

    public static String applyEndOfTurnItem(Pokemon pokemon) {

        return "";
    }


    public static String applyEndOfTurnStatus(Pokemon pokemon) {
        if (pokemon.getStatut() != null) {
            double previousHp = pokemon.getHp();
            pokemon.getStatut().applyEndOfTurn(pokemon);
            if (pokemon.getHp() < previousHp) {
                return pokemon.getName() + " suffers from " + pokemon.getStatut().getName() + "!\n";
            }
        }
        return "";
    }

    public static String playTurn(Pokemon attacker, Pokemon defender, Attack chosenAttack) {
        StringBuilder log = new StringBuilder();

        if (!canPokemonAttack(attacker, log)) return log.toString();

        executeAttack(attacker, defender, chosenAttack, log);



        checkKOs(attacker, defender, log);

        return log.toString();
    }

    private static boolean canPokemonAttack(Pokemon attacker, StringBuilder log) {
        if (attacker.getStatut() != null && !attacker.getStatut().canAttack(attacker)) {

            log.append(attacker.getName()).append(" is paralyzed and cannot attack!\n");
            return false;
        }
        return true;
    }

    private static void executeAttack(Pokemon attacker, Pokemon defender, Attack chosenAttack, StringBuilder log) {

        log.append(attacker.getName()).append(" uses ").append(chosenAttack.getName()).append("!\n");

        chosenAttack.receiveDamage(attacker, defender);


    }

    private static void checkKOs(Pokemon attacker, Pokemon defender, StringBuilder log) {

        if (defender.getHp() <= 0) {
            log.append(defender.getName()).append(" is KO!\n");
        }
        if (attacker.getHp() <= 0) {
            log.append(attacker.getName()).append(" is KO (recoil)!\n");
        }
    }
}