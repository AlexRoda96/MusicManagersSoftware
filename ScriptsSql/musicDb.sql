-- Alejandro Roda

-- Base de datos musicDb
create database if not exists musicDb;

-- Use musicDb
use  musicDB;

-- Tabla grupo
create table if not exists grupo(
id int(10) not null primary key,
nombre varchar(100) not null,
annoFormacion year,
activoActualmente boolean,
discograficaActual varchar(50),
discograficasAntiguas varchar(250),
miembrosAntiguos varchar(250),
generoMusical varchar(100),
foto Blob
);

-- Tabla Discografica
create table if not exists discografica(
id int(10) not null primary key,
empresaMatriz varchar(25),
annoFundacion year,
fundador varchar(50),
pais varchar(25)
);


-- Crear tabla artista
create table if not exists artista(
id int(10) not null primary key,
nombreArtistico varchar(50),
nombre varchar(25) not null,
primerApellido varchar(25) not null,
segundoApellido varchar(25),
dni varchar(20) not null,
fechaNacimiento date,
paisNacimiento varchar(50),
numTelefono varchar(15),
id_grupo int(10) default null,
id_discografica int(10) default null,
generoMusical varchar(100),
tipoMusico varchar(25),
foto Blob,
FOREIGN KEY (id_grupo) REFERENCES grupo (id),
FOREIGN KEY (id_discografica) REFERENCES discografica (id)
);



-- Crear la tabla disco
create table if not exists disco(
id int(10) not null primary key,
titulo varchar(50) not null,
fechaPublicacion date,
generoMusical varchar(50),
formato varchar(100),
id_artista int(10) default null,
id_grupo int(10) default null,
id_discografica int(10) default null,  
precio float,
caractula Blob,
FOREIGN KEY (id_artista) REFERENCES artista (id),
FOREIGN KEY (id_grupo) REFERENCES grupo (id),
FOREIGN KEY (id_discografica) REFERENCES discografica (id)
);


-- Crear tabla cancion
create table if not exists cancion(
id int(10) not null primary key,
titulo varchar(100) not null,
fechaPublicacion date,
formato varchar(100),
genero varchar(100),
id_disco int(10) default null,
id_artista int(10) default null,
id_grupo int(10) default null,
duracion int(10),
videoclip boolean,
FOREIGN KEY (id_artista) REFERENCES artista (id),
FOREIGN KEY (id_grupo) REFERENCES grupo (id),
FOREIGN KEY (id_disco) REFERENCES disco (id)
);

-- Crear tabla gira
create table if not exists gira(
id int(10) not null primary key,
nombre varchar(100),
id_artista int(10) default null,
id_grupo int(10) default null,
fechaInicio date,
fechaFin date,
presupuesto float,
coste float,
ganancia float,
FOREIGN KEY (id_artista) REFERENCES artista (id),
FOREIGN KEY (id_grupo) REFERENCES grupo (id)
);

-- Crear tabla sala
create table if not exists sala(
id int(10) not null primary key,
nombre varchar(100), 
pais varchar(100),
ciudad varchar(100),
direccion varchar(100),
aforoMax int(10),
tipoSala varchar(100),
paginaWeb varchar(100),
numeroTelef int(10),
precioAlquiler float
);


-- Crear tabla concierto
create table if not exists concierto(
id int(10) not null primary key,
pais varchar(100),
ciudad varchar(100),
id_sala int(10) default null,
id_gira int(10) default null,
id_artista int (10) default null,
id_grupo int(10) default null,
fecha date,
fechaSalidaEntradas date,
numeroEntradas int(10),
merchan boolean,
precioEntrada float,
horaApertura time,
edadMinima int(5),
FOREIGN KEY (id_sala) REFERENCES sala (id),
FOREIGN KEY (id_gira) REFERENCES gira (id),
FOREIGN KEY (id_artista) REFERENCES artista (id),
FOREIGN KEY (id_grupo) REFERENCES grupo (id)
);

-- Crear tabla intermedia entre concierto y cancion
create table if not exists concierto_cancion(
id_concierto int(10) not null,
id_cancion int(10) not null,
primary key (id_concierto,id_cancion),
foreign key (id_concierto) references concierto (id),
foreign key (id_cancion) references cancion (id)
);

-- Tabla Reunion
create table if not exists reunion(
id int primary key not null,
lugar varchar(50),
hora time,
descripcion varchar(200),
id_artista int (10) default null,
id_grupo int(10) default null,
FOREIGN KEY (id_artista) REFERENCES artista (id),
FOREIGN KEY (id_grupo) REFERENCES grupo (id)
);