package org.example;

import org.example.status.Brulure;
import org.example.status.Paralysie;
import org.example.status.Poison;
import org.example.status.Statut;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        // ============================================================
        //  CODE EXISTANT — Chargement depuis la BDD
        // ============================================================

        // status
        HashMap<String, Status> allStatus = Controller.findAllStatut();

        // types and coefficient efficacity
        HashMap<String, Type> allTypes = Controller.findAllCoefType();

        // Pokemon charge from bdd
        HashMap<String, Pokemon> allPokemon = Controller.findAllPokemon(allTypes, allStatus);

        // 4. Charger les attaques et les associer aux pokémon
        HashMap<String, Attack> allAttacks = Controller.findAllAttacks(allTypes, allPokemon, allStatus);

        // Retrieve 2 Specific Pokemon
        Pokemon pokemon1 = allPokemon.get("Pikachu");
        Pokemon pokemon2 = allPokemon.get("Dracaufeu");

        System.out.println("\n=== Premier Pokémon ===");
        if (pokemon1 != null) {
            System.out.println(pokemon1);
            System.out.println("  Attaques : ");
            for (Attack a : pokemon1.getListAttacks()) {
                System.out.println("    - " + a);
            }
        } else {
            System.out.println("Pikachu non trouvé dans la base de données.");
        }

        System.out.println("\n=== Deuxième Pokémon ===");
        if (pokemon2 != null) {
            System.out.println(pokemon2);
            System.out.println("  Attaques : ");
            for (Attack a : pokemon2.getListAttacks()) {
                System.out.println("    - " + a);
            }
        } else {
            System.out.println("Dracaufeu non trouvé dans la base de données.");
        }

        // ============================================================
        //  TESTS DE TOUTES LES FONCTIONNALITÉS (sans BDD)
        // ============================================================

        System.out.println("\n\n");
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║   TESTS DE TOUTES LES FONCTIONNALITÉS           ║");
        System.out.println("╚══════════════════════════════════════════════════╝");

        // -----------------------------------------------------------
        // 1. TEST : Création de Types et coefficients d'efficacité
        // -----------------------------------------------------------
        System.out.println("\n========== 1. TEST TYPE & EFFICACITÉ ==========");

        Type typeFeu = new Type("Feu");
        Type typeEau = new Type("Eau");
        Type typeElectrik = new Type("Electrik");
        Type typePlante = new Type("Plante");

        // Feu -> Eau = 0.5 (pas efficace), Feu -> Plante = 2.0 (super efficace)
        typeFeu.addEfficiency("Feu", 1.0);
        typeFeu.addEfficiency("Eau", 0.5);
        typeFeu.addEfficiency("Electrik", 1.0);
        typeFeu.addEfficiency("Plante", 2.0);

        // Eau -> Feu = 2.0, Eau -> Plante = 0.5
        typeEau.addEfficiency("Feu", 2.0);
        typeEau.addEfficiency("Eau", 1.0);
        typeEau.addEfficiency("Electrik", 1.0);
        typeEau.addEfficiency("Plante", 0.5);

        // Electrik -> Eau = 2.0, Electrik -> Plante = 0.5
        typeElectrik.addEfficiency("Feu", 1.0);
        typeElectrik.addEfficiency("Eau", 2.0);
        typeElectrik.addEfficiency("Electrik", 1.0);
        typeElectrik.addEfficiency("Plante", 0.5);

        // Plante -> Eau = 2.0, Plante -> Feu = 0.5
        typePlante.addEfficiency("Feu", 0.5);
        typePlante.addEfficiency("Eau", 2.0);
        typePlante.addEfficiency("Electrik", 1.0);
        typePlante.addEfficiency("Plante", 1.0);

        System.out.println("Type Feu créé : " + typeFeu.getName());
        System.out.println("Type Eau créé : " + typeEau.getName());
        System.out.println("Type Electrik créé : " + typeElectrik.getName());
        System.out.println("Type Plante créé : " + typePlante.getName());

        System.out.println("Coef Feu -> Eau   = " + typeFeu.getCoef(typeEau) + " (attendu 0.5)");
        System.out.println("Coef Feu -> Plante= " + typeFeu.getCoef(typePlante) + " (attendu 2.0)");
        System.out.println("Coef Eau -> Feu   = " + typeEau.getCoef(typeFeu) + " (attendu 2.0)");
        System.out.println("Coef Electrik->Eau= " + typeElectrik.getCoef(typeEau) + " (attendu 2.0)");

        // -----------------------------------------------------------
        // 2. TEST : Création de Status
        // -----------------------------------------------------------
        System.out.println("\n========== 2. TEST STATUS ==========");

        Status statusNone = new Status("NONE", 0, 1.0, 1.0);
        Status statusBurned = new Status("BURNED", 0.0625, 0.5, 1.0);
        Status statusParalyzed = new Status("PARALYZED", 0, 1.0, 0.5);
        Status statusPoisoned = new Status("POISONED", 0.125, 1.0, 1.0);

        System.out.println("Status NONE       : coefDamage=" + statusNone.getCoefDamage()
                + ", coefAttack=" + statusNone.getCoefclassicAttack()
                + ", coefSpeed=" + statusNone.getCoefSpeed());
        System.out.println("Status BURNED     : coefDamage=" + statusBurned.getCoefDamage()
                + ", coefAttack=" + statusBurned.getCoefclassicAttack()
                + ", coefSpeed=" + statusBurned.getCoefSpeed());
        System.out.println("Status PARALYZED  : coefDamage=" + statusParalyzed.getCoefDamage()
                + ", coefAttack=" + statusParalyzed.getCoefclassicAttack()
                + ", coefSpeed=" + statusParalyzed.getCoefSpeed());
        System.out.println("Status POISONED   : coefDamage=" + statusPoisoned.getCoefDamage()
                + ", coefAttack=" + statusPoisoned.getCoefclassicAttack()
                + ", coefSpeed=" + statusPoisoned.getCoefSpeed());

        // -----------------------------------------------------------
        // 3. TEST : Création de Pokémon (avec 1 type et avec 2 types)
        // -----------------------------------------------------------
        System.out.println("\n========== 3. TEST POKÉMON ==========");

        // Pokémon avec 1 type
        Pokemon pikachu = new Pokemon("Pikachu", 180, 180, 110,
                60, 70, 50, 50, 40, 40, typeElectrik, statusNone);

        // Pokémon avec 2 types
        Pokemon dracaufeu = new Pokemon("Dracaufeu", 266, 266, 100,
                129, 104, 105, 105, 98, 98, typeFeu, null, statusNone);

        Pokemon tortank = new Pokemon("Tortank", 268, 268, 78,
                105, 103, 120, 120, 105, 105, typeEau, statusNone);

        Pokemon florizarre = new Pokemon("Florizarre", 270, 270, 80,
                122, 100, 120, 120, 100, 100, typePlante, statusNone);

        System.out.println(pikachu);
        System.out.println(dracaufeu);
        System.out.println(tortank);
        System.out.println(florizarre);

        System.out.println("\nHP Pikachu     : " + pikachu.getHp() + "/" + pikachu.getMaxHp());
        System.out.println("Speed Pikachu  : " + pikachu.getSpeed());
        System.out.println("Type Pikachu   : " + pikachu.getType().getName());
        System.out.println("Type2 Dracaufeu: " + (dracaufeu.getType2() != null ? "aucun (null)" : "aucun"));

        // -----------------------------------------------------------
        // 4. TEST : Création d'attaques (tous les types d'attaques)
        // -----------------------------------------------------------
        System.out.println("\n========== 4. TEST ATTAQUES ==========");

        // Attaque basique
        Attack tonnerre = new Attack("Tonnerre", 90, "speciale", typeElectrik);
        Attack lanceFlamme = new Attack("Lance-Flamme", 90, "speciale", typeFeu);
        Attack surfAttack = new Attack("Surf", 90, "speciale", typeEau);
        Attack charge = new Attack("Charge", 40, "physique", typePlante);

        System.out.println("Attaque basique      : " + tonnerre);
        System.out.println("Attaque basique      : " + lanceFlamme);
        System.out.println("Attaque basique      : " + surfAttack);
        System.out.println("Attaque basique      : " + charge);

        // HpWinAttacker (l'attaquant regagne des HP)
        HpWinAttacker giga = new HpWinAttacker("Giga-Sangsue", 75, "speciale",
                typePlante, 100, 0.5);
        System.out.println("HpWinAttacker        : " + giga);

        // HpDamageAttacker (l'attaquant perd des HP - recul)
        HpDamageAttacker damocles = new HpDamageAttacker("Damoclès", 120, "physique",
                typeFeu, 100, 0.33);
        System.out.println("HpDamageAttacker     : " + damocles);

        // StatusChange (peut infliger un statut)
        StatusChange flammeche = new StatusChange("Flammèche", 40, "speciale",
                typeFeu, 100, statusBurned);  // 100% de proba pour le test
        System.out.println("StatusChange         : " + flammeche);

        // classicDefenseInfluence (baisse la défense classique)
        classicDefenseInfluence griffeAcier = new classicDefenseInfluence("Griffe Acier", 50,
                "physique", typeFeu, 100, 0.25);  // 100% de proba pour le test
        System.out.println("classicDefenseInfluence: " + griffeAcier);

        // -----------------------------------------------------------
        // 5. TEST : Ajout d'attaques à un Pokémon (max 4)
        // -----------------------------------------------------------
        System.out.println("\n========== 5. TEST AJOUT ATTAQUES AUX POKÉMON ==========");

        pikachu.addListAttacks(tonnerre);
        pikachu.addListAttacks(charge);
        pikachu.addListAttacks(giga);
        pikachu.addListAttacks(damocles);
        // 5ème attaque : ne doit PAS être ajoutée
        pikachu.addListAttacks(surfAttack);

        System.out.println("Attaques de Pikachu (doit en avoir 4 max) :");
        for (Attack a : pikachu.getListAttacks()) {
            System.out.println("  - " + a);
        }
        System.out.println("Nb attaques = " + pikachu.getListAttacks().size() + " (attendu 4)");

        dracaufeu.addListAttacks(lanceFlamme);
        dracaufeu.addListAttacks(flammeche);
        dracaufeu.addListAttacks(griffeAcier);
        dracaufeu.addListAttacks(damocles);

        tortank.addListAttacks(surfAttack);
        tortank.addListAttacks(charge);

        florizarre.addListAttacks(giga);
        florizarre.addListAttacks(charge);

        // -----------------------------------------------------------
        // 6. TEST : Rules — Qui commence ?
        // -----------------------------------------------------------
        System.out.println("\n========== 6. TEST RULES — QUI COMMENCE ? ==========");

        Rules rules = new Rules();
        boolean pikachuBegin = rules.whoBegin(pikachu, dracaufeu);
        System.out.println("Pikachu (speed=" + pikachu.getSpeed()
                + ") vs Dracaufeu (speed=" + dracaufeu.getSpeed() + ")");
        System.out.println("Pikachu commence ? " + pikachuBegin + " (attendu true car 110 > 100)");

        boolean tortankBegin = rules.whoBegin(tortank, pikachu);
        System.out.println("\nTortank (speed=" + tortank.getSpeed()
                + ") vs Pikachu (speed=" + pikachu.getSpeed() + ")");
        System.out.println("Tortank commence ? " + tortankBegin + " (attendu false car 78 < 110)");

        // -----------------------------------------------------------
        // 7. TEST : setupCombatStats (attaque spéciale vs physique)
        // -----------------------------------------------------------
        System.out.println("\n========== 7. TEST setupCombatStats ==========");

        int[] statsSpeciale = tonnerre.setupCombatStats(pikachu, tortank);
        System.out.println("Tonnerre (speciale) : Pikachu attaque Tortank");
        System.out.println("  attackStat = " + statsSpeciale[0] + " (specialAttack Pikachu = 60)");
        System.out.println("  defenseStat= " + statsSpeciale[1] + " (specialDefense Tortank = 120)");

        int[] statsPhysique = charge.setupCombatStats(florizarre, pikachu);
        System.out.println("\nCharge (physique) : Florizarre attaque Pikachu");
        System.out.println("  attackStat = " + statsPhysique[0] + " (classicAttack Florizarre = 100)");
        System.out.println("  defenseStat= " + statsPhysique[1] + " (classicDefense Pikachu = 40)");

        // -----------------------------------------------------------
        // 8. TEST : Calcul de dégâts (Attack.calculateDamage)
        // -----------------------------------------------------------
        System.out.println("\n========== 8. TEST CALCUL DE DÉGÂTS ==========");

        double dmg1 = tonnerre.calculateDamage(pikachu, tortank);
        System.out.println("Tonnerre (Electrik) de Pikachu sur Tortank (Eau) :");
        System.out.println("  Dégâts = " + String.format("%.2f", dmg1)
                + " (super efficace x2.0)");

        double dmg2 = lanceFlamme.calculateDamage(dracaufeu, florizarre);
        System.out.println("\nLance-Flamme (Feu) de Dracaufeu sur Florizarre (Plante) :");
        System.out.println("  Dégâts = " + String.format("%.2f", dmg2)
                + " (super efficace x2.0)");

        double dmg3 = lanceFlamme.calculateDamage(dracaufeu, tortank);
        System.out.println("\nLance-Flamme (Feu) de Dracaufeu sur Tortank (Eau) :");
        System.out.println("  Dégâts = " + String.format("%.2f", dmg3)
                + " (pas efficace x0.5)");

        // -----------------------------------------------------------
        // 9. TEST : receiveDamage (attaque basique)
        // -----------------------------------------------------------
        System.out.println("\n========== 9. TEST receiveDamage (attaque basique) ==========");

        System.out.println("HP Tortank avant : " + String.format("%.2f", tortank.getHp()));
        tonnerre.receiveDamage(pikachu, tortank);
        System.out.println("Pikachu utilise Tonnerre sur Tortank !");
        System.out.println("HP Tortank après : " + String.format("%.2f", tortank.getHp()));

        // -----------------------------------------------------------
        // 10. TEST : HpWinAttacker (Giga-Sangsue — récupération de HP)
        // -----------------------------------------------------------
        System.out.println("\n========== 10. TEST HpWinAttacker (Giga-Sangsue) ==========");

        // D'abord, baisser les HP de Florizarre
        florizarre.setHp(150);
        System.out.println("HP Florizarre avant : " + String.format("%.2f", florizarre.getHp()));
        System.out.println("HP Tortank    avant : " + String.format("%.2f", tortank.getHp()));

        giga.receiveDamage(florizarre, tortank);
        System.out.println("Florizarre utilise Giga-Sangsue sur Tortank !");
        System.out.println("HP Florizarre après : " + String.format("%.2f", florizarre.getHp())
                + " (doit avoir regagné des HP)");
        System.out.println("HP Tortank    après : " + String.format("%.2f", tortank.getHp())
                + " (doit avoir perdu des HP)");

        // -----------------------------------------------------------
        // 11. TEST : HpDamageAttacker (Damoclès — recul)
        // -----------------------------------------------------------
        System.out.println("\n========== 11. TEST HpDamageAttacker (Damoclès) ==========");

        System.out.println("HP Dracaufeu avant : " + String.format("%.2f", dracaufeu.getHp()));
        System.out.println("HP Pikachu   avant : " + String.format("%.2f", pikachu.getHp()));

        damocles.receiveDamage(dracaufeu, pikachu);
        System.out.println("Dracaufeu utilise Damoclès sur Pikachu !");
        System.out.println("HP Dracaufeu après : " + String.format("%.2f", dracaufeu.getHp())
                + " (doit avoir perdu des HP de recul)");
        System.out.println("HP Pikachu   après : " + String.format("%.2f", pikachu.getHp())
                + " (doit avoir perdu des HP)");

        // -----------------------------------------------------------
        // 12. TEST : StatusChange (Flammèche — applique brûlure)
        // -----------------------------------------------------------
        System.out.println("\n========== 12. TEST StatusChange (Flammèche) ==========");

        System.out.println("Status Tortank avant : " + tortank.getStatus().getName());
        flammeche.receiveDamage(dracaufeu, tortank);
        System.out.println("Dracaufeu utilise Flammèche sur Tortank !");
        System.out.println("Status Tortank après : " + tortank.getStatus().getName()
                + " (attendu BURNED avec 100% proba)");

        // -----------------------------------------------------------
        // 13. TEST : classicDefenseInfluence (Griffe Acier)
        // -----------------------------------------------------------
        System.out.println("\n========== 13. TEST classicDefenseInfluence (Griffe Acier) ==========");

        System.out.println("classicDefense Pikachu avant : " + pikachu.getClassicDefense());
        System.out.println("classicDefenseMax Pikachu    : " + pikachu.getClassicDefenseMax());
        griffeAcier.receiveDamage(dracaufeu, pikachu);
        System.out.println("Dracaufeu utilise Griffe Acier sur Pikachu !");
        System.out.println("classicDefense Pikachu après : " + pikachu.getClassicDefense()
                + " (doit avoir baissé de 25% = -" + (int)(pikachu.getClassicDefenseMax() * 0.25) + ")");

        // -----------------------------------------------------------
        // 14. TEST : Statuts (interface Statut — Brulure, Paralysie, Poison)
        // -----------------------------------------------------------
        System.out.println("\n========== 14. TEST STATUTS (Brulure, Paralysie, Poison) ==========");

        // --- Brulure ---
        Brulure brulure = new Brulure();
        Pokemon testBrulure = new Pokemon("TestBrulure", 100, 100, 50,
                50, 50, 50, 50, 50, 50, typeFeu, statusNone);
        testBrulure.setStatut(brulure);

        System.out.println("--- Brûlure ---");
        System.out.println("Nom : " + brulure.getName());
        System.out.println("Peut attaquer ? " + brulure.canAttack(testBrulure) + " (attendu true)");
        System.out.println("HP avant : " + String.format("%.2f", testBrulure.getHp()));
        brulure.applyEndOfTurn(testBrulure);
        System.out.println("HP après fin de tour : " + String.format("%.2f", testBrulure.getHp())
                + " (perd 1/16 = " + String.format("%.2f", 100.0 / 16.0) + ")");
        System.out.println("Modify attack (physique, base=100) : "
                + brulure.modifyAttackPower(100, "physique") + " (attendu 50.0)");
        System.out.println("Modify attack (speciale, base=100) : "
                + brulure.modifyAttackPower(100, "speciale") + " (attendu 100.0)");

        // --- Paralysie ---
        Paralysie paralysie = new Paralysie();
        Pokemon testParalysie = new Pokemon("TestParalysie", 100, 100, 80,
                50, 50, 50, 50, 50, 50, typeElectrik, statusNone);
        testParalysie.setStatut(paralysie);

        System.out.println("\n--- Paralysie ---");
        System.out.println("Nom : " + paralysie.getName());
        System.out.println("Modify speed (base=80) : "
                + paralysie.modifySpeed(80) + " (attendu 40)");
        // Tester canAttack plusieurs fois (75% de chance de pouvoir attaquer)
        int canAttackCount = 0;
        int testRuns = 20;
        for (int i = 0; i < testRuns; i++) {
            if (paralysie.canAttack(testParalysie)) canAttackCount++;
        }
        System.out.println("canAttack sur " + testRuns + " essais : "
                + canAttackCount + " réussis (environ 75% = ~" + (testRuns * 75 / 100) + ")");
        System.out.println("HP avant : " + String.format("%.2f", testParalysie.getHp()));
        paralysie.applyEndOfTurn(testParalysie);
        System.out.println("HP après fin de tour : " + String.format("%.2f", testParalysie.getHp())
                + " (inchangé, la paralysie ne fait pas de dégâts)");

        // --- Poison ---
        Poison poison = new Poison();
        Pokemon testPoison = new Pokemon("TestPoison", 100, 100, 50,
                50, 50, 50, 50, 50, 50, typePlante, statusNone);
        testPoison.setStatut(poison);

        System.out.println("\n--- Poison ---");
        System.out.println("Nom : " + poison.getName());
        System.out.println("Peut attaquer ? " + poison.canAttack(testPoison) + " (attendu true)");
        System.out.println("HP avant : " + String.format("%.2f", testPoison.getHp()));
        poison.applyEndOfTurn(testPoison);
        System.out.println("HP après fin de tour : " + String.format("%.2f", testPoison.getHp())
                + " (perd 1/8 = " + String.format("%.2f", 100.0 / 8.0) + ")");

        // -----------------------------------------------------------
        // 15. TEST : Setters Pokémon
        // -----------------------------------------------------------
        System.out.println("\n========== 15. TEST SETTERS POKÉMON ==========");

        Pokemon testSetters = new Pokemon("TestSetters", 200, 200, 90,
                80, 70, 60, 60, 50, 50, typeFeu, statusNone);

        System.out.println("Avant : " + testSetters);
        testSetters.setName("TestModifié");
        testSetters.setHp(150);
        testSetters.setSpeed(120);
        testSetters.setSpecialAttack(100);
        testSetters.setClassicAttack(110);
        testSetters.setSpecialDefense(80);
        testSetters.setClassicDefense(70);
        testSetters.setType(typeEau);
        testSetters.setType2(typePlante);
        testSetters.setStatus(statusBurned);
        System.out.println("Après : " + testSetters);
        System.out.println("HP     : " + testSetters.getHp() + " (attendu 150.0)");
        System.out.println("Speed  : " + testSetters.getSpeed() + " (attendu 120)");
        System.out.println("Type   : " + testSetters.getType().getName() + " (attendu Eau)");
        System.out.println("Type2  : " + testSetters.getType2().getName() + " (attendu Plante)");
        System.out.println("Status : " + testSetters.getStatus().getName() + " (attendu BURNED)");

        // -----------------------------------------------------------
        // 16. TEST : Simulation d'un mini-combat
        // -----------------------------------------------------------
        System.out.println("\n========== 16. SIMULATION MINI-COMBAT ==========");

        // Réinitialiser les Pokémon
        Pokemon combattant1 = new Pokemon("Pikachu", 180, 180, 110,
                60, 70, 50, 50, 40, 40, typeElectrik, statusNone);
        Pokemon combattant2 = new Pokemon("Tortank", 268, 268, 78,
                105, 103, 120, 120, 105, 105, typeEau, statusNone);

        combattant1.addListAttacks(tonnerre);
        combattant2.addListAttacks(surfAttack);

        System.out.println("--- Début du combat ---");
        System.out.println(combattant1.getName() + " (HP=" + String.format("%.0f", combattant1.getHp())
                + ") VS " + combattant2.getName() + " (HP=" + String.format("%.0f", combattant2.getHp()) + ")");

        boolean p1Begin = rules.whoBegin(combattant1, combattant2);
        System.out.println(p1Begin ? combattant1.getName() + " commence !" : combattant2.getName() + " commence !");

        int tour = 1;
        while (combattant1.getHp() > 0 && combattant2.getHp() > 0 && tour <= 10) {
            System.out.println("\n-- Tour " + tour + " --");

            if (p1Begin) {
                // Pikachu attaque d'abord
                Attack atk1 = combattant1.getListAttacks().get(0);
                atk1.receiveDamage(combattant1, combattant2);
                System.out.println(combattant1.getName() + " utilise " + atk1.getName()
                        + " ! HP " + combattant2.getName() + " = " + String.format("%.2f", combattant2.getHp()));

                if (combattant2.getHp() <= 0) {
                    System.out.println(combattant2.getName() + " est K.O. !");
                    break;
                }

                Attack atk2 = combattant2.getListAttacks().get(0);
                atk2.receiveDamage(combattant2, combattant1);
                System.out.println(combattant2.getName() + " utilise " + atk2.getName()
                        + " ! HP " + combattant1.getName() + " = " + String.format("%.2f", combattant1.getHp()));

                if (combattant1.getHp() <= 0) {
                    System.out.println(combattant1.getName() + " est K.O. !");
                    break;
                }
            } else {
                // Tortank attaque d'abord
                Attack atk2 = combattant2.getListAttacks().get(0);
                atk2.receiveDamage(combattant2, combattant1);
                System.out.println(combattant2.getName() + " utilise " + atk2.getName()
                        + " ! HP " + combattant1.getName() + " = " + String.format("%.2f", combattant1.getHp()));

                if (combattant1.getHp() <= 0) {
                    System.out.println(combattant1.getName() + " est K.O. !");
                    break;
                }

                Attack atk1 = combattant1.getListAttacks().get(0);
                atk1.receiveDamage(combattant1, combattant2);
                System.out.println(combattant1.getName() + " utilise " + atk1.getName()
                        + " ! HP " + combattant2.getName() + " = " + String.format("%.2f", combattant2.getHp()));

                if (combattant2.getHp() <= 0) {
                    System.out.println(combattant2.getName() + " est K.O. !");
                    break;
                }
            }

            tour++;
        }

        if (combattant1.getHp() > 0 && combattant2.getHp() > 0) {
            System.out.println("\n⏱ Fin du combat après 10 tours — pas de K.O.");
        }

        System.out.println("\n--- Résultat ---");
        System.out.println(combattant1.getName() + " HP = " + String.format("%.2f", combattant1.getHp()));
        System.out.println(combattant2.getName() + " HP = " + String.format("%.2f", combattant2.getHp()));

        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║              FIN DES TESTS                       ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
    }
}