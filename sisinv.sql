-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-05-2022 a las 21:39:43
-- Versión del servidor: 8.0.28
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sisinv`
--
CREATE DATABASE IF NOT EXISTS `sisinv` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `sisinv`;

DELIMITER $$
--
-- Procedimientos
--
DROP PROCEDURE IF EXISTS `Inventario_Total_Fecha`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `Inventario_Total_Fecha` (IN `FECHA` CHAR(12))  SELECT p.idProducto AS codigo, p.nom_Producto, (SELECT ((IF(SUM(e.cantidad_Entrada)is null,0,SUM(e.cantidad_Entrada))) - (SELECT IF(SUM(s.cantidad_Salida) is null,0,SUM(s.cantidad_Salida)) FROM salidas s WHERE p.idProducto = s.codigo_Salida AND s.fecha_Salida <= FECHA)) FROM entradas e WHERE p.idProducto = e.codigo_Entrada AND e.fecha_Entrada <= FECHA) as Stock FROM producto p$$

DROP PROCEDURE IF EXISTS `NUEVO_CLIENTE`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `NUEVO_CLIENTE` (`CODIGO` VARCHAR(10))  INSERT INTO Cliente (idCliente) VALUES (CODIGO)$$

DROP PROCEDURE IF EXISTS `NUEVO_PRODUCTO`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `NUEVO_PRODUCTO` (`CODIGO` VARCHAR(10))  INSERT INTO Inventario (codigo_Inventario) VALUES (CODIGO)$$

DROP PROCEDURE IF EXISTS `NUEVO_PROVEEDOR`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `NUEVO_PROVEEDOR` (`CODIGO` VARCHAR(10))  INSERT INTO Proveedor (idProveedor) VALUES (CODIGO)$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--
-- Creación: 19-04-2022 a las 22:03:18
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `idCliente` int NOT NULL,
  `nombre_Cliente` varchar(45) NOT NULL,
  `apellido_Cliente` varchar(45) NOT NULL,
  `apellido2_Cliente` varchar(45) NOT NULL,
  `telefono_Cliente` bigint NOT NULL,
  `email_Cliente` varchar(45) NOT NULL,
  `direccion_Cliente` varchar(45) NOT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- RELACIONES PARA LA TABLA `cliente`:
--

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idCliente`, `nombre_Cliente`, `apellido_Cliente`, `apellido2_Cliente`, `telefono_Cliente`, `email_Cliente`, `direccion_Cliente`) VALUES
(1, 'luis', 'genaro', 'GARZA', 88888888, 'a@b.com', 'por aqui');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entradas`
--
-- Creación: 19-04-2022 a las 22:03:46
--

DROP TABLE IF EXISTS `entradas`;
CREATE TABLE IF NOT EXISTS `entradas` (
  `idEntradas` int NOT NULL AUTO_INCREMENT,
  `codigo_Entrada` int NOT NULL,
  `fecha_Entrada` date NOT NULL,
  `cantidad_Entrada` int NOT NULL,
  `idProveedor` int NOT NULL,
  PRIMARY KEY (`idEntradas`),
  KEY `fk_Entradas_Proveedor_idx` (`idProveedor`),
  KEY `fk_Entradas_Producto1_idx` (`codigo_Entrada`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

--
-- RELACIONES PARA LA TABLA `entradas`:
--   `codigo_Entrada`
--       `producto` -> `idProducto`
--   `idProveedor`
--       `proveedor` -> `idProveedor`
--

--
-- Volcado de datos para la tabla `entradas`
--

INSERT INTO `entradas` (`idEntradas`, `codigo_Entrada`, `fecha_Entrada`, `cantidad_Entrada`, `idProveedor`) VALUES
(1, 1, '2022-04-19', 10, 1),
(2, 2, '2022-04-10', 15, 1),
(3, 1, '2022-04-20', 60, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario`
--
-- Creación: 19-04-2022 a las 22:03:50
--

DROP TABLE IF EXISTS `inventario`;
CREATE TABLE IF NOT EXISTS `inventario` (
  `idInventario` int NOT NULL AUTO_INCREMENT,
  `codigo_Inventario` int NOT NULL,
  `entrada_Inventario` int NOT NULL,
  `cantidad_Salida` int NOT NULL,
  `stock` int NOT NULL,
  PRIMARY KEY (`idInventario`),
  KEY `fk_Inventario_Producto1_idx` (`codigo_Inventario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

--
-- RELACIONES PARA LA TABLA `inventario`:
--   `codigo_Inventario`
--       `producto` -> `idProducto`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--
-- Creación: 19-04-2022 a las 22:03:40
--

DROP TABLE IF EXISTS `producto`;
CREATE TABLE IF NOT EXISTS `producto` (
  `idProducto` int NOT NULL,
  `nom_Producto` varchar(45) NOT NULL,
  `descripcion_Producto` varchar(45) DEFAULT NULL,
  `precio_Producto` decimal(10,0) NOT NULL,
  `precio_sugerido` decimal(10,0) NOT NULL,
  `fecha_registro` datetime NOT NULL,
  `idProveedor` int NOT NULL,
  PRIMARY KEY (`idProducto`),
  KEY `fk_Producto_Proveedor1_idx` (`idProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- RELACIONES PARA LA TABLA `producto`:
--   `idProveedor`
--       `proveedor` -> `idProveedor`
--

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `nom_Producto`, `descripcion_Producto`, `precio_Producto`, `precio_sugerido`, `fecha_registro`, `idProveedor`) VALUES
(1, 'Coca 2.5L', 'Refresco', '30', '38', '2022-04-19 00:00:00', 1),
(2, 'Coca Cola 1L', 'Refresco de 1 L', '20', '25', '2022-04-19 00:00:00', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--
-- Creación: 19-04-2022 a las 22:03:33
--

DROP TABLE IF EXISTS `proveedor`;
CREATE TABLE IF NOT EXISTS `proveedor` (
  `idProveedor` int NOT NULL,
  `nombre_Proveedor` varchar(45) NOT NULL,
  `telefono_Proveedor` bigint NOT NULL,
  `telefono2_Proveedor` bigint NOT NULL,
  `direccion_Proveedor` varchar(45) NOT NULL,
  `email_Proveedor` varchar(45) NOT NULL,
  `descripcion_Proveedor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- RELACIONES PARA LA TABLA `proveedor`:
--

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`idProveedor`, `nombre_Proveedor`, `telefono_Proveedor`, `telefono2_Proveedor`, `direccion_Proveedor`, `email_Proveedor`, `descripcion_Proveedor`) VALUES
(1, 'Coca Cola', 81819568, 9196, 'Aqui', 'www@algo.com', 'el chido');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--
-- Creación: 19-04-2022 a las 22:03:55
--

-- DROP TABLE IF EXISTS `rol`;
-- CREATE TABLE IF NOT EXISTS `rol` (
--   `idRol` int NOT NULL,
  -- `nombre_Rol` varchar(45) NOT NULL,
  -- PRIMARY KEY (`idRol`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- RELACIONES PARA LA TABLA `rol`:
--

--
-- Volcado de datos para la tabla `rol`
--

-- INSERT INTO `rol` (`idRol`, `nombre_Rol`) VALUES
-- (1, 'Administrador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salidas`
--
-- Creación: 19-04-2022 a las 22:03:59
--

DROP TABLE IF EXISTS `salidas`;
CREATE TABLE IF NOT EXISTS `salidas` (
  `idSalidas` int NOT NULL AUTO_INCREMENT,
  `codigo_Salida` int NOT NULL,
  `fecha_Salida` date NOT NULL,
  `cantidad_Salida` int NOT NULL,
  `idCliente` int NOT NULL,
  PRIMARY KEY (`idSalidas`),
  KEY `fk_Salidas_Cliente1_idx` (`idCliente`),
  KEY `fk_Salidas_Producto1_idx` (`codigo_Salida`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

--
-- RELACIONES PARA LA TABLA `salidas`:
--   `idCliente`
--       `cliente` -> `idCliente`
--   `codigo_Salida`
--       `producto` -> `idProducto`
--

--
-- Volcado de datos para la tabla `salidas`
--

INSERT INTO `salidas` (`idSalidas`, `codigo_Salida`, `fecha_Salida`, `cantidad_Salida`, `idCliente`) VALUES
(1, 1, '2022-05-01', 10, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--
-- Creación: 19-04-2022 a las 22:04:13
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `idUsuario` int NOT NULL,
  `identidad_Usuario` varchar(45) NOT NULL,
  `contra_Usuario` varchar(45) NOT NULL,
  `nombres_Usuario` varchar(45) NOT NULL,
  `apellido1_Usuario` varchar(45) NOT NULL,
  `apellido2_Usuario` varchar(45) NOT NULL,
 -- `idRol` int NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `idUsuario_UNIQUE` (`idUsuario`)
  -- KEY `fk_Usuario_Rol_idx` (`idRol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- RELACIONES PARA LA TABLA `usuario`:
--   `idRol`
--       `rol` -> `idRol`
--

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `identidad_Usuario`, `contra_Usuario`, `nombres_Usuario`, `apellido1_Usuario`, `apellido2_Usuario`, `idRol`) VALUES
(1, 'test', 'prueba', 'Jose', 'Alvarez', 'Martinez');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `entradas`
--
ALTER TABLE `entradas`
  ADD CONSTRAINT `fk_Entradas_Producto1` FOREIGN KEY (`codigo_Entrada`) REFERENCES `producto` (`idProducto`),
  ADD CONSTRAINT `fk_Entradas_Proveedor` FOREIGN KEY (`idProveedor`) REFERENCES `proveedor` (`idProveedor`);

--
-- Filtros para la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD CONSTRAINT `fk_Inventario_Producto1` FOREIGN KEY (`codigo_Inventario`) REFERENCES `producto` (`idProducto`) ON DELETE CASCADE;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `fk_Producto_Proveedor1` FOREIGN KEY (`idProveedor`) REFERENCES `proveedor` (`idProveedor`) ON DELETE CASCADE;

--
-- Filtros para la tabla `salidas`
--
ALTER TABLE `salidas`
  ADD CONSTRAINT `fk_Salidas_Cliente1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`),
  ADD CONSTRAINT `fk_Salidas_Producto1` FOREIGN KEY (`codigo_Salida`) REFERENCES `producto` (`idProducto`);

--
-- Filtros para la tabla `usuario`
--
-- ALTER TABLE `usuario`
  -- ADD CONSTRAINT `fk_Usuario_Rol` FOREIGN KEY (`idRol`) REFERENCES `rol` (`idRol`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
