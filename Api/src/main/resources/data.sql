drop database if exists railway;
create database railway;
use railway;

drop table if exists roles;
create table roles(
id_rol int auto_increment primary key,
role varchar (50) not null
);

insert into roles (role) values ('admin');
insert into roles (role) values ('user');

drop table if exists usuarios;
create table usuarios(
id_usuario int auto_increment primary key,
username varchar(50) unique not null,
nombre varchar (50) not null,
apellidos varchar(50),
email varchar(50) not null unique,
password varchar(500) not null,
foto blob,
telefono int,
id_rol int DEFAULT 2,
foreign key (id_rol) references roles(id_rol) on delete cascade on update cascade
);



insert into usuarios (username,nombre,apellidos,email,password,foto,telefono,id_rol) values ('ivan','Ivan','D. Panetone','ivanhrt@gmail.com','$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.',null,659852147,1);
insert into usuarios (username,nombre,apellidos,email,password,foto,telefono,id_rol) values ('alberto','Alberto','D. God','diosito@gmail.com','$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.',null,659852148,1);

drop table if exists hoteles;
create table hoteles(
id_hotel int auto_increment primary key,
nombre varchar(50) not null,
descripcion varchar(300),
categoria int,
foto blob,
pais varchar(50) not null,
provincia varchar (50),
poblacion varchar(100) not null,
direccion varchar(150) not null,
codigo_postal int,
longitud double not null,
latitud double not null,
id_registrador int,
foreign key (id_registrador) references usuarios(id_usuario) on delete set null on update cascade
);

insert into hoteles (nombre,descripcion,categoria,foto,pais,provincia,poblacion,direccion,codigo_postal,longitud,latitud,id_registrador) values ('Hotel I','Not bad',3,null,'nuncajamas','provicnia','poblacion1','Dirección1',45362,1.25874,0.23657,1);
insert into hoteles (nombre,descripcion,categoria,foto,pais,provincia,poblacion,direccion,codigo_postal,longitud,latitud,id_registrador) values ('Hotel A','God',5,null,'la ostia','paraiso','poblacion2','Dirección2',33568,2.3547,1.23657,2);

drop table if exists habitaciones;
create table habitaciones(
id_habitacion int auto_increment primary key,
num_habitacion int not null,
tipo varchar (10),
descripcion varchar(300),
precio double not null,
foto blob,
id_hotel int not null,
foreign key (id_hotel) references hoteles(id_hotel) on delete cascade on update cascade
);

insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (111,'cool','Coolx2',12.35,null,1);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (112,'super cool','super Coolx2',22.35,null,2);

drop table if exists contactos;
create table contactos(
id_contacto int auto_increment primary key,
telefono_contacto int,
email varchar(50) not null,
id_hotel int not null,
foreign key (id_hotel) references hoteles(id_hotel) on delete cascade on update cascade
);

insert into contactos (telefono_contacto,email,id_hotel) values (11123456,'email 1',1);
insert into contactos (telefono_contacto,email,id_hotel) values (11245789,'email 2',2);

drop table if exists facturas;
create table facturas(
id_factura int auto_increment primary key,
fecha_inicio date,
fecha_fin date,
numero_personas int,
desayuno boolean
);

insert into facturas (fecha_inicio ,fecha_fin,numero_personas,desayuno) values ('2020-05-03','2020-06-03',1,true);
insert into facturas (fecha_inicio ,fecha_fin,numero_personas,desayuno) values ('2020-06-03','2021-05-03',3,false);

drop table if exists reservas;
create table reservas(
id_reserva int auto_increment primary key,
id_factura int not null,
id_usuario int not null,
id_habitacion int not null,
precio_final double default null,
foreign key (id_factura) references facturas(id_factura) on delete cascade on update cascade,
foreign key (id_usuario) references usuarios(id_usuario) on delete cascade on update cascade,
foreign key (id_habitacion) references habitaciones(id_habitacion) on delete cascade on update cascade
);

insert into reservas (id_factura,id_usuario,id_habitacion,precio_final) values (1,1,1,2300);
insert into reservas (id_factura,id_usuario,id_habitacion,precio_final) values (2,2,2,3652);

drop table if exists agregan_favoritos;
create table agregan_favoritos(
id_agregan_favoritos int auto_increment primary key,
id_usuario int not null,
id_hotel int not null,
foreign key (id_usuario) references usuarios(id_usuario) on delete cascade on update cascade,
foreign key (id_hotel) references hoteles(id_hotel) on delete cascade on update cascade
);

insert into agregan_favoritos (id_usuario,id_hotel) values (1,1);
insert into agregan_favoritos (id_usuario,id_hotel) values (2,2);

drop table if exists comentan;
create table comentan(
id_comenta int auto_increment primary key,
valoracion int not null,
comentario varchar(500),
id_usuario int not null,
id_hotel int not null,
foreign key (id_usuario) references usuarios(id_usuario) on delete cascade on update cascade,
foreign key (id_hotel) references hoteles(id_hotel) on delete cascade on update cascade
);

insert into comentan (valoracion,comentario,id_usuario,id_hotel) values (7,'shit',1,1);
insert into comentan (valoracion,comentario,id_usuario,id_hotel) values (6,'shit',2,2);

drop table if exists buscan;
create table buscan(
id_busca int auto_increment primary key,
id_usuario int not null,
id_hotel int not null,
foreign key (id_usuario) references usuarios(id_usuario) on delete cascade on update cascade,
foreign key (id_hotel) references hoteles(id_hotel) on delete cascade on update cascade
);

insert into buscan (id_usuario,id_hotel) values (1,1);
insert into buscan (id_usuario,id_hotel) values (2,2);