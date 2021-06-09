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

import java.time.Instant;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.checkerframework.checker.nullness.qual.Nullable;

import com.flowpowered.math.vector.Vector3i;
import com.griefdefender.api.claim.ClaimGroupType;
import com.griefdefender.api.claim.ClaimType;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.Title;

public interface ClaimDataGetter {

    /** Gets the claim's world {@link UUID}.
     * 
     * Note: This will return null if tied to a {@link ClaimSnapshot} 
     * as it is not locatable.
     * 
     * @return The world UUID
     */
    @Nullable UUID getWorldUniqueId();

    /**
     * Gets the lesser boundary corner of claim.
     * 
     * Note: This will return null if tied to a {@link ClaimSnapshot} 
     * as it is not locatable.
     * 
     * @return The lesser boundary corner position, if available
     */
    @Nullable Vector3i getLesserBoundaryCorner();

    /**
     * Gets the greater boundary corner of claim.
     * 
     * Note: This will return null if tied to a {@link ClaimSnapshot} 
     * as it is not locatable.
     * 
     * @return The greater boundary corner position, if available
     */
    @Nullable Vector3i getGreaterBoundaryCorner();

    /**
     * Gets the spawn position of claim.
     * 
     * Note: This will return null if tied to a {@link ClaimSnapshot} 
     * as it is not locatable.
     * 
     * @return The spawn position, if available
     */
    @Nullable Vector3i getSpawnPos();

    /**
     * Gets the claim group uuid this claim is joined to.
     * 
     * @return The claim group uuid, or null if not joined to one
     */
    @Nullable UUID getClaimGroupUniqueId();

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
    @Nullable String getDisplayName();

    /**
     * Gets the {@link ClaimType} of claim.
     * 
     * @return The claim type
     */
    ClaimType getType();

    /**
     * Gets the parent claim {@link UUID}.
     * 
     * @return The parent claim UUID, if available
     */
    @Nullable UUID getParentUniqueId();

    /**
     * Gets the claim owner's {@link UUID}.
     * 
     * Note: {@link ClaimType#ADMIN} and {@link ClaimType#WILDERNESS} claims do not have
     * owners.
     * 
     * @return The UUID of this claim
     */
    @Nullable UUID getOwnerUniqueId();

    /**
     * Gets the claim's greeting message.
     * 
     * @return The greeting message, if available
     */
    Optional<Component> getGreeting();

    /**
     * Gets the claim's farewell message.
     * 
     * @return The farewell message, if available
     */
    Optional<Component> getFarewell();

    /**
     * Gets the claim's enter action bar message.
     * 
     * @return The enter action bar message, if available
     */
    Optional<Component> getEnterActionBar();

    /**
     * Gets the claim's exit action bar message.
     * 
     * @return The exit action bar message, if available
     */
    Optional<Component> getExitActionBar();

    /**
     * Gets the claim's enter {@link Title}.
     * 
     * @return The claim's enter title, if available.
     */
    Optional<Title> getEnterTitle();

    /**
     * Gets the claim's exit {@link Title}.
     * 
     * @return The claim's exit title, if available.
     */
    Optional<Title> getExitTitle();

    /**
     * Gets the creation date of claim.
     * 
     * @return The date created
     */
    Instant getDateCreated();

    /**
     * Gets the last active date of claim.
     * 
     * @return The last active date
     */
    Instant getDateLastActive();

    /**
     * Gets whether the claim allows sending deny messages
     * to players.
     * 
     * @return Whether deny messages are being sent to players
     */
    boolean allowDenyMessages();

    /**
     * Gets whether the claim allows flag overrides.
     * 
     * @return Whether flag overrides are allowed
     */
    boolean allowFlagOverrides();

    /**
     * Gets whether claim can expire.
     * 
     * @return If claim can expire
     */
    boolean allowExpiration();

    /**
     * Gets whether claim is a 3D cuboid.
     * 
     * @return True if 3D cuboid, false if not
     */
    boolean isCuboid();

    /**
     * Gets whether this claim is inheriting from parent claim.
     * 
     * @return If claim inherits from parent
     */
    boolean doesInheritParent();

    /**
     * Gets whether this claim can be resized.
     * 
     * @return If resizeable
     */
    boolean isResizable();

    /**
     * Gets whether this claim has been expired.
     * 
     * Note: All claim actions are denied while in this state.
     * 
     * @return
     */
    boolean isExpired();

    /**
     * Gets whether this claim requires claim blocks.
     * 
     * @return Whether claim requires claim blocks
     */
    boolean requiresClaimBlocks();

    /**
     * Gets whether this claim has min/max size restrictions.
     * 
     * @return Whether claim has size restrictions
     */
    boolean hasSizeRestrictions();

    /**
     * Gets the {@link ClanData}.
     * 
     * @return The clan data, if available
     */
    @Nullable ClanData getClanData();

    /**
     * Gets the {@link EconomyData}
     * 
     * The economy data, if available
     */
    @Nullable EconomyData getEconomyData();

    /**
     * Gets the trusted accessor set of {@link UUID}'s.
     * 
     * @return The mutable accessor uuid set
     */
    Set<UUID> getAccessors();

    /**
     * Gets the trusted builder set of {@link UUID}'s.
     * 
     * @return The mutable builder uuid set
     */
    Set<UUID> getBuilders();

    /**
     * Gets the trusted container set of {@link UUID}'s.
     * 
     * @return The mutable container uuid set
     */
    Set<UUID> getContainers();

    /**
     * Gets the trusted manager set of {@link UUID}'s.
     * 
     * @return The mutable manager uuid set
     */
    Set<UUID> getManagers();

    /**
     * Gets the trusted accessor group set of {@link UUID}'s.
     * 
     * @return The mutable accessor group uuid set
     */
    Set<String> getAccessorGroups();

    /**
     * Gets the trusted builder group set of {@link UUID}'s.
     * 
     * @return The mutable builder group uuid set
     */
    Set<String> getBuilderGroups();

    /**
     * Gets the trusted container group set of {@link UUID}'s.
     * 
     * @return The mutable container group uuid set
     */
    Set<String> getContainerGroups();

    /**
     * Gets the trusted manager group set of {@link UUID}'s.
     * 
     * @return The mutable manager group uuid set
     */
    Set<String> getManagerGroups();
}
