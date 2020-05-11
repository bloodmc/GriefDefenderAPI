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

import java.util.UUID;

import com.griefdefender.api.GriefDefender;
import com.griefdefender.api.User;

public interface ClaimVisual {

    /**
     * Gets the {@link Claim} of visual.
     * 
     * @return The claim
     */
    Claim getClaim();

    /**
     * Gets the {@link ClaimVisualType}.
     * 
     * @return The claim visual type
     */
    ClaimVisualType getType();

    /**
     * Sets the {@link ClaimVisualType}.
     * 
     * @param type The new visual type
     */
    void setType(ClaimVisualType type);

    /**
     * Applies the visual to player with {@link UUID}.
     * 
     * @param uuid The player uuid to apply visual
     */
    default void apply(UUID uuid) {
        final User user = GriefDefender.getCore().getUser(uuid);
        if (user == null) {
            return;
        }

        this.apply(user);
    }

    /**
     * Applies the visual to player with {@link UUID}.
     * 
     * @param uuid The player uuid to apply visual
     * @param resetActive Whether to reset current player visuals
     */
    default void apply(UUID uuid, boolean resetActive) {
        final User user = GriefDefender.getCore().getUser(uuid);
        if (user == null) {
            return;
        }

        this.apply(user, resetActive);
    }

    /**
     * Applies the visual to {@link User}.
     * 
     * @param user The user to apply visual
     */
    default void apply(User user) {
        this.apply(user, true);
    }

    /**
     * Applies the visual to {@link User}.
     * 
     * @param user The user to apply visual
     * @param resetActive Whether to reset current player visuals
     */
    void apply(User user, boolean resetActive);

    /**
     * Reverts the claim visual.
     * 
     * @param user The user to revert visual
     */
    void revert(User user);

    /**
     * Reverts the claim visual.
     * 
     * @param user The user to revert visual
     */
    void revert(UUID uuid);

    /**
     * Gets the amount of spacing, in blocks, between filler blocks.
     * 
     * @return The amount of spacing between filler blocks
     */
    int getFillerSpacing();

    /**
     * Sets the amount of spacing between filler blocks.
     * 
     * @param amount The spacing amount
     */
    void setFillerSpacing(int amount);
}
