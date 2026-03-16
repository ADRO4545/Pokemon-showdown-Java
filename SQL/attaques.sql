-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : dim. 15 mars 2026 à 21:40
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `pokemon_db`
--

-- --------------------------------------------------------

--
-- Structure de la table `attaques`
--

CREATE TABLE `attaques` (
  `name_pokemon` varchar(10) DEFAULT NULL,
  `name_attack` varchar(15) DEFAULT NULL,
  `power` int(3) DEFAULT NULL,
  `category` varchar(8) DEFAULT NULL,
  `type` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `attaques`
--

INSERT INTO `attaques` (`name_pokemon`, `name_attack`, `power`, `category`, `type`) VALUES
('Pikachu', 'Tonnerre', 90, 'speciale', 'Electric'),
('Pikachu', 'Vive-Attaque', 40, 'physique', 'Normal'),
('Pikachu', 'Queue de Fer', 100, 'physique', 'Steel'),
('Pikachu', 'Boule Élek', 60, 'speciale', 'Electric'),
('Dracaufeu', 'Lance-Flammes', 90, 'speciale', 'Fire'),
('Dracaufeu', 'Dracogriffe', 80, 'physique', 'Dragon'),
('Dracaufeu', 'Lame d\'Air', 75, 'speciale', 'Flying'),
('Dracaufeu', 'Poing de Feu', 75, 'physique', 'Fire'),
('Tortank', 'Surf', 90, 'speciale', 'Water'),
('Tortank', 'Hydrocanon', 110, 'speciale', 'Water'),
('Tortank', 'Morsure', 60, 'physique', 'Dark'),
('Tortank', 'Laser Glace', 90, 'speciale', 'Ice'),
('Florizarre', 'Lance-Soleil', 120, 'speciale', 'Grass'),
('Florizarre', 'Bombe Beurk', 90, 'speciale', 'Poison'),
('Florizarre', 'Giga-Sangsue', 75, 'speciale', 'Grass'),
('Florizarre', 'Séisme', 100, 'physique', 'Ground'),
('Ectoplasma', 'Ball\'Ombre', 80, 'speciale', 'Ghost'),
('Ectoplasma', 'Cradovague', 95, 'speciale', 'Poison'),
('Ectoplasma', 'Vibrobscur', 80, 'speciale', 'Dark'),
('Ectoplasma', 'Coup Bas', 70, 'physique', 'Dark'),
('Ronflex', 'Damoclès', 120, 'physique', 'Normal'),
('Ronflex', 'Séisme', 100, 'physique', 'Ground'),
('Ronflex', 'Mâchouille', 80, 'physique', 'Dark'),
('Ronflex', 'Tacle Lourd', 80, 'physique', 'Steel'),
('Dracolosse', 'Colère', 120, 'physique', 'Dragon'),
('Dracolosse', 'Vent Violent', 110, 'speciale', 'Flying'),
('Dracolosse', 'Poing Éclair', 75, 'physique', 'Electric'),
('Dracolosse', 'Hydroqueue', 90, 'physique', 'Water'),
('Lucario', 'Aurasphère', 80, 'speciale', 'Fighting'),
('Lucario', 'Close Combat', 120, 'physique', 'Fighting'),
('Lucario', 'Luminocanon', 80, 'speciale', 'Steel'),
('Lucario', 'Charge Os', 25, 'physique', 'Ground'),
('Carchacrok', 'Séisme', 100, 'physique', 'Ground'),
('Carchacrok', 'Dracocharge', 100, 'physique', 'Dragon'),
('Carchacrok', 'Mâchouille', 80, 'physique', 'Dark'),
('Carchacrok', 'Crocs Feu', 65, 'physique', 'Fire'),
('Nymphali', 'Pouvoir Lunaire', 95, 'speciale', 'Fairy'),
('Nymphali', 'Éclat Magique', 80, 'speciale', 'Fairy'),
('Nymphali', 'Météores', 60, 'speciale', 'Normal'),
('Nymphali', 'Choc Psy', 80, 'speciale', 'Psychic');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
