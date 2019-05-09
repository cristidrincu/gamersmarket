package com.gamersmarket.common.enums.jsonkeys;

public enum HardwareOfferJsonKeys {
    HARDWARE_OFFER_ID("id"),
    APPROVED_BY_US("approvedByUs"),
    BUYER_REQUESTS_REVIEW("buyerRequestsReview"),
    SELLING_GAMER_ID("sellingGamerId"),
    BUYING_GAMER_ID("buyingGamerId"),
    APPROVER_GAMER_ID("approverGamerId"),
    WINNER_BID_ID("winnerBidId"),
    HARDWARE_ITEM_ID("hwItemId");

    private final String jsonKeyDescription;

    HardwareOfferJsonKeys(String jsonKeyDescription) {
        this.jsonKeyDescription = jsonKeyDescription;
    }

    public String getJsonKeyDescription() {
        return jsonKeyDescription;
    }
}
