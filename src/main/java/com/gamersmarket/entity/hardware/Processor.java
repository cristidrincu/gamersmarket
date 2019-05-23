package com.gamersmarket.entity.hardware;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.gamersmarket.common.enums.jsonkeys.ProcessorJsonKeys;
import com.gamersmarket.common.deserializers.ProcessorDeserializer;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "hw_item_processor")
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("Processor")
@JsonDeserialize(using = ProcessorDeserializer.class)
@NamedQueries({
        @NamedQuery(name = Processor.FIND_ALL_PROCESSORS, query = Processor.FIND_ALL_PROCESSORS_QUERY),
        @NamedQuery(name = Processor.FIND_PROCESSOR_BY_ID, query = Processor.FIND_PROCESSOR_BY_ID_QUERY)
})
public class Processor extends HardwareItem implements Serializable {

    private static final long serialVersionUID = -8016496843122720880L;

    private static final String PARAM_PROCESSOR_ID = "id";

    public static final String FIND_ALL_PROCESSORS = "find_all_processors";
    public static final String FIND_PROCESSOR_BY_ID = "find_processor";

    public static final String FIND_ALL_PROCESSORS_QUERY = "select proc from Processor proc";
    public static final String FIND_PROCESSOR_BY_ID_QUERY = "select proc from Processor proc where proc.id = :" + PARAM_PROCESSOR_ID;   

    @Column(name = "proc_recommended_for_gaming")
    private int recommendedForGaming;

    @Column(name = "proc_socket")
    private String procSocket;

    @Column(name = "proc_series")
    private String procSeries;

    @Column(name = "proc_core")
    private String procCore;

    @Column(name = "proc_nr_of_cores")
    private int procNrOfCores;

    @Column(name = "proc_nr_of_threads")
    private int procNrOfThreads;

    @Column(name = "proc_frequency")
    private String procFrequency;

    @Column(name = "proc_turbo_frequency")
    private String procTurboFrequency;

    @Column(name = "proc_smart_cache")
    private String procSmartCache;

    @Column(name = "proc_manufacturing_technology")
    private String procManufacturingTechnology;

    @Column(name = "proc_total_power_dissipated")
    private String procTotalPowerDissipated;

    @Column(name = "proc_has_stock_cooler")
    private int procHasStockCooler;

    @Column(name = "proc_embedded_graphics_card_model")
    private String procEmbeddedGraphicsCardModel;

    @Column(name = "proc_embedded_graphics_card_frequency")
    private String procEmbeddedGraphicsCardFrequency;

    @Column(name = "proc_embedded_graphics_card_memory")
    private String procEmbeddedGraphicsCardMemory;

    @Column(name = "proc_supported_ram_type")
    private String procSupportedRamType;

    @Column(name = "proc_supported_ram_frequency")
    private String procSupportedRamFrequency;

    @Column(name = "proc_supported_ram_channel")
    private String procSupportedRamChannel;

    @Column(name = "proc_pci_express_revision")
    private String procPciExpressRevision;

    @Column(name = "proc_max_pci_express_lanes")
    private String procMaxPciExpressLanes;   

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hardware_item_id")
    private HardwareItem hardwareItem;

    public Processor() {
        super();
    }

    public Processor(Processor processor, String manufacturer, String name, String manufacturerCode) { 
        super(manufacturer, name, manufacturerCode);
        this.recommendedForGaming = processor.getRecommendedForGaming();
        this.procSocket = processor.getProcSocket();
        this.procSeries = processor.getProcSeries();
        this.procCore = processor.getProcCore();
        this.procNrOfCores = processor.getProcNrOfCores();
        this.procNrOfThreads = processor.getProcNrOfThreads();
        this.procFrequency = processor.getProcFrequency();
        this.procTurboFrequency = processor.getProcTurboFrequency();
        this.procSmartCache = processor.getProcSmartCache();
        this.procManufacturingTechnology = processor.getProcManufacturingTechnology();
        this.procTotalPowerDissipated = processor.getProcTotalPowerDissipated();
        this.procHasStockCooler = processor.getProcHasStockCooler();
        this.procEmbeddedGraphicsCardModel = processor.getProcEmbeddedGraphicsCardModel();
        this.procEmbeddedGraphicsCardFrequency = processor.getProcEmbeddedGraphicsCardFrequency();
        this.procSupportedRamType = processor.getProcSupportedRamType();
        this.procSupportedRamFrequency = processor.getProcSupportedRamFrequency();
        this.procSupportedRamChannel = processor.getProcSupportedRamChannel();
        this.procPciExpressRevision = processor.getProcPciExpressRevision();
        this.procMaxPciExpressLanes = processor.getProcMaxPciExpressLanes();        
    }

    public Processor(JsonNode processorJsonNode) {
        super(processorJsonNode.get("manufacturer").asText(), processorJsonNode.get("name").asText());
        this.recommendedForGaming = processorJsonNode.get(ProcessorJsonKeys.RECOMMENDED_FOR_GAMING.getJsonKeyDescription()).asInt();
        this.procSocket = processorJsonNode.get(ProcessorJsonKeys.SOCKET.getJsonKeyDescription()).asText();
        this.procSeries = processorJsonNode.get(ProcessorJsonKeys.PROC_SERIES.getJsonKeyDescription()).asText();
        this.procCore = processorJsonNode.get(ProcessorJsonKeys.PROC_CORE.getJsonKeyDescription()).asText();
        this.procNrOfCores = processorJsonNode.get(ProcessorJsonKeys.PROC_NR_OF_CORES.getJsonKeyDescription()).asInt();
        this.procNrOfThreads = processorJsonNode.get(ProcessorJsonKeys.PROC_NR_OF_THREADS.getJsonKeyDescription()).asInt();
        this.procFrequency = processorJsonNode.get(ProcessorJsonKeys.FREQUENCY.getJsonKeyDescription()).asText();
        this.procTurboFrequency = processorJsonNode.get(ProcessorJsonKeys.TURBO_FREQUENCY.getJsonKeyDescription()).asText();
        this.procSmartCache = processorJsonNode.get(ProcessorJsonKeys.PROC_SMARTH_CACHE.getJsonKeyDescription()).asText();
        this.procManufacturingTechnology = processorJsonNode.get(ProcessorJsonKeys.PROC_MANUFACTURING_TECHNOLOGY.getJsonKeyDescription()).asText();
        this.procTotalPowerDissipated = processorJsonNode.get(ProcessorJsonKeys.PROC_TOTAL_POWER_DISSIPATED.getJsonKeyDescription()).asText();
        this.procHasStockCooler = processorJsonNode.get(ProcessorJsonKeys.PROC_HAS_STOCK_COOLER.getJsonKeyDescription()).asInt();
        this.procEmbeddedGraphicsCardModel = processorJsonNode.get(ProcessorJsonKeys.PROC_EMBEDDED_GRAPHICS_CARD_MODEL.getJsonKeyDescription()).asText();
        this.procEmbeddedGraphicsCardFrequency = processorJsonNode.get(ProcessorJsonKeys.PROC_EMBEDDED_GRAPHICS_CARD_FREQUENCY.getJsonKeyDescription()).asText();
        this.procSupportedRamType = processorJsonNode.get(ProcessorJsonKeys.PROC_SUPPORTED_RAM_TYPE.getJsonKeyDescription()).asText();
        this.procSupportedRamFrequency = processorJsonNode.get(ProcessorJsonKeys.PROC_SUPPORTED_RAM_FREQUENCY.getJsonKeyDescription()).asText();
        this.procSupportedRamChannel = processorJsonNode.get(ProcessorJsonKeys.PROC_SUPPORTED_RAM_CHANNEL.getJsonKeyDescription()).asText();
        this.procPciExpressRevision = processorJsonNode.get(ProcessorJsonKeys.PROC_PCI_EXPRESS_REVISION.getJsonKeyDescription()).asText();
        this.procMaxPciExpressLanes = processorJsonNode.get(ProcessorJsonKeys.PROC_PCI_EXPRESS_LANES.getJsonKeyDescription()).asText();        
    }   

    public int getRecommendedForGaming() {
        return recommendedForGaming;
    }

    public void setRecommendedForGaming(int recommendedForGaming) {
        this.recommendedForGaming = recommendedForGaming;
    }

    public String getProcSocket() {
        return procSocket;
    }

    public void setProcSocket(String procSocket) {
        this.procSocket = procSocket;
    }

    public String getProcSeries() {
        return procSeries;
    }

    public void setProcSeries(String procSeries) {
        this.procSeries = procSeries;
    }

    public String getProcCore() {
        return procCore;
    }

    public void setProcCore(String procCore) {
        this.procCore = procCore;
    }

    public int getProcNrOfCores() {
        return procNrOfCores;
    }

    public void setProcNrOfCores(int procNrOfCores) {
        this.procNrOfCores = procNrOfCores;
    }

    public int getProcNrOfThreads() {
        return procNrOfThreads;
    }

    public void setProcNrOfThreads(int procNrOfThreads) {
        this.procNrOfThreads = procNrOfThreads;
    }

    public String getProcFrequency() {
        return procFrequency;
    }

    public void setProcFrequency(String procFrequency) {
        this.procFrequency = procFrequency;
    }

    public String getProcTurboFrequency() {
        return procTurboFrequency;
    }

    public void setProcTurboFrequency(String procTurboFrequency) {
        this.procTurboFrequency = procTurboFrequency;
    }

    public String getProcSmartCache() {
        return procSmartCache;
    }

    public void setProcSmartCache(String procSmartCache) {
        this.procSmartCache = procSmartCache;
    }

    public String getProcManufacturingTechnology() {
        return procManufacturingTechnology;
    }

    public void setProcManufacturingTechnology(String procManufacturingTechnology) {
        this.procManufacturingTechnology = procManufacturingTechnology;
    }

    public String getProcTotalPowerDissipated() {
        return procTotalPowerDissipated;
    }

    public void setProcTotalPowerDissipated(String procTotalPowerDissipated) {
        this.procTotalPowerDissipated = procTotalPowerDissipated;
    }

    public int getProcHasStockCooler() {
        return procHasStockCooler;
    }

    public void setProcHasStockCooler(int procHasStockCooler) {
        this.procHasStockCooler = procHasStockCooler;
    }

    public String getProcEmbeddedGraphicsCardModel() {
        return procEmbeddedGraphicsCardModel;
    }

    public void setProcEmbeddedGraphicsCardModel(String procEmbeddedGraphicsCardModel) {
        this.procEmbeddedGraphicsCardModel = procEmbeddedGraphicsCardModel;
    }

    public String getProcEmbeddedGraphicsCardFrequency() {
        return procEmbeddedGraphicsCardFrequency;
    }

    public void setProcEmbeddedGraphicsCardFrequency(String procEmbeddedGraphicsCardFrequency) {
        this.procEmbeddedGraphicsCardFrequency = procEmbeddedGraphicsCardFrequency;
    }

    public String getProcEmbeddedGraphicsCardMemory() {
        return procEmbeddedGraphicsCardMemory;
    }

    public void setProcEmbeddedGraphicsCardMemory(String procEmbeddedGraphicsCardMemory) {
        this.procEmbeddedGraphicsCardMemory = procEmbeddedGraphicsCardMemory;
    }

    public String getProcSupportedRamType() {
        return procSupportedRamType;
    }

    public void setProcSupportedRamType(String procSupportedRamType) {
        this.procSupportedRamType = procSupportedRamType;
    }

    public String getProcSupportedRamFrequency() {
        return procSupportedRamFrequency;
    }

    public void setProcSupportedRamFrequency(String procSupportedRamFrequency) {
        this.procSupportedRamFrequency = procSupportedRamFrequency;
    }

    public String getProcSupportedRamChannel() {
        return procSupportedRamChannel;
    }

    public void setProcSupportedRamChannel(String procSupportedRamChannel) {
        this.procSupportedRamChannel = procSupportedRamChannel;
    }

    public String getProcPciExpressRevision() {
        return procPciExpressRevision;
    }

    public void setProcPciExpressRevision(String procPciExpressRevision) {
        this.procPciExpressRevision = procPciExpressRevision;
    }

    public String getProcMaxPciExpressLanes() {
        return procMaxPciExpressLanes;
    }

    public void setProcMaxPciExpressLanes(String procMaxPciExpressLanes) {
        this.procMaxPciExpressLanes = procMaxPciExpressLanes;
    }    

    public HardwareItem getHardwareItem() {
        return hardwareItem;
    }

    public void setHardwareItem(HardwareItem hardwareItem) {
        this.hardwareItem = hardwareItem;
    }   

    @Override
    public String toString() {
        return "Processor{" +                
                ", recommendedForGaming=" + recommendedForGaming +
                ", procSocket='" + procSocket + '\'' +
                ", procSeries='" + procSeries + '\'' +
                ", procCore='" + procCore + '\'' +
                ", procNrOfCores=" + procNrOfCores +
                ", procNrOfThreads=" + procNrOfThreads +
                ", procFrequency='" + procFrequency + '\'' +
                ", procTurboFrequency='" + procTurboFrequency + '\'' +
                ", procSmartCache='" + procSmartCache + '\'' +
                ", procManufacturingTechnology='" + procManufacturingTechnology + '\'' +
                ", procTotalPowerDissipated='" + procTotalPowerDissipated + '\'' +
                ", procHasStockCooler=" + procHasStockCooler +
                ", procEmbeddedGraphicsCardModel='" + procEmbeddedGraphicsCardModel + '\'' +
                ", procEmbeddedGraphicsCardFrequency='" + procEmbeddedGraphicsCardFrequency + '\'' +
                ", procEmbeddedGraphicsCardMemory='" + procEmbeddedGraphicsCardMemory + '\'' +
                ", procSupportedRamType='" + procSupportedRamType + '\'' +
                ", procSupportedRamFrequency='" + procSupportedRamFrequency + '\'' +
                ", procSupportedRamChannel='" + procSupportedRamChannel + '\'' +
                ", procPciExpressRevision='" + procPciExpressRevision + '\'' +
                ", procMaxPciExpressLanes='" + procMaxPciExpressLanes + '\'' +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                ", hardwareItem=" + hardwareItem +
                '}';
    }
}
