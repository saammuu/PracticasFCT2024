-- EJERCICIO 4
CREATE TABLE IF NOT EXISTS socios(
	id SERIAL PRIMARY KEY,
	nombre varchar(100),
	apellidos varchar(100),
	dni varchar(100) UNIQUE,
	telefono varchar(20),
	socio_avalador_id int,
	poblacion_id int,
	CONSTRAINT fk_socio_avalador_id FOREIGN KEY (socio_avalador_id) REFERENCES socios(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT fk_poblacion_id FOREIGN KEY (poblacion_id) REFERENCES poblaciones(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS pedidos(
	id SERIAL PRIMARY KEY,
	forma_envio varchar(100),
	forma_pago varchar(100),
	socio_id int,
	CONSTRAINT fk_socio_id FOREIGN KEY (socio_id) REFERENCES socios(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS detalles_pedidos(
	consecutivo int,
	cantidad int,
	pedido_id int,
	isbn varchar(100),
	CONSTRAINT fk_pedido_id FOREIGN KEY (pedido_id) REFERENCES pedidos(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_isbn FOREIGN KEY (isbn) REFERENCES libros(isbn) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT pk_detalles_pedidos PRIMARY KEY (consecutivo, pedido_id)
);

CREATE TABLE IF NOT EXISTS libros(
 	isbn varchar(100) PRIMARY KEY,
	titulo varchar(100),
	autor varchar(100),
	editorial varchar(100),
	coleccion_id int,
	CONSTRAINT fk_coleccion_id FOREIGN KEY (coleccion_id) REFERENCES colecciones(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS colecciones(
	id SERIAL PRIMARY KEY,
	volumen int
);

CREATE TABLE IF NOT EXISTS poblaciones(
	id SERIAL PRIMARY KEY,
	habitantes int,
	nombre varchar(100),
	provincia_id int,
	CONSTRAINT fk_provincia_id FOREIGN KEY (provincia_id) REFERENCES provincias(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS provincias(
	id SERIAL PRIMARY KEY,
	nombre varchar(100),
	p_extension numeric(10,2),
	almacen_id int,
	CONSTRAINT fk_almacen_id FOREIGN KEY (almacen_id) REFERENCES almacenes(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS almacenes(
	id SERIAL PRIMARY KEY,
	fecha_apertura date,
	direccion varchar(100),
	provincia_id int
);

CREATE TABLE IF NOT EXISTS stock_libros_almacenes(
	isbn varchar(100),
	almacen_id int,
	cantidad int,
	CONSTRAINT fk_isbn FOREIGN KEY (isbn) REFERENCES libros(isbn) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT fk_almacen_id FOREIGN KEY (almacen_id) REFERENCES almacenes(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT pk_stock_libros_almacenes PRIMARY KEY (isbn, almacen_id)
);