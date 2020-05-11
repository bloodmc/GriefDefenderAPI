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
package com.griefdefender.api.provider;

import java.util.UUID;

import com.flowpowered.math.vector.Vector3i;
import com.griefdefender.api.GriefDefender;
import com.griefdefender.api.User;
import com.griefdefender.api.claim.Claim;

public interface WorldEditProvider {

    /**
     * Displays a WECUI claim visual to user with uuid.
     * 
     * @param claim The claim to visualize
     * @param uuid The user uuid
     */
    default void displayClaimCUIVisual(Claim claim, UUID uuid) {
        if (claim == null || uuid == null) {
            return;
        }

        final User user = GriefDefender.getCore().getUser(uuid);
        if (user == null) {
            return;
        }

        this.displayClaimCUIVisual(claim, user);
    }

    /**
     * Displays a WECUI claim visual to user with uuid.
     * 
     * @param claim The claim to visualize
     * @param uuid The user uuid
     */
    void displayClaimCUIVisual(Claim claim, User user);

    /**
     * Reverts a WECUI claim visual for user with uuid.
     * 
     * @param claimUniqueId The claim uuid to remove visualization
     * @param uuid The user uuid
     */
    default void revertClaimCUIVisual(UUID claimUniqueId, UUID uuid) {
        if (claimUniqueId == null || uuid == null) {
            return;
        }

        final User user = GriefDefender.getCore().getUser(uuid);
        if (user == null) {
            return;
        }

        this.revertClaimCUIVisual(claimUniqueId, user);
    }

    /**
     * Reverts a WECUI claim visual for user with uuid.
     * 
     * @param claimUniqueId The claim uuid to remove visualization
     * @param uuid The user uuid
     */
    void revertClaimCUIVisual(UUID claimUniqueId, User user);

    /**
     * Reverts all WECUI claim visuals for user with uuid.
     * 
     * @param uuid The user uuid
     */
    default void revertAllVisuals(UUID uuid) {
        if (uuid == null) {
            return;
        }

        final User user = GriefDefender.getCore().getUser(uuid);
        if (user == null) {
            return;
        }

        this.revertAllVisuals(user);
    }

    /**
     * Reverts all WECUI claim visuals for {link User}.
     * 
     * @param uuid The user
     */
    void revertAllVisuals(User user);

    /**
     * Starts sending a drag CUI visual to user at specified pos.
     * 
     * @param uuid The user uuid
     * @param pos The pos to start the visual
     */
    default void startDragVisual(UUID uuid, Vector3i pos) {
        if (uuid == null) {
            return;
        }

        final User user = GriefDefender.getCore().getUser(uuid);
        if (user == null) {
            return;
        }

        this.startDragVisual(user, pos.getX(), pos.getY(), pos.getZ());
    }

    /**
     * Starts sending a drag CUI visual to user at specified pos.
     * 
     * @param user The user
     * @param pos The pos to start the visual
     */
    default void startDragVisual(User user, Vector3i pos) {
        this.startDragVisual(user, pos.getX(), pos.getY(), pos.getZ());
    }

    /**
     * Starts sending a drag CUI visual to user at specified pos.
     * 
     * @param uuid The user uuid
     * @param x X coordinate
     * @param y Y coordinate
     * @param z Z coordinate
     */
    default void startDragVisual(UUID uuid, int x, int y, int z) {
        if (uuid == null) {
            return;
        }

        final User user = GriefDefender.getCore().getUser(uuid);
        if (user == null) {
            return;
        }

        this.startDragVisual(user, x, y, z);
    }

    /**
     * Starts sending a drag CUI visual to user at specified pos.
     * 
     * @param user The user
     * @param x X coordinate
     * @param y Y coordinate
     * @param z Z coordinate
     */
    void startDragVisual(User user, int x, int y, int z);

    /**
     * Stops sending a drag CUI visual to user.
     * 
     * @param user The user
     */
    void stopDragVisual(User user);

    /**
     * Gets whether user has WECUI support.
     * 
     * @param uuid The user uuid
     * @return Whether user has CUI support
     */
    default boolean hasCUISupport(UUID uuid) {
        if (uuid == null) {
            return false;
        }

        final User user = GriefDefender.getCore().getUser(uuid);
        if (user == null) {
            return false;
        }

        return this.hasCUISupport(user);
    }

    /**
     * Gets whether user has WECUI support.
     * 
     * @param user The user
     * @return Whether user has CUI support
     */
    boolean hasCUISupport(User user);
}
