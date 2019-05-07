package com.gamersmarket.common.utils.template.hardware;

import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.common.enums.HardwareOfferJsonFields;
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

        int approvedByUs = hardwareOfferJson.get(HardwareOfferJsonFields.APPROVED_BY_US.getFieldName()).asInt();
        int buyerRequestsReview = hardwareOfferJson.get(HardwareOfferJsonFields.BUYER_REQUESTS_REVIEW.getFieldName()).asInt();
        int sellingGamerId = hardwareOfferJson.get(HardwareOfferJsonFields.SELLING_GAMER_ID.getFieldName()).asInt();
        int hwItemId = hardwareOfferJson.get(HardwareOfferJsonFields.HARDWARE_ITEM_ID.getFieldName()).asInt();

        Gamer sellingGamer = gamersRepo.getGamerDetails(sellingGamerId);
        HardwareItem hardwareItem = hardwareItemRepo.getItem(hwItemId);

        initialHardwareOfferDependencies.put(HardwareOfferJsonFields.APPROVED_BY_US.getFieldName(), approvedByUs);
        initialHardwareOfferDependencies.put(HardwareOfferJsonFields.BUYER_REQUESTS_REVIEW.getFieldName(), buyerRequestsReview);
        initialHardwareOfferDependencies.put(HardwareOfferJsonFields.SELLING_GAMER_ID.getFieldName(), sellingGamer);
        initialHardwareOfferDependencies.put(HardwareOfferJsonFields.HARDWARE_ITEM_ID.getFieldName(), hardwareItem);

        return initialHardwareOfferDependencies;
    }

    public Map<String, Object> buildFinalHardwareOffer(JsonNode hardwareOfferJson) {
        Map<String, Object> hardwareOfferDependencies = new LinkedHashMap<>();

        int buyingGamerId = hardwareOfferJson.get(HardwareOfferJsonFields.BUYING_GAMER_ID.getFieldName()).asInt();
        int approverGamerId = hardwareOfferJson.get(HardwareOfferJsonFields.APPROVER_GAMER_ID.getFieldName()).asInt();
        int winnerBidId = hardwareOfferJson.get(HardwareOfferJsonFields.WINNER_BID_ID.getFieldName()).asInt();

        Gamer buyingGamer = gamersRepo.getGamerDetails(buyingGamerId);
        Gamer approverGamer = gamersRepo.getGamerDetails(approverGamerId);
        Gamer winnerBid = gamersRepo.getGamerDetails(winnerBidId);

        hardwareOfferDependencies.put(HardwareOfferJsonFields.BUYING_GAMER_ID.getFieldName(), buyingGamer);
        hardwareOfferDependencies.put(HardwareOfferJsonFields.APPROVER_GAMER_ID.getFieldName(), approverGamer);
        hardwareOfferDependencies.put(HardwareOfferJsonFields.WINNER_BID_ID.getFieldName(), winnerBid);

        return hardwareOfferDependencies;
    }
}
