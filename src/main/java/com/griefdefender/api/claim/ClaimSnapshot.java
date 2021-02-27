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

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.checkerframework.checker.nullness.qual.Nullable;

import com.griefdefender.api.GriefDefender;
import com.griefdefender.api.data.ClaimDataGetter;
import com.griefdefender.api.permission.Context;

import net.kyori.adventure.text.Component;

public interface ClaimSnapshot {

    /**
     * Gets the name of the snapshot.
     * 
     * @return The snapshot name
     */
    String getName();

    /**
     * Gets the creation date of snapshot.
     * 
     * @return The snapshot creation date
     */
    Instant getDateCreated();

    /**
     * Gets the snapshot description {@link Component}.
     * 
     * @return The snapshot description, if available
     */
    @Nullable Component getDescription();

    /**
     * Gets creator claim's {@link UUID}
     * 
     * @return The creator claim unique identifer
     */
    @Nullable UUID getCreatorUniqueId();

    /**
     * Gets a {@link ClaimDataGetter}.
     * 
     * @return The claim data
     */
    ClaimDataGetter getClaimData();

    /**
     * Gets an immutable map of children snapshots.
     * 
     * @return The immutable map of children snapshots
     */
    Map<UUID, ClaimSnapshot> getChildrenSnapshots();

    /**
     * Gets the flag permissions stored in snapshot.
     * 
     * Note: Key is identifier of permission holder
     * Note: Value is a map with key containing permission:value and value 
     * containing set of contexts attached to permission
     * 
     * @return The immutable permission map
     */
    Map<String, Map<Set<Context>, Map<String, Boolean>>> getPermissions();

    /**
     * Gets the options stored in snapshot.
     * 
     * Note: Key is identifier of permission holder
     * Note: Value is a map with key containing option:value and value 
     * containing set of contexts attached to option
     * 
     * @return The immutable option map
     */
    Map<String, Map<Set<Context>, Map<String, List<String>>>> getOptions();

    /**
     * Applies snapshot to creator claim.
     * 
     * <br><br>Note: This will automatically apply all
     * children snapshots that are part of this snapshot.
     * 
     * @return If snapshot apply was successful, false if not
     */
    default boolean applyToCreator() {
        return this.applyToCreator(true);
    }

    /**
     * Applies snapshot to creator claim.
     * 
     * @param includeChildren True to include children snapshots, false if not
     * @return If snapshot apply was successful, false if not
     */
    boolean applyToCreator(boolean includeChildren);

    /**
     * Applies snapshot to creator claim.
     * 
     * @param includeChildren True to include children snapshots, false if not
     * @return If snapshot apply was successful, false if not
     */
    boolean applyToCreator(SnapshotApplySettings applySettings, boolean includeChildren);

    /**
     * Applies snapshot to specified claim.
     * 
     * @return If snapshot apply was successful, false if not
     */
    boolean apply(Claim claim);

    /**
     * Applies snapshot to specified claim.
     * 
     * @return If snapshot apply was successful, false if not
     */
    boolean apply(Claim claim, SnapshotApplySettings applySettings);

    /**
     * Gets a new claim snapshot builder instance for {@link Builder}.
     * 
     * @return A new claim snapshot builder instance
     */
    public static ClaimSnapshot.Builder builder() {
        return GriefDefender.getRegistry().createBuilder(ClaimSnapshot.Builder.class);
    }

    public interface Builder {

        /**
         * Gets the name of the snapshot.
         * 
         * @return The current snapshot name
         */
        String getName();

        /**
         * Gets the snapshot description {@link Component}.
         * 
         * @return The snapshot description, if available
         */
        @Nullable Component getDescription();

        /**
         * Gets the creator claim's {@link UUID}
         * 
         * @return The creator claim unique identifer, if available
         */
        @Nullable UUID getCreatorClaimUniqueId();

        /**
         * Gets the {@link ClaimDataGetter}.
         * 
         * @return The claim data
         */
        ClaimDataGetter getClaimData();

        /**
         * Gets the set of children claim unique uuid's
         * included in this snapshot.
         * 
         * @return The set of children uuid's or empty snapshot if none
         */
        Set<UUID> getChildrenUniqueIds();

        /**
         * Whether children are included in this snapshot.
         * 
         * @return True if included, false if not
         */
        boolean includeChildren();

        /**
         * Gets the flag permissions stored in snapshot.
         * 
         * Note: Key is a context containing permission:value
         * Note: Value is a set of contexts attached to permission
         * 
         * @return The mutable permission map
         */
        Map<String, Map<Set<Context>, Map<String, Boolean>>> getPermissions();

        /**
         * Gets the options stored in snapshot.
         * 
         * Note: Key is a context containing option:value
         * Note: Value is a set of contexts attached to permission
         * 
         * @return The mutable option map
         */
        Map<String, Map<Set<Context>, Map<String, List<String>>>> getOptions();

        /**
         * The claim to use for snapshot.
         * 
         * Note: This will copy claim data, economy data, permissions, and options.
         * It will not set the {@link #claimUniqueId(UUID)
         * 
         * @param claim The claim
         * @param children True to include children with snapshot, false if not
         * @return The builder
         */
        Builder from(Claim claim, boolean children);

        /**
         * The snapshot name.
         * 
         * @param name The snapshot name
         * @return The builder
         */
        Builder name(String name);

        /**
         * The {@link Component} description of snapshot.
         * 
         * @param description The description
         * @return The snapshot description
         */
        Builder description(Component description);

        /**
         * The claim {@link UUID} the snapshot is based on.
         * 
         * Note: If apply is used without a {@link Claim}, it will
         * apply to the claim {@link UUID} set here.
         * 
         * @param claimUniqueId The claim uuid
         * @return The builder
         */
        Builder creatorClaimUniqueId(UUID claimUniqueId);

        /**
         * The claim {@link ClaimDataGetter} the snapshot is based on.
         * 
         * @param data The claim data
         * @return The builder
         */
        Builder claimData(ClaimDataGetter data);

        /**
         * The claim flag permissions.
         * 
         * Note: Key is a context containing permission:value
         * Note: Value is a set of contexts attached to permission
         * 
         * @param claim The claim to copy permissions from
         * @return The builder
         */
        Builder permissions(Claim claim);

        /**
         * The claim flag permissions.
         * 
         * Note: Key is a context containing permission:value
         * Note: Value is a set of contexts attached to permission
         * 
         * @return The builder
         */
        Builder permissions(Map<String, Map<Set<Context>, Map<String, Boolean>>> permissions);

        /**
         * The claim options.
         * 
         * Note: Key is a context containing option:value
         * Note: Value is a set of contexts attached to option
         * 
         * @param claim The claim to copy options from
         * @return The builder
         */
        Builder options(Claim claim);

        /**
         * The claim options.
         * 
         * Note: Key is a context containing option:value
         * Note: Value is a set of contexts attached to option
         * 
         * @return The builder
         */
        Builder options(Map<String, Map<Set<Context>, Map<String, List<String>>>> options);

        /**
         * Resets the builder to default settings.
         * 
         * @return The builder
         */
        Builder reset();

        /**
         * Returns the {@link ClaimResult}.
         * 
         * @return The created snapshot
         */
        ClaimSnapshot build();
    }
}
