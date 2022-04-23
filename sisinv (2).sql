-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-04-2022 a las 22:21:16
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.10

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

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `NUEVO_CLIENTE` (`CODIGO` VARCHAR(10))  INSERT INTO Cliente (idCliente) VALUES (CODIGO)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `NUEVO_PRODUCTO` (`CODIGO` VARCHAR(10))  INSERT INTO Inventario (codigo_Inventario) VALUES (CODIGO)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `NUEVO_PROVEEDOR` (`CODIGO` VARCHAR(10))  INSERT INTO Proveedor (idProveedor) VALUES (CODIGO)$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `nombre_Cliente` varchar(45) NOT NULL,
  `apellido_Cliente` varchar(45) NOT NULL,
  `apellido2_Cliente` varchar(45) NOT NULL,
  `telefono_Cliente` bigint(10) NOT NULL,
  `email_Cliente` varchar(45) NOT NULL,
  `direccion_Cliente` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idCliente`, `nombre_Cliente`, `apellido_Cliente`, `apellido2_Cliente`, `telefono_Cliente`, `email_Cliente`, `direccion_Cliente`) VALUES
(1, 'Pepe', 'Perez', 'Rodriguez', 1234569871, 'ejemplocliente@gmail.com', 'Monterrey'),
(2, 'Paco', 'Mendez', 'Sanchez', 1236549889, 'ejemplo2@gmail.com', 'Monterrey');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entradas`
--

CREATE TABLE `entradas` (
  `idEntradas` int(11) NOT NULL,
  `codigo_Entrada` int(11) NOT NULL,
  `fecha_Entrada` date NOT NULL,
  `cantidad_Entrada` int(11) NOT NULL,
  `idProveedor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario`
--

CREATE TABLE `inventario` (
  `idInventario` int(11) NOT NULL,
  `codigo_Inventario` int(11) NOT NULL,
  `entrada_Inventario` int(11) NOT NULL,
  `cantidad_Salida` int(11) NOT NULL,
  `stock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL,
  `nom_Producto` varchar(45) NOT NULL,
  `descripcion_Producto` varchar(45) DEFAULT NULL,
  `precio_Producto` decimal(10,0) NOT NULL,
  `precio_sugerido` decimal(10,0) NOT NULL,
  `fecha_registro` datetime NOT NULL,
  `idProveedor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `nom_Producto`, `descripcion_Producto`, `precio_Producto`, `precio_sugerido`, `fecha_registro`, `idProveedor`) VALUES
(1, 'Agua Ciel', 'Agua purificada', '12', '12', '2022-02-22 00:00:00', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `idProveedor` int(11) NOT NULL,
  `nombre_Proveedor` varchar(45) NOT NULL,
  `telefono_Proveedor` bigint(10) NOT NULL,
  `telefono2_Proveedor` bigint(10) NOT NULL,
  `direccion_Proveedor` varchar(45) NOT NULL,
  `email_Proveedor` varchar(45) NOT NULL,
  `descripcion_Proveedor` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`idProveedor`, `nombre_Proveedor`, `telefono_Proveedor`, `telefono2_Proveedor`, `direccion_Proveedor`, `email_Proveedor`, `descripcion_Proveedor`) VALUES
(1, 'Coca Cola', 1234567890, 1234567891, 'Monterrey, Nuevo Leon', 'serviciococacola@cocacola.mx', NULL),
(2, 'Pepsi', 1326547890, 1236549870, 'Monterrey, Nuevo Leon', 'pepsi@pepsi.com', '2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `idRol` int(11) NOT NULL,
  `nombre_Rol` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`idRol`, `nombre_Rol`) VALUES
(1, 'Administrador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salidas`
--

CREATE TABLE `salidas` (
  `idSalidas` int(11) NOT NULL,
  `codigo_Salida` int(11) NOT NULL,
  `fecha_Salida` date NOT NULL,
  `cantidad_Salida` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `identidad_Usuario` varchar(45) NOT NULL,
  `contra_Usuario` varchar(45) NOT NULL,
  `nombres_Usuario` varchar(45) NOT NULL,
  `apellido1_Usuario` varchar(45) NOT NULL,
  `apellido2_Usuario` varchar(45) NOT NULL,
  `idRol` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `identidad_Usuario`, `contra_Usuario`, `nombres_Usuario`, `apellido1_Usuario`, `apellido2_Usuario`, `idRol`) VALUES
(1, 'admin', '12345', 'Jose Jesus', 'Morales ', 'Guerrero', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indices de la tabla `entradas`
--
ALTER TABLE `entradas`
  ADD PRIMARY KEY (`idEntradas`),
  ADD KEY `fk_Entradas_Proveedor_idx` (`idProveedor`),
  ADD KEY `fk_Entradas_Producto1_idx` (`codigo_Entrada`);

--
-- Indices de la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD PRIMARY KEY (`idInventario`),
  ADD KEY `fk_Inventario_Producto1_idx` (`codigo_Inventario`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`),
  ADD KEY `fk_Producto_Proveedor1_idx` (`idProveedor`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`idProveedor`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`idRol`);

--
-- Indices de la tabla `salidas`
--
ALTER TABLE `salidas`
  ADD PRIMARY KEY (`idSalidas`),
  ADD KEY `fk_Salidas_Cliente1_idx` (`idCliente`),
  ADD KEY `fk_Salidas_Producto1_idx` (`codigo_Salida`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`),
  ADD UNIQUE KEY `idUsuario_UNIQUE` (`idUsuario`),
  ADD KEY `fk_Usuario_Rol_idx` (`idRol`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `entradas`
--
ALTER TABLE `entradas`
  MODIFY `idEntradas` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `inventario`
--
ALTER TABLE `inventario`
  MODIFY `idInventario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `salidas`
--
ALTER TABLE `salidas`
  MODIFY `idSalidas` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `entradas`
--
ALTER TABLE `entradas`
  ADD CONSTRAINT `fk_Entradas_Producto1` FOREIGN KEY (`codigo_Entrada`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Entradas_Proveedor` FOREIGN KEY (`idProveedor`) REFERENCES `proveedor` (`idProveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD CONSTRAINT `fk_Inventario_Producto1` FOREIGN KEY (`codigo_Inventario`) REFERENCES `producto` (`idProducto`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `fk_Producto_Proveedor1` FOREIGN KEY (`idProveedor`) REFERENCES `proveedor` (`idProveedor`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Filtros para la tabla `salidas`
--
ALTER TABLE `salidas`
  ADD CONSTRAINT `fk_Salidas_Cliente1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Salidas_Producto1` FOREIGN KEY (`codigo_Salida`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_Usuario_Rol` FOREIGN KEY (`idRol`) REFERENCES `rol` (`idRol`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
