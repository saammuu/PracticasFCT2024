-- EJERCICIO 3
CREATE TABLE IF NOT EXISTS socios(
	id SERIAL PRIMARY KEY,
	nombre varchar(100),
	direccion varchar(200)
);

CREATE TABLE IF NOT EXISTS patrones(
	id SERIAL PRIMARY KEY,
	dni varchar(50),
	nombre varchar(100),
	direccion varchar(200)
);

CREATE TABLE IF NOT EXISTS barcos(
	id SERIAL PRIMARY KEY,
	matricula varchar(100) UNIQUE,
	n_amarre int,
	cuota numeric(5,2),
	socio_id int,
	CONSTRAINT fk_socio_id FOREIGN KEY (socio_id) REFERENCES socios(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS salidas(
	id SERIAL PRIMARY KEY,
	destino varchar(100),
	fecha_salida date,
	hora_salida time,
	barco_id int,
	patron_id int,
	CONSTRAINT fk_barco_id FOREIGN KEY (barco_id) REFERENCES barcos(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT fk_patron_id FOREIGN KEY (patron_id) REFERENCES patrones(id) ON DELETE CASCADE ON UPDATE CASCADE
);