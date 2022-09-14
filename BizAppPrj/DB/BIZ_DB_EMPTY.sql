-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.6.51-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for bizdb
DROP DATABASE IF EXISTS `bizdb`;
CREATE DATABASE IF NOT EXISTS `bizdb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bizdb`;

-- Dumping structure for table bizdb.m_customer
DROP TABLE IF EXISTS `m_customer`;
CREATE TABLE IF NOT EXISTS `m_customer` (
  `ID` varchar(50) NOT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `ADDNO` varchar(45) DEFAULT NULL,
  `ADD1` varchar(45) DEFAULT NULL,
  `ADD2` varchar(45) DEFAULT NULL,
  `ADD3` varchar(45) DEFAULT NULL,
  `CONTACT` varchar(15) DEFAULT NULL,
  `MOBILE` varchar(15) DEFAULT NULL,
  `ACTIVE` smallint(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.m_customer: ~0 rows (approximately)
REPLACE INTO `m_customer` (`ID`, `NAME`, `ADDNO`, `ADD1`, `ADD2`, `ADD3`, `CONTACT`, `MOBILE`, `ACTIVE`) VALUES
	('00000', 'CASH', NULL, NULL, NULL, NULL, NULL, NULL, 1);

-- Dumping structure for table bizdb.m_giftvoucher
DROP TABLE IF EXISTS `m_giftvoucher`;
CREATE TABLE IF NOT EXISTS `m_giftvoucher` (
  `GV_NO` varchar(100) NOT NULL,
  `GRP_ID` varchar(50) NOT NULL,
  `VALUE` double NOT NULL DEFAULT '0',
  `CR_LOC` int(11) NOT NULL,
  `CR_BY` varchar(50) NOT NULL,
  `CR_DATE` datetime DEFAULT NULL,
  `PUR_LOC` int(11) DEFAULT NULL,
  `PUR_DATE` datetime DEFAULT NULL,
  `PUR_CRBY` varchar(50) DEFAULT NULL,
  `PUR_REFNO` varchar(100) DEFAULT NULL,
  `ACTIVE` int(11) NOT NULL DEFAULT '0',
  `ISPUR` int(11) NOT NULL DEFAULT '0',
  `GV_DES` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`GV_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.m_giftvoucher: ~0 rows (approximately)

-- Dumping structure for table bizdb.m_giftvoucher_group
DROP TABLE IF EXISTS `m_giftvoucher_group`;
CREATE TABLE IF NOT EXISTS `m_giftvoucher_group` (
  `GRP_ID` varchar(50) NOT NULL,
  `GRP_NAME` varchar(100) NOT NULL,
  `GRP_STARTNO` varchar(100) NOT NULL,
  `GRP_ENDNO` varchar(100) NOT NULL,
  `GRP_QTY` int(11) NOT NULL DEFAULT '0',
  `GRP_ACTIVE` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`GRP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.m_giftvoucher_group: ~0 rows (approximately)

-- Dumping structure for table bizdb.m_group1
DROP TABLE IF EXISTS `m_group1`;
CREATE TABLE IF NOT EXISTS `m_group1` (
  `ID` varchar(5) NOT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `ACTIVE` smallint(6) DEFAULT NULL,
  `ISHIDDEN` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.m_group1: ~0 rows (approximately)
REPLACE INTO `m_group1` (`ID`, `NAME`, `ACTIVE`, `ISHIDDEN`) VALUES
	('G1000', '', 1, 1);

-- Dumping structure for table bizdb.m_group2
DROP TABLE IF EXISTS `m_group2`;
CREATE TABLE IF NOT EXISTS `m_group2` (
  `ID` varchar(5) NOT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `ACTIVE` smallint(6) DEFAULT NULL,
  `ISHIDDEN` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.m_group2: ~0 rows (approximately)
REPLACE INTO `m_group2` (`ID`, `NAME`, `ACTIVE`, `ISHIDDEN`) VALUES
	('G2000', '', 1, 1);

-- Dumping structure for table bizdb.m_group3
DROP TABLE IF EXISTS `m_group3`;
CREATE TABLE IF NOT EXISTS `m_group3` (
  `ID` varchar(5) NOT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `ACTIVE` smallint(6) DEFAULT NULL,
  `ISHIDDEN` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.m_group3: ~0 rows (approximately)
REPLACE INTO `m_group3` (`ID`, `NAME`, `ACTIVE`, `ISHIDDEN`) VALUES
	('G3000', '', 1, 1);

-- Dumping structure for table bizdb.m_group4
DROP TABLE IF EXISTS `m_group4`;
CREATE TABLE IF NOT EXISTS `m_group4` (
  `ID` varchar(5) NOT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `ACTIVE` smallint(6) DEFAULT NULL,
  `ISHIDDEN` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.m_group4: ~0 rows (approximately)
REPLACE INTO `m_group4` (`ID`, `NAME`, `ACTIVE`, `ISHIDDEN`) VALUES
	('G4000', '', 1, 1);

-- Dumping structure for table bizdb.m_group5
DROP TABLE IF EXISTS `m_group5`;
CREATE TABLE IF NOT EXISTS `m_group5` (
  `ID` varchar(5) NOT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `ACTIVE` smallint(6) DEFAULT NULL,
  `ISHIDDEN` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.m_group5: ~0 rows (approximately)
REPLACE INTO `m_group5` (`ID`, `NAME`, `ACTIVE`, `ISHIDDEN`) VALUES
	('G5000', '', 1, 1);

-- Dumping structure for table bizdb.m_group6
DROP TABLE IF EXISTS `m_group6`;
CREATE TABLE IF NOT EXISTS `m_group6` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `ACTIVE` tinyint(4) DEFAULT '1',
  `ISHIDDEN` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.m_group6: ~0 rows (approximately)

-- Dumping structure for table bizdb.m_grouplink
DROP TABLE IF EXISTS `m_grouplink`;
CREATE TABLE IF NOT EXISTS `m_grouplink` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `G1_ID` varchar(50) NOT NULL,
  `G2_ID` varchar(50) NOT NULL,
  `G3_ID` varchar(50) NOT NULL,
  `G4_ID` varchar(50) NOT NULL,
  `G5_ID` varchar(50) NOT NULL,
  `G6_ID` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.m_grouplink: ~0 rows (approximately)

-- Dumping structure for table bizdb.m_location
DROP TABLE IF EXISTS `m_location`;
CREATE TABLE IF NOT EXISTS `m_location` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `ACTIVE` smallint(6) DEFAULT NULL,
  `VISIBLE` smallint(6) DEFAULT NULL,
  `REFNO` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.m_location: ~0 rows (approximately)
REPLACE INTO `m_location` (`ID`, `NAME`, `ACTIVE`, `VISIBLE`, `REFNO`) VALUES
	(0, 'MAIN', 1, 1, '');

-- Dumping structure for table bizdb.m_paydet
DROP TABLE IF EXISTS `m_paydet`;
CREATE TABLE IF NOT EXISTS `m_paydet` (
  `ID` varchar(5) NOT NULL,
  `M_PAYMST_ID` varchar(5) NOT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `RATE` double DEFAULT NULL,
  `SHORT_NAME` varchar(50) DEFAULT NULL,
  `SEQ_ORDER` int(11) DEFAULT '0',
  `ACTIVE` int(11) DEFAULT '1',
  `REF_REQ` int(11) DEFAULT '0',
  `DATE_F` int(11) DEFAULT '0',
  PRIMARY KEY (`ID`,`M_PAYMST_ID`),
  KEY `FK_M_PAYDET_M_PAYMST1_IDX` (`M_PAYMST_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.m_paydet: ~3 rows (approximately)
REPLACE INTO `m_paydet` (`ID`, `M_PAYMST_ID`, `NAME`, `RATE`, `SHORT_NAME`, `SEQ_ORDER`, `ACTIVE`, `REF_REQ`, `DATE_F`) VALUES
	('AMEX', 'CRC', 'AMEX', 0, 'AMEX', 0, 1, 1, 0),
	('MAST', 'CRC', 'MASTER', 0, 'MASTER', 1, 1, 1, 0),
	('VISA', 'CRC', 'VISA', 0, 'VISA', 0, 1, 1, 0);

-- Dumping structure for table bizdb.m_paymst
DROP TABLE IF EXISTS `m_paymst`;
CREATE TABLE IF NOT EXISTS `m_paymst` (
  `ID` varchar(5) NOT NULL,
  `NAME` varchar(50) DEFAULT NULL,
  `HASDET` smallint(6) DEFAULT NULL,
  `REFREQ` smallint(6) DEFAULT NULL,
  `SEQ_ORDER` int(11) DEFAULT '0',
  `SHORT_NAME` varchar(50) DEFAULT NULL,
  `ACTIVE` int(11) DEFAULT '1',
  `OVER_PAY` int(11) DEFAULT '0',
  `DATE_F` int(11) DEFAULT '0',
  `SET_DUE_AUTO` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.m_paymst: ~4 rows (approximately)
REPLACE INTO `m_paymst` (`ID`, `NAME`, `HASDET`, `REFREQ`, `SEQ_ORDER`, `SHORT_NAME`, `ACTIVE`, `OVER_PAY`, `DATE_F`, `SET_DUE_AUTO`) VALUES
	('CHQ', 'CHEQUE', 0, 1, 2, 'CHEQUE', 0, 0, 1, 0),
	('CRC', 'CREDIT CARD', 1, 0, 1, 'CRD CARD', 0, 0, 0, 1),
	('CRD', 'CREDIT', 0, 0, 4, 'CREDIT', 1, 0, 0, 0),
	('CSH', 'CASH', 0, 0, 0, 'CASH', 1, 1, 0, 1),
	('VOU', 'VOUCHER', 0, 1, 3, 'VOUCHER', 0, 0, 0, 0);

-- Dumping structure for table bizdb.m_permissions
DROP TABLE IF EXISTS `m_permissions`;
CREATE TABLE IF NOT EXISTS `m_permissions` (
  `ID` varchar(50) NOT NULL,
  `PARENTID` varchar(50) NOT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `DESCRIPTION` longtext,
  `TYPE` varchar(10) DEFAULT NULL,
  `HASSUB` smallint(6) DEFAULT NULL,
  `ISUIMENU` smallint(6) DEFAULT NULL,
  `ORD` int(11) NOT NULL DEFAULT '0',
  `TREE_ICON` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`ID`,`PARENTID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.m_permissions: ~66 rows (approximately)
REPLACE INTO `m_permissions` (`ID`, `PARENTID`, `NAME`, `DESCRIPTION`, `TYPE`, `HASSUB`, `ISUIMENU`, `ORD`, `TREE_ICON`) VALUES
	('A00000', 'A00000', 'ACCOUNTS', 'Accounts/Payments', 'ACC', 1, 1, 601, 'accounts.png'),
	('A00001', 'A00000', 'ACHQ', 'Cheque Payments', 'ACHQ', 0, 1, 602, 'Cheque.png'),
	('M00000', 'M00000', 'MASTER', 'Master Files', 'MSTF', 1, 1, 0, 'materfiles.png'),
	('M00001', 'M00000', 'LOCATIONS', 'Locations', 'LOC', 0, 1, 1, 'location.png'),
	('M00002', 'M00000', 'GROUP1', 'Group1', 'GROUP', 0, 1, 2, 'group.png'),
	('M00003', 'M00000', 'GROUP2', 'Group2', 'GROUP', 0, 1, 3, 'group.png'),
	('M00004', 'M00000', 'GROUP3', 'Group3', 'GROUP', 0, 1, 4, 'group.png'),
	('M00005', 'M00000', 'GROUP4', 'Group4', 'GROUP', 0, 1, 5, 'group.png'),
	('M00006', 'M00000', 'GROUP5', 'Group5', 'GROUP', 0, 1, 6, 'group.png'),
	('M00007', 'M00000', 'GROUP6', 'Group6', 'GROUP', 0, 1, 7, 'group.png'),
	('M00011', 'M00000', 'GROUPMAP', 'Group Map', 'GRPM', 0, 1, 12, 'groupmap.png'),
	('M00012', 'M00000', 'UNITS', 'Unit Master', 'UNITS', 0, 1, 13, 'units.png'),
	('M00013', 'M00000', 'UGRP', 'Unit Group', 'UGRP', 0, 1, 14, 'unitgrp.png'),
	('M00014', 'M00000', 'ITEMS', 'Item Maser', 'ITEMS', 0, 1, 15, 'item_cloth.png'),
	('M00015', 'M00000', 'SUP', 'Supplier', 'SUP', 0, 1, 16, 'supplier.png'),
	('M00016', 'M00000', 'CUS', 'Customer', 'CUS', 0, 1, 17, 'customer.png'),
	('M00017', 'M00000', 'GVCRE', 'Gift Voucher Creation', 'GVCRE', 0, 1, 18, 'gv.png'),
	('M00018', 'M00000', 'GVSTA', 'Gift Voucher Status', 'GVSTA', 0, 1, 19, 'gv_status.png'),
	('M00019', 'M00000', 'SALESM', 'Sales Person', 'SALESM', 0, 1, 20, 'salesman.png'),
	('P00000', 'P00000', 'GEN_PER', 'General Permissions', 'GEN_PER', 1, 0, 801, ''),
	('P00001', 'P00000', 'P1', 'Login', 'GEN_PER', 0, 0, 802, ''),
	('P00002', 'P00000', 'P2', 'Logout', 'GEN_PER', 0, 0, 803, ''),
	('P00003', 'P00000', 'P3', 'Location Create', 'GEN_PER', 0, 0, 804, ''),
	('P00004', 'P00000', 'P4', 'Location Update', 'GEN_PER', 0, 0, 805, ''),
	('P00005', 'P00000', 'P5', 'Group Creation', 'GEN_PER', 0, 0, 805, ''),
	('P00006', 'P00000', 'P6', 'Group Update', 'GEN_PER', 0, 0, 807, ''),
	('P00007', 'P00000', 'P7', 'Unit Creation', 'GEN_PER', 0, 0, 808, ''),
	('P00008', 'P00000', 'P8', 'Unit Update', 'GEN_PER', 0, 0, 809, ''),
	('P00009', 'P00000', 'P9', 'Item Creation', 'GEN_PER', 0, 0, 810, ''),
	('P00010', 'P00000', 'P10', 'Item Update', 'GEN_PER', 0, 0, 811, ''),
	('P00011', 'P00000', 'P11', 'Supplier Create', 'GEN_PER', 0, 0, 812, ''),
	('P00012', 'P00000', 'P12', 'Supplier Update', 'GEN_PER', 0, 0, 813, ''),
	('P00013', 'P00000', 'P13', 'Customer Create', 'GEN_PER', 0, 0, 814, ''),
	('P00014', 'P00000', 'P14', 'Customer Update', 'GEN_PER', 0, 0, 815, ''),
	('P00015', 'P00000', 'P15', 'Group Map Create', 'GEN_PER', 0, 0, 816, ''),
	('P00016', 'P00000', 'P16', 'Group Map Update', 'GEN_PER', 0, 0, 817, ''),
	('P00017', 'P00000', 'P17', 'Unit Map Create', 'GEN_PER', 0, 0, 818, ''),
	('P00018', 'P00000', 'P18', 'Unit Map Update', 'GEN_PER', 0, 0, 819, ''),
	('P00019', 'P00000', 'P19', 'Cheque Payment Update State', 'GEN_PER', 0, 0, 820, ''),
	('P00020', 'P00000', 'P20', 'Cheque Payment Special Update(Re-Assign)', 'GEN_PER', 0, 0, 821, ''),
	('P00021', 'P00000', 'P21', 'Gift voucher purchase', 'GEN_PER', 0, 0, 822, ''),
	('P00022', 'P00000', 'P22', 'Gift voucher redeem', 'GEN_PER', 0, 0, 823, ''),
	('P00023', 'P00000', 'P23', 'Give Discount Percentage', 'GEN_PER', 0, 0, 824, ''),
	('P00024', 'P00000', 'P24', 'Give Discount Amount', 'GEN_PER', 0, 0, 825, ''),
	('P00025', 'P00000', 'P25', 'Give Total Discount', 'GEN_PER', 0, 0, 826, ''),
	('P00026', 'P00000', 'P26', 'Cancel Transaction', 'GEN_PER', 0, 0, 826, ''),
	('R00000', 'R00000', 'RPT', 'Reports', 'RPT', 1, 1, 201, 'report.png'),
	('R00001', 'R00000', 'R_SALES', 'Sales Reports', 'RPT', 0, 1, 202, 'Sales_Folder.png'),
	('R00002', 'R00001', 'R_SALES_1', 'Invoice Listing', 'RPT', 0, 1, 203, 'Report_sub.png'),
	('R00003', 'R00001', 'R_SALES_2', 'Payment mode wise Sale', 'RPT', 0, 1, 204, 'Report_sub.png'),
	('R00004', 'R00001', 'R_SALES_3', 'Supplier Products Sale', 'RPT', 0, 1, 205, 'Report_sub.png'),
	('R00005', 'R00001', 'R_SALES_4', 'Invoice wise Profit Report', 'RPT', 0, 1, 206, 'Report_sub.png'),
	('R00101', 'R00000', 'R_STOCK', 'Stock Reports', 'RPT', 0, 1, 301, 'Stock_Folder.png'),
	('R00102', 'R00101', 'R_STOCK_1', 'Stock Balance Summary', 'RPT', 0, 1, 302, 'Report_sub.png'),
	('S00000', 'S00000', 'SECURITY', 'Security', 'SECUR', 1, 1, 701, 'security.png'),
	('S00001', 'S00000', 'SEC_UC', 'User Creation', 'SUC', 0, 1, 702, 'user_create.png'),
	('S00002', 'S00000', 'SEC_GP', 'Group Permission', 'SGP', 0, 1, 703, ''),
	('S00003', 'S00000', 'SEC_US', 'User Security', 'SUS', 0, 1, 704, 'user_security.png'),
	('S00004', 'S00000', 'SEC_UUD', 'User Details Update', 'SUUDU', 0, 0, 705, ''),
	('S00005', 'S00000', 'SEC_UUS', 'User State Update only', 'SUSU', 0, 0, 706, ''),
	('T00000', 'T00000', 'TRANSACTIONS', 'Transactions', 'TRN', 1, 1, 101, 'transaction.png'),
	('T00001', 'T00000', 'T_GRN', 'Goods Received Note', 'TRN', 0, 1, 102, 'grn.png'),
	('T00002', 'T00000', 'T_INV', 'Invoice', 'TRN', 0, 1, 103, 'Invoice.png'),
	('U00000', 'U00000', 'SETTINGS', 'Utilities', 'SET', 1, 1, 751, 'fol.png'),
	('U00001', 'U00000', 'SET_SYS', 'Settings', 'SET', 0, 1, 752, 'settings.png'),
	('U00002', 'U00000', 'SET_EXC', 'Excel Upload', 'SET', 0, 1, 753, 'excel.png');

-- Dumping structure for table bizdb.m_products
DROP TABLE IF EXISTS `m_products`;
CREATE TABLE IF NOT EXISTS `m_products` (
  `ID` varchar(100) NOT NULL,
  `PARENT_ID` varchar(100) DEFAULT NULL,
  `NAME` text,
  `PRINTDES` varchar(100) DEFAULT NULL,
  `ACTIVE` smallint(6) DEFAULT NULL,
  `BATCH` smallint(6) DEFAULT NULL,
  `CRDATE` datetime DEFAULT NULL,
  `CRUSER` varchar(50) NOT NULL,
  `MDDATE` datetime DEFAULT NULL,
  `MDUSER` varchar(50) NOT NULL,
  `M_GROUP1_ID` varchar(5) NOT NULL,
  `M_GROUP2_ID` varchar(5) NOT NULL,
  `M_GROUP3_ID` varchar(5) NOT NULL,
  `M_GROUP4_ID` varchar(5) NOT NULL,
  `M_GROUP5_ID` varchar(5) NOT NULL,
  `REF1` varchar(45) DEFAULT NULL,
  `REF2` varchar(45) DEFAULT NULL,
  `M_UNITGROUPS_ID` varchar(50) NOT NULL,
  `PRO_IMG` varchar(100) DEFAULT '',
  `PRO_COMMSION` double DEFAULT '0',
  `M_GROUP6_ID` varchar(5) DEFAULT NULL,
  KEY `FK_M_PRODUCTS_M_GROUP11_IDX` (`M_GROUP1_ID`),
  KEY `FK_M_PRODUCTS_M_GROUP21_IDX` (`M_GROUP2_ID`),
  KEY `FK_M_PRODUCTS_M_GROUP31_IDX` (`M_GROUP3_ID`),
  KEY `FK_M_PRODUCTS_M_GROUP41_IDX` (`M_GROUP4_ID`),
  KEY `FK_M_PRODUCTS_M_GROUP51_IDX` (`M_GROUP5_ID`),
  KEY `FK_M_PRODUCTS_M_UNITGROUPS1_IDX` (`M_UNITGROUPS_ID`),
  KEY `FK_M_PRODUCTS_M_USER1_IDX` (`CRUSER`),
  KEY `FK_M_PRODUCTS_M_USER2_IDX` (`MDUSER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.m_products: ~0 rows (approximately)

-- Dumping structure for table bizdb.m_products_has_m_propertise
DROP TABLE IF EXISTS `m_products_has_m_propertise`;
CREATE TABLE IF NOT EXISTS `m_products_has_m_propertise` (
  `M_PRODUCTS_ID` varchar(50) NOT NULL,
  `M_PROPERTISE_ID` int(11) NOT NULL,
  `VALUE` varchar(100) DEFAULT NULL,
  KEY `FK_M_PRODUCTS_HAS_M_PROPERTISE_M_PRODUCTS1_IDX` (`M_PRODUCTS_ID`),
  KEY `FK_M_PRODUCTS_HAS_M_PROPERTISE_M_PROPERTISE1_IDX` (`M_PROPERTISE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.m_products_has_m_propertise: ~0 rows (approximately)

-- Dumping structure for table bizdb.m_propdatatype
DROP TABLE IF EXISTS `m_propdatatype`;
CREATE TABLE IF NOT EXISTS `m_propdatatype` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `FORMAT` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.m_propdatatype: ~5 rows (approximately)
REPLACE INTO `m_propdatatype` (`ID`, `NAME`, `FORMAT`) VALUES
	(1, 'NUM', ''),
	(2, 'TEXT', ''),
	(3, 'DATE', ''),
	(4, 'EXPDATE', 'YY-MM-DD'),
	(5, 'WARRENTY', 'YY-MM-DD');

-- Dumping structure for table bizdb.m_propertise
DROP TABLE IF EXISTS `m_propertise`;
CREATE TABLE IF NOT EXISTS `m_propertise` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `ACTIVE` smallint(6) DEFAULT NULL,
  `M_PROPDATATYPE_ID` int(11) NOT NULL,
  KEY `FK_M_PROPERTISE_M_PROPDATATYPE1_IDX` (`M_PROPDATATYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.m_propertise: ~0 rows (approximately)

-- Dumping structure for table bizdb.m_salesperson
DROP TABLE IF EXISTS `m_salesperson`;
CREATE TABLE IF NOT EXISTS `m_salesperson` (
  `ID` varchar(50) NOT NULL,
  `FNAME` varchar(60) NOT NULL,
  `LNAME` varchar(60) NOT NULL,
  `IMGPATH` varchar(100) DEFAULT '',
  `COMM_PER` double DEFAULT '0',
  `ACTIVE` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.m_salesperson: ~0 rows (approximately)

-- Dumping structure for table bizdb.m_stocks
DROP TABLE IF EXISTS `m_stocks`;
CREATE TABLE IF NOT EXISTS `m_stocks` (
  `M_LOCATION_ID` int(11) NOT NULL,
  `M_PRODUCTS_ID` varchar(50) NOT NULL,
  `BATCHNO` varchar(50) DEFAULT NULL,
  `COSTP` double DEFAULT NULL,
  `SELLP` double DEFAULT NULL,
  `CRDATE` datetime DEFAULT NULL,
  `M_UNITS_ID` varchar(10) NOT NULL,
  `SIH` double DEFAULT NULL,
  `MARKUP` double NOT NULL,
  `ACTIVE` smallint(6) DEFAULT '1',
  `SIH_MAXU_ROU` double DEFAULT '0',
  `SIH_MINU_ROU` double DEFAULT '0',
  `UNIT_M` varchar(50) DEFAULT '',
  KEY `FK_M_STOCKS_M_LOCATION1_IDX` (`M_LOCATION_ID`),
  KEY `FK_M_STOCKS_M_PRODUCTS1_IDX` (`M_PRODUCTS_ID`),
  KEY `FK_M_STOCKS_M_UNITS1_IDX` (`M_UNITS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.m_stocks: ~0 rows (approximately)

-- Dumping structure for table bizdb.m_stocks_tem
DROP TABLE IF EXISTS `m_stocks_tem`;
CREATE TABLE IF NOT EXISTS `m_stocks_tem` (
  `M_PRODUCTS_ID` varchar(50) NOT NULL,
  `PRONAME` varchar(200) NOT NULL,
  `SIH` double NOT NULL,
  `UNIT_ID` varchar(50) NOT NULL,
  `UNIT_SYM` varchar(50) NOT NULL,
  `BATCHNO` varchar(50) NOT NULL,
  `M_LOCATION_ID` int(11) NOT NULL,
  `SIH_MAXU_ROU` double DEFAULT '0',
  `SIH_MINU_ROU` double DEFAULT '0',
  `UNIT_M` varchar(50) DEFAULT '',
  PRIMARY KEY (`M_PRODUCTS_ID`,`BATCHNO`,`M_LOCATION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.m_stocks_tem: ~0 rows (approximately)

-- Dumping structure for table bizdb.m_supplier
DROP TABLE IF EXISTS `m_supplier`;
CREATE TABLE IF NOT EXISTS `m_supplier` (
  `ID` varchar(50) NOT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `CONTACTPERSON` varchar(15) DEFAULT NULL,
  `CONTACT` varchar(15) DEFAULT NULL,
  `MOBILE` varchar(15) DEFAULT NULL,
  `ACTIVE` smallint(6) DEFAULT NULL,
  `ADDRESS` longtext
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.m_supplier: ~0 rows (approximately)
REPLACE INTO `m_supplier` (`ID`, `NAME`, `CONTACTPERSON`, `CONTACT`, `MOBILE`, `ACTIVE`, `ADDRESS`) VALUES
	('S0000', 'DEF', '-', '-', '-', 1, '-');

-- Dumping structure for table bizdb.m_supplier_has_m_products
DROP TABLE IF EXISTS `m_supplier_has_m_products`;
CREATE TABLE IF NOT EXISTS `m_supplier_has_m_products` (
  `M_SUPPLIER_ID` varchar(50) NOT NULL,
  `M_PRODUCTS_ID` varchar(50) NOT NULL,
  `ACTIVE` smallint(6) DEFAULT NULL,
  KEY `FK_M_SUPPLIER_HAS_M_PRODUCTS_M_PRODUCTS1_IDX` (`M_PRODUCTS_ID`),
  KEY `FK_M_SUPPLIER_HAS_M_PRODUCTS_M_SUPPLIER1_IDX` (`M_SUPPLIER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.m_supplier_has_m_products: ~0 rows (approximately)

-- Dumping structure for table bizdb.m_unitgroups
DROP TABLE IF EXISTS `m_unitgroups`;
CREATE TABLE IF NOT EXISTS `m_unitgroups` (
  `ID` varchar(50) NOT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `ACTIVE` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.m_unitgroups: ~0 rows (approximately)
REPLACE INTO `m_unitgroups` (`ID`, `NAME`, `ACTIVE`) VALUES
	('UG000', 'NO', 1);

-- Dumping structure for table bizdb.m_unitgroups_has_m_units
DROP TABLE IF EXISTS `m_unitgroups_has_m_units`;
CREATE TABLE IF NOT EXISTS `m_unitgroups_has_m_units` (
  `M_UNITGROUPS_ID` varchar(50) NOT NULL,
  `M_UNITS_ID` varchar(50) NOT NULL,
  `VOLUME` float(24,0) DEFAULT NULL,
  `ACTIVE` smallint(6) DEFAULT NULL,
  `BASEUNIT` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`M_UNITGROUPS_ID`,`M_UNITS_ID`),
  KEY `FK_M_UNITGROUPS_HAS_M_UNITS_M_UNITS1_IDX` (`M_UNITS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.m_unitgroups_has_m_units: ~0 rows (approximately)
REPLACE INTO `m_unitgroups_has_m_units` (`M_UNITGROUPS_ID`, `M_UNITS_ID`, `VOLUME`, `ACTIVE`, `BASEUNIT`) VALUES
	('UG000', 'U000', 1, 1, 1);

-- Dumping structure for table bizdb.m_units
DROP TABLE IF EXISTS `m_units`;
CREATE TABLE IF NOT EXISTS `m_units` (
  `ID` varchar(50) NOT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `ACTIVE` smallint(6) DEFAULT NULL,
  `SYMBLE` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.m_units: ~0 rows (approximately)
REPLACE INTO `m_units` (`ID`, `NAME`, `ACTIVE`, `SYMBLE`) VALUES
	('U000', 'NO', 1, '');

-- Dumping structure for table bizdb.m_user
DROP TABLE IF EXISTS `m_user`;
CREATE TABLE IF NOT EXISTS `m_user` (
  `ID` varchar(50) NOT NULL,
  `FIRSTNAME` varchar(45) DEFAULT NULL,
  `LASTNAME` varchar(45) DEFAULT NULL,
  `IMGURL` varchar(100) DEFAULT NULL,
  `UGRUID` int(11) NOT NULL,
  `ACTIVE` smallint(6) DEFAULT NULL,
  `VISIBLE` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_M_USER_M_USERGROUP1_IDX` (`UGRUID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.m_user: ~0 rows (approximately)
REPLACE INTO `m_user` (`ID`, `FIRSTNAME`, `LASTNAME`, `IMGURL`, `UGRUID`, `ACTIVE`, `VISIBLE`) VALUES
	('U0000', 'SUPER ADMIN', '', '', 0, 1, 0);

-- Dumping structure for table bizdb.m_usergroup
DROP TABLE IF EXISTS `m_usergroup`;
CREATE TABLE IF NOT EXISTS `m_usergroup` (
  `ID` int(11) NOT NULL,
  `GROUPNAME` varchar(45) DEFAULT NULL,
  `ACTIVE` smallint(6) DEFAULT NULL,
  `VISIBLE` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.m_usergroup: ~3 rows (approximately)
REPLACE INTO `m_usergroup` (`ID`, `GROUPNAME`, `ACTIVE`, `VISIBLE`) VALUES
	(0, 'SUPERADMIN', 1, 0),
	(1, 'ADMIN', 1, 1),
	(2, 'CASHIER', 1, 1);

-- Dumping structure for table bizdb.m_usersecurity
DROP TABLE IF EXISTS `m_usersecurity`;
CREATE TABLE IF NOT EXISTS `m_usersecurity` (
  `ID` int(11) NOT NULL,
  `USERNAME` varchar(45) NOT NULL,
  `PASSWORD` varchar(45) DEFAULT NULL,
  `UID` varchar(50) NOT NULL,
  PRIMARY KEY (`USERNAME`),
  KEY `FK_M_USERSECURITY_M_USER_IDX` (`UID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.m_usersecurity: ~0 rows (approximately)
REPLACE INTO `m_usersecurity` (`ID`, `USERNAME`, `PASSWORD`, `UID`) VALUES
	(0, 'ADMIN', 'ÃËÝÅÉÓÐÖ', 'U0000');

-- Dumping structure for table bizdb.r_price_tags
DROP TABLE IF EXISTS `r_price_tags`;
CREATE TABLE IF NOT EXISTS `r_price_tags` (
  `LOCID` int(11) NOT NULL,
  `PROID` varchar(50) NOT NULL,
  `BATCHID` varchar(50) NOT NULL,
  `SERIALID` varchar(100) NOT NULL,
  `PRONAME` varchar(100) NOT NULL,
  `COSTP` double NOT NULL,
  `SELLP` double NOT NULL,
  PRIMARY KEY (`LOCID`,`PROID`,`BATCHID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.r_price_tags: ~0 rows (approximately)

-- Dumping structure for function bizdb.strf_ConvMaxUnit
DROP FUNCTION IF EXISTS `strf_ConvMaxUnit`;
DELIMITER //
CREATE FUNCTION `strf_ConvMaxUnit`( unit_grp VARCHAR(100),unit_id VARCHAR(100),qty DOUBLE ) RETURNS double
BEGIN   DECLARE UNIT_VOL_CUR  DOUBLE DEFAULT '0'  ;  DECLARE UNIT_VOL_MAX  DOUBLE DEFAULT '0'  ;  select ugu.VOLUME INTO UNIT_VOL_CUR from m_unitgroups_has_m_units ugu where ugu.M_UNITGROUPS_ID=unit_grp AND ugu.M_UNITS_ID=unit_id    ;  select ugu.VOLUME INTO UNIT_VOL_MAX from m_unitgroups_has_m_units ugu where ugu.M_UNITGROUPS_ID=unit_grp ORDER BY ugu.VOLUME desc limit 1    ;  RETURN ((qty*UNIT_VOL_CUR)/UNIT_VOL_MAX)  ; END//
DELIMITER ;

-- Dumping structure for function bizdb.strf_ConvMinUnit
DROP FUNCTION IF EXISTS `strf_ConvMinUnit`;
DELIMITER //
CREATE FUNCTION `strf_ConvMinUnit`( unit_grp VARCHAR(100),unit_id VARCHAR(100),qty DOUBLE ) RETURNS double
BEGIN   DECLARE UNIT_VOL_CUR  DOUBLE DEFAULT '0'  ;  DECLARE UNIT_VOL_MIN  DOUBLE DEFAULT '0'  ;  select ugu.VOLUME INTO UNIT_VOL_CUR from m_unitgroups_has_m_units ugu where ugu.M_UNITGROUPS_ID=unit_grp AND ugu.M_UNITS_ID=unit_id    ;  select ugu.VOLUME INTO UNIT_VOL_MIN from m_unitgroups_has_m_units ugu where ugu.M_UNITGROUPS_ID=unit_grp ORDER BY ugu.VOLUME asc limit 1    ;  RETURN ((qty*UNIT_VOL_CUR)*UNIT_VOL_MIN)  ; END//
DELIMITER ;

-- Dumping structure for function bizdb.strf_getInvProfit
DROP FUNCTION IF EXISTS `strf_getInvProfit`;
DELIMITER //
CREATE FUNCTION `strf_getInvProfit`( para_trnid VARCHAR(100),para_trntyp VARCHAR(5) ) RETURNS double
BEGIN   DECLARE TRNPROFIT  DOUBLE DEFAULT '0'  ;  select (SUM(sl.AMOUNT)-SUM(sl.CPRICE*sl.QTY)) INTO TRNPROFIT  from t_stockline sl   where sl.T_STOCKMST_ID=para_trnid AND sl.TRNTYP=para_trntyp  GROUP BY sl.T_STOCKMST_ID,sl.TRNTYP   ;  RETURN TRNPROFIT  ; END//
DELIMITER ;

-- Dumping structure for function bizdb.strf_getMaxUnit
DROP FUNCTION IF EXISTS `strf_getMaxUnit`;
DELIMITER //
CREATE FUNCTION `strf_getMaxUnit`( unit_grp VARCHAR(100) ) RETURNS varchar(100) CHARSET latin1
BEGIN   DECLARE UNIT_ID VARCHAR(100) DEFAULT ''  ;  select ugu.M_UNITS_ID  INTO UNIT_ID from m_unitgroups_has_m_units ugu where ugu.M_UNITGROUPS_ID=unit_grp ORDER BY ugu.VOLUME DESC LIMIT 1    ;  RETURN UNIT_ID   ; END//
DELIMITER ;

-- Dumping structure for function bizdb.strf_getMinUnit
DROP FUNCTION IF EXISTS `strf_getMinUnit`;
DELIMITER //
CREATE FUNCTION `strf_getMinUnit`( unit_grp VARCHAR(100) ) RETURNS varchar(100) CHARSET latin1
BEGIN   DECLARE UNIT_ID VARCHAR(100) DEFAULT ''  ;  select ugu.M_UNITS_ID  INTO UNIT_ID from m_unitgroups_has_m_units ugu where ugu.M_UNITGROUPS_ID=unit_grp ORDER BY ugu.VOLUME ASC LIMIT 1    ;  RETURN UNIT_ID   ; END//
DELIMITER ;

-- Dumping structure for function bizdb.strf_getUnitName
DROP FUNCTION IF EXISTS `strf_getUnitName`;
DELIMITER //
CREATE FUNCTION `strf_getUnitName`( unit_id VARCHAR(100) ) RETURNS varchar(100) CHARSET latin1
BEGIN   DECLARE UNIT_NAME VARCHAR(100) DEFAULT ''  ;  SELECT u.NAME INTO UNIT_NAME FROM m_units u where u.ID=unit_id  ;  RETURN UNIT_NAME   ; END//
DELIMITER ;

-- Dumping structure for function bizdb.strf_getUnitSym
DROP FUNCTION IF EXISTS `strf_getUnitSym`;
DELIMITER //
CREATE FUNCTION `strf_getUnitSym`( unit_id VARCHAR(100) ) RETURNS varchar(100) CHARSET latin1
BEGIN   DECLARE UNIT_SYM VARCHAR(100) DEFAULT ''  ;  SELECT SYMBLE INTO UNIT_SYM FROM m_units WHERE ID=unit_id  ;  RETURN UNIT_SYM   ; END//
DELIMITER ;

-- Dumping structure for function bizdb.strf_getUnitVol
DROP FUNCTION IF EXISTS `strf_getUnitVol`;
DELIMITER //
CREATE FUNCTION `strf_getUnitVol`( unit_grp VARCHAR(100),unit_id VARCHAR(100) ) RETURNS double
BEGIN   DECLARE UNIT_VOL DOUBLE DEFAULT '0'  ;  select ugu.VOLUME INTO UNIT_VOL from m_unitgroups_has_m_units ugu where ugu.M_UNITGROUPS_ID=unit_grp AND ugu.M_UNITS_ID=unit_id   ;  RETURN UNIT_VOL   ; END//
DELIMITER ;

-- Dumping structure for procedure bizdb.strp_StockBalance
DROP PROCEDURE IF EXISTS `strp_StockBalance`;
DELIMITER //
CREATE PROCEDURE `strp_StockBalance`( loc_code INT )
BEGIN   TRUNCATE TABLE  M_STOCKS_TEM  ;  INSERT INTO M_STOCKS_TEM (SELECT PROID,NAME,sum(SIH) AS SIH,UNITID,UNIT,BATCH,LOCID,SUM(REM_SIH_MAX) AS SIH_MAXU_ROU,SUM(REM_SIH_MIN) AS SIH_MINU_ROU,MIN_UNIT FROM  (  (select p.ID as PROID,p.NAME as NAME,0 as SIH,0 as REM_SIH_MAX,0 AS REM_SIH_MIN ,strf_getMaxUnit(p.M_UNITGROUPS_ID) AS UNITID,  strf_getUnitSym(strf_getMaxUnit(p.M_UNITGROUPS_ID)) AS UNIT,strf_getUnitSym(strf_getMinUnit(p.M_UNITGROUPS_ID)) AS MIN_UNIT,'0001' as BATCH,l.ID as LOCID   from m_products p cross join m_location l   where p.ACTIVE=1 AND l.ACTIVE=1 )  union all  (SELECT SL.PROID AS PROID,P.NAME AS NAME,SUM(u.STOCKENTYP*strf_ConvMaxUnit(SL.M_UNITGROUPS_ID, SL.M_UNITS_ID, SL.QTY)) AS SIH,  (TRUNCATE(SUM(u.STOCKENTYP*strf_ConvMaxUnit(SL.M_UNITGROUPS_ID, SL.M_UNITS_ID, SL.QTY)),0) ) as REM_SIH_MAX,  (SUM(u.STOCKENTYP*strf_ConvMinUnit(SL.M_UNITGROUPS_ID, SL.M_UNITS_ID, SL.QTY)) - (strf_getUnitVol(SL.M_UNITGROUPS_ID,strf_getMaxUnit(p.M_UNITGROUPS_ID))* TRUNCATE(SUM(u.STOCKENTYP*strf_ConvMaxUnit(SL.M_UNITGROUPS_ID, SL.M_UNITS_ID, SL.QTY)),0)) ) as REM_SIH_MIN,  strf_getMaxUnit(p.M_UNITGROUPS_ID) AS UNITID,strf_getUnitSym(strf_getMaxUnit(p.M_UNITGROUPS_ID)) AS UNIT,strf_getUnitSym(strf_getMinUnit(p.M_UNITGROUPS_ID)) AS MIN_UNIT,SL.BATCH_NO AS BATCH,  SM.M_LOCATION_SOURCE as LOCID  FROM t_stockmst SM  inner join t_stockline SL  on SM.ID=SL.T_STOCKMST_ID and SM.TRNTYPE=SL.TRNTYP  inner join u_transactions u  on SM.TRNTYPE=u.TRNTYPE  INNER JOIN m_products P  on SL.PROID=P.ID  where SM.TRNSTATE='P'  GROUP BY SL.PROID,P.NAME)  )A  WHERE A.LOCID=loc_code  group by  A.PROID,A.NAME,A.LOCID,A.BATCH,A.UNIT  order by  A.PROID,A.NAME,A.LOCID ) ; END//
DELIMITER ;

-- Dumping structure for procedure bizdb.strp_UpdateStockBalance
DROP PROCEDURE IF EXISTS `strp_UpdateStockBalance`;
DELIMITER //
CREATE PROCEDURE `strp_UpdateStockBalance`( loc_code INT )
BEGIN   CALL strp_StockBalance(loc_code)  ;  UPDATE  M_STOCKS  S INNER JOIN M_STOCKS_TEM TS ON S.M_PRODUCTS_ID=TS.M_PRODUCTS_ID AND S.BATCHNO=TS.BATCHNO AND S.M_LOCATION_ID=TS.M_LOCATION_ID SET S.SIH=TS.SIH,S.SIH_MAXU_ROU=TS.SIH_MAXU_ROU,S.SIH_MINU_ROU=TS.SIH_MINU_ROU,S.UNIT_M=TS.UNIT_M   ; END//
DELIMITER ;

-- Dumping structure for table bizdb.t_chqpayments
DROP TABLE IF EXISTS `t_chqpayments`;
CREATE TABLE IF NOT EXISTS `t_chqpayments` (
  `CHQ_NO` varchar(50) NOT NULL,
  `CHQ_DATE` datetime NOT NULL,
  `STATE` varchar(5) NOT NULL,
  `REFNO` varchar(50) NOT NULL,
  `REFTRNTYP` varchar(5) NOT NULL,
  `CUS_ID` varchar(50) DEFAULT NULL,
  `SUP_ID` varchar(50) DEFAULT NULL,
  `AMOUNT` double DEFAULT '0',
  `M_USER_CR` varchar(50) DEFAULT NULL,
  `CRDATE` datetime DEFAULT NULL,
  `M_USER_MD` varchar(50) DEFAULT NULL,
  `MDDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`CHQ_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.t_chqpayments: ~0 rows (approximately)

-- Dumping structure for table bizdb.t_gvredeem
DROP TABLE IF EXISTS `t_gvredeem`;
CREATE TABLE IF NOT EXISTS `t_gvredeem` (
  `NO` int(11) NOT NULL,
  `GV_NO` varchar(100) NOT NULL,
  `RED_VAL` double NOT NULL DEFAULT '0',
  `RED_LOC` int(11) NOT NULL,
  `RED_CRBY` varchar(50) NOT NULL,
  `RED_REFNO` varchar(100) NOT NULL,
  PRIMARY KEY (`NO`,`GV_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.t_gvredeem: ~0 rows (approximately)

-- Dumping structure for table bizdb.t_phystkdet
DROP TABLE IF EXISTS `t_phystkdet`;
CREATE TABLE IF NOT EXISTS `t_phystkdet` (
  `ID` int(11) NOT NULL,
  `T_PHYSTKMST_ID` varchar(50) NOT NULL,
  `SYSQTY` double DEFAULT NULL,
  `PHYQTY` double DEFAULT NULL,
  `CPRICE` double DEFAULT NULL,
  `SPRICE` double DEFAULT NULL,
  `PROID` varchar(100) NOT NULL,
  `M_UNITS_ID` varchar(50) NOT NULL,
  `M_UNITGROUPS_ID` varchar(50) NOT NULL,
  `UNIT_SYS` varchar(50) DEFAULT '',
  `BATCH` varchar(5) DEFAULT '',
  KEY `FK_T_PHYSTKDET_M_UNITGROUPS1_IDX` (`M_UNITGROUPS_ID`),
  KEY `FK_T_PHYSTKDET_M_UNITS1_IDX` (`M_UNITS_ID`),
  KEY `FK_T_PHYSTKDET_T_PHYSTKMST1_IDX` (`T_PHYSTKMST_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.t_phystkdet: ~0 rows (approximately)

-- Dumping structure for table bizdb.t_phystkmst
DROP TABLE IF EXISTS `t_phystkmst`;
CREATE TABLE IF NOT EXISTS `t_phystkmst` (
  `ID` varchar(50) NOT NULL,
  `CRDATE` datetime DEFAULT NULL,
  `M_USER_CR` varchar(50) NOT NULL,
  `MDDATE` datetime DEFAULT NULL,
  `M_USER_MD` varchar(50) NOT NULL,
  `M_LOCATION_ID` int(11) NOT NULL,
  `ISACTIVE` smallint(6) DEFAULT NULL,
  `TRNSTATE` varchar(2) DEFAULT NULL,
  KEY `FK_T_PHYSTKMST_M_LOCATION1_IDX` (`M_LOCATION_ID`),
  KEY `FK_T_PHYSTKMST_M_USER1_IDX` (`M_USER_CR`),
  KEY `FK_T_PHYSTKMST_M_USER2_IDX` (`M_USER_MD`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.t_phystkmst: ~0 rows (approximately)

-- Dumping structure for table bizdb.t_stockline
DROP TABLE IF EXISTS `t_stockline`;
CREATE TABLE IF NOT EXISTS `t_stockline` (
  `T_STOCKMST_ID` varchar(50) NOT NULL,
  `TERMINAL` varchar(5) NOT NULL,
  `TRNTYP` varchar(5) DEFAULT NULL,
  `LINEID` int(11) NOT NULL,
  `PROID` varchar(100) NOT NULL,
  `SPRICE` double DEFAULT NULL,
  `CPRICE` double DEFAULT NULL,
  `QTY` double DEFAULT NULL,
  `LDIS` double DEFAULT NULL,
  `LDISPER` double DEFAULT NULL,
  `AMOUNT` double DEFAULT NULL,
  `M_UNITS_ID` varchar(50) DEFAULT NULL,
  `M_UNITGROUPS_ID` varchar(50) DEFAULT NULL,
  `PRONAME` longtext NOT NULL,
  `BATCH_NO` varchar(50) DEFAULT NULL,
  `ISGV` tinyint(4) DEFAULT '0',
  `REF_TRN` varchar(100) DEFAULT '',
  `SALESMAN` varchar(50) DEFAULT '',
  `SALES_COM` double DEFAULT '0',
  `PRONAME2` longtext,
  KEY `FK_T_STOCKLINE_M_UNITGROUPS1_IDX` (`M_UNITGROUPS_ID`),
  KEY `FK_T_STOCKLINE_M_UNITS1_IDX` (`M_UNITS_ID`),
  KEY `FK_T_STOCKLINE_T_STOCKMST1_IDX` (`T_STOCKMST_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.t_stockline: ~0 rows (approximately)

-- Dumping structure for table bizdb.t_stockmst
DROP TABLE IF EXISTS `t_stockmst`;
CREATE TABLE IF NOT EXISTS `t_stockmst` (
  `ID` varchar(50) NOT NULL,
  `TERMINAL` varchar(5) NOT NULL,
  `TRNTYPE` varchar(50) NOT NULL,
  `FULLUTILIZE` smallint(6) DEFAULT NULL,
  `CRDATE` datetime DEFAULT NULL,
  `M_USER_CR` varchar(50) NOT NULL,
  `M_USER_MD` varchar(50) NOT NULL,
  `MDDATE` datetime DEFAULT NULL,
  `REFNO` varchar(100) DEFAULT NULL,
  `REFNO2` varchar(100) DEFAULT NULL,
  `REFNOTE` longtext,
  `ISACTIVE` smallint(6) DEFAULT NULL,
  `TRNSTATE` varchar(2) DEFAULT NULL,
  `GRAMOUNT` double DEFAULT NULL,
  `NETDIS` double DEFAULT NULL,
  `NETAMOUNT` double DEFAULT NULL,
  `M_CUSTOMER_ID` varchar(50) DEFAULT NULL,
  `M_SUPPLIER_ID` varchar(50) DEFAULT NULL,
  `M_LOCATION_SOURCE` int(11) NOT NULL,
  `M_LOCATION_DEST` int(11) DEFAULT NULL,
  `EFT_DATE` datetime DEFAULT NULL,
  `REF_TRNNO` varchar(100) DEFAULT NULL,
  `CHANGE_AMT` double DEFAULT '0',
  PRIMARY KEY (`ID`,`TRNTYPE`,`TERMINAL`),
  KEY `FK_T_STOCKMST_M_CUSTOMER1_IDX` (`M_CUSTOMER_ID`),
  KEY `FK_T_STOCKMST_M_LOCATION1_IDX` (`M_LOCATION_SOURCE`),
  KEY `FK_T_STOCKMST_M_LOCATION2_IDX` (`M_LOCATION_DEST`),
  KEY `FK_T_STOCKMST_M_SUPPLIER1_IDX` (`M_SUPPLIER_ID`),
  KEY `FK_T_STOCKMST_M_USER1_IDX` (`M_USER_CR`),
  KEY `FK_T_STOCKMST_M_USER2_IDX` (`M_USER_MD`),
  KEY `FK_T_STOCKMST_U_TRANSACTIONS1_IDX` (`TRNTYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.t_stockmst: ~0 rows (approximately)

-- Dumping structure for table bizdb.t_stockpayments
DROP TABLE IF EXISTS `t_stockpayments`;
CREATE TABLE IF NOT EXISTS `t_stockpayments` (
  `ID` int(11) NOT NULL,
  `T_STOCKMST_ID` varchar(50) NOT NULL,
  `TERMINAL` varchar(5) NOT NULL,
  `TRNTYP` varchar(5) DEFAULT NULL,
  `REFNO` varchar(45) DEFAULT NULL,
  `FRMAMOUNT` double DEFAULT NULL,
  `AMOUNT` double DEFAULT NULL,
  `CHANGE_AMT` double DEFAULT NULL,
  `PAYDETID` varchar(5) NOT NULL,
  `PAYHEDID` varchar(5) NOT NULL,
  `EFT_DATE` datetime DEFAULT NULL,
  `UTILIZED` int(11) DEFAULT '1',
  KEY `FK_T_STOCKPAYMENTS_M_PAYDET1_IDX` (`PAYDETID`,`PAYHEDID`),
  KEY `FK_T_STOCKPAYMENTS_T_STOCKMST1_IDX` (`T_STOCKMST_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.t_stockpayments: ~0 rows (approximately)

-- Dumping structure for table bizdb.user_permitions
DROP TABLE IF EXISTS `user_permitions`;
CREATE TABLE IF NOT EXISTS `user_permitions` (
  `M_USERGROUP_ID` int(11) NOT NULL,
  `M_PERMISSIONS_ID` varchar(50) NOT NULL,
  `M_PERMISSIONS_PARENTID` varchar(50) NOT NULL,
  `ACCESSTYPE` varchar(5) DEFAULT NULL,
  KEY `USER_PERMITIONS_FK_M_USERGROUP_HAS_M_PERMISSIONS_M_PERMISSIONS1` (`M_PERMISSIONS_ID`,`M_PERMISSIONS_PARENTID`),
  KEY `USER_PERMITIONS_FK_M_USERGROUP_HAS_M_PERMISSIONS_M_USERGROUP1_2` (`M_USERGROUP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.user_permitions: ~66 rows (approximately)
REPLACE INTO `user_permitions` (`M_USERGROUP_ID`, `M_PERMISSIONS_ID`, `M_PERMISSIONS_PARENTID`, `ACCESSTYPE`) VALUES
	(0, 'A00000', 'A00000', 'null'),
	(0, 'A00001', 'A00000', 'null'),
	(0, 'M00000', 'M00000', 'null'),
	(0, 'M00001', 'M00000', 'null'),
	(0, 'M00002', 'M00000', 'null'),
	(0, 'M00003', 'M00000', 'null'),
	(0, 'M00004', 'M00000', 'null'),
	(0, 'M00005', 'M00000', 'null'),
	(0, 'M00006', 'M00000', 'null'),
	(0, 'M00007', 'M00000', 'null'),
	(0, 'M00011', 'M00000', 'null'),
	(0, 'M00012', 'M00000', 'null'),
	(0, 'M00013', 'M00000', 'null'),
	(0, 'M00014', 'M00000', 'null'),
	(0, 'M00015', 'M00000', 'null'),
	(0, 'M00016', 'M00000', 'null'),
	(0, 'M00017', 'M00000', 'null'),
	(0, 'M00018', 'M00000', 'null'),
	(0, 'M00019', 'M00000', 'null'),
	(0, 'P00000', 'P00000', 'null'),
	(0, 'P00001', 'P00000', 'null'),
	(0, 'P00002', 'P00000', 'null'),
	(0, 'P00003', 'P00000', 'null'),
	(0, 'P00004', 'P00000', 'null'),
	(0, 'P00005', 'P00000', 'null'),
	(0, 'P00006', 'P00000', 'null'),
	(0, 'P00007', 'P00000', 'null'),
	(0, 'P00008', 'P00000', 'null'),
	(0, 'P00009', 'P00000', 'null'),
	(0, 'P00010', 'P00000', 'null'),
	(0, 'P00011', 'P00000', 'null'),
	(0, 'P00012', 'P00000', 'null'),
	(0, 'P00013', 'P00000', 'null'),
	(0, 'P00014', 'P00000', 'null'),
	(0, 'P00015', 'P00000', 'null'),
	(0, 'P00016', 'P00000', 'null'),
	(0, 'P00017', 'P00000', 'null'),
	(0, 'P00018', 'P00000', 'null'),
	(0, 'P00019', 'P00000', 'null'),
	(0, 'P00020', 'P00000', 'null'),
	(0, 'P00021', 'P00000', 'null'),
	(0, 'P00022', 'P00000', 'null'),
	(0, 'P00023', 'P00000', 'null'),
	(0, 'P00024', 'P00000', 'null'),
	(0, 'P00025', 'P00000', 'null'),
	(0, 'P00026', 'P00000', 'null'),
	(0, 'R00000', 'R00000', 'null'),
	(0, 'R00001', 'R00000', 'null'),
	(0, 'R00002', 'R00001', 'null'),
	(0, 'R00003', 'R00001', 'null'),
	(0, 'R00004', 'R00001', 'null'),
	(0, 'R00005', 'R00001', 'null'),
	(0, 'R00101', 'R00000', 'null'),
	(0, 'R00102', 'R00101', 'null'),
	(0, 'S00000', 'S00000', 'null'),
	(0, 'S00001', 'S00000', 'null'),
	(0, 'S00002', 'S00000', 'null'),
	(0, 'S00003', 'S00000', 'null'),
	(0, 'S00004', 'S00000', 'null'),
	(0, 'S00005', 'S00000', 'null'),
	(0, 'T00000', 'T00000', 'null'),
	(0, 'T00001', 'T00000', 'null'),
	(0, 'T00002', 'T00000', 'null'),
	(0, 'U00000', 'U00000', 'null'),
	(0, 'U00001', 'U00000', 'null'),
	(0, 'U00002', 'U00000', 'null');

-- Dumping structure for table bizdb.u_reports
DROP TABLE IF EXISTS `u_reports`;
CREATE TABLE IF NOT EXISTS `u_reports` (
  `RPT_ID` varchar(50) NOT NULL,
  `RPT_NAME` varchar(100) NOT NULL,
  `RPT_PATH` varchar(200) NOT NULL,
  `RPT_EN_LOC` int(11) NOT NULL DEFAULT '0',
  `RPT_EN_CUS` int(11) NOT NULL DEFAULT '0',
  `RPT_EN_SUP` int(11) NOT NULL DEFAULT '0',
  `RPT_EN_DATE_RANGE` int(11) NOT NULL DEFAULT '0',
  `RPT_EN_DATE_AS_AT` int(11) NOT NULL DEFAULT '0',
  `RPT_EN_DATE_QUATER` int(11) NOT NULL DEFAULT '0',
  `RPT_EN_GRP` int(11) NOT NULL DEFAULT '0',
  `RPT_ACTIVE` int(11) NOT NULL DEFAULT '1',
  `RPT_SUBREPORT_PATH` varchar(200) NOT NULL DEFAULT '',
  PRIMARY KEY (`RPT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.u_reports: ~5 rows (approximately)
REPLACE INTO `u_reports` (`RPT_ID`, `RPT_NAME`, `RPT_PATH`, `RPT_EN_LOC`, `RPT_EN_CUS`, `RPT_EN_SUP`, `RPT_EN_DATE_RANGE`, `RPT_EN_DATE_AS_AT`, `RPT_EN_DATE_QUATER`, `RPT_EN_GRP`, `RPT_ACTIVE`, `RPT_SUBREPORT_PATH`) VALUES
	('R00002', 'INVOICE LISTING', 'Sales\\\\R00002\\\\Rpt_InvoiceListing.jrxml', 1, 0, 0, 1, 0, 0, 0, 1, 'Reports\\\\Sales\\\\R00002\\\\'),
	('R00003', 'PAYMODE WISE SALE', 'Sales\\\\R00003\\\\Rpt_SalesSummary.jrxml', 1, 0, 0, 1, 0, 0, 0, 1, 'Reports\\\\Sales\\\\R00003\\\\'),
	('R00004', 'SUPPLIER WISE SALE', 'Sales\\\\R00004\\\\Rpt_SupplierSale.jrxml', 1, 0, 1, 1, 0, 0, 0, 1, 'Reports\\\\Sales\\\\R00004\\\\'),
	('R00102', 'STOCK BALANCE', 'Stock\\\\R00102\\\\Rpt_StockBalance.jrxml', 1, 0, 0, 0, 0, 0, 1, 1, ''),
	('R00103', 'STOCK BALANCE - MUL UNITS', 'Stock\\\\R00102\\\\Rpt_StockBalance_MULUnits.jrxml', 1, 0, 0, 0, 0, 0, 1, 1, '');

-- Dumping structure for table bizdb.u_rpt_emails
DROP TABLE IF EXISTS `u_rpt_emails`;
CREATE TABLE IF NOT EXISTS `u_rpt_emails` (
  `ID` int(11) NOT NULL,
  `RPT_ID` varchar(50) NOT NULL,
  `EMAIL_ADD` varchar(200) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.u_rpt_emails: ~0 rows (approximately)

-- Dumping structure for table bizdb.u_setup
DROP TABLE IF EXISTS `u_setup`;
CREATE TABLE IF NOT EXISTS `u_setup` (
  `ID` int(11) NOT NULL,
  `COMSERIAL` varchar(50) DEFAULT NULL,
  `COMNAME` varchar(100) DEFAULT NULL,
  `CURLOC` int(11) DEFAULT NULL,
  `ADDNO` varchar(45) DEFAULT NULL,
  `ADD1` varchar(45) DEFAULT NULL,
  `ADD2` varchar(45) DEFAULT NULL,
  `ADD3` varchar(45) DEFAULT NULL,
  `STKMIN` smallint(6) DEFAULT NULL,
  `UITHEME` int(11) DEFAULT NULL,
  `UPDATE_VER` varchar(50) DEFAULT NULL,
  `BATCH_ENABLE` int(11) NOT NULL,
  `COM_IMG` varchar(100) DEFAULT '',
  `MYSQL_DUMP_PATH` varchar(500) DEFAULT '',
  `EMAIL_RPT_DAYS_BFR` int(11) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.u_setup: ~0 rows (approximately)
REPLACE INTO `u_setup` (`ID`, `COMSERIAL`, `COMNAME`, `CURLOC`, `ADDNO`, `ADD1`, `ADD2`, `ADD3`, `STKMIN`, `UITHEME`, `UPDATE_VER`, `BATCH_ENABLE`, `COM_IMG`, `MYSQL_DUMP_PATH`, `EMAIL_RPT_DAYS_BFR`) VALUES
	(1, '002', 'Nandana Hardware', 1, 'Wattala', '-', '-', '-', 1, 0, NULL, 0, '002.jpg', 'C:\\\\Program Files (x86)\\MySQL\\\\MySQL Server 5.5\\\\bin', 0);

-- Dumping structure for table bizdb.u_systhemes
DROP TABLE IF EXISTS `u_systhemes`;
CREATE TABLE IF NOT EXISTS `u_systhemes` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `URL` varchar(100) NOT NULL,
  `ACTIVE` smallint(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.u_systhemes: ~0 rows (approximately)

-- Dumping structure for table bizdb.u_terminals
DROP TABLE IF EXISTS `u_terminals`;
CREATE TABLE IF NOT EXISTS `u_terminals` (
  `LOC_ID` int(11) NOT NULL,
  `TERMINAL_ID` varchar(10) NOT NULL,
  `PRODUCTKEY` varchar(100) DEFAULT NULL,
  `SERIALKEY` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`LOC_ID`,`TERMINAL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.u_terminals: ~0 rows (approximately)

-- Dumping structure for table bizdb.u_transactions
DROP TABLE IF EXISTS `u_transactions`;
CREATE TABLE IF NOT EXISTS `u_transactions` (
  `TRNNO` varchar(50) NOT NULL,
  `TRNTYPE` varchar(5) DEFAULT NULL,
  `REFTRNTYPE` varchar(5) DEFAULT NULL,
  `REFNO` varchar(45) DEFAULT NULL,
  `REFNO2` varchar(45) DEFAULT NULL,
  `TRNDESC` varchar(50) DEFAULT NULL,
  `ACTIVE` smallint(6) DEFAULT NULL,
  `STOCKENTYP` int(11) DEFAULT NULL,
  `DEFPRICE` varchar(2) DEFAULT NULL,
  `LINEDIS` smallint(6) DEFAULT NULL,
  `LINEDISPER` smallint(6) DEFAULT NULL,
  `CUSTOMER` smallint(6) DEFAULT NULL,
  `SUPPLIER` smallint(6) DEFAULT NULL,
  `CPRICE` smallint(6) DEFAULT NULL,
  `SPRICE` smallint(6) DEFAULT NULL,
  `BATCHCREATE` smallint(6) DEFAULT NULL,
  `DATECHOOSER` smallint(6) DEFAULT NULL,
  `FUTUREDATE` smallint(6) DEFAULT NULL,
  `CHGDEFPRICE` smallint(6) DEFAULT NULL,
  `SOURCELOC` smallint(6) DEFAULT NULL,
  `DESTLOC` smallint(6) DEFAULT NULL,
  `PAYMENTS` smallint(6) DEFAULT NULL,
  `REPORT_PATH` varchar(100) DEFAULT NULL,
  `IS_POSTRN` int(11) NOT NULL DEFAULT '0',
  `DISPLAY_UNIT` int(11) NOT NULL DEFAULT '1',
  `PREV_REP` int(11) NOT NULL DEFAULT '1',
  `CANCEL_OPT` int(11) NOT NULL DEFAULT '0',
  `CANCEL_DAYS_WITH` int(11) NOT NULL DEFAULT '1',
  `SUP_PROD_ONLY` int(11) NOT NULL DEFAULT '0',
  `CHANGE_SPRICE` int(11) NOT NULL DEFAULT '0',
  `HOLD_ONLY` int(11) NOT NULL DEFAULT '0',
  `RETURN_REQ_REF` int(11) NOT NULL DEFAULT '0',
  `EN_SALESMAN` tinyint(4) DEFAULT '0',
  `RPT_ENABLE` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`TRNNO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bizdb.u_transactions: ~2 rows (approximately)
REPLACE INTO `u_transactions` (`TRNNO`, `TRNTYPE`, `REFTRNTYPE`, `REFNO`, `REFNO2`, `TRNDESC`, `ACTIVE`, `STOCKENTYP`, `DEFPRICE`, `LINEDIS`, `LINEDISPER`, `CUSTOMER`, `SUPPLIER`, `CPRICE`, `SPRICE`, `BATCHCREATE`, `DATECHOOSER`, `FUTUREDATE`, `CHGDEFPRICE`, `SOURCELOC`, `DESTLOC`, `PAYMENTS`, `REPORT_PATH`, `IS_POSTRN`, `DISPLAY_UNIT`, `PREV_REP`, `CANCEL_OPT`, `CANCEL_DAYS_WITH`, `SUP_PROD_ONLY`, `CHANGE_SPRICE`, `HOLD_ONLY`, `RETURN_REQ_REF`, `EN_SALESMAN`, `RPT_ENABLE`) VALUES
	('T00001', 'GRN', '', 'Supplier Inv No', '', 'GRN', 1, 1, 'C', 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, '', 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1),
	('T00002', 'INV', '', '', '', 'Invoice', 1, -1, 'S', 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 'INV//INV-58//TRpt_Default.jrxml', 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1);

-- Dumping structure for view bizdb.view_propropertise
DROP VIEW IF EXISTS `view_propropertise`;
-- Creating temporary table to overcome VIEW dependency errors
CREATE TABLE `view_propropertise` (
	`PROID` VARCHAR(100) NOT NULL COLLATE 'latin1_swedish_ci',
	`PRONAME` TEXT NULL COLLATE 'latin1_swedish_ci',
	`PROPNAME` VARCHAR(45) NULL COLLATE 'latin1_swedish_ci',
	`PROPVAL` VARCHAR(100) NULL COLLATE 'latin1_swedish_ci'
) ENGINE=MyISAM;

-- Dumping structure for view bizdb.view_trnfull
DROP VIEW IF EXISTS `view_trnfull`;
-- Creating temporary table to overcome VIEW dependency errors
CREATE TABLE `view_trnfull` (
	`ID` VARCHAR(50) NOT NULL COLLATE 'latin1_swedish_ci',
	`TRNTYPE` VARCHAR(50) NOT NULL COLLATE 'latin1_swedish_ci',
	`CRDATE` DATETIME NULL,
	`REFNO` VARCHAR(100) NULL COLLATE 'latin1_swedish_ci',
	`REFNO2` VARCHAR(100) NULL COLLATE 'latin1_swedish_ci',
	`GRAMOUNT` DOUBLE NULL,
	`NETDIS` DOUBLE NULL,
	`NETAMOUNT` DOUBLE NULL,
	`CUSNAME` VARCHAR(45) NULL COLLATE 'latin1_swedish_ci',
	`LOCNAME_DES` VARCHAR(45) NULL COLLATE 'latin1_swedish_ci',
	`SYMBLE` VARCHAR(5) NULL COLLATE 'latin1_swedish_ci',
	`LINEID` INT(11) NOT NULL,
	`PROID` VARCHAR(100) NOT NULL COLLATE 'latin1_swedish_ci',
	`SPRICE` DOUBLE NULL,
	`CPRICE` DOUBLE NULL,
	`QTY` DOUBLE NULL,
	`LDIS` DOUBLE NULL,
	`LDISPER` DOUBLE NULL,
	`AMOUNT` DOUBLE NULL,
	`PRONAME` LONGTEXT NOT NULL COLLATE 'latin1_swedish_ci',
	`BATCH_NO` VARCHAR(50) NULL COLLATE 'latin1_swedish_ci',
	`SUP_NAME` VARCHAR(100) NULL COLLATE 'latin1_swedish_ci',
	`CR_USER` VARCHAR(45) NULL COLLATE 'latin1_swedish_ci',
	`EFT_DATE` DATETIME NULL,
	`REF_TRNNO` VARCHAR(100) NULL COLLATE 'latin1_swedish_ci',
	`CHANGE_VAL` DOUBLE NOT NULL,
	`TRNSTATE` VARCHAR(2) NULL COLLATE 'latin1_swedish_ci',
	`LOCNAME_SOURCE` VARCHAR(45) NULL COLLATE 'latin1_swedish_ci',
	`MD_USER` VARCHAR(45) NULL COLLATE 'latin1_swedish_ci'
) ENGINE=MyISAM;

-- Dumping structure for view bizdb.view_trnpay
DROP VIEW IF EXISTS `view_trnpay`;
-- Creating temporary table to overcome VIEW dependency errors
CREATE TABLE `view_trnpay` (
	`PAYHED` VARCHAR(50) NULL COLLATE 'latin1_swedish_ci',
	`PAYDET` VARCHAR(45) NULL COLLATE 'latin1_swedish_ci',
	`FRMAMOUNT` DOUBLE NULL,
	`REFNO` VARCHAR(45) NULL COLLATE 'latin1_swedish_ci',
	`EFT_DATE` DATETIME NULL,
	`T_STOCKMST_ID` VARCHAR(50) NOT NULL COLLATE 'latin1_swedish_ci',
	`TRNTYP` VARCHAR(5) NULL COLLATE 'latin1_swedish_ci',
	`DATE_F` INT(11) NULL,
	`DATEF_DET` BIGINT(11) NOT NULL,
	`AMOUNT` DOUBLE NULL
) ENGINE=MyISAM;

-- Dumping structure for view bizdb.view_propropertise
DROP VIEW IF EXISTS `view_propropertise`;
-- Removing temporary table and create final VIEW structure
DROP TABLE IF EXISTS `view_propropertise`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `view_propropertise` AS select `m_products`.`ID` AS `PROID`,`m_products`.`NAME` AS `PRONAME`,`m_propertise`.`NAME` AS `PROPNAME`,`m_products_has_m_propertise`.`VALUE` AS `PROPVAL` from ((`m_products` join `m_products_has_m_propertise` on((`m_products`.`ID` = `m_products_has_m_propertise`.`M_PRODUCTS_ID`))) join `m_propertise` on((`m_products_has_m_propertise`.`M_PROPERTISE_ID` = `m_propertise`.`ID`)));

-- Dumping structure for view bizdb.view_trnfull
DROP VIEW IF EXISTS `view_trnfull`;
-- Removing temporary table and create final VIEW structure
DROP TABLE IF EXISTS `view_trnfull`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `view_trnfull` AS select `t_stockmst`.`ID` AS `ID`,`t_stockmst`.`TRNTYPE` AS `TRNTYPE`,`t_stockmst`.`CRDATE` AS `CRDATE`,`t_stockmst`.`REFNO` AS `REFNO`,`t_stockmst`.`REFNO2` AS `REFNO2`,`t_stockmst`.`GRAMOUNT` AS `GRAMOUNT`,`t_stockmst`.`NETDIS` AS `NETDIS`,`t_stockmst`.`NETAMOUNT` AS `NETAMOUNT`,`m_customer`.`NAME` AS `CUSNAME`,`m_location`.`NAME` AS `LOCNAME_DES`,`m_units`.`SYMBLE` AS `SYMBLE`,`t_stockline`.`LINEID` AS `LINEID`,`t_stockline`.`PROID` AS `PROID`,`t_stockline`.`SPRICE` AS `SPRICE`,`t_stockline`.`CPRICE` AS `CPRICE`,`t_stockline`.`QTY` AS `QTY`,`t_stockline`.`LDIS` AS `LDIS`,`t_stockline`.`LDISPER` AS `LDISPER`,`t_stockline`.`AMOUNT` AS `AMOUNT`,`t_stockline`.`PRONAME` AS `PRONAME`,`t_stockline`.`BATCH_NO` AS `BATCH_NO`,`m_supplier`.`NAME` AS `SUP_NAME`,`m_user`.`FIRSTNAME` AS `CR_USER`,`t_stockmst`.`EFT_DATE` AS `EFT_DATE`,`t_stockmst`.`REF_TRNNO` AS `REF_TRNNO`,ifnull(`t_stockmst`.`CHANGE_AMT`,0) AS `CHANGE_VAL`,`t_stockmst`.`TRNSTATE` AS `TRNSTATE`,`m_location_1`.`NAME` AS `LOCNAME_SOURCE`,`m_user_1`.`FIRSTNAME` AS `MD_USER` from ((((((((`t_stockline` join `t_stockmst` on(((`t_stockline`.`T_STOCKMST_ID` = `t_stockmst`.`ID`) and (`t_stockline`.`TRNTYP` = `t_stockmst`.`TRNTYPE`)))) join `m_user` on((`t_stockmst`.`M_USER_CR` = `m_user`.`ID`))) left join `m_customer` on((`t_stockmst`.`M_CUSTOMER_ID` = `m_customer`.`ID`))) left join `m_location` on((`t_stockmst`.`M_LOCATION_DEST` = `m_location`.`ID`))) left join `m_supplier` on((`t_stockmst`.`M_SUPPLIER_ID` = `m_supplier`.`ID`))) left join `m_units` on((`t_stockline`.`M_UNITS_ID` = `m_units`.`ID`))) left join `m_location` `m_location_1` on((`t_stockmst`.`M_LOCATION_SOURCE` = `m_location_1`.`ID`))) left join `m_user` `m_user_1` on((`t_stockmst`.`M_USER_MD` = `m_user_1`.`ID`)));

-- Dumping structure for view bizdb.view_trnpay
DROP VIEW IF EXISTS `view_trnpay`;
-- Removing temporary table and create final VIEW structure
DROP TABLE IF EXISTS `view_trnpay`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `view_trnpay` AS select `m_paymst`.`NAME` AS `PAYHED`,`m_paydet`.`NAME` AS `PAYDET`,`t_stockpayments`.`FRMAMOUNT` AS `FRMAMOUNT`,`t_stockpayments`.`REFNO` AS `REFNO`,`t_stockpayments`.`EFT_DATE` AS `EFT_DATE`,`t_stockpayments`.`T_STOCKMST_ID` AS `T_STOCKMST_ID`,`t_stockpayments`.`TRNTYP` AS `TRNTYP`,`m_paymst`.`DATE_F` AS `DATE_F`,ifnull(`m_paydet`.`DATE_F`,0) AS `DATEF_DET`,`t_stockpayments`.`AMOUNT` AS `AMOUNT` from ((`t_stockpayments` join `m_paymst` on((`t_stockpayments`.`PAYHEDID` = `m_paymst`.`ID`))) left join `m_paydet` on((`t_stockpayments`.`PAYDETID` = `m_paydet`.`ID`)));

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
