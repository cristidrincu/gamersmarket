CREATE SEQUENCE sq_hardware_item START WITH 50;

create table hardware_item(
  id INTEGER PRIMARY KEY,
  name VARCHAR(255),
  sell_period_hours SMALLINT,
  min_price DECIMAL,
  recommended_price DECIMAL,
  serial_number VARCHAR(255),
  has_warranty SMALLINT,
  age SMALLINT,
  manufacturer_id INTEGER,
  CONSTRAINT fk_hardware_item_manufacturer_id FOREIGN KEY (manufacturer_id)
  REFERENCES gamers_market.hardware_manufacturer(id),
  hw_type_id INTEGER,
  CONSTRAINT fk_hardware_item_hardware_type_id FOREIGN KEY (hw_type_id)
  REFERENCES gamers_market.hardware_type(id),
  gamer_id INTEGER,
  CONSTRAINT fk_hardware_item_user_id FOREIGN KEY (gamer_id)
  REFERENCES gamers_market.gamers(id),
  unique(id, serial_number)
);