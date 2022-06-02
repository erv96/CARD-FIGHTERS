use card_fighters;

CREATE TABLE personaje(
	nombre VARCHAR(50) PRIMARY KEY,
    descripcion VARCHAR(255)
);

CREATE TABLE consumible(
	nombre VARCHAR(50) PRIMARY KEY,
    descripcion VARCHAR(100),
    aumentoEnergia INT,
    aumentoVida INT,
    aumentoAtaque INT
);

CREATE TABLE escenario(
	nombre VARCHAR(50) PRIMARY KEY,
    descripcion VARCHAR(255)
);

CREATE TABLE carta(
	id INT PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(50),
    personaje VARCHAR(50),
    descripcion VARCHAR(255),
    puntosAtaque NUMERIC(2),
    velocidad NUMERIC(2),
    alcance NUMERIC(1),
    FOREIGN KEY (personaje)
    REFERENCES personaje(nombre)
);

select*from carta;


CREATE TABLE especial(
	id INT PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(100),
    personaje VARCHAR(100),
    descripcion VARCHAR(255),
    puntosAtaque NUMERIC(2),
    velocidad NUMERIC(2),
    alcance NUMERIC(1),
    costeEnergia NUMERIC(1),
    FOREIGN KEY (personaje)
    REFERENCES personaje(nombre)
);


CREATE TABLE ultimate(
	id INT PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(100),
    personaje VARCHAR(100),
    descripcion VARCHAR(255),
    puntosAtaque NUMERIC(2),
    velocidad NUMERIC(2),
    alcance NUMERIC(1),
    costeEnergia NUMERIC(1),
    costeVida NUMERIC(2),
    FOREIGN KEY (personaje)
    REFERENCES personaje(nombre)
);




