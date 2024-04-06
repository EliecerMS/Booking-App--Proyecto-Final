CREATE SCHEMA bookingBD;
create user 'clientebooking'@'%' identified by 'cliente123';
GRANT ALL PRIVILEGES ON bookingBD.* TO 'clientebooking'@'%';
FLUSH PRIVILEGES;

use bookingBD;

-- Ejemplo creacion de tabla con FKs
-- CREATE TABLE `producto` (
--  `id_producto` int NOT NULL AUTO_INCREMENT,
--  `id_categoria` int NOT NULL,
--  `descripcion` varchar(30) NOT NULL,
--  `detalle` varchar(1600) NOT NULL,
--  `precio` double DEFAULT NULL,
--  `existencias` int DEFAULT NULL,
--  `ruta_imagen` varchar(1024) DEFAULT NULL,
--  `activo` tinyint(1) DEFAULT NULL,
--  PRIMARY KEY (`id_producto`),
--  KEY `fk_producto_caregoria` (`id_categoria`),
--  CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

create table destino
(
id_destino int auto_increment primary key, 
localizacion varchar(50) NOT NULL,
pais varchar(35) NOT NULL,
ciudad varchar(35) NOT NULL,
nombre_destino varchar(70) NOT NULL,
ruta_imagen varchar(1024) NOT NULL,
descripcion_general varchar(60) NOT NULL,
descripcion_media varchar(200) NOT NULL,
precio_noche DECIMAL(10,2) NOT NULL,
descuento varchar(15) NOT NULL,
descripcion_detalles varchar(600) NOT NULL,
destacado varchar(500) NOT NULL,
inclusion_uno varchar(70) NOT NULL,
inclusion_dos varchar(70) NOT NULL,
inclusion_tres varchar(70) NOT NULL,
exclusion_uno varchar(70) NOT NULL,
exclusion_dos varchar(70) NOT NULL,
exclusion_tres varchar(70) NOT NULL,
condiciones_reembolso varchar(150) NOT NULL,
habitaciones INT NOT NULL,
cantidad_huespedes INT NOT NULL,
camas INT NOT NULL,
bannos INT NOT NULL,
rating INT NOT NULL,
start_date DATE NOT NULL,
end_date DATE NOT NULL
);

CREATE TABLE usuario (
  id_usuario int auto_increment primary key,
  nombre varchar(70) NOT NULL,
  primer_apellido varchar(70) NOT NULL,
  segundo_apellido varchar(70) DEFAULT NULL,
  telefono varchar(70) NOT NULL,
  email varchar(70) NOT NULL,
  password varchar(68) NOT NULL,
  username varchar(20) NOT NULL,
  ruta_imagen varchar(1024) DEFAULT NULL,
  activo tinyint(1) DEFAULT NULL
);

CREATE TABLE rol (
  id_rol int NOT NULL AUTO_INCREMENT,
  nombre varchar(20) DEFAULT NULL,
  id_usuario int DEFAULT NULL,
  PRIMARY KEY (id_rol),
  KEY fk_rol_usuario (id_usuario),
  CONSTRAINT rol_ibfk_1 FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
);

create table reserva
(
id_reserva int auto_increment primary key, 
id_destino int NOT NULL,
id_usuario int NOT NULL,
cantidad_adultos int NOT NULL,
cantidad_ninnos int NULL,
noches int NOT NULL,
precio_total DECIMAL(10,2) NOT NULL,
CONSTRAINT fk_destino FOREIGN KEY (id_destino)  
REFERENCES destino(id_destino)  
ON DELETE CASCADE  
ON UPDATE CASCADE,
CONSTRAINT fk_usuario FOREIGN KEY (id_usuario)  
REFERENCES usuario(id_usuario)  
ON DELETE CASCADE  
ON UPDATE CASCADE
);

insert into bookingBD.destino (localizacion,pais,ciudad,nombre_destino,ruta_imagen,descripcion_general,descripcion_media,precio_noche,descuento,descripcion_detalles,destacado,inclusion_uno,inclusion_dos,inclusion_tres,exclusion_uno,exclusion_dos,exclusion_tres,condiciones_reembolso,habitaciones,cantidad_huespedes,camas,bannos,rating,start_date, end_date) values ('Guanacaste, Costa Rica', 'Costa Rica','Guanacaste','Hotel Resort Papagayo','https://lh3.googleusercontent.com/p/AF1QipNL0NpEyCxQAAE91dhaj7s3naKe6Ryhr9B4jamV=s680-w680-h510', 'Las mejores vistas hacia el golfo de papagayo','El mejor hotel, tambien con aire de aventura por las zonas cercanas (canopy, kayak, paracaidismo) y mucho mas',130.99,'10%','Este texto es de ejemplo de detalles en cuanto a este destino...Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.','Este es otro ejemplo de destacado para este destino en guanacaste...Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.', 'Wifi','Parqueo','3 Comidas del dia', 'Aire Acondicionado','Jacuzzi','Espacios recreativos al aire libre','Obten un reembolso de la totalidad al cancelar en los proximos 24 horas',5,10,5,3,5,'2024-01-01','2024-06-01');
insert into bookingBD.destino (localizacion,pais,ciudad,nombre_destino,ruta_imagen,descripcion_general,descripcion_media,precio_noche,descuento,descripcion_detalles,destacado,inclusion_uno,inclusion_dos,inclusion_tres,exclusion_uno,exclusion_dos,exclusion_tres,condiciones_reembolso,habitaciones,cantidad_huespedes,camas,bannos,rating,start_date, end_date) values ('Cartago, Costa Rica','Costa Rica','Cartago', 'Mount View Cartago','https://a0.muscache.com/im/pictures/ec2cdd14-129f-46c9-ac71-15c574db7969.jpg?im_w=720', 'La tranquilidad de la montaña','Para relajarse, pero ademas hay zonaz cercanas para disfrutar de la aventura',75,'15%','Este texto es de ejemplo de detalles en cuanto a este destino en Cartago...Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.','Este es otro ejemplo de destacado para este destino en Cartago...Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.', 'Parqueo','Wifi','Solo almuerzo (desayuno a bajo costo)', 'Calefaccion','Jacuzzi','Espacios recreativos al aire libre','Obten un reembolso de la totalidad al cancelar en los proximos 72 horas',3,6,3,2,3,'2024-02-01','2024-05-01');
insert into bookingBD.destino (localizacion,pais,ciudad,nombre_destino,ruta_imagen,descripcion_general,descripcion_media,precio_noche,descuento,descripcion_detalles,destacado,inclusion_uno,inclusion_dos,inclusion_tres,exclusion_uno,exclusion_dos,exclusion_tres,condiciones_reembolso,habitaciones,cantidad_huespedes,camas,bannos,rating,start_date, end_date) values ('Cartagena, Colombia','Colombia','Cartagena', 'Condo entero en Provincia de Cartagena, Colombia','https://a0.muscache.com/im/pictures/4d1b6644-c6a9-429e-9cd5-3aa707eafdb9.jpg?im_w=1200', 'Ático, a unos pasos de la playa','La tranquilidad de la playa y hermosos atardeceres',99.99,'12%','Este texto es de ejemplo de detalles en cuanto a este destino en Cartagena Colombia...Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.','Este es otro ejemplo de destacado para este destino en Cartagena...Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.', 'Parqueo','Wifi','Solo almuerzo (desayuno a bajo costo)', 'Calefaccion','Jacuzzi','Espacios recreativos al aire libre','Obten un reembolso de la totalidad al cancelar en los proximos 12 horas',5,15,5,3,3,'2024-01-01','2024-08-01');


INSERT INTO bookingBD.usuario
(
nombre,
primer_apellido,
segundo_apellido,
telefono,
email,
password,
username,
ruta_imagen,
activo)
values ('Pedro','Rivera','Mendoza','88556780','pedro@gmail.com','$2a$10$koGR7eS22Pv5KdaVJKDcge04ZB53iMiw76.UjHPY.XyVYlYqXnPbO','pedro05','',1);

INSERT INTO bookingBD.usuario
(
nombre,
primer_apellido,
segundo_apellido,
telefono,
email,
password,
username,
ruta_imagen,
activo)
values ('Maria','Baltodano','Cespedes','88556685','maria@gmail.com','$2a$10$koGR7eS22Pv5KdaVJKDcge04ZB53iMiw76.UjHPY.XyVYlYqXnPbO','mary','',1);


INSERT INTO bookingBD.rol (id_rol, nombre, id_usuario) VALUES (1,'ROLE_ADMIN',1);
INSERT INTO bookingBD.rol (id_rol, nombre, id_usuario) VALUES (2,'ROLE_VENDEDOR',1);
INSERT INTO bookingBD.rol (id_rol, nombre, id_usuario) VALUES (3,'ROLE_USER',1);
INSERT INTO bookingBD.rol (id_rol, nombre, id_usuario) VALUES (4,'ROLE_VENDEDOR',2);
INSERT INTO bookingBD.rol (id_rol, nombre, id_usuario) VALUES (5,'ROLE_USER',2);

-- DROP DATABASE bookingBD;