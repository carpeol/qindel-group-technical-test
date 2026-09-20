CREATE TABLE prices (
    price_list BIGINT PRIMARY KEY,
    brand_id BIGINT NOT NULL,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    product_id BIGINT NOT NULL,
    priority BIGINT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    curr VARCHAR(3) NOT NULL
);

CREATE INDEX idx_prices_applicability
    ON prices (brand_id, product_id, start_date, end_date, priority);

INSERT INTO prices (price_list, brand_id, start_date, end_date, product_id, priority, price, curr) VALUES
    (1, 1, TIMESTAMP '2020-06-14 00:00:00', TIMESTAMP '2020-12-31 23:59:59', 35455, 0, 35.50, 'EUR'),
    (2, 1, TIMESTAMP '2020-06-14 15:00:00', TIMESTAMP '2020-06-14 18:30:00', 35455, 1, 25.45, 'EUR'),
    (3, 1, TIMESTAMP '2020-06-15 00:00:00', TIMESTAMP '2020-06-15 11:00:00', 35455, 1, 30.50, 'EUR'),
    (4, 1, TIMESTAMP '2020-06-15 16:00:00', TIMESTAMP '2020-12-31 23:59:59', 35455, 1, 38.95, 'EUR');
