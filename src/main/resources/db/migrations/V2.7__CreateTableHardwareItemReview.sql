CREATE SEQUENCE sq_hardware_item_review START WITH 70;

create table hardware_item_review(
  id INTEGER PRIMARY KEY,
  report VARCHAR,
  video_url VARCHAR(100),
  approved_by_us SMALLINT,
  offer_id INTEGER,
  CONSTRAINT fk_hardware_item_review_offer_id FOREIGN KEY (offer_id)
  REFERENCES gamers_market.hardware_offer(id),
  unique(id)
);