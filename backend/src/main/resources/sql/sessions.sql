CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE sessions
(
 uid           varchar(255) DEFAULT uuid_generate_v4 (),
 session_id    int NOT NULL,
 title         varchar(50) NOT NULL,
 password      varchar(255) NOT NULL,
 location_link varchar(255) NOT NULL,
 role          varchar(13) NOT NULL,
 status        int NOT NULL,
 expired_date  date NULL,
 CONSTRAINT PK_sessions PRIMARY KEY ( uid )
);

COMMENT ON TABLE sessions IS 'unique id';

COMMENT ON COLUMN sessions.title IS 'session title';
COMMENT ON COLUMN sessions.password IS 'session password';
COMMENT ON COLUMN sessions.location_link IS 'location link';
COMMENT ON COLUMN sessions.status IS 'session status';
COMMENT ON COLUMN sessions.session_id IS 'session id';

CREATE SEQUENCE session_id;

INSERT INTO sessions (session_id, title, password, location_link, role, status)
VALUES (nextval('session_id'), 'mooyaho', '1234', 'https://1234', 'ROLE_USER', 0);