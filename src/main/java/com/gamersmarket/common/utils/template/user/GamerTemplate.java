package com.gamersmarket.common.utils.template.user;

import com.gamersmarket.entity.gamers.Gamer;

import java.io.IOException;

public class GamerTemplate extends UserTemplate<Gamer> {

    @Override
    public Gamer getUserType(String jsonObject) throws IOException {
        return objectMapperProvider.getObjectMapper().readValue(jsonObject, Gamer.class);
    }
}
