USE jtt_adlister_db;

DROP TABLE IF EXISTS ads_categories;
DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS categories;

CREATE TABLE users (
  id       BIGINT UNSIGNED     NOT NULL AUTO_INCREMENT,
  username VARCHAR(50) UNIQUE  NOT NULL,
  email    VARCHAR(255) UNIQUE NOT NULL,
  password VARCHAR(100)        NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE ads (
  id          BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  user_id     BIGINT UNSIGNED NOT NULL,
  title       VARCHAR(255)    NOT NULL,
  description TEXT            NOT NULL,
  created_at  DATETIME        NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES users (id)
    ON DELETE CASCADE
);

CREATE TABLE categories (
  id   BIGINT UNSIGNED    NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) UNIQUE NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE ads_categories (
  ad_id       BIGINT UNSIGNED NOT NULL,
  category_id BIGINT UNSIGNED NOT NULL,
  FOREIGN KEY (ad_id) REFERENCES ads (id)
    ON DELETE CASCADE,
  FOREIGN KEY (category_id) REFERENCES categories (id)
    ON DELETE CASCADE
);