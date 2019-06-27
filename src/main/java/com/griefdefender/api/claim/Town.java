package com.griefdefender.api.claim;

import com.griefdefender.api.data.TownData;
import net.kyori.text.Component;

import java.util.Optional;
import java.util.UUID;

public interface Town extends Claim {

    /**
     * Gets the {@link ClaimType}.
     * 
     * @return The claim type
     */
    default ClaimType getType() {
        return ClaimTypes.TOWN;
    }

    /**
     * Gets the town tag.
     * 
     * @return The town tag
     */
    default Optional<Component> getTownTag() {
        return this.getData().getTownTag();
    }

    /**
     * Gets the {@link UUID}'s accrued claim blocks.
     * 
     * @return The uuid's accrued claim blocks
     */
    default int getAccruedClaimBlocks(UUID uuid) {
        final Integer accrued = this.getData().getAccruedClaimBlocks().get(uuid);
        if (accrued == null) {
            return 0;
        }

        return accrued;
    }

    /**
     * Gets the {@link UUID}'s bonus claim blocks.
     * 
     * @return The uuid's bonus claim blocks
     */
    default int getBonusClaimBlocks(UUID uuid) {
        final Integer bonus = this.getData().getBonusClaimBlocks().get(uuid);
        if (bonus == null) {
            return 0;
        }

        return bonus;
    }

    TownData getData();
}
