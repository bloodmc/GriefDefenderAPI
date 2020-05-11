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

import com.griefdefender.api.claim.Claim;
import com.griefdefender.api.claim.ClaimBlockSystem;
import com.griefdefender.api.claim.ClaimManager;
import com.griefdefender.api.data.PlayerData;
import com.griefdefender.api.permission.flag.Flag;
import com.griefdefender.api.provider.WorldEditProvider;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.checkerframework.checker.nullness.qual.Nullable;

public interface Core {

    /**
     * Checks if GriefDefender is enabled in world.
     * 
     * @param worldProperties The world properties to check.
     * @return true if enabled, false if not
     */
    boolean isEnabled(UUID worldUniqueId);

    /**
     * Gets the claim block system used.
     * 
     * @return The claim block system
     */
    ClaimBlockSystem getClaimBlockSystem();

    /**
     * Checks if economy mode is enabled on server.
     */
    boolean isEconomyModeEnabled();

    /**
     * Checks if the protection module is enabled for flag.
     * 
     * @param flag The claim flag to check
     * @return true if enabled, false if not
     */
    boolean isProtectionModuleEnabled(Flag flag);

    /**
     * Gets the world {@link PlayerData} for specified {@link UUID}.
     * 
     * @param worldProperties The world properties
     * @param playerUniqueId The player UUID
     * @return The player data associated with uuid, if available
     */
    Optional<PlayerData> getPlayerData(UUID worldUniqueId, UUID playerUniqueId);

    /**
     * Gets the claim with uuid.
     * 
     * @return The claim with uuid, if available
     */
    @Nullable Claim getClaim(UUID uuid);

    /**
     * Gets an immutable list of all {@link Claim}'s.
     * 
     * @return An immutable list of all claims, empty list if none were found
     */
    List<Claim> getAllClaims();

    /**
     * Gets an immutable list of all player {@link Claim}'s.
     * 
     * Note: This will return an empty list if player has no claims.
     * 
     * @param playerUniqueId The player UUID
     * @return An immutable list of all claims, empty list if none were found
     */
    List<Claim> getAllPlayerClaims(UUID playerUniqueId);

    /**
     * Gets the claim manager of world.
     * 
     * @param worldUniqueId The world uuid
     * @return The claim manager of world
     */
    ClaimManager getClaimManager(UUID worldUniqueId);

    /**
     * Gets the default {@link Subject}.
     * 
     * Note: This subject is used to apply permissions to 
     * all users.
     * 
     * @return The default subject
     */
    Subject getDefaultSubject();

    /**
     * Gets the {@link Subject} with identifier.
     * 
     * @param identifier
     * @return The subject
     */
    Subject getSubject(String identifier);

    /**
     * Gets the {@link User} with {@link UUID}.
     * 
     * @param uuid The uuid
     * @return The user, if available
     */
    @Nullable User getUser(UUID uuid);

    /**
     * Gets the {@link Group} with identifier.
     * 
     * @param identifier
     * @return The subject
     */
    Group getGroup(String name);

    /**
     * Gets the {@link WorldEditProvider}.
     * 
     * Note: This will return null if WorldEdit is not installed.
     * 
     * @return The worldedit provider, if available
     */
    @Nullable WorldEditProvider getWorldEditProvider();
}
