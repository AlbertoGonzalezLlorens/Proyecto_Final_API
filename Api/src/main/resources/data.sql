/*drop database if exists proyecto;*/
/*create database proyecto;
use proyecto;*/

drop table if exists roles;
create table roles(
id_rol long auto_increment primary key,
nombre varchar (50) not null
);

insert into roles (nombre) values ('admin');
insert into roles (nombre) values ('loser');

drop table if exists usuarios;
create table usuarios(
id_usuario int auto_increment primary key,
nombre varchar (50) not null,
apellidos varchar(50),
email varchar(50) not null unique,
contraseña varchar(50) not null,
foto blob,
telefono int,
id_rol int not null,
foreign key (id_rol) references roles(id_rol) on delete cascade on update cascade
);

insert into usuarios (nombre,apellidos,email,contraseña,foto,telefono,id_rol) values ('Ivan','D. Panetone','ivanhrt@gmail.com','legustangrandes',null,659852147,2);
insert into usuarios (nombre,apellidos,email,contraseña,foto,telefono,id_rol) values ('Alberto','D. God','diosito@gmail.com','catacrack',null,659852148,1);

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
id_registrador int not null,
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

drop table if exists facturas;
create table facturas(
id_factura int auto_increment primary key,
fecha_inicio date,
fecha_fin date,
numero_personas int,
desayuno boolean
);

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

drop table if exists agregan_favoritos;
create table agregan_favoritos(
id_agregan_favoritos int auto_increment primary key,
id_usuario int not null,
id_hotel int not null,
foreign key (id_usuario) references usuarios(id_usuario) on delete cascade on update cascade,
foreign key (id_hotel) references hoteles(id_hotel) on delete cascade on update cascade
);

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

drop table if exists buscan;
create table buscan(
id_busca int auto_increment primary key,
id_usuario int not null,
id_hotel int not null,
foreign key (id_usuario) references usuarios(id_usuario) on delete cascade on update cascade,
foreign key (id_hotel) references hoteles(id_hotel) on delete cascade on update cascade
);