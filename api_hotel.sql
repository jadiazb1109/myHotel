/*
 Navicat Premium Data Transfer

 Source Server         : Local
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : api_hotel

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 02/02/2022 01:46:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for clientes
-- ----------------------------
DROP TABLE IF EXISTS `clientes`;
CREATE TABLE `clientes`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `identidad` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `nombres` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `activo` tinyint(1) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of clientes
-- ----------------------------
INSERT INTO `clientes` VALUES (1, '1234', 'CLIENTE 1', 1);
INSERT INTO `clientes` VALUES (2, '12345', 'CLIENTE 2', 1);
INSERT INTO `clientes` VALUES (3, '1234321', 'CLIENTE 3', 1);
INSERT INTO `clientes` VALUES (4, '123489', 'CLIENTE MODIFICADO 4', 1);

-- ----------------------------
-- Table structure for consumos
-- ----------------------------
DROP TABLE IF EXISTS `consumos`;
CREATE TABLE `consumos`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `fecha` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `id_reserva` int NULL DEFAULT NULL,
  `activo` tinyint(1) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_consumo_idReserva`(`id_reserva`) USING BTREE,
  CONSTRAINT `fk_consumo_idReserva` FOREIGN KEY (`id_reserva`) REFERENCES `reservas` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of consumos
-- ----------------------------
INSERT INTO `consumos` VALUES (2, '2022-01-31 21:33:18', 1, 1);
INSERT INTO `consumos` VALUES (3, '2022-01-31 21:35:15', 3, 1);
INSERT INTO `consumos` VALUES (4, '2022-01-31 21:35:16', 4, 1);
INSERT INTO `consumos` VALUES (5, '2022-01-31 21:35:18', 2, 1);

-- ----------------------------
-- Table structure for consumos_detalle
-- ----------------------------
DROP TABLE IF EXISTS `consumos_detalle`;
CREATE TABLE `consumos_detalle`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_consumo` int NULL DEFAULT NULL,
  `id_servicio` int NULL DEFAULT NULL,
  `valor` decimal(20, 2) NULL DEFAULT NULL,
  `activo` tinyint(1) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_consumo_detalle_idConsumo`(`id_consumo`) USING BTREE,
  INDEX `fk_consumo_detalle_idServicio`(`id_servicio`) USING BTREE,
  CONSTRAINT `fk_consumo_detalle_idConsumo` FOREIGN KEY (`id_consumo`) REFERENCES `consumos` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_consumo_detalle_idServicio` FOREIGN KEY (`id_servicio`) REFERENCES `servicios` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of consumos_detalle
-- ----------------------------
INSERT INTO `consumos_detalle` VALUES (1, 2, 1, 10000.00, 1);
INSERT INTO `consumos_detalle` VALUES (2, 2, 2, 15000.00, 1);
INSERT INTO `consumos_detalle` VALUES (3, 2, 3, 30000.00, 1);
INSERT INTO `consumos_detalle` VALUES (4, 3, 3, 30000.00, 1);
INSERT INTO `consumos_detalle` VALUES (5, 3, 3, 30000.00, 1);
INSERT INTO `consumos_detalle` VALUES (6, 4, 1, 10000.00, 1);
INSERT INTO `consumos_detalle` VALUES (7, 5, 2, 15000.00, 1);
INSERT INTO `consumos_detalle` VALUES (8, 2, 1, 10000.00, 1);
INSERT INTO `consumos_detalle` VALUES (9, 2, 2, 15000.00, 1);
INSERT INTO `consumos_detalle` VALUES (10, 2, 3, 30000.00, 1);
INSERT INTO `consumos_detalle` VALUES (11, 2, 1, 10000.00, 1);
INSERT INTO `consumos_detalle` VALUES (12, 2, 2, 15000.00, 1);
INSERT INTO `consumos_detalle` VALUES (13, 2, 3, 30000.00, 1);
INSERT INTO `consumos_detalle` VALUES (14, 5, 1, 10000.00, 1);
INSERT INTO `consumos_detalle` VALUES (15, 5, 2, 15000.00, 1);
INSERT INTO `consumos_detalle` VALUES (16, 5, 3, 30000.00, 1);
INSERT INTO `consumos_detalle` VALUES (17, 5, 1, 10000.00, 1);
INSERT INTO `consumos_detalle` VALUES (18, 5, 2, 15000.00, 1);
INSERT INTO `consumos_detalle` VALUES (19, 5, 3, 30000.00, 1);

-- ----------------------------
-- Table structure for dias_festivos
-- ----------------------------
DROP TABLE IF EXISTS `dias_festivos`;
CREATE TABLE `dias_festivos`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `fecha` date NULL DEFAULT NULL,
  `descripcion` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `activo` tinyint(1) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dias_festivos
-- ----------------------------
INSERT INTO `dias_festivos` VALUES (1, '2022-01-10', 'REYES MAGOS', 1);

-- ----------------------------
-- Table structure for reservas
-- ----------------------------
DROP TABLE IF EXISTS `reservas`;
CREATE TABLE `reservas`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `fecha` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `id_cliente` int NULL DEFAULT NULL,
  `fecha_ingreso` date NULL DEFAULT NULL,
  `fecha_salida` date NULL DEFAULT NULL,
  `todo_incluido` tinyint(1) NULL DEFAULT 0,
  `valor_todo_incluido` decimal(20, 2) NULL DEFAULT 90000.00,
  `total` decimal(20, 2) NULL DEFAULT 0.00,
  `activo` tinyint(1) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_reservas_idCliente`(`id_cliente`) USING BTREE,
  CONSTRAINT `fk_reservas_idCliente` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reservas
-- ----------------------------
INSERT INTO `reservas` VALUES (1, '2022-01-06 00:00:00', 1, '2022-01-08', '2022-01-11', 0, 90000.00, NULL, 1);
INSERT INTO `reservas` VALUES (2, '2022-01-07 00:00:00', 2, '2022-01-19', '2022-01-25', 1, 90000.00, NULL, 1);
INSERT INTO `reservas` VALUES (3, '2022-01-08 00:00:00', 3, '2022-01-16', '2022-01-20', 0, 90000.00, NULL, 1);
INSERT INTO `reservas` VALUES (4, '2022-01-09 00:00:00', 1, '2022-01-21', '2022-01-24', 1, 90000.00, NULL, 1);

-- ----------------------------
-- Table structure for reservas_acompanastes
-- ----------------------------
DROP TABLE IF EXISTS `reservas_acompanastes`;
CREATE TABLE `reservas_acompanastes`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_reserva` int NULL DEFAULT NULL,
  `nombres` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `activo` tinyint(1) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_reservas_acompanantes_idReserva`(`id_reserva`) USING BTREE,
  CONSTRAINT `fk_reservas_acompanantes_idReserva` FOREIGN KEY (`id_reserva`) REFERENCES `reservas` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reservas_acompanastes
-- ----------------------------
INSERT INTO `reservas_acompanastes` VALUES (1, 1, 'ACOMPAÑANTE 1 CLIENTE 1', 1);
INSERT INTO `reservas_acompanastes` VALUES (2, 1, 'ACOMPAÑANTE 2 CLIENTE 1', 1);
INSERT INTO `reservas_acompanastes` VALUES (3, 3, 'ACOMPAÑANTE 1 CLIENTE 3', 1);
INSERT INTO `reservas_acompanastes` VALUES (4, 3, 'ACOMPAÑANTE 2 CLIENTE 3', 1);
INSERT INTO `reservas_acompanastes` VALUES (5, 3, 'ACOMPAÑANTE 3 CLIENTE 3', 1);
INSERT INTO `reservas_acompanastes` VALUES (6, 3, 'ACOMPAÑANTE 4 CLIENTE 3', 1);
INSERT INTO `reservas_acompanastes` VALUES (7, 4, 'ACOMPAÑANTE 1 CLIENTE 1', 1);

-- ----------------------------
-- Table structure for servicios
-- ----------------------------
DROP TABLE IF EXISTS `servicios`;
CREATE TABLE `servicios`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `valor` decimal(20, 2) NULL DEFAULT NULL,
  `activo` tinyint(1) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of servicios
-- ----------------------------
INSERT INTO `servicios` VALUES (1, 'SPA', 10000.00, 1);
INSERT INTO `servicios` VALUES (2, 'GYM', 15000.00, 1);
INSERT INTO `servicios` VALUES (3, 'RESTAURANTE', 30000.00, 1);

-- ----------------------------
-- Table structure for tarifas
-- ----------------------------
DROP TABLE IF EXISTS `tarifas`;
CREATE TABLE `tarifas`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `dia` int NULL DEFAULT NULL,
  `descripcion` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `valor` decimal(20, 2) NULL DEFAULT NULL,
  `activo` tinyint(1) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tarifas
-- ----------------------------
INSERT INTO `tarifas` VALUES (1, 1, 'LUNES', 50000.00, 1);
INSERT INTO `tarifas` VALUES (2, 2, 'MARTES', 50000.00, 1);
INSERT INTO `tarifas` VALUES (3, 3, 'MIERCOLES', 50000.00, 1);
INSERT INTO `tarifas` VALUES (4, 4, 'JUEVES', 50000.00, 1);
INSERT INTO `tarifas` VALUES (5, 5, 'VIERNES', 50000.00, 1);
INSERT INTO `tarifas` VALUES (6, 6, 'SABADO', 80000.00, 1);
INSERT INTO `tarifas` VALUES (7, 0, 'DOMINGO', 80000.00, 1);
INSERT INTO `tarifas` VALUES (8, 7, 'FESTIVO', 80000.00, 1);

SET FOREIGN_KEY_CHECKS = 1;
