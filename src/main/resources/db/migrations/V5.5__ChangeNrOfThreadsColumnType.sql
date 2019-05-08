ALTER TABLE gamers_market.hw_item_processor
ALTER COLUMN proc_nr_of_cores TYPE SMALLINT USING (proc_nr_of_cores::INTEGER);