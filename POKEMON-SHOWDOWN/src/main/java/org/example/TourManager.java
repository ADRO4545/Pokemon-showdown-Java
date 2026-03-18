package org.example;

public class TourManager {

    /**
     * Make attack and return true if one of the pokemon is KO
     */
    public static boolean executerAttaques(Pokemon pokemon1, Pokemon pokemon2) {
        playTurn(pokemon1, pokemon2);
        if (isPokemonKO(pokemon1, pokemon2))
            return true;

        playTurn(pokemon2, pokemon1);
        if (isPokemonKO(pokemon1, pokemon2))
            return true;

        return false;
    }

    public static boolean isPokemonKO(Pokemon pokemon1, Pokemon pokemon2) {
        return pokemon1.getHp() <= 0 || pokemon2.getHp() <= 0;
    }

    public static void makeEffectsObjectsAfterAttack(Pokemon attaquant, Pokemon defenseur) {
        if (defenseur.getItem() != null) {
            defenseur.getItem().effectAfterStatus(defenseur);
        }
        if (attaquant.getItem() != null) {
            attaquant.getItem().effectAfterStatus(attaquant);
        }
    }

    public static void applyEndOfTurnItem(Pokemon pokemon) {
        if (pokemon.getItem() != null) {
            double previousHp = pokemon.getHp();
            pokemon.getItem().effectEndTour(pokemon);
            if (pokemon.getHp() > previousHp) {
                System.out.println(pokemon.getName() + " heals using " + pokemon.getItem().getName()
                        + "! HP = " + pokemon.getHp());
            }
        }
    }

    public static void applyEndOfTurnStatus(Pokemon pokemon) {
        if (pokemon.getStatut() != null) {
            double previousHp = pokemon.getHp();
            pokemon.getStatut().applyEndOfTurn(pokemon);
            if (pokemon.getHp() < previousHp) {
                System.out.println(pokemon.getName() + " suffers from "
                        + pokemon.getStatut().getName()
                        + "! HP = " + pokemon.getHp());
            }
        }
    }

    public static void playTurn(Pokemon attacker, Pokemon defender) {
        if (!canPokemonAttack(attacker)) {
            return;
        }

        executeAttack(attacker, defender);
        makeEffectsObjectsAfterAttack(attacker, defender);
        checkKOs(attacker, defender);
    }

    private static boolean canPokemonAttack(Pokemon attacker) {
        // check paralysi
        if (attacker.getStatut() != null && !attacker.getStatut().canAttack(attacker)) {
            System.out.println(attacker.getName() + " is paralyzed and cannot attack!");
            return false;
        }
        return true;
    }

    private static void executeAttack(Pokemon attacker, Pokemon defender) {
        // execute attack
        Attack attack = attacker.getListAttacks().get(0); // first attack, to be changed later
        System.out.println(attacker.getName() + " uses " + attack.getName() + "!");
        attack.receiveDamage(attacker, defender);
        System.out.println("  HP " + defender.getName() + " = " + defender.getHp());
        System.out.println("  HP " + attacker.getName() + " = " + attacker.getHp());
    }

    private static void checkKOs(Pokemon attacker, Pokemon defender) {
        // check KO
        if (defender.getHp() <= 0) {
            System.out.println(defender.getName() + " is KO!");
        }
        if (attacker.getHp() <= 0) {
            System.out.println(attacker.getName() + " is KO (recoil)!");
        }
    }
}
