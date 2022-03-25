USE PROJET_RMI_Magasin_1;
INSERT INTO type_article VALUES (NULL,"Carte graphique","Fait tourner les jeux et affiche les images");
INSERT INTO type_article VALUES (NULL,"Carte mère","Permet d'y inserer le CPU le GPU et la RAM");
INSERT INTO type_article VALUES (NULL,"Processeur","CPU");
INSERT INTO type_article VALUES (NULL,"RAM","Mémoire vive");
INSERT INTO type_article VALUES (NULL,"Boitier","Pour y mettre le matos");
INSERT INTO type_article VALUES (NULL,"Ventilos","Refroidir le PC");

INSERT INTO article VALUES (NULL,'https://dyw7ncnq1en5l.cloudfront.net/optim/produits/363/45503/nvidia-geforce-rtx-2070_d2b78e11a93459be__1200_900__overflow.jpg',"carte graphique V1",500.50,"Bien pour jouer mais peu aussi ce manger",1,0);
INSERT INTO article VALUES (NULL,'https://m.media-amazon.com/images/I/71OpiCVK+0L._AC_SX425_.jpg',"carte graphique V2",500.50,"Bien pour jouer mais peu aussi ce manger",1,0);
INSERT INTO article VALUES (NULL,'https://www.rueducommerce.fr/medias/e6dedaa129ac3266a6d9787322d55347/p_1000x1000/20191029084619208344ca10499c001fc964a0f79e0d3dc2-big.png',"carte graphique V3",500.50,"Bien pour jouer mais peu aussi ce manger",1,0);
INSERT INTO article VALUES (NULL,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTNjbfaHWmv6AXl-2Ilz90zTlIuxxlPS-QrRg&usqp=CAU',"carte mère V1",250,"Pour le processeur",2,10);
INSERT INTO article VALUES (NULL,'https://blog.integral-system.fr/wp-content/uploads/2019/05/171342-1.jpg',"carte mère V2",250,"Pour le processeur",2,10);
INSERT INTO article VALUES (NULL,'https://static.fnac-static.com/multimedia/Images/FR/MDM/82/85/ee/15631746/1505-1/tsp20211201090558/Carte-mere-Gaming-Asus-TUF-Intel-Z490-Plus.jpg',"carte mère V3",250,"Pour le processeur",2,10);
INSERT INTO article VALUES (NULL,'https://www.tradediscount.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/i/n/intelcorei3_1_1_1_1_2.jpg',"Processeur V1",481.50,"ça chauffe vite",3,10);
INSERT INTO article VALUES (NULL,'https://www.tradediscount.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/i/n/intel-core-i5-3320m_2.jpg',"Processeur V2",481.50,"ça chauffe vite",3,10);
INSERT INTO article VALUES (NULL,'https://m.media-amazon.com/images/I/51iVSqLIBWL._AC_SS450_.jpg',"Processeur V3",481.50,"ça chauffe vite",3,10);
INSERT INTO article VALUES (NULL,'https://www.esus-it.fr/fre_pl_Memoire-RAM-2-GB-Toshiba-Satellite-L555D-S7006-DDR2-800MHz-SO-DIMM-8734_1.jpg',"RAM V1",85.90,"Pas pour le kanoe",4,3);
INSERT INTO article VALUES (NULL,'https://m.media-amazon.com/images/I/41RygOJrSiL._AC_SX450_.jpg',"RAM V2",85.90,"Pas pour le kanoe",4,3);
INSERT INTO article VALUES (NULL,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSIyOKU_G8OIYi0zFPI3aA4gvDIR2V5KbPuvyedC6PszCCxyjACLzFn9vcrRbEP_ailI_I&usqp=CAU',"RAM V3",85.90,"Pas pour le kanoe",4,3);
INSERT INTO article VALUES (NULL,'https://www.cybertek.fr/images_produits/76cc6a64-84c8-4d7f-b6a1-0bc577cb1ccd.jpg',"Boitier PC V1",120.88,"C'est joli avec une vitre",5,129);
INSERT INTO article VALUES (NULL,'https://www.cybertek.fr/images_produits/6eba4300-e0c5-4a33-9b0a-143a803a14ee.jpg',"Boitier PC V2",120.88,"C'est joli avec une vitre",5,129);
INSERT INTO article VALUES (NULL,'https://m.media-amazon.com/images/I/61w2nSUYeTL._AC_SX425_.jpg',"Boitier PC V3",120.88,"C'est joli avec une vitre",5,129);
INSERT INTO article VALUES (NULL,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQWe6JLxokZcFy8tkZns7JiMPH1DFXLXvjSkg&usqp=CAU',"Ventilos V1",45.50,"Pour refroidir le tout",6,5);
INSERT INTO article VALUES (NULL,'https://m.media-amazon.com/images/I/61neDG65pTL._SX342_.jpg',"Ventilos V2",45.50,"Pour refroidir le tout",6,5);
INSERT INTO article VALUES (NULL,'https://m.media-amazon.com/images/I/71AlddnOwYL._AC_SL1500_.jpg',"Ventilos V3",45.50,"Pour refroidir le tout",6,5);

INSERT INTO panier VALUES (NULL,0,0);
INSERT INTO panier VALUES (NULL,0,0);
INSERT INTO panier VALUES (NULL,0,0);

INSERT INTO utilisateur VALUES ("test1","t1",1);
INSERT INTO utilisateur VALUES ("agouat","agt",2);
INSERT INTO utilisateur VALUES ("mmeyer","myr",3);