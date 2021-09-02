-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 02-Set-2021 às 16:01
-- Versão do servidor: 10.4.17-MariaDB
-- versão do PHP: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `java`
--
CREATE DATABASE IF NOT EXISTS `java` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `java`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `clients`
--

CREATE TABLE `clients` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `clients`
--

INSERT INTO `clients` (`id`, `name`, `address`, `phone`, `email`) VALUES
(1, 'Jorge', 'Vila Suissa', '978977979', 'jorge@hotmail.com');

-- --------------------------------------------------------

--
-- Estrutura da tabela `order_services`
--

CREATE TABLE `order_services` (
  `id` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `equipament` varchar(150) DEFAULT NULL,
  `value` decimal(10,2) DEFAULT NULL,
  `service` varchar(150) DEFAULT NULL,
  `clientId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `order_services`
--

INSERT INTO `order_services` (`id`, `created_at`, `equipament`, `value`, `service`, `clientId`) VALUES
(1, '2021-07-27 17:10:23', 'Prego', '500.00', 'Pregar', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `profile` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `users`
--

INSERT INTO `users` (`id`, `username`, `phone`, `email`, `password`, `profile`) VALUES
(1, 'jorgaoo', '978977979', 'jorge@hotmail.com', '123', 'admin'),
(2, 'clebe', '1241254521521', 'clebe@hotmail.com', '123', 'user'),
(3, 'kachoro', '125415252151', 'kachoro@hotmail.com', '123', 'admin'),
(4, 'mt', '12412421', 'mt@', '123', 'User'),
(7, 'larrisa', '421421', 'j@', '421412', 'User'),
(8, 'mat', '414', 'r@', '123', 'User'),
(9, 'Long', '2512958129', 'long@hotmail.com', '123', 'Admin');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `order_services`
--
ALTER TABLE `order_services`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_client_order` (`clientId`);

--
-- Índices para tabela `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `clients`
--
ALTER TABLE `clients`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `order_services`
--
ALTER TABLE `order_services`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `order_services`
--
ALTER TABLE `order_services`
  ADD CONSTRAINT `FK_client_order` FOREIGN KEY (`clientId`) REFERENCES `clients` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
