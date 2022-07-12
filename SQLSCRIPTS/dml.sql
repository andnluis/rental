CREATE TABLE Departamento (
	id_dep INT,
	departamento VARCHAR(25) NOT NULL,
	PRIMARY KEY (id_dep)
);


CREATE TABLE Ciudad (
	id_ciudad INT,
	ciudad VARCHAR(25) NOT NULL,
	id_dep INT,
	PRIMARY KEY (id_ciudad)
);

CREATE TABLE Direccion (
	id_dir INT,
	direccion VARCHAR(128) NOT NULL,
	id_ciudad INT NOT NULL,
	PRIMARY KEY (id_dir)
);

CREATE TABLE Maquina (
	id_maq INT AUTO_INCREMENT,
	id_man INT NOT NULL,
	id_prop INT NOT NULL,
	n_serie VARCHAR(25) NOT NULL,
	foto blob,
	disponible BINARY NOT NULL,
	id_tipo INT NOT NULL,
	pph FLOAT NOT NULL,
	ubicacion INT NOT NULL,
	modelo_motor VARCHAR(25) NOT NULL,
	potencia FLOAT NOT NULL,
	peso FLOAT NOT NULL,
	descripcion TEXT NOT NULL,
	PRIMARY KEY (id_maq)
);



CREATE TABLE Manufacturador (
	id_man INT NOT NULL AUTO_INCREMENT,
	manufacturador VARCHAR(25) NOT NULL,
	PRIMARY KEY (id_man)
);

CREATE TABLE Subcategoria (
	id_subcat INT NOT NULL AUTO_INCREMENT,
	subcat VARCHAR(35) NOT NULL,
	id_cat INT NOT NULL,
	PRIMARY KEY (id_subcat)
);

CREATE TABLE Categoria (
	id_cat INT NOT NULL AUTO_INCREMENT,
	categoria VARCHAR(35) NOT NULL,
	PRIMARY KEY (id_cat)
);

CREATE TABLE Rentas (
	id_renta INT AUTO_INCREMENT,
	id_maq INT NOT NULL,
	id_arr INT NOT NULL,
	horas_rentadas INT NOT NULL,
	fecha_inicio DATETIME NOT NULL,
	fecha_final DATETIME NOT NULL,
	deposito blob,
	codigo_reserva VARCHAR(255) NOT NULL,
	PRIMARY KEY (id_renta)
);



CREATE TABLE Tipo_maquina (
	id_tipo INT NOT NULL AUTO_INCREMENT,
	tipo VARCHAR(35) NOT NULL,
	id_subcat int NOT NULL,
	PRIMARY KEY (id_tipo)
);


CREATE TABLE Propietario (
	id_prop INT NOT NULL,
	n_id VARCHAR(13) NOT NULL UNIQUE,
	nombre VARCHAR(25) NOT NULL,
	apellido VARCHAR(25) NOT NULL,
	telefono INT NOT NULL UNIQUE,
	id_dir INT NOT NULL,
	email VARCHAR(55) NOT NULL,
	clave VARCHAR(255) NOT NULL,
	f_nac DATE NOT NULL,
	creado TIMESTAMP NOT NULL,
    pfp blob,
	PRIMARY KEY (id_prop)
);





CREATE TABLE Arrendatario (
	id_arr INT NOT NULL,
	n_id VARCHAR(13) NOT NULL,
	nombre VARCHAR(25) NOT NULL,
	apellido VARCHAR(25) NOT NULL,
	telefono INT NOT NULL UNIQUE,
	id_dir INT NOT NULL,
	email VARCHAR(55) NOT NULL,
	clave VARCHAR(255) NOT NULL,
	creado DATETIME  NOT NULL,
    pfp blob,
	PRIMARY KEY (id_arr)
);



ALTER TABLE Direccion ADD CONSTRAINT Direccion_fk0 FOREIGN KEY (id_ciudad) REFERENCES Ciudad(id_ciudad);

ALTER TABLE Ciudad ADD CONSTRAINT Ciudad_fk0 FOREIGN KEY (id_dep) REFERENCES Departamento(id_dep);

ALTER TABLE Maquina ADD CONSTRAINT Maquina_fk0 FOREIGN KEY (id_man) REFERENCES Manufacturador(id_man);

ALTER TABLE Maquina ADD CONSTRAINT Maquina_fk1 FOREIGN KEY (id_prop) REFERENCES Propietario(id_prop);

ALTER TABLE Maquina ADD CONSTRAINT Maquina_fk2 FOREIGN KEY (id_tipo) REFERENCES Tipo_maquina(id_tipo);

ALTER TABLE Maquina ADD CONSTRAINT Maquina_fk3 FOREIGN KEY (ubicacion) REFERENCES Ciudad(id_ciudad);

ALTER TABLE Subcategoria ADD CONSTRAINT Subcategoria_fk0 FOREIGN KEY (id_cat) REFERENCES Categoria(id_cat);

ALTER TABLE Rentas ADD CONSTRAINT Rentas_fk0 FOREIGN KEY (id_maq) REFERENCES Maquina(id_maq);

ALTER TABLE Rentas ADD CONSTRAINT Rentas_fk1 FOREIGN KEY (id_arr) REFERENCES Arrendatario(id_arr);

ALTER TABLE Tipo_maquina ADD CONSTRAINT Tipo_maquina_fk0 FOREIGN KEY (id_subcat) REFERENCES Subcategoria(id_subcat);

ALTER TABLE Propietario ADD CONSTRAINT Propietario_fk0 FOREIGN KEY (id_dir) REFERENCES Direccion(id_dir);

ALTER TABLE Arrendatario ADD CONSTRAINT Arrendatario_fk0 FOREIGN KEY (id_dir) REFERENCES Direccion(id_dir);



