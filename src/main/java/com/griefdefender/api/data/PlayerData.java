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
package com.griefdefender.api.data;

import com.griefdefender.api.User;
import com.griefdefender.api.claim.Claim;
import com.griefdefender.api.claim.ClaimGroup;
import com.griefdefender.api.claim.ClaimGroupSyncMode;
import com.griefdefender.api.claim.ClaimGroupTypes;
import com.griefdefender.api.claim.ClaimSnapshot;
import com.griefdefender.api.claim.ClaimType;
import com.griefdefender.api.permission.PermissionResult;
import com.griefdefender.api.permission.option.type.CreateModeType;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface PlayerData {

    /**
     * Gets the {@link User}.
     * 
     * @return The user associated with player data
     */
    User getUser();

    /**
     * Gets the {@link UUID} of player.
     * 
     * @return The unique identifier
     */
    UUID getUniqueId();

    /**
     * Gets the player name.
     * 
     * @return The player name
     */
    String getName();

    /**
     * Gets an unmodifiable set view of claims owned by this player.
     * 
     * @return The unmodifiable set view of owned claims, empty if none
     */
    Set<Claim> getClaims();

    /**
     * Gets the abandon return ratio used when abandoning a claim.
     * 
     * @param type The claim type to check
     * @return The abandon return ratio
     */
    double getAbandonedReturnRatio(ClaimType type);

    /**
     * Gets the total accrued claim blocks.
     * 
     * Note: This does not include initial claim blocks.
     * 
     * @return The total accrued claim blocks
     */
    int getAccruedClaimBlocks();

    /**
     * Gets the blocks accrued per hour.
     * 
     * @return The blocks accrued per hour
     */
    int getBlocksAccruedPerHour();

    /**
     * Gets the max amount of claim blocks a player
     * can hold.
     * 
     * @return The max amount of claim blocks
     */
    int getMaxAccruedClaimBlocks();

    /**
     * Gets the max level for claim creation.
     * 
     * @return The max level
     */
    int getMaxClaimLevel();

    /**
     * Gets the max size limit of x, in blocks, for claim
     * creation.
     * 
     * @param type The claim type to check
     * @return The max size of x
     */
    int getMaxClaimX(ClaimType type);

    /**
     * Gets the max size limit of y, in blocks, for claim
     * creation.
     * 
     * Note: This option is ignored for 2D claims.
     * 
     * @param type The claim type to check
     * @return The max size of y
     */
    int getMaxClaimY(ClaimType type);

    /**
     * Gets the max size limit of z, in blocks, for claim
     * creation.
     * 
     * @param type The claim type to check
     * @return The max size of z
     */
    int getMaxClaimZ(ClaimType type);

    /**
     * Gets the minimum level for claim creation.
     * 
     * @return The minimum level
     */
    int getMinClaimLevel();

    /**
     * Gets the minimum size limit of x, in blocks, for claim
     * creation.
     * 
     * @param type The claim type to check
     * @return The minimum size of x
     */
    int getMinClaimX(ClaimType type);

    /**
     * Gets the minimum size limit of y, in blocks, for claim
     * creation.
     * 
     * Note: This option is ignored for 2D claims.
     * 
     * @param type The claim type to check
     * @return The minimum size of y
     */
    int getMinClaimY(ClaimType type);

    /**
     * Gets the minimum size limit of z, in blocks, for claim
     * creation.
     * 
     * @param type The claim type to check
     * @return The minimum size of z
     */
    int getMinClaimZ(ClaimType type);

    /**
     * Gets the total bonus claim blocks.
     * 
     * @return The total bonus claim blocks
     */
    int getBonusClaimBlocks();

    /**
     * Gets the initial claim blocks.
     * 
     * @return The initial claim blocks
     */
    int getInitialClaimBlocks();

    /**
     * Gets the remaining claim blocks.
     * 
     * @return The remaining claim blocks
     */
    int getRemainingClaimBlocks();

    /**
     * Gets the remaining pvp combat time in seconds.
     * 
     * @param claim The claim to check in
     * @return The remaining pvp combat time
     */
    int getRemainingPvpCombatTime(Claim claim);

    /**
     * Gets the amount of days for this player's
     * auto-created chest claim's to expire.
     * 
     * @return The amount of days for chest claims to expire
     */
    int getChestClaimExpiration();

    /**
     * Gets the claim {@link CreateModeType} for player on login.
     * 
     * @return The claim creation mode
     */
    CreateModeType getClaimCreateMode();

    /**
     * Gets the max amount of claims this player can create for a specific {@link ClaimType}.
     * 
     * @param type The claim type
     * @return The max create claim limit
     */
    int getCreateClaimLimit(ClaimType type);

    /**
     * Gets the rental limit of this player.
     * 
     * @return The rental limit
     */
    int getRentalLimit();

    /**
     * Sets the rental limit of this player.
     * 
     * @param limit The rental limit
     * @return The permission result
     */
    CompletableFuture<PermissionResult> setRentalLimit(int limit);

    /**
     * Gets the economy claim block cost.
     * 
     * @return The economy claim block cost
     */
    double getEconomyClaimBlockCost();

    /**
     * Gets the economy claim block return on selling a claim block.
     * 
     * Note: This is only used if {@link GriefDefenderApi#isEconomyModeEnabled()} is false.
     *      
     * @return The economy claim block return
     */
    double getEconomyClaimBlockReturn();

    /**
     * Checks if this player can ignore a claim.
     * 
     * @param claim The claim to check
     * @return Whether this player can ignore the claim
     */
    boolean canIgnoreClaim(Claim claim);

    /**
     * Checks if this player can pvp in {@link Claim}.
     * 
     * @param claim The claim to check
     * @return Whether player has ability to pvp inside claim
     */
    boolean canPvp(Claim claim);

    /**
     * Checks if this player is in pvp combat.
     * 
     * @return true if in pvp combat, false if not
     */
    boolean inPvpCombat();

    /**
     * Sets the total amount of accrued claim blocks.
     * 
     * @param blocks The new total of accrued claim blocks
     * @return The permission result
     */
    CompletableFuture<PermissionResult> setAccruedClaimBlocks(int blocks);

    /**
     * Sets the total amount of bonus claim blocks.
     * 
     * @param blocks The new total of bonus claim blocks
     * @return The permission result
     */
    CompletableFuture<PermissionResult> setBonusClaimBlocks(int blocks);

    /**
     * Gets the current map view of player {@link ClaimSnapshot}'s.
     * 
     * @return An unmodifiable map of player claim snapshots
     */
    Map<String, Map<String, ClaimSnapshot>> getClaimSnapshots();

    /**
     * Gets the current map view of player {@link ClaimGroup}'s this player is using.
     * 
     * @return An unmodifiable map view of claim groups used by player
     */
    Map<String, ClaimGroup> getClaimGroupsByName();

    /**
     * Gets the current map view of player {@link ClaimGroup}'s this player is using.
     * 
     * @return An unmodifiable map view of claim groups used by player
     */
    Map<UUID, ClaimGroup> getClaimGroupsByUUID();

    /**
     * Deletes a {@link ClaimGroup} from player.
     * 
     * <br><br>Note: Deleting a {@link ClaimGroup} will remove all claims
     * associated with it causing the claim to use its own permissions.
     * 
     * @param group The claim group to delete
     * @return The permission result
     */
    CompletableFuture<PermissionResult> deleteClaimGroup(String name);

    /**
     * Deletes the specified {@link ClaimSnapshot} if it exists in group.
     * 
     * @param group The snapshot group
     * @param name The snapshot name to delete
     * @return true if the snapshot was deleted
     */
    boolean deleteSnapshot(String group, String name);

    /**
     * Deletes the specified {@link ClaimSnapshot} if it exists.
     * 
     * Note: This will only delete snapshots not associated with a group.
     * 
     * @param name The snapshot name to delete
     * @return true if the snapshot was deleted
     */
    boolean deleteSnapshot(String name);

    /**
     * Gets the current tax rate for {@link ClaimType}.
     * 
     * @param type The claim type
     * @return The current tax rate
     */
    double getTaxRate(ClaimType type);

    /**
     * Reverts all current visuals.
     */
    void revertAllVisuals();

    /**
     * Reverts the visual of a {@link Claim}.
     * 
     * @param claim The claim to revert
     */
    void revertVisual(Claim claim);

    /**
     * Reverts visual with {@link UUID}.
     * 
     * @param uuid The visual uuid
     */
    void revertVisual(UUID uuid);
}
