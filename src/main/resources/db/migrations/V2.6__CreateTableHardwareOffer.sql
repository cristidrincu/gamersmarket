CREATE SEQUENCE sq_hardware_offer START WITH 60;

create table hardware_offer(
  id INTEGER PRIMARY KEY,
  approved_by_us SMALLINT,
  buyer_requests_review SMALLINT,
  selling_gamer_id INTEGER,
  CONSTRAINT fk_hardware_offer_selling_gamer_id FOREIGN KEY (selling_gamer_id)
  REFERENCES gamers_market.gamers(id),
  buying_gamer_id INTEGER,
  CONSTRAINT fk_hardware_offer_buying_gamer_id FOREIGN KEY (buying_gamer_id)
  REFERENCES gamers_market.gamers(id),
  approver_gamer_id INTEGER,
  CONSTRAINT fk_hardware_offer_approver_id FOREIGN KEY (approver_gamer_id)
  REFERENCES gamers_market.gamers(id),
  winner_bid_id INTEGER,
  CONSTRAINT fk_hardware_offer_winner_bid_id FOREIGN KEY (winner_bid_id)
  REFERENCES gamers_market.gamers(id),
  hwitem_id INTEGER,
  CONSTRAINT fk_hardware_offer_hw_item FOREIGN KEY (hwitem_id)
  REFERENCES gamers_market.hardware_item(id),
  unique(id, hwitem_id)
);