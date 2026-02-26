-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 26 fév. 2026 à 15:55
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
-- Base de données : `prets_remboursements`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `nom`, `email`, `telephone`) VALUES
(1, '', '', ''),
(2, '', '', ''),
(3, '', '', ''),
(4, '', '', ''),
(7, '', '', ''),
(9, '', '', ''),
(10, '', '', ''),
(11, '', '', ''),
(12, '', '', ''),
(13, '', '', ''),
(14, '', '', ''),
(15, '', '', ''),
(17, '', '', ''),
(19, '', '', ''),
(20, '', '', ''),
(21, '', '', ''),
(22, '', '', ''),
(23, '', '', ''),
(25, '', '', ''),
(26, '', '', ''),
(27, '', '', ''),
(28, '', '', ''),
(29, '', '', ''),
(30, '', '', ''),
(31, '', '', ''),
(32, '', '', ''),
(33, '', '', ''),
(34, '', '', ''),
(35, '', '', ''),
(36, '', '', ''),
(37, '', '', '');

-- --------------------------------------------------------

--
-- Structure de la table `prets`
--

CREATE TABLE `prets` (
  `id_pret` int(11) NOT NULL,
  `montant_total` int(11) DEFAULT NULL,
  `date_pret` date DEFAULT NULL,
  `duree_mois` int(11) DEFAULT NULL,
  `id_client` int(11) DEFAULT NULL,
  `taux_interet` decimal(7,3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `prets`
--

INSERT INTO `prets` (`id_pret`, `montant_total`, `date_pret`, `duree_mois`, `id_client`, `taux_interet`) VALUES
(1, 10000, '2026-02-21', 12, 1, 0.200),
(2, 10000, '2026-02-21', 12, 1, 0.200),
(4, 10000, '2026-02-21', 12, 1, 0.200),
(5, 10000, '2026-02-21', 12, 1, 0.200),
(6, 10000, '2026-02-21', 12, 1, 0.200),
(7, 10000, '2026-02-21', 12, 1, 0.200),
(8, 10000, '2026-02-21', 12, 1, 0.200),
(9, 10000, '2026-02-21', 12, 1, 0.200),
(10, 10000, '2026-02-21', 12, 1, 0.200),
(11, 10000, '2026-02-21', 12, 1, 0.200),
(12, 10000, '2026-02-21', 12, 1, 0.200),
(13, 10000, '2026-02-21', 12, 1, 0.200),
(14, 10000, '2026-02-21', 12, 1, 0.200),
(15, 10000, '2026-02-21', 12, 1, 0.200),
(16, 10000, '2026-02-21', 12, 1, 0.200),
(17, 10000, '2026-02-21', 12, 1, 0.200),
(18, 10000, '2026-02-21', 12, 1, 0.200),
(19, 10000, '2026-02-21', 12, 1, 0.200),
(20, 10000, '2026-02-21', 12, 1, 0.200),
(21, 10000, '2026-02-21', 12, 1, 0.200),
(22, 10000, '2026-02-21', 12, 1, 0.200),
(23, 10000, '2026-02-21', 12, 1, 0.200),
(24, 10000, '2026-02-21', 12, 1, 0.200),
(25, 10000, '2026-02-21', 12, 1, 0.200),
(26, 10000, '2026-02-21', 12, 1, 0.200),
(27, 10000, '2026-02-21', 12, 1, 0.200),
(28, 10000, '2026-02-21', 12, 1, 0.200),
(29, 10000, '2026-02-21', 12, 1, 0.200),
(30, 10000, '2026-02-21', 12, 1, 0.200),
(31, 10000, '2026-02-21', 12, 1, 0.200),
(32, 10000, '2026-02-21', 12, 1, 0.200),
(33, 10000, '2026-02-21', 12, 1, 0.200),
(34, 10000, '2026-02-21', 12, 1, 0.200),
(35, 10000, '2026-02-21', 12, 1, 0.200),
(36, 10000, '2026-02-21', 12, 1, 0.200),
(37, 10000, '2026-02-21', 12, 1, 0.200),
(38, 10000, '2026-02-21', 12, 1, 0.200),
(39, 10000, '2026-02-21', 12, 1, 0.200),
(40, 10000, '2026-02-21', 12, 1, 0.200),
(41, 10000, '2026-02-21', 12, 1, 0.200),
(42, 10000, '2026-02-21', 12, 1, 0.200),
(43, 10000, '2026-02-21', 12, 1, 0.200),
(44, 10000, '2026-02-21', 12, 1, 0.200),
(45, 10000, '2026-02-21', 12, 1, 0.200),
(46, 10000, '2026-02-21', 12, 1, 0.200),
(47, 10000, '2026-02-21', 12, 1, 0.200),
(48, 10000, '2026-02-21', 12, 1, 0.200),
(49, 10000, '2026-02-21', 12, 1, 0.200),
(50, 10000, '2026-02-21', 12, 1, 0.200),
(51, 10000, '2026-02-21', 12, 1, 0.200),
(52, 10000, '2026-02-21', 12, 1, 0.200),
(53, 10000, '2026-02-21', 12, 1, 0.200),
(54, 10000, '2026-02-21', 12, 1, 0.200),
(55, 10000, '2026-02-21', 12, 1, 0.200),
(56, 10000, '2026-02-21', 12, 1, 0.200),
(57, 150000, '2026-02-21', 12, 1, 0.200),
(58, 10000, '2020-01-19', 12, 1, 0.200),
(59, 10000, '2026-02-21', 12, 1, 0.200),
(60, 10000, '2026-02-21', 12, 1, 0.200),
(61, 10000, '2026-02-21', 12, 1, 0.200),
(62, 150000, '2026-02-21', 12, 1, 0.200),
(63, 10000, '2020-01-19', 12, 1, 0.200),
(64, 10000, '2026-02-21', 12, 1, 0.200),
(65, 10000, '2026-02-21', 12, 1, 0.200);

-- --------------------------------------------------------

--
-- Structure de la table `remboursement`
--

CREATE TABLE `remboursement` (
  `id` int(11) NOT NULL,
  `montant` decimal(10,2) DEFAULT NULL,
  `dateRemb` date DEFAULT NULL,
  `pretId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `remboursement`
--

INSERT INTO `remboursement` (`id`, `montant`, `dateRemb`, `pretId`) VALUES
(1, 2000.00, '2023-02-15', 1),
(4, 2500.00, '2023-02-15', 4),
(5, 3000.00, '2023-02-15', 5),
(6, 2000.00, '2023-02-15', 1),
(7, 3700.00, '2023-02-15', 2),
(8, 2500.00, '2023-02-15', 4),
(9, 3000.00, '2023-02-15', 5),
(10, 2000.00, '2023-02-15', 1),
(11, 3700.00, '2023-02-15', 2),
(12, 2500.00, '2023-02-15', 4),
(13, 3000.00, '2023-02-15', 5);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `prets`
--
ALTER TABLE `prets`
  ADD PRIMARY KEY (`id_pret`),
  ADD KEY `client_id` (`id_client`);

--
-- Index pour la table `remboursement`
--
ALTER TABLE `remboursement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `pret_id` (`pretId`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT pour la table `prets`
--
ALTER TABLE `prets`
  MODIFY `id_pret` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=66;

--
-- AUTO_INCREMENT pour la table `remboursement`
--
ALTER TABLE `remboursement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `prets`
--
ALTER TABLE `prets`
  ADD CONSTRAINT `prets_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `client` (`id`);

--
-- Contraintes pour la table `remboursement`
--
ALTER TABLE `remboursement`
  ADD CONSTRAINT `remboursement_ibfk_1` FOREIGN KEY (`pretId`) REFERENCES `prets` (`id_pret`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
