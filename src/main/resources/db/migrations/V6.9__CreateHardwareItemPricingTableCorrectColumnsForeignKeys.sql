CREATE TABLE gamers_market.hw_item_pricing(
  id INTEGER PRIMARY KEY,  
  hw_item_id INTEGER,
  sell_period_hours SMALLINT,
  min_price DECIMAL,
  recommended_price DECIMAL,  
  has_warranty SMALLINT,
  age SMALLINT,                
  CONSTRAINT fk_pricing_hardware_item FOREIGN KEY (hw_item_id)
  REFERENCES gamers_market.hw_item(id),
  unique(id)
);

