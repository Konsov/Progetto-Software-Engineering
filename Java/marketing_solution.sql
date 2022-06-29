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
-- Database: `marketing_solution`
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

--
-- Dump dei dati per la tabella `accounts`
--

INSERT INTO `accounts` (`idaccount`, `nome`, `cognome`, `username`, `password`) VALUES
(8, 'Matteo', 'Abiuso', 'admin', 'password'),
(9, 'Luca', 'Consonni', 'Conso', '12345');

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

--
-- Dump dei dati per la tabella `clients`
--

INSERT INTO `clients` (`idclients`, `nome`, `cognome`, `email`, `telefono`) VALUES
(25, 'Mario', 'Rossi', 'mariorossi@gmail.com', '3456789098'),
(26, 'Fabiano', 'Bianchi', 'fabiano.bianchi@yahoo.com', '03179436'),
(27, 'Vanessa', 'Johnson', 'vanessajh@hotmail.uk', '543223234'),
(28, 'Simone', 'Vivaldi', 'vivaldi89@outlook.com', '3934316189');

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

--
-- Dump dei dati per la tabella `materiali`
--

INSERT INTO `materiali` (`idmateriali`, `nome`, `prezzo`, `nomeprogetto`) VALUES
(36, 'Tavoli', 350, 'Fiera del Raviolo'),
(37, 'Colla', 150, 'Pubblicita'' Burger Kings'),
(38, 'Carta', 200, 'Pubblicita'' Burger Kings'),
(39, 'Toner', 1000, 'Pubblicita'' Burger Kings'),
(41, 'Toner', 200, 'Volantini Fashion Night'),
(42, 'Carta', 150, 'Volantini Fashion Night'),
(43, 'Teli', 200, 'Sfilata Fashion Night'),
(44, 'Ornamenti Palco', 300, 'Sfilata Fashion Night');

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

--
-- Dump dei dati per la tabella `progetticartellonistica`
--

INSERT INTO `progetticartellonistica` (`idprogetticartellonistica`, `nome`, `tipoprogetto`, `prezzo`, `tempoimpiegato`, `statoordine`, `idcliente`, `scadenza`, `ndipendentiassegnati`, `tipocartelloni`, `proposta1`, `quantita1`, `altezza1`, `larghezza1`, `proposta2`, `quantita2`, `altezza2`, `larghezza2`) VALUES
(9, 'Pubblicita'' Burger Kings', 'CARTELLONISTICA', 5000, 23, 'FATTURATO', 26, '2 Dicembre 2020', 3, 'STRADALE', 1, 1, 300, 400, 1, 2, 200, 500);

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

--
-- Dump dei dati per la tabella `progettievento`
--

INSERT INTO `progettievento` (`idprogettievento`, `nome`, `tipoprogetto`, `prezzo`, `tempoimpiegato`, `statoordine`, `idcliente`, `scadenza`, `ndipendentiassegnati`) VALUES
(14, 'Sfilata Fashion Night', 'EVENTO', 20000, 30, 'PREVENTIVATO', 27, '4 Agosto 2019', 2);

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

--
-- Dump dei dati per la tabella `progettifiera`
--

INSERT INTO `progettifiera` (`idprogettifiera`, `nome`, `tipoprogetto`, `prezzo`, `tempoimpiegato`, `statoordine`, `idcliente`, `scadenza`, `ndipendentiassegnati`, `proposta1`, `proposta2`, `descrizione`) VALUES
(7, 'Fiera del Raviolo', 'FIERA', 15000, 29, 'ACCETTATO', 25, '1 Febbraio 2019', 2, 0, 1, 'Stand ad angolo, 5m x 8m, doppia entrata, con esposizione a vista');

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

--
-- Dump dei dati per la tabella `progettionline`
--

INSERT INTO `progettionline` (`idprogettionline`, `nome`, `tipoprogetto`, `prezzo`, `tempoimpiegato`, `statoordine`, `idcliente`, `scadenza`, `ndipendentiassegnati`, `banner`, `sfondo`, `inserzionerettangolare`, `altezza`, `larghezza`, `inserzionequadrata`, `lato`) VALUES
(5, 'Sito FC Karnezis', 'ONLINE', 1500, 30, 'PAGATO', '28', '1 Aprile 2020', 3, 0, 1, 1, 10, 30, 0, 0);

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

--
-- Dump dei dati per la tabella `progettistampa`
--

INSERT INTO `progettistampa` (`idprogettistampa`, `nome`, `tipoprogetto`, `prezzo`, `tempoimpiegato`, `statoordine`, `idcliente`, `scadenza`, `ndipendentiassegnati`, `proposta1`, `quantita1`, `proposta2`, `quantita2`, `proposta3`, `quantita3`, `altezza`, `larghezza`) VALUES
(8, 'Volantini Fashion Night', 'STAMPA', 2000, 20, 'NEGOZIAZIONE', 27, '6 Luglio 2019', 5, 1, 100, 1, 25, 1, 80, 25, 15);

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
-- Dump dei dati per la tabella `serviziesterni`
--

INSERT INTO `serviziesterni` (`idserviziesterni`, `nome`, `prezzo`, `nomeprogetto`) VALUES
(45, 'Pitti', 1500, 'Sfilata Fashion Night'),
(46, 'Dj "GiovaneAgile"', 1400, 'Sfilata Fashion Night'),
(47, 'Servizio Fotografico', 800, 'Sfilata Fashion Night');

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
  MODIFY `idaccount` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT per la tabella `clients`
--
ALTER TABLE `clients`
  MODIFY `idclients` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
--
-- AUTO_INCREMENT per la tabella `materiali`
--
ALTER TABLE `materiali`
  MODIFY `idmateriali` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;
--
-- AUTO_INCREMENT per la tabella `progetticartellonistica`
--
ALTER TABLE `progetticartellonistica`
  MODIFY `idprogetticartellonistica` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT per la tabella `progettievento`
--
ALTER TABLE `progettievento`
  MODIFY `idprogettievento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT per la tabella `progettifiera`
--
ALTER TABLE `progettifiera`
  MODIFY `idprogettifiera` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT per la tabella `progettionline`
--
ALTER TABLE `progettionline`
  MODIFY `idprogettionline` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT per la tabella `progettistampa`
--
ALTER TABLE `progettistampa`
  MODIFY `idprogettistampa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT per la tabella `serviziesterni`
--
ALTER TABLE `serviziesterni`
  MODIFY `idserviziesterni` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
