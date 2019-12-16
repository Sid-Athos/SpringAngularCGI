-- phpMyAdmin SQL Dump wesh mamene
-- version 4.7.9 yo
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 03 déc. 2018 à 18:23
-- Version du serveur :  5.7.21
-- Version de PHP :  5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `GLANCE`
--
DROP DATABASE IF EXISTS `NetWorks`;
CREATE DATABASE IF NOT EXISTS `NetWorks` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `NetWorks`;


-- --------------------------------------------------------

--
-- Structure de la table `USERS`
--


DROP TABLE IF EXISTS `USERS`;
CREATE TABLE IF NOT EXISTS `USERS` (
  `ID` int(11) NOT NULL UNIQUE AUTO_INCREMENT,
  `pseudo` varchar(45) NOT NULL,
  `mail` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `lastCo` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `regDate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `online` tinyint(1) NOT NULL DEFAULT 1,
  `alive` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

ALTER TABLE `USERS` ADD CONSTRAINT UNIQUE(`pseudo`);
ALTER TABLE `USERS` ADD CONSTRAINT UNIQUE(`mail`);

--
-- Déchargement des données de la table `USERS`
--

INSERT INTO `USERS` (`ID`, `pseudo`, `mail`, `password`) VALUES
(1, 'Athos', 'sa.bennaceur@gmail.com', 'cd98bf0202ef07e38e87f6bd9445e5e7331e2c78'),
(2, 'Sidou', 'sa.benn90@gmail.com', 'cd98bf0202ef07e38e87f6bd9445e5e7331e2c78');


--
-- Structure de la table `ROOMS`
--

DROP TABLE IF EXISTS `POSTS`;
CREATE TABLE IF NOT EXISTS `POSTS` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `content` varchar(50) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT 1,
  `userID` int(11) NOT NULL,
  `postDate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  CONSTRAINT FK_us FOREIGN KEY (`userID`)
  REFERENCES USERS(`ID`)
  ON UPDATE CASCADE
  ON DELETE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `POSTS`
--

INSERT INTO `POSTS` (`name`, `content`,`userID`) VALUES
('NetWorks is here !', 'Bonjour ! Bienvenue sur VOTRE réseau social, NetWorks.',1);

-- --------------------------------------------------------


-- --------------------------------------------------------

-- --------------------------------------------------------

--
-- Structure de la table `LIKES`
--

DROP TABLE IF EXISTS `LIKES`;
CREATE TABLE IF NOT EXISTS `LIKES` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `postID` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT FK_post FOREIGN KEY (`postID`)
  REFERENCES POSTS(`ID`)
  ON UPDATE CASCADE
  ON DELETE RESTRICT,
  CONSTRAINT FK_user FOREIGN KEY (`userID`)
  REFERENCES USERS(`ID`)
  ON UPDATE CASCADE
  ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

-- --------------------------------------------------------

--
-- Structure de la table `MESSAGES`
--

DROP TABLE IF EXISTS `MESSAGES`;
CREATE TABLE IF NOT EXISTS `MESSAGES` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(250) NOT NULL,
  `sentDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  `expeditorID` int(11) NOT NULL,
  `receiverID` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `COMMENTS`;
CREATE TABLE IF NOT EXISTS `COMMENTS` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `content` mediumtext NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT 1,
  `postDate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `userID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT FK_u FOREIGN KEY (`userID`)
  REFERENCES USERS(`ID`)
  ON UPDATE CASCADE
  ON DELETE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `COMMENT_BY`;
CREATE TABLE IF NOT EXISTS `COMMENT_BY` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `commentID` int(11) NOT NULL,
  `postID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT FK_comm FOREIGN KEY (`commentID`)
  REFERENCES COMMENTS(`ID`)
  ON UPDATE CASCADE
  ON DELETE RESTRICT,
  CONSTRAINT FK_pos FOREIGN KEY (`postID`)
  REFERENCES POSTS(`ID`)
  ON UPDATE CASCADE
  ON DELETE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
