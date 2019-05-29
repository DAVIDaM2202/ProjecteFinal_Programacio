-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-05-2019 a las 19:14:54
-- Versión del servidor: 10.1.37-MariaDB
-- Versión de PHP: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `projectefinal`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `activitat`
--

CREATE TABLE `activitat` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `descripcio` varchar(500) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `dia` date NOT NULL,
  `diafinal` date NOT NULL,
  `localitat` int(11) NOT NULL,
  `categoria` int(11) NOT NULL,
  `creador` varchar(50) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `activitat`
--

INSERT INTO `activitat` (`id`, `nom`, `descripcio`, `dia`, `diafinal`, `localitat`, `categoria`, `creador`) VALUES
(1, 'Visita al Dali', 'El proxim divendres es vol anar a visitar el museu dali ja que es realitzara un descompte', '2019-05-24', '2019-05-24', 1, 2, 'david'),
(2, 'Semana del Cine', 'A girona el aquesta setmana es la setmana del Cine, i es m\'agradaria anar el dimecres', '2019-05-22', '2019-05-22', 2, 1, 'tomas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `activitat_persones_inscrites`
--

CREATE TABLE `activitat_persones_inscrites` (
  `id` int(11) NOT NULL,
  `persona` int(11) NOT NULL,
  `activitat` int(11) NOT NULL,
  `asistira` varchar(2) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `activitat_persones_inscrites`
--

INSERT INTO `activitat_persones_inscrites` (`id`, `persona`, `activitat`, `asistira`) VALUES
(1, 1, 1, '1'),
(2, 2, 2, '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id`, `nom`) VALUES
(1, 'Oci'),
(2, 'Cultura');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentari`
--

CREATE TABLE `comentari` (
  `id` int(11) NOT NULL,
  `text` varchar(500) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `activitat` int(11) NOT NULL,
  `persona` int(11) NOT NULL,
  `data` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `comentari`
--

INSERT INTO `comentari` (`id`, `text`, `activitat`, `persona`, `data`) VALUES
(1, 'Perfecte, per la tarda hi ha menos gent', 2, 1, '2019-05-19'),
(2, 'Perfecte, jo asisitre, podem anar a veure la de Guerra Mundia Z', 2, 2, '2019-05-19');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `localitat`
--

CREATE TABLE `localitat` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `latitud` varchar(100) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `longitud` varchar(100) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `localitat`
--

INSERT INTO `localitat` (`id`, `nom`, `latitud`, `longitud`) VALUES
(1, 'Figueres', '42.2666314', '2.9638434'),
(2, 'Girona', '41.9793006', '2.8199439');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `id` int(11) NOT NULL,
  `userdjango` int(11) NOT NULL,
  `nom` varchar(50) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `cognom` varchar(50) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `correu` varchar(50) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`id`, `userdjango`, `nom`, `cognom`, `correu`) VALUES
(1, 1, 'david', 'ayachi', 'david@gmail.com'),
(2, 2, 'tomas', 'puig', 'tomas@gmail.com'),
(3, 3, 'carlos', 'carlos', 'ca@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `userdjango`
--

CREATE TABLE `userdjango` (
  `id` int(11) NOT NULL,
  `username` varchar(100) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `password` varchar(100) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `userdjango`
--

INSERT INTO `userdjango` (`id`, `username`, `password`) VALUES
(1, 'david', 'david2202'),
(2, 'tomas', 'tomas2202'),
(3, 'carlos', 'carlos'),
(4, 'klk', 'klk'),
(5, 'klk', 'klk');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `activitat`
--
ALTER TABLE `activitat`
  ADD PRIMARY KEY (`id`),
  ADD KEY `localitat_fk` (`localitat`),
  ADD KEY `categoria_fk` (`categoria`);

--
-- Indices de la tabla `activitat_persones_inscrites`
--
ALTER TABLE `activitat_persones_inscrites`
  ADD PRIMARY KEY (`persona`,`activitat`),
  ADD KEY `activitat_fk` (`activitat`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `comentari`
--
ALTER TABLE `comentari`
  ADD PRIMARY KEY (`id`),
  ADD KEY `comentari_fk` (`activitat`),
  ADD KEY `cpersona_fk` (`persona`);

--
-- Indices de la tabla `localitat`
--
ALTER TABLE `localitat`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_fk` (`userdjango`);

--
-- Indices de la tabla `userdjango`
--
ALTER TABLE `userdjango`
  ADD PRIMARY KEY (`id`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `activitat`
--
ALTER TABLE `activitat`
  ADD CONSTRAINT `categoria_fk` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`id`),
  ADD CONSTRAINT `localitat_fk` FOREIGN KEY (`localitat`) REFERENCES `localitat` (`id`);

--
-- Filtros para la tabla `activitat_persones_inscrites`
--
ALTER TABLE `activitat_persones_inscrites`
  ADD CONSTRAINT `activitat_fk` FOREIGN KEY (`activitat`) REFERENCES `activitat` (`id`),
  ADD CONSTRAINT `persona_fk` FOREIGN KEY (`persona`) REFERENCES `persona` (`id`);

--
-- Filtros para la tabla `comentari`
--
ALTER TABLE `comentari`
  ADD CONSTRAINT `comentari_fk` FOREIGN KEY (`activitat`) REFERENCES `activitat` (`id`),
  ADD CONSTRAINT `cpersona_fk` FOREIGN KEY (`persona`) REFERENCES `persona` (`id`);

--
-- Filtros para la tabla `persona`
--
ALTER TABLE `persona`
  ADD CONSTRAINT `user_fk` FOREIGN KEY (`userdjango`) REFERENCES `userdjango` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
