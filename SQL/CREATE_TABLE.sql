use card_fighters;

CREATE TABLE personajes(
	nombre VARCHAR(50) PRIMARY KEY,
    descripcion VARCHAR(255),
	especial VARCHAR(100),
    ultimate VARCHAR(100),
    CONSTRAINT especial_personaje_fk
    FOREIGN KEY (especial)
    REFERENCES especiales(nombre),
    CONSTRAINT ultimate_personaje_fk
    FOREIGN KEY (ultimate)
    REFERENCES ultimates(nombre)
);

CREATE TABLE consumibles(
	nombre VARCHAR(50) PRIMARY KEY,
    descripcion VARCHAR(100),
    aumentoEnergia INT,
    aumentoVida INT,
    aumentoAtaque INT
);

CREATE TABLE escenarios(
	nombre VARCHAR(50) PRIMARY KEY,
    descripcion VARCHAR(255)
);

CREATE TABLE cartas(
	id INT PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(50),
    personaje VARCHAR(50),
    descripcion VARCHAR(255),
    puntosAtaque NUMERIC(2),
    velocidad NUMERIC(2),
    alcance NUMERIC(1),
    FOREIGN KEY (personaje)
    REFERENCES personajes(nombre)
);


CREATE TABLE especiales(
	nombre VARCHAR(100) PRIMARY KEY,
    descripcion VARCHAR(255),
    puntosAtaque NUMERIC(2),
    velocidad NUMERIC(2),
    alcance NUMERIC(1),
    costeEnergia NUMERIC(1)
);

CREATE TABLE ultimates(
	nombre VARCHAR(100) PRIMARY KEY,
    descripcion VARCHAR(255),
    puntosAtaque NUMERIC(2),
    velocidad NUMERIC(2),
    alcance NUMERIC(1),
    costeEnergia NUMERIC(1),
    costeVida NUMERIC(2)
);




