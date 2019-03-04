package com.gamersmarket.common.interfaces;

import com.gamersmarket.entity.bid.HardwareBid;

import java.util.List;

public interface GamersRepository<T> {

    T getGamerDetails(int gamerId);
    void createAccount(T user);
    void resetPassword(int gamerId, String newPassword);
    void cancelAccount(int gamerId);
    List<HardwareBid> getActiveHWBidsForGamer(int gamerId);
    List<HardwareBid> getWonHWBidsForGamer(int gamerId);
    List<HardwareBid> getCancelledHWBidsForGamer(int gamerId);
}
