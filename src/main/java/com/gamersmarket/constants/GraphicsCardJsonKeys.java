package com.gamersmarket.constants;

import com.gamersmarket.ServiceStartup;

import javax.ejb.DependsOn;
import javax.ejb.Startup;
import javax.inject.Singleton;
import java.util.Properties;
import java.util.logging.Logger;

@DependsOn("JsonConstantsStartup")
@Singleton
@Startup
public class GraphicsCardJsonKeys {

    private Logger logger = Logger.getLogger(ServiceStartup.class.getName());

    private String graphicsCardInterface = "graphicsCardInterface";
    private String maxResolution = "maxResolution";
    private String graphicsCardModel = "graphicsCardModel";
    private String cooling = "cooling";
    private String recommendedForGaming = "recommendedForGaming";
    private String chipsetProducer = "chipsetProducer";
    private String series = "gcSeries";
    private String nanometers = "nanometers";
    private String processor = "graphicsProcessor";
    private String releaseDate = "gcReleaseDate";
    private String vertexShaderVersion = "vertexShaderVersion";
    private String pixelFillRate = "gcPixelFillRate";
    private String textureFillRate = "gcTextureFillRate";
    private String textureUnits = "gcTextureUnits";
    private String rasterOperators = "gcRasterOperators";
    private String transistorsNumber = "gcTransistorsNumber";
    private String cudaCores = "gcCudaCores";
    private String ocMaximumBandwith = "gcOCMaximumBandwith";
    private String memoryType = "memoryType";
    private String memoryCapacity = "memoryCapacity";
    private String memoryBus = "memoryBus";
    private String memoryFrequency = "memoryFrequency";
    private String memoryBandwidth = "memoryBandwidth";
    private String directXSupport = "gcDirectXSupport";
    private String openGLSupport = "gcOpenGLSupport";
    private String vulkanSupport = "gcVulkanSupport";
    private String gSyncSupport = "gcGSyncSupport";
    private String vrReadySupport = "gcGSyncSupport";
    private String hdmiPorts = "gcHdmiPorts";
    private String displayPorts = "gcDisplayPorts";
    private String hdtvSupport = "hdtvSupport";

    public GraphicsCardJsonKeys() {}

    public String getGraphicsCardInterface() {
        return graphicsCardInterface;
    }

    public String getMaxResolution() {
        return maxResolution;
    }

    public String getGraphicsCardModel() {
        return graphicsCardModel;
    }

    public String getCooling() {
        return cooling;
    }

    public String getRecommendedForGaming() {
        return recommendedForGaming;
    }

    public String getChipsetProducer() {
        return chipsetProducer;
    }

    public String getSeries() {
        return series;
    }

    public String getNanometers() {
        return nanometers;
    }

    public String getProcessor() {
        return processor;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getVertexShaderVersion() {
        return vertexShaderVersion;
    }

    public String getPixelFillRate() {
        return pixelFillRate;
    }

    public String getTextureFillRate() {
        return textureFillRate;
    }

    public String getTextureUnits() {
        return textureUnits;
    }

    public String getRasterOperators() {
        return rasterOperators;
    }

    public String getTransistorsNumber() {
        return transistorsNumber;
    }

    public String getCudaCores() {
        return cudaCores;
    }

    public String getOcMaximumBandwith() {
        return ocMaximumBandwith;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public String getMemoryCapacity() {
        return memoryCapacity;
    }

    public String getMemoryBus() {
        return memoryBus;
    }

    public String getMemoryFrequency() {
        return memoryFrequency;
    }

    public String getMemoryBandwidth() {
        return memoryBandwidth;
    }

    public String getDirectXSupport() {
        return directXSupport;
    }

    public String getOpenGLSupport() {
        return openGLSupport;
    }

    public String getVulkanSupport() {
        return vulkanSupport;
    }

    public String getgSyncSupport() {
        return gSyncSupport;
    }

    public String getVrReadySupport() {
        return vrReadySupport;
    }

    public String getHdmiPorts() {
        return hdmiPorts;
    }

    public String getDisplayPorts() {
        return displayPorts;
    }

    public String getHdtvSupport() {
        return hdtvSupport;
    }

    public void buildGraphicsCardJsonKeys(Properties graphicsCardPropertiesJson) {
        graphicsCardInterface = graphicsCardPropertiesJson.getProperty("GRAPHICS_CARD_INTERFACE");
        maxResolution = graphicsCardPropertiesJson.getProperty("MAX_RESOLUTION");
        graphicsCardModel = graphicsCardPropertiesJson.getProperty("GRAPHICS_CARD_MODEL");
        cooling = graphicsCardPropertiesJson.getProperty("COOLING");
        recommendedForGaming = graphicsCardPropertiesJson.getProperty("RECOMMENDED_FOR_GAMING");
        chipsetProducer = graphicsCardPropertiesJson.getProperty("CHIPSET_PRODUCER");
        series = graphicsCardPropertiesJson.getProperty("SERIES");
        nanometers = graphicsCardPropertiesJson.getProperty("NANOMETERS");
        processor = graphicsCardPropertiesJson.getProperty("PROCESSOR");
        releaseDate = graphicsCardPropertiesJson.getProperty("RELEASE_DATE");
        vertexShaderVersion = graphicsCardPropertiesJson.getProperty("VERTEX_SHADER_VERSION");
        pixelFillRate = graphicsCardPropertiesJson.getProperty("PIXEL_FILL_RATE");
        textureFillRate = graphicsCardPropertiesJson.getProperty("TEXTURE_FILL_RATE");
        textureUnits = graphicsCardPropertiesJson.getProperty("TEXTURE_UNITS");
        rasterOperators = graphicsCardPropertiesJson.getProperty("RASTER_OPERATORS");
        transistorsNumber = graphicsCardPropertiesJson.getProperty("TRANSISTOR_NUMBERS");
        cudaCores = graphicsCardPropertiesJson.getProperty("CUDA_CORES");
        ocMaximumBandwith = graphicsCardPropertiesJson.getProperty("OC_MAXIMUM_BANDWIDTH");
        memoryType = graphicsCardPropertiesJson.getProperty("MEMORY_TYPE");
        memoryCapacity = graphicsCardPropertiesJson.getProperty("MEMORY_CAPACITY");
        memoryBus = graphicsCardPropertiesJson.getProperty("MEMORY_BUS");
        memoryFrequency = graphicsCardPropertiesJson.getProperty("MEMORY_FREQUENCY");
        memoryBandwidth = graphicsCardPropertiesJson.getProperty("MEMORY_BANDWIDTH");
        directXSupport = graphicsCardPropertiesJson.getProperty("DIRECT_X_SUPPORT");
        openGLSupport = graphicsCardPropertiesJson.getProperty("OPEN_GL_SUPPORT");
        vulkanSupport = graphicsCardPropertiesJson.getProperty("VULKAN_SUPPORT");
        gSyncSupport = graphicsCardPropertiesJson.getProperty("G_SYNC_SUPPORT");
        vrReadySupport = graphicsCardPropertiesJson.getProperty("VR_READY_SUPPORT");
        hdmiPorts = graphicsCardPropertiesJson.getProperty("HDMI_PORTS");
        displayPorts = graphicsCardPropertiesJson.getProperty("DISPLAY_PORTS");
        hdtvSupport = graphicsCardPropertiesJson.getProperty("HDTV_SUPPORT");
        logger.info("Built graphics card json keys.");
    }
}
