package com.gamersmarket.constants;

import java.util.List;
import java.util.Properties;

public interface JsonKeys {
    void buildJsonKeys(Properties props);
    List<String > getEntityJsonKeysList();
}
