-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3307
-- Generation Time: Apr 04, 2019 at 05:08 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hqvmanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `code` varchar(12) NOT NULL,
  `customers` varchar(25) DEFAULT NULL,
  `status` varchar(6) NOT NULL,
  `payments` varchar(10) NOT NULL,
  `Date` date NOT NULL,
  `orderName` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL,
  `priceEach` double NOT NULL,
  `amount` double NOT NULL,
  `surchange` int(12) DEFAULT NULL,
  `Cost` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`code`, `customers`, `status`, `payments`, `Date`, `orderName`, `type`, `priceEach`, `amount`, `surchange`, `Cost`) VALUES
('CUR00001', 'Dinh The Hiep', 'Sell', 'Money', '2019-04-05', 'Nhan nam vuong', 'Nhan nam', 3750000, 1.586, 300, 4850000),
('CUR00002', 'Dinh The Hiep', 'Bought', 'Money', '2018-10-29', 'Nhan nam vuong', 'Nhan nam', 3750000, 1.586, 300, 4850000),
('GOL00001', 'Dinh The Hiep', 'Bought', 'Money', '2018-10-29', 'Nhan nam vuong', 'Nhan nam', 3750, 1.586, 300, 4850000),
('GOL00002', 'Dinh The Hiep', 'Bought', 'Card', '2018-10-29', 'Nhan nam vuong', 'Nhan nam', 3750000, 1.586, 300, 4850000),
('OTH00003', 'Dinh The Hiep', 'Sell', 'Card', '2018-10-29', 'Nhan nam vuong', 'Nhan nam', 3750000, 1.586, 300, 4850000);

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `productCode` varchar(10) NOT NULL,
  `productName` varchar(20) NOT NULL,
  `productImage` varchar(30) DEFAULT NULL,
  `productDescription` text NOT NULL,
  `quantity` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`productCode`, `productName`, `productImage`, `productDescription`, `quantity`) VALUES
('GTA00001', 'Nhan nam phan', 'src/images/vangta/namphan.jpg', 'Nhan nam phan', 58),
('GTA00002', 'Nhan mot chi', 'src/images/vangta/motchi.jpg', 'Nhan btmc vang ta 1 chi', 10),
('GTA00003', 'Nhan hai chi', 'src/images/vangta/haichi.jpg', 'Nhan hai chi', 58),
('GTA00004', 'Nhan ba chi', 'src/images/vangta/bachi.jpg', 'Nhan ba chi', 58),
('GTA00005', 'Nhan nam chi', 'src/images/vangta/namchi.jpg', 'Nhan nam chi', 58),
('GTA00006', 'Nhan muoi chi', 'src/images/vangta/muoichi.jpg', 'Nhan muoi chi', 58),
('GTY00001', 'Nhan nam ITALY 18K', 'src/images/vangta/haichi.jpg', 'Nhan nam ITALY 18K', 1000),
('NGT00001', 'DOLLAR', 'src/images/ngoaite/usd.jpg', 'Do la My', 5869);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`code`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`productCode`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
