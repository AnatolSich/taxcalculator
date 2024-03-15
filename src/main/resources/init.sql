CREATE DATABASE  IF NOT EXISTS `tax`;
USE `tax`;

DROP TABLE IF EXISTS `tax_band`;

CREATE TABLE `tax` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `lower_annual_salary_limit` DOUBLE DEFAULT 0,
  `upper_annual_salary_limit` DOUBLE, DEFAULT NULL,
  `tax_rate` DOUBLE DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `tax` WRITE;
INSERT INTO `tax` VALUES
(1,'Tax Band A', 0, 5000, 0),
(2,'Tax Band B', 5000, 20000, 20.00),
(3,'Tax Band C', 20000, null , 40.00);
UNLOCK TABLES;




