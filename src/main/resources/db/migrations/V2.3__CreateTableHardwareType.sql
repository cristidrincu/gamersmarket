CREATE SEQUENCE sq_hardware_type START WITH 30;

create table hardware_type(
  id INTEGER PRIMARY KEY,
  name VARCHAR(255)
);