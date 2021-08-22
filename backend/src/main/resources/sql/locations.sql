CREATE TABLE locations
(
 location_id SERIAL DEFAULT NOT NULL,
 session_uid varchar(255) NOT NULL,
 latitude    numeric NULL,
 longitude   numeric NULL,
 updated_date date NULL,
 CONSTRAINT PK_locations PRIMARY KEY ( location_id ),
 CONSTRAINT FK_17 FOREIGN KEY ( session_uid ) REFERENCES sessions ( uid )
);

CREATE INDEX fkIdx_18 ON locations
(
 session_uid
);
