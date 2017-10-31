-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.62-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema bizdb
--

CREATE DATABASE IF NOT EXISTS bizdb;
USE bizdb;

--
-- Temporary table structure for view `view_propropertise`
--
DROP TABLE IF EXISTS `view_propropertise`;
DROP VIEW IF EXISTS `view_propropertise`;
CREATE TABLE `view_propropertise` (
  `PROID` varchar(100),
  `PRONAME` text,
  `PROPNAME` varchar(45),
  `PROPVAL` varchar(100)
);

--
-- Temporary table structure for view `view_trnfull`
--
DROP TABLE IF EXISTS `view_trnfull`;
DROP VIEW IF EXISTS `view_trnfull`;
CREATE TABLE `view_trnfull` (
  `ID` varchar(50),
  `TRNTYPE` varchar(50),
  `CRDATE` datetime,
  `REFNO` varchar(100),
  `REFNO2` varchar(100),
  `GRAMOUNT` double,
  `NETDIS` double,
  `NETAMOUNT` double,
  `CUSNAME` varchar(45),
  `LOCNAME_DES` varchar(45),
  `SYMBLE` varchar(5),
  `LINEID` int(11),
  `PROID` varchar(100),
  `SPRICE` double,
  `CPRICE` double,
  `QTY` double,
  `LDIS` double,
  `LDISPER` double,
  `AMOUNT` double,
  `PRONAME` longtext,
  `BATCH_NO` varchar(50),
  `SUP_NAME` varchar(100),
  `CR_USER` varchar(45),
  `EFT_DATE` datetime,
  `REF_TRNNO` varchar(100),
  `CHANGE_VAL` double,
  `TRNSTATE` varchar(2),
  `LOCNAME_SOURCE` varchar(45),
  `MD_USER` varchar(45)
);

--
-- Temporary table structure for view `view_trnpay`
--
DROP TABLE IF EXISTS `view_trnpay`;
DROP VIEW IF EXISTS `view_trnpay`;
CREATE TABLE `view_trnpay` (
  `PAYHED` varchar(50),
  `PAYDET` varchar(45),
  `FRMAMOUNT` double,
  `REFNO` varchar(45),
  `EFT_DATE` datetime,
  `T_STOCKMST_ID` varchar(50),
  `TRNTYP` varchar(5),
  `DATE_F` int(11),
  `DATEF_DET` bigint(11),
  `AMOUNT` double
);

--
-- Definition of table `m_customer`
--

DROP TABLE IF EXISTS `m_customer`;
CREATE TABLE `m_customer` (
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

--
-- Dumping data for table `m_customer`
--

/*!40000 ALTER TABLE `m_customer` DISABLE KEYS */;
INSERT INTO `m_customer` (`ID`,`NAME`,`ADDNO`,`ADD1`,`ADD2`,`ADD3`,`CONTACT`,`MOBILE`,`ACTIVE`) VALUES 
 ('00001','DEFAULT','-','-','-','-','-','-',1),
 ('C0002','BUWANEKA SUMANASEKARA','88/10/E','PILIYANDALA','MAVITHARA','PILIYANDALA','776161689','776161689',1);
/*!40000 ALTER TABLE `m_customer` ENABLE KEYS */;


--
-- Definition of table `m_giftvoucher`
--

DROP TABLE IF EXISTS `m_giftvoucher`;
CREATE TABLE `m_giftvoucher` (
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

--
-- Dumping data for table `m_giftvoucher`
--

/*!40000 ALTER TABLE `m_giftvoucher` DISABLE KEYS */;
INSERT INTO `m_giftvoucher` (`GV_NO`,`GRP_ID`,`VALUE`,`CR_LOC`,`CR_BY`,`CR_DATE`,`PUR_LOC`,`PUR_DATE`,`PUR_CRBY`,`PUR_REFNO`,`ACTIVE`,`ISPUR`,`GV_DES`) VALUES 
 ('170000000001','B0001',1000,1,'U0000','2017-03-11 21:47:47',1,'2017-03-12 19:15:55','U0000','1703000005',1,1,'gift'),
 ('170000000002','B0001',1000,1,'U0000','2017-03-11 21:47:47',NULL,NULL,NULL,NULL,1,0,'gift');
/*!40000 ALTER TABLE `m_giftvoucher` ENABLE KEYS */;


--
-- Definition of table `m_giftvoucher_group`
--

DROP TABLE IF EXISTS `m_giftvoucher_group`;
CREATE TABLE `m_giftvoucher_group` (
  `GRP_ID` varchar(50) NOT NULL,
  `GRP_NAME` varchar(100) NOT NULL,
  `GRP_STARTNO` varchar(100) NOT NULL,
  `GRP_ENDNO` varchar(100) NOT NULL,
  `GRP_QTY` int(11) NOT NULL DEFAULT '0',
  `GRP_ACTIVE` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`GRP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `m_giftvoucher_group`
--

/*!40000 ALTER TABLE `m_giftvoucher_group` DISABLE KEYS */;
INSERT INTO `m_giftvoucher_group` (`GRP_ID`,`GRP_NAME`,`GRP_STARTNO`,`GRP_ENDNO`,`GRP_QTY`,`GRP_ACTIVE`) VALUES 
 ('B0001','gift','170000000001','170000000003',2,1);
/*!40000 ALTER TABLE `m_giftvoucher_group` ENABLE KEYS */;


--
-- Definition of table `m_group1`
--

DROP TABLE IF EXISTS `m_group1`;
CREATE TABLE `m_group1` (
  `ID` varchar(5) NOT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `ACTIVE` smallint(6) DEFAULT NULL,
  `ISHIDDEN` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `m_group1`
--

/*!40000 ALTER TABLE `m_group1` DISABLE KEYS */;
INSERT INTO `m_group1` (`ID`,`NAME`,`ACTIVE`,`ISHIDDEN`) VALUES 
 ('G1000','NOT APPLICABLE',1,1),
 ('G1001','MENS',1,0),
 ('G1002','LADIES',1,0);
/*!40000 ALTER TABLE `m_group1` ENABLE KEYS */;


--
-- Definition of table `m_group2`
--

DROP TABLE IF EXISTS `m_group2`;
CREATE TABLE `m_group2` (
  `ID` varchar(5) NOT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `ACTIVE` smallint(6) DEFAULT NULL,
  `ISHIDDEN` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `m_group2`
--

/*!40000 ALTER TABLE `m_group2` DISABLE KEYS */;
INSERT INTO `m_group2` (`ID`,`NAME`,`ACTIVE`,`ISHIDDEN`) VALUES 
 ('G2000','NOT APPLICABLE',1,1),
 ('G2001','CASUAL',1,0),
 ('G2002','FORMAL',1,0);
/*!40000 ALTER TABLE `m_group2` ENABLE KEYS */;


--
-- Definition of table `m_group3`
--

DROP TABLE IF EXISTS `m_group3`;
CREATE TABLE `m_group3` (
  `ID` varchar(5) NOT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `ACTIVE` smallint(6) DEFAULT NULL,
  `ISHIDDEN` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `m_group3`
--

/*!40000 ALTER TABLE `m_group3` DISABLE KEYS */;
INSERT INTO `m_group3` (`ID`,`NAME`,`ACTIVE`,`ISHIDDEN`) VALUES 
 ('G3000','NOT APPLICABLE',1,1),
 ('G3001','SHIRT',1,0),
 ('G3002','BLOUSE',1,0),
 ('G3003','TROUSER',1,0),
 ('G3004','DENIM',1,0),
 ('G3005','SHORT',1,0);
/*!40000 ALTER TABLE `m_group3` ENABLE KEYS */;


--
-- Definition of table `m_group4`
--

DROP TABLE IF EXISTS `m_group4`;
CREATE TABLE `m_group4` (
  `ID` varchar(5) NOT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `ACTIVE` smallint(6) DEFAULT NULL,
  `ISHIDDEN` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `m_group4`
--

/*!40000 ALTER TABLE `m_group4` DISABLE KEYS */;
INSERT INTO `m_group4` (`ID`,`NAME`,`ACTIVE`,`ISHIDDEN`) VALUES 
 ('G4000','NOT APPLICABLE',1,1),
 ('G4001','EMERAL',1,0),
 ('G4002','VANTAGE',1,0),
 ('G4003','NILM',1,0),
 ('G4004','SIGNATURE',1,0),
 ('G4005','JEZZA',1,0),
 ('G4006','H&S',1,0),
 ('G4007','RONALD',1,0);
/*!40000 ALTER TABLE `m_group4` ENABLE KEYS */;


--
-- Definition of table `m_group5`
--

DROP TABLE IF EXISTS `m_group5`;
CREATE TABLE `m_group5` (
  `ID` varchar(5) NOT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `ACTIVE` smallint(6) DEFAULT NULL,
  `ISHIDDEN` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `m_group5`
--

/*!40000 ALTER TABLE `m_group5` DISABLE KEYS */;
INSERT INTO `m_group5` (`ID`,`NAME`,`ACTIVE`,`ISHIDDEN`) VALUES 
 ('G5000','NOT APPLICABLE',1,1),
 ('G5001','L/S [15]',1,0),
 ('G5002','S/S [15]',1,0),
 ('G5003','S',1,0),
 ('G5004','M',1,0),
 ('G5005','XL',1,0);
/*!40000 ALTER TABLE `m_group5` ENABLE KEYS */;


--
-- Definition of table `m_grouplink`
--

DROP TABLE IF EXISTS `m_grouplink`;
CREATE TABLE `m_grouplink` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `G1_ID` varchar(50) NOT NULL,
  `G2_ID` varchar(50) NOT NULL,
  `G3_ID` varchar(50) NOT NULL,
  `G4_ID` varchar(50) NOT NULL,
  `G5_ID` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `m_grouplink`
--

/*!40000 ALTER TABLE `m_grouplink` DISABLE KEYS */;
INSERT INTO `m_grouplink` (`ID`,`G1_ID`,`G2_ID`,`G3_ID`,`G4_ID`,`G5_ID`) VALUES 
 (3,'G1001','G2002','G3001','G4001','G5002'),
 (4,'G1001','G2002','G3001','G4001','G5001'),
 (5,'G1001','G2001','G3005','G4007','G5004'),
 (6,'G1002','G2001','G3002','G4006','G5004'),
 (7,'G1002','G2001','G3002','G4006','G5003');
/*!40000 ALTER TABLE `m_grouplink` ENABLE KEYS */;


--
-- Definition of table `m_location`
--

DROP TABLE IF EXISTS `m_location`;
CREATE TABLE `m_location` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `ACTIVE` smallint(6) DEFAULT NULL,
  `VISIBLE` smallint(6) DEFAULT NULL,
  `REFNO` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `m_location`
--

/*!40000 ALTER TABLE `m_location` DISABLE KEYS */;
INSERT INTO `m_location` (`ID`,`NAME`,`ACTIVE`,`VISIBLE`,`REFNO`) VALUES 
 (1,'COLOMBO',1,1,'HO');
/*!40000 ALTER TABLE `m_location` ENABLE KEYS */;


--
-- Definition of table `m_paydet`
--

DROP TABLE IF EXISTS `m_paydet`;
CREATE TABLE `m_paydet` (
  `ID` varchar(5) NOT NULL,
  `M_PAYMST_ID` varchar(5) NOT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `RATE` double DEFAULT NULL,
  `SHORT_NAME` varchar(50) DEFAULT NULL,
  `SEQ_ORDER` int(11) DEFAULT '0',
  `ACTIVE` int(11) DEFAULT '1',
  `REF_REQ` int(11) DEFAULT '0',
  `DATE_F` int(11) DEFAULT '0',
  KEY `FK_M_PAYDET_M_PAYMST1_IDX` (`M_PAYMST_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `m_paydet`
--

/*!40000 ALTER TABLE `m_paydet` DISABLE KEYS */;
INSERT INTO `m_paydet` (`ID`,`M_PAYMST_ID`,`NAME`,`RATE`,`SHORT_NAME`,`SEQ_ORDER`,`ACTIVE`,`REF_REQ`,`DATE_F`) VALUES 
 ('VISA','CRC','VISA',0,'VISA',0,1,1,0),
 ('MAST','CRC','MASTER',0,'MASTER',1,1,1,0);
/*!40000 ALTER TABLE `m_paydet` ENABLE KEYS */;


--
-- Definition of table `m_paymst`
--

DROP TABLE IF EXISTS `m_paymst`;
CREATE TABLE `m_paymst` (
  `ID` varchar(5) NOT NULL,
  `NAME` varchar(50) DEFAULT NULL,
  `HASDET` smallint(6) DEFAULT NULL,
  `REFREQ` smallint(6) DEFAULT NULL,
  `SEQ_ORDER` int(11) DEFAULT '0',
  `SHORT_NAME` varchar(50) DEFAULT NULL,
  `ACTIVE` int(11) DEFAULT '1',
  `OVER_PAY` int(11) DEFAULT '0',
  `DATE_F` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `m_paymst`
--

/*!40000 ALTER TABLE `m_paymst` DISABLE KEYS */;
INSERT INTO `m_paymst` (`ID`,`NAME`,`HASDET`,`REFREQ`,`SEQ_ORDER`,`SHORT_NAME`,`ACTIVE`,`OVER_PAY`,`DATE_F`) VALUES 
 ('CSH','CASH',0,0,0,'CASH',1,1,0),
 ('CRC','CREDIT CARD',1,0,1,'CRD CARD',1,0,0),
 ('CHQ','CHEQUE',0,1,2,'CHEQUE',1,0,1),
 ('VOU','VOUCHER',0,1,3,'VOUCHER',1,0,0);
/*!40000 ALTER TABLE `m_paymst` ENABLE KEYS */;


--
-- Definition of table `m_permissions`
--

DROP TABLE IF EXISTS `m_permissions`;
CREATE TABLE `m_permissions` (
  `ID` varchar(50) NOT NULL,
  `PARENTID` varchar(50) NOT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `DESCRIPTION` longtext,
  `TYPE` varchar(10) DEFAULT NULL,
  `HASSUB` smallint(6) DEFAULT NULL,
  `ISUIMENU` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`ID`,`PARENTID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `m_permissions`
--

/*!40000 ALTER TABLE `m_permissions` DISABLE KEYS */;
INSERT INTO `m_permissions` (`ID`,`PARENTID`,`NAME`,`DESCRIPTION`,`TYPE`,`HASSUB`,`ISUIMENU`) VALUES 
 ('A00000','A00000','ACCOUNTS','Accounts/Payments','ACC',1,1),
 ('A00001','A00000','ACHQ','Cheque Payments','ACHQ',1,1),
 ('M00000','M00000','MASTER','Master Files','MAST',1,1),
 ('M00001','M00000','LOCATIONS','Locations','LOC',0,1),
 ('M00002','M00000','GROUP1','Category','GROUP',0,1),
 ('M00003','M00000','GROUP2','Sub Category','GROUP',0,1),
 ('M00004','M00000','GROUP3','Type','GROUP',0,1),
 ('M00005','M00000','GROUP4','Brand','GROUP',0,1),
 ('M00006','M00000','GROUP5','Model','GROUP',0,1),
 ('M00007','M00000','UNITS','Unit Master','UNITS',0,1),
 ('M00008','M00000','ITEMS','Item Maser','ITEMS',0,1),
 ('M00009','M00000','SUP','Supplier','SUP',0,1),
 ('M00010','M00000','CUS','Customer','CUS',0,1),
 ('M00011','M00000','GROUPMAP','Group Map','GRPM',0,1),
 ('M00012','M00000','UGRP','Unit Group','UGRP',0,1),
 ('M00013','M00000','GVCRE','Gift Voucher Creation','GVCRE',0,1),
 ('M00014','M00000','GVSTA','Gift Voucher Status','GVSTA',0,1),
 ('P00000','P00000','GEN_PER','General Permissions','GEN_PER',1,0),
 ('P00001','P00000','P1','Login','GEN_PER',0,0),
 ('P00002','P00000','P2','Logout','GEN_PER',0,0),
 ('P00003','P00000','P3','Location Create','GEN_PER',0,0),
 ('P00004','P00000','P4','Location Update','GEN_PER',0,0),
 ('P00005','P00000','P5','Group Creation','GEN_PER',0,0),
 ('P00006','P00000','P6','Group Update','GEN_PER',0,0),
 ('P00007','P00000','P7','Unit Creation','GEN_PER',0,0),
 ('P00008','P00000','P8','Unit Update','GEN_PER',0,0),
 ('P00009','P00000','P9','Item Creation','GEN_PER',0,0),
 ('P00010','P00000','P10','Item Update','GEN_PER',0,0),
 ('P00011','P00000','P11','Supplier Create','GEN_PER',0,0),
 ('P00012','P00000','P12','Supplier Update','GEN_PER',0,0),
 ('P00013','P00000','P13','Customer Create','GEN_PER',0,0),
 ('P00014','P00000','P14','Customer Update','GEN_PER',0,0),
 ('P00015','P00000','P15','Group Map Create','GEN_PER',0,0),
 ('P00016','P00000','P16','Group Map Update','GEN_PER',0,0),
 ('P00017','P00000','P17','Unit Map Create','GEN_PER',0,0),
 ('P00018','P00000','P18','Unit Map Update','GEN_PER',0,0),
 ('P00019','P00000','P19','Cheque Payment Update State','GEN_PER',0,0),
 ('P00020','P00000','P20','Cheque Payment Special Update(Re-Assign)','GEN_PER',0,0),
 ('P00021','P00000','P21','Gift voucher purchase','GEN_PER',0,0),
 ('P00022','P00000','P22','Gift voucher redeem','GEN_PER',0,0),
 ('S00000','S00000','SECURITY','Security','SECUR',1,1),
 ('S00001','S00000','SEC_UC','User Creation','SUC',0,1),
 ('S00002','S00000','SEC_GP','Group Permission','SGP',0,1),
 ('S00003','S00000','SEC_US','User Security','SUS',0,1),
 ('T00000','T00000','TRANSACTIONS','Transactions','TRN',1,1),
 ('T00001','T00000','T_GRN','Goods Receive Note','TRN',0,1),
 ('T00002','T00000','T_INV','Invoice','TRN',0,1);
/*!40000 ALTER TABLE `m_permissions` ENABLE KEYS */;


--
-- Definition of table `m_products`
--

DROP TABLE IF EXISTS `m_products`;
CREATE TABLE `m_products` (
  `ID` varchar(100) NOT NULL,
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
  KEY `FK_M_PRODUCTS_M_GROUP11_IDX` (`M_GROUP1_ID`),
  KEY `FK_M_PRODUCTS_M_GROUP21_IDX` (`M_GROUP2_ID`),
  KEY `FK_M_PRODUCTS_M_GROUP31_IDX` (`M_GROUP3_ID`),
  KEY `FK_M_PRODUCTS_M_GROUP41_IDX` (`M_GROUP4_ID`),
  KEY `FK_M_PRODUCTS_M_GROUP51_IDX` (`M_GROUP5_ID`),
  KEY `FK_M_PRODUCTS_M_UNITGROUPS1_IDX` (`M_UNITGROUPS_ID`),
  KEY `FK_M_PRODUCTS_M_USER1_IDX` (`CRUSER`),
  KEY `FK_M_PRODUCTS_M_USER2_IDX` (`MDUSER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `m_products`
--

/*!40000 ALTER TABLE `m_products` DISABLE KEYS */;
INSERT INTO `m_products` (`ID`,`NAME`,`PRINTDES`,`ACTIVE`,`BATCH`,`CRDATE`,`CRUSER`,`MDDATE`,`MDUSER`,`M_GROUP1_ID`,`M_GROUP2_ID`,`M_GROUP3_ID`,`M_GROUP4_ID`,`M_GROUP5_ID`,`REF1`,`REF2`,`M_UNITGROUPS_ID`) VALUES 
 ('000001','MENS CASUAL SHORT RONALD M','MENS CASUAL SHORT RONALD M',1,0,'2017-02-26 19:48:37','U0000','2017-02-26 19:48:37','U0000','G1001','G2001','G3005','G4007','G5004','','','UG001'),
 ('000002','LADIES CASUAL BLOUSE H&S M','LADIES CASUAL BLOUSE H&S M',1,0,'2017-02-26 19:49:22','U0000','2017-02-26 19:49:22','U0000','G1002','G2001','G3002','G4006','G5004','','','UG001'),
 ('000003','MENS FORMAL SHIRT EMERAL L/S [15]','MENS FORMAL SHIRT EMERAL L/S [15]',1,0,'2017-02-26 19:49:49','U0000','2017-02-26 19:49:49','U0000','G1001','G2002','G3001','G4001','G5001','','','UG001');
/*!40000 ALTER TABLE `m_products` ENABLE KEYS */;


--
-- Definition of table `m_products_has_m_propertise`
--

DROP TABLE IF EXISTS `m_products_has_m_propertise`;
CREATE TABLE `m_products_has_m_propertise` (
  `M_PRODUCTS_ID` varchar(50) NOT NULL,
  `M_PROPERTISE_ID` int(11) NOT NULL,
  `VALUE` varchar(100) DEFAULT NULL,
  KEY `FK_M_PRODUCTS_HAS_M_PROPERTISE_M_PRODUCTS1_IDX` (`M_PRODUCTS_ID`),
  KEY `FK_M_PRODUCTS_HAS_M_PROPERTISE_M_PROPERTISE1_IDX` (`M_PROPERTISE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `m_products_has_m_propertise`
--

/*!40000 ALTER TABLE `m_products_has_m_propertise` DISABLE KEYS */;
/*!40000 ALTER TABLE `m_products_has_m_propertise` ENABLE KEYS */;


--
-- Definition of table `m_propdatatype`
--

DROP TABLE IF EXISTS `m_propdatatype`;
CREATE TABLE `m_propdatatype` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `FORMAT` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `m_propdatatype`
--

/*!40000 ALTER TABLE `m_propdatatype` DISABLE KEYS */;
INSERT INTO `m_propdatatype` (`ID`,`NAME`,`FORMAT`) VALUES 
 (1,'NUM',''),
 (2,'TEXT',''),
 (3,'DATE',''),
 (4,'EXPDATE','YY-MM-DD'),
 (5,'WARRENTY','YY-MM-DD');
/*!40000 ALTER TABLE `m_propdatatype` ENABLE KEYS */;


--
-- Definition of table `m_propertise`
--

DROP TABLE IF EXISTS `m_propertise`;
CREATE TABLE `m_propertise` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `ACTIVE` smallint(6) DEFAULT NULL,
  `M_PROPDATATYPE_ID` int(11) NOT NULL,
  KEY `FK_M_PROPERTISE_M_PROPDATATYPE1_IDX` (`M_PROPDATATYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `m_propertise`
--

/*!40000 ALTER TABLE `m_propertise` DISABLE KEYS */;
INSERT INTO `m_propertise` (`ID`,`NAME`,`ACTIVE`,`M_PROPDATATYPE_ID`) VALUES 
 (1,'COLOUR',1,2),
 (2,'WARRENTY',1,5);
/*!40000 ALTER TABLE `m_propertise` ENABLE KEYS */;


--
-- Definition of table `m_stocks`
--

DROP TABLE IF EXISTS `m_stocks`;
CREATE TABLE `m_stocks` (
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
  KEY `FK_M_STOCKS_M_LOCATION1_IDX` (`M_LOCATION_ID`),
  KEY `FK_M_STOCKS_M_PRODUCTS1_IDX` (`M_PRODUCTS_ID`),
  KEY `FK_M_STOCKS_M_UNITS1_IDX` (`M_UNITS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `m_stocks`
--

/*!40000 ALTER TABLE `m_stocks` DISABLE KEYS */;
INSERT INTO `m_stocks` (`M_LOCATION_ID`,`M_PRODUCTS_ID`,`BATCHNO`,`COSTP`,`SELLP`,`CRDATE`,`M_UNITS_ID`,`SIH`,`MARKUP`,`ACTIVE`) VALUES 
 (1,'000001','0001',600,1200,'2017-02-26 19:50:23','U0001',-1,0,1),
 (1,'000002','0001',650,1200,'2017-02-26 19:49:22','U0001',0,0,1),
 (1,'000003','0001',500,1200,'2017-02-26 20:28:18','U0001',-1,0,1);
/*!40000 ALTER TABLE `m_stocks` ENABLE KEYS */;


--
-- Definition of table `m_supplier`
--

DROP TABLE IF EXISTS `m_supplier`;
CREATE TABLE `m_supplier` (
  `ID` varchar(50) NOT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `CONTACTPERSON` varchar(15) DEFAULT NULL,
  `CONTACT` varchar(15) DEFAULT NULL,
  `MOBILE` varchar(15) DEFAULT NULL,
  `ACTIVE` smallint(6) DEFAULT NULL,
  `ADDRESS` longtext
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `m_supplier`
--

/*!40000 ALTER TABLE `m_supplier` DISABLE KEYS */;
INSERT INTO `m_supplier` (`ID`,`NAME`,`CONTACTPERSON`,`CONTACT`,`MOBILE`,`ACTIVE`,`ADDRESS`) VALUES 
 ('S0001','DEFAUL','A','0112618884','0776161689',1,'-'),
 ('S0002','TEST','BUWA','1233','111',1,'SSS');
/*!40000 ALTER TABLE `m_supplier` ENABLE KEYS */;


--
-- Definition of table `m_supplier_has_m_products`
--

DROP TABLE IF EXISTS `m_supplier_has_m_products`;
CREATE TABLE `m_supplier_has_m_products` (
  `M_SUPPLIER_ID` varchar(50) NOT NULL,
  `M_PRODUCTS_ID` varchar(50) NOT NULL,
  `ACTIVE` smallint(6) DEFAULT NULL,
  KEY `FK_M_SUPPLIER_HAS_M_PRODUCTS_M_PRODUCTS1_IDX` (`M_PRODUCTS_ID`),
  KEY `FK_M_SUPPLIER_HAS_M_PRODUCTS_M_SUPPLIER1_IDX` (`M_SUPPLIER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `m_supplier_has_m_products`
--

/*!40000 ALTER TABLE `m_supplier_has_m_products` DISABLE KEYS */;
INSERT INTO `m_supplier_has_m_products` (`M_SUPPLIER_ID`,`M_PRODUCTS_ID`,`ACTIVE`) VALUES 
 ('S0001','P00001',1),
 ('S0001','P00002',1),
 ('S0001','P00003',1),
 ('S0001','P00004',1),
 ('S0001','000002',1);
/*!40000 ALTER TABLE `m_supplier_has_m_products` ENABLE KEYS */;


--
-- Definition of table `m_unitgroups`
--

DROP TABLE IF EXISTS `m_unitgroups`;
CREATE TABLE `m_unitgroups` (
  `ID` varchar(50) NOT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `ACTIVE` smallint(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `m_unitgroups`
--

/*!40000 ALTER TABLE `m_unitgroups` DISABLE KEYS */;
INSERT INTO `m_unitgroups` (`ID`,`NAME`,`ACTIVE`) VALUES 
 ('UG001','NO',1);
/*!40000 ALTER TABLE `m_unitgroups` ENABLE KEYS */;


--
-- Definition of table `m_unitgroups_has_m_units`
--

DROP TABLE IF EXISTS `m_unitgroups_has_m_units`;
CREATE TABLE `m_unitgroups_has_m_units` (
  `M_UNITGROUPS_ID` varchar(50) NOT NULL,
  `M_UNITS_ID` varchar(50) NOT NULL,
  `VOLUME` float(24,0) DEFAULT NULL,
  `ACTIVE` smallint(6) DEFAULT NULL,
  `BASEUNIT` smallint(6) DEFAULT NULL,
  KEY `FK_M_UNITGROUPS_HAS_M_UNITS_M_UNITS1_IDX` (`M_UNITS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `m_unitgroups_has_m_units`
--

/*!40000 ALTER TABLE `m_unitgroups_has_m_units` DISABLE KEYS */;
INSERT INTO `m_unitgroups_has_m_units` (`M_UNITGROUPS_ID`,`M_UNITS_ID`,`VOLUME`,`ACTIVE`,`BASEUNIT`) VALUES 
 ('UG001','U0001',1,1,1);
/*!40000 ALTER TABLE `m_unitgroups_has_m_units` ENABLE KEYS */;


--
-- Definition of table `m_units`
--

DROP TABLE IF EXISTS `m_units`;
CREATE TABLE `m_units` (
  `ID` varchar(50) NOT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `ACTIVE` smallint(6) DEFAULT NULL,
  `SYMBLE` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `m_units`
--

/*!40000 ALTER TABLE `m_units` DISABLE KEYS */;
INSERT INTO `m_units` (`ID`,`NAME`,`ACTIVE`,`SYMBLE`) VALUES 
 ('U0001','NO',1,'NO');
/*!40000 ALTER TABLE `m_units` ENABLE KEYS */;


--
-- Definition of table `m_user`
--

DROP TABLE IF EXISTS `m_user`;
CREATE TABLE `m_user` (
  `ID` varchar(50) NOT NULL,
  `FIRSTNAME` varchar(45) DEFAULT NULL,
  `LASTNAME` varchar(45) DEFAULT NULL,
  `IMGURL` varchar(100) DEFAULT NULL,
  `UGRUID` int(11) NOT NULL,
  `ACTIVE` smallint(6) DEFAULT NULL,
  `LOCID` int(11) NOT NULL,
  `VISIBLE` smallint(6) DEFAULT NULL,
  KEY `FK_M_USER_M_LOCATION1_IDX` (`LOCID`),
  KEY `FK_M_USER_M_USERGROUP1_IDX` (`UGRUID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `m_user`
--

/*!40000 ALTER TABLE `m_user` DISABLE KEYS */;
INSERT INTO `m_user` (`ID`,`FIRSTNAME`,`LASTNAME`,`IMGURL`,`UGRUID`,`ACTIVE`,`LOCID`,`VISIBLE`) VALUES 
 ('U0000','SUPER','ADMIN','-',1,1,1,0);
/*!40000 ALTER TABLE `m_user` ENABLE KEYS */;


--
-- Definition of table `m_usergroup`
--

DROP TABLE IF EXISTS `m_usergroup`;
CREATE TABLE `m_usergroup` (
  `ID` int(11) NOT NULL,
  `GROUPNAME` varchar(45) DEFAULT NULL,
  `ACTIVE` smallint(6) DEFAULT NULL,
  `VISIBLE` smallint(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `m_usergroup`
--

/*!40000 ALTER TABLE `m_usergroup` DISABLE KEYS */;
INSERT INTO `m_usergroup` (`ID`,`GROUPNAME`,`ACTIVE`,`VISIBLE`) VALUES 
 (1,'SUPER ADMIN',1,0),
 (2,'ADMIN',1,1);
/*!40000 ALTER TABLE `m_usergroup` ENABLE KEYS */;


--
-- Definition of table `m_usersecurity`
--

DROP TABLE IF EXISTS `m_usersecurity`;
CREATE TABLE `m_usersecurity` (
  `ID` int(11) NOT NULL,
  `USERNAME` varchar(45) DEFAULT NULL,
  `PASSWORD` varchar(45) DEFAULT NULL,
  `UID` varchar(50) NOT NULL,
  KEY `FK_M_USERSECURITY_M_USER_IDX` (`UID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `m_usersecurity`
--

/*!40000 ALTER TABLE `m_usersecurity` DISABLE KEYS */;
INSERT INTO `m_usersecurity` (`ID`,`USERNAME`,`PASSWORD`,`UID`) VALUES 
 (1,'ADMIN','ÃËÝÅÉÓÐÖ','U0000');
/*!40000 ALTER TABLE `m_usersecurity` ENABLE KEYS */;


--
-- Definition of table `t_chqpayments`
--

DROP TABLE IF EXISTS `t_chqpayments`;
CREATE TABLE `t_chqpayments` (
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

--
-- Dumping data for table `t_chqpayments`
--

/*!40000 ALTER TABLE `t_chqpayments` DISABLE KEYS */;
INSERT INTO `t_chqpayments` (`CHQ_NO`,`CHQ_DATE`,`STATE`,`REFNO`,`REFTRNTYP`,`CUS_ID`,`SUP_ID`,`AMOUNT`,`M_USER_CR`,`CRDATE`,`M_USER_MD`,`MDDATE`) VALUES 
 ('4567','2017-02-20 00:00:00','U','1702000015','INV','C0002',NULL,1000,'U0000','2017-02-10 11:32:03','U0000','2017-02-13 00:00:00');
/*!40000 ALTER TABLE `t_chqpayments` ENABLE KEYS */;


--
-- Definition of table `t_gvredeem`
--

DROP TABLE IF EXISTS `t_gvredeem`;
CREATE TABLE `t_gvredeem` (
  `NO` int(11) NOT NULL,
  `GV_NO` varchar(100) NOT NULL,
  `RED_VAL` double NOT NULL DEFAULT '0',
  `RED_LOC` int(11) NOT NULL,
  `RED_CRBY` varchar(50) NOT NULL,
  `RED_REFNO` varchar(100) NOT NULL,
  PRIMARY KEY (`NO`,`GV_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `t_gvredeem`
--

/*!40000 ALTER TABLE `t_gvredeem` DISABLE KEYS */;
INSERT INTO `t_gvredeem` (`NO`,`GV_NO`,`RED_VAL`,`RED_LOC`,`RED_CRBY`,`RED_REFNO`) VALUES 
 (1,'170000000001',1000,1,'U0000','1703000006');
/*!40000 ALTER TABLE `t_gvredeem` ENABLE KEYS */;


--
-- Definition of table `t_phystkdet`
--

DROP TABLE IF EXISTS `t_phystkdet`;
CREATE TABLE `t_phystkdet` (
  `ID` int(11) NOT NULL,
  `T_PHYSTKMST_ID` varchar(50) NOT NULL,
  `SYSQTY` double DEFAULT NULL,
  `PHYQTY` double DEFAULT NULL,
  `CPRICE` double DEFAULT NULL,
  `SPRICE` double DEFAULT NULL,
  `PROID` varchar(100) NOT NULL,
  `M_UNITS_ID` varchar(50) NOT NULL,
  `M_UNITGROUPS_ID` varchar(50) NOT NULL,
  KEY `FK_T_PHYSTKDET_M_UNITGROUPS1_IDX` (`M_UNITGROUPS_ID`),
  KEY `FK_T_PHYSTKDET_M_UNITS1_IDX` (`M_UNITS_ID`),
  KEY `FK_T_PHYSTKDET_T_PHYSTKMST1_IDX` (`T_PHYSTKMST_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `t_phystkdet`
--

/*!40000 ALTER TABLE `t_phystkdet` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_phystkdet` ENABLE KEYS */;


--
-- Definition of table `t_phystkmst`
--

DROP TABLE IF EXISTS `t_phystkmst`;
CREATE TABLE `t_phystkmst` (
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

--
-- Dumping data for table `t_phystkmst`
--

/*!40000 ALTER TABLE `t_phystkmst` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_phystkmst` ENABLE KEYS */;


--
-- Definition of table `t_stockline`
--

DROP TABLE IF EXISTS `t_stockline`;
CREATE TABLE `t_stockline` (
  `T_STOCKMST_ID` varchar(50) NOT NULL,
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
  `TRNTYP` varchar(5) DEFAULT NULL,
  `ISGV` tinyint(4) DEFAULT '0',
  KEY `FK_T_STOCKLINE_M_UNITGROUPS1_IDX` (`M_UNITGROUPS_ID`),
  KEY `FK_T_STOCKLINE_M_UNITS1_IDX` (`M_UNITS_ID`),
  KEY `FK_T_STOCKLINE_T_STOCKMST1_IDX` (`T_STOCKMST_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `t_stockline`
--

/*!40000 ALTER TABLE `t_stockline` DISABLE KEYS */;
INSERT INTO `t_stockline` (`T_STOCKMST_ID`,`LINEID`,`PROID`,`SPRICE`,`CPRICE`,`QTY`,`LDIS`,`LDISPER`,`AMOUNT`,`M_UNITS_ID`,`M_UNITGROUPS_ID`,`PRONAME`,`BATCH_NO`,`TRNTYP`,`ISGV`) VALUES 
 ('1702000001',1,'000001',1200,600,1,0,0,1200,'U0001','UG001','MENS CASUAL SHORT RONALD M','0001','INV',0),
 ('1702000002',1,'000003',1200,500,1,0,0,1200,'U0001','UG001','MENS FORMAL SHIRT EMERAL L/S [15]','0001','INV',0),
 ('1703000005',1,'170000000001',1000,0,1,0,0,1000,'U0001','UG001','gift','null','INV',1),
 ('1703000005',2,'000002',1200,650,1,0,0,1200,'U0001','UG001','LADIES CASUAL BLOUSE H&S M','','INV',0),
 ('1703000006',1,'000003',1200,500,1,0,0,1200,'U0001','UG001','MENS FORMAL SHIRT EMERAL L/S [15]','','INV',0);
/*!40000 ALTER TABLE `t_stockline` ENABLE KEYS */;


--
-- Definition of table `t_stockmst`
--

DROP TABLE IF EXISTS `t_stockmst`;
CREATE TABLE `t_stockmst` (
  `ID` varchar(50) NOT NULL,
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
  PRIMARY KEY (`ID`,`TRNTYPE`),
  KEY `FK_T_STOCKMST_M_CUSTOMER1_IDX` (`M_CUSTOMER_ID`),
  KEY `FK_T_STOCKMST_M_LOCATION1_IDX` (`M_LOCATION_SOURCE`),
  KEY `FK_T_STOCKMST_M_LOCATION2_IDX` (`M_LOCATION_DEST`),
  KEY `FK_T_STOCKMST_M_SUPPLIER1_IDX` (`M_SUPPLIER_ID`),
  KEY `FK_T_STOCKMST_M_USER1_IDX` (`M_USER_CR`),
  KEY `FK_T_STOCKMST_M_USER2_IDX` (`M_USER_MD`),
  KEY `FK_T_STOCKMST_U_TRANSACTIONS1_IDX` (`TRNTYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `t_stockmst`
--

/*!40000 ALTER TABLE `t_stockmst` DISABLE KEYS */;
INSERT INTO `t_stockmst` (`ID`,`TRNTYPE`,`FULLUTILIZE`,`CRDATE`,`M_USER_CR`,`M_USER_MD`,`MDDATE`,`REFNO`,`REFNO2`,`REFNOTE`,`ISACTIVE`,`TRNSTATE`,`GRAMOUNT`,`NETDIS`,`NETAMOUNT`,`M_CUSTOMER_ID`,`M_SUPPLIER_ID`,`M_LOCATION_SOURCE`,`M_LOCATION_DEST`,`EFT_DATE`,`REF_TRNNO`,`CHANGE_AMT`) VALUES 
 ('1702000001','INV',1,'2017-02-26 19:50:23','U0000','U0000','2017-02-26 19:50:23','','','',1,'H',1200,0,1200,'00001','',1,0,'2017-02-26 19:50:23','',NULL),
 ('1702000002','INV',1,'2017-02-26 20:28:18','U0000','U0000','2017-02-26 20:28:18','','','',1,'H',1200,0,1200,'00001','',1,0,'2017-02-26 20:28:18','',NULL),
 ('1703000003','INV',1,'2017-03-12 18:05:40','U0000','U0000','2017-03-12 18:05:40','','','',1,'P',3400,0,3400,'00001','',1,0,'2017-03-12 18:05:40','',0),
 ('1703000005','INV',1,'2017-03-12 19:15:55','U0000','U0000','2017-03-12 19:15:55','','','',1,'P',2200,0,2200,'00001','',1,0,'2017-03-12 19:15:55','',0),
 ('1703000006','INV',1,'2017-03-12 21:13:58','U0000','U0000','2017-03-12 21:13:58','','','',1,'P',1200,0,1200,'00001','',1,0,'2017-03-12 21:13:58','',0);
/*!40000 ALTER TABLE `t_stockmst` ENABLE KEYS */;


--
-- Definition of table `t_stockpayments`
--

DROP TABLE IF EXISTS `t_stockpayments`;
CREATE TABLE `t_stockpayments` (
  `ID` int(11) NOT NULL,
  `T_STOCKMST_ID` varchar(50) NOT NULL,
  `REFNO` varchar(45) DEFAULT NULL,
  `FRMAMOUNT` double DEFAULT NULL,
  `AMOUNT` double DEFAULT NULL,
  `CHANGE_AMT` double DEFAULT NULL,
  `PAYDETID` varchar(5) NOT NULL,
  `PAYHEDID` varchar(5) NOT NULL,
  `EFT_DATE` datetime DEFAULT NULL,
  `TRNTYP` varchar(5) DEFAULT NULL,
  `UTILIZED` int(11) DEFAULT '1',
  KEY `FK_T_STOCKPAYMENTS_M_PAYDET1_IDX` (`PAYDETID`,`PAYHEDID`),
  KEY `FK_T_STOCKPAYMENTS_T_STOCKMST1_IDX` (`T_STOCKMST_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `t_stockpayments`
--

/*!40000 ALTER TABLE `t_stockpayments` DISABLE KEYS */;
INSERT INTO `t_stockpayments` (`ID`,`T_STOCKMST_ID`,`REFNO`,`FRMAMOUNT`,`AMOUNT`,`CHANGE_AMT`,`PAYDETID`,`PAYHEDID`,`EFT_DATE`,`TRNTYP`,`UTILIZED`) VALUES 
 (0,'1703000005','',2200,2200,0,'','CSH','2017-03-12 00:00:00','INV',1),
 (0,'1703000006','170000000001',1000,1000,0,'','VOU','2017-03-12 00:00:00','INV',1),
 (1,'1703000006','',200,200,0,'','CSH','2017-03-12 00:00:00','INV',1);
/*!40000 ALTER TABLE `t_stockpayments` ENABLE KEYS */;


--
-- Definition of table `u_setup`
--

DROP TABLE IF EXISTS `u_setup`;
CREATE TABLE `u_setup` (
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
  `BATCH_ENABLE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `u_setup`
--

/*!40000 ALTER TABLE `u_setup` DISABLE KEYS */;
INSERT INTO `u_setup` (`ID`,`COMSERIAL`,`COMNAME`,`CURLOC`,`ADDNO`,`ADD1`,`ADD2`,`ADD3`,`STKMIN`,`UITHEME`,`UPDATE_VER`,`BATCH_ENABLE`) VALUES 
 (1,'00','TEST',1,'-','-','-','-',1,0,NULL,0);
/*!40000 ALTER TABLE `u_setup` ENABLE KEYS */;


--
-- Definition of table `u_systhemes`
--

DROP TABLE IF EXISTS `u_systhemes`;
CREATE TABLE `u_systhemes` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `URL` varchar(100) NOT NULL,
  `ACTIVE` smallint(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `u_systhemes`
--

/*!40000 ALTER TABLE `u_systhemes` DISABLE KEYS */;
/*!40000 ALTER TABLE `u_systhemes` ENABLE KEYS */;


--
-- Definition of table `u_terminals`
--

DROP TABLE IF EXISTS `u_terminals`;
CREATE TABLE `u_terminals` (
  `LOC_ID` int(11) NOT NULL,
  `TERMINAL_ID` varchar(10) NOT NULL,
  `PRODUCTKEY` varchar(100) DEFAULT NULL,
  `SERIALKEY` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`LOC_ID`,`TERMINAL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `u_terminals`
--

/*!40000 ALTER TABLE `u_terminals` DISABLE KEYS */;
/*!40000 ALTER TABLE `u_terminals` ENABLE KEYS */;


--
-- Definition of table `u_transactions`
--

DROP TABLE IF EXISTS `u_transactions`;
CREATE TABLE `u_transactions` (
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
  `DISPLAY_UNIT` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `u_transactions`
--

/*!40000 ALTER TABLE `u_transactions` DISABLE KEYS */;
INSERT INTO `u_transactions` (`TRNNO`,`TRNTYPE`,`REFTRNTYPE`,`REFNO`,`REFNO2`,`TRNDESC`,`ACTIVE`,`STOCKENTYP`,`DEFPRICE`,`LINEDIS`,`LINEDISPER`,`CUSTOMER`,`SUPPLIER`,`CPRICE`,`SPRICE`,`BATCHCREATE`,`DATECHOOSER`,`FUTUREDATE`,`CHGDEFPRICE`,`SOURCELOC`,`DESTLOC`,`PAYMENTS`,`REPORT_PATH`,`IS_POSTRN`,`DISPLAY_UNIT`) VALUES 
 ('T00001','GRN','','','','Goods Recive Note',1,1,'C',0,0,0,1,1,1,1,1,0,1,1,0,0,'',0,1),
 ('T00002','INV','','','','Invoice',1,-1,'S',1,1,1,0,0,1,0,0,0,0,1,0,1,'INV//TRpt_Default.jrxml',1,0);
/*!40000 ALTER TABLE `u_transactions` ENABLE KEYS */;


--
-- Definition of table `user_permitions`
--

DROP TABLE IF EXISTS `user_permitions`;
CREATE TABLE `user_permitions` (
  `M_USERGROUP_ID` int(11) NOT NULL,
  `M_PERMISSIONS_ID` varchar(50) NOT NULL,
  `M_PERMISSIONS_PARENTID` varchar(50) NOT NULL,
  `ACCESSTYPE` varchar(5) DEFAULT NULL,
  KEY `USER_PERMITIONS_FK_M_USERGROUP_HAS_M_PERMISSIONS_M_PERMISSIONS1` (`M_PERMISSIONS_ID`,`M_PERMISSIONS_PARENTID`),
  KEY `USER_PERMITIONS_FK_M_USERGROUP_HAS_M_PERMISSIONS_M_USERGROUP1_2` (`M_USERGROUP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_permitions`
--

/*!40000 ALTER TABLE `user_permitions` DISABLE KEYS */;
INSERT INTO `user_permitions` (`M_USERGROUP_ID`,`M_PERMISSIONS_ID`,`M_PERMISSIONS_PARENTID`,`ACCESSTYPE`) VALUES 
 (1,'M00000','M00000','A'),
 (1,'M00001','M00000','A'),
 (1,'M00002','M00000','A'),
 (1,'M00003','M00000','A'),
 (1,'M00004','M00000','A'),
 (1,'M00005','M00000','A'),
 (1,'M00006','M00000','A'),
 (1,'M00007','M00000','A'),
 (1,'M00008','M00000','A'),
 (1,'M00009','M00000','A'),
 (1,'M00010','M00000','A'),
 (1,'M00011','M00000','A'),
 (1,'M00012','M00000','A'),
 (1,'T00000','T00000','A'),
 (1,'T00001','T00000','A'),
 (1,'T00002','T00000','null'),
 (1,'S00000','S00000','null'),
 (1,'S00001','S00000','null'),
 (1,'S00002','S00000','null'),
 (1,'S00003','S00000','null'),
 (1,'A00000','A00000','null'),
 (1,'A00001','A00000','null'),
 (1,'P00000','P00000','null'),
 (1,'P00001','P00000','null'),
 (1,'P00002','P00000','null'),
 (1,'P00003','P00000','null'),
 (1,'P00004','P00000','null'),
 (1,'P00005','P00000','null'),
 (1,'P00006','P00000','null'),
 (1,'P00007','P00000','null'),
 (1,'P00008','P00000','null'),
 (1,'P00009','P00000','null'),
 (1,'P00010','P00000','null'),
 (1,'P00011','P00000','null'),
 (1,'P00012','P00000','null'),
 (1,'P00013','P00000','null'),
 (1,'P00014','P00000','null'),
 (1,'P00015','P00000','null'),
 (1,'P00016','P00000','null'),
 (1,'P00017','P00000','null'),
 (1,'P00018','P00000','null'),
 (1,'P00019','P00000','null'),
 (1,'P00020','P00000','null'),
 (1,'M00013','M00000','null'),
 (1,'M00014','M00000','null'),
 (1,'P00021','P00000','null'),
 (1,'P00022','P00000','null');
/*!40000 ALTER TABLE `user_permitions` ENABLE KEYS */;


--
-- Definition of view `view_propropertise`
--

DROP TABLE IF EXISTS `view_propropertise`;
DROP VIEW IF EXISTS `view_propropertise`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_propropertise` AS select `m_products`.`ID` AS `PROID`,`m_products`.`NAME` AS `PRONAME`,`m_propertise`.`NAME` AS `PROPNAME`,`m_products_has_m_propertise`.`VALUE` AS `PROPVAL` from ((`m_products` join `m_products_has_m_propertise` on((`m_products`.`ID` = `m_products_has_m_propertise`.`M_PRODUCTS_ID`))) join `m_propertise` on((`m_products_has_m_propertise`.`M_PROPERTISE_ID` = `m_propertise`.`ID`)));

--
-- Definition of view `view_trnfull`
--

DROP TABLE IF EXISTS `view_trnfull`;
DROP VIEW IF EXISTS `view_trnfull`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_trnfull` AS select `t_stockmst`.`ID` AS `ID`,`t_stockmst`.`TRNTYPE` AS `TRNTYPE`,`t_stockmst`.`CRDATE` AS `CRDATE`,`t_stockmst`.`REFNO` AS `REFNO`,`t_stockmst`.`REFNO2` AS `REFNO2`,`t_stockmst`.`GRAMOUNT` AS `GRAMOUNT`,`t_stockmst`.`NETDIS` AS `NETDIS`,`t_stockmst`.`NETAMOUNT` AS `NETAMOUNT`,`m_customer`.`NAME` AS `CUSNAME`,`m_location`.`NAME` AS `LOCNAME_DES`,`m_units`.`SYMBLE` AS `SYMBLE`,`t_stockline`.`LINEID` AS `LINEID`,`t_stockline`.`PROID` AS `PROID`,`t_stockline`.`SPRICE` AS `SPRICE`,`t_stockline`.`CPRICE` AS `CPRICE`,`t_stockline`.`QTY` AS `QTY`,`t_stockline`.`LDIS` AS `LDIS`,`t_stockline`.`LDISPER` AS `LDISPER`,`t_stockline`.`AMOUNT` AS `AMOUNT`,`t_stockline`.`PRONAME` AS `PRONAME`,`t_stockline`.`BATCH_NO` AS `BATCH_NO`,`m_supplier`.`NAME` AS `SUP_NAME`,`m_user`.`FIRSTNAME` AS `CR_USER`,`t_stockmst`.`EFT_DATE` AS `EFT_DATE`,`t_stockmst`.`REF_TRNNO` AS `REF_TRNNO`,ifnull(`t_stockmst`.`CHANGE_AMT`,0) AS `CHANGE_VAL`,`t_stockmst`.`TRNSTATE` AS `TRNSTATE`,`m_location_1`.`NAME` AS `LOCNAME_SOURCE`,`m_user_1`.`FIRSTNAME` AS `MD_USER` from ((((((((`t_stockline` join `t_stockmst` on(((`t_stockline`.`T_STOCKMST_ID` = `t_stockmst`.`ID`) and (`t_stockline`.`TRNTYP` = `t_stockmst`.`TRNTYPE`)))) join `m_user` on((`t_stockmst`.`M_USER_CR` = `m_user`.`ID`))) left join `m_customer` on((`t_stockmst`.`M_CUSTOMER_ID` = `m_customer`.`ID`))) left join `m_location` on((`t_stockmst`.`M_LOCATION_DEST` = `m_location`.`ID`))) left join `m_supplier` on((`t_stockmst`.`M_SUPPLIER_ID` = `m_supplier`.`ID`))) left join `m_units` on((`t_stockline`.`M_UNITS_ID` = `m_units`.`ID`))) left join `m_location` `m_location_1` on((`t_stockmst`.`M_LOCATION_SOURCE` = `m_location_1`.`ID`))) left join `m_user` `m_user_1` on((`t_stockmst`.`M_USER_MD` = `m_user_1`.`ID`)));

--
-- Definition of view `view_trnpay`
--

DROP TABLE IF EXISTS `view_trnpay`;
DROP VIEW IF EXISTS `view_trnpay`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_trnpay` AS select `m_paymst`.`NAME` AS `PAYHED`,`m_paydet`.`NAME` AS `PAYDET`,`t_stockpayments`.`FRMAMOUNT` AS `FRMAMOUNT`,`t_stockpayments`.`REFNO` AS `REFNO`,`t_stockpayments`.`EFT_DATE` AS `EFT_DATE`,`t_stockpayments`.`T_STOCKMST_ID` AS `T_STOCKMST_ID`,`t_stockpayments`.`TRNTYP` AS `TRNTYP`,`m_paymst`.`DATE_F` AS `DATE_F`,ifnull(`m_paydet`.`DATE_F`,0) AS `DATEF_DET`,`t_stockpayments`.`AMOUNT` AS `AMOUNT` from ((`t_stockpayments` join `m_paymst` on((`t_stockpayments`.`PAYHEDID` = `m_paymst`.`ID`))) left join `m_paydet` on((`t_stockpayments`.`PAYDETID` = `m_paydet`.`ID`)));



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
