package com.gamersmarket.common.enums.hwbidstates;

public enum HardwareBidStates {
    ACTIVE("active"),
    CANCELLED("cancelled"),
    COMPLETED("completed");

    private final String status;

    HardwareBidStates(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
