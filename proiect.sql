-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 23, 2023 at 03:10 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `proiect`
--

-- --------------------------------------------------------

--
-- Table structure for table `arma`
--

CREATE TABLE `arma` (
  `valoare` int(5) NOT NULL,
  `daune` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `arma`
--

INSERT INTO `arma` (`valoare`, `daune`) VALUES
(1, 10);

-- --------------------------------------------------------

--
-- Table structure for table `armura`
--

CREATE TABLE `armura` (
  `Valoare` int(5) NOT NULL,
  `Rezistenta` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `armura`
--

INSERT INTO `armura` (`Valoare`, `Rezistenta`) VALUES
(1, 10);

-- --------------------------------------------------------

--
-- Table structure for table `consumabil`
--

CREATE TABLE `consumabil` (
  `valoare` int(5) NOT NULL,
  `puncte` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `consumabil`
--

INSERT INTO `consumabil` (`valoare`, `puncte`) VALUES
(1, 10);

-- --------------------------------------------------------

--
-- Table structure for table `jucator`
--

CREATE TABLE `jucator` (
  `viata` int(5) NOT NULL,
  `daune` int(5) NOT NULL,
  `rezistenta` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `jucator`
--

INSERT INTO `jucator` (`viata`, `daune`, `rezistenta`) VALUES
(5, 3, 3),
(5, 5, 5),
(5, 3, 3),
(0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `schelete`
--

CREATE TABLE `schelete` (
  `viata` int(5) NOT NULL,
  `daune` int(5) NOT NULL,
  `rezistenta` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `schelete`
--

INSERT INTO `schelete` (`viata`, `daune`, `rezistenta`) VALUES
(5, 2, 1),
(5, 2, 1),
(1, 3, 1),
(1, 3, 1),
(1, 50, 1),
(1, 50, 1);

-- --------------------------------------------------------

--
-- Table structure for table `zombi`
--

CREATE TABLE `zombi` (
  `viata` int(5) NOT NULL,
  `daune` int(5) NOT NULL,
  `rezistenta` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `zombi`
--

INSERT INTO `zombi` (`viata`, `daune`, `rezistenta`) VALUES
(5, 1, 2),
(5, 1, 2),
(1, 3, 1),
(1, 3, 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
