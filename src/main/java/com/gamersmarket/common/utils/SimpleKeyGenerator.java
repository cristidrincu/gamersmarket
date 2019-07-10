package com.gamersmarket.common.utils;

import com.gamersmarket.common.interfaces.KeyGenerator;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class SimpleKeyGenerator implements KeyGenerator {

    @Override
    public Key generateKey() {
        String keyString = "uyv>>operqt897723782367843";
        return new SecretKeySpec(keyString.getBytes(), 0, keyString.getBytes().length, "DES");
    }
}
