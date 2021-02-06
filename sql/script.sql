CREATE TABLE `clientes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(50) NOT NULL,
  `dui` varchar(255) NOT NULL,
  `nombres` varchar(50) NOT NULL,
  `sexo` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
);

CREATE TABLE `productos` (
  `id` bigint(20) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) NOT NULL,
  `precio` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `ordenes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `id_cliente` bigint(20) DEFAULT NULL,
  `id_producto` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ordenes_id_cliente` (`id_cliente`),
  KEY `FK_ordenes_id_producto` (`id_producto`),
  CONSTRAINT `FK_ordenes_id_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id`),
  CONSTRAINT `FK_ordenes_id_producto` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id`)
);