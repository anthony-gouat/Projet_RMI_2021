-- Script BDD projet RMI 2021

CREATE DATABASE IF NOT exists PROJET_RMI;
USE PROJET_RMI;

DROP TABLE IF EXISTS ligne_panier;
DROP TABLE IF EXISTS panier;
DROP TABLE IF EXISTS article;
DROP TABLE IF EXISTS type_article;

CREATE TABLE IF NOT EXISTS type_article(
      id INT NOT NULL auto_increment,
      type varchar(50),
      description TEXT,
      PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS article(
     id INT NOT NULL auto_increment,
     lien_image TEXT,
     nom varchar(50),
     prix DECIMAL(10,2),
     description TEXT,
     type_article_id int,
     stock int,
     FOREIGN KEY (type_article_id) REFERENCES type_article(id),
     PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS panier(
	id INT NOT NULL auto_increment,
    total DECIMAL(10,2),
    nb_article int,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS ligne_panier(
   quantite int,
   article_id int,
   panier_id int,
   FOREIGN KEY (article_id) REFERENCES article(id),
   FOREIGN KEY (panier_id) REFERENCES panier(id),
   PRIMARY KEY(article_id,panier_id)
);