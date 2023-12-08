create table Olona(
    idOlona serial PRIMARY KEY,
    nom VARCHAR(50),
    dateNaissance date
);

INSERT into Olona values (default,'nom1','11-1-11');
INSERT into Olona values (default,'nom2','11-1-12');
