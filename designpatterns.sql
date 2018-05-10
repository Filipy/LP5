-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: 03-Maio-2018 às 03:41
-- Versão do servidor: 5.7.21
-- PHP Version: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `designpatterns`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `evento`
--

DROP TABLE IF EXISTS `evento`;
CREATE TABLE IF NOT EXISTS `evento` (
  `id` int(11) NOT NULL,
  `palestrante` varchar(88) NOT NULL,
  `titulo` varchar(88) NOT NULL,
  `quantAlunos` varchar(88) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
CREATE TABLE IF NOT EXISTS `pessoa` (
  `nome` varchar(80) NOT NULL,
  `email` varchar(80) NOT NULL,
  `tipoUsuario` varchar(80) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pessoa`
--

INSERT INTO `pessoa` (`nome`, `email`, `tipoUsuario`) VALUES
('esesses', 'saddsadsdsa', 'Aluno'),
('eeeee', 'eeeeee', 'Professor');

-- --------------------------------------------------------

--
-- Estrutura da tabela `proposta`
--

DROP TABLE IF EXISTS `proposta`;
CREATE TABLE IF NOT EXISTS `proposta` (
  `tituloAtividade` varchar(80) NOT NULL,
  `finalidadeAtividade` varchar(80) NOT NULL,
  `cargaHoraria` varchar(80) NOT NULL,
  `nomeEstado` varchar(80) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `proposta`
--

INSERT INTO `proposta` (`tituloAtividade`, `finalidadeAtividade`, `cargaHoraria`, `nomeEstado`) VALUES
('aaaa', 'aaaaaa', 'aaaa', 'aaaaaaa'),
('bb', 'bb', 'bb', 'EmAnalise'),
('bb', 'bb', 'bb', 'EmAnalise'),
('wwww', 'wwww', 'qqqq', 'Reprovado'),
('qqq', 'qqq', 'qqqqq', 'Aprovado');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
