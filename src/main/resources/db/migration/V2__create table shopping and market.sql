CREATE TABLE IF NOT EXISTS shopping (
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY,
    shoppingDate timestamp NOT NULL,
    totalPrice double precision NOT NULL,
    marketId bigint NOT NULL,
    userId bigint NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (userId) REFERENCES "user" (id)
);

CREATE TABLE IF NOT EXISTS market (
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(100) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

ALTER TABLE shopping ADD CONSTRAINT fk_market FOREIGN KEY (marketId) REFERENCES market (id);