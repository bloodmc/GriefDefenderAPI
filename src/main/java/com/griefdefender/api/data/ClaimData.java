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

import com.flowpowered.math.vector.Vector3i;
import com.griefdefender.api.GriefDefender;
import com.griefdefender.api.claim.Claim;
import com.griefdefender.api.claim.ClaimType;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.Title;

import java.time.Instant;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 * Represents the persisted data of a claim.
 */
public interface ClaimData extends ClaimDataGetter {

    /**
     * Sets the name of claim.
     * 
     * @param name The claim name
     */
    void setName(Component name);

    /**
     * Sets the owner {@link UUID} of claim.
     * 
     * @param ownerUniqueId The owner uuid
     */
    void setOwnerUniqueId(UUID ownerUniqueId);

    /**
     * Sets the {@link ClaimType}.
     * 
     * @param type The claim type
     */
    void setType(ClaimType type);

    /**
     * Sets the farewell message when a player exits the claim.
     * 
     * @param farewell The farewell message
     */
    void setFarewell(Component farewell);

    /**
     * Sets the greeting message when a player enters the claim.
     * 
     * @param greeting The greeting message
     */
    void setGreeting(Component greeting);

    /**
     * Sets the {@link Title} when a player enters the claim.
     * 
     * @param title The enter title
     */
    void setEnterTitle(Title title);

    /**
     * Sets the {@link Title} when a player exits the claim.
     * 
     * @param title The exit title
     */
    void setExitTitle(Title title);

    /**
     * Sets last active date of claim.
     * 
     * Note: The date is used to determine whether the claim expires
     * based on expiration settings.
     * 
     * @param date The last active date
     */
    void setDateLastActive(Instant date);

    /**
     * Toggles whether this claim is inheriting from parent claim.
     * 
     * @param inherit Whether claim inherits from parent
     */
    void setInheritParent(boolean inherit);

    /**
     * Toggles whether this claim is resizable.
     * 
     * @param allowResize Whether claim can be resized.
     */
    void setResizable(boolean allowResize);

    /**
     * Toggles whether this claim is a cuboid.
     * 
     * @param cuboid Whether claim is a cuboid
     */
    void setCuboid(boolean cuboid);

    /**
     * Toggles whether this claim allows deny messages to be sent to
     * players. If false, no deny messages will be sent.
     * 
     * @param allowDenyMessages Whether to allow sending deny messages to players
     */
    void setDenyMessages(boolean allowDenyMessages);

    /**
     * Toggles whether this claim can expire due to no player activity.
     * 
     * @param allowExpire Whether this claim allows expirations
     */
    void setExpiration(boolean allowExpire);

    /**
     * Toggles whether this claim should allow flag overrides.
     * 
     * @param allowOverrides Whether this claim allows flag overrides
     */
    void setFlagOverrides(boolean allowOverrides);

    /**
     * Sets the parent {@link UUID}.
     * 
     * @param uniqueId The parent uuid
     */
    void setParent(UUID uniqueId);

    /**
     * Sets if this claim requires claim blocks from players.
     * 
     * Note: This is true by default.
     * 
     * @param requiresClaimBlocks Whether this claim requires claim blocks
     */
    void setRequiresClaimBlocks(boolean requiresClaimBlocks);

    /**
     * Sets if this claim checks for min/max size restrictions.
     * 
     * Note: {@link ClaimType#ADMIN} and {@link ClaimType#WILDERNESS} can not have restrictions.
     * 
     * @param sizeRestrictions Whether this claim checks size restrictions.
     */
    void setSizeRestrictions(boolean sizeRestrictions);

    /**
     * Sets the trusted accessor set of {@link UUID}'s.
     * 
     * @param The set of accessor uuid's
     */
    void setAccessors(Set<UUID> accessors);

    /**
     * Sets the trusted builder set of {@link UUID}'s.
     * 
     * @param The set of builder uuid's
     */
    void setBuilders(Set<UUID> builders);

    /**
     * Sets the trusted container set of {@link UUID}'s.
     * 
     * @param The set of container uuid's
     */
    void setContainers(Set<UUID> containers);

    /**
     * Sets the trusted manager set of {@link UUID}'s.
     * 
     * @param The set of manager uuid's
     * @return The builder
     */
    void setManagers(Set<UUID> managers);

    /**
     * Sets the trusted accessor group set of {@link UUID}'s.
     * 
     * @param The set of accessor group uuid's
     */
    void setAccessorGroups(Set<String> accessorGroups);

    /**
     * Sets the trusted builder group set of {@link UUID}'s.
     * 
     * @param The set of builder group uuid's
     */
    void setBuilderGroups(Set<String> builderGroups);

    /**
     * Sets the trusted container group set of {@link UUID}'s.
     * 
     * @param The set of container group uuid's
     */
    void setContainerGroups(Set<String> containerGroups);

    /**
     * Sets the trusted manager group set of {@link UUID}'s.
     * 
     * @param The set of manager group uuid's
     */
    void setManagerGroups(Set<String> managerGroups);

    /**
     * Saves all changes to storage.
     */
    void save();

    /**
     * Gets a new claim data builder instance for {@link Builder}.
     * 
     * @return A new claim data builder instance
     */
    public static ClaimData.Builder builder() {
        return GriefDefender.getRegistry().createBuilder(ClaimData.Builder.class);
    }

    public interface Builder {

        /**
         * Gets the claim's display name {@link Component}.
         * 
         * @return The display name component, if available
         */
        Optional<Component> getDisplayNameComponent();

        /**
         * Gets the {@link ClaimType} of claim.
         * 
         * @return The claim type
         */
        Optional<ClaimType> getType();

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
         * Gets the claim's enter title.
         * 
         * @return The enter title, if available
         */
        Optional<Title> getEnterTitle();

        /**
         * Gets the claim's exit title.
         * 
         * @return The exit title, if available
         */
        Optional<Title> getExitTitle();

        /**
         * Gets whether the snapshot is inheriting from parent claim.
         * 
         * @return If snapshot is set to inherit from parent
         */
        boolean getInherit();

        /**
         * Gets whether the snapshot allows resize.
         * 
         * @return If resizeable
         */
        boolean getResizable();

        /**
         * Gets whether the snapshot allows flag overrides.
         * 
         * @return Whether flag overrides are allowed
         */
        boolean getOverrides();

        /**
         * Gets whether the snapshot allows sending deny messages
         * to players.
         * 
         * @return Whether deny messages are being sent to players
         */
        boolean getDenyMessages();

        /**
         * Gets whether snapshot can expire.
         * 
         * @return If snapshot can expire
         */
        boolean getExpiration();

        /**
         * Gets whether this snapshot requires claim blocks.
         * 
         * @return Whether snapshot requires claim blocks
         */
        boolean getClaimBlocks();

        /**
         * Gets whether this snapshot has min/max size restrictions.
         * 
         * @return Whether snapshot has size restrictions
         */
        boolean getSizeRestrictions();

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

        /**
         * The claim to use for snapshot.
         * 
         * @param claim The claim
         * @return The builder
         */
        Builder from(Claim claim);

        /**
         * The claim name.
         * 
         * @param name The claim name
         * @return The builder
         */
        Builder name(Component name);

        /**
         * The claim {@link ClaimType} the snapshot is based on.
         * 
         * @param type The claim type
         * @return The builder
         */
        Builder claimType(ClaimType type);

        /**
         * The greeting message.
         * 
         * @param greeting
         * @return The builder
         */
        Builder greeting(Component greeting);

        /**
         * The farewell message.
         * 
         * @param farewell
         * @return The builder
         */
        Builder farewell(Component farewell);

        /**
         * The enter title.
         * 
         * @param title
         * @return The builder
         */
        Builder enterTitle(Title title);

        /**
         * The exit title.
         * 
         * @param title
         * @return The builder
         */
        Builder exitTitle(Title title);

        /**
         * Whether claim should inherit from parent
         * 
         * @param inherit Whether claim inherits from parent
         * @return The builder
         */
        Builder inherit(boolean inherit);

        /**
         * Whether claim should be resizable
         * 
         * @param resizable Whether claim can be resized.
         * @return The builder
         */
        Builder resizable(boolean resizable);

        /**
         * Whether claim allows deny messages to be sent to players.
         * 
         * @param denyMessages Whether to allow sending deny messages to players
         * @return The builder
         */
        Builder denyMessages(boolean denyMessages);

        /**
         * Whether claim can expire due to no player activity.
         * 
         * @param expiration Whether claim allows expirations
         * @return The builder
         */
        Builder expiration(boolean expiration);

        /**
         * Whether claim should allow flag overrides.
         * 
         * @param overrides Whether claim allows flag overrides
         * @return The builder
         */
        Builder overrides(boolean overrides);

        /**
         * Whether claim requires claim blocks from players.
         * 
         * @param claimBlocks Whether this claim requires claim blocks
         * @return The builder
         */
        Builder claimBlocks(boolean claimBlocks);

        /**
         * Whether claim checks for min/max size restrictions.
         * 
         * Note: {@link ClaimType#ADMIN} and {@link ClaimType#WILDERNESS} can not have restrictions.
         * 
         * @param sizeRestrictions Whether this claim checks size restrictions.
         * @return The builder
         */
        Builder sizeRestrictions(boolean sizeRestrictions);

        /**
         * The trusted accessor set of {@link UUID}'s.
         * 
         * @param The set of accessor uuid's
         * @return The builder
         */
        Builder accessors(Set<UUID> accessors);

        /**
         * The trusted builder set of {@link UUID}'s.
         * 
         * @param The set of builder uuid's
         * @return The builder
         */
        Builder builders(Set<UUID> builders);

        /**
         * The trusted container set of {@link UUID}'s.
         * 
         * @param The set of container uuid's
         * @return The builder
         */
        Builder containers(Set<UUID> containers);

        /**
         * The trusted manager set of {@link UUID}'s.
         * 
         * @param The set of manager uuid's
         * @return The builder
         */
        Builder managers(Set<UUID> managers);

        /**
         * The trusted accessor group set of {@link UUID}'s.
         * 
         * @param The set of accessor group uuid's
         * @return The builder
         */
        Builder accessorGroups(Set<String> accessorGroups);

        /**
         * The trusted builder group set of {@link UUID}'s.
         * 
         * @param The set of builder group uuid's
         * @return The builder
         */
        Builder builderGroups(Set<String> builderGroups);

        /**
         * The trusted container group set of {@link UUID}'s.
         * 
         * @param The set of container group uuid's
         * @return The builder
         */
        Builder containerGroups(Set<String> containerGroups);

        /**
         * The trusted manager group set of {@link UUID}'s.
         * 
         * @param The set of manager group uuid's
         * @return The builder
         */
        Builder managerGroups(Set<String> managerGroups);

        /**
         * Resets the builder to default settings.
         * 
         * @return The builder
         */
        Builder reset();

        /**
         * Returns the {@link ClaimData}.
         * 
         * @return The created claim data
         */
        ClaimData build();
    }
}
