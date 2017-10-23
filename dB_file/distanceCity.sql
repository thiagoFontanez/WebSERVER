-- Host: localhost
-- Tempo de geração: 21/10/2017 às 00:02
-- Versão do servidor: 10.1.25-MariaDB
-- Versão do PHP: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- data base `distanceCity`

--
-- struct table `city`
--

CREATE TABLE `city` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- dump data base `city`
--

INSERT INTO `city` (`id`, `name`, `latitude`, `longitude`) VALUES
(1, 'sao paulo', -23.533773, -46.62529),
(2, 'Campinas', -22.907104, -47.06324),
(3, 'curitiba', -25.441105, -49.276855),
(4, 'Serengeti Africa', -2.332577, 34.832153);

ALTER TABLE `city`
  ADD PRIMARY KEY (`id`);

-- AUTO_INCREMENT table `city`
--
ALTER TABLE `city`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
