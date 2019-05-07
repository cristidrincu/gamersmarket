ALTER TABLE gamers_market.hardware_type
DROP COLUMN alias;

ALTER TABLE gamers_market.hardware_type
ADD COLUMN hwTypeAlias VARCHAR(255);
