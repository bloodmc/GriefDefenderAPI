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
package com.griefdefender.api;

import java.util.UUID;

import org.checkerframework.checker.nullness.qual.Nullable;

import com.griefdefender.api.claim.Claim;
import com.griefdefender.api.claim.TrustType;
import com.griefdefender.api.data.PlayerData;

/** 
 * Represents an online or offline player.
 */
public interface User extends Subject {

    /**
     * Gets the {@link UUID} of user.
     */
    UUID getUniqueId();

    /**
     * Gets the {@link PlayerData} of user.
     * 
     * @return The player data
     */
    PlayerData getPlayerData();

    /**
     * Whether this user is online.
     * 
     * @return true if online, false otherwise
     */
    boolean isOnline();

    /**
     * Gets the online player object.
     * 
     * @return The online player object, if available
     */
    @Nullable
    Object getOnlinePlayer();

    /**
     * Gets the current {@link Claim} player is in.
     * 
     * Note: This will return no claim if player is not online.
     * 
     * @return The current claim
     */
    @Nullable Claim getCurrentClaim();

    /**
     * Checks if this user can break a block at specified location.
     * 
     * @param location The target block location
     * @return true if user can break, false if not
     */
    default boolean canBreak(Object location) {
        return this.getPlayerData().canBreak(location);
    }

    /**
     * Checks if this user can place a block at specified location.
     * 
     * @param placedItem The item being placed
     * @param location The target block location
     * @return true if user can place, false if not
     */
    default boolean canPlace(Object placedItem, Object location) {
        return this.getPlayerData().canPlace(placedItem, location);
    }

    /**
     * Checks if this player can attack entity.
     * 
     * @param itemStack The item being used to attack entity
     * @param entity The target entity
     * @return true if entity can be attacked, false if not
     */
    default boolean canHurtEntity(Object itemStack, Object entity) {
        return this.getPlayerData().canHurtEntity(itemStack, entity);
    }

    /**
     * Checks if this player can interact with entity.
     * 
     * @param itemStack The item being used to interact with entity
     * @param entity The target entity
     * @param trustType The minimum {@link TrustType} required
     * @return true if entity can be interacted with, false if not
     */
    default boolean canInteractWithEntity(Object itemStack, Object entity, TrustType trustType) {
        return this.getPlayerData().canInteractWithEntity(itemStack, entity, trustType);
    }

    /**
     * Checks if this user can use a block at specified location.
     * 
     * @param location The target block location
     * @param trustType The minimum {@link TrustType} required
     * @param leftClick If block will be activated on left-click
     * @param shift If block activation requires shift
     * @return true if user can use block, false if not
     */
    default boolean canUseBlock(Object location, TrustType trustType, boolean leftClick, boolean shift) {
        return this.getPlayerData().canUseBlock(location, trustType, leftClick, shift);
    }

    /**
     * Checks if this user can use item at a specified location.
     * 
     * <br>Note: If item is custom, pass a string identifier in format
     *           'modid:name'
     * <br>Note: If item is activated on right-click then 'leftClick' 
     *           should be false.
     * 
     * @param itemStack The target itemStack
     * @param location The location where item will be used
     * @param trustType The minimum {@link TrustType} required.
     * @param leftClick If item will be activated on left-click. 
     * @param shift If item activation requires shift.
     * @return true if player can use item, false if not
     */
    default boolean canUseItem(Object itemStack, Object location, TrustType trustType, boolean leftClick, boolean shift) {
        return this.getPlayerData().canUseItem(itemStack, location, trustType, leftClick, shift);
    }

    /**
     * Checks if this user can ignore a claim.
     * 
     * @param claim The claim to check
     * @return Whether this user can ignore the claim
     */
    default boolean canIgnoreClaim(Claim claim) {
        return this.getPlayerData().canIgnoreClaim(claim);
    }

    /**
     * Checks if this user can manage admin claims.
     * 
     * @return true if can manage, false if not
     */
    default boolean canManageAdminClaims() {
        return this.getPlayerData().canManageAdminClaims();
    }

    /**
     * Checks if this user can manage wilderness claims.
     * 
     * @return true if can manage, false if not
     */
    default boolean canManageWildernessClaims() {
        return this.getPlayerData().canManageWildernessClaims();
    }

    /**
     * Checks if this user can pvp in {@link Claim}.
     * 
     * @param claim The claim to check
     * @return Whether user has ability to pvp inside claim
     */
    default boolean canPvp(Claim claim) {
        return this.getPlayerData().canPvp(claim);
    }

    /**
     * Checks if this user is in pvp combat.
     * 
     * @return true if in pvp combat, false if not
     */
    default boolean inPvpCombat() {
        if (!this.isOnline()) {
            return false;
        }
        return this.getPlayerData().inPvpCombat();
    }
}
