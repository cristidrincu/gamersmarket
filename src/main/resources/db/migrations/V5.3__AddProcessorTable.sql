CREATE TABLE gamers_market.hw_item_processor(
  id INTEGER PRIMARY KEY NOT NULL,
  proc_recommended_for_gaming SMALLINT,
  proc_socket VARCHAR (255),
  proc_series VARCHAR (255),
  proc_core VARCHAR (255),
  proc_nr_of_cores VARCHAR (255),
  proc_nr_of_threads SMALLINT,
  proc_frequency VARCHAR (255),
  proc_turbo_frequency VARCHAR (255),
  proc_smart_cache VARCHAR (255),
  proc_manufacturing_technology VARCHAR (255),
  proc_total_power_dissipated VARCHAR (255),
  proc_has_stock_cooler SMALLINT,
  proc_embedded_graphics_card_model VARCHAR (255),
  proc_embedded_graphics_card_memory VARCHAR (255),
  proc_supported_ram_type VARCHAR (255),
  proc_supported_ram_frequency VARCHAR (255),
  proc_supported_ram_channel VARCHAR (255),
  proc_pci_express_revision VARCHAR (255),
  proc_max_pci_express_lanes VARCHAR (255),
  created_on TIMESTAMPTZ,
  updated_on TIMESTAMPTZ,
  hardware_item_id INTEGER,
  CONSTRAINT fk_hardware_item_processor FOREIGN KEY (hardware_item_id)
  REFERENCES gamers_market.hw_item(id),
  UNIQUE (id)
);