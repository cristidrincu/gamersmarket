create table hw_item_mouse(
  mouse_id INTEGER PRIMARY KEY NOT NULL,
  name VARCHAR(50) NOT NULL,
  manufacturer_code VARCHAR(50),
  connection_type VARCHAR (10),
  sensor_technology VARCHAR (50),
  buttons SMALLINT,
  scrolling_buttons SMALLINT,
  has_illumination SMALLINT,
  led_color VARCHAR(50),
  cable_length VARCHAR(10),
  weight VARCHAR(10),
  dpi SMALLINT,
  is_wireless SMALLINT,
  hardware_item_id INTEGER,
  CONSTRAINT fk_hardware_item_mouse FOREIGN KEY (hardware_item_id)
  REFERENCES gamers_market.hardware_item(id),
  UNIQUE(mouse_id)
);