CREATE TABLE hw_item_keyboard(
  id INTEGER NOT NULL,
  keyboard_type VARCHAR (100),
  keyboard_colour VARCHAR (100),
  has_numerical_keys SMALLINT,
  nr_of_keys SMALLINT,
  keyboard_technology VARCHAR (100),
  keyboard_interface VARCHAR (100),
  keyboard_wire_length VARCHAR (100),
  is_mechanical SMALLINT,
  has_palm_rest SMALLINT,
  keyboard_keys_layout VARCHAR (100),
  has_illumination SMALLINT,
  led_colour VARCHAR (100),
  created_on TIMESTAMPTZ,
  updated_on TIMESTAMPTZ,
  hardware_item_id INTEGER,
  CONSTRAINT fk_hardware_item_keyboard FOREIGN KEY (hardware_item_id)
  REFERENCES gamers_market.hw_item(id),
  unique(id)
);