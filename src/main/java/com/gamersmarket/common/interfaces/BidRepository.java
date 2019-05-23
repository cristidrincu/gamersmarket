/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.common.interfaces;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;

/**
 *
 * @author cristiandrincu
 */
public interface BidRepository<T> {
    
    T getBid(int bidId);
    List<T> getBids(String bidState);
    void addBid(T bid);    
    T addBid(JsonNode hardwareBidNode, int hardwareOfferId, int bidderId);
    void editBid(T bid);
    void editBid(int bidId, JsonNode updatedBid);
    void deleteBid(int bidId);
    void deleteBid(T bid);
}
