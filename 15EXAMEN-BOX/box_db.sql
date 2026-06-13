CREATE DATABASE IF NOT EXISTS box_db;
USE box_db;

CREATE TABLE IF NOT EXISTS gimnasios (
    id_gimnasio INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    ubicacion VARCHAR(150),
    entrenador_principal VARCHAR(100),
    capacidad INT,
    fecha_fundacion DATE,
    telefono VARCHAR(20),
    activo BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS boxeadores (
    id INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    edad INT NOT NULL,
    peso DECIMAL(5,2) NOT NULL,
    categoria VARCHAR(50),
    nacionalidad VARCHAR(60),
    peleas_ganadas INT DEFAULT 0,
    peleas_perdidas INT DEFAULT 0,
    peleas_empatadas INT DEFAULT 0,
    gimnasio VARCHAR(100),
    mano_dominante ENUM('Diestro', 'Zurdo', 'Ambidiestro') DEFAULT 'Diestro'
);


CREATE TABLE IF NOT EXISTS combates (
    id_combate INT PRIMARY KEY AUTO_INCREMENT,
    boxeador1_id INT,
    boxeador2_id INT,
    fecha DATE,
    lugar VARCHAR(150),
    resultado VARCHAR(50),
    rounds INT,
    peso_categoria VARCHAR(50),
    FOREIGN KEY (boxeador1_id) REFERENCES boxeadores(id),
    FOREIGN KEY (boxeador2_id) REFERENCES boxeadores(id)
);

INSERT INTO gimnasios (nombre, ubicacion, entrenador_principal, capacidad, fecha_fundacion, telefono) VALUES
('Gimnasio Mexicano', 'CDMX, México', 'Freddy Roach', 120, '2005-03-15', '5512345678'),
('Wild Card Gym', 'Los Ángeles, USA', 'Freddy Roach', 200, '1990-11-20', '3235559876'),
('Gimnasio Canelo', 'Guadalajara, México', 'Eddy Reynoso', 150, '2010-06-10', '3312345678'),
('Top Rank Gym', 'Las Vegas, USA', 'Bob Arum', 180, '1995-01-05', '7025554321'),
('Gimnasio de los Campeones', 'Monterrey, México', 'Ignacio Beristáin', 90, '1980-09-12', '8187654321');

INSERT INTO boxeadores (id, nombre, edad, peso, categoria, nacionalidad, peleas_ganadas, peleas_perdidas, peleas_empatadas, gimnasio, mano_dominante) VALUES
(1, 'Canelo Álvarez', 35, 76.5, 'Super Mediano', 'Mexicana', 62, 2, 2, 'Gimnasio Canelo', 'Diestro'),
(2, 'Saúl "Canelo" Álvarez', 34, 75.0, 'Mediano', 'Mexicana', 61, 1, 2, 'Gimnasio Canelo', 'Diestro'),
(3, 'Floyd Mayweather', 47, 68.0, 'Welter', 'Estadounidense', 50, 0, 0, 'Wild Card Gym', 'Diestro'),
(4, 'Óscar De La Hoya', 51, 70.5, 'Super Welter', 'Estadounidense', 39, 6, 0, 'Wild Card Gym', 'Diestro'),
(5, 'Juan Manuel Márquez', 52, 65.0, 'Ligero', 'Mexicana', 56, 7, 1, 'Gimnasio Mexicano', 'Diestro');

INSERT INTO combates (boxeador1_id, boxeador2_id, fecha, lugar, resultado, rounds, peso_categoria) VALUES
(1, 3, '2013-09-14', 'Las Vegas, USA', 'Ganó boxeador1', 12, 'Welter'),
(2, 4, '2007-05-05', 'Las Vegas, USA', 'Ganó boxeador2', 12, 'Mediano'),
(1, 5, '2014-05-03', 'Las Vegas, USA', 'Ganó boxeador1', 12, 'Ligero'),
(3, 4, '1996-06-07', 'Los Ángeles, USA', 'Ganó boxeador1', 12, 'Super Welter'),
(5, 1, '2009-07-18', 'Las Vegas, USA', 'Ganó boxeador2', 12, 'Welter');

SELECT 'Gimnasios' AS tabla, COUNT(*) AS registros FROM gimnasios
UNION ALL
SELECT 'Boxeadores', COUNT(*) FROM boxeadores
UNION ALL
SELECT 'Combates', COUNT(*) FROM combates;