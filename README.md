
<div align="center" ><img height="150" width="150" alt="pikachu" src="https://github.com/ADRO4545/Pokemon-showdown-Java/blob/main/POKEMON-SHOWDOWN/src/main/resources/images/pikachu-readme.png" /></div>

# Pokemon Showdown

Ce projet est un simulateur de combat Pokémon au tour par tour développé en Java avec l'interface graphique JavaFX. Réalisé dans le cadre du module de Programmation Orientée Objet de la 1ère année à Coda (2026) , il s'inspire grandement de l'interface de Pokémon Showdown. 

L'objectif principal est de modéliser les mécaniques complexes des combats Pokémon en appliquant rigoureusement les concepts de la Programmation Orientée Objet (POO).Le joueur doit pouvoir constituer une équipe et affronter un adversaire contrôlé par l'ordinateur.

## Fonctionnalités Clés du jeu

### Interface Graphique 
* **Menu d'accueil** : Écran de présentation incluant les crédits et permettant de lancer le jeu.
* **Création d'équipe (Team Builder)** : Interface permettant au joueur de constituer une équipe de 4 Pokémons, de sélectionner leurs attaques, et de leur assigner des objets tenus.
* **Arène de combat** : Interface de combat 1v1 affichant les Pokémon actifs, les barres de vie (HP), les types, et les options d'actions (attaquer ou changer de Pokémon).
* **Historique de combat** : Affichage en temps réel du déroulement du combat, incluant les attaques utilisées, les dégâts, l'efficacité, et les changements de statuts.

### Mécaniques de Jeu
* **Modélisation des Pokémon** : Implémentation d'au moins 10 Pokémon distincts avec leurs statistiques propres (HP, Attaque, Défense, Vitesse, etc.) et une liste d'attaques prédéfinies.
* **Système de Dégâts et Types** : Calcul des dégâts distinguant les attaques physiques et spéciales. Le système prend en compte l'influence des types de Pokemon et d'attaque.
* **Attaques à Effets** : Présence de 4 attaques possédant des effets secondaires.
* **Altérations de Statut** : Implémentation des statuts Paralysie, Poison et Brûlure impactant les statistiques ou les HP à chaque tour.
* **Objets Tenus** : Intégration d'au moins 5 objets tenus offrant des bonus passifs ou des effets déclenchés en combat.

### Fonctionnalités additionnelles
* **Audio & Visuel** : Ajout d'effets sonores et gif lors des combats.
* **Chargement des données** : Initialisation des Pokémon depuis une base de données.
  
## Comment lancer notre jeu ?

### 1. Prérequis
Assurez-vous d'avoir les éléments suivants installés et configurés sur votre ordinateur :
* **[Java JDK 21+](https://adoptium.net/)** (pour compiler et exécuter le code Java).
* **[Maven](https://maven.apache.org/download.cgi)** (pour télécharger les dépendances JavaFX automatiquement).
* Un serveur **MySQL** local (comme [XAMPP](https://www.apachefriends.org/fr/index.html)).

### 2. Cloner le projet
Ouvrez votre terminal et récupérez le code source depuis GitHub, puis placez-vous dans le dossier du projet :
```commande à renseigner dans le terminal
git clone https://github.com/ADRO4545/Pokemon-showdown-Java.git
cd Pokemon-showdown-Java/POKEMON-SHOWDOW
```

### 3. Configurer la Base de Données
Comme le jeu charge les Pokémon, les attaques, les effets et les types depuis une base de données, il faut la préparer :

1. Démarrez votre serveur MySQL (lancez XAMPP).
2. Importez les fichiers SQL fournis avec le projet (`attaques.sql`, `pokemon.sql`, `effects.sql`, `pokemon.sql`) dans votre serveur local.

### 4. Démarrer le jeu
```commande à renseigner dans le terminal
mvn javafx:run
```

## 🛠️ Technologies utilisées

 <table>
   <thead>
      <tr>        
        <th align="center">
          <h3 style="color:#38bdf8;">Frontend</h3>        
        </th>  
        <th align="center">
          <h3 style="color:#38bdf8;">Backend</h3>        
        </th>
        <th align="center">
          <h3 style="color:#38bdf8;">Base de Données</h3>       
        </th>
      </tr>
   </thead>
   <tbody>
        <tr>            
            <td align="center"><img src="https://skillicons.dev/icons?i=javaFX" /></td>
            <td align="center"><img src="https://skillicons.dev/icons?i=java" /></td>            
            <td align="center"><img src="https://skillicons.dev/icons?i=mysql" /></td>            
        </tr>     
    </tbody>
   
  </table> 

  ## 👥 Contributeurs & Projet de Groupe

Ce projet est un projet académique réalisé en équipe de 2 étudiants.  
Il applique les notions vues au cours de nos 3 semaines de cours sur le langage java:

- Programmation Orientée Objet (POO)
- Langage java
- Interface graphique en JavaFx

### Répartition des tâches dans le Groupe

[**Arthur DRUGEAULT**](https://github.com/ADRO4545):
Gestion des Pokemons
Gestion des statuts des Pokemons
Gestion du choix de l'ordre de jeu des pokemons pendant le combat
Interface visuel du choix des pokemons de l'équipe
Interface visuel du choix du pokemon qui débute le combat
Interface visuel du combat
Effets sonores et visuels


[**Pierre SOREAU**](https://github.com/PierreSoreau):  
Gestion des Types des Pokemons
Gestion des Effets des Attaques
Gestion des Objets des Pokemons
Gestion des Pokemons
Interface visuel du choix des pokemons de l'équipe
Interface visuel du combat
Création des bases de données et leur lien avec le jeu


## 🧠 Difficultées rencontrées

La principale difficulté rencontrée lors de ce projet était **l'exigence architecturale**. Notre plus grand défi a été de nous détacher de la pensée procédurale pour concevoir une véritable architecture en **Programmation Orientée Objet (POO)**.

Pour garantir un code propre, évolutif et maintenable, nous nous sommes efforcés d'appliquer strictement les bonnes pratiques :
* **Respect des bonnes pratiques :** Nous avons veillé à appliquer le *Single Responsibility Principle* et le principe *DRY (Don't Repeat Yourself)* pour éviter toute duplication de code.
* **Dynamique et relations entre les classes :** Au lieu d'empiler des fonctions, nous avons dû repenser nos modèles pour exploiter pleinement l'héritage et les interfaces. 

Cela nous a demandé un important travail de conception en amont (et pas mal de refactoring en cours de route, il faut l'avouer!).



  
