USE PROJET_RMI_Magasin_3;
INSERT INTO type_article VALUES (NULL,"Télés","Pour reguarder des films");
INSERT INTO type_article VALUES (NULL,"Tablettes","Pour transporter");
INSERT INTO type_article VALUES (NULL,"Téléphones","Pour téléphoner");

INSERT INTO article VALUES (NULL,'',"Télé V1",1500.50,"normal",1,0);
INSERT INTO article VALUES (NULL,'',"Télé V2",5000.50,"Cher",1,0);
INSERT INTO article VALUES (NULL,'',"Télé V3",500.50,"Grande",1,0);
INSERT INTO article VALUES (NULL,'',"Tablette V1",250,"Pour transporter",2,10);
INSERT INTO article VALUES (NULL,'',"Tablette V2",150,"Modèle grand public",2,10);
INSERT INTO article VALUES (NULL,'',"Tablette V3",50,"1er prix",2,10);
INSERT INTO article VALUES (NULL,'',"Téléphone V1",1281.50,"Pour les riches",3,10);
INSERT INTO article VALUES (NULL,'',"Téléphone V2",41,"a clapet",3,10);
INSERT INTO article VALUES (NULL,'',"Téléphone V3",481.50,"Moyenne gamme",3,10);

INSERT INTO panier VALUES (NULL,0,0);
INSERT INTO panier VALUES (NULL,0,0);
INSERT INTO panier VALUES (NULL,0,0);

INSERT INTO utilisateur VALUES ("test1","t1",1);
INSERT INTO utilisateur VALUES ("agouat","agt",2);
INSERT INTO utilisateur VALUES ("mmeyer","myr",3);