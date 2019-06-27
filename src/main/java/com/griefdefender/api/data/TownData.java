package com.griefdefender.api.data;

import net.kyori.text.Component;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface TownData extends ClaimData {

    Optional<Component> getTownTag();

    void setTownTag(Component text);

    Map<UUID, Integer> getAccruedClaimBlocks();

    Map<UUID, Integer> getBonusClaimBlocks();

    Map<UUID, String> getResidentPastDueTaxTimestamps();

    Map<UUID, Double> getResidentTaxBalances();
}
