INSERT INTO Departamento VALUES (1,'Atlántida'),
(2,'Colón'),	
(3,'Comayagua'),	
(4,'Copán'),	
(5,'Cortés'),	
(6,'Choluteca'),	
(7,'El Paraíso'),	
(8,'Francisco Morazán'),	
(9,'Gracias a Dios'),	
(10,'Intibucá'),	
(11,'Islas de la Bahía'),
(12,'La Paz'),	
(13,'Lempira'),	
(14,'Ocotepeque'),	
(15,'Olancho'),	
(16,'Santa Bárbara'),	
(17,'Valle'),	
(18,'Yoro');
INSERT INTO Ciudad VALUES 
(1,'La Ceiba',1),
(2,'Tela',1),
(3,'El Porvenir',1),
(4,'Trujillo',2),
(5,'Saba',2),
(6,'Tocoa',2),
(7,'Sonaguera',2),
(8,'Comayagua',3),
(9,'Esquías',3),
(10,'Siguatepeque',3),
(11,'Taulabe',3),
(12,'Santa Rosa de Copan',4),
(13,'Copan Ruinas',4),
(14,'San Pedro Sula',5),
(15,'Choloma',5),
(16,'Omoa',5),
(17,'Puerto Cortes',5),
(18,'La Lima',5),
(19,'Villanueva',5),
(20,'Choluteca',6),
(21,'El triunfo',6),
(22,'Marcovia',6),
(23,'San Marcos de Colón',6),
(24,'Yuscarán',7),
(25,'Danlí',7),
(26,'Texiguat',7),
(27,'Trojes',7),
(28,'Morocelí',7),
(29,'Distrito Central',8),
(30,'Ojojona',8),
(31,'Sabanagrande',8),
(32,'Santa Ana',8),
(33,'Tatumbla',8),
(34,'Guaimaca',8),
(35,'Valle de Ángeles',8),
(36,'Puerto Lempira',9),
(37,'Brus Laguna',9),
(38,'La Esperanza',10),
(39,'Intibuca',10),
(40,'Yamaranguila',10),
(41,'Roata',11),
(42,'Guanaja',11),
(43,'Utila',11),
(44,'La Paz',12),
(45,'Marcala',12),
(46,'Gracias',13),
(47,'Belen',13),
(48,'La Campa',13),
(49,'Ocotepeque ',14),
(50,'Belén Gualcho',14),
(51,'Juticalpa',15),
(52,'Campamento',15),
(53,'Catacamas',15),
(54,'San Esteban',15),
(55,'Patuca',15),
(56,'Santa Barbara',16),
(57,'Ilama',16),
(58,'San Luis',16),
(59,'Nacaome',17),
(60,'San Lorenzo',17),
(61,'Langue',17),
(62,'Amapala',17),
(63,'Yoro',18),
(64,'El Progreso',18),
(65,'Olanchito',18);

INSERT INTO manufacturador (manufacturador) VALUES
('Caterpillar'),
('John Deere'),
('Volvo CE'),
('Hitachi'),
('Hyundai');

INSERT INTO Categoria (categoria) VALUES 
('Equipo de movimiento de tierras'),
('Equipo de hormigado'),
('Equipo de elevacion de materiales'),
('Equipo de uso especial'),
('Equipo de soporte');

INSERT INTO Subcategoria (subcat, id_cat) VALUES
('Equipos de movimiento de tierras',1),
('Equipo de excavación',1),
('Equipo de carga',1),
('Equipo de transporte',1),
('Equipo de compactacion',1),
('Equipo de producción',2),
('Equipo de transporte',2),
('Equipo de colocación',2),
('Elevadores',3),
('Grúas moviles',3),
('Grúas estaticas',3),
('Equipo de pavimentación',4),
('Mezcladoras de asfalto',4),
('Equipo de túneles',4),
('Equipo de servicios',5),
('Equipo de apoyo',5);

INSERT INTO Tipo_maquina (tipo, id_subcat) VALUES 
('Bulldozer',1),
('Motoniveladora',1),
('Cargador frontal',1),
('Retroexcavadora',2),
('Dragalina',2),
('Excavadora',2),
('Cargadora',3),
('Camión',3),
('Camión Articulado',4),
('Volqueta',4),
('Rodillo de neutomatico',5),
('Compactadores de placa',5),
('Rodillo de rueda lisa',5),
('Planta de hormigon', 6),
('Mezcladora',6),
('Hormigonera',7),
('Volquetas de concreto',7),
('Bombas de hormigon', 8),
('Elevadores',8),
('Equipo de inyeccion', 8),
('Elevador fijo', 9),
('Elevador móvil',9),
('Carretilla elevadora',9),
('Grua de neutomatico',10),
('Grua sobra camión',10),
('Grua montada en oruga',10),
('Grua estacionaria',11),
('Grua para transporte',11),
('Acabados hormigón',12),
('Plantas de asfalto',13),
('Pavimentadora de asfalto',13),
('Equipos de transporte de escombro',14),
('Tuneladoras',14),
('Generadores',15),
('Equipo de soldadura',15),
('Equipos de bombeo y deshidratación',16),
('Equipos de colocación de tuberías',16);

select * from usuario;

Insert into usuario VALUES
(1,'Casey','Bennell',99272732,'cbennell0@twitter.com','LKzoo1iz','2022-06-06 23:56:04',true,'dEi5hi'),
<<<<<<< HEAD
(56,'Drake','Asty',99696461,'dasty1j@toplist.cz','0zxF0XvTo','2022-05-24 16:39:23',true,'x0GpK6'),
(57,'Herc','Dufall',99700991,'hdufall1k@mtv.com','oSnxCwNE9p','2022-05-16 20:09:03',true,'eqbqTl'),
(58,'Nolan','Donoghue',99953289,'nodonoghue1l@hatena.ne','a6qNbb22t','2022-05-27 03:53:12',true,'kJt9tr'),
(59,'Leonard','Addison',99664788,'laddison1m@unblog.fr','ovsARoOrGW','2021-08-15 13:20:13',true,'01U1wT'),
(60,'Wilfred','Thorowgood',99574889,'wthorowgood1n@behance.net','xlaclr9','2022-05-10 15:39:41',true,'SDnvhb'),
=======
>>>>>>> 1695f77eadce52b0123a55af055f44f62b8237c3
(2,'Thornie','Dust',99510734,'tdust1@ameblo.jp','gtdb4nzCW','2022-06-19 22:03:24',true,'cIQ4XV'),
(3,'Krispin','Domsalla',99231508,'kdomsalla2@sitemeter.com','XnMbIZ','2022-01-09 11:09:27',true,'4SAQNB'),
(4,'Nehemiah','Hayden',99764971,'nhayden3@whitehouse.gov','uJCcWQT65xQU','2021-09-28 07:26:35',true,'TzD9fn'),
(5,'Clemmie','Bloodworth',99332689,'cbloodworth4@hibu.com','zB8eUMie','2022-01-11 12:16:43',true,'qMMwXv'),
(6,'Ambros','Spofford',99306006,'aspofford5@woothemes.com','auIALleIJ3','2022-04-22 00:15:35',true,'LI6RcF'),
(7,'Delano','Dartnall',99459748,'ddartnall6@sfgate.com','alnvTKpC','2022-03-08 17:30:09',true,'uoFhu6'),
(8,'Jephthah','Johananov',99487026,'jjohananov7@amazon.uk','c4G8Uf3Kfqbu','2022-03-15 16:47:38',true,'v1TC4t'),
(9,'Monty','Davenhill',99408967,'mdavenhill8@cloudflare.com','EkjvCmzyIy','2022-04-20 11:25:03',true,'y8BqxE'),
(10,'Caryl','Renon',99371956,'crenon9@wunderground.com','xTEdapBdTJ','2021-12-18 00:27:32',true,'rxuhs3'),
(11,'Mychal','Maydway',99067146,'mmaydwaya@mapquest.com','aAB7LH8JFXHD','2021-07-04 05:29:34',true,'Th5K6r'),
(12,'Cale','Rowberry',99121381,'crowberryb@home.pl','1fQbk0CO','2022-04-27 06:15:59',true,'rDOJrJ'),
(13,'Gan','Heam',99378339,'gheamc@yelp.com','3l2uqpuSNd','2022-06-07 06:25:45',true,'L3e28h'),
(14,'Chaunce','Takis',99669417,'ctakisd@wufoo.com','f1LQRTR','2022-03-24 06:06:35',true,'EVdt0T'),
(15,'Georg','Siward',99030909,'gsiwarde@tamu.edu','KtXPfCkkH','2021-08-31 19:46:31',true,'ySpwE7'),
(16,'Neville','Benjafield',99453853,'nbenjafieldf@tamu.edu','ZzmAR0aL1g','2022-05-27 02:39:36',true,'DSrM6h'),
(17,'Ahmed','Ikin',99653886,'aiking@dmoz.org','3CeaILIr7exY','2021-11-28 19:13:06',true,'0E6pWl'),
(18,'Coop','Annis',99055372,'cannish@free.fr','c0Wmg1','2022-05-14 21:44:08',true,'7nrFsn'),
(19,'Carlie','Eicheler',99477197,'ceicheleri@soundcloud.com','kYVyACg','2022-06-12 13:25:52',true,'VjJWyA'),
(20,'Smitty','Roblin',99305862,'sroblinj@abc.net','1v4l8S6','2021-09-21 07:05:16',true,'WXrey4'),
(21,'Mord','Purdey',99284778,'mpurdeyk@netvibes.com','agMHLpEDAJyj','2022-07-22 13:24:20',true,'104Fwg'),
(22,'Caspar','Eburne',99254975,'ceburnel@reverbnation.com','sadxIM6','2022-04-11 20:41:49',true,'bfV5FD'),
(23,'Jedd','Huller',99759531,'jhullerm@geocities.com','fdm7jY5qGU','2021-10-08 20:01:57',true,'yWJadZ'),
(24,'Carr','Tace',99335656,'ctacen@squarespace.com','KBFfLQuXg1hd','2022-07-07 16:23:31',true,'vKcQoO'),
(25,'Kenny','Slaney',99887351,'kslaneyo@sciencedirect.com','P9Lozw','2022-07-24 14:57:27',true,'a3X2pq'),
(26,'Brian','Degli' ,99700212,'bdegliantonip@wikipedia.org','0R5QNjKa','2021-07-26 22:01:34',true,'CwOHoS'),
(27,'Joe','Belloch',99526370,'jbellochq@naver.com','0DpJASP','2022-06-09 12:17:57',true,'rfGa89'),
(28,'Erek','Joseph',99145376,'ejosephr@un.org','lqqofbs','2021-08-12 07:10:26',true,'8FBkVm'),
(29,'Bret','Norsister',99821223,'bnorsisters@ftc.gov','26RYCNXACU','2021-09-06 22:39:32',true,'SdV96v'),
(30,'King','Cotterill',99685502,'kcotterillt@bloomberg.com','Ax8L98ZHz','2022-03-06 13:24:32',true,'rHezK9'),
(31,'Inglebert','Meiner',99101312,'imeineru@youtu.be','FvnkuXY','2022-05-30 22:10:30',true,'M5rcKv'),
(32,'Yancey','Hards',99669975,'yhardsv@narod.ru','5iFAmoxIt','2021-08-16 11:41:38',true,'KCZhDk'),
(33,'Floyd','Loud',99942188,'floudw@youku.com','xsBAKO','2022-07-22 19:42:59',true,'VFb2ZS'),
(34,'Sydney','Jacks',99148662,'sjacksx@parallels.com','KyTkSi1rVTIR','2021-09-14 23:13:33',true,'xIosNR'),
(35,'Julian','Tommeo',99287185,'jtommeoy@soup.io','gxLyFxG','2021-11-13 16:03:03',true,'JpRQRH'),
(36,'Huntley','Bartlomiejczyk',99640703,'hbartlomiejczykz@businesswire.com','41w2VAkeWx','2021-08-12 16:38:34',true,'gkKTRy'),
(37,'Ivor','Abotson',99709196,'iabotson10@prnewswire.com','3T9zZ8','2022-04-08 02:05:15',true,'Gxvr4U'),
(38,'Tannie','Van',99575232,'tvanhove11@google.co.hk','MoFkpB','2021-11-04 05:59:32',true,'MmRzTC'),
(39,'Judd','Pylkynyton',99077873,'jpylkynyton12@webeden.uk','hQb60ty','2022-06-14 16:55:48',true,'vkj7A7'),
(40,'Bryant','Twining',99535049,'btwining13@usda.gov','li6JGPE08','2022-06-28 11:56:18',true,'TatBus'),
(41,'Bradley','Shiel',99342612,'bshiel14@senate.gov','XdDXJ1rd8','2022-01-01 12:50:25',true,'rhnUvK'),
(42,'Enrico','Vockins',99304557,'evockins15@themeforest.net','T42IT8','2021-12-18 15:25:08',true,'K5IbWr'),
(43,'Sherwin','Janisson',99576196,'sjanisson16@nydailynews.com','cdaptS','2022-07-31 07:42:15',true,'l2ZlDt'),
(44,'Bartholomeus','Castanie',99807160,'bcastanie17@europa.eu','4ikNuKErk71','2021-12-19 22:47:55',true,'3Kz8Jk'),
(45,'Corbett','Lochead',99492133,'clochead18@cnet.com','fBtvuW','2022-01-22 01:04:17',true,'lbVuk4'),
(46,'Harper','Firmin',99514109,'hfirmin19@netscape.com','9UmuQJeTJWtK','2021-07-25 14:10:08',true,'AjB5Vv'),
(47,'Kennie','Schrei',99694272,'kschrei1a@stumbleupon.com','2yaWLX','2021-07-19 02:11:04',true,'i4JIfn'),
(48,'Carlie','Rangle',99622956,'crangle1b@npr.org','qDgfkRyebw','2021-10-20 12:34:13',true,'OqK1Rk'),
(49,'Alvan','Bendon',99773860,'abendon1c@skyrock.com','PPgfiO','2022-02-15 04:50:55',true,'lHZvby'),
(50,'William','Tiffney',99614684,'wtiffney1d@arstechnica.com','C3bo8jvnme','2021-08-14 20:19:38',true,'PH1DDo'),
(51,'Monroe','Sherston',99178940,'msherston1e@cnn.com','6r91bFpwe','2021-07-30 09:28:11',true,'FNv4EM'),
(52,'Tades','Parnaby',99055821,'tparnaby1f@livejournal.com','pqK74zwXCcFP','2022-05-08 20:11:33',true,'bVv6xq'),
(53,'Georges','Budge',99232663,'gbudge1g@fotki.com','pdCFnWLZ','2022-05-16 10:55:33',true,'olcstq'),
(54,'Matt','Tomblings',99608476,'mtomblings1h@networksolutions.com','KaCZvi','2021-10-10 19:13:50',true,'pP84dF'),
(55,'Franz','Pelfer',99983636,'fpelfer1i@answers.com','v98lmB','2021-10-15 23:49:32',true,'Hvr3ti'),
(56,'Drake','Asty',99696461,'dasty1j@toplist.cz','0zxF0XvTo','2022-05-24 16:39:23',true,'x0GpK6'),
(57,'Herc','Dufall',99700991,'hdufall1k@mtv.com','oSnxCwNE9p','2022-05-16 20:09:03',true,'eqbqTl'),
(58,'Nolan','Donoghue',99953289,'nodonoghue1l@hatena.ne','a6qNbb22t','2022-05-27 03:53:12',true,'kJt9tr'),
(59,'Leonard','Addison',99664788,'laddison1m@unblog.fr','ovsARoOrGW','2021-08-15 13:20:13',true,'01U1wT'),
(60,'Wilfred','Thorowgood',99574889,'wthorowgood1n@behance.net','xlaclr9','2022-05-10 15:39:41',true,'SDnvhb');

