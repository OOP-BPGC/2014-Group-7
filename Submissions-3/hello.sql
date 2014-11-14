-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 14, 2014 at 01:49 PM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `hello`
--
CREATE DATABASE IF NOT EXISTS `hello` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `hello`;

-- --------------------------------------------------------

--
-- Table structure for table `empleave_pending`
--

CREATE TABLE IF NOT EXISTS `empleave_pending` (
  `leave_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_id` varchar(12) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  PRIMARY KEY (`leave_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

--
-- Dumping data for table `empleave_pending`
--

INSERT INTO `empleave_pending` (`leave_id`, `emp_id`, `start_date`, `end_date`) VALUES
(14, '2244', '2014-11-17', '2014-11-22');

-- --------------------------------------------------------

--
-- Table structure for table `empleave_records`
--

CREATE TABLE IF NOT EXISTS `empleave_records` (
  `serialno` int(11) NOT NULL AUTO_INCREMENT,
  `leave_id` int(11) NOT NULL,
  `emp_id` varchar(12) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`serialno`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `empleave_records`
--

INSERT INTO `empleave_records` (`serialno`, `leave_id`, `emp_id`, `start_date`, `end_date`, `status`) VALUES
(1, 3, '1133', '2014-11-15', '2014-11-18', 1),
(2, 13, '2244', '2014-11-22', '2014-11-26', 0),
(3, 15, '6754', '2014-11-22', '2014-11-28', 0),
(4, 16, '6754', '2014-11-26', '2014-11-28', 1),
(5, 17, '5623', '2014-11-15', '2014-11-18', 0);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `emp_id` varchar(12) NOT NULL,
  `name` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `designation` varchar(30) NOT NULL,
  `address` varchar(50) NOT NULL,
  `mobileno` varchar(10) NOT NULL,
  `leave_applied` int(11) DEFAULT '0',
  `recent_leave_id` int(11) DEFAULT '0',
  `email` varchar(40) NOT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`emp_id`, `name`, `password`, `designation`, `address`, `mobileno`, `leave_applied`, `recent_leave_id`, `email`) VALUES
('1133', 'eerr', 'aadd', 'clerk', 'sfgg34fd 43-2', '1245879211', 0, 3, 'eerr@gmail.com'),
('2244', 'gghh', 'qqqq', 'clerk', 'fdfg-3234', '3344112255', 1, 14, 'gghh@gmail.com'),
('5623', 'ttyy', 'www', 'clerk', 'efdg-4354', '2233009911', 0, 17, ''),
('6754', 'tqq', 'qqee', 'waiter', 'fdgg-343 dfg', '5566223344', 0, 16, '');

-- --------------------------------------------------------

--
-- Table structure for table `guest`
--

CREATE TABLE IF NOT EXISTS `guest` (
  `guest_id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `meal` varchar(12) NOT NULL,
  `charge` int(11) NOT NULL,
  PRIMARY KEY (`guest_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `guest`
--

INSERT INTO `guest` (`guest_id`, `date`, `meal`, `charge`) VALUES
(1, '2014-11-14', 'dinner', 35),
(2, '2014-11-14', 'dinner', 35),
(3, '2014-11-14', 'dinner', 35),
(4, '2014-11-14', 'dinner', 35);

-- --------------------------------------------------------

--
-- Table structure for table `manager`
--

CREATE TABLE IF NOT EXISTS `manager` (
  `id` int(11) NOT NULL,
  `name` varchar(12) NOT NULL,
  `password` varchar(12) NOT NULL,
  `mobile` varchar(12) NOT NULL,
  `address` varchar(20) NOT NULL,
  `email` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `manager`
--

INSERT INTO `manager` (`id`, `name`, `password`, `mobile`, `address`, `email`) VALUES
(111, 'hey', 'wer', '6677998321', 'dfsf-3qrf dfsv ', 'messmanager@goa.bits-pilani.ac.in');

-- --------------------------------------------------------

--
-- Table structure for table `onleave`
--

CREATE TABLE IF NOT EXISTS `onleave` (
  `leave_id` int(10) NOT NULL AUTO_INCREMENT,
  `id` varchar(12) NOT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  PRIMARY KEY (`leave_id`),
  KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=33 ;

--
-- Dumping data for table `onleave`
--

INSERT INTO `onleave` (`leave_id`, `id`, `start_date`, `end_date`) VALUES
(9, '3535', '2014-11-11', '2014-11-16');

-- --------------------------------------------------------

--
-- Table structure for table `rates`
--

CREATE TABLE IF NOT EXISTS `rates` (
  `meal` varchar(12) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`meal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rates`
--

INSERT INTO `rates` (`meal`, `price`) VALUES
('breakfast', 25),
('dinner', 35),
('lunch', 30);

-- --------------------------------------------------------

--
-- Table structure for table `test`
--

CREATE TABLE IF NOT EXISTS `test` (
  `name` text NOT NULL,
  `id` varchar(12) NOT NULL,
  `active` int(1) NOT NULL,
  `flag` int(1) NOT NULL,
  `bill` int(11) NOT NULL,
  `serial` int(1) NOT NULL,
  `pwd` varchar(200) DEFAULT NULL,
  `mobileno` varchar(10) DEFAULT NULL,
  `address` varchar(60) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FULLTEXT KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `test`
--

INSERT INTO `test` (`name`, `id`, `active`, `flag`, `bill`, `serial`, `pwd`, `mobileno`, `address`, `email`) VALUES
('user001', '0001', 1, 1, 0, 9, 'kkkk', '8888888888', 'mumbai', 'user001@gmail.com'),
('user002', '0002', 1, 1, 0, 10, 'ffff', '6666666666', 'delhi', 'user002@gmail.com'),
('vikrant', '2011', 1, 1, 0, 1, 'Abcd123!', '2222444468', 'A-23 Sector 21 Noida', 'f2011111@goa.bits-pilani.ac.in'),
('Yash', '2012', 1, 1, 0, 3, 'qwer', '0123456789', 'C-45 Sector 25 Noida', 'f2012318@goa.bits-pilani.ac.in'),
('swapnil', '3333', 1, 1, 0, 4, 'llll', '1234567890', 'D-47, Sector 27 Noida', 'f2012115@goa.bits-pilani.ac.in'),
('user457', '3535', 0, 1, 100, 2, 'pqrs', '7822334455', 'B-34 Sector 23 Noida', 'user457@gmail.com'),
('abhishek', '5555', 1, 1, 0, 5, 'aaaa', '3456789012', 'F-63, Sector 31 Noida', 'f2012aaa@goa.bits-pilani.ac.in'),
('bhaargav', '6666', 1, 1, 0, 6, 'bbbb', '4567890123', 'G-41, Sector 33 Noida', 'f2013bbb@goa.bits-pilani.ac.in'),
('sanath', '7777', 1, 1, 0, 7, 'ssss', '5678901234', 'H-52, Sector 35 Noida', 'f2012sss@goa.bits-pilani.ac.in'),
('madhumita', '8888', 1, 1, 0, 8, 'mmmm', '6789012345', 'H2, Sector 20 Noida', 'f2013mmm@goa.bits-pilani.ac.in');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `onleave`
--
ALTER TABLE `onleave`
  ADD CONSTRAINT `onleave_ibfk_1` FOREIGN KEY (`id`) REFERENCES `test` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
