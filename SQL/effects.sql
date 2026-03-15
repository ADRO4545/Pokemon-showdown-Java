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
-- Structure de la table `effects`
--

CREATE TABLE `effects` (
  `name_attack` varchar(50) NOT NULL,
  `influenced_variable` varchar(50) NOT NULL,
  `coefficient` decimal(10,2) NOT NULL,
  `probability` int(11) NOT NULL,
  `valeur_statut` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `effects`
--

INSERT INTO `effects` (`name_attack`, `influenced_variable`, `coefficient`, `probability`, `valeur_statut`) VALUES
('Damoclès', 'hpdamageattacker', 0.33, 100, 'NONE'),
('Giga-Sangsue', 'hpwinattacker', 0.50, 100, 'NONE'),
('Lance-Flammes', 'status', 0.00, 10, 'BURNED'),
('Mâchouille', 'classicDefense', 0.20, 20, 'NONE');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `effects`
--
ALTER TABLE `effects`
  ADD PRIMARY KEY (`name_attack`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
