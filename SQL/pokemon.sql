-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : dim. 15 mars 2026 à 21:41
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
-- Structure de la table `pokemon`
--

CREATE TABLE `pokemon` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `hp` double NOT NULL,
  `maxHp` double NOT NULL,
  `speed` int(11) NOT NULL,
  `specialAttack` int(11) NOT NULL,
  `classicAttack` int(11) NOT NULL,
  `specialDefense` int(11) NOT NULL,
  `classicDefense` int(11) NOT NULL,
  `type` varchar(30) NOT NULL,
  `type2` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `pokemon`
--

INSERT INTO `pokemon` (`id`, `name`, `hp`, `maxHp`, `speed`, `specialAttack`, `classicAttack`, `specialDefense`, `classicDefense`, `type`, `type2`) VALUES
(1, 'Pikachu', 35, 35, 90, 50, 55, 50, 40, 'Electric', NULL),
(2, 'Dracaufeu', 78, 78, 100, 109, 84, 85, 78, 'Fire', 'Flying'),
(3, 'Tortank', 79, 79, 78, 85, 83, 105, 100, 'Water', NULL),
(4, 'Florizarre', 80, 80, 80, 100, 82, 100, 83, 'Grass', 'Poison'),
(5, 'Ectoplasma', 60, 60, 110, 130, 65, 75, 60, 'Ghost', 'Poison'),
(6, 'Ronflex', 160, 160, 30, 65, 110, 110, 65, 'Normal', NULL),
(7, 'Dracolosse', 91, 91, 80, 100, 134, 100, 95, 'Dragon', 'Flying'),
(8, 'Lucario', 70, 70, 90, 115, 110, 70, 70, 'Fighting', 'Steel'),
(9, 'Carchacrok', 108, 108, 102, 80, 130, 85, 95, 'Ground', 'Ground'),
(10, 'Nymphali', 95, 95, 60, 110, 65, 130, 65, 'Fairy', NULL);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `pokemon`
--
ALTER TABLE `pokemon`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `pokemon`
--
ALTER TABLE `pokemon`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
