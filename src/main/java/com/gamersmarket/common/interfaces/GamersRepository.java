package com.gamersmarket.common.interfaces;

import com.gamersmarket.entity.bid.HardwareBid;

import java.util.List;

public interface GamersRepository<T> {

    T getGamerDetails(int gamerId);
    T getGamerDetails(String emailAddress);
    void createGamer(T gamer);
    void updateGamer(T gamer);    
    void deleteGamer(int gamerId);
    List<HardwareBid> getActiveHWBidsForGamer(int gamerId);
    List<HardwareBid> getWonHWBidsForGamer(int gamerId);
    List<HardwareBid> getCancelledHWBidsForGamer(int gamerId);
}
