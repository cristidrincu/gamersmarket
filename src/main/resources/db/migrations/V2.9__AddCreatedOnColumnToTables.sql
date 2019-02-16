ALTER TABLE gamers_market.user_role
ADD COLUMN created_on TIMESTAMPTZ,
ADD COLUMN updated_on TIMESTAMPTZ;

ALTER TABLE gamers_market.hardware_type
ADD COLUMN created_on TIMESTAMPTZ,
ADD COLUMN updated_on TIMESTAMPTZ;

ALTER TABLE gamers_market.hardware_offer
ADD COLUMN created_on TIMESTAMPTZ,
ADD COLUMN updated_on TIMESTAMPTZ;

ALTER TABLE gamers_market.hardware_manufacturer
ADD COLUMN created_on TIMESTAMPTZ,
ADD COLUMN updated_on TIMESTAMPTZ;

ALTER TABLE gamers_market.hardware_item_review
ADD COLUMN created_on TIMESTAMPTZ,
ADD COLUMN updated_on TIMESTAMPTZ;

ALTER TABLE gamers_market.hardware_item
ADD COLUMN created_on TIMESTAMPTZ,
ADD COLUMN updated_on TIMESTAMPTZ;

ALTER TABLE gamers_market.hardware_bid
ADD COLUMN created_on TIMESTAMPTZ,
ADD COLUMN updated_on TIMESTAMPTZ;

ALTER TABLE gamers_market.gamers
ADD COLUMN created_on TIMESTAMPTZ,
ADD COLUMN updated_on TIMESTAMPTZ;