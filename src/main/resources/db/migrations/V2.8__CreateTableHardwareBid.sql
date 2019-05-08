CREATE SEQUENCE sq_hardware_bid START WITH 80;

create table hardware_bid(
  id INTEGER PRIMARY KEY,
  amount DECIMAL,
  gamer_id INTEGER,
  CONSTRAINT fk_hardware_bid_gamer_id FOREIGN KEY (gamer_id)
  REFERENCES gamers_market.gamers(id),
  offer_id INTEGER,
  CONSTRAINT fk_hardware_bid_offer_id FOREIGN KEY (offer_id)
  REFERENCES gamers_market.hardware_offer(id),
  created_on TIMESTAMPTZ,
  updated_on TIMESTAMPTZ,
  unique(id)
);