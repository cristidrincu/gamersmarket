alter table gamers_market.translation_mouse
add column connection_type_translation varchar(255),
add column sensor_technology_translation varchar(255),
add column buttons_translation varchar(255),
add column scrolling_buttons_translation varchar(255),
add column colour_translation varchar(255),
add column has_illumination_translation varchar(255),
add column led_color_translation varchar(255),
add column cable_length_translation varchar(255),
add column weight_translation varchar(255),
add column dpi_translation varchar(255),
add column is_wireless_translation varchar(255),
add column mouse_id integer,
add constraint fk_mouse_id foreign key(mouse_id)
references gamers_market.hw_item_mouse(id);
