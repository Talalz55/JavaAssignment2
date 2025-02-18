DROP TABLE IF EXISTS PASSWORD_RECORD;
CREATE TABLE PASSWORD_RECORD (
                                 id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                 title VARCHAR(255) NOT NULL,
                                 username VARCHAR(255) NOT NULL,
                                 password VARCHAR(255) NOT NULL,
                                 url VARCHAR(255),
                                 email VARCHAR(255),
                                 notes VARCHAR(255)
);
