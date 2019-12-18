/* 
	Tabellen voor het project van Applicatie architecturen
	Wannes Maes en Leen Gadisseur
 */


drop table reservatie purge;
drop table extern purge;
drop table studenten purge;
drop table docenten purge;
drop table secgroepen purge;
drop table secgebruikers purge;
drop table machine purge;
drop table opleiding purge;


create table opleiding 
(
	naam varchar2(10) primary key
);
create table machine
(
	naam varchar2(20),
	beschrijving varchar2(40),
	lokaal varchar2(5),
	opleiding varchar2(10),
	serienr int primary key,
	aankoopprijs int,
	uurprijs int,
	foreign key (opleiding) references opleiding(naam)
);
create table secgebruikers 
(
	gebruikersnaam int primary key,
	paswoord varchar2(20)
);

create table secgroepen 
(
	gebruikersnaam int references secgebruikers primary key,
	groep varchar2(20)
);
create table docenten
(
	dnr int primary key,
	naam varchar2(20),
	opleiding varchar2(10),
	foreign key (opleiding) references opleiding(naam),
	foreign key (dnr) references secgebruikers(gebruikersnaam)
);
create table studenten
(
	snr int primary key,
	naam varchar2(20),
	foreign key (snr) references secgebruikers(gebruikersnaam)
);
create table extern
(
	enr int primary key,
	naam varchar2(20),
	foreign key (enr) references secgebruikers(gebruikersnaam)
);
create table reservatie
(
	rnr int primary key,
	serienr int,
	datum date,
	startuur int,
	einduur int,
	beschikbaar varchar2(1) not null,
        huurder int,
	check (startuur>7),
	check (einduur<20),
	check (beschikbaar='j' OR beschikbaar='n'),
	foreign key (serienr) references machine(serienr),
	foreign key (huurder) references secgebruikers(gebruikersnaam)
);

insert into opleiding values ('EICT');
insert into opleiding values ('EM');
insert into opleiding values ('Chemie');
insert into opleiding values ('BK');

insert into machine values ('Server1','Hostplaats voor onze databank','A213','EICT',1001,1000,10);
insert into machine values ('Draaibank1','Ding voor bouw','B213','BK',2001,2000,20);
insert into machine values ('Destilatiekolom1','Destileerkolom','C213','Chemie',3001,3000,30);
insert into machine values ('3D-printer1','Speelgoed voor volwassenen','E213','EM',4003,4000,40);
insert into machine values ('Server2','Hostplaats voor onze databank','A213','EICT',1002,5000,50);
insert into machine values ('Draaibank2','Ding voor bouw','B213','BK',2002,6000,60);
insert into machine values ('Destilatiekolom2','Destileerkolom','C213','Chemie',3002,7000,70);
insert into machine values ('3D-printer2','Speelgoed voor volwassenen','E213','EM',4002,8000,80);
insert into machine values ('Server3','Hostplaats voor onze databank','A113','EICT',1003,9000,90);
insert into machine values ('Draaibank3','Ding voor bouw','B113','BK',2003,1500,15);
insert into machine values ('Destilatiekolom3','Destileerkolom','C113','Chemie',3003,2500,25);
insert into machine values ('3D-printer3','Speelgoed voor volwassenen','E113','EM',4001,3500,35);

insert into secgebruikers values (1,'1');
insert into secgebruikers values (2,'2');
insert into secgebruikers values (3,'3');
insert into secgebruikers values (4,'4');
insert into secgebruikers values (5,'5');
insert into secgebruikers values (6,'6');
insert into secgebruikers values (7,'7');
insert into secgebruikers values (8,'8');

insert into secgroepen values (1,'docent');
insert into secgroepen values (2,'docent');
insert into secgroepen values (3,'docent');
insert into secgroepen values (4,'docent');
insert into secgroepen values (5,'docent');
insert into secgroepen values (6,'student');
insert into secgroepen values (7,'student');
insert into secgroepen values (8,'extern');

insert into docenten values (1,'hcr','EICT');
insert into docenten values (2,'avh','EICT');
insert into docenten values (3,'bbb','BK');
insert into docenten values (4,'eee','EM');
insert into docenten values (5,'ccc','Chemie');


insert into studenten values(6,'Wannes');
insert into studenten values(7,'Leen');

insert into extern values(8,'erasmus');


insert into reservatie values (1,1001,sysdate,8,9,'n',6);
insert into reservatie values (2,1001,sysdate,9,11,'j',null);
insert into reservatie values (3,1001,sysdate,13,14,'j',null);
insert into reservatie values (4,2001,sysdate,8,9,'j',null);
insert into reservatie values (5,2001,sysdate,9,11,'j',null);
insert into reservatie values (6,2001,sysdate,13,14,'j',null);
insert into reservatie values (7,1001,sysdate,8,9,'j',null);
insert into reservatie values (8,1001,sysdate,9,11,'j',null);
insert into reservatie values (9,1001,sysdate,13,14,'j',null);
insert into reservatie values (10,2001,sysdate,8,9,'j',null);
insert into reservatie values (11,2001,sysdate,9,11,'j',null);
insert into reservatie values (12,2001,sysdate,13,14,'j',null);

insert into reservatie values (13,1002,sysdate,8,9,'j',null);
insert into reservatie values (14,1002,sysdate,9,11,'j',null);
insert into reservatie values (15,1002,sysdate,13,14,'j',null);
insert into reservatie values (16,2002,sysdate,8,9,'j',null);
insert into reservatie values (17,2002,sysdate,9,11,'j',null);
insert into reservatie values (18,2002,sysdate,13,14,'j',null);
insert into reservatie values (19,1002,sysdate,8,9,'j',null);
insert into reservatie values (20,1002,sysdate,9,11,'j',null);
insert into reservatie values (21,1002,sysdate,13,14,'j',null);
insert into reservatie values (22,2002,sysdate,8,9,'j',null);
insert into reservatie values (23,2002,sysdate,9,11,'j',null);
insert into reservatie values (24,2002,sysdate,13,14,'j',null);

insert into reservatie values (25,1003,sysdate,8,9,'j',null);
insert into reservatie values (26,1003,sysdate,9,11,'j',null);
insert into reservatie values (27,1003,sysdate,13,14,'j',null);
insert into reservatie values (28,2003,sysdate,8,9,'j',null);
insert into reservatie values (29,2003,sysdate,9,11,'j',null);
insert into reservatie values (30,2003,sysdate,13,14,'j',null);
insert into reservatie values (31,1003,sysdate,8,9,'j',null);
insert into reservatie values (32,1003,sysdate,9,11,'j',null);
insert into reservatie values (33,1003,sysdate,13,14,'j',null);
insert into reservatie values (34,2003,sysdate,8,9,'j',null);
insert into reservatie values (35,2003,sysdate,9,11,'j',null);
insert into reservatie values (36,2003,sysdate,13,14,'j',null);


