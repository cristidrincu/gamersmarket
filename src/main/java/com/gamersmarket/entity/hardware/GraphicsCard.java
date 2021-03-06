package com.gamersmarket.entity.hardware;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.gamersmarket.common.enums.jsonkeys.GraphicsCardJsonKeys;
import com.gamersmarket.common.deserializers.GraphicCardDeserializer;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "hw_item_graphics_card")
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("GraphicsCard")
@JsonDeserialize(using = GraphicCardDeserializer.class)
@NamedQueries({
        @NamedQuery(name = GraphicsCard.GET_ITEM, query = "select gc from GraphicsCard gc where gc.id = :id"),
        @NamedQuery(name = GraphicsCard.GET_ITEMS, query = "select gc from GraphicsCard gc")
})
public class GraphicsCard extends HardwareItem implements Serializable {

    private static final long serialVersionUID = -5008414667559835805L;
    public static final String GET_ITEM = "GraphicsCard.getItem";
    public static final String GET_ITEMS = "GraphicsCard.getItems";   

    @Column(name = "gc_interface")
    @Size(min = 10, max = 40, message = "The graphics card interface name must be between 10 and 40 characters long.")
    private String graphicsCardInterface;

    @Column(name = "gc_max_resolution")
    @Size(min = 10, max = 40, message = "The graphics card max resolution must be between 10 and 40 characters long.")
    private String maxResolution;

    @Column(name = "gc_model")
    private String graphicsCardModel;

    @Column(name = "gc_cooling")
    private String cooling;

    @Column(name = "gc_recommended_for_gaming")
    private int recommendedForGaming;

    @Column(name = "gc_chipset_producer")
    private String chipsetProducer;

    @Column(name = "gc_series")
    private String gcSeries;

    @Column(name = "gc_nanometers")
    private String nanometers;

    @Column(name = "gc_graphics_processor")
    private String graphicsProcessor;

    @Column(name = "gc_release_date")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    private Date gcReleaseDate;

    @Column(name = "gc_pixel_shader_version")
    private String pixelShaderVersion;

    @Column(name ="gc_vertex_shader_version")
    private String vertexShaderVersion;

    @Column(name = "gc_pixel_fill_rate")
    private String gcPixelFillRate;

    @Column(name = "gc_texture_fill_rate")
    private String gcTextureFillRate;

    @Column(name = "gc_texture_units")
    private int gcTextureUnits;

    @Column(name = "gc_raster_operators")
    private int gcRasterOperators;

    @Column(name = "gc_transistors_number")
    private int gcTransistorsNumber;

    @Column(name = "gc_cuda_cores")
    private int gcCudaCores;

    @Column(name = "gc_oc_maximum_bandwith")
    private String gcOCMaximumBandwith;

    @Column(name = "memory_type")
    private String memoryType;

    @Column(name = "memory_capacity")
    private String memoryCapacity;

    @Column(name = "memory_bus")
    private String memoryBus;

    @Column(name = "memory_frequency")
    private String memoryFrequency;

    @Column(name = "memory_bandwidth")
    private String memoryBandwidth;

    @Column(name = "gc_directx_support")
    private String gcDirectXSupport;

    @Column(name = "gc_opengl_support")
    private String gcOpenGLSupport;

    @Column(name = "gc_vulkan_support")
    private boolean gcVulkanSupport;

    @Column(name = "gc_gsync_support")
    private boolean gcGSyncSupport;

    @Column(name = "gc_vr_ready_support")
    private boolean gcVRReadySupport;

    @Column(name = "gc_hdmi_ports")
    private int gcHdmiPorts;

    @Column(name = "gc_display_ports")
    private int gcDisplayPorts;

    @Column(name = "gc_hdtv_support")
    private boolean gcHdtvSupport;   

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hardware_item_id")
    private HardwareItem hardwareItem;

    public GraphicsCard() {
        super();
    }   
    
    public GraphicsCard(GraphicsCard graphicsCard, String manufacturer, String name, String manufacturerCode) {  
        super(manufacturer, name, manufacturerCode);
        this.graphicsCardInterface = graphicsCard.getGraphicsCardInterface();
        this.maxResolution = graphicsCard.getMaxResolution();
        this.graphicsCardModel = graphicsCard.getGraphicsCardModel();
        this.cooling = graphicsCard.getCooling();
        this.recommendedForGaming = graphicsCard.getRecommendedForGaming();
        this.chipsetProducer = graphicsCard.getChipsetProducer();
        this.gcSeries = graphicsCard.getGcSeries();
        this.nanometers = graphicsCard.getNanometers();
        this.graphicsProcessor = graphicsCard.getGraphicsProcessor();
        this.gcReleaseDate = graphicsCard.getGcReleaseDate();
        this.pixelShaderVersion = graphicsCard.getPixelShaderVersion();
        this.vertexShaderVersion = graphicsCard.getVertexShaderVersion();
        this.gcPixelFillRate = graphicsCard.getGcPixelFillRate();
        this.gcTextureFillRate = graphicsCard.getGcTextureFillRate();
        this.gcTextureUnits = graphicsCard.getGcTextureUnits();
        this.gcRasterOperators = graphicsCard.getGcRasterOperators();
        this.gcTransistorsNumber = graphicsCard.getGcTransistorsNumber();
        this.gcCudaCores = graphicsCard.getGcCudaCores();
        this.gcOCMaximumBandwith = graphicsCard.getGcOCMaximumBandwith();
        this.memoryType = graphicsCard.getMemoryType();
        this.memoryCapacity = graphicsCard.getMemoryCapacity();
        this.memoryBus = graphicsCard.getMemoryBus();
        this.memoryFrequency = graphicsCard.getMemoryFrequency();
        this.memoryBandwidth = graphicsCard.getMemoryBandwidth();
        this.gcDirectXSupport = graphicsCard.getGcDirectXSupport();
        this.gcOpenGLSupport = graphicsCard.getGcOpenGLSupport();
        this.gcVulkanSupport = graphicsCard.isGcVulkanSupport();
        this.gcGSyncSupport = graphicsCard.isGcGSyncSupport();
        this.gcVRReadySupport = graphicsCard.isGcVRReadySupport();
        this.gcHdmiPorts = graphicsCard.getGcHdmiPorts();
        this.gcDisplayPorts = graphicsCard.getGcDisplayPorts();
        this.gcHdtvSupport = graphicsCard.isGcHdtvSupport();
        this.updatedOn = new Date();
    }

    public GraphicsCard(JsonNode graphicsCardNode) {
        super(graphicsCardNode.get("manufacturer").asText(), graphicsCardNode.get("name").asText());
        this.graphicsCardInterface = graphicsCardNode.get(GraphicsCardJsonKeys.GRAPHICS_CARD_INTERFACE.getJsonKeyDescription()).asText();
        this.maxResolution = graphicsCardNode.get(GraphicsCardJsonKeys.MAX_RESOLUTION.getJsonKeyDescription()).asText();
        this.graphicsCardModel = graphicsCardNode.get(GraphicsCardJsonKeys.GRAPHICS_CARD_MODEL.getJsonKeyDescription()).asText();        
        this.recommendedForGaming = graphicsCardNode.get(GraphicsCardJsonKeys.RECOMMENDED_FOR_GAMING.getJsonKeyDescription()).asInt();
        this.chipsetProducer = graphicsCardNode.get(GraphicsCardJsonKeys.CHIPSET_PRODUCER.getJsonKeyDescription()).asText();        
        this.updatedOn = new Date();
    }    

    public String getGraphicsCardInterface() {
        return graphicsCardInterface;
    }

    public void setGraphicsCardInterface(String graphicsCardInterface) {
        this.graphicsCardInterface = graphicsCardInterface;
    }

    public String getMaxResolution() {
        return maxResolution;
    }

    public void setMaxResolution(String maxResolution) {
        this.maxResolution = maxResolution;
    }

    public String getGraphicsCardModel() {
        return graphicsCardModel;
    }

    public void setGraphicsCardModel(String graphicsCardModel) {
        this.graphicsCardModel = graphicsCardModel;
    }

    public String getCooling() {
        return cooling;
    }

    public void setCooling(String cooling) {
        this.cooling = cooling;
    }

    public int getRecommendedForGaming() {
        return recommendedForGaming;
    }

    public void setRecommendedForGaming(int recommendedForGaming) {
        this.recommendedForGaming = recommendedForGaming;
    }

    public String getChipsetProducer() {
        return chipsetProducer;
    }

    public void setChipsetProducer(String chipsetProducer) {
        this.chipsetProducer = chipsetProducer;
    }

    public String getGcSeries() {
        return gcSeries;
    }

    public void setGcSeries(String gcSeries) {
        this.gcSeries = gcSeries;
    }

    public String getNanometers() {
        return nanometers;
    }

    public void setNanometers(String nanometers) {
        this.nanometers = nanometers;
    }

    public String getGraphicsProcessor() {
        return graphicsProcessor;
    }

    public void setGraphicsProcessor(String graphicsProcessor) {
        this.graphicsProcessor = graphicsProcessor;
    }

    public Date getGcReleaseDate() {
        return gcReleaseDate;
    }

    public void setGcReleaseDate(Date gcReleaseDate) {
        this.gcReleaseDate = gcReleaseDate;
    }

    public String getPixelShaderVersion() {
        return pixelShaderVersion;
    }

    public void setPixelShaderVersion(String pixelShaderVersion) {
        this.pixelShaderVersion = pixelShaderVersion;
    }

    public String getVertexShaderVersion() {
        return vertexShaderVersion;
    }

    public void setVertexShaderVersion(String vertexShaderVersion) {
        this.vertexShaderVersion = vertexShaderVersion;
    }

    public String getGcPixelFillRate() {
        return gcPixelFillRate;
    }

    public void setGcPixelFillRate(String gcPixelFillRate) {
        this.gcPixelFillRate = gcPixelFillRate;
    }

    public String getGcTextureFillRate() {
        return gcTextureFillRate;
    }

    public void setGcTextureFillRate(String gcTextureFillRate) {
        this.gcTextureFillRate = gcTextureFillRate;
    }

    public int getGcTextureUnits() {
        return gcTextureUnits;
    }

    public void setGcTextureUnits(int gcTextureUnits) {
        this.gcTextureUnits = gcTextureUnits;
    }

    public int getGcRasterOperators() {
        return gcRasterOperators;
    }

    public void setGcRasterOperators(int gcRasterOperators) {
        this.gcRasterOperators = gcRasterOperators;
    }

    public int getGcTransistorsNumber() {
        return gcTransistorsNumber;
    }

    public void setGcTransistorsNumber(int gcTransistorsNumber) {
        this.gcTransistorsNumber = gcTransistorsNumber;
    }

    public int getGcCudaCores() {
        return gcCudaCores;
    }

    public void setGcCudaCores(int gcCudaCores) {
        this.gcCudaCores = gcCudaCores;
    }

    public String getGcOCMaximumBandwith() {
        return gcOCMaximumBandwith;
    }

    public void setGcOCMaximumBandwith(String gcOCMaximumBandwith) {
        this.gcOCMaximumBandwith = gcOCMaximumBandwith;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

    public String getMemoryCapacity() {
        return memoryCapacity;
    }

    public void setMemoryCapacity(String memoryCapacity) {
        this.memoryCapacity = memoryCapacity;
    }

    public String getMemoryBus() {
        return memoryBus;
    }

    public void setMemoryBus(String memoryBus) {
        this.memoryBus = memoryBus;
    }

    public String getMemoryFrequency() {
        return memoryFrequency;
    }

    public void setMemoryFrequency(String memoryFrequency) {
        this.memoryFrequency = memoryFrequency;
    }

    public String getMemoryBandwidth() {
        return memoryBandwidth;
    }

    public void setMemoryBandwidth(String memoryBandwidth) {
        this.memoryBandwidth = memoryBandwidth;
    }

    public String getGcDirectXSupport() {
        return gcDirectXSupport;
    }

    public void setGcDirectXSupport(String gcDirectXSupport) {
        this.gcDirectXSupport = gcDirectXSupport;
    }

    public String getGcOpenGLSupport() {
        return gcOpenGLSupport;
    }

    public void setGcOpenGLSupport(String gcOpenGLSupport) {
        this.gcOpenGLSupport = gcOpenGLSupport;
    }

    public boolean isGcVulkanSupport() {
        return gcVulkanSupport;
    }

    public void setGcVulkanSupport(boolean gcVulkanSupport) {
        this.gcVulkanSupport = gcVulkanSupport;
    }

    public boolean isGcGSyncSupport() {
        return gcGSyncSupport;
    }

    public void setGcGSyncSupport(boolean gcGSyncSupport) {
        this.gcGSyncSupport = gcGSyncSupport;
    }

    public boolean isGcVRReadySupport() {
        return gcVRReadySupport;
    }

    public void setGcVRReadySupport(boolean gcVRReadySupport) {
        this.gcVRReadySupport = gcVRReadySupport;
    }

    public int getGcHdmiPorts() {
        return gcHdmiPorts;
    }

    public void setGcHdmiPorts(int gcHdmiPorts) {
        this.gcHdmiPorts = gcHdmiPorts;
    }

    public int getGcDisplayPorts() {
        return gcDisplayPorts;
    }

    public void setGcDisplayPorts(int gcDisplayPorts) {
        this.gcDisplayPorts = gcDisplayPorts;
    }

    public boolean isGcHdtvSupport() {
        return gcHdtvSupport;
    }

    public void setGcHdtvSupport(boolean gcHdtvSupport) {
        this.gcHdtvSupport = gcHdtvSupport;
    }    

    public HardwareItem getHardwareItem() {
        return hardwareItem;
    }

    public void setHardwareItem(HardwareItem hardwareItem) {
        this.hardwareItem = hardwareItem;
    }    

    @Override
    public String toString() {
        return "GraphicsCard{" +                
                ", graphicsCardInterface='" + graphicsCardInterface + '\'' +
                ", maxResolution='" + maxResolution + '\'' +
                ", graphicsCardModel='" + graphicsCardModel + '\'' +
                ", cooling='" + cooling + '\'' +
                ", recommendedForGaming=" + recommendedForGaming +
                ", chipsetProducer='" + chipsetProducer + '\'' +
                ", gcSeries='" + gcSeries + '\'' +
                ", nanometers='" + nanometers + '\'' +
                ", graphicsProcessor='" + graphicsProcessor + '\'' +
                ", gcReleaseDate=" + gcReleaseDate +
                ", pixelShaderVersion='" + pixelShaderVersion + '\'' +
                ", vertexShaderVersion='" + vertexShaderVersion + '\'' +
                ", gcPixelFillRate='" + gcPixelFillRate + '\'' +
                ", gcTextureFillRate='" + gcTextureFillRate + '\'' +
                ", gcTextureUnits=" + gcTextureUnits +
                ", gcRasterOperators=" + gcRasterOperators +
                ", gcTransistorsNumber=" + gcTransistorsNumber +
                ", gcCudaCores=" + gcCudaCores +
                ", gcOCMaximumBandwith='" + gcOCMaximumBandwith + '\'' +
                ", memoryType='" + memoryType + '\'' +
                ", memoryCapacity='" + memoryCapacity + '\'' +
                ", memoryBus='" + memoryBus + '\'' +
                ", memoryFrequency='" + memoryFrequency + '\'' +
                ", memoryBandwidth='" + memoryBandwidth + '\'' +
                ", gcDirectXSupport='" + gcDirectXSupport + '\'' +
                ", gcOpenGLSupport='" + gcOpenGLSupport + '\'' +
                ", gcVulkanSupport=" + gcVulkanSupport +
                ", gcGSyncSupport=" + gcGSyncSupport +
                ", gcVRReadySupport=" + gcVRReadySupport +
                ", gcHdmiPorts=" + gcHdmiPorts +
                ", gcDisplayPorts=" + gcDisplayPorts +
                ", gcHdtvSupport=" + gcHdtvSupport +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                ", hardwareItem=" + hardwareItem +
                '}';
    }
}
