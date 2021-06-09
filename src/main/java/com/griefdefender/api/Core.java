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
import com.griefdefender.api.claim.ClaimGroup;
import com.griefdefender.api.claim.ClaimManager;
import com.griefdefender.api.claim.ClaimSnapshot;
import com.griefdefender.api.claim.TrustType;
import com.griefdefender.api.data.PlayerData;
import com.griefdefender.api.permission.flag.Flag;
import com.griefdefender.api.provider.ClanProvider;
import com.griefdefender.api.provider.WorldEditProvider;

import java.util.List;
import java.util.Map;
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
    @Nullable PlayerData getPlayerData(UUID worldUniqueId, UUID playerUniqueId);

    /**
     * Gets the claim with uuid.
     * 
     * @return The claim with uuid, if available
     */
    @Nullable Claim getClaim(UUID uuid);

    /**
     * Gets the claim with friendly identifier.
     * 
     * Note: If no owner UUID is available such as an admin or wilderness claim, pass null.
     * 
     * @param ownerUniqueId The owner UUID of claim
     * @param friendlyIdentifier The friendly name of claim
     * @return The claim with friendly identifier, if available
     */
    @Nullable Claim getClaim(@Nullable UUID ownerUniqueId, String friendlyIdentifier);

    /**
     * Gets the claim at location.
     * 
     * @param location The location
     * @return The claim, if available
     */
    @Nullable Claim getClaimAt(Object location);

    /**
     * Gets the claim at location.
     * 
     * @param worldUniqueId The world uuid
     * @param x The location block X coord
     * @param y The location block Y coord
     * @param z The location block Z coord
     * @return The claim, if available
     */
    @Nullable Claim getClaimAt(UUID worldUniqueId, int x, int y, int z);

    /**
     * Gets an unmodifiable map view of friendly claim identifiers.
     * 
     * @return The unmodifiable map view, empty map if none exist
     */
    Map<UUID, Map<String, UUID>> getFriendlyIdentifierMapView();

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
    @Nullable ClaimManager getClaimManager(UUID worldUniqueId);

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
     * Gets the {@link ClanProvider}.
     * 
     * Note: This will return null if a Clan plugin is not installed.
     * 
     * @return The clan provider, if available
     */
    @Nullable ClanProvider getClanProvider();

    /**
     * Gets the {@link WorldEditProvider}.
     * 
     * Note: This will return null if WorldEdit is not installed.
     * 
     * @return The worldedit provider, if available
     */
    @Nullable WorldEditProvider getWorldEditProvider();

    /**
     * Gets a global {@link ClaimSnapshot}.  
     * 
     * Note: This does not support {@link SnapshotCreateSettings.Type#CLAIM}. 
     * Use {@link Claim#getSnapshots()) instead.
     * Note: The id is in format '<group>:<name>'. If there is no group, just pass name.
     * 
     * @param type The type of snapshot
     * @param id The id of snapshot
     * @return The claim snapshot, if available
     */
   // @Nullable ClaimSnapshot getGlobalClaimSnapshot(String id, SnapshotCreateSettings.Type type);

    /**
     * Deletes an admin {@link ClaimSnapshot}.  
     * 
     * @param name The name of snapshot to delete
     * @param type The type of snapshot to delete
     */
    void deleteAdminClaimSnapshot(String name);

    /**
     * Deletes an admin {@link ClaimSnapshot} in specified snapshot group.  
     * 
     * @param group The name of snapshot group to search in
     * @param name The name of snapshot to delete
     * @param type The type of snapshot to delete
     */
    void deleteAdminClaimSnapshot(String group, String name);

    /**
     * Deletes a public {@link ClaimSnapshot}.  
     * 
     * @param name The name of snapshot to delete
     * @param type The type of snapshot to delete
     */
    void deletePublicClaimSnapshot(String name);

    /**
     * Deletes a public {@link ClaimSnapshot} in specified snapshot group.  
     * 
     * @param group The name of snapshot group to search in
     * @param name The name of snapshot to delete
     * @param type The type of snapshot to delete
     */
    void deletePublicClaimSnapshot(String group, String name);

    /**
     * Gets the current map view of admin {@link ClaimSnapshot}'s.
     * 
     * @return An unmodifiable map of admin claim snapshots
     */
    Map<String, Map<String, ClaimSnapshot>> getAdminClaimSnapshots();

    /**
     * Gets the current map view of public {@link ClaimSnapshot}'s.
     * 
     * @return An unmodifiable map of public claim snapshots
     */
    Map<String, Map<String, ClaimSnapshot>> getPublicClaimSnapshots();

    /**
     * Gets the current map view of admin {@link ClaimGroup}'s.
     * 
     * @return An unmodifiable map of admin claim groups
     */
    Map<String, ClaimGroup> getAdminClaimGroupsByName();

    /**
     * Gets the current map view of admin {@link ClaimGroup}'s.
     * 
     * @return An unmodifiable map of admin claim groups
     */
    Map<UUID, ClaimGroup> getAdminClaimGroupsByUUID();

    /**
     * Gets the current map view of player {@link ClaimGroup}'s.
     * 
     * @return An unmodifiable map of player claim groups
     */
    Map<UUID, ClaimGroup> getPlayerClaimGroupsByUUID();

    /**
     * Gets a {@link ClaimGroup} associated with uuid.
     * 
     * @param uuid The claim group uuid to search for.
     * @return The claim group, if available
     */
    @Nullable ClaimGroup getClaimGroupByUUID(UUID uuid);

    /**
     * Checks if the command sender can use the command at its location.
     * 
     * @param sender The command sender
     * @param trustType The trust type
     * @param claimIdentifier The claim identifier if check is for another claim
     * @return The command result
     */
    CommandResult canUseCommand(Object sender, TrustType trustType, @Nullable String claimIdentifier);
}
