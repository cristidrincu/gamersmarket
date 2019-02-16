CREATE SEQUENCE sq_user START WITH 20;

create table gamers(
  id INTEGER PRIMARY KEY,
  password VARCHAR(255),
  first_name VARCHAR(100),
  last_name VARCHAR(100),
  email VARCHAR(100),
  age SMALLINT,
  role_id INTEGER,
  CONSTRAINT fk_user_role_id FOREIGN KEY (role_id)
  REFERENCES gamers_market.user_role(id),
  unique(id, email)
);