CREATE SCHEMA bookingBD;
create user 'clientebooking'@'%' identified by 'cliente123';
GRANT ALL PRIVILEGES ON bookingBD.* TO 'clientebooking'@'%';
FLUSH PRIVILEGES;

use bookingBD;

create table destino
(
id_destino int auto_increment primary key, 
localizacion varchar(50),
nombre_destino varchar(70),
ruta_imagen varchar(1024),
descripcion_general varchar(60),
descripcion_media varchar(200),
precio_noche DECIMAL(10,2),
descuento varchar(15),
descripcion_detalles varchar(600),
destacado varchar(500),
inclusion_uno varchar(70),
inclusion_dos varchar(70),
inclusion_tres varchar(70),
exclusion_uno varchar(70),
exclusion_dos varchar(70),
exclusion_tres varchar(70)
);

insert into bookingBD.destino (localizacion,nombre_destino,ruta_imagen,descripcion_general,descripcion_media,precio_noche,descuento,descripcion_detalles,destacado,inclusion_uno,inclusion_dos,inclusion_tres,exclusion_uno,exclusion_dos,exclusion_tres) values ('Guanacaste, Costa Rica', 'Hotel Resort Papagayo','https://lh3.googleusercontent.com/p/AF1QipNL0NpEyCxQAAE91dhaj7s3naKe6Ryhr9B4jamV=s680-w680-h510', 'Las mejores vistas hacia el golfo de papagayo','El mejor hotel, tambien con aire de aventura por las zonas cercanas (canopy, kayak, paracaidismo) y mucho mas',130.99,'10%','Este texto es de ejemplo de detalles en cuanto a este destino...Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.','Este es otro ejemplo de destacado para este destino en guanacaste...Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.', 'Wifi','Parqueo','3 Comidas del dia', 'Aire Acondicionado','Jacuzzi','Espacios recreativos al aire libre');


insert into bookingBD.destino (localizacion,nombre_destino,ruta_imagen,descripcion_general,descripcion_media,precio_noche,descuento,descripcion_detalles,destacado,inclusion_uno,inclusion_dos,inclusion_tres,exclusion_uno,exclusion_dos,exclusion_tres) values ('Cartago, Costa Rica', 'Mount View Cartago','https://a0.muscache.com/im/pictures/ec2cdd14-129f-46c9-ac71-15c574db7969.jpg?im_w=720', 'La tranquilidad de la montaña','Para relajarse, pero ademas hay zonaz cercanas para disfrutar de la aventura',75,'15%','Este texto es de ejemplo de detalles en cuanto a este destino en Cartago...Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.','Este es otro ejemplo de destacado para este destino en Cartago...Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.', 'Parqueo','Wifi','Solo almuerzo (desayuno a bajo costo)', 'Calefaccion','Jacuzzi','Espacios recreativos al aire libre');