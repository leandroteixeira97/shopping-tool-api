CREATE TABLE IF NOT EXISTS credential(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY,
    username VARCHAR(30) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    expired BOOLEAN NOT NULL DEFAULT false,
    userId bigint NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS "user" (
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    credentialId bigint NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (credentialId) REFERENCES credential (id)
);

ALTER TABLE credential ADD CONSTRAINT fk_user FOREIGN KEY (userId) REFERENCES "user" (id);