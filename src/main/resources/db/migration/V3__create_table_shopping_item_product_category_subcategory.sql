CREATE TABLE IF NOT EXISTS category (
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(100) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS sub_category (
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(100) NOT NULL UNIQUE,
    category_id bigint NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (category_id) REFERENCES category (id)
);

CREATE TABLE IF NOT EXISTS product (
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(255) NOT NULL UNIQUE,
    sub_category_id bigint NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS shopping_item (
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY,
    product_id bigint NOT NULL,
    shopping_id bigint NOT NULL,
    quantity INTEGER NOT NULL,
    unitary_price DOUBLE PRECISION NOT NULL,
    total_price DOUBLE PRECISION NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (product_id) REFERENCES product (id),
    FOREIGN KEY (shopping_id) REFERENCES shopping (id)
);