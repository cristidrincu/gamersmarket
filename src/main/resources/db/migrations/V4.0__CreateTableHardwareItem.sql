CREATE TABLE hardware_item(
  id INTEGER PRIMARY KEY,
  manufacturer_code VARCHAR(255),
  created_on TIMESTAMPTZ,
  updated_on TIMESTAMPTZ,
  hardware_type_id INTEGER,
  CONSTRAINT fk_hardware_type_id FOREIGN KEY(hardware_type_id)
  REFERENCES gamers_market.hardware_type(id),
  unique(id)
);