CREATE SEQUENCE sq_user_role START WITH 10;

create table user_role(
  id INTEGER PRIMARY KEY,
  role VARCHAR(100),
  UNIQUE(id)
);