CREATE SEQUENCE sq_hardware_manufacturer START WITH 40;

create table hardware_manufacturer(
  id INTEGER PRIMARY KEY,
  name VARCHAR(100)
);