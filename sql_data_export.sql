-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: shopwatch
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cart_id` int(11) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `address` varchar(100) NOT NULL,
  `total_money` int(11) NOT NULL,
  `status_bill` int(11) NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_bill_cart_idx` (`cart_id`),
  CONSTRAINT `fk_bill_cart` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (1,2,'0327742927','134/2 Trần Công, B.Từ liêm , Hà Nội',113830000,2,'2021-07-17 22:08:47','2021-07-17 22:16:25');
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `status` bit(1) NOT NULL,
  `images` text,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` VALUES (1,'tissot',_binary '','https://likewatch.com/cdn/show/images/category/2019/10/10966223956288.png_250x0','2021-07-12 13:34:52','2021-07-12 13:34:52'),(2,'omega',_binary '','https://likewatch.com/cdn/show/images/category/2020/01/brand-likewatch-10158590793780.png_250x0','2021-07-12 18:38:09','2021-07-12 18:38:09'),(3,'omega1',_binary '\0','https://likewatch.com/cdn/show/images/category/2020/01/brand-likewatch-10158590793780.png_250x0','2021-07-12 18:44:06','2021-07-17 11:27:31'),(4,'name cần edit',_binary '\0','images cần edit','2021-07-12 18:46:18','2021-07-12 18:47:00'),(5,'omega1',_binary '\0','https://likewatch.com/cdn/show/images/category/2020/01/brand-likewatch-10158590793780.png_250x0','2021-07-17 11:24:38','2021-07-17 19:53:49'),(6,'omega2',_binary '\0','https://likewatch.com/cdn/show/images/category/2020/01/brand-likewatch-10158590793780.png_250x0','2021-07-17 11:26:32','2021-07-17 19:37:55'),(7,'omega3',_binary '','https://likewatch.com/cdn/show/images/category/2020/01/brand-likewatch-10158590793780.png_250x0','2021-07-17 11:27:16','2021-07-17 11:27:16'),(8,'123',_binary '','https://likewatch.com/cdn/show/images/category/2020/01/brand-likewatch-10158590793780.png_250x0','2021-07-17 19:42:13','2021-07-17 19:42:13'),(9,'omega10',_binary '','https://likewatch.com/cdn/show/images/category/2020/01/brand-likewatch-10158590793780.png_250x0','2021-07-17 19:43:07','2021-07-17 19:44:06'),(10,'GUCCI',_binary '','https://likewatch.com/cdn/show/images/category/2019/10/11125001998005.png_250x0','2021-07-17 20:13:51','2021-07-17 20:13:51');
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `payment_id` int(11) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cart_customer_idx` (`user_id`),
  KEY `fk_cart_transport_idx` (`payment_id`),
  CONSTRAINT `fk_cart_payment` FOREIGN KEY (`payment_id`) REFERENCES `payment` (`id`),
  CONSTRAINT `fk_cart_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (1,1,NULL,_binary '','2021-07-17 20:50:50','2021-07-17 20:50:50'),(2,NULL,NULL,_binary '\0','2021-07-17 22:02:11','2021-07-17 22:08:48');
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `colorwatch`
--

DROP TABLE IF EXISTS `colorwatch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `colorwatch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `status` bit(1) NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colorwatch`
--

LOCK TABLES `colorwatch` WRITE;
/*!40000 ALTER TABLE `colorwatch` DISABLE KEYS */;
INSERT INTO `colorwatch` VALUES (1,'Màu Trắng',_binary '','2021-07-17 20:03:44','2021-07-17 20:03:44'),(2,'Màu Xanh',_binary '','2021-07-17 20:04:01','2021-07-17 20:04:01'),(3,'Màu Hồng',_binary '','2021-07-17 20:04:08','2021-07-17 20:04:08'),(4,'Màu Vàng',_binary '','2021-07-17 20:04:12','2021-07-17 20:04:12'),(5,'Màu Bạc',_binary '','2021-07-17 20:04:16','2021-07-17 20:04:16');
/*!40000 ALTER TABLE `colorwatch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genderwatch`
--

DROP TABLE IF EXISTS `genderwatch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `genderwatch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `status` bit(1) NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genderwatch`
--

LOCK TABLES `genderwatch` WRITE;
/*!40000 ALTER TABLE `genderwatch` DISABLE KEYS */;
INSERT INTO `genderwatch` VALUES (1,'Đồng Hồ Trẻ Em',_binary '','2021-07-17 19:48:20','2021-07-17 19:48:20'),(2,'Đồng Hồ Người Lớn',_binary '','2021-07-17 19:48:52','2021-07-17 19:48:52'),(3,'Đồng Hồ Người Nam',_binary '','2021-07-17 19:49:12','2021-07-17 19:49:12'),(4,'Đồng Hồ Người Nữ',_binary '','2021-07-17 19:49:29','2021-07-17 19:52:18'),(5,'Dây Mạ Vàng',_binary '','2021-07-17 19:53:09','2021-07-17 19:58:42');
/*!40000 ALTER TABLE `genderwatch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `payment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` text,
  `status` bit(1) NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,'SHIPCODE','Giao hàng nhận mới thanh toán',_binary '','2021-07-12 13:34:52','2021-07-12 13:34:52'),(2,'CHUYENKHOAN','Thanh Toán qua Thẻ Ngân Hàng',_binary '','2021-07-12 13:34:52','2021-07-12 13:34:52');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` text,
  `price_old` int(11) NOT NULL,
  `price_new` int(11) NOT NULL,
  `images` text NOT NULL,
  `brand_id` int(11) NOT NULL,
  `type_id` int(11) NOT NULL,
  `gender_id` int(11) NOT NULL,
  `color_id` int(11) NOT NULL,
  `status` varchar(45) NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_product_brand_idx` (`brand_id`),
  KEY `fk_product_type_idx` (`type_id`),
  KEY `fk_product_gender_idx` (`gender_id`),
  KEY `fk_product_color_idx` (`color_id`),
  CONSTRAINT `fk_product_brand` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`),
  CONSTRAINT `fk_product_color` FOREIGN KEY (`color_id`) REFERENCES `colorwatch` (`id`),
  CONSTRAINT `fk_product_gender` FOREIGN KEY (`gender_id`) REFERENCES `genderwatch` (`id`),
  CONSTRAINT `fk_product_type` FOREIGN KEY (`type_id`) REFERENCES `typewatch` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'G-Timeless watch 42mm YA126283','G-Timeless đón đầu xu hướng với đồng hồ chính hãng, kính mắt thời trang cực chất',54120000,44390000,'https://likewatch.com/cdn/show/images/product/large/2021/07/dong-ho-likewatch-g-timeless-watch-38mm-2904012683770.jpg',10,2,3,5,'1','2021-07-17 20:24:59','2021-07-17 20:35:09'),(2,'The Longines Legend Diver  L3.774.4.60.2','Ngoài dây đeo, phần vỏ đồng hồ cũng như mặt kính cũng nên được vệ sinh thường xuyên. Trong khi đợi các dây đeo khô.',62420000,54960000,'https://likewatch.com/cdn/show/images/product/large/2021/07/dong-ho-likewatch-the-longines-legend-diver-watch-42mm-10519136456409.png',1,1,3,2,'1','2021-07-17 20:32:31','2021-07-17 20:32:31'),(3,'Phuc Watch123','Ngoài dây đeo, phần vỏ đồng hồ cũng như mặt kính cũng nên được vệ sinh thường xuyên. Trong khi đợi các dây đeo khô.',62420000,54960000,'https://likewatch.com/cdn/show/images/product/large/2021/07/dong-ho-likewatch-the-longines-legend-diver-watch-42mm-10519136456409.png',1,1,3,2,'1','2021-07-17 21:23:37','2021-07-17 21:23:37');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productcart`
--

DROP TABLE IF EXISTS `productcart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `productcart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `cart_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price_final` int(11) NOT NULL,
  `total_item` int(11) NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_oder_product_idx` (`product_id`),
  KEY `fk_oder_cart_idx` (`cart_id`),
  CONSTRAINT `fk_oder_cart` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`),
  CONSTRAINT `fk_oder_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productcart`
--

LOCK TABLES `productcart` WRITE;
/*!40000 ALTER TABLE `productcart` DISABLE KEYS */;
INSERT INTO `productcart` VALUES (1,1,1,2,44390000,88780000,'2021-07-17 21:00:07','2021-07-17 21:21:31'),(2,2,1,3,54960000,164880000,'2021-07-17 21:22:21','2021-07-17 21:22:21'),(4,3,2,4,54960000,219840000,'2021-07-17 22:02:25','2021-07-17 22:02:25'),(5,1,2,2,44390000,88780000,'2021-07-17 22:02:32','2021-07-17 22:02:32');
/*!40000 ALTER TABLE `productcart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_CUSTOMER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale`
--

DROP TABLE IF EXISTS `sale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sale` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `percent` double NOT NULL,
  `status` bit(1) NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale`
--

LOCK TABLES `sale` WRITE;
/*!40000 ALTER TABLE `sale` DISABLE KEYS */;
/*!40000 ALTER TABLE `sale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `typewatch`
--

DROP TABLE IF EXISTS `typewatch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `typewatch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `status` bit(1) NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `typewatch`
--

LOCK TABLES `typewatch` WRITE;
/*!40000 ALTER TABLE `typewatch` DISABLE KEYS */;
INSERT INTO `typewatch` VALUES (1,'Dây Nhựa',_binary '','2021-07-17 19:55:02','2021-07-17 19:55:02'),(2,'Dây Inox',_binary '','2021-07-17 19:55:48','2021-07-17 19:55:48'),(3,'Dây Mạ vàng',_binary '','2021-07-17 19:56:03','2021-07-17 19:56:03'),(4,'Dây Mạ vàng1',_binary '\0','2021-07-17 19:57:53','2021-07-17 19:59:38'),(5,'Dây Mạ vàng 2',_binary '','2021-07-17 19:58:00','2021-07-17 19:58:00');
/*!40000 ALTER TABLE `typewatch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `status` bit(1) NOT NULL,
  `role_id` int(11) NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_role_user_idx` (`role_id`),
  CONSTRAINT `fk_role_user` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Nguyễn Văn Phúc','phuc@gmail.com','11111111','0987654321',_binary '',1,'2021-07-12 13:34:52','2021-07-12 13:34:52');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-17 22:21:38
