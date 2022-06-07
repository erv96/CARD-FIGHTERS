-- PERSONAJE: STEVEN

INSERT INTO Personaje values('Steven','Luchador especializado en cuerpo a cuerpo no posee ataques propios a distancia pero hace mucho daño con sus habilidades');

INSERT INTO carta values(1,'Acometida','Básico','Steven','Realiza una acometida que hace un daño decente',4,4,2);
INSERT INTO carta values(2,'Bloqueo','Básico','Steven','Pose de bloqueo, bloquea la carta del rival',0,9,0);
INSERT INTO carta values(3,'Puñetazo','Básico','Steven','Puñetazo rápido y de daño bajo',3,8,1);

SELECT*FROM carta;
-- INSERTANDO CON AUTO_INCREMENT UN TOTAL DE 15 CARTAS COMUNES

-- INTRODUCIENDO 7 CARTAS DE PUÑETAZO Y 7 DE ACOMETIDA
INSERT INTO carta (nombre,tipo,personaje,descripcion,puntosAtaque,velocidad,alcance) 
	values('Puñetazo','Básico','Steven','Puñetazo rápido y de daño bajo',3,8,1);

INSERT INTO carta (nombre,tipo,personaje,descripcion,puntosAtaque,velocidad,alcance)
	values('Acometida','Básico','Steven','Realiza una acometida que hace un daño decente',5,5,2);
    
-- INTRODUCIENDO UNA SOLA CARTA DE BLOQUEO
    
INSERT INTO carta (nombre,tipo,personaje,descripcion,puntosAtaque,velocidad,alcance)
	values('Bloqueo','Básico','Steven','Pose de bloqueo, bloquea la carta del rival',0,9,0);
      
-- INSERTANDO EN STEVEN SU ESPECIAL 3 VECES Y SU ULTIMATE 2

INSERT INTO ultimate values(1,'Bomba imparable','Ultimate','Steven','Golpe de gran rango que hace un daño masivo',9,5,3,0,5);
INSERT INTO ultimate values(2,'Bomba imparable','Ultimate','Steven','Golpe de gran rango que hace un daño masivo',9,5,3,0,5);

INSERT INTO especial values(1,'Gancho rompedor','Especial','Steven','Poderoso gancho rapido y de buen daño',5,5,1,1);
INSERT INTO especial values(2,'Gancho rompedor','Especial','Steven','Poderoso gancho rapido y de buen daño',5,5,1,1);
INSERT INTO especial values(3,'Gancho rompedor','Especial','Steven','Poderoso gancho rapido y de buen daño',5,5,1,1);

-- RYU 

INSERT INTO Personaje values('Ryu','Luchador equilibrado con ataques a distancia y cuerpo a cuerpo.');

-- CARTAS COMUNES 

-- INTRODUCIENDO 7 PUÑETAZOS Y 7 ACOMETIDAS

INSERT INTO carta (nombre,tipo,personaje,descripcion,puntosAtaque,velocidad,alcance) 
	values('Puñetazo','Básico','Ryu','Puñetazo rápido y de daño bajo',3,8,1);

INSERT INTO carta (nombre,tipo,personaje,descripcion,puntosAtaque,velocidad,alcance)
	values('Acometida','Básico','Ryu','Realiza una acometida que hace un daño decente',5,5,2);
    
-- INTRODUCIENDO 1 BLOQUEO
    
INSERT INTO carta (nombre,tipo,personaje,descripcion,puntosAtaque,velocidad,alcance)
	values('Bloqueo','Básico','Ryu','Pose de bloqueo, bloquea la carta del rival',0,9,0);
    
-- INSERTANDO EN RYU SU ESPECIAL 3 VECES Y SU ULTIMATE 2

INSERT INTO ultimate values(3,'Shin-shoryuken','Ultimate','Ryu','Golpe cuerpo a cuerpo que ejerce un daño masivo que puede decidir el combate',11,7,1,0,5);
INSERT INTO ultimate values(4,'Shin-shoryuken','Ultimate','Ryu','Golpe cuerpo a cuerpo que ejerce un daño masivo que puede decidir el combate',11,7,1,0,5);

INSERT INTO especial values(4,'Hadouken','Especial','Ryu','Acumulas tu fuerza espiritual interior y la arrojas sobre el enemigo',4,5,2,1);
INSERT INTO especial values(5,'Hadouken','Especial','Ryu','Acumulas tu fuerza espiritual interior y la arrojas sobre el enemigo',4,5,2,1);
INSERT INTO especial values(6,'Hadouken','Especial','Ryu','Acumulas tu fuerza espiritual interior y la arrojas sobre el enemigo',4,5,2,1);




SELECT*FROM carta;


-- POCIONES 

INSERT INTO consumible (nombre,descripcion,aumentoEnergia) values('PocionEnergia','Poción que restaura 5 de energía',5);
INSERT INTO consumible (nombre,descripcion,aumentoAtaque) values('PocionAtaque','Poción que aumenta en 1 el ataque de tu siguiente carta',1);
INSERT INTO consumible (nombre,descripcion,aumentoVida) values('PocionVida','Poción que aumenta en 5 la vida de tu personaje',5);

-- ESCENARIOS 

INSERT INTO escenario VALUES('Playa enigmática','Una playa misteriosa que esconde secretos entre sus aguas, con la llegada del verano varios luchadores vienen aquí para entrenar
sus movimientos en la arena frente a unas temperaturas extremas.');

INSERT INTO escenario VALUES('Dojo','¿En serio necesitas una descripción de esto?, menos pensar y más luchar.')



