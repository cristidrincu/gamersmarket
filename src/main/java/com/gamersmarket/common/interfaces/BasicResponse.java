package com.gamersmarket.common.interfaces;

/**
 *
 * @author cristiandrincu
 * @param <T>
 * @param <C>
 */
public interface BasicResponse<T, C> {
    
    T buildStatus(int status);
    T buildMessage(String message);
    T buildDefaultResponse(int status);
    T buildDefaultResponse(String message);
    T buildDefaultResponse(int status, String message);    
    T buildEntityDetails(C entity);
}
