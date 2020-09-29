-- Alejandro Roda


 -- Crear base de datos 
create database if not exists musicDb;

-- Use musicDb
use  musicDB;

-- Crear la tabla disco
create table if not exists disco(
id int(10) not null primary key,
titulo varchar(50) not null,
fechaPublicacion date,
generoMusical varchar(50),
formato varchar(100),
discografica varchar(50) not null,
colaboraciones varchar(100),
precio float,
canalYoutube varchar(100),
cuentaSpotify varchar(100)
);

-- Crear tabla músico
create table if not exists artista(
id int(10) not null primary key,
nombre varchar(100) not null,
apellidos varchar(100) not null,
dni varchar(50) not null,
nombreArtistico varchar(50),
fechaNacimiento date,
nacionalidad varchar(50),
discografica varchar(100),
generoMusical varchar(100),
paginaWeb varchar(100),
cuentaInstagram varchar(100),
canalYoutube varchar(100),
cuentaSpotify varchar(100)
);

-- Crear la tabla grupo
create table if not exists grupo(
id int(10) not null primary key,
nombre varchar(100) not null,
annoFormacion year,
discografica varchar(100),
generoMusical varchar(100),
paginaWeb varchar(100),
cuentaInstagram varchar(100),
canalYoutube varchar(100),
cuentaSpotify varchar(100)
);

-- Crear tabla cancion
create table if not exists cancion(
id int(10) not null primary key,
titulo varchar(100) not null,
fechaPublicacion date,
formato varchar(100),
genero varchar(100),
discografica varchar(100) not null,
productor varchar(100) not null,
duracion int(10),
colaboraciones varchar(100),
videoclip boolean,
enlaceYoutube varchar(100),
cuentaSpotify varchar(100)
);

-- Crear tabla gira
create table if not exists gira(
id int(10) not null primary key,
nombre varchar(100),
fechaInicio date,
fechaFin date
);

-- Crear tabla concierto
create table if not exists concierto(
id int(10) not null primary key,
pais varchar(100),
ciudad varchar(100),
sala varchar(100),
fecha date,
fechaSalidaEntradas date,
numeroEntradas int(10),
merchan boolean,
precioEntrada float,
horaApertura time,
edadMinima int(5)
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
numeroTelef int(10)
);

-- Crear tabla intermedia entre cancion y disco
create table if not exists cancion_disco(
disco_id int(10) not null,
cancion_id int(10) not null,
primary key (disco_id,cancion_id),
foreign key (disco_id) references disco (id),
foreign key (cancion_id) references cancion (id)
);

-- Crear tabla intermedia entre artista y cancion
create table if not exists cancion_artista(
artista_id int(10) not null,
cancion_id int(10) not null,
primary key (artista_id,cancion_id),
foreign key (artista_id) references artista (id),
foreign key (cancion_id) references cancion (id)
);

-- Crear tabla intermedia entre cancion y grupo
create table if not exists cancion_grupo(
grupo_id int(10) not null,
cancion_id int(10) not null,
primary key (grupo_id,cancion_id),
foreign key (grupo_id) references grupo (id),
foreign key (cancion_id) references cancion (id)
);

-- Crear tabla intermedia entre cantante y grupo
create table if not exists artista_grupo(
grupo_id int(10) not null,
artista_id int(10) not null,
primary key (grupo_id,artista_id),
foreign key (grupo_id) references grupo (id),
foreign key (artista_id) references artista (id)
);

-- Crear tabla intermedia entre cantante y disco
create table if not exists cantante_disco(
disco_id int(10) not null,
artista_id int(10) not null,
primary key (disco_id,artista_id),
foreign key (disco_id) references disco (id),
foreign key (artista_id) references artista (id)
);

-- Crear tabla intermedia entre grupo y disco
create table if not exists grupo_disco(
disco_id int(10) not null,
grupo_id int(10) not null,
primary key (disco_id,grupo_id),
foreign key (disco_id) references disco (id),
foreign key (grupo_id) references grupo (id)
);

-- Crear tabla intermedia  entre gira y cocierto
create table if not exists gira_concierto(
id_gira int(10) not null,
id_concierto int(10) not null,
primary key (id_gira,id_concierto),
foreign key (id_gira) references gira (id),
foreign key (id_concierto) references concierto (id)
);

-- Crear tabla intermedia entre gira y grupo
create table if not exists gira_grupo(
id_gira int(10) not null,
id_grupo int(10) not null,
primary key (id_gira,id_grupo),
foreign key (id_gira) references gira (id),
foreign key (id_grupo) references grupo (id)
);

-- Crear tabla intermedia entre gira y artista
create table if not exists gira_artista(
id_gira int(10) not null,
id_artista int(10) not null,
primary key (id_gira,id_artista),
foreign key (id_gira) references gira (id),
foreign key (id_artista) references artista (id)
);

-- Crear tabla intermedia entre concierto y cancion
create table if not exists concierto_cancion(
id_concierto int(10) not null,
id_cancion int(10) not null,
primary key (id_concierto,id_cancion),
foreign key (id_concierto) references concierto (id),
foreign key (id_cancion) references cancion (id)
);

-- Crear tabla intermedia entre concierto y artista
create table if not exists concierto_artista(
id_concierto int(10) not null,
id_artista int(10) not null,
primary key (id_concierto,id_artista),
foreign key (id_concierto) references concierto (id),
foreign key (id_artista) references artista (id)
);

-- Crear tabla intermedia entre concierto y grupo
create table if not exists concierto_grupo(
id_concierto int(10) not null,
id_grupo int(10) not null,
primary key (id_concierto,id_grupo),
foreign key (id_concierto) references concierto (id),
foreign key (id_grupo) references grupo (id)
);

-- Crear tabla intermedia entre concierto y sala
create table if not exists concierto_sala(
id_concierto int(10) not null,
id_sala int(10) not null,
primary key (id_concierto,id_sala),
foreign key (id_concierto) references concierto (id),
foreign key (id_sala) references sala (id)
);

drop database musicDb;
