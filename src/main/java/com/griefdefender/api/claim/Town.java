/*
 * This file is part of GriefDefenderAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) bloodmc
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.griefdefender.api.claim;

import com.griefdefender.api.data.TownData;
import net.kyori.adventure.text.Component;

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
