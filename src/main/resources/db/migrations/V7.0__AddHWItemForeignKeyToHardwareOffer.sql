ALTER TABLE gamers_market.hardware_offer
ADD CONSTRAINT fk_hardware_offer_hwitem_id FOREIGN KEY(hwitem_id)
REFERENCES gamers_market.hw_item(id);
