-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.6.31-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema springboot_test
--

CREATE DATABASE IF NOT EXISTS springboot_test;
USE springboot_test;

--
-- Definition of table `charge_fixe`
--

DROP TABLE IF EXISTS `charge_fixe`;
CREATE TABLE `charge_fixe` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NOM` varchar(45) NOT NULL,
  `VALEUR` int(10) unsigned NOT NULL,
  `USER_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE,
  KEY `FK_charge_fixe_user` (`USER_ID`),
  CONSTRAINT `FK_charge_fixe_user` FOREIGN KEY (`USER_ID`) REFERENCES `utilisateur` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `charge_fixe`
--

/*!40000 ALTER TABLE `charge_fixe` DISABLE KEYS */;
/*!40000 ALTER TABLE `charge_fixe` ENABLE KEYS */;


--
-- Definition of table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `ROLE_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ROLE_NAME` varchar(45) NOT NULL,
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role`
--

/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`ROLE_ID`,`ROLE_NAME`) VALUES 
 (1,'ROLE_ADMIN'),
 (2,'ROLE_USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;


--
-- Definition of table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `USER_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ROLE_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`USER_ID`,`ROLE_ID`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`ROLE_ID`),
  CONSTRAINT `FK1adslu3s4xgk5eemf54qxm908` FOREIGN KEY (`USER_ID`) REFERENCES `utilisateur` (`USER_ID`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_role`
--

/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`USER_ID`,`ROLE_ID`) VALUES 
 (1,1),
 (4,1),
 (1,2),
 (2,2),
 (4,2),
 (15,2),
 (16,2),
 (17,2),
 (18,2),
 (19,2),
 (20,2),
 (21,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;


--
-- Definition of table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE `utilisateur` (
  `USER_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `LOGIN` varchar(45) NOT NULL,
  `USER_PASSWORD` varchar(145) NOT NULL,
  `USER_ACTIVE` int(10) unsigned NOT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `utilisateur`
--

/*!40000 ALTER TABLE `utilisateur` DISABLE KEYS */;
INSERT INTO `utilisateur` (`USER_ID`,`LOGIN`,`USER_PASSWORD`,`USER_ACTIVE`) VALUES 
 (1,'admin','admin',1),
 (2,'user','user',1),
 (4,'bouzga','123456',0),
 (15,'mountassir','$2a$10$iwQbweskG41epJxxBaC3jOGGwsodFjFg43LOXaCwL.hdGr9hlrW.a',1),
 (16,'ouafae','$2a$10$VOjYMscTvDLiQlMW8IjFPeQQWw46caYq8IEL9vf9WQPk2AtPrdJqa',1),
 (17,'ouafae','$2a$10$m1su9sV3nS7ISbsEo7WkKepaw4..LTfDo1ECin57jRO89fM1ElQo2',1),
 (18,'ouafae','$2a$10$TQvC2BFbMyuF6aID.zV8Req/n1q9YL2/V3HqL0hDyXuSafQcrAwtS',1),
 (19,'mountassir1987','$2a$10$12Hg8/EeZvEhVKbWvJRfa.rSt5ZWkDkH5AsQgaSdT/NnV/Uf7OCI2',1),
 (20,'mountassir1987','$2a$10$vqaiCXyzBSETVf/wNYpgD./iAHimfiiLdi/TQ1wjhQ.PnYFSjDrdm',1),
 (21,'mobz','$2a$10$8asNvoOj0nx5dU4Yh7Ud3eTTmPhZ5yhi/yfq3T.EtYQ2unZ.ywgOy',1);
/*!40000 ALTER TABLE `utilisateur` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
