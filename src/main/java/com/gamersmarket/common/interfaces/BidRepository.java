/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.common.interfaces;

/**
 *
 * @author cristiandrincu
 */
public interface BidRepository<T> {
    
    T getBid(int bidId);
    T getBid(String bidState);
    void addBid(T bid);    
    void editBid(T bid);
    void editBid(int bidId);
    void deleteBid(int bidId);
    void deleteBid(T bid);
}
