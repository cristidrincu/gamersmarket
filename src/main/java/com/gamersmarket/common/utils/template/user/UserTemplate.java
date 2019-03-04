package com.gamersmarket.common.utils.template.user;

import com.gamersmarket.common.providers.ObjectMapperProvider;

import javax.inject.Inject;
import java.io.IOException;

public abstract class UserTemplate<T> {

    @Inject
    ObjectMapperProvider objectMapperProvider;

    public abstract T getUserType(String jsonObject) throws IOException;
}
