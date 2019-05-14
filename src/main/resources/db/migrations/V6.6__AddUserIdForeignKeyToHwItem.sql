ALTER TABLE gamers_market.hw_item
ADD COLUMN user_id INTEGER;

ALTER TABLE gamers_market.hw_item
ADD CONSTRAINT fk_hardware_item_user_id FOREIGN KEY(user_id)
REFERENCES gamers_market.gamers(id);
