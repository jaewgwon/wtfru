CREATE TABLE users (
    user_id serial NOT NULL,
    user_name character varying(64) NOT NULL,
    password character varying(64) NOT NULL,
    type smallint NOT NULL,
    created_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    deleted_at timestamp with time zone,
    CONSTRAINT users_pkey PRIMARY KEY (user_id)
);