CREATE TABLE forms (
    id bigint unsigned NOT NULL AUTO_INCREMENT,
    first_name varchar(32) NOT NULL,
    last_name varchar(32) NOT NULL,
    mobile_number varchar(20) NOT NULL,
    is_completed boolean NOT NULL,
    PRIMARY KEY (id)
);