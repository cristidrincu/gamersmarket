ALTER TABLE gamers_market.hw_item_mouse
DROP COLUMN hardware_item_id;

ALTER TABLE gamers_market.hw_item_mouse
ADD COLUMN hardware_type_id INTEGER;

ALTER TABLE gamers_market.hw_item_mouse
ADD CONSTRAINT fk_hardware_type_mouse FOREIGN KEY (hardware_type_id)
REFERENCES gamers_market.hardware_type(id);

