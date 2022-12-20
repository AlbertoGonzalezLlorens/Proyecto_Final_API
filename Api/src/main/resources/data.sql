drop database if exists railway;
create database railway;
use railway;

drop table if exists roles;
create table roles(
id_rol int auto_increment primary key,
nombre varchar (50) not null
);

insert into roles (nombre) values ('admin');
insert into roles (nombre) values ('user');

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
insert into usuarios (username,nombre,apellidos,email,password,foto,telefono,id_rol) values ('alberto','Alberto','D. God','diosito@gmail.com','$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.',null,659852148,2);

drop table if exists hoteles;
create table hoteles(
id_hotel int auto_increment primary key,
nombre varchar(50) not null,
descripcion varchar(2000),
categoria int,
foto blob,
pais varchar(50) not null,
provincia varchar (50),
poblacion varchar(100) not null,
direccion varchar(150) not null,
codigo_postal int,
longitud double not null,
latitud double not null,
desayuno boolean,
precio_min double,
id_registrador int,
foreign key (id_registrador) references usuarios(id_usuario) on delete set null on update cascade
);

insert into hoteles (nombre,descripcion,categoria,foto,pais,provincia,poblacion,direccion,codigo_postal,longitud,latitud,desayuno,precio_min,id_registrador) values ('Silken','Porque sabemos que viajar significa conocer pero también sentirse como en casa, en Silken Hoteles abogamos por ser tu refugio en cualquier punto de la geografía española. Todos los hoteles de autor de la cadena ponen a tu disposición el diseño de vanguardia, el confort, la funcionalidad y la mejor localización que buscas en cada una de tus experiencias. Te acogemos en unas instalaciones de calidad inmejorable y siempre con un trato atento y profesional por parte de nuestros empleados con el único objetivo de que disfrutes de nuestro hotel tanto como lo harás de tu viaje. Explora y piérdete en las principales ciudades españolas disfrutando de un acogedor hogar donde poder descansar después. Bienvenido a Silken Hoteles.',5,null,'España','Barcelona','Barcelona','Ramblas Barcelona 34', 08002, 41.37931728705166, 2.1752452267903957,true, 49.9, 1);
insert into hoteles (nombre,descripcion,categoria,foto,pais,provincia,poblacion,direccion,codigo_postal,longitud,latitud,desayuno,precio_min,id_registrador) values ('Bastardo','Si por el motivo que sea tu camino pasa por Madrid, Bastardo es tu destino. No somos un hotel, no somos un bar, no somos un espacio de creación. Somos todo eso y algunas cosas más. Huimos de la pureza. Somos un punto de encuentro para visitantes y madrileños en el centro de la ciudad, entre Malasaña y Chueca. Un laboratorio cultural abierto siempre a las últimas tendencias. Un ecosistema creado para el disfrute en el que puedes asistir a un concierto o a una proyección de una película de vanguardia, contemplar una exhibición, charlar tomando una copa con los tejados de Madrid de fondo, compartir una buena comida con amigos y, por supuesto, también alojarte. Todo con un cuidado diseño marca de la casa. En definitiva, Bastardo es una atalaya desde la que conquistar esta ciudad caótica, mestiza, vibrante y hospitalaria. Hazla tuya, no es difícil.',4,null,'España','Madrid','Madrid','C. de San Mateo, 3',28004,40.42545345880872, -3.700193517405064,false,45, 1);
insert into hoteles (nombre,descripcion,categoria,foto,pais,provincia,poblacion,direccion,codigo_postal,longitud,latitud,desayuno,precio_min,id_registrador) values ('Escondido','Escondido hace honor a su nombre, hallándose en una playa virgen de la costa del estado de Oaxaca. A muy poca distancia de Puerto Escondido, la meca mexicana del surf, este refugio de paz y tranquilidad te ofrece un escape a la rutina y estrés del día a día, no quedando otra opción que la de disfrutar. Sus dieciséis cabañas, su spa, albercas y restaurante hacen sentir al huésped en México en todo momento. Sus colores, cocina y sobre todo servicio y calor humanos, hacen inequívocamente mexicano a este escondite.',3,null,'México','Oaxaca','Oaxaca de Juárez','Av. José María Morelos 401, RUTA INDEPENDENCIA, Centro',68000,17.0638218554118, -96.72811337010772,true, 39.87, 1);
insert into hoteles (nombre,descripcion,categoria,foto,pais,provincia,poblacion,direccion,codigo_postal,longitud,latitud,desayuno,precio_min,id_registrador) values ('Urban','El Hotel Urban 5*GL está situado en el centro financiero, político, cultural y comercial de la capital española. Su propuesta gastronómica y la perfecta combinación entre arquitectura y diseño lo convierten en un hotel único en pleno Madrid de los Austrias.',2,null,'España','Madrid','Madrid','Cra de S. Jerónimo, 34',28014,40.41640621443502, -3.6986935510267145,false,35.21, 1);
insert into hoteles (nombre,descripcion,categoria,foto,pais,provincia,poblacion,direccion,codigo_postal,longitud,latitud,desayuno,precio_min,id_registrador) values ('Breathless','Disfrute de un entorno playero solo para personas adultas con la combinación perfecta de entretenimiento renovador y relajación total. Celebre el estilo de vida de Breathless con fabulosas comidas, cócteles artesanales, un servicio sobresaliente y experiencias de spa de primera clase en un fascinante entorno único. Deléitese con una fusión de música, moda, cultura y arte, y viva una experiencia como ninguna otra. Visite uno de nuestros elegantes resorts sociales en el Caribe o México y conozca las ofertas de Unlimited-Luxury® en Breathless Resorts & Spas®.',1,null,'Portugal','Lisboa','Lisboa','Av. Gen. Roçadas 3',1170,38.72246297206359, -9.128949801188098,true,30.1, 1);
insert into hoteles (nombre,descripcion,categoria,foto,pais,provincia,poblacion,direccion,codigo_postal,longitud,latitud,desayuno,precio_min,id_registrador) values ('Mimosa','Emplazado en un edificio modernista catalogado del siglo XIX y situado en la misma manzana que La Pedrera, el H10 Casa Mimosa es un exclusivo hotel de cuatro estrellas superior que combina elementos originales con una decoración elegante y atemporal. Destaca por sus amplias habitaciones, el Restaurante y Lobby Bar El Til·ler con acceso a un frondoso jardín con piscina. Además, cuenta con la Terraza El Cel de Gaudí, situada en la planta superior, con plunge pool y vistas privilegiadas a La Pedrera. El hotel también dispone de dos salas de reuniones con luz natural, una de ellas ubicada en una antigua cochera.',5,null,'España','Málaga','Málaga','C. Trinidad, 35',29009 ,36.82769523714159, -4.396657282362116,false,52.6, 1);
insert into hoteles (nombre,descripcion,categoria,foto,pais,provincia,poblacion,direccion,codigo_postal,longitud,latitud,desayuno,precio_min,id_registrador) values ('One & Only','A sparkling archipelago in the Indian Ocean, the Maldives is one of the worlds most desirable destinations. Marvel at the thriving ocean life, home to twenty one species of dolphin and whale, the Maldives is a natural playground for vibrant marine life',4,null,'España','Zamora','Zamora','la S/N, Pl. Sta. María Nueva',49001,41.503831019953935, -5.749043264843609,true,48.7, 1);
insert into hoteles (nombre,descripcion,categoria,foto,pais,provincia,poblacion,direccion,codigo_postal,longitud,latitud,desayuno,precio_min,id_registrador) values ('Smart','Si visitas este destino turístico, ya sea por negocios o placer, Smart Cancún es la alternativa perfecta al ser un resort con personalidad corporativa, pero con la comodidad y descanso que requieres. Este hotel es una opción inteligente que permite llevar a cabo esa reunión de negocios, con varias salas de juntas y servicio de coffee break. Su conveniente ubicación en una de las avenidas principales de la ciudad, muy cerca de la entrada a la zona hotelera, permite un rápido y fácil acceso a centros comerciales, restaurantes y playas',3,null,'Andorra','Andorra la Vella','Andorra la Vella','Av. Carlemany, 70, AD700 Escaldes-Engordany',700,42.50940921039436, 1.5352349072736007,false,43.52, 1);
insert into hoteles (nombre,descripcion,categoria,foto,pais,provincia,poblacion,direccion,codigo_postal,longitud,latitud,desayuno,precio_min,id_registrador) values ('DoubleTree','Spil Mountain is the backdrop for our hotel near prominent shops. We offer Turkish and world recipes in Adala Restaurant and relaxing treatments in our spa. Enjoy access to the indoor pool and fitness center. Whether youre traveling for business or leisure, our carefully considered amenities are designed to make your stay comfortable.',2,null,'Francia','Paris','Paris','2 Rue Palatine',75006,48.851568269436086, 2.335077504818781,true,37.84, 1);
insert into hoteles (nombre,descripcion,categoria,foto,pais,provincia,poblacion,direccion,codigo_postal,longitud,latitud,desayuno,precio_min,id_registrador) values ('Baobab','Famosa por su Carnaval, gastronomía y naturaleza la isla goza de una temperatura media anual de 23 grados para disfrutar de la playa o la montaña. De hecho alberga el pico más alto de España, el Teide, que alcanza 3.718 metros de altura. Gracias a estos atributos, es uno de los mejores lugares del mundo para disfrutar del ciclismo contando con un gran número de rutas.',1,null,'Estados Unidos','Hawaii','Honolulu','515 N Kuakini St, Honolulu, HI', 96817,21.324770582666414, -157.85798779944594,false,29.73, 1);
insert into hoteles (nombre,descripcion,categoria,foto,pais,provincia,poblacion,direccion,codigo_postal,longitud,latitud,desayuno,precio_min,id_registrador) values ('The Mint','Diferente, fresco, original, divertido y lleno de rincones especiales. El Vincci The Mint te propone una forma distinta de alojamiento en Madrid: un hotel en la Gran Vía vanguardista, con diseño de Jaime Beriestain, habitaciones y suites repletas de servicios, gastronomía moderna en lugares sorprendentes, azotea con vistas al skyline de Madrid… Un hotel nuevo en Madrid creado para espíritus inquietos, mentes creativas y viajeros modernos.',5,null,'Estados Unidos','California','California City','9628 California City Blvd, California City, CA',93505,35.12663448728001, -117.95808153286372,true,62.5, 1);
insert into hoteles (nombre,descripcion,categoria,foto,pais,provincia,poblacion,direccion,codigo_postal,longitud,latitud,desayuno,precio_min,id_registrador) values ('Oasis','Para alcanzar la excelencia, cada día hay que dar un esfuerzo extra, porque buscamos siempre ofrecer a nuestros clientes, una experiencia vacacional verdaderamente memorable, para que siempre piensen en regresar y hospedarse con nosotros. Por lo anterior, nos llena de orgullo compartirte nuestro filosofía, misma que nos sirve de guía para recordarnos cuál es nuestra razón de ser y hacia donde nos dirigimos',4,null,'Japón','Osaka','Osaka','1 Chome-1-10 Kaigandori, Minato Ward, Osaka, 552-0022, ',552,34.65595399425247, 135.42919673442475,false,47, 1);
insert into hoteles (nombre,descripcion,categoria,foto,pais,provincia,poblacion,direccion,codigo_postal,longitud,latitud,desayuno,precio_min,id_registrador) values ('Ayre','Ayre Gran Hotel Colón es un hotel de 4 estrellas y de diseño situado en el centro de Madrid, muy próximo al Parque del Retiro, la Plaza de Toros de las Ventas y el comercial barrio de Salamanca. El hotel está compuesto por dos edificios (Edificio Europa y Edificio América), recientemente renovados  Ambos espacios están unidos por un espectacular jardín de 1.200 metros cuadrados y una galería de arte. Ayre Gran Hotel Colón,  reúne todo aquello que necesitas para disfrutar de una confortable estancia en un entorno tranquilo, desde el que descubrir los innumerables encantos que ofrece la capital española.',3,null,'Japón','Osaka','Osaka','1-1 Senribanpakukoen, Suita, Osaka 565-0826',565,34.81570693218334, 135.53330279751083,true,39.9, 1);
insert into hoteles (nombre,descripcion,categoria,foto,pais,provincia,poblacion,direccion,codigo_postal,longitud,latitud,desayuno,precio_min,id_registrador) values ('Ocean','El Ocean Riviera Paradise es un resort cinco estrellas de nueva construcción, situado en primera línea de mar en la Riviera Maya, muy cercano a Playa del Carmen. Destaca por su gran magnitud además de su moderna arquitectura e impactante interiorismo de inspiración mediterránea. Cuenta con numerosas piscinas, una de ellas en la misma arena de la playa y a pocos metros del mar, una exuberante vegetación propia de la zona, diez restaurantes, doce bares y una zona deportiva. Dispone también del servicio Privilege, Exclusive Rooms and Services, Despacio Spa Centre, centro de buceo Dive It! y una amplia oferta de animación para toda la familia. ',2,null,'Rúsia','Moscow','Moscow','Moscow, Rusia, 103132',103132,55.752738213346476, 37.61771924275972,false,30,1);
insert into hoteles (nombre,descripcion,categoria,foto,pais,provincia,poblacion,direccion,codigo_postal,longitud,latitud,desayuno,precio_min,id_registrador) values ('Mousai','Hotel Mousai en Puerto Vallarta, México, ofrece a los huéspedes mayores de 16 años experiencias exclusivas, en la que podrán disfrutar el arte de vivir, en un entorno tropical cerca de la playa.',1,null,'Mongolia','Ulán Bator','Ulán Bator','Ulaanbaatar 16040, Mongolia',16040,47.92468076524759, 106.89545107792733,true,25.8, 1);

drop table if exists habitaciones;
create table habitaciones(
id_habitacion int auto_increment primary key,
num_habitacion int not null,
tipo varchar (100),
descripcion varchar(2000),
precio double not null,
foto blob,
id_hotel int,
foreign key (id_hotel) references hoteles(id_hotel) on delete no action on update cascade
);

insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (111,'Estándar','Habitación sencilla sin sobrecoste',0,null,1);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (112,'EstándarPlus','Habitación con acceso a la piscina y el gimnasio del hotel',15,null,1);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (113,'Suite','Habitación de lujo, con todas las comodidades del hotel incluidas',30,null,1);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (111,'Estándar','Habitación sencilla sin sobrecoste',0,null,2);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (112,'EstándarPlus','Habitación con acceso a la piscina y el gimnasio del hotel',15,null,2);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (113,'Suite','Habitación de lujo, con todas las comodidades del hotel incluidas',30,null,2);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (111,'Estándar','Habitación sencilla sin sobrecoste',0,null,3);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (112,'EstándarPlus','Habitación con acceso a la piscina y el gimnasio del hotel',15,null,3);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (113,'Suite','Habitación de lujo, con todas las comodidades del hotel incluidas',30,null,3);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (111,'Estándar','Habitación sencilla sin sobrecoste',0,null,4);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (112,'EstándarPlus','Habitación con acceso a la piscina y el gimnasio del hotel',15,null,4);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (113,'Suite','Habitación de lujo, con todas las comodidades del hotel incluidas',30,null,4);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (111,'Estándar','Habitación sencilla sin sobrecoste',0,null,5);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (112,'EstándarPlus','Habitación con acceso a la piscina y el gimnasio del hotel',15,null,5);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (113,'Suite','Habitación de lujo, con todas las comodidades del hotel incluidas',30,null,5);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (111,'Estándar','Habitación sencilla sin sobrecoste',0,null,6);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (112,'EstándarPlus','Habitación con acceso a la piscina y el gimnasio del hotel',15,null,6);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (113,'Suite','Habitación de lujo, con todas las comodidades del hotel incluidas',30,null,6);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (111,'Estándar','Habitación sencilla sin sobrecoste',0,null,7);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (112,'EstándarPlus','Habitación con acceso a la piscina y el gimnasio del hotel',15,null,7);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (113,'Suite','Habitación de lujo, con todas las comodidades del hotel incluidas',30,null,7);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (111,'Estándar','Habitación sencilla sin sobrecoste',0,null,8);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (112,'EstándarPlus','Habitación con acceso a la piscina y el gimnasio del hotel',15,null,8);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (113,'Suite','Habitación de lujo, con todas las comodidades del hotel incluidas',30,null,8);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (111,'Estándar','Habitación sencilla sin sobrecoste',0,null,9);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (112,'EstándarPlus','Habitación con acceso a la piscina y el gimnasio del hotel',15,null,9);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (113,'Suite','Habitación de lujo, con todas las comodidades del hotel incluidas',30,null,9);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (111,'Estándar','Habitación sencilla sin sobrecoste',0,null,10);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (112,'EstándarPlus','Habitación con acceso a la piscina y el gimnasio del hotel',15,null,10);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (113,'Suite','Habitación de lujo, con todas las comodidades del hotel incluidas',30,null,10);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (111,'Estándar','Habitación sencilla sin sobrecoste',0,null,11);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (112,'EstándarPlus','Habitación con acceso a la piscina y el gimnasio del hotel',15,null,11);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (113,'Suite','Habitación de lujo, con todas las comodidades del hotel incluidas',30,null,11);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (111,'Estándar','Habitación sencilla sin sobrecoste',0,null,12);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (112,'EstándarPlus','Habitación con acceso a la piscina y el gimnasio del hotel',15,null,12);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (113,'Suite','Habitación de lujo, con todas las comodidades del hotel incluidas',30,null,12);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (111,'Estándar','Habitación sencilla sin sobrecoste',0,null,13);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (112,'EstándarPlus','Habitación con acceso a la piscina y el gimnasio del hotel',15,null,13);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (113,'Suite','Habitación de lujo, con todas las comodidades del hotel incluidas',30,null,13);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (111,'Estándar','Habitación sencilla sin sobrecoste',0,null,14);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (112,'EstándarPlus','Habitación con acceso a la piscina y el gimnasio del hotel',15,null,14);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (113,'Suite','Habitación de lujo, con todas las comodidades del hotel incluidas',30,null,14);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (111,'Estándar','Habitación sencilla sin sobrecoste',0,null,15);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (112,'EstándarPlus','Habitación con acceso a la piscina y el gimnasio del hotel',15,null,15);
insert into habitaciones (num_habitacion,tipo,descripcion,precio,foto,id_hotel) values (113,'Suite','Habitación de lujo, con todas las comodidades del hotel incluidas',30,null,15);



drop table if exists contactos;
create table contactos(
id_contacto int auto_increment primary key,
telefono_contacto int,
email varchar(50) not null,
id_hotel int,
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
id_factura int,
id_usuario int,
id_habitacion int,
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
id_usuario int,
id_hotel int,
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
id_usuario int,
id_hotel int,
foreign key (id_usuario) references usuarios(id_usuario) on delete cascade on update cascade,
foreign key (id_hotel) references hoteles(id_hotel) on delete cascade on update cascade
);

insert into comentan (valoracion,comentario,id_usuario,id_hotel) values (7,'shit',1,1);
insert into comentan (valoracion,comentario,id_usuario,id_hotel) values (6,'shit',2,2);

drop table if exists buscan;
create table buscan(
id_busca int auto_increment primary key,
id_usuario int,
id_hotel int,
foreign key (id_usuario) references usuarios(id_usuario) on delete cascade on update cascade,
foreign key (id_hotel) references hoteles(id_hotel) on delete cascade on update cascade
);

insert into buscan (id_usuario,id_hotel) values (1,1);
insert into buscan (id_usuario,id_hotel) values (2,2);