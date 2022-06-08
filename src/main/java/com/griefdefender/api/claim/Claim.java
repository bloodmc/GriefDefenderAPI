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

import com.flowpowered.math.vector.Vector3i;
import com.griefdefender.api.Clan;
import com.griefdefender.api.ContextSource;
import com.griefdefender.api.GriefDefender;
import com.griefdefender.api.Subject;
import com.griefdefender.api.Tristate;
import com.griefdefender.api.User;
import com.griefdefender.api.data.ClaimData;
import com.griefdefender.api.data.EconomyData;
import com.griefdefender.api.data.PlayerData;
import com.griefdefender.api.permission.Context;
import com.griefdefender.api.permission.PermissionResult;
import com.griefdefender.api.permission.flag.Flag;
import com.griefdefender.api.permission.flag.FlagDefinition;
import com.griefdefender.api.permission.option.Option;
import com.griefdefender.api.permission.option.OptionDefinition;

import io.leangen.geantyref.TypeToken;
import net.kyori.adventure.text.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Represents a protected claim.
 */
public interface Claim extends ContextSource {

    /**
     * Gets the {@link UUID} of claim.
     * 
     * @return The UUID of this claim
     */
    UUID getUniqueId();

    /**
     * Gets the {@link ClaimType} of claim.
     * 
     * @return The claim type
     */
    default ClaimType getType() {
        return this.getData().getType();
    }

    /** Gets the claim's world {@link UUID}.
     * 
     * @return The world UUID
     */
    default UUID getWorldUniqueId() {
        return this.getData().getWorldUniqueId();
    }

    /**
     * Gets the claim's world name.
     * 
     * @return The world name
     */
    String getWorldName();

    /**
     * Gets the claim's display name {@link Component}.
     * 
     * @return The display name component, if available
     */
    Optional<Component> getDisplayNameComponent();

    /**
     * Gets the claim's display name.
     * 
     * @return The display name, if available
     */
    @Nullable  String getDisplayName();

    /**
     * Gets the unique friendly identifier of claim.
     * 
     * Note: This represents the unique friendly identifier of claim and is different from 
     * the {@link #getDisplayName()}.
     * 
     * @return The unique friendly identifier, if available
     */
    @Nullable String getFriendlyIdentifier();

    /**
     * Gets the claim group this claim is associated with.
     * 
     * @return The claim group, if available
     */
    @Nullable ClaimGroup getClaimGroup();

    /**
     * Sets the unique friendly identifier of claim.
     * 
     * Note: This represents the unique friendly identifier of claim and is different from 
     * the {@link #setDisplayName(Component)}.
     * 
     * @param name The unique friendly identifier
     * @param replace Whether to replace if identifier exists
     * @return true if successful, false if no replace
     */
    void setFriendlyIdentifier(String name);

    /**
     * Gets the active {@link ClaimVisual}.
     * 
     * @return The claim visual, if available
     */
    @Nullable ClaimVisual getClaimVisual();

    /**
     * Gets the claim owner's name.
     * 
     * Note: {@link ClaimType#ADMIN} and {@link ClaimType#WILDERNESS} claims do not have
     * owners. These claims should return a general name such as 'administrator'.
     * 
     * @return The name of claim owner
     */
    String getOwnerName();

    /**
     * Gets the claim owner's display name as a {@link Component}.
     * 
     * Note: {@link ClaimType#ADMIN} and {@link ClaimType#WILDERNESS} claims do not have
     * owners. These claims should return a general name such as 'administrator'.
     * 
     * @return The display name of claim owner, if available
     */
    Component getOwnerDisplayName();

    /**
     * Gets the claim owner's {@link UUID}.
     * 
     * Note: {@link ClaimType#ADMIN} and {@link ClaimType#WILDERNESS} claims do not have
     * owners.
     * 
     * @return The UUID of this claim
     */
    default UUID getOwnerUniqueId() {
        return this.getData().getOwnerUniqueId();
    }

    /**
     * Adds a {@link ClaimAttribute}.
     * 
     * @param attribute The claim attribute
     */
    void addAttribute(ClaimAttribute attribute);

    /**
     * Removes a {@link ClaimAttribute}.
     * 
     * @param id The claim attribute
     */
    default void removeAttribute(ClaimAttribute attribute) {
        this.removeAttribute(attribute.getId());
    }

    /**
     * Removes a {@link ClaimAttribute} by id.
     * 
     * @param id The claim attribute id
     */
    void removeAttribute(String id);

    /**
     * Removes all attribute types associated with claim.
     */
    void removeAllAttributes();

    /**
     * Checks if claim contains {@link ClaimAttribute}.
     * 
     * @param attribute The claim attribute
     * @return true if claim contains it, false if not
     */
    default boolean hasAttribute(ClaimAttribute attribute) {
        return this.hasAttribute(attribute.getId());
    }

    /**
     * Checks if claim contains {@link ClaimAttribute} by id.
     * 
     * @param id The claim attribute id
     * @return true if claim contains it, false if not
     */
    boolean hasAttribute(String id);

    /**
     * Gets a set of {@link ClaimAttribute}'s associated with claim.
     * 
     * @return An unmodifiable set of claim attributes
     */
    Set<ClaimAttribute> getAttributes();

    /**
     * Gets the claim's parent.
     * 
     * @return The parent claim, if available
     */
    @Nullable Claim getParent();

    List<Claim> getInheritedParents();

    /**
     * Gets the lesser boundary corner of claim.
     * 
     * @return The lesser boundary corner location.
     */
    Vector3i getLesserBoundaryCorner();

    /**
     * Gets the greater boundary corner of claim.
     * 
     * @return The greater boundary corner location.
     */
    Vector3i getGreaterBoundaryCorner();

    /**
     * Gets whether claim is a cuboid.
     * 
     * @return true if claim is cuboid
     */
    boolean isCuboid();

    /**
     * Checks if claim is parent
     * 
     * @param claim The claim to check
     * @return true if claim is parent
     */
    boolean isParent(Claim claim);

    /**
     * Gets the claim blocks required for this claim.
     * 
     * Note: If cuboids are enabled in wilderness, 2D claims will factor in Y.
     * 
     * @return The claim blocks of claim
     */
    int getClaimBlocks();

    /**
     * Gets the total claim area in blocks.
     * 
     * @return The total area of claim
     */
    int getArea();

    /**
     * Gets the total claim volume in blocks.
     *      
     * @return The total volume of claim
     */
    int getVolume();

    /**
     * Gets the claim's width(x axis) in blocks.
     * 
     * @return The width of claim
     */
    int getWidth();

    /**
     * Gets the claim's height(y axis) in blocks.
     * 
     * @return The height of claim
     */
    int getHeight();

    /**
     * Gets the claim's length(z axis) in blocks.
     * 
     * @return The length of claim
     */
    int getLength();

    /**
     * Gets the list of chunk positions used by this claim.
     * 
     * @return The list of claim chunk positions used.
     */
    List<Vector3i> getChunkPositions();

    /**
     * Gets the list of entities currently in claim.
     * 
     * @return The list of entities in claim.
     */
    //List<Entity> getEntities();

    /**
     * Gets the list of players currently in claim.
     * 
     * @return The list of players in claim.
     */
    List<UUID> getPlayers();

    /**
     * Transfers claim to new owner.
     * 
     * Note: Both {@link ClaimType#WILDERNESS} and {@link ClaimType#ADMIN} cannot be transferred.
     * This validates if the new owner has enough claim blocks to support this claim.
     * 
     * @param ownerUniqueId
     * @return The claim result
     */
    ClaimResult transferOwner(UUID ownerUniqueId);

    /**
     * Attempts to change claim to another type.
     * 
     * Note: If changing an {@link ClaimType#ADMIN} claim, owner is required.
     * 
     * @param type The new claim type
     * @return The claim result
     */
    default ClaimResult changeType(ClaimType type) {
        return changeType(type, null);
    }

    /**
     * Attempts to change claim to another type and owner.
     * 
     * Note: {@link ClaimType#WILDERNESS} cannot be changed.
     * If changing an {@link ClaimType#ADMIN} claim, owner is required.
     * 
     * @param type The new claim type
     * @param owner The owner to set
     * @return The claim result
     */
    ClaimResult changeType(ClaimType type, @Nullable UUID owner);

    /**
     * Resizes a claim.
     * 
     * @param startCornerPos The start corner block position
     * @param endCornerPos The end corner block position
     * @return The claim result
     */
    default ClaimResult resize(Vector3i startCornerPos, Vector3i endCornerPos) {
        return this.resize(startCornerPos.getX(), endCornerPos.getX(), startCornerPos.getY(), endCornerPos.getY(), startCornerPos.getZ(), endCornerPos.getZ());
    }

    /**
     * Resizes the claim.
     * 
     * @param x1 The start X-axis position
     * @param x2 The end X-axis position
     * @param y1 The start Y-axis position
     * @param y2 The end Y-axis position
     * @param z1 The start Z-axis position
     * @param z2 The end Z-axis position
     * @return The claim result
     */
    ClaimResult resize(int x1, int x2, int y1, int y2, int z1, int z2);

    /**
     * Gets an immutable list of child claims.
     * 
     * Note: This will return an empty list if no child claims
     * are found.
     * 
     * @param recursive Whether to recursively scan for children
     * @return The immutable list of child claims
     */
    Set<Claim> getChildren(boolean recursive);

    /**
     * Gets an immutable list of parent claims.
     * 
     * Note: This will return an empty list if no parent claims
     * are found.
     * 
     * @param recursive Whether to recursively scan for parents
     * @return The immutable list of parent claims
     */
    List<Claim> getParents(boolean recursive);

    /**
     * Gets an unmodifiable set of all trusted users.
     * 
     * @return An unmodifiable set of all trusted users
     */
    Set<UUID> getUserTrusts();

    /**
     * Gets an unmodifiable set of trusted users for {@link TrustType}.
     * 
     * @return An unmodifiable set of trusted users
     */
    Set<UUID> getUserTrusts(TrustType type);

    /**
     * Gets an unmodifiable set of all trusted groups.
     * 
     * @return An unmodifiable set of all trusted groups
     */
    Set<String> getGroupTrusts();

    /**
     * Gets an unmodifiable set of trusted groups for {@link TrustType}.
     * 
     * @return An unmodifiable set of trusted groups
     */
    Set<String> getGroupTrusts(TrustType type);

    /**
     * Clears all trusts for claim.
     * 
     * @return The claim result
     */
    ClaimResult removeAllTrusts();

    /**
     * Clears all user trusts for claim.
     * 
     * @return The claim result
     */
    ClaimResult removeAllUserTrusts();

    /**
     * Clears all group trusts for claim.
     * 
     * @return The claim result
     */
    ClaimResult removeAllGroupTrusts();

    /**
     * Gets an unmodifiable set of all trusted clans.
     * 
     * @return An unmodifiable set of all trusted clans
     */
    Set<Clan> getClanTrusts();

    /**
     * Gets an unmodifiable set of trusted clans for {@link TrustType}.
     * 
     * @return An unmodifiable set of trusted clans
     */
    Set<Clan> getClanTrusts(TrustType type);

    /**
     * Clears all clan trusts for claim.
     * 
     * @return The claim result
     */
    ClaimResult removeAllClanTrusts();

    /**
     * Grants claim trust to the UUID for given {@link TrustType}.
     * 
     * @param uuid The UUID of user
     * @param type The trust type
     * @return The claim result
     */
    ClaimResult addUserTrust(UUID uuid, TrustType type);

    /**
     * Grants claim trust to the set of UUID's for given {@link TrustType}.
     * 
     * @param uuid The set of user UUID's
     * @param type The trust type
     * @return The claim result
     */
    ClaimResult addUserTrusts(Set<UUID> uuid, TrustType type);

    /**
     * Removes UUID from claim trust for given {@link TrustType}.
     * 
     * @param uuid The UUID of user
     * @param type The trust type
     * @return The claim result
     */
    ClaimResult removeUserTrust(UUID uuid, TrustType type);

    /**
     * Removes the set of UUID's from claim trust for given {@link TrustType}.
     * 
     * @param uuid The set of user UUID's
     * @param type The trust type
     * @return The claim result
     */
    ClaimResult removeUserTrusts(Set<UUID> uuid, TrustType type);

    /**
     * Grants claim trust to the group for given {@link TrustType}.
     * 
     * @param group The group
     * @param type The trust type
     * @return The claim result
     */
    ClaimResult addGroupTrust(String group, TrustType type);

    /**
     * Grants claim trust to the set of groups for given {@link TrustType}.
     * 
     * @param groups The set of groups
     * @param type The trust type
     * @return The claim result
     */
    ClaimResult addGroupTrusts(Set<String> groups, TrustType type);

    /**
     * Removes a group from claim trust for given {@link TrustType}.
     * 
     * @param group The group
     * @param type The trust type
     * @return The claim result
     */
    ClaimResult removeGroupTrust(String group, TrustType type);

    /**
     * Removes the set of UUID's from claim trust for given {@link TrustType}.
     * 
     * @param groups The set of groups
     * @param type The trust type
     * @return The claim result
     */
    ClaimResult removeGroupTrusts(Set<String> groups, TrustType type);

    /**
     * Grants claim trust to the clan for given {@link TrustType}.
     * 
     * @param clan The clan
     * @param type The trust type
     * @return The claim result
     */
    ClaimResult addClanTrust(Clan clan, TrustType type);

    /**
     * Grants claim trust to the set of clans for given {@link TrustType}.
     * 
     * @param clans The set of clans
     * @param type The trust type
     * @return The claim result
     */
    ClaimResult addClanTrusts(Set<Clan> clans, TrustType type);

    /**
     * Grants claim trust to the clan for given {@link TrustType}.
     * 
     * @param clanTag The clan tag
     * @param type The trust type
     * @return The claim result
     */
    ClaimResult addClanTrust(String clanTag, TrustType type);

    /**
     * Removes a clan from claim trust for given {@link TrustType}.
     * 
     * @param clan The clan
     * @param type The trust type
     * @return The claim result
     */
    ClaimResult removeClanTrust(Clan clan, TrustType type);

    /**
     * Removes a clan from claim trust for given {@link TrustType}.
     * 
     * @param clanTag The clan tag
     * @param type The trust type
     * @return The claim result
     */
    ClaimResult removeClanTrust(String clanTag, TrustType type);

    /**
     * Removes the set of clans from claim trust for given {@link TrustType}.
     * 
     * @param clans The set of clans
     * @param type The trust type
     * @return The claim result
     */
    ClaimResult removeClanTrusts(Set<Clan> clans, TrustType type);

    /**
     * Checks if the {@link UUID} is trusted with given {@link TrustType}.
     * 
     * @param uuid The uuid to check
     * @param type The minimum trust required
     * @return Whether the uuid is trusted
     */
    boolean isUserTrusted(UUID uuid, TrustType type);

    /**
     * Checks if the group is trusted with given {@link TrustType}.
     * 
     * @param group The group to check
     * @param type The minimum trust required
     * @return Whether the group is trusted
     */
    boolean isGroupTrusted(String group, TrustType type);

    /**
     * Checks if the clan is trusted with given {@link TrustType}.
     * 
     * @param clan The clan to check
     * @param type The minimum trust required
     * @return Whether the clan is trusted
     */
    boolean isClanTrusted(Clan clan, TrustType type);

    /**
     * Checks if the clan tag is trusted with given {@link TrustType}.
     * 
     * @param clanTag The clan tag to check
     * @param type The minimum trust required
     * @return Whether the clan is trusted
     */
    boolean isClanTrusted(String clanTag, TrustType type);

    /**
     * Checks if this type is {@link ClaimTypes#ADMIN}.
     * 
     * @return true if admin claim
     */
    default boolean isAdminClaim() {
        return this.getType() == ClaimTypes.ADMIN;
    }

    /**
     * Checks if this type is {@link ClaimTypes#BASIC}.
     * 
     * @return true if basic claim
     */
    default boolean isBasicClaim() {
        return this.getType() == ClaimTypes.BASIC;
    }

    /**
     * Checks if this type is {@link ClaimTypes#SUBDIVISION}.
     * 
     * @return true if subdivision
     */
    default boolean isSubdivision() {
        return this.getType() == ClaimTypes.SUBDIVISION;
    }

    /**
     * Checks if this type is {@link ClaimTypes#TOWN}.
     * 
     * @return true if town
     */
    default boolean isTown() {
        return this.getType() == ClaimTypes.TOWN;
    }

    /**
     * Checks if this type is {@link ClaimTypes#WILDERNESS}.
     * 
     * @return true if wilderness
     */
    default boolean isWilderness() {
        return this.getType() == ClaimTypes.WILDERNESS;
    }

    /**
     * Checks if this claim is within a town.
     * 
     * @return true if this claim is within a town
     */
    boolean isInTown();

    /**
     * Gets the town this claim is in.
     * 
     * @return the town this claim is in, if any
     */
    @Nullable Claim getTown();

    /**
     * Gets the {@link ClaimManager} of this claim's world.
     * 
     * @return The claim manager
     */
    ClaimManager getClaimManager();

    /**
     * Gets the wilderness claim of this claim's world.
     * 
     * @return The wilderness claim
     */
    Claim getWilderness();

    /**
     * Checks if the position is within this claim.
     * 
     * @param x X coordinate
     * @param y Y coordinate
     * @param z Z coordinate
     * @return Whether this claim contains the passed position
     */
    default boolean contains(int x, int y, int z) {
        return this.contains(x, y, z, false);
    }

    /**
     * Checks if the position is within this claim.
     * 
     * @param location
     * @return Whether this claim contains the passed position
     */
    default boolean contains(Vector3i pos) {
        return this.contains(pos, false);
    }

    /**
     * Checks if the position is within this claim.
     * 
     * @param location
     * @param excludeChildren
     * @return Whether this claim contains the passed location
     */
    default boolean contains(Vector3i pos, boolean excludeChildren) {
        return this.contains(pos.getX(), pos.getY(), pos.getZ(), excludeChildren);
    }

    /**
     * Checks if the position is within this claim.
     * 
     * @param x X coordinate
     * @param y Y coordinate
     * @param z Z coordinate
     * @param excludeChildren
     * @return Whether this claim contains the passed location
     */
    boolean contains(int x, int y, int z, boolean excludeChildren);

    /**
     * Checks if this claim overlaps another.
     * 
     * @param otherClaim The other claim to check
     * 
     * @return Whether this claim overlaps the other claim
     */
    boolean overlaps(Claim otherClaim);

    /**
     * Extends a cuboid claim downward.
     * 
     * @param newDepth The new depth
     * @return Whether the extension was successful
     */
    boolean extend(int newDepth);

    /**
     * Checks if this claim is within another claim.
     * 
     * @param otherClaim The other claim
     * @return Whether this claim is inside other claim
     */
    boolean isInside(Claim otherClaim);

    /**
     * Gets the chunk hashes this claim contains.
     * 
     * @return The set of chunk hashes
     */
    Set<Long> getChunkHashes();

    /**
     * Deletes all children claims.
     * 
     * @return The result of deletion
     */
    ClaimResult deleteChildren();

    /**
     * Deletes all children claims of a specific {@link ClaimType}.
     * 
     * @param type The type of claims to delete
     * @return The result of deletion
     */
    ClaimResult deleteChildren(ClaimType type);

    /**
     * Deletes a child claim.
     * 
     * @param child The child claim to be deleted
     * @return The result of deletion
     */
    ClaimResult deleteChild(Claim child);

    /**
     * Gets the persisted data of claim.
     * 
     * @return The claim's persisted data
     */
    ClaimData getData();

    /**
     * Deletes the specified {@link ClaimSchematic} if it exists.
     * 
     * @param name The schematic to delete
     * @return true if the schematic was deleted
     */
    boolean deleteSchematic(String schematic);

    /**
     * Gets a map of currently stored {@link ClaimSchematic}'s.
     * 
     * @return The map of schematics, empty if none
     */
    Map<String, ClaimSchematic> getSchematics();

    /**
     * Creates a {@link ClaimSnapshot}.
     * 
     * @param name The snapshot name
     * @param settings The creation settings
     * @param description The snapshot description
     * @return The claim snapshot
     */
    ClaimSnapshot createSnapshot(String name, Component description, SnapshotCreateSettings settings);

    /**
     * Creates a {@link ClaimSnapshot}.
     * 
     * Note: This will use default {@link SnapshotCreateSettings}
     * 
     * @param name The snapshot name
     * @param includeChildren True to include children, false if not
     * @return The claim snapshot
     */
    ClaimSnapshot createSnapshot(String name, boolean includeChildren);

    /**
     * Creates a {@link ClaimSnapshot}.
     * 
     * Note: This will use default {@link SnapshotCreateSettings}
     * 
     * @param name The snapshot name
     * @param description The snapshot description
     * @param includeChildren True to include children, false if not
     * @return The claim snapshot
     */
    ClaimSnapshot createSnapshot(String name, Component description, boolean includeChildren);

    /**
     * Deletes the specified {@link ClaimSnapshot} if it exists.
     * 
     * @param name The snapshot to delete
     * @return true if the snapshot was deleted
     */
    boolean deleteSnapshot(String name);

    /**
     * Gets a map of currently stored {@link ClaimSnapshot}'s.
     * 
     * @return The map of snapshots, empty if none
     */
    Map<String, ClaimSnapshot> getSnapshots();

    default EconomyData getEconomyData() {
        return this.getData().getEconomyData();
    }

    /**
     * Gets the economy account used for claim bank.
     * 
     * @return the economy account, if available
     */
    @Nullable UUID getEconomyAccountId();

    /**
     * Gets the rented claim.
     * 
     * Note: If this is a non-rented child claim, it will check
     * parents that have same owner.
     * 
     * @return The rented claim
     */
    @Nullable Claim getRentedClaim();

    /**
     * Whether the {@link User} has an active visual on this {@link Claim}.
     * 
     * @param user The user
     * @return true if active visual, false if not
     */
    boolean hasActiveVisual(User user);

    /**
     * Whether PVP is allowed in this {@link Claim}.
     * 
     * @return true if allowed, false if not
     */
    boolean isPvpAllowed();

    /**
     * Whether user with {@link UUID} can edit claim.
     * 
     * @param uuid The user unique id
     * @return true if allowed, false if not
     */
    boolean allowEdit(UUID uuid);

    /**
     * Checks if a block can be broken at specified location in this {@link Claim}.
     * 
     * <br>Note: If source was performed directly by player, pass player
     * <br>Note: If source is custom, pass a string identifier in format
     *           'modid:name'
     * 
     * @param source The source performing the break action
     * @param location The target block location
     * @param user The user associated with action, if available
     * @return true if block can be broken, false if not
     */
    boolean canBreak(Object source, Object location, @Nullable User user);

    /**
     * Checks if a block can be placed at specified location in this {@link Claim}.
     * 
     * <br>Note: If source was performed directly by player, pass player
     * <br>Note: If source or item is custom, pass a string identifier in format
     *           'modid:name'
     * 
     * @param source The source performing the place action
     * @param placedItem The item being placed
     * @param location The target block location
     * @param user The user associated with action, if available
     * @return true if block can be placed, false if not
     */
    boolean canPlace(Object source, Object placedItem, Object location, @Nullable User user);

    /**
     * Checks if an entity can be attacked in this {@link Claim}.
     * 
     * <br>Note: If source was performed directly by player, pass player
     * <br>Note: If source or item is custom, pass a string identifier in format
     *           'modid:name'
     * 
     * @param source The source performing the attack
     * @param itemStack The item being used to attack entity
     * @param entity The target entity
     * @param user The user associated with action, if available
     * @return true if entity can be attacked, false if not
     */
    boolean canHurtEntity(Object source, Object itemStack, Object entity, @Nullable User user);

    /**
     * Checks if an entity can be interacted with in this {@link Claim}.
     * 
     * <br>Note: If source was performed directly by player, pass player
     * <br>Note: If source, item, or entity is custom, pass a string identifier in format
     *           'modid:name'
     * 
     * @param source The source performing the entity interaction
     * @param itemStack The item being used to interact with entity
     * @param entity The target entity
     * @param user The user associated with action, if available
     * @param trustType The minimum {@link TrustType} required
     * @return true if entity can be interacted with, false if not
     */
    boolean canInteractWithEntity(Object source, Object itemStack, Object entity, @Nullable User user, TrustType trustType);

    /**
     * Checks if a block can be used at specified location.
     * 
     * <br>Note: If source was performed directly by player, pass player
     * <br>Note: If source is custom, pass a string identifier in format
     *           'modid:name'
     * 
     * @param source The source performing the use action
     * @param location The target block location
     * @param user The user associated with action, if available
     * @param trustType The minimum {@link TrustType} required
     * @return true if block can be used, false if not
     */
    default boolean canUseBlock(Object source, Object location, @Nullable User user, TrustType trustType) {
        return this.canUseBlock(source, location, user, trustType, false, false);
    }

    /**
     * Checks if a block can be used at specified location.
     * 
     * <br>Note: If source was performed directly by player, pass player
     * <br>Note: If source is custom, pass a string identifier in format
     *           'modid:name'
     * <br>Note: Parameters 'leftClick' and 'shift' are only used if
     *           player is source.
     * 
     * @param source The source performing the use action
     * @param location The target block location
     * @param user The user associated with action, if available
     * @param trustType The minimum {@link TrustType} required
     * @param leftClick If block will be activated on left-click
     * @param shift If block activation requires shift
     * @return true if block can be used, false if not
     */
    boolean canUseBlock(Object source, Object location, @Nullable User user, TrustType trustType, boolean leftClick, boolean shift);

    /**
     * Checks if this player can use item at a specified location.
     * 
     * <br>Note: If source was performed directly by player, pass player
     * <br>Note: If source or item is custom, pass a string identifier in format
     *           'modid:name'
     * <br>Note: If item is activated on right-click then 'leftClick' 
     *           should be false.
     * 
     * @param source The source performing the use action
     * @param itemStack The target itemStack
     * @param location The location where item will be used
     * @param user The user associated with action, if available
     * @param trustType The minimum {@link TrustType} required
     * @return true if player can use item, false if not
     */
    default boolean canUseItem(Object source, Object itemStack, Object location, @Nullable User user, TrustType trustType) {
        return this.canUseItem(source, itemStack, location, user, trustType, false, false);
    }

    /**
     * Checks if this player can use item at a specified location.
     * 
     * <br>Note: If source was performed directly by player, pass player
     * <br>Note: If source or item is custom, pass a string identifier in format
     *           'modid:name'
     * <br>Note: If item is activated on right-click then 'leftClick' 
     *           should be false.
     * 
     * @param source The source performing the use action
     * @param itemStack The target itemStack
     * @param location The location where item will be used
     * @param user The user associated with action, if available
     * @param trustType The minimum {@link TrustType} required
     * @param leftClick If item will be activated on left-click 
     * @param shift If item activation requires shift.
     * @return true if player can use item, false if not
     */
    boolean canUseItem(Object source, Object itemStack, Object location, @Nullable User user, TrustType trustType, boolean leftClick, boolean shift);

    /**
    * Gets the active {@link Flag} permission value for {@link Subject} in this {@link Claim}.
    * 
    * @param flag The flag
    * @param subject The subject
    * @param contexts The contexts
    * @return The active flag value
    */
    default Tristate getActiveFlagPermissionValue(Flag flag, Subject subject, Set<Context> contexts) {
        return getActiveFlagPermissionValue(flag, subject, null, null, contexts, false);
    }

    /**
    * Gets the active {@link Flag} permission value for {@link Subject} in this {@link Claim}.
    * 
    * @param flag The flag
    * @param subject The subject
    * @param contexts The contexts
    * @param type The trust type
    * @return The active flag value
    */
    default Tristate getActiveFlagPermissionValue(Flag flag, Subject subject, Set<Context> contexts, TrustType type) {
        return getActiveFlagPermissionValue(flag, subject, null, null, contexts, type, false);
    }

    /**
    * Gets the active {@link Flag} permission value for {@link Subject} in this {@link Claim}.
    * 
    * @param flag The flag
    * @param subject The subject
    * @param contexts The contexts
    * @param checkOverride Whether to check override
    * @return The active flag value
    */
    default Tristate getActiveFlagPermissionValue(Flag flag, Subject subject, Set<Context> contexts, boolean checkOverride) {
        return getActiveFlagPermissionValue(flag, subject, null, null, contexts, null, checkOverride);
    }

    /**
    * Gets the active {@link Flag} permission value for {@link Subject} in this {@link Claim}.
    * 
    * @param flag The flag
    * @param subject The subject
    * @param contexts The contexts
    * @param type The trust type
    * @param checkOverride Whether to check override
    * @return The active flag value
    */
    default Tristate getActiveFlagPermissionValue(Flag flag, Subject subject, Set<Context> contexts, TrustType type, boolean checkOverride) {
        return getActiveFlagPermissionValue(flag, subject, null, null, contexts, type, checkOverride);
    }

    /**
    * Gets the active {@link Flag} permission value for {@link Subject} in this {@link Claim}.
    * 
    * @param flag The flag
    * @param subject The subject
    * @param source The source
    * @param target The target
    * @param contexts The contexts
    * @return The active flag value
    */
    default Tristate getActiveFlagPermissionValue(Flag flag, Subject subject, Object source, Object target, Set<Context> contexts) {
        return getActiveFlagPermissionValue(flag, subject, source, target, contexts, false);
    }

    /**
    * Gets the active {@link Flag} permission value for {@link Subject} in this {@link Claim}.
    * 
    * @param flag The flag
    * @param subject The subject
    * @param source The source
    * @param target The target
    * @param contexts The contexts
    * @param checkOverride Whether to check override
    * @return The active flag value
    */
    default Tristate getActiveFlagPermissionValue(Flag flag, Subject subject, Object source, Object target, Set<Context> contexts, boolean checkOverride) {
        return getActiveFlagPermissionValue(flag, subject, source, target, contexts, null, checkOverride);
    }

    /**
    * Gets the active {@link Flag} permission value for {@link Subject} in this {@link Claim}.
    * 
    * @param flag The flag
    * @param subject The subject
    * @param source The source
    * @param target The target
    * @param contexts The contexts
    * @param type The trust type
    * @param checkOverride Whether to check override
    * @return The active flag value
    */
    default Tristate getActiveFlagPermissionValue(Flag flag, Subject subject, Object source, Object target, Set<Context> contexts, TrustType type, boolean checkOverride) {
        return GriefDefender.getPermissionManager().getActiveFlagPermissionValue(this, subject, flag, source, target, contexts, type, checkOverride);
    }

    /**
     * Gets the {@link Flag} permission value with {@link Context}'s.
     * 
     * Note: This uses the default subject which applies to all users in claim.
     * 
     * @param flag The claim flag
     * @param target The target id
     * @param contexts The claim contexts
     * @return The permission value, or {@link Tristate#UNDEFINED} if none
     */
    default Tristate getFlagPermissionValue(Flag flag, Set<Context> contexts) {
        contexts.add(this.getContext());
        return GriefDefender.getPermissionManager().getFlagPermissionValue(flag, contexts);
    }

    /**
     * Sets {@link Flag} permission with {@link Context}'s.
     * 
     * Note: This uses the default subject which applies to all users in claim.
     * 
     * @param flag The claim flag
     * @param value The new value
     * @param contexts The claim contexts
     * @return The permission result future
     */
    default CompletableFuture<PermissionResult> setFlagPermission(Flag flag, Tristate value, Set<Context> contexts) {
        contexts.add(this.getContext());
        return GriefDefender.getPermissionManager().setFlagPermission(flag, value, contexts);
    }

    /**
     * Sets {@link Flag} permission on {@link Subject} with {@link Context}'s.
     * 
     * @param subject The subject
     * @param flag The claim flag
     * @param value The new value
     * @param contexts The claim contexts
     * @return The permission result future
     */
    default CompletableFuture<PermissionResult> setFlagPermission(Flag flag, Subject subject, Tristate value, Set<Context> contexts) {
        contexts.add(this.getContext());
        return GriefDefender.getPermissionManager().setFlagPermission(flag, subject, value, contexts);
    }

    /**
     * Set {@link FlagDefinition} in this {@link Claim}.
     * 
     * @param definition The flag definition
     * @param value The new value
     * @return The permission result future
     */
    default CompletableFuture<PermissionResult> setFlagDefinition(FlagDefinition definition, Tristate value) {
        return this.setFlagDefinition(GriefDefender.getCore().getDefaultFlagDefinitionGroup(), definition, value);
    }

    /**
     * Set {@link FlagDefinition} on {@link Subject} in this {@link Claim}.
     * 
     * @param subject The subject
     * @param definition The flag definition
     * @param value The new value
     * @return The permission result future
     */
    CompletableFuture<PermissionResult> setFlagDefinition(Subject subject, FlagDefinition definition, Tristate value);

    /**
     * Set {@link OptionDefinition} in this {@link Claim}.
     * 
     * @param definition The option definition
     * @param value The new value
     * @return The permission result future
     */
    default CompletableFuture<PermissionResult> setOptionDefinition(OptionDefinition definition, String value) {
        return this.setOptionDefinition(GriefDefender.getCore().getDefaultOptionDefinitionGroup(), definition, value);
    }

    /**
     * Set {@link OptionDefinition} on {@link Subject} in this {@link Claim}.
     * 
     * @param subject The subject
     * @param definition The option definition
     * @param value The new value
     * @return The permission result future
     */
    CompletableFuture<PermissionResult> setOptionDefinition(Subject subject, OptionDefinition definition, String value);

    /**
    * Gets the active {@link Option} value with {@link Context}'s in this {@link Claim}.
    * 
    * @param type The option type
    * @param option The option
    * @param claim The claim
    * @param contexts The contexts
    * @return The active option value
    */
    default <T> T getActiveOptionValue(TypeToken<T> type, Option<T> option, Set<Context> contexts) {
        return getActiveOptionValue(type, option, GriefDefender.getCore().getDefaultSubject(), contexts);
    }

    /**
    * Gets the active {@link Option} value for with {@link Context}'s  in this {@link Claim}.
    * 
    * @param type The option type
    * @param option The option
    * @param subject The subject
    * @param claim The claim
    * @param contexts The contexts
    * @return The active option value
    */
    default <T> T getActiveOptionValue(TypeToken<T> type, Option<T> option, Subject subject, Set<Context> contexts) {
        contexts.add(this.getContext());
        return GriefDefender.getPermissionManager().getActiveOptionValue(type, option, subject, this, contexts);
    }

    /**
    * Gets the {@link Option} value with {@link Context}'s in this {@link Claim}.
    * 
    * @param option The option
    * @param claim The claim
    * @param contexts The contexts
    * @return The option value
    */
    default String getOptionValue(Option<?> option, Set<Context> contexts) {
        return getOptionValue(option, GriefDefender.getCore().getDefaultSubject(), contexts);
    }

    /**
    * Gets the {@link Option} value with {@link Context}'s in this {@link Claim}.
    * 
    * @param option The option
    * @param subject The subject
    * @param claim The claim
    * @param contexts The contexts
    * @return The option value
    */
    String getOptionValue(Option<?> option, Subject subject, Set<Context> contexts);

    /**
     * Gets the active {@link OptionDefinition} value in this {@link Claim}.
     * 
     * @param definition The option definition
     * @return The active value
     */
    default String getActiveOptionDefinitionValue(OptionDefinition definition) {
        return this.getActiveOptionDefinitionValue(GriefDefender.getCore().getDefaultOptionDefinitionGroup(), definition);
    }

    /**
     * Gets the active {@link OptionDefinition} value in this {@link Claim}.
     * 
     * @param definition The option definition
     * @return The active value
     */
    String getActiveOptionDefinitionValue(Subject subject, OptionDefinition definition);

    /**
     * Sets {@link Option} value with {@link Context}'s.
     * 
     * Note: This uses the default subject which applies to all users in claim.
     * 
     * @param option The option
     * @param value The new value
     * @param contexts The claim contexts
     * @return The permission result future
     */
    default CompletableFuture<PermissionResult> setOption(Option option, String value, Set<Context> contexts) {
        return this.setOption(option, GriefDefender.getCore().getDefaultSubject(), value, contexts);
    }

    /**
     * Sets {@link Option} value on {@link Subject} with {@link Context}'s.
     * 
     * @param option The option
     * @param subject The subject
     * @param value The new value
     * @param contexts The claim contexts
     * @return The permission result future
     */
    default CompletableFuture<PermissionResult> setOption(Option option, Subject subject, String value, Set<Context> contexts) {
        contexts.add(this.getContext());
        return GriefDefender.getPermissionManager().setOption(option, subject, value, contexts);
    }

    /**
     * Gets the default context which is used for storing flag defaults.
     * 
     * @return The default context
     */
    Context getDefaultTypeContext();

    /**
     * Gets the override context which is used for overriding claim flags.
     * 
     * @return The override context
     */
    Context getOverrideTypeContext();

    /**
     * Gets a new claim builder instance for {@link Builder}.
     * 
     * @return A new claim builder instance
     */
    public static Claim.Builder builder() {
        return GriefDefender.getRegistry().createBuilder(Claim.Builder.class);
    }

    public interface Builder {

        /**
         * The position bounds of claim.
         * 
         * @param p1 The lesser boundary position
         * @param p2 The greater boundary position
         * @return The builder
         */
        default Builder bounds(Vector3i p1, Vector3i p2) {
            return this.bounds(p1.getX(), p2.getX(), p1.getY(), p2.getY(), p1.getZ(), p2.getZ());
        }

        /**
         * The position bounds of claim.
         * 
         * @param x1 The start X-axis position
         * @param x2 The end X-axis position
         * @param y1 The start Y-axis position
         * @param y2 The end Y-axis position
         * @param z1 The start Z-axis position
         * @param z2 The end Z-axis position
         * @return The builder
         */
        Builder bounds(int x1, int x2, int y1, int y2, int z1, int z2);

        /**
         * Toggles whether this claim is cuboid
         * 
         * @param cuboid Whether claim is cuboid
         * @return The builder
         */
        Builder cuboid(boolean cuboid);

        /**
         * The source creating this {@link Claim}.
         * 
         * @param source The source creating claim
         * @return The builder
         */
        Builder source(Object source);

        /**
         * The owner of claim.
         * 
         * Note: {@link ClaimType#ADMIN} does not use owners.
         * 
         * @param ownerUniqueId The claim owner UUID, if available
         * @return The builder
         */
        Builder owner(UUID ownerUniqueId);

        /**
         * The claim type.
         * 
         * @param type The claim type
         * @return The builder
         */
        Builder type(ClaimType type);

        /**
         * The claim attributes.
         * 
         * @param attributes The claim attributes
         * @return The builder
         */
        Builder attributes(Set<ClaimAttribute> attributes);

        /**
         * The world to add claim into.
         * 
         * @param world The world
         * @return The builder
         */
        Builder world(UUID worldUniqueId);

        /**
         * The parent claim.
         * 
         * Note: This is required when adding a child claim
         * to an existing parent.
         * 
         * @param parent The parent, if available
         * @return The builder
         */
        Builder parent(Claim parent);

        /**
         * Toggles whether this claim allows deny messages to be sent to
         * players. If false, no deny messages will be sent.
         * 
         * @param allowDeny Whether to allow sending deny messages to players
         * @return The builder
         */
        Builder denyMessages(boolean allowDeny);

        /**
         * Toggles whether this claim can expire due to no activity.
         * 
         * @param allowExpire Whether this claim can expire
         * @return The builder
         */
        Builder expire(boolean allowExpire);

        /**
         * Sets the farewell message when a player exits the claim.
         * 
         * @param farewell The farewell message
         * @return The builder
         */
        Builder farewell(Component farewell);

        /**
         * Sets the greeting message when a player exits the claim.
         * 
         * @param greeting The greeting message
         * @return The builder
         */
        Builder greeting(Component greeting);

        /**
         * Toggles whether this claim is inheriting from parent claim.
         * 
         * @param inherit Whether claim inherits from parent
         * @return The builder
         */
        Builder inherit(boolean inherit);

        /**
         * Sets if this claim requires claim blocks from players.
         * 
         * Note: This is true by default.
         * 
         * @param requireClaimBlocks Whether this claim requires claim blocks
         * @return The builder
         */
        Builder requireClaimBlocks(boolean requireClaimBlocks);

        /**
         * Toggles whether this claim is resizable.
         * 
         * @param allowResize Whether claim can be resized.
         */
        Builder resizable(boolean allowResize);

        /**
         * Whether to check {@link PlayerData#getCreateClaimLimit()}.
         * 
         * @param checkLimit Whether to check for claim creation restrictions.
         * @return The builder
         */
        Builder createLimitRestrictions(boolean checkLimit);

        /**
         * Whether to check {@link PlayerData#getMinClaimLevel()} and 
         * {@link PlayerData#getMaxClaimLevel()}.
         * 
         * @param checkLevel Whether to check for level restrictions.
         * @return The builder
         */
        Builder levelRestrictions(boolean checkLevel);

        /**
         * Whether to check for min/max size restrictions.
         * 
         * @param checkSize Whether to check for size restrictions.
         * @return The builder
         */
        Builder sizeRestrictions(boolean checkSize);

        /**
         * The spawn position of this claim.
         * 
         * @param pos The spawn position
         * @return The builder
         */
        default Builder spawnPos(Vector3i pos) {
            return this.spawnPos(pos.getX(), pos.getY(), pos.getZ());
        }

        /**
         * The spawn position of this claim.
         * 
         * @param x X coordinate
         * @param y Y coordinate
         * @param z Z coordinate
         * @return The builder
         */
        Builder spawnPos(int x, int y, int z);

        /**
         * Resets the builder to default settings.
         * 
         * @return The builder
         */
        Builder reset();

        /**
         * Returns the {@link ClaimResult}.
         * 
         * @return The claim result
         */
        ClaimResult build();
    }
}
