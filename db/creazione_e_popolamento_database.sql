DROP DATABASE IF EXISTS gamemarket;
CREATE DATABASE gamemarket;
USE gamemarket;

DROP TABLE IF EXISTS utenti;

CREATE TABLE utenti (	
  nome_utente varchar(50) not null ,
  passwrod varchar(50) not null ,
  role varchar(5) not null,
  balance float(2) DEFAULT 0,
  nome varchar(50) not null,
  cognome varchar(50) not null,
  nascita varchar(15) not null,
  primary key(nome_utente)
);

INSERT INTO utenti values ("pippo","admin","admin",50,"giuseppe","bianchi","1975-03-15");
INSERT INTO utenti values ("micky","admin","manag",50,"lorenzo","bianchi","1975-03-15");
INSERT INTO utenti values ("carmine","admin","user",50,"carmine","longhi","1975-03-15");
INSERT INTO utenti values ("emmy","admin","user",50,"cane","rossi","1975-03-15");

DROP TABLE IF EXISTS games;

CREATE TABLE games (	
  id int not null auto_increment,
  nome char(100) not null,
  years char(12) not null,
  added char(12)  not null,
  imgGame varchar(250) not null,
  quantita int not null default 1,
  price float(2) not null default 1,
  descrizione text(5000),
  genere varchar(20) not null,
  peg int not null,
  iva int not null,
  primary key(id)
);

INSERT INTO games values (null,"Elden Ring","2022-01-01","2022-01-30","elden.jpeg",4,"50.00","Alzati e segui il percorso oltre il mare nebbioso per incontrare il tuo destino nella nuovissima esperienza Souls di FromSoftware Inc.: Eldern Ring. Scritto da Hidetaka Miyazaki, il creatore di Dark Souls, e George R.R. Martin, la mente dietro A Song of Ice and Fire, il gioco promette un viaggio avvincente ma brutale, in cui grinta, determinazione e sete inestinguibile di trionfo sono la chiave per raccogliere alla fine tutti i frammenti dell'Elden Ring. Compra Elden Ring Steam Key e svela tutti i misteri delle Terre di Mezzo!","rpg","18","3");
INSERT INTO games values (null,"PlayStation Plus Card 90 Days","2022-01-02","2022-01-30","playstation.jpeg",4,"50.00","Card PlayStation Plus da 3 mesi ITALIA. Estendi l'abbonamento a PlayStation di 90 giorni con una Card PlayStation Plus Italiana! PlayStation Network è un servizio gratuito ma se acquisti l'abbonamento PS Plus sbloccherai funzionalità esclusive. Se sei connesso a PlayStation Network acquista questa pass, altrimenti potresti perdere contenuti esclusivi! Ecco alcuni dei vantaggi del PS Plus che devono essere sottolineati.","simulator","3","5");
INSERT INTO games values (null,"Assassin's Creed: Unity","2022-01-01","2022-01-30","assunity.jpg",4,"4.00","Le opzioni di personalizzazione della casa sono almeno altrettanto vaste rispetto alla creazione personaggio . Non solo puoi personalizzare ogni angolo della tua casa, ma puoi anche scegliere tra componenti già fatti: scarica un progetto pre-realizzato dallo spazio di archiviazione online, dove i giocatori di tutto il mondo mettono in pratica le loro idee. Solleva o abbassa le fondamenta stesse della tua casa o allunga e trascina i bordi delle tue mura se ti manca un po di spazio.","rpg","6","5");
INSERT INTO games values (null,"Call of Duty: Black Ops Cold War","2022-01-01","2022-02-01","calofduty2.jpg",4,"15.00","Le opzioni di personalizzazione della casa sono almeno altrettanto vaste rispetto alla creazione personaggio . Non solo puoi personalizzare ogni angolo della tua casa, ma puoi anche scegliere tra componenti già fatti: scarica un progetto pre-realizzato dallo spazio di archiviazione online, dove i giocatori di tutto il mondo mettono in pratica le loro idee. Solleva o abbassa le fondamenta stesse della tua casa o allunga e trascina i bordi delle tue mura se ti manca un po di spazio.","FPS","18","5");
INSERT INTO games values (null,"Fall Guys: Ultimate Knockout","2022-01-01","2022-02-09","fall.jpeg",4,"32.00","Le opzioni di personalizzazione della casa sono almeno altrettanto vaste rispetto alla creazione personaggio . Non solo puoi personalizzare ogni angolo della tua casa, ma puoi anche scegliere tra componenti già fatti: scarica un progetto pre-realizzato dallo spazio di archiviazione online, dove i giocatori di tutto il mondo mettono in pratica le loro idee. Solleva o abbassa le fondamenta stesse della tua casa o allunga e trascina i bordi delle tue mura se ti manca un po di spazio.","FPS","12","5");
INSERT INTO games values (null,"The Sims 4","2022-01-01","2022-03-30","sims4.jpg",4,"30.00",
	"The Sims 4  The SIms 4 è il quarto capitolo di un franchise incentrato sulla gestione di personaggi in tempo reale. Crea e personalizza il tuo personaggio, costruisci una casa, trova un lavoro - fai carriera, circondati da una famiglia e stringi amicizia con i tuoi vicini!, partecipa a numerose attività quotidiane o fai qualsiasi altra cosa tu possa pensare, dopo tutto è The Sims 4.
	Tecniche di personalizzazione di Stretch, Bend e Drag
	Una delle caratteristiche chiave di Sims 4 sul perché la serie The Sims è sempre stata il menu di creazione dei personaggi e The Sims 4 non fa eccezione. Il nuovo strumento Crea-un-Sim ti consente di diventare fondamentalmente uno scultore e piegare il tuo Sim in quasi ogni forma e forma fisica: puoi fare clic, trascinare e modificare manualmente quasi ogni aspetto della tua creazione.","Action","18","5");
INSERT INTO games values (null,"Warhammer 40,000: Chaos Gate - Daemonhunters","2022-01-01","2022-03-30","warhammer.jpg",4,"20.00",
	"Warhammer 40,000: Chaos Gate - Daemonhunters 
Already know every game you own by heart? Then it’s time for a new one! If you are a fan of strategy games like we are, then Warhammer 40,000: Chaos Gate - Daemonhunters key on Steam is the perfect choice for you. Developed by Complex Games and published on 2022-05-05 by the remarkable Frontier Foundry known for many top-notch games, the title exhibits just the same high quality. Thought-out design, multilayered gameplay, and energizing experience are all included in the title. Oh, and indelible impressions, too! Buy Warhammer 40,000: Chaos Gate - Daemonhunters Steam key at a cheaper price and unlock the door to the mesmerizing setting in which you will spend an amazing time tackling challenges.","multiplayer","18","5");
INSERT INTO games values (null,"FIFA 22","2022-01-01","2022-03-30","fifa22.jpg",4,"20.00",
	"FIFA 22 Sperimenta il prossimo livello di immersione con il nuovo gioco di FIFA! La data di uscita di FIFA 22 è segnata sul nostro calendario: il 2 ottobre e Electronic Arts promette molti nuovi contenuti e innovazioni per tutti gli appassionati di questa serie sportiva. Ogni modalità è stata ottimizzata per fornire prestazioni migliori, sono state apportate modifiche fondamentali al gameplay per rendere tutto più realistico e un impressionante elenco di oltre 17.000 giocatori e oltre 700 squadre è pronto a lottare per la vittoria sul campo. Metti alla prova le tue abilità in una delle 30 più grandi competizioni del mondo, sfida gli altri giocatori online o costruisci una carriera di successo nel mondo del calcio con FIFA 22!","Simulator","18","5");


DROP TABLE IF EXISTS ordini;

CREATE TABLE ordini (
  id int not null auto_increment,
  nome_utente varchar(50) not null ,
  totale float not null,
  iva int not null,
  quantita int not null,
  nome char(100) not null,
  fatturaNUmero varchar(25) not null,
  buyed varchar(25) not null,
  
  primary key(id),
  FOREIGN KEY (nome_utente) REFERENCES utenti(nome_utente)
);

INSERT INTO ordini values (null,"emmy",42.13,3,1,"Elden Ring","2134","2022-05-03 21:00:00");
INSERT INTO ordini values (null,"emmy",41.11,4,1,"Elden Ring","2135","2022-06-03 21:00:00");
INSERT INTO ordini values (null,"carmine",22.11,7,1,"Elden Ring","2124","2022-05-03 21:00:00");