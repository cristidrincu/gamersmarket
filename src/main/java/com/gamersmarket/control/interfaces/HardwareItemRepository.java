package com.gamersmarket.control.interfaces;

import com.gamersmarket.constants.JsonKeys;
import com.gamersmarket.entity.hardware.HardwareItem;

import javax.validation.constraints.NotNull;

public interface HardwareItemRepository<T> extends HardwareRepository<T> {

    void persistItemWithHardwareType(@NotNull T item, @NotNull HardwareItem hardwareItemJson, int hardwareTypeId);
}
