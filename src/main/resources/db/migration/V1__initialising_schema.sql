CREATE TABLE forms (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(32) NOT NULL,
    last_name VARCHAR(32) NOT NULL,
    mobile_number VARCHAR(20) NOT NULL,
    is_completed BOOLEAN NOT NULL
);

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(32) NOT NULL,
    last_name VARCHAR(32) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    mobile_number VARCHAR(20) NOT NULL,
    date_of_birth DATE,
    date_of_creation DATE NOT NULL,
    role INT NOT NULL
);

CREATE TABLE trustees (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(32) NOT NULL,
    last_name VARCHAR(32) NOT NULL,
    mobile_number VARCHAR(20) NOT NULL,
    address VARCHAR(50)
);

CREATE TABLE teams (
    id SERIAL PRIMARY KEY,
    name VARCHAR(32) NOT NULL,
    description VARCHAR(90),
    educator_id BIGINT UNSIGNED NOT NULL,
    CONSTRAINT FK_EDUCATOR_IN_TEAMS FOREIGN KEY (educator_id) REFERENCES users(id)
);

CREATE TABLE children (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    date_of_birth DATE NOT NULL,
    team_id BIGINT UNSIGNED NOT NULL,
    CONSTRAINT FK_TEAM_IN_CHILDREN FOREIGN KEY (team_id) REFERENCES teams(id)
);

CREATE TABLE attendance (
    id SERIAL PRIMARY KEY,
    date DATE NOT NULL,
    cognitive_development_mark INT,
    social_development_mark INT,
    creative_development_mark INT,
    child_id BIGINT UNSIGNED,
    CONSTRAINT FK_CHILD_IN_ATTENDANCE FOREIGN KEY (child_id) REFERENCES children(id)
);

CREATE TABLE trustee_child_association (
    trustee_id BIGINT UNSIGNED NOT NULL,
    child_id BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY (trustee_id, child_id),
    KEY FK_TRUSTEE (trustee_id),
    KEY FK_CHILD (child_id),
    CONSTRAINT FK_TRUSTEE FOREIGN KEY (trustee_id) REFERENCES trustees(id),
    CONSTRAINT FK_CHILD FOREIGN KEY (child_id) REFERENCES children(id)
);
