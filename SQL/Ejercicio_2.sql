-- EJERCICIO 2
CREATE TABLE IF NOT EXISTS zoos(
	id SERIAL PRIMARY KEY,
	nombre varchar(100),
	pais varchar(100),
	ciudad varchar(100),
	tamano numeric(7,2),
	presupuesto numeric(10,2)
);

CREATE TABLE IF NOT EXISTS especies(
	id SERIAL PRIMARY KEY,
	n_cientifico varchar(100) UNIQUE,
	n_vulgar varchar(100),
	familia varchar(100),
	peligro boolean
);

CREATE TABLE IF NOT EXISTS animales(
	id SERIAL PRIMARY KEY,
	sexo varchar(20),
	nacimiento date,
	pais_origen varchar(100),
	continente varchar(100),
	especie_id int,
	zoo_id int,
	CONSTRAINT fk_especie_id FOREIGN KEY (especie_id) REFERENCES especies(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT fk_zoo_id FOREIGN KEY (zoo_id) REFERENCES zoos(id) ON DELETE CASCADE ON UPDATE CASCADE
);