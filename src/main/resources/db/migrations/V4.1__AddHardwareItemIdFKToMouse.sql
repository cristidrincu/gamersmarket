ALTER TABLE gamers_market.hw_item_mouse
ADD COLUMN hw_item_id INTEGER;

ALTER TABLE gamers_market.hw_item_mouse
ADD CONSTRAINT fk_hardware_item_id FOREIGN KEY(hw_item_id)
REFERENCES gamers_market.hardware_item(id);