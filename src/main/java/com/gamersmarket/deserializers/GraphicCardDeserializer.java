package com.gamersmarket.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.constants.GraphicsCardJsonKeys;
import com.gamersmarket.entity.hardware.GraphicsCard;

import javax.inject.Inject;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GraphicCardDeserializer extends JsonDeserializer<GraphicsCard> {

    @Inject
    GraphicsCardJsonKeys graphicsCardJsonKeys;

    @Override
    public GraphicsCard deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        Logger logger = Logger.getLogger(GraphicCardDeserializer.class.getName());
        ObjectCodec codec = jsonParser.getCodec();
        JsonNode node = codec.readTree(jsonParser);
        JsonNode graphicCardNode = node.get("graphicCard");
        GraphicsCard graphicsCard = new GraphicsCard();

        try {
            graphicsCard = new GraphicsCard(graphicCardNode, graphicsCardJsonKeys);
        } catch (ParseException e) {
            logger.log(Level.SEVERE, "Exception occurred in date deserialization");
            logger.log(Level.INFO, e.getMessage());
        }

        return graphicsCard;
    }
}
