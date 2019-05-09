package com.gamersmarket.common.utils.template.hardware;

import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.common.enums.jsonkeys.HardwareOfferJsonKeys;
import com.gamersmarket.control.gamers.GamersRepo;
import com.gamersmarket.control.hardware.HardwareItemRepo;
import com.gamersmarket.entity.gamers.Gamer;
import com.gamersmarket.entity.hardware.HardwareItem;

import javax.inject.Inject;
import java.util.LinkedHashMap;
import java.util.Map;

public class HardwareOfferTemplate {

    @Inject
    GamersRepo gamersRepo;

    @Inject
    HardwareItemRepo hardwareItemRepo;
    
    public HardwareOfferTemplate() {}

    public Map<String, Object> buildInitialHardwareOffer(JsonNode hardwareOfferJson) {
        Map<String, Object> initialHardwareOfferDependencies = new LinkedHashMap<>();

        int approvedByUs = hardwareOfferJson.get(HardwareOfferJsonKeys.APPROVED_BY_US.getJsonKeyDescription()).asInt();
        int buyerRequestsReview = hardwareOfferJson.get(HardwareOfferJsonKeys.BUYER_REQUESTS_REVIEW.getJsonKeyDescription()).asInt();
        int sellingGamerId = hardwareOfferJson.get(HardwareOfferJsonKeys.SELLING_GAMER_ID.getJsonKeyDescription()).asInt();
        int hwItemId = hardwareOfferJson.get(HardwareOfferJsonKeys.HARDWARE_ITEM_ID.getJsonKeyDescription()).asInt();

        Gamer sellingGamer = gamersRepo.getGamerDetails(sellingGamerId);
        HardwareItem hardwareItem = hardwareItemRepo.getItem(hwItemId);

        initialHardwareOfferDependencies.put(HardwareOfferJsonKeys.APPROVED_BY_US.getJsonKeyDescription(), approvedByUs);
        initialHardwareOfferDependencies.put(HardwareOfferJsonKeys.BUYER_REQUESTS_REVIEW.getJsonKeyDescription(), buyerRequestsReview);
        initialHardwareOfferDependencies.put(HardwareOfferJsonKeys.SELLING_GAMER_ID.getJsonKeyDescription(), sellingGamer);
        initialHardwareOfferDependencies.put(HardwareOfferJsonKeys.HARDWARE_ITEM_ID.getJsonKeyDescription(), hardwareItem);

        return initialHardwareOfferDependencies;
    }

    public Map<String, Object> buildFinalHardwareOffer(JsonNode hardwareOfferJson) {
        Map<String, Object> hardwareOfferDependencies = new LinkedHashMap<>();

        int buyingGamerId = hardwareOfferJson.get(HardwareOfferJsonKeys.BUYING_GAMER_ID.getJsonKeyDescription()).asInt();
        int approverGamerId = hardwareOfferJson.get(HardwareOfferJsonKeys.APPROVER_GAMER_ID.getJsonKeyDescription()).asInt();
        int winnerBidId = hardwareOfferJson.get(HardwareOfferJsonKeys.WINNER_BID_ID.getJsonKeyDescription()).asInt();

        Gamer buyingGamer = gamersRepo.getGamerDetails(buyingGamerId);
        Gamer approverGamer = gamersRepo.getGamerDetails(approverGamerId);
        Gamer winnerBid = gamersRepo.getGamerDetails(winnerBidId);

        hardwareOfferDependencies.put(HardwareOfferJsonKeys.BUYING_GAMER_ID.getJsonKeyDescription(), buyingGamer);
        hardwareOfferDependencies.put(HardwareOfferJsonKeys.APPROVER_GAMER_ID.getJsonKeyDescription(), approverGamer);
        hardwareOfferDependencies.put(HardwareOfferJsonKeys.WINNER_BID_ID.getJsonKeyDescription(), winnerBid);

        return hardwareOfferDependencies;
    }
}
