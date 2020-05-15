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
import com.google.common.reflect.TypeToken;
import com.griefdefender.api.ContextSource;
import com.griefdefender.api.GriefDefender;
import com.griefdefender.api.Subject;
import com.griefdefender.api.Tristate;
import com.griefdefender.api.data.ClaimData;
import com.griefdefender.api.data.EconomyData;
import com.griefdefender.api.data.PlayerData;
import com.griefdefender.api.permission.Context;
import com.griefdefender.api.permission.PermissionResult;
import com.griefdefender.api.permission.flag.Flag;
import com.griefdefender.api.permission.option.Option;

import net.kyori.text.Component;

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
     * @return The name of claim owner, if available
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
     * Gets the claim's parent.
     * 
     * @return The parent claim, if available
     */
    Optional<Claim> getParent();

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
        return changeType(type, Optional.empty());
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
    ClaimResult changeType(ClaimType type, Optional<UUID> owner);

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
     * Gets an immutable list of all trusted users.
     * 
     * @return An immutable list of all trusted users
     */
    List<UUID> getUserTrusts();

    /**
     * Gets an immutable list of trusted users for {@link TrustType}.
     * 
     * @return An immutable list of trusted users
     */
    List<UUID> getUserTrusts(TrustType type);

    /**
     * Gets an immutable list of all trusted groups.
     * 
     * @return An immutable list of all trusted groups
     */
    List<String> getGroupTrusts();

    /**
     * Gets an immutable list of trusted groups for {@link TrustType}.
     * 
     * @return An immutable list of trusted groups
     */
    List<String> getGroupTrusts(TrustType type);

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
     * Grants claim trust to the UUID for given {@link TrustType}.
     * 
     * @param uuid The UUID of user
     * @param type The trust type
     * @return The claim result
     */
    ClaimResult addUserTrust(UUID uuid, TrustType type);

    /**
     * Grants claim trust to the list of UUID's for given {@link TrustType}.
     * 
     * @param uuid The list of user UUID's
     * @param type The trust type
     * @return The claim result
     */
    ClaimResult addUserTrusts(List<UUID> uuid, TrustType type);

    /**
     * Removes UUID from claim trust for given {@link TrustType}.
     * 
     * @param uuid The UUID of user
     * @param type The trust type
     * @return The claim result
     */
    ClaimResult removeUserTrust(UUID uuid, TrustType type);

    /**
     * Removes the list of UUID's from claim trust for given {@link TrustType}.
     * 
     * @param uuid The list of user UUID's
     * @param type The trust type
     * @return The claim result
     */
    ClaimResult removeUserTrusts(List<UUID> uuid, TrustType type);

    /**
     * Grants claim trust to the group for given {@link TrustType}.
     * 
     * @param group The group
     * @param type The trust type
     * @return The claim result
     */
    ClaimResult addGroupTrust(String group, TrustType type);

    /**
     * Grants claim trust to the list of groups for given {@link TrustType}.
     * 
     * @param groups The list of groups
     * @param type The trust type
     * @return The claim result
     */
    ClaimResult addGroupTrusts(List<String> groups, TrustType type);

    /**
     * Removes a group from claim trust for given {@link TrustType}.
     * 
     * @param group The group
     * @param type The trust type
     * @return The claim result
     */
    ClaimResult removeGroupTrust(String group, TrustType type);

    /**
     * Removes the list of UUID's from claim trust for given {@link TrustType}.
     * 
     * @param groups The list of groups
     * @param type The trust type
     * @return The claim result
     */
    ClaimResult removeGroupTrusts(List<String> groups, TrustType type);

    /**
     * Checks if the {@link UUID} is able to build in claim.
     * 
     * @param uuid The uuid to check
     * @return Whether the uuid is trusted
     */
    default boolean isTrusted(UUID uuid) {
        return this.isUserTrusted(uuid, TrustTypes.BUILDER);
    }

    /**
     * Checks if the {@link UUID} is trusted with given {@link TrustType}.
     * 
     * @param uuid The uuid to check
     * @param type The minimum trust required
     * @return Whether the uuid is trusted
     */
    boolean isUserTrusted(UUID uuid, TrustType type);

    /**
     * Checks if the group is trusted in claim.
     * 
     * @param group The group to check
     * @return Whether the group is trusted
     */
    default boolean isGroupTrusted(String group) {
        return isGroupTrusted(group, TrustTypes.BUILDER);
    }

    /**
     * Checks if the group is trusted with given {@link TrustType}.
     * 
     * @param group The group to check
     * @param type The minimum trust required
     * @return Whether the group is trusted
     */
    boolean isGroupTrusted(String group, TrustType type);

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
    Optional<Claim> getTown();

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
     * Deletes the specified schematic if it exists.
     * 
     * @param name The schematic to delete
     * @return true if the schematic was deleted
     */
    boolean deleteSchematic(String schematic);

    /**
     * Gets a map of currently stored schematics.
     * 
     * @return The map of schematics, empty if none
     */
    Map<String, ClaimSchematic> getSchematics();

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
     * Gets the claim's name.
     * 
     * @return The name of claim, if available
     */
    default Optional<Component> getName() {
        return this.getData().getName();
    }

    default EconomyData getEconomyData() {
        return this.getData().getEconomyData();
    }

    /**
     * Gets the economy account used for claim bank.
     * 
     * @return the economy account, if available
     */
    Optional<UUID> getEconomyAccountId();

    /**
    * Gets the active {@link Flag} permission value for {@link Subject} in this {@link Claim}.
    * 
    * @param flag The flag
    * @param subject The subject
    * @param contexts The contexts
    * @return
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
    * @return
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
    * @return
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
    * @return
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
    * @return
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
    * @return
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
    * @return
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
     * @return The result of set
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
     * @return The result of set
     */
    default CompletableFuture<PermissionResult> setFlagPermission(Flag flag, Subject subject, Tristate value, Set<Context> contexts) {
        contexts.add(this.getContext());
        return GriefDefender.getPermissionManager().setFlagPermission(flag, subject, value, contexts);
    }

    /**
    * Gets the active {@link Option} value with {@link Context}'s in this {@link Claim}.
    * 
    * @param type The option type
    * @param option The option
    * @param claim The claim
    * @param contexts The contexts
    * @return
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
    * @return
    */
    default <T> T getActiveOptionValue(TypeToken<T> type, Option<T> option, Subject subject, Set<Context> contexts) {
        contexts.add(this.getContext());
        return GriefDefender.getPermissionManager().getActiveOptionValue(type, option, subject, this, contexts);
    }

    /**
     * Sets {@link Option} value with {@link Context}'s.
     * 
     * Note: This uses the default subject which applies to all users in claim.
     * 
     * @param option The option
     * @param value The new value
     * @param contexts The claim contexts
     * @return The result of set
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
     * @return The result of set
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
     * Gets the override context which is used for overriding claim flags.
     * 
     * @return The override context
     */
    Context getOverrideClaimContext();

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
         * Toggles whether this claim should allow flag overrides.
         * 
         * @param allowOverrides Whether this claim allows flag overrides
         * @return The builder
         */
        Builder overrides(boolean allowOverrides);

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
