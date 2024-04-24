-- EJERCICIO 1
CREATE TABLE IF NOT EXISTS asuntos(
	n_expediente  SERIAL PRIMARY KEY ,
	fecha_inicio date,
	fecha_fin date,
	cliente_id int,
	CONSTRAINT fk_cliente_id FOREIGN KEY (cliente_id) REFERENCES clientes(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS clientes(
	id SERIAL PRIMARY KEY ,
	dni varchar(50) UNIQUE,
	nombre varchar(100),
	direccion varchar(200)
);

CREATE TABLE IF NOT EXISTS procuradores(
	id  SERIAL PRIMARY KEY ,
	dni varchar(50) UNIQUE,
	nombre varchar(100),
	direccion varchar(200)
);

CREATE TABLE IF NOT EXISTS asuntos_procuradores(
	n_expediente int,
	procurador_id int,
	CONSTRAINT fk_n_expediente FOREIGN KEY (n_expediente) REFERENCES asuntos(n_expediente) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_procurador_id FOREIGN KEY (procurador_id) REFERENCES procuradores(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT pk_asuntos_procuradores PRIMARY KEY (n_expediente, procurador_id)
);
