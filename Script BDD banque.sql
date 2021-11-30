CREATE DATABASE IF NOT exists PROJET_RMI_Banque;
USE PROJET_RMI_Banque;

DROP TABLE IF EXISTS clients;
DROP TABLE IF EXISTS carte;

CREATE TABLE IF NOT EXISTS carte(
      id INT NOT NULL auto_increment,
      numero varchar(16),
      date_exp date,
      crytpo varchar(3),
      PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS clients(
      id INT NOT NULL auto_increment,
      nom varchar(50),
      carte_id int,
      solde DECIMAL(15,2),
      foreign key (carte_id) REFERENCES carte(id),
      PRIMARY KEY(id)
);