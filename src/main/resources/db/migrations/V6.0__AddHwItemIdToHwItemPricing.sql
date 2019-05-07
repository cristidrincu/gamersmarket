alter table gamers_market.hardware_item_pricing
add column hw_item_id INTEGER;

alter table gamers_market.hardware_item_pricing
add constraint fk_hardware_item_pricing_hw_item_id foreign key (hw_item_id)
references gamers_market.hw_item;