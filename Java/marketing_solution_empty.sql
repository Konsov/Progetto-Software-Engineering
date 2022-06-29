-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Creato il: Gen 26, 2017 alle 16:46
-- Versione del server: 10.1.19-MariaDB
-- Versione PHP: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `marketing_solution_empty`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `accounts`
--

CREATE TABLE `accounts` (
  `idaccount` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `clients`
--

CREATE TABLE `clients` (
  `idclients` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `materiali`
--

CREATE TABLE `materiali` (
  `idmateriali` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `prezzo` float NOT NULL,
  `nomeprogetto` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `progetticartellonistica`
--

CREATE TABLE `progetticartellonistica` (
  `idprogetticartellonistica` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `tipoprogetto` varchar(45) NOT NULL,
  `prezzo` float NOT NULL,
  `tempoimpiegato` float DEFAULT NULL,
  `statoordine` varchar(45) NOT NULL,
  `idcliente` int(11) NOT NULL,
  `scadenza` varchar(45) NOT NULL,
  `ndipendentiassegnati` int(11) NOT NULL,
  `tipocartelloni` varchar(45) NOT NULL,
  `proposta1` int(11) NOT NULL,
  `quantita1` int(11) DEFAULT NULL,
  `altezza1` float DEFAULT NULL,
  `larghezza1` float DEFAULT NULL,
  `proposta2` int(11) NOT NULL,
  `quantita2` int(11) DEFAULT NULL,
  `altezza2` float DEFAULT NULL,
  `larghezza2` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `progettievento`
--

CREATE TABLE `progettievento` (
  `idprogettievento` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `tipoprogetto` varchar(45) NOT NULL,
  `prezzo` float NOT NULL,
  `tempoimpiegato` float DEFAULT NULL,
  `statoordine` varchar(45) NOT NULL,
  `idcliente` int(11) NOT NULL,
  `scadenza` varchar(45) NOT NULL,
  `ndipendentiassegnati` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `progettifiera`
--

CREATE TABLE `progettifiera` (
  `idprogettifiera` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `tipoprogetto` varchar(45) NOT NULL,
  `prezzo` float NOT NULL,
  `tempoimpiegato` float DEFAULT NULL,
  `statoordine` varchar(45) NOT NULL,
  `idcliente` int(11) NOT NULL,
  `scadenza` varchar(45) NOT NULL,
  `ndipendentiassegnati` int(11) NOT NULL,
  `proposta1` int(11) NOT NULL,
  `proposta2` int(11) NOT NULL,
  `descrizione` varchar(2000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `progettionline`
--

CREATE TABLE `progettionline` (
  `idprogettionline` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `tipoprogetto` varchar(45) NOT NULL,
  `prezzo` float NOT NULL,
  `tempoimpiegato` float DEFAULT NULL,
  `statoordine` varchar(45) NOT NULL,
  `idcliente` varchar(45) NOT NULL,
  `scadenza` varchar(45) NOT NULL,
  `ndipendentiassegnati` int(11) NOT NULL,
  `banner` int(11) NOT NULL,
  `sfondo` int(11) NOT NULL,
  `inserzionerettangolare` int(11) NOT NULL,
  `altezza` float DEFAULT NULL,
  `larghezza` float DEFAULT NULL,
  `inserzionequadrata` int(11) NOT NULL,
  `lato` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `progettistampa`
--

CREATE TABLE `progettistampa` (
  `idprogettistampa` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `tipoprogetto` varchar(45) NOT NULL,
  `prezzo` float NOT NULL,
  `tempoimpiegato` float DEFAULT NULL,
  `statoordine` varchar(45) NOT NULL,
  `idcliente` int(11) NOT NULL,
  `scadenza` varchar(45) NOT NULL,
  `ndipendentiassegnati` int(11) NOT NULL,
  `proposta1` int(11) NOT NULL,
  `quantita1` int(11) DEFAULT NULL,
  `proposta2` int(11) NOT NULL,
  `quantita2` int(11) DEFAULT NULL,
  `proposta3` int(11) NOT NULL,
  `quantita3` int(11) DEFAULT NULL,
  `altezza` float NOT NULL,
  `larghezza` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `serviziesterni`
--

CREATE TABLE `serviziesterni` (
  `idserviziesterni` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `prezzo` float NOT NULL,
  `nomeprogetto` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`idaccount`),
  ADD UNIQUE KEY `username_UNIQUE` (`username`);

--
-- Indici per le tabelle `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`idclients`),
  ADD UNIQUE KEY `email_UNIQUE` (`email`),
  ADD UNIQUE KEY `telefono_UNIQUE` (`telefono`);

--
-- Indici per le tabelle `materiali`
--
ALTER TABLE `materiali`
  ADD PRIMARY KEY (`idmateriali`);

--
-- Indici per le tabelle `progetticartellonistica`
--
ALTER TABLE `progetticartellonistica`
  ADD PRIMARY KEY (`idprogetticartellonistica`),
  ADD UNIQUE KEY `nome` (`nome`);

--
-- Indici per le tabelle `progettievento`
--
ALTER TABLE `progettievento`
  ADD PRIMARY KEY (`idprogettievento`),
  ADD UNIQUE KEY `nome` (`nome`);

--
-- Indici per le tabelle `progettifiera`
--
ALTER TABLE `progettifiera`
  ADD PRIMARY KEY (`idprogettifiera`),
  ADD UNIQUE KEY `nome` (`nome`);

--
-- Indici per le tabelle `progettionline`
--
ALTER TABLE `progettionline`
  ADD PRIMARY KEY (`idprogettionline`),
  ADD UNIQUE KEY `nome` (`nome`);

--
-- Indici per le tabelle `progettistampa`
--
ALTER TABLE `progettistampa`
  ADD PRIMARY KEY (`idprogettistampa`),
  ADD UNIQUE KEY `nome_UNIQUE` (`nome`);

--
-- Indici per le tabelle `serviziesterni`
--
ALTER TABLE `serviziesterni`
  ADD PRIMARY KEY (`idserviziesterni`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `accounts`
--
ALTER TABLE `accounts`
  MODIFY `idaccount` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT per la tabella `clients`
--
ALTER TABLE `clients`
  MODIFY `idclients` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT per la tabella `materiali`
--
ALTER TABLE `materiali`
  MODIFY `idmateriali` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;
--
-- AUTO_INCREMENT per la tabella `progetticartellonistica`
--
ALTER TABLE `progetticartellonistica`
  MODIFY `idprogetticartellonistica` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT per la tabella `progettievento`
--
ALTER TABLE `progettievento`
  MODIFY `idprogettievento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT per la tabella `progettifiera`
--
ALTER TABLE `progettifiera`
  MODIFY `idprogettifiera` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT per la tabella `progettionline`
--
ALTER TABLE `progettionline`
  MODIFY `idprogettionline` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT per la tabella `progettistampa`
--
ALTER TABLE `progettistampa`
  MODIFY `idprogettistampa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT per la tabella `serviziesterni`
--
ALTER TABLE `serviziesterni`
  MODIFY `idserviziesterni` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
