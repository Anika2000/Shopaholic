CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username varchar(50) NOT NULL,
    password varchar(200) NOT NULL
);


CREATE TABLE items (
    item_id SERIAL PRIMARY KEY,
    seller int4 REFERENCES users (id) ON DELETE CASCADE,
    text    varchar(2000),
    stock int,
    price double
);

