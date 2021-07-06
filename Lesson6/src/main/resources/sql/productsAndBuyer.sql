BEGIN;

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products
(
    id    bigserial PRIMARY KEY,
    title VARCHAR(255),
    cost  double precision
);
INSERT INTO products (title,cost)
VALUES ('aaa', 35.2),
       ('bbb', 999.99),
       ('ccc', 135.66),
       ('ddd', 135.99),
       ('eee', 235.15),
       ('fff', 146.17),
       ('ggg', 111.11),
       ('hhh', 234.99),
       ('iii', 946.94),
       ('jjj', 964.66);

DROP TABLE IF EXISTS buyers CASCADE;
CREATE TABLE buyers
(
    id   bigserial PRIMARY KEY,
    name VARCHAR(255)
);
INSERT INTO buyers (name)
VALUES ('XXX'),
       ('YYY'),
       ('ZZZ');

DROP TABLE IF EXISTS buyers_products CASCADE;
CREATE TABLE buyers_products
(
    buyer_id   bigint,
    product_id bigint,
    FOREIGN KEY (product_id) REFERENCES products (id),
    FOREIGN KEY (buyer_id) REFERENCES buyers (id)
);
INSERT INTO buyers_products (product_id, buyer_id)
VALUES (1, 1),
       (2, 1),
       (3, 1),
       (4, 1),
       (5, 1),
       (6, 1),
       (7, 1),
       (8, 1),
       (9, 1),
       (10, 1),
       (1, 2),
       (2, 2),
       (3, 3),
       (5, 3),
       (9, 3),
       (10, 3);

COMMIT;
