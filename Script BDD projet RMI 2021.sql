-- Script BDD projet RMI 2021

CREATE DATABASE IF NOT exists PROJET_RMI;
USE PROJET_RMI;

DROP TABLE IF EXISTS panier;
CREATE TABLE IF NOT EXISTS panier(
	id INT NOT NULL auto_increment,
    article varchar(10),
    PRIMARY KEY(id)
)