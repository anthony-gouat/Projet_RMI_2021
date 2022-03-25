USE PROJET_RMI_Magasin_2;
INSERT INTO type_article VALUES (NULL,"Kayaks","Pour naviguer");
INSERT INTO type_article VALUES (NULL,"Pagais","Pour ramer");
INSERT INTO type_article VALUES (NULL,"Equipement de sécurité","Pour la sécurité");

INSERT INTO article VALUES (NULL,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTKi9tw4e47Qpp-CQ3TflW4vqnxJYv_vEIANA&usqp=CAU',"Kayaks V1",1500.50,"Rapide",1,0);
INSERT INTO article VALUES (NULL,'https://www.club-shop.fr/39463-large_default/cano%C3%AB-kayak-rigide-biwok-evo-hi-luxe-2-places.jpg',"Kayaks V2",5000.50,"Cher",1,0);
INSERT INTO article VALUES (NULL,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTFO9XmwnPsQeLQN0fbIFcXH9awBS1XuRtiWA&usqp=CAU',"Kayaks V3",500.50,"Grand",1,0);
INSERT INTO article VALUES (NULL,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSQ1u1HzmoOJGVWBhge8g5_Re-_R0XviUARHFxlu973GVtDKDeVWQexugv0ukxHsnXsWBk&usqp=CAU',"Pagais V1",250,"Pour ramer",2,10);
INSERT INTO article VALUES (NULL,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQaz2TOzSfsVKSpGxAu6zAqWpqYtgJF_aklKw&usqp=CAU',"Pagais V2",150,"Pour ramer",2,10);
INSERT INTO article VALUES (NULL,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQeKmbqr2oyRBGKvsuNB9SZyuzxwc1fsUT0EQ&usqp=CAU',"Pagais V3",50,"Pour ramer",2,10);
INSERT INTO article VALUES (NULL,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQeSx9hWtrppEng0Mgt3QqHx8vxmwaf6osdsg&usqp=CAU',"Casque",81.50,"Pour la tête",3,10);
INSERT INTO article VALUES (NULL,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRAOnM5p5r6DWC5PXQmCb-MInJfZA3ubyNX2zS8IXaDXhhpinNhNSWPG0zRFyNiCNdMPC4&usqp=CAU',"Gants",41,"Pour les mains",3,10);
INSERT INTO article VALUES (NULL,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRxN49XtYl-mgOONhc4weG25NzwPvgcE48wCg&usqp=CAU',"Gilet",481.50,"Pour flotter",3,10);

INSERT INTO panier VALUES (NULL,0,0);
INSERT INTO panier VALUES (NULL,0,0);
INSERT INTO panier VALUES (NULL,0,0);

INSERT INTO utilisateur VALUES ("test1","t1",1);
INSERT INTO utilisateur VALUES ("agouat","agt",2);
INSERT INTO utilisateur VALUES ("mmeyer","myr",3);