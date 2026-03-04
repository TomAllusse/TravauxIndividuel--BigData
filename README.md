# <div align="center">TravauxIndividuel - BigData</div>

# Création de la base de donnée

```bash
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `nexus_erp`
--

CREATE DATABASE nexus_erp;

-- --------------------------------------------------------

--
-- Structure de la table `server_logs`
--

CREATE TABLE `server_logs` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `region` varchar(255) DEFAULT NULL,
  `statut` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `server_logs`
--

INSERT INTO `server_logs` (`id`, `name`, `region`, `statut`) VALUES
(1, 'Paris', 'Europe', 'Online'),
(2, 'Allemagne', 'Europe', 'Online'),
(3, 'Belgique', 'Europe', 'Online'),
(4, 'Lyon', 'Europe', 'Offline'),
(5, 'Canada', NULL, 'Online'),
(6, 'Australie', 'Pacifique', 'Offline'),
(7, 'Japon', 'Asie', 'Offline'),
(8, 'Chine', 'Asie', 'Offline'),
(9, 'Brésil', 'Amérique', 'Online'),
(10, 'Maroc', NULL, 'Offline');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `server_logs`
--
ALTER TABLE `server_logs`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `server_logs`
--
ALTER TABLE `server_logs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

```
