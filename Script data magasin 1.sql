INSERT INTO type_article VALUES (NULL,"Carte graphique","Fait tourner les jeux et affiche les images");
INSERT INTO type_article VALUES (NULL,"Carte mère","Permet d'y inserer le CPU le GPU et la RAM");
INSERT INTO type_article VALUES (NULL,"Processeur","CPU");
INSERT INTO type_article VALUES (NULL,"RAM","Mémoire vive");
INSERT INTO type_article VALUES (NULL,"Boitier","Pour y mettre le matos");
INSERT INTO type_article VALUES (NULL,"Ventilos","Refroidir le PC");

INSERT INTO article VALUES (NULL,"","carte graphique V1",500.50,"Bien pour jouer mais peu aussi ce manger",1,0);
INSERT INTO article VALUES (NULL,"","carte graphique V2",500.50,"Bien pour jouer mais peu aussi ce manger",1,0);
INSERT INTO article VALUES (NULL,"","carte graphique V3",500.50,"Bien pour jouer mais peu aussi ce manger",1,0);
INSERT INTO article VALUES (NULL,"","carte mère V1",250,"Pour le processeur",2,10);
INSERT INTO article VALUES (NULL,"","carte mère V2",250,"Pour le processeur",2,10);
INSERT INTO article VALUES (NULL,"","carte mère V3",250,"Pour le processeur",2,10);
INSERT INTO article VALUES (NULL,"","Processeur V1",481.50,"ça chauffe vite",3,10);
INSERT INTO article VALUES (NULL,"","Processeur V2",481.50,"ça chauffe vite",3,10);
INSERT INTO article VALUES (NULL,"","Processeur V3",481.50,"ça chauffe vite",3,10);
INSERT INTO article VALUES (NULL,"","RAM V1",85.90,"Pas pour le kanoe",4,3);
INSERT INTO article VALUES (NULL,"","RAM V2",85.90,"Pas pour le kanoe",4,3);
INSERT INTO article VALUES (NULL,"","RAM V3",85.90,"Pas pour le kanoe",4,3);
INSERT INTO article VALUES (NULL,"","Boitier PC V1",120.88,"C'est joli avec une vitre",5,129);
INSERT INTO article VALUES (NULL,"","Boitier PC V2",120.88,"C'est joli avec une vitre",5,129);
INSERT INTO article VALUES (NULL,"","Boitier PC V3",120.88,"C'est joli avec une vitre",5,129);
INSERT INTO article VALUES (NULL,"","Ventilos V1",45.50,"Pour refroidir le tout",6,5);
INSERT INTO article VALUES (NULL,"","Ventilos V2",45.50,"Pour refroidir le tout",6,5);
INSERT INTO article VALUES (NULL,"","Ventilos V3",45.50,"Pour refroidir le tout",6,5);

INSERT INTO panier VALUES (NULL,0,0);
INSERT INTO panier VALUES (NULL,0,0);
INSERT INTO panier VALUES (NULL,0,0);
INSERT INTO panier VALUES (NULL,0,0);
INSERT INTO panier VALUES (NULL,0,0);

INSERT INTO ligne_panier VALUES (1,2,1);
INSERT INTO ligne_panier VALUES (1,4,1);
INSERT INTO ligne_panier VALUES (1,5,1);

INSERT INTO ligne_panier VALUES (3,1,2);
INSERT INTO ligne_panier VALUES (1,5,2);
INSERT INTO ligne_panier VALUES (1,16,2);

INSERT INTO ligne_panier VALUES (2,10,3);
INSERT INTO ligne_panier VALUES (1,2,3);

INSERT INTO ligne_panier VALUES (1,14,4);

INSERT INTO ligne_panier VALUES (3,9,5);

INSERT INTO utilisateur VALUES ("t1","t1",1);
INSERT INTO utilisateur VALUES ("agouat","agt",2);
INSERT INTO utilisateur VALUES ("mmeyer","myr",3);
INSERT INTO utilisateur VALUES ("t2","test2",4);
INSERT INTO utilisateur VALUES ("t3","test3",5);

UPDATE panier set total=(SELECT SUM(article.prix*ligne_panier.quantite) FROM ligne_panier
                         JOIN article on article.id = article_id
                         JOIN panier on panier.id = panier_id
                         where panier.id=1),
                  nb_article=(SELECT SUM(quantite) FROM ligne_panier
                               JOIN article on article.id = article_id
                               JOIN panier on panier.id = panier_id
                              where panier.id=1)
WHERE panier.id=1;

UPDATE panier set total=(SELECT SUM(article.prix*ligne_panier.quantite) FROM ligne_panier
                         JOIN article on article.id = article_id
                         JOIN panier on panier.id = panier_id
                         where panier.id=2),
                 nb_article=(SELECT SUM(quantite) FROM ligne_panier
                            JOIN article on article.id = article_id
                            JOIN panier on panier.id = panier_id
                            where panier.id=2)
WHERE panier.id=2;

UPDATE panier set total=(SELECT SUM(article.prix*ligne_panier.quantite) FROM ligne_panier
                         JOIN article on article.id = article_id
                         JOIN panier on panier.id = panier_id
                         where panier.id=3),
                  nb_article=(SELECT SUM(quantite) FROM ligne_panier
                               JOIN article on article.id = article_id
                               JOIN panier on panier.id = panier_id
                              where panier.id=3)
WHERE panier.id=3;

UPDATE panier set total=(SELECT SUM(article.prix*ligne_panier.quantite) FROM ligne_panier
                         JOIN article on article.id = article_id
                         JOIN panier on panier.id = panier_id
                         where panier.id=4),
                  nb_article=(SELECT SUM(quantite) FROM ligne_panier
                               JOIN article on article.id = article_id
                               JOIN panier on panier.id = panier_id
                              where panier.id=4)
WHERE panier.id=4;

UPDATE panier set total=(SELECT SUM(article.prix*ligne_panier.quantite) FROM ligne_panier
                         JOIN article on article.id = article_id
                         JOIN panier on panier.id = panier_id
                         where panier.id=5),
                  nb_article=(SELECT SUM(quantite) FROM ligne_panier
                               JOIN article on article.id = article_id
                               JOIN panier on panier.id = panier_id
                              where panier.id=5)
WHERE panier.id=5;