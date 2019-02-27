package com.gamersmarket.common.constants;

import java.util.List;
import java.util.Properties;

public interface JsonKeys {
    void buildJsonKeys(Properties props);
    List<String > getEntityJsonKeysList();
}
