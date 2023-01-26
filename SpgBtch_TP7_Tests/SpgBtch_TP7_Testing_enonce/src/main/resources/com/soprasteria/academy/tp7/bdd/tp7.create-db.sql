DROP TABLE IF EXISTS bibliotheque;

CREATE TABLE bibliotheque(
isbn VARCHAR(17) NOT NULL,
author VARCHAR(50) NOT NULL,
title VARCHAR(50) NOT NULL,
publicationyear int(4) NOT NULL,
stock int(2) DEFAULT NULL,
estimationtotal decimal(4,0) DEFAULT NULL,
rare int(1) DEFAULT 0,
CONSTRAINT pk_biblio PRIMARY KEY (isbn)
);