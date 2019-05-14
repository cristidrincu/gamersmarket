DROP TABLE gamers_market.hardware_manufacturer CASCADE;

ALTER TABLE gamers_market.hw_item
ADD COLUMN manufacturer VARCHAR(255);
