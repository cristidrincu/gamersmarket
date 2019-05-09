package com.gamersmarket.common.enums.jsonkeys;

public enum GraphicsCardJsonKeys {    

    GRAPHICS_CARD_INTERFACE("graphicsCardInterface"),
    MAX_RESOLUTION("maxResolution"),
    GRAPHICS_CARD_MODEL("graphicsCardModel"),
    COOLING("cooling"),
    RECOMMENDED_FOR_GAMING("recommendedForGaming"),
    CHIPSET_PRODUCER("chipsetProducer"),
    SERIES("gcSeries"),
    NANOMETERS("nanometers"),
    PROCESSOR("graphicsProcessor"),
    RELEASE_DATE("gcReleaseDate"),
    PIXEL_SHADER_VERSION("pixelShaderVersion"),
    VERTEX_SHADER_VERSION("vertexShaderVersion"),
    PIXEL_FILL_RATE("gcPixelFillRate"),
    TEXTURE_FILL_RATE("gcTextureFillRate"),
    TEXTURE_UNITS("gcTextureUnits"),
    RASTER_OPERATORS("gcRasterOperators"),
    TRANSISTORS_NUMBER("gcTransistorsNumber"),
    CURA_CORES("gcCudaCores"),
    OC_MAXIMUM_BANDWIDTH("gcOCMaximumBandwith"),
    MEMORY_TYPE("memoryType"),
    MEMORY_CAPACITY("memoryCapacity"),
    MEMORY_BUS("memoryBus"),
    MEMORY_FREQUENCY("memoryFrequency"),
    MEMORY_BANDWIDTH("memoryBandwidth"),
    DIRECT_X_SUPPORT("gcDirectXSupport"),
    OPEN_GL_SUPPORT("gcOpenGLSupport"),
    VULKAN_SUPPORT("gcVulkanSupport"),
    G_SYNC_SUPPORT("gcGSyncSupport"),
    VR_READY_SUPPORT("gcVRReadySupport"),
    HDMI_PORTS("gcHdmiPorts"),
    DISPLAY_PORTS("gcDisplayPorts"),
    HDTV_SUPPORT("gcHdtvSupport");

    private final String jsonKeyDescription;

    private GraphicsCardJsonKeys(String jsonKeyDescription) {
        this.jsonKeyDescription = jsonKeyDescription;
    }

    public String getJsonKeyDescription() {
        return jsonKeyDescription;
    }        
}
