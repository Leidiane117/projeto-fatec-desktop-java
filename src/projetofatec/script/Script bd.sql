-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           8.0.31 - MySQL Community Server - GPL
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para bd_lanchonete
CREATE DATABASE IF NOT EXISTS `bd_lanchonete` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_lanchonete`;

-- Copiando estrutura para tabela bd_lanchonete.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(80) NOT NULL,
  `celular` varchar(11) NOT NULL,
  `email` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela bd_lanchonete.cliente: ~6 rows (aproximadamente)
INSERT IGNORE INTO `cliente` (`id`, `nome`, `celular`, `email`) VALUES
	(1, 'Leidiane', '965041901', 'leidiane5499@hotmail.com'),
	(2, 'Mauro ricardo', '11985668448', 'mauro@hotmail.com'),
	(3, 'Eloina Soares', '11985758448', 'elo@hotmail.com'),
	(4, 'antônia ', '119112355', 'antonia@hotmail.com'),
	(7, 'Gabriel', '11965041988', 'gabi@hotmail.com'),
	(8, 'Maria', '11987176088', 'maria@maria.com');

-- Copiando estrutura para tabela bd_lanchonete.login
CREATE TABLE IF NOT EXISTS `login` (
  `id` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `usuario` char(10) NOT NULL DEFAULT '',
  `senha` char(4) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela bd_lanchonete.login: ~1 rows (aproximadamente)
INSERT IGNORE INTO `login` (`id`, `usuario`, `senha`) VALUES
	('1', 'admin', '123');

-- Copiando estrutura para tabela bd_lanchonete.pedido
CREATE TABLE IF NOT EXISTS `pedido` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_cliente` int NOT NULL,
  `id_produto` int NOT NULL,
  `valor` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_produto` (`id_produto`),
  KEY `id_cliente` (`id_cliente`),
  CONSTRAINT `id_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`),
  CONSTRAINT `id_produto` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela bd_lanchonete.pedido: ~4 rows (aproximadamente)
INSERT IGNORE INTO `pedido` (`id`, `id_cliente`, `id_produto`, `valor`) VALUES
	(2, 4, 1, 50),
	(3, 3, 1, 50),
	(4, 3, 1, 100),
	(5, 2, 3, 25);

-- Copiando estrutura para tabela bd_lanchonete.produto
CREATE TABLE IF NOT EXISTS `produto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(80) NOT NULL,
  `preco` double NOT NULL,
  `descricao` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela bd_lanchonete.produto: ~5 rows (aproximadamente)
INSERT IGNORE INTO `produto` (`id`, `nome`, `preco`, `descricao`) VALUES
	(1, 'bolo de chocolate', 3.5, NULL),
	(2, 'Açaí 400ml', 5, ''),
	(3, 'mousse de maracujá', 3.6, NULL),
	(4, 'x burguer', 10, NULL),
	(5, 'x salada', 15, NULL);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
