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
('Pikachu', 'Fatal-Foudre', 110, 'speciale', 'Electric'),
('Pikachu', 'Casse-Brique', 75, 'physique', 'Fighting'),
('Pikachu', 'Étincelle', 65, 'physique', 'Electric'),
('Pikachu', 'Câlinerie', 90, 'physique', 'Fairy'),
('Pikachu', 'Frotte-Frimousse', 20, 'physique', 'Electric'),

('Dracaufeu', 'Lance-Flammes', 90, 'speciale', 'Fire'),
('Dracaufeu', 'Dracogriffe', 80, 'physique', 'Dragon'),
('Dracaufeu', 'Lame d air', 75, 'speciale', 'Flying'),
('Dracaufeu', 'Poing de Feu', 75, 'physique', 'Fire'),
('Dracaufeu', 'Boutefeu', 120, 'physique', 'Fire'),
('Dracaufeu', 'Déflagration', 110, 'speciale', 'Fire'),
('Dracaufeu', 'Séisme', 100, 'physique', 'Ground'),
('Dracaufeu', 'Crocs Feu', 65, 'physique', 'Fire'),
('Dracaufeu', 'Lame de Roc', 100, 'physique', 'Rock'),

('Tortank', 'Surf', 90, 'speciale', 'Water'),
('Tortank', 'Hydrocanon', 110, 'speciale', 'Water'),
('Tortank', 'Morsure', 60, 'physique', 'Dark'),
('Tortank', 'Laser Glace', 90, 'speciale', 'Ice'),
('Tortank', 'Cascade', 80, 'physique', 'Water'),
('Tortank', 'Luminocanon', 80, 'speciale', 'Steel'),
('Tortank', 'Aurasphère', 80, 'speciale', 'Fighting'),
('Tortank', 'Tour Rapide', 50, 'physique', 'Normal'),
('Tortank', 'Blizzard', 110, 'speciale', 'Ice'),

('Florizarre', 'Lance-Soleil', 120, 'speciale', 'Grass'),
('Florizarre', 'Bombe Beurk', 90, 'speciale', 'Poison'),
('Florizarre', 'Giga-Sangsue', 75, 'speciale', 'Grass'),
('Florizarre', 'Séisme', 100, 'physique', 'Ground'),
('Florizarre', 'Tempête Verte', 130, 'speciale', 'Grass'),
('Florizarre', 'Tranche Herbe', 55, 'physique', 'Grass'),
('Florizarre', 'Telluriforce', 90, 'speciale', 'Ground'),
('Florizarre', 'Plaquage', 85, 'physique', 'Normal'),
('Florizarre', 'Cradovague', 95, 'speciale', 'Poison'),

('Ectoplasma', 'Ball Ombre', 80, 'speciale', 'Ghost'),
('Ectoplasma', 'Cradovague', 95, 'speciale', 'Poison'),
('Ectoplasma', 'Vibrobscur', 80, 'speciale', 'Dark'),
('Ectoplasma', 'Coup Bas', 70, 'physique', 'Dark'),
('Ectoplasma', 'Châtiment', 65, 'speciale', 'Ghost'),
('Ectoplasma', 'Exploforce', 120, 'speciale', 'Fighting'),
('Ectoplasma', 'Éclat Magique', 80, 'speciale', 'Fairy'),
('Ectoplasma', 'Tonnerre', 90, 'speciale', 'Electric'),
('Ectoplasma', 'Poing Ombre', 60, 'physique', 'Ghost'),

('Ronflex', 'Damoclès', 120, 'physique', 'Normal'),
('Ronflex', 'Séisme', 100, 'physique', 'Ground'),
('Ronflex', 'Mâchouille', 80, 'physique', 'Dark'),
('Ronflex', 'Tacle Lourd', 80, 'physique', 'Steel'),
('Ronflex', 'Plaquage', 85, 'physique', 'Normal'),
('Ronflex', 'Poing Glace', 75, 'physique', 'Ice'),
('Ronflex', 'PsykoudBoul', 80, 'physique', 'Psychic'),
('Ronflex', 'Surpuissance', 120, 'physique', 'Fighting'),
('Ronflex', 'Tête de Fer', 80, 'physique', 'Steel'),

('Dracolosse', 'Colère', 120, 'physique', 'Dragon'),
('Dracolosse', 'Vent Violent', 110, 'speciale', 'Flying'),
('Dracolosse', 'Poing Éclair', 75, 'physique', 'Electric'),
('Dracolosse', 'Hydroqueue', 90, 'physique', 'Water'),
('Dracolosse', 'Dracogriffe', 80, 'physique', 'Dragon'),
('Dracolosse', 'Vitesse Extrême', 80, 'physique', 'Normal'),
('Dracolosse', 'Séisme', 100, 'physique', 'Ground'),
('Dracolosse', 'Poing de Feu', 75, 'physique', 'Fire'),
('Dracolosse', 'Cascade', 80, 'physique', 'Water'),

('Lucario', 'Aurasphère', 80, 'speciale', 'Fighting'),
('Lucario', 'Close Combat', 120, 'physique', 'Fighting'),
('Lucario', 'Luminocanon', 80, 'speciale', 'Steel'),
('Lucario', 'Charge Os', 25, 'physique', 'Ground'),
('Lucario', 'Pisto-Poing', 40, 'physique', 'Steel'),
('Lucario', 'Vitesse Extrême', 80, 'physique', 'Normal'),
('Lucario', 'Casse-Brique', 75, 'physique', 'Fighting'),
('Lucario', 'Météores', 60, 'speciale', 'Normal'),
('Lucario', 'Dracochoc', 85, 'speciale', 'Dragon'),

('Carchacrok', 'Séisme', 100, 'physique', 'Ground'),
('Carchacrok', 'Dracocharge', 100, 'physique', 'Dragon'),
('Carchacrok', 'Mâchouille', 80, 'physique', 'Dark'),
('Carchacrok', 'Crocs Feu', 65, 'physique', 'Fire'),
('Carchacrok', 'Colère', 120, 'physique', 'Dragon'),
('Carchacrok', 'Telluriforce', 90, 'speciale', 'Ground'),
('Carchacrok', 'Lame de Roc', 100, 'physique', 'Rock'),
('Carchacrok', 'Éboulement', 75, 'physique', 'Rock'),
('Carchacrok', 'Griffe Acier', 50, 'physique', 'Steel'),

('Nymphali', 'Pouvoir Lunaire', 95, 'speciale', 'Fairy'),
('Nymphali', 'Éclat Magique', 80, 'speciale', 'Fairy'),
('Nymphali', 'Météores', 60, 'speciale', 'Normal'),
('Nymphali', 'Choc Psy', 80, 'speciale', 'Psychic');
('Nymphali', 'Voix Enjôleuse', 40, 'speciale', 'Fairy'),
('Nymphali', 'Mégaphone', 90, 'speciale', 'Normal'),
('Nymphali', 'Ball Ombre', 80, 'speciale', 'Ghost'),
('Nymphali', 'Feu Mystique', 75, 'speciale', 'Fire'),
('Nymphali', 'Morsure', 60, 'physique', 'Dark');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
