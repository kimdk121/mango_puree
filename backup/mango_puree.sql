/*M!999999\- enable the sandbox mode */ 
-- MariaDB dump 10.19-11.7.2-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: mango_puree
-- ------------------------------------------------------
-- Server version	11.7.2-MariaDB-ubu2404

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*M!100616 SET @OLD_NOTE_VERBOSITY=@@NOTE_VERBOSITY, NOTE_VERBOSITY=0 */;

--
-- Table structure for table `business`
--

DROP TABLE IF EXISTS `business`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `business` (
  `business_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '사업자아이디',
  `business_name` varchar(50) NOT NULL COMMENT '상호명',
  `representative_name` varchar(50) NOT NULL COMMENT '대표자명',
  `registration_number` varchar(20) NOT NULL COMMENT '사업자등록번호',
  `address` varchar(400) NOT NULL COMMENT '주소',
  `tel_no` varchar(20) NOT NULL COMMENT '전화번호',
  `fax_no` varchar(20) DEFAULT NULL COMMENT '팩스번호',
  `business_type` varchar(50) DEFAULT NULL COMMENT '업태',
  `industry_type` varchar(50) DEFAULT NULL COMMENT '종목',
  `reg_id` bigint(20) DEFAULT NULL COMMENT '등록자',
  `reg_dt` datetime DEFAULT current_timestamp() COMMENT '등록일시',
  PRIMARY KEY (`business_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `business`
--

LOCK TABLES `business` WRITE;
/*!40000 ALTER TABLE `business` DISABLE KEYS */;
INSERT INTO `business` VALUES
(1,'망고퓨레 본사','김동균','010-31-72784','서울특별시 강남구 본사로 1길','031-101-1010','031-101-1011','유통','식품',1,'2025-04-01 14:29:55'),
(2,'망고퓨레 지사','김동균','010-31-72784','부산광역시 해운대구 지사로 2길','031-101-1015','031-102-1022','유통','식품',1,'2025-04-01 14:29:55');
/*!40000 ALTER TABLE `business` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `code`
--

DROP TABLE IF EXISTS `code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `code` (
  `code_id` varchar(20) NOT NULL COMMENT '코드아이디',
  `code_group_id` varchar(20) NOT NULL COMMENT '코드그룹아이디',
  `code_name` varchar(50) NOT NULL COMMENT '코드명',
  `code_value` varchar(50) NOT NULL COMMENT '코드값',
  `order_index` int(11) NOT NULL COMMENT '순번',
  `use_yn` tinyint(1) NOT NULL COMMENT '사용여부',
  `reg_id` bigint(20) DEFAULT NULL COMMENT '등록자',
  `reg_dt` datetime DEFAULT current_timestamp() COMMENT '등록일시',
  PRIMARY KEY (`code_id`),
  KEY `code_code_group_id_IDX` (`code_group_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `code`
--

LOCK TABLES `code` WRITE;
/*!40000 ALTER TABLE `code` DISABLE KEYS */;
INSERT INTO `code` VALUES
('ESS001','ESTIMATE_STATUS','임시저장','TEMP',1,1,1,'2025-04-01 08:48:45'),
('ESS002','ESTIMATE_STATUS','작성완료','DONE',2,1,1,'2025-04-01 08:48:45'),
('ESS003','ESTIMATE_STATUS','확정','CONFIRMED',3,1,1,'2025-04-01 08:48:45'),
('UNT001','UNIT','개','EA',1,1,1,'2025-04-01 14:04:49'),
('UNT002','UNIT','박스','BOX',2,1,1,'2025-04-01 14:04:49'),
('UNT003','UNIT','킬로그램','KG',3,1,1,'2025-04-01 14:04:49'),
('VAD001','VALID_DATE','15일','15',1,1,1,'2025-04-01 08:48:45'),
('VAD002','VALID_DATE','30일','30',2,1,1,'2025-04-01 08:48:45'),
('VAD003','VALID_DATE','60일','60',3,1,1,'2025-04-01 08:48:45');
/*!40000 ALTER TABLE `code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `code_group`
--

DROP TABLE IF EXISTS `code_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `code_group` (
  `code_group_id` varchar(20) NOT NULL COMMENT '코드그룹아이디',
  `code_group_name` varchar(50) NOT NULL COMMENT '코드그룹명',
  `reg_id` bigint(20) DEFAULT NULL COMMENT '등록자',
  `reg_dt` datetime DEFAULT current_timestamp() COMMENT '등록일시',
  PRIMARY KEY (`code_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `code_group`
--

LOCK TABLES `code_group` WRITE;
/*!40000 ALTER TABLE `code_group` DISABLE KEYS */;
INSERT INTO `code_group` VALUES
('ESTIMATE_STATUS','견적서상태',1,'2025-04-01 08:44:50'),
('UNIT','단위',1,'2025-04-01 14:03:18'),
('VALID_DATE','유효기간',1,'2025-04-01 08:44:50');
/*!40000 ALTER TABLE `code_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estimate`
--

DROP TABLE IF EXISTS `estimate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `estimate` (
  `estimate_id` varchar(20) NOT NULL COMMENT '견적서아이디',
  `estimate_date` date DEFAULT NULL COMMENT '견적일자',
  `valid_date_cd` varchar(10) DEFAULT NULL COMMENT '유효기간코드',
  `estimate_status_cd` varchar(10) NOT NULL COMMENT '상태코드',
  `manager_id` bigint(20) DEFAULT NULL COMMENT '담당자아이디',
  `manager_name` varchar(50) DEFAULT NULL COMMENT '담당자명',
  `manager_tel_no` varchar(20) DEFAULT NULL COMMENT '담당자전화번호',
  `manager_fax_no` varchar(20) DEFAULT NULL COMMENT '담당자팩스번호',
  `vendor_id` bigint(20) DEFAULT NULL COMMENT '거래처아이디',
  `vendor_name` varchar(50) DEFAULT NULL COMMENT '거래처명',
  `vendor_tel_no` varchar(20) DEFAULT NULL COMMENT '거래처전화번호',
  `vendor_fax_no` varchar(20) DEFAULT NULL COMMENT '거래처팩스번호',
  `business_id` bigint(20) DEFAULT NULL COMMENT '사업자아이디',
  `business_name` varchar(50) DEFAULT NULL COMMENT '사업자명',
  `representative_name` varchar(50) DEFAULT NULL COMMENT '대표자명',
  `registration_number` varchar(20) DEFAULT NULL COMMENT '사업자등록번호',
  `business_address` varchar(400) DEFAULT NULL COMMENT '사업자주소',
  `business_tel_no` varchar(20) DEFAULT NULL COMMENT '사업자전화번호',
  `business_fax_no` varchar(20) DEFAULT NULL COMMENT '사업자팩스번호',
  `business_type` varchar(50) DEFAULT NULL COMMENT '업태',
  `industry_type` varchar(50) DEFAULT NULL COMMENT '종목',
  `remark` text DEFAULT NULL COMMENT '비고',
  `reg_id` bigint(20) DEFAULT NULL COMMENT '등록자',
  `reg_dt` datetime DEFAULT current_timestamp() COMMENT '등록일시',
  `upd_id` bigint(20) DEFAULT NULL COMMENT '수정자',
  `upd_dt` datetime DEFAULT NULL COMMENT '수정일시',
  PRIMARY KEY (`estimate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estimate`
--

LOCK TABLES `estimate` WRITE;
/*!40000 ALTER TABLE `estimate` DISABLE KEYS */;
INSERT INTO `estimate` VALUES
('EST25040700007','2025-04-15','VAD002','ESS003',1,'관리자','010-1010-1010','02-1010-1010',6,'이이 식품','051-051-4779','053-973-6140',2,'망고퓨레 지사','김동균','010-31-72784','부산광역시 해운대구 지사로 2길','031-101-1015','031-102-1022','유통','식품','qqq',1,'2025-04-07 15:33:53',1,'2025-04-10 01:03:21'),
('EST25040800001','2025-04-15','VAD002','ESS002',NULL,'관리자','010-1010-1010','02-1010-1010',NULL,'이이 식품','051-051-4779','053-973-6140',NULL,'망고퓨레 지사','김동균','010-31-72784','부산광역시 해운대구 지사로 2길','031-101-1015','031-102-1022','유통','식품','qqq',1,'2025-04-08 00:45:12',1,'2025-04-09 16:10:05'),
('EST25042600001','2025-04-08','VAD002','ESS002',1,'관리자','010-1010-1010','02-1010-1010',6,'이이 식품','051-051-4779','053-973-6140',2,'망고퓨레 지사','김동균','010-31-72784','부산광역시 해운대구 지사로 2길','031-101-1015','031-102-1022','유통','식품','qq',9,'2025-04-26 02:30:50',1,'2025-04-29 01:06:39'),
('EST25042900001','2025-04-29','VAD002','ESS003',1,'관리자','010-1010-1012','02-1010-1012',2,'주식회사 김 식품','061-524-9619','041-292-1253',1,'망고퓨레 본사','김동균','010-31-72784','서울특별시 강남구 본사로 1길','031-101-1010','031-101-1011','유통','식품','비비고',1,'2025-04-29 06:28:52',1,'2025-04-29 06:28:58'),
('EST25050400001','2025-05-21','VAD001','ESS002',1,'관리자','010-1010-1012','02-1010-1012',5,'(주) 남 식품','016-143-8981','064-746-9661',1,'망고퓨레 본사','김동균','010-31-72784','서울특별시 강남구 본사로 1길','031-101-1010','031-101-1011','유통','식품','',1,'2025-05-04 00:01:25',NULL,NULL),
('EST25101300001','2025-10-13','VAD002','ESS003',9,'사용자','010-1010-1010','010-1010-1010',5,'(주) 남 식품','016-143-8981','064-746-9661',2,'망고퓨레 지사','김동균','010-31-72784','부산광역시 해운대구 지사로 2길','031-101-1015','031-102-1022','유통','식품','',1,'2025-10-13 07:35:33',1,'2025-10-13 07:35:52');
/*!40000 ALTER TABLE `estimate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estimate_item`
--

DROP TABLE IF EXISTS `estimate_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `estimate_item` (
  `estimate_id` varchar(20) NOT NULL COMMENT '견적서아이디',
  `item_id` varchar(20) NOT NULL COMMENT '품목아이디',
  `item_name` varchar(50) NOT NULL COMMENT '품목명',
  `unit_cd` varchar(10) DEFAULT NULL COMMENT '단위코드',
  `due_date` date DEFAULT NULL COMMENT '납기일자',
  `price` int(11) DEFAULT NULL COMMENT '단가',
  `quantity` int(11) DEFAULT NULL COMMENT '수량',
  `supply_amount` int(11) DEFAULT NULL COMMENT '공급가액',
  `vat_amount` int(11) DEFAULT NULL COMMENT '부가세',
  `total_amount` int(11) DEFAULT NULL COMMENT '총액',
  `reg_id` bigint(20) DEFAULT NULL COMMENT '등록자',
  `reg_dt` datetime DEFAULT current_timestamp() COMMENT '등록일시',
  PRIMARY KEY (`estimate_id`,`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estimate_item`
--

LOCK TABLES `estimate_item` WRITE;
/*!40000 ALTER TABLE `estimate_item` DISABLE KEYS */;
INSERT INTO `estimate_item` VALUES
('EST25040700007','FOOD000004','간장','UNT001','2025-04-15',7800,50,390000,39000,429000,1,'2025-04-07 15:33:53'),
('EST25040700007','FOOD000005','참기름','UNT003','2025-04-23',8500,100,850000,85000,935000,1,'2025-04-07 15:33:53'),
('EST25040800001','FOOD000006','들기름','UNT001','2025-04-17',8100,50,405000,40500,445500,NULL,'2025-04-09 16:10:05'),
('EST25042600001','FOOD000004','간장','UNT001','2025-04-16',7800,60,468000,46800,514800,1,'2025-04-29 01:06:39'),
('EST25042600001','FOOD000005','참기름','UNT003','2025-04-17',8500,50,425000,42500,467500,1,'2025-04-29 01:06:39'),
('EST25042600001','FOOD000008','우동','UNT001','2025-04-17',2500,100,250000,25000,275000,1,'2025-04-29 01:06:39'),
('EST25042600001','FOOD000009','떡볶이','UNT001','2025-04-17',7500,250,1875000,187500,2062500,1,'2025-04-29 01:06:39'),
('EST25042900001','FOOD000001','김치','UNT001','2025-04-30',7000,300,2100000,210000,2310000,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000002','된장','UNT001','2025-04-30',5000,150,750000,75000,825000,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000003','고추장','UNT001','2025-04-30',4500,110,495000,49500,544500,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000004','간장','UNT001','2025-04-30',7800,150,1170000,117000,1287000,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000005','참기름','UNT003','2025-04-30',8500,90,765000,76500,841500,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000006','들기름','UNT001','2025-04-30',8100,100,810000,81000,891000,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000007','라면','UNT001','2025-04-30',2000,80,160000,16000,176000,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000008','우동','UNT001','2025-04-30',2500,70,175000,17500,192500,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000009','떡볶이','UNT001','2025-04-30',7500,66,495000,49500,544500,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000010','햄','UNT003','2025-04-30',4500,45,202500,20250,222750,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000011','김','UNT001','2025-04-30',3600,40,144000,14400,158400,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000012','쌀','UNT001','2025-04-30',7300,50,365000,36500,401500,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000013','보리','UNT003','2025-04-30',5600,30,168000,16800,184800,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000014','현미','UNT002','2025-04-30',8900,200,1780000,178000,1958000,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000015','콩나물','UNT001','2025-04-30',5800,10,58000,5800,63800,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000016','두부','UNT001','2025-04-30',9800,250,2450000,245000,2695000,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000017','순두부','UNT002','2025-04-30',6100,110,671000,67100,738100,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000018','소금','UNT001','2025-04-30',8800,90,792000,79200,871200,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000019','설탕','UNT002','2025-04-30',3500,80,280000,28000,308000,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000020','식초','UNT002','2025-04-30',2300,150,345000,34500,379500,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000021','마요네즈','UNT001','2025-04-30',2100,100,210000,21000,231000,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000022','케첩','UNT003','2025-04-30',2900,40,116000,11600,127600,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000023','버터','UNT001','2025-04-30',1600,10,16000,1600,17600,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000024','잼','UNT001','2025-04-30',7800,90,702000,70200,772200,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000025','치즈','UNT002','2025-04-30',9800,80,784000,78400,862400,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000026','요구르트','UNT003','2025-04-30',4300,60,258000,25800,283800,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000027','우유','UNT001','2025-04-30',5500,150,825000,82500,907500,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000028','요거트','UNT001','2025-04-30',5000,300,1500000,150000,1650000,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000029','계란','UNT003','2025-04-30',6500,110,715000,71500,786500,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000030','닭가슴살','UNT003','2025-04-30',3500,90,315000,31500,346500,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000031','사과','UNT002','2025-04-30',4400,150,660000,66000,726000,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000032','바나나','UNT003','2025-04-30',3500,80,280000,28000,308000,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000033','오렌지','UNT001','2025-04-30',5600,50,280000,28000,308000,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000034','포도','UNT003','2025-04-30',3400,130,442000,44200,486200,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000035','딸기','UNT002','2025-04-30',5800,110,638000,63800,701800,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000036','수박','UNT002','2025-04-30',4900,120,588000,58800,646800,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000037','참외','UNT002','2025-04-30',8000,130,1040000,104000,1144000,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000038','배','UNT001','2025-04-30',5300,150,795000,79500,874500,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000039','복숭아','UNT001','2025-04-30',2500,120,300000,30000,330000,1,'2025-04-29 06:28:52'),
('EST25042900001','FOOD000040','레몬','UNT003','2025-04-30',7700,100,770000,77000,847000,1,'2025-04-29 06:28:52'),
('EST25050400001','FOOD000003','고추장','UNT001','2025-05-14',4500,20,90000,9000,99000,1,'2025-05-04 00:01:25'),
('EST25050400001','FOOD000005','참기름','UNT003','2025-05-14',8500,150,1275000,127500,1402500,1,'2025-05-04 00:01:25'),
('EST25050400001','FOOD000006','들기름','UNT001','2025-05-14',8100,300,2430000,243000,2673000,1,'2025-05-04 00:01:25'),
('EST25050400001','FOOD000009','떡볶이','UNT001','2025-05-14',7500,250,1875000,187500,2062500,1,'2025-05-04 00:01:25'),
('EST25050400001','FOOD000010','햄','UNT003','2025-05-14',4500,100,450000,45000,495000,1,'2025-05-04 00:01:25'),
('EST25101300001','FOOD000002','된장','UNT001','2025-10-16',5000,50,250000,25000,275000,1,'2025-10-13 07:35:33'),
('EST25101300001','FOOD000003','고추장','UNT001','2025-10-16',4500,30,135000,13500,148500,1,'2025-10-13 07:35:33'),
('EST25101300001','FOOD000004','간장','UNT001','2025-10-15',7800,1000,7800000,780000,8580000,1,'2025-10-13 07:35:33'),
('EST25101300001','FOOD000007','라면','UNT001','2025-10-24',2000,250,500000,50000,550000,1,'2025-10-13 07:35:33');
/*!40000 ALTER TABLE `estimate_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `item_id` varchar(20) NOT NULL COMMENT '품목아이디',
  `item_name` varchar(50) NOT NULL COMMENT '품목명',
  `unit_cd` varchar(10) DEFAULT NULL COMMENT '단위코드',
  `standard_price` int(11) DEFAULT NULL COMMENT '표준단가',
  `reg_id` bigint(20) DEFAULT NULL COMMENT '등록자',
  `reg_dt` datetime DEFAULT current_timestamp() COMMENT '등록일시',
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES
('FOOD000001','김치','UNT001',7000,1,'2025-01-05 07:21:46'),
('FOOD000002','된장','UNT001',5000,1,'2024-11-16 03:33:48'),
('FOOD000003','고추장','UNT001',4500,1,'2024-10-09 07:20:17'),
('FOOD000004','간장','UNT001',7800,1,'2024-06-16 11:08:58'),
('FOOD000005','참기름','UNT003',8500,1,'2024-12-27 00:24:23'),
('FOOD000006','들기름','UNT001',8100,1,'2024-08-02 09:12:18'),
('FOOD000007','라면','UNT001',2000,1,'2024-06-23 02:38:18'),
('FOOD000008','우동','UNT001',2500,1,'2024-05-26 03:17:14'),
('FOOD000009','떡볶이','UNT001',7500,1,'2024-09-29 07:56:40'),
('FOOD000010','햄','UNT003',4500,1,'2024-04-12 23:43:49'),
('FOOD000011','김','UNT001',3600,1,'2025-01-04 00:41:03'),
('FOOD000012','쌀','UNT001',7300,1,'2024-08-10 11:46:31'),
('FOOD000013','보리','UNT003',5600,1,'2024-05-22 20:36:29'),
('FOOD000014','현미','UNT002',8900,1,'2024-07-16 08:51:23'),
('FOOD000015','콩나물','UNT001',5800,1,'2024-05-29 21:26:26'),
('FOOD000016','두부','UNT001',9800,1,'2025-01-31 06:02:24'),
('FOOD000017','순두부','UNT002',6100,1,'2025-02-19 03:56:04'),
('FOOD000018','소금','UNT001',8800,1,'2024-09-18 08:21:56'),
('FOOD000019','설탕','UNT002',3500,1,'2024-10-10 03:33:42'),
('FOOD000020','식초','UNT002',2300,1,'2025-01-20 17:42:27'),
('FOOD000021','마요네즈','UNT001',2100,1,'2024-07-06 00:02:30'),
('FOOD000022','케첩','UNT003',2900,1,'2024-11-05 03:21:04'),
('FOOD000023','버터','UNT001',1600,1,'2025-03-24 02:08:40'),
('FOOD000024','잼','UNT001',7800,1,'2024-04-02 18:24:49'),
('FOOD000025','치즈','UNT002',9800,1,'2024-10-05 12:20:12'),
('FOOD000026','요구르트','UNT003',4300,1,'2024-07-15 00:36:01'),
('FOOD000027','우유','UNT001',5500,1,'2024-09-30 06:13:58'),
('FOOD000028','요거트','UNT001',5000,1,'2024-06-05 07:45:47'),
('FOOD000029','계란','UNT003',6500,1,'2024-09-02 23:06:02'),
('FOOD000030','닭가슴살','UNT003',3500,1,'2024-10-11 08:14:48'),
('FOOD000031','사과','UNT002',4400,1,'2024-10-14 09:38:38'),
('FOOD000032','바나나','UNT003',3500,1,'2024-06-09 07:14:18'),
('FOOD000033','오렌지','UNT001',5600,1,'2024-08-03 21:44:10'),
('FOOD000034','포도','UNT003',3400,1,'2025-03-24 12:25:48'),
('FOOD000035','딸기','UNT002',5800,1,'2024-11-18 10:20:41'),
('FOOD000036','수박','UNT002',4900,1,'2024-09-26 00:39:56'),
('FOOD000037','참외','UNT002',8000,1,'2024-06-24 05:43:00'),
('FOOD000038','배','UNT001',5300,1,'2024-05-20 23:11:24'),
('FOOD000039','복숭아','UNT001',2500,1,'2025-01-17 20:26:42'),
('FOOD000040','레몬','UNT003',7700,1,'2024-07-09 02:57:50'),
('FOOD000041','양파','UNT001',5800,1,'2024-04-26 07:16:55'),
('FOOD000042','마늘','UNT003',3500,1,'2024-04-18 04:52:00'),
('FOOD000043','감자','UNT001',5500,1,'2024-06-17 02:32:20'),
('FOOD000044','고구마','UNT001',4800,1,'2024-07-24 15:08:40'),
('FOOD000045','당근','UNT001',4700,1,'2025-02-19 08:02:56'),
('FOOD000046','애호박','UNT002',9000,1,'2024-11-28 03:32:07'),
('FOOD000047','오이','UNT002',3500,1,'2024-09-23 23:41:04'),
('FOOD000048','브로콜리','UNT001',7700,1,'2024-08-12 14:25:50'),
('FOOD000049','시금치','UNT002',4800,1,'2025-02-07 18:05:12'),
('FOOD000050','배추','UNT001',6600,1,'2024-06-14 08:45:09');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '메뉴아이디',
  `menu_name` varchar(50) NOT NULL COMMENT '메뉴명',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '상위메뉴아이디',
  `order_index` int(11) NOT NULL COMMENT '순번',
  `url` varchar(255) DEFAULT NULL COMMENT 'URL',
  `icon` varchar(50) DEFAULT NULL COMMENT '아이콘',
  `reg_id` bigint(20) DEFAULT NULL COMMENT '등록자',
  `reg_dt` datetime DEFAULT current_timestamp() COMMENT '등록일시',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci COMMENT='메뉴';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES
(1,'대시보드',NULL,1,'/admin/main','fas fa-tachometer-alt',1,'2025-03-19 17:26:20'),
(2,'견적서',NULL,2,'','fas fa-file-invoice',1,'2025-03-19 17:26:20'),
(3,'견적서등록',2,1,'/admin/estimate/insert','fas fa-file-signature',1,'2025-03-19 17:27:23'),
(4,'견적서관리',2,2,'/admin/estimate','fas fa-folder-open',1,'2025-03-19 17:27:23'),
(5,'데이터수집',NULL,3,'','fas fa-database',1,'2025-03-19 17:27:23'),
(6,'NVR 카메라현황',5,1,'/admin/nvrcamera','fas fa-video',1,'2025-03-19 18:07:23'),
(7,'NVR 스케쥴관리',5,2,'/admin/nvrschedule','fas fa-calendar-alt',1,'2025-04-16 01:52:28'),
(8,'시스템설정',NULL,4,'','fas fa-cogs',1,'2025-03-25 06:07:56'),
(9,'사용자관리',8,1,'/admin/user','fas fa-users-cog',1,'2025-03-25 06:07:56');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu_role`
--

DROP TABLE IF EXISTS `menu_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu_role` (
  `role_id` bigint(20) NOT NULL COMMENT '권한아이디',
  `menu_id` bigint(20) NOT NULL COMMENT '메뉴아이디',
  PRIMARY KEY (`menu_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_role`
--

LOCK TABLES `menu_role` WRITE;
/*!40000 ALTER TABLE `menu_role` DISABLE KEYS */;
INSERT INTO `menu_role` VALUES
(1,1),
(1,2),
(1,3),
(1,4),
(1,5),
(1,7),
(1,8),
(1,9),
(1,10);
/*!40000 ALTER TABLE `menu_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `movie_id` varchar(20) NOT NULL COMMENT '영상아이디',
  `schedule_id` varchar(20) NOT NULL COMMENT '스케쥴아이디',
  `movie_name` varchar(50) DEFAULT NULL COMMENT '영상명',
  `save_path` varchar(200) DEFAULT NULL COMMENT '저장경로',
  `file_size` int(11) DEFAULT NULL COMMENT '파일크기',
  `reg_dt` datetime DEFAULT current_timestamp() COMMENT '등록일시',
  PRIMARY KEY (`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES
('MOVIE0001','SCHEDULE0002','20250421_080000_5_CAMERA0003.mp4','/data/movie/20250421_080000_5_CAMERA0003.mp4',2348858,'2025-04-21 23:37:16'),
('MOVIE0002','SCHEDULE0002','20250421_080000_5_CAMERA0003.mp4','/data/movie/20250421_080000_5_CAMERA0003.mp4',2348858,'2025-04-21 23:45:13'),
('MOVIE0003','SCHEDULE0003','20250421_080000_5_CAMERA0003.mp4','/data/movie/20250421_080000_5_CAMERA0003.mp4',2348858,'2025-04-21 23:45:14'),
('MOVIE0004','SCHEDULE0002','20250421_080000_5_CAMERA0003.mp4','/data/movie/20250421_080000_5_CAMERA0003.mp4',2348858,'2025-04-21 23:49:13'),
('MOVIE0005','SCHEDULE0003','20250421_080000_5_CAMERA0003.mp4','/data/movie/20250421_080000_5_CAMERA0003.mp4',2348858,'2025-04-21 23:49:14'),
('MOVIE0006','SCHEDULE0002','20250421_080000_5_CAMERA0003.mp4','/data/movie/20250421_080000_5_CAMERA0003.mp4',2348858,'2025-04-22 00:49:13'),
('MOVIE0007','SCHEDULE0003','20250421_080000_5_CAMERA0003.mp4','/data/movie/20250421_080000_5_CAMERA0003.mp4',2348858,'2025-04-22 00:49:14'),
('MOVIE0008','SCHEDULE0002','20250421_080000_5_CAMERA0003.mp4','/data/movie/20250421_080000_5_CAMERA0003.mp4',2348858,'2025-04-22 01:49:13'),
('MOVIE0009','SCHEDULE0003','20250421_080000_5_CAMERA0003.mp4','/data/movie/20250421_080000_5_CAMERA0003.mp4',2348858,'2025-04-22 01:49:14'),
('MOVIE0010','SCHEDULE0002','20250421_080000_5_CAMERA0003.mp4','/data/movie/20250421_080000_5_CAMERA0003.mp4',2348858,'2025-04-22 02:49:13'),
('MOVIE0011','SCHEDULE0003','20250421_080000_5_CAMERA0003.mp4','/data/movie/20250421_080000_5_CAMERA0003.mp4',2348858,'2025-04-22 02:49:14'),
('MOVIE0012','SCHEDULE0002','20250421_080000_5_CAMERA0003.mp4','/data/movie/20250421_080000_5_CAMERA0003.mp4',2348858,'2025-04-22 03:49:12'),
('MOVIE0013','SCHEDULE0003','20250421_080000_5_CAMERA0003.mp4','/data/movie/20250421_080000_5_CAMERA0003.mp4',2348858,'2025-04-22 03:49:13'),
('MOVIE0014','SCHEDULE0002','20250421_080000_5_CAMERA0003.mp4','/data/movie/20250421_080000_5_CAMERA0003.mp4',2348858,'2025-04-22 04:49:12'),
('MOVIE0015','SCHEDULE0003','20250421_080000_5_CAMERA0003.mp4','/data/movie/20250421_080000_5_CAMERA0003.mp4',2348858,'2025-04-22 04:49:13'),
('MOVIE0016','SCHEDULE0002','20250421_080000_5_CAMERA0003.mp4','/data/movie/20250421_080000_5_CAMERA0003.mp4',2348858,'2025-04-23 02:49:14'),
('MOVIE0017','SCHEDULE0003','20250421_080000_5_CAMERA0003.mp4','/data/movie/20250421_080000_5_CAMERA0003.mp4',2348858,'2025-04-23 02:49:15'),
('MOVIE0018','SCHEDULE0002','20250421_080000_5_CAMERA0003.mp4','/data/movie/20250421_080000_5_CAMERA0003.mp4',2348858,'2025-04-23 03:49:12'),
('MOVIE0019','SCHEDULE0003','20250421_080000_5_CAMERA0003.mp4','/data/movie/20250421_080000_5_CAMERA0003.mp4',2348858,'2025-04-23 03:49:13'),
('MOVIE0020','SCHEDULE0002','20250421_080000_5_CAMERA0003.mp4','/data/movie/20250421_080000_5_CAMERA0003.mp4',2348858,'2025-04-23 21:49:14'),
('MOVIE0021','SCHEDULE0003','20250421_080000_5_CAMERA0003.mp4','/data/movie/20250421_080000_5_CAMERA0003.mp4',2348858,'2025-04-23 21:49:15'),
('MOVIE0022','SCHEDULE0002','20250421_080000_5_CAMERA0003.mp4','/data/movie/20250421_080000_5_CAMERA0003.mp4',2348858,'2025-04-25 09:23:15'),
('MOVIE0023','SCHEDULE0002','20250421_080000_5_CAMERA0003.mp4','/data/movie/20250421_080000_5_CAMERA0003.mp4',2348858,'2025-04-25 19:07:12'),
('MOVIE0024','SCHEDULE0002','20250421_080000_5_CAMERA0003.mp4','/data/movie/20250421_080000_5_CAMERA0003.mp4',2348858,'2025-04-25 20:07:05'),
('MOVIE0025','SCHEDULE0002','20250421_080000_5_CAMERA0003.mp4','/data/movie/20250421_080000_5_CAMERA0003.mp4',2348858,'2025-04-25 21:08:03');
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nvr_camera`
--

DROP TABLE IF EXISTS `nvr_camera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `nvr_camera` (
  `camera_id` varchar(20) NOT NULL COMMENT '카메라아이디',
  `server_id` varchar(20) NOT NULL COMMENT '서버아이디',
  `camera_name` varchar(50) NOT NULL COMMENT '카메라명',
  `use_yn` tinyint(1) NOT NULL DEFAULT 1,
  `reg_dt` datetime DEFAULT current_timestamp() COMMENT '등록일시',
  PRIMARY KEY (`camera_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nvr_camera`
--

LOCK TABLES `nvr_camera` WRITE;
/*!40000 ALTER TABLE `nvr_camera` DISABLE KEYS */;
INSERT INTO `nvr_camera` VALUES
('CAMERA0001','SERVER0001','1번카메라',1,'2025-04-12 02:31:16'),
('CAMERA0002','SERVER0001','2번카메라',1,'2025-04-12 02:31:16'),
('CAMERA0003','SERVER0001','3번카메라',1,'2025-04-12 02:31:16'),
('CAMERA0004','SERVER0001','4번카메라',1,'2025-04-15 19:51:00'),
('CAMERA0005','SERVER0001','5번카메라',1,'2025-04-15 19:51:00'),
('CAMERA0006','SERVER0001','6번카메라',1,'2025-04-15 19:51:00'),
('CAMERA0007','SERVER0001','7번카메라',1,'2025-04-15 19:51:00');
/*!40000 ALTER TABLE `nvr_camera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nvr_schedule`
--

DROP TABLE IF EXISTS `nvr_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `nvr_schedule` (
  `schedule_id` varchar(20) NOT NULL COMMENT '스케쥴아이디',
  `camera_id` varchar(20) NOT NULL COMMENT '카메라아이디',
  `schedule_name` varchar(50) NOT NULL COMMENT '스케쥴명',
  `start_date` date NOT NULL COMMENT '시작일자',
  `end_date` date NOT NULL COMMENT '종료일자',
  `cycle` int(11) NOT NULL COMMENT '주기 (분)',
  `duration` int(11) NOT NULL COMMENT '길이 (분)',
  `last_download_dt` datetime DEFAULT NULL COMMENT '마지막 다운로드일시',
  `use_yn` tinyint(4) NOT NULL DEFAULT 1 COMMENT '사용여부',
  `reg_id` bigint(20) DEFAULT NULL COMMENT '등록자',
  `reg_dt` datetime DEFAULT current_timestamp() COMMENT '등록일시',
  `upd_id` bigint(20) DEFAULT NULL COMMENT '수정자',
  `upd_dt` datetime DEFAULT NULL COMMENT '수정일시',
  PRIMARY KEY (`schedule_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nvr_schedule`
--

LOCK TABLES `nvr_schedule` WRITE;
/*!40000 ALTER TABLE `nvr_schedule` DISABLE KEYS */;
INSERT INTO `nvr_schedule` VALUES
('SCHEDULE0001','CAMERA0001','스케쥴1','2025-04-18','2025-04-19',60,3,NULL,1,1,'2025-04-17 00:54:51',NULL,'2025-04-23 03:07:40'),
('SCHEDULE0002','CAMERA0001','스케쥴2','2025-04-19','2025-04-25',60,5,'2025-04-25 22:08:00',1,1,'2025-04-17 05:25:05',NULL,'2025-04-29 07:11:45'),
('SCHEDULE0003','CAMERA0002','스케쥴3','2025-04-17','2025-04-24',60,5,'2025-04-23 21:49:15',1,1,'2025-04-17 05:33:38',NULL,'2025-04-29 07:11:54');
/*!40000 ALTER TABLE `nvr_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nvr_schedule_history`
--

DROP TABLE IF EXISTS `nvr_schedule_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `nvr_schedule_history` (
  `history_id` varchar(20) NOT NULL COMMENT '스케쥴이력아이디',
  `schedule_id` varchar(20) NOT NULL COMMENT '스케쥴아이디',
  `movie_id` varchar(20) DEFAULT NULL COMMENT '영상아이디',
  `downloaded_yn` char(1) NOT NULL COMMENT '다운로드 여부 (Y/N)',
  `fail_reason` varchar(200) DEFAULT NULL COMMENT '실패이유',
  `reg_dt` datetime DEFAULT current_timestamp() COMMENT '등록일시',
  PRIMARY KEY (`history_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nvr_schedule_history`
--

LOCK TABLES `nvr_schedule_history` WRITE;
/*!40000 ALTER TABLE `nvr_schedule_history` DISABLE KEYS */;
INSERT INTO `nvr_schedule_history` VALUES
('HISTORY0001','SCHEDULE0002',NULL,'0','외부 API 요청에 실패했습니다.','2025-04-21 20:36:31'),
('HISTORY0002','SCHEDULE0002',NULL,'0','외부 API 요청에 실패했습니다.','2025-04-21 21:35:43'),
('HISTORY0003','SCHEDULE0002',NULL,'0','외부 API 요청에 실패했습니다.','2025-04-21 21:38:08'),
('HISTORY0004','SCHEDULE0002',NULL,'0','영상 파일을 HDFS에 저장하는 중 오류가 발생했습니다.','2025-04-21 21:54:42'),
('HISTORY0005','SCHEDULE0002',NULL,'0','영상 파일을 HDFS에 저장하는 중 오류가 발생했습니다.','2025-04-21 21:58:28'),
('HISTORY0006','SCHEDULE0002','MOVIE0001','1',NULL,'2025-04-21 23:37:19'),
('HISTORY0007','SCHEDULE0002','MOVIE0002','1',NULL,'2025-04-21 23:45:13'),
('HISTORY0008','SCHEDULE0003','MOVIE0003','1',NULL,'2025-04-21 23:45:14'),
('HISTORY0009','SCHEDULE0002','MOVIE0004','1',NULL,'2025-04-21 23:49:13'),
('HISTORY0010','SCHEDULE0003','MOVIE0005','1',NULL,'2025-04-21 23:49:14'),
('HISTORY0011','SCHEDULE0002','MOVIE0006','1',NULL,'2025-04-22 00:49:13'),
('HISTORY0012','SCHEDULE0003','MOVIE0007','1',NULL,'2025-04-22 00:49:14'),
('HISTORY0013','SCHEDULE0002','MOVIE0008','1',NULL,'2025-04-22 01:49:13'),
('HISTORY0014','SCHEDULE0003','MOVIE0009','1',NULL,'2025-04-22 01:49:14'),
('HISTORY0015','SCHEDULE0002','MOVIE0010','1',NULL,'2025-04-22 02:49:13'),
('HISTORY0016','SCHEDULE0003','MOVIE0011','1',NULL,'2025-04-22 02:49:14'),
('HISTORY0017','SCHEDULE0002','MOVIE0012','1',NULL,'2025-04-22 03:49:12'),
('HISTORY0018','SCHEDULE0003','MOVIE0013','1',NULL,'2025-04-22 03:49:13'),
('HISTORY0019','SCHEDULE0002','MOVIE0014','1',NULL,'2025-04-22 04:49:12'),
('HISTORY0020','SCHEDULE0003','MOVIE0015','1',NULL,'2025-04-22 04:49:13'),
('HISTORY0021','SCHEDULE0002','MOVIE0016','1',NULL,'2025-04-23 02:49:14'),
('HISTORY0022','SCHEDULE0003','MOVIE0017','1',NULL,'2025-04-23 02:49:15'),
('HISTORY0023','SCHEDULE0002','MOVIE0018','1',NULL,'2025-04-23 03:49:12'),
('HISTORY0024','SCHEDULE0003','MOVIE0019','1',NULL,'2025-04-23 03:49:13'),
('HISTORY0025','SCHEDULE0002','MOVIE0020','1',NULL,'2025-04-23 21:49:14'),
('HISTORY0026','SCHEDULE0003','MOVIE0021','1',NULL,'2025-04-23 21:49:15'),
('HISTORY0027','SCHEDULE0002','MOVIE0022','1',NULL,'2025-04-25 09:23:15'),
('HISTORY0028','SCHEDULE0002','MOVIE0023','1',NULL,'2025-04-25 19:07:12'),
('HISTORY0029','SCHEDULE0002','MOVIE0024','1',NULL,'2025-04-25 20:07:05'),
('HISTORY0030','SCHEDULE0002','MOVIE0025','1',NULL,'2025-04-25 21:08:03'),
('HISTORY0031','SCHEDULE0002',NULL,'0','외부 API 요청에 실패했습니다.','2025-04-25 22:08:00');
/*!40000 ALTER TABLE `nvr_schedule_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nvr_server`
--

DROP TABLE IF EXISTS `nvr_server`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `nvr_server` (
  `server_id` varchar(20) NOT NULL COMMENT '서버아이디',
  `server_name` varchar(50) NOT NULL COMMENT '서버명',
  `server_address` varchar(200) NOT NULL COMMENT '서버주소',
  `reg_dt` datetime DEFAULT current_timestamp() COMMENT '등록일시',
  PRIMARY KEY (`server_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci COMMENT='NVR 서버';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nvr_server`
--

LOCK TABLES `nvr_server` WRITE;
/*!40000 ALTER TABLE `nvr_server` DISABLE KEYS */;
INSERT INTO `nvr_server` VALUES
('SERVER0001','NVR영상수집서버','https://2bb6abf4-eb24-4b51-a489-3efcf57ef075.mock.pstmn.io','2025-04-12 02:28:39');
/*!40000 ALTER TABLE `nvr_server` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '권한아이디',
  `role_name` varchar(50) NOT NULL COMMENT '권한명',
  `reg_id` bigint(20) DEFAULT NULL COMMENT '등록자',
  `reg_dt` datetime DEFAULT current_timestamp() COMMENT '등록일시',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES
(1,'ADMIN',1,'2025-03-19 14:00:26'),
(2,'USER',1,'2025-03-22 14:00:28');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '사용자아이디',
  `username` varchar(20) NOT NULL COMMENT '아이디',
  `name` varchar(50) DEFAULT NULL COMMENT '사용자명',
  `password` varchar(255) NOT NULL COMMENT '비밀번호',
  `tel_no` varchar(20) NOT NULL COMMENT '전화번호',
  `fax_no` varchar(20) DEFAULT NULL COMMENT '팩스번호',
  `role_id` bigint(20) DEFAULT NULL COMMENT '권한아이디',
  `reg_dt` datetime DEFAULT current_timestamp() COMMENT '등록일시',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES
(1,'admin','관리자','$2a$10$rDdBU4nSnNA86uFhiCySNeHClW38q6/fsDQj2GnmO5mu0z0ZdQ6I2','010-1010-1012','02-1010-1012',1,'2025-03-19 13:59:59'),
(9,'jwt','사용자','$2a$10$A/F2bHTWaSEj8lvfZybvYu/xG4Xk.d5y9TeTey5VfqDRUg8HKB3W6','010-1010-1010','010-1010-1010',2,'2025-04-25 22:47:02'),
(10,'guest','게스트','$2a$10$6K0XyuB8wV72IGpfpPRv8.hEbX3tcRcV2Znse3sVmpANmRLtYHx3.','010-0000-0000','02-0000-0000',1,'2025-12-17 14:46:39');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendor`
--

DROP TABLE IF EXISTS `vendor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendor` (
  `vendor_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '거래처아이디',
  `vendor_name` varchar(50) NOT NULL COMMENT '거래처명',
  `representative_name` varchar(50) NOT NULL COMMENT '대표자명',
  `registration_number` varchar(20) NOT NULL COMMENT '사업자등록번호',
  `address` varchar(400) NOT NULL COMMENT '주소',
  `tel_no` varchar(20) NOT NULL COMMENT '전화번호',
  `fax_no` varchar(20) DEFAULT NULL COMMENT '팩스번호',
  `business_type` varchar(50) DEFAULT NULL COMMENT '업태',
  `industry_type` varchar(50) DEFAULT NULL COMMENT '종목',
  `reg_id` bigint(20) DEFAULT NULL COMMENT '등록자',
  `reg_dt` datetime DEFAULT current_timestamp() COMMENT '등록일시',
  PRIMARY KEY (`vendor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendor`
--

LOCK TABLES `vendor` WRITE;
/*!40000 ALTER TABLE `vendor` DISABLE KEYS */;
INSERT INTO `vendor` VALUES
(1,'오박 식품','권영식','864-30-89585','부산광역시 송파구 선릉로','02-3181-5450','053-842-7051','소매','식품',1,'2024-06-01 17:28:51'),
(2,'주식회사 김 식품','서지아','765-88-15058','충청남도 안양시 동안구 영동대499길 (시우김면)','061-524-9619','041-292-1253','유통','식품',1,'2025-03-24 21:04:50'),
(3,'유한회사 김조권 식품','송정식','305-66-57843','인천광역시 성동구 개포로 (옥자윤김면)','063-400-4641','051-074-5597','소매','식품',1,'2024-10-08 21:52:02'),
(4,'유한회사 강 식품','박명자','283-12-14335','울산광역시 성북구 잠실295거리 (서준류읍)','032-319-1057','062-408-4322','유통','식품',1,'2024-10-08 00:30:17'),
(5,'(주) 남 식품','이중수','805-94-95934','경기도 광주시 테헤란1길 (재현김강동)','016-143-8981','064-746-9661','유통','식품',1,'2024-06-16 13:13:42'),
(6,'이이 식품','고서현','628-59-32742','세종특별자치시 양천구 석촌호수거리','051-051-4779','053-973-6140','소매','식품',1,'2024-05-30 18:46:16'),
(7,'(유) 김 식품','박시우','607-37-34468','경상남도 강릉시 서초중앙길','041-254-1468','070-5781-9740','도매','식품',1,'2024-05-17 05:59:52'),
(8,'문권 식품','신지후','883-71-50153','대구광역시 노원구 서초중앙392가','016-169-0796','032-164-7019','제조','식품',1,'2024-10-20 17:12:13'),
(9,'(주) 홍황이 식품','한종수','335-67-92069','세종특별자치시 서초구 잠실4가 (준호구읍)','010-5318-0990','063-285-4311','유통','식품',1,'2024-08-14 22:58:03'),
(10,'유한회사 최 식품','박수민','110-64-89506','전라북도 광명시 봉은사가 (시우백문면)','033-106-4990','042-220-3120','도매','식품',1,'2025-03-29 23:26:40');
/*!40000 ALTER TABLE `vendor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*M!100616 SET NOTE_VERBOSITY=@OLD_NOTE_VERBOSITY */;

-- Dump completed on 2026-03-31 12:55:42
