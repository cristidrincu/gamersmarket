package com.gamersmarket.common.enums;

public enum ProcessorJsonKeys {   

     RECOMMENDED_FOR_GAMING("recommendedForGaming"),
     SOCKET("procSocket"),
     PROC_SERIES("procSeries"),
     PROC_CORE("procCore"),
     PROC_NR_OF_CORES("procNrOfCores"),
     PROC_NR_OF_THREADS("procNrOfThreads"),
     FREQUENCY("procFrequency"),
     TURBO_FREQUENCY("procTurboFrequency"),
     PROC_SMARTH_CACHE("procSmartCache"),
     PROC_MANUFACTURING_TECHNOLOGY("procManufacturingTechnology"),
     PROC_TOTAL_POWER_DISSIPATED("procTotalPowerDissipated"),
     PROC_HAS_STOCK_COOLER("procHasStockCooler"),
     PROC_EMBEDDED_GRAPHICS_CARD_MODEL("procEmbeddedGraphicsCardModel"),
     PROC_EMBEDDED_GRAPHICS_CARD_FREQUENCY("procEmbeddedGraphicsCardFrequency"),
     PROC_EMBEDDED_GRAPHICS_CARD_MEMORY("procEmbeddedGraphicsCardMemory"),
     PROC_SUPPORTED_RAM_TYPE("procSupportedRamType"),
     PROC_SUPPORTED_RAM_FREQUENCY("procSupportedRamFrequency"),
     PROC_SUPPORTED_RAM_CHANNEL("procSupportedRamChannel"),
     PROC_PCI_EXPRESS_REVISION("procPciExpressRevision"),
     PROC_PCI_EXPRESS_LANES("procMaxPciExpressLanes");

    private final String jsonKeyDescription;
     
    private ProcessorJsonKeys(String jsonKeyDescription) {
        this.jsonKeyDescription = jsonKeyDescription;
    }

    public String getJsonKeyDescription() {
        return jsonKeyDescription;
    }        
}
