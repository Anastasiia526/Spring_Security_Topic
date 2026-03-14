use flowers;

CREATE TABLE users(
id bigint not null auto_increment primary key,
username varchar(100) not null,
surname varchar(100) not null,
role varchar(20),
password varchar(100) not null unique
);
DROP table home_flowers;
DROP table users;

INSERT INTO users(username, surname, role, password) values('Anastasiia', 'Kalitina', 'ROLE_ADMIN', 'Anastasiia526');
INSERT INTO users(username, surname, role, password) values('Karolina', 'Chili', 'ROLE_USER' , 'Karolina222');

INSERT INTO homeFlowers (name, latin_name, type, room, health_status) VALUES ('Ficus Benjamina', 'Ficus Benjamina', 'indoor', 'living room', 'healthy');
INSERT INTO homeFlowers (name, latin_name, type, room, health_status) VALUES ('Snake Plant', 'Sansevieria trifasciata', 'succulent', 'bedroom', 'healthy');
INSERT INTO homeFlowers (name, latin_name, type, room, health_status) VALUES ('Monstera', 'Monstera deliciosa', 'indoor', 'living room', 'needs care');