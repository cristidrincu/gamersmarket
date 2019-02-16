create table hw_item_mouse(
  id INTEGER PRIMARY KEY NOT NULL,
  connection_type VARCHAR (10),
  sensor_technology VARCHAR (50),
  buttons SMALLINT,
  colour VARCHAR (20),
  scrolling_buttons SMALLINT,
  has_illumination SMALLINT,
  led_color VARCHAR(50),
  cable_length VARCHAR(10),
  weight VARCHAR(10),
  dpi SMALLINT,
  is_wireless SMALLINT,
  created_on TIMESTAMPTZ,
  updated_on TIMESTAMPTZ,
  hardware_item_id INTEGER,
  CONSTRAINT fk_hardware_item_mouse FOREIGN KEY (hardware_item_id)
  REFERENCES gamers_market.hw_item(id),
  UNIQUE(id)
);