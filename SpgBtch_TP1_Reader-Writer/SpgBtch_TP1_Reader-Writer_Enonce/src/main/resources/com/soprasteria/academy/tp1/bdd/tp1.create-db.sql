DROP TABLE IF EXISTS bibliotheque;

CREATE TABLE bibliotheque(
isbn VARCHAR(17) NOT NULL,
title VARCHAR(50) NOT NULL,
author VARCHAR(50) NOT NULL,
publicationyear int(11) NOT NULL,
europrice decimal(4,0) DEFAULT NULL,
stock int(2) DEFAULT NULL,
CONSTRAINT pk_biblio PRIMARY KEY (isbn)
);