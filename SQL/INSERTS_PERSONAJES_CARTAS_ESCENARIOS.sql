-- PERSONAJE: STEVEN

INSERT INTO Personaje values('Steven','Luchador especializado en cuerpo a cuerpo no posee ataques a distancia pero hace mucho daño con sus habilidades');

INSERT INTO carta values(1,'Acometida','Básico','Steven','Realiza una acometida que hace un daño decente',4,4,2);
INSERT INTO carta values(2,'Bloqueo','Básico','Steven','Pose de bloqueo, bloquea la carta del rival',0,9,0);
INSERT INTO carta values(3,'Puñetazo','Básico','Steven','Puñetazo rápido y de daño bajo',3,8,1);

SELECT*FROM carta;
-- INSERTANDO CON AUTO_INCREMENT UN TOTAL DE 15 CARTAS COMUNES

INSERT INTO carta (nombre,tipo,personaje,descripcion,puntosAtaque,velocidad,alcance) 
	values('Puñetazo','Básico','Steven','Puñetazo rápido y de daño bajo',3,8,1);

INSERT INTO carta (nombre,tipo,personaje,descripcion,puntosAtaque,velocidad,alcance)
	values('Acometida','Básico','Steven','Realiza una acometida que hace un daño decente',4,4,2);
    
INSERT INTO carta (nombre,tipo,personaje,descripcion,puntosAtaque,velocidad,alcance)
	values('Bloqueo','Básico','Steven','Pose de bloqueo, bloquea la carta del rival',0,9,0);
      
-- INSERTANDO EN STEVEN SU ESPECIAL 3 VECES Y SU ULTIMATE 2

INSERT INTO ultimate values(1,'Bomba imparable','Ultimate','Steven','Golpe de gran rango que hace un daño masivo',9,5,3,0,5);
INSERT INTO ultimate values(2,'Bomba imparable','Ultimate','Steven','Golpe de gran rango que hace un daño masivo',9,5,3,0,5);

INSERT INTO especial values(1,'Gancho rompedor','Especial','Steven','Poderoso gancho rapido y de buen daño',5,5,1,1);
INSERT INTO especial values(2,'Gancho rompedor','Especial','Steven','Poderoso gancho rapido y de buen daño',5,5,1,1);
INSERT INTO especial values(3,'Gancho rompedor','Especial','Steven','Poderoso gancho rapido y de buen daño',5,5,1,1);


-- POCIONES 

INSERT INTO consumible (nombre,descripcion,aumentoEnergia) values('PocionEnergia','Poción que restaura 5 de energía',5);
INSERT INTO consumible (nombre,descripcion,aumentoAtaque) values('PocionAtaque','Poción que aumenta en 1 el ataque de tu siguiente carta',1);
INSERT INTO consumible (nombre,descripcion,aumentoVida) values('PocionVida','Poción que aumenta en 5 la vida de tu personaje',5);

-- ESCENARIOS 

INSERT INTO escenario VALUES('Playa enigmática','Una playa misteriosa que esconde secretos entre sus aguas, con la llegada del verano varios luchadores vienen aquí para entrenar
sus movimientos en la arena frente a unas temperaturas extremas.');

INSERT INTO escenario VALUES('Dojo','¿En serio necesitas una descripción de esto?, menos pensar y más luchar.')



