package com.gamersmarket.entity.hardware;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.constants.ProcessorJsonKeys;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "hw_item_processor")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Processor implements Serializable {

    private static final long serialVersionUID = -8016496843122720880L;

    @Id
    @NotNull
    @GeneratedValue(generator = "sq_hardware_item")
    @SequenceGenerator(name = "sq_hardware_item_graphics_card", sequenceName = "sq_hardware_item")
    private int id;

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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private Date createdOn = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_on")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private Date updatedOn;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hardware_item_id")
    private HardwareItem hardwareItem;

    public Processor() {}

    public Processor(Processor processor) {
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
        this.updatedOn = new Date();
    }

    public Processor(JsonNode processorJsonNode) {
        this.recommendedForGaming = processorJsonNode.get(ProcessorJsonKeys.getRecommendedForGaming()).asInt();
        this.procSocket = processorJsonNode.get(ProcessorJsonKeys.getSocket()).asText();
        this.procSeries = processorJsonNode.get(ProcessorJsonKeys.getProcSeries()).asText();
        this.procCore = processorJsonNode.get(ProcessorJsonKeys.getProcCore()).asText();
        this.procNrOfCores = processorJsonNode.get(ProcessorJsonKeys.getProcNrOfCores()).asInt();
        this.procNrOfThreads = processorJsonNode.get(ProcessorJsonKeys.getProcNrOfThreads()).asInt();
        this.procFrequency = processorJsonNode.get(ProcessorJsonKeys.getFrequency()).asText();
        this.procTurboFrequency = processorJsonNode.get(ProcessorJsonKeys.getTurboFrequency()).asText();
        this.procSmartCache = processorJsonNode.get(ProcessorJsonKeys.getProcSmarthCache()).asText();
        this.procManufacturingTechnology = processorJsonNode.get(ProcessorJsonKeys.getProcManufacturingTechnology()).asText();
        this.procTotalPowerDissipated = processorJsonNode.get(ProcessorJsonKeys.getProcTotalPowerDissipated()).asText();
        this.procHasStockCooler = processorJsonNode.get(ProcessorJsonKeys.getProcHasStockCooler()).asInt();
        this.procEmbeddedGraphicsCardModel = processorJsonNode.get(ProcessorJsonKeys.getProcEmbeddedGraphicsCardModel()).asText();
        this.procEmbeddedGraphicsCardFrequency = processorJsonNode.get(ProcessorJsonKeys.getProcEmbeddedGraphicsCardFrequency()).asText();
        this.procSupportedRamType = processorJsonNode.get(ProcessorJsonKeys.getProcSupportedRamType()).asText();
        this.procSupportedRamFrequency = processorJsonNode.get(ProcessorJsonKeys.getProcSupportedRamFrequency()).asText();
        this.procSupportedRamChannel = processorJsonNode.get(ProcessorJsonKeys.getProcSupportedRamChannel()).asText();
        this.procPciExpressRevision = processorJsonNode.get(ProcessorJsonKeys.getProcPciExpressRevision()).asText();
        this.procMaxPciExpressLanes = processorJsonNode.get(ProcessorJsonKeys.getProcPciExpressLanes()).asText();
        this.updatedOn = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public HardwareItem getHardwareItem() {
        return hardwareItem;
    }

    public void setHardwareItem(HardwareItem hardwareItem) {
        this.hardwareItem = hardwareItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Processor processor = (Processor) o;
        return id == processor.id &&
                createdOn.equals(processor.createdOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdOn);
    }

    @Override
    public String toString() {
        return "Processor{" +
                "id=" + id +
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
