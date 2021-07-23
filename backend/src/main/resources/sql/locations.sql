CREATE TABLE locations
(
 location_id int NOT NULL,
 session_uid uuid default NOT NULL,
 latitude    numeric NULL,
 longitude   numeric NULL,
 CONSTRAINT PK_locations PRIMARY KEY ( location_id ),
 CONSTRAINT FK_17 FOREIGN KEY ( session_uid ) REFERENCES sessions ( uid )
);

CREATE INDEX fkIdx_18 ON locations
(
 session_uid
);
