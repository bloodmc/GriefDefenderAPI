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

import com.griefdefender.api.data.PlayerData;

/**
 * Used to provide more information to a plugin when a claim
 * action is successful or cancelled.
 */
public enum ClaimResultType {

    /**
     * Returned if a claim already exists.
     */
    CLAIM_ALREADY_EXISTS,

    /**
     * Returned if a claim is not found.
     */
    CLAIM_NOT_FOUND,

    /**
     * Returned if claims are not enabled in a world.
     */
    CLAIMS_DISABLED,

    /**
     * Returned if a claim's y level goes above a
     * {@link org.spongepowered.api.entity.living.player.Player}'s {@link PlayerData#getMaxClaimLevel()}.
     */
    ABOVE_MAX_LEVEL,

    /**
     * Returned if a claim's y level goes below a
     * {@link org.spongepowered.api.entity.living.player.Player}'s {@link PlayerData#getMinClaimLevel()}.
     */
    BELOW_MIN_LEVEL,

    /**
     * Returned if a claim's x size goes below a
     * {@link org.spongepowered.api.entity.living.player.Player}'s {@link PlayerData#getMinClaimX(ClaimType)}.
     */
    BELOW_MIN_SIZE_X,

    /**
     * Returned if a claim's y size goes below a
     * {@link org.spongepowered.api.entity.living.player.Player}'s {@link PlayerData#getMinClaimY(ClaimType)}.
     */
    BELOW_MIN_SIZE_Y,

    /**
     * Returned if a claim's z size goes below a
     * {@link org.spongepowered.api.entity.living.player.Player}'s {@link PlayerData#getMinClaimZ(ClaimType)}.
     */
    BELOW_MIN_SIZE_Z,

    /**
     * Returned if no economy account was found.
     */
    ECONOMY_ACCOUNT_NOT_FOUND,

    /**
     * Returned if a land purchase is made without enough funds.
     */
    ECONOMY_NOT_ENOUGH_FUNDS,

    /**
     * Returned if required claim funds could not be deposited into an {@link org.spongepowered.api.service.economy.account.Account}.
     */
    ECONOMY_DEPOSIT_FAIL,

    /**
     * Returned if required claim funds could not be withdrawn from an {@link org.spongepowered.api.service.economy.account.Account}.
     */
    ECONOMY_WITHDRAW_FAIL,

    /**
     * Returned if a {@link org.spongepowered.api.entity.living.player.Player} attempts to create a
     * claim past their {@link PlayerData#getCreateClaimLimit(ClaimType)}.
     */
    EXCEEDS_MAX_CLAIM_LIMIT,

    /**
     * Returned if a claim's x size exceeds a
     * {@link org.spongepowered.api.entity.living.player.Player}'s {@link PlayerData#getMaxClaimX(ClaimType)}.
     */
    EXCEEDS_MAX_SIZE_X,

    /**
     * Returned if a claim's y size exceeds a
     * {@link org.spongepowered.api.entity.living.player.Player}'s {@link PlayerData#getMaxClaimY(ClaimType)}.
     */
    EXCEEDS_MAX_SIZE_Y,

    /**
     * Returned if a claim's z size exceeds a
     * {@link org.spongepowered.api.entity.living.player.Player}'s {@link PlayerData#getMaxClaimZ(ClaimType)}.
     */
    EXCEEDS_MAX_SIZE_Z,

    /**
     * Returned if a claim action did not complete successfully.
     */
    FAILURE,

    /**
     * Returned if a {@link org.spongepowered.api.entity.living.player.Player} doesn't have enough claim blocks
     * to perform a claim action.
     */
    INSUFFICIENT_CLAIM_BLOCKS,

    /**
     * Returned if a {@link org.spongepowered.api.entity.living.player.Player} doesn't have enough funds
     * to perform an economy action.
     */
    NOT_ENOUGH_FUNDS,

    /**
     * Returned if a claim action requires an owner's permission.
     */
    REQUIRES_OWNER,

    /**
     * Returned if a world could not be loaded by uuid.
     */
    WORLD_NOT_FOUND,

    /**
     * Returned if an attempted claim action uses wrong
     * {@link ClaimType}.
     */
    WRONG_CLAIM_TYPE,

    /**
     * Returns a list of overlapping claims.
     * 
     * See {@link ClaimResult#getClaims()}
     */
    OVERLAPPING_CLAIM,

    /**
     * Returns one or more claims that were cancelled.
     * 
     * Note: If deleting a claim with child claims, this may
     * return a list of one or more claims in result that
     * could not be deleted due to event cancellations.
     */
    CLAIM_EVENT_CANCELLED,

    /**
     * Returns successful claim in result.
     * 
     * <p>Examples of results:</p>
     *
     * <ul>
     *     <li>Created claim</li>
     *     <li>Deleted claim</li>
     *     <li>Resized claim</li>
     *     <li>Transferred claim</li>
     * </ul>
     */
    SUCCESS
}
