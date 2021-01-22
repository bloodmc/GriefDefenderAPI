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
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import com.griefdefender.api.GriefDefender;
import com.griefdefender.api.data.ClaimData;
import com.griefdefender.api.data.ClaimDataGetter;
import com.griefdefender.api.data.EconomyData;
import com.griefdefender.api.data.EconomyDataGetter;
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
    Optional<Component> getDescription();

    /**
     * Gets creator claim's {@link UUID}
     * 
     * @return The creator claim unique identifer
     */
    Optional<UUID> getCreatorUniqueId();

    /**
     * Gets a {@link ClaimDataGetter}.
     * 
     * @return The claim data
     */
    ClaimDataGetter getClaimData();

    /**
     * Gets the {@link EconomyDataGetter} copy.
     * 
     * @return The economy data copy
     */
    EconomyDataGetter getEconomyData();

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
    Map<String, Map<Set<Context>, Map<String, String>>> getOptions();

    /**
     * Applies snapshot to creator claim.
     * 
     * @return If snapshot apply was successful, false if not
     */
    boolean applyToCreator();

    /**
     * Applies snapshot to creator claim.
     * 
     * @return If snapshot apply was successful, false if not
     */
    boolean applyToCreator(SnapshotApplySettings applySettings);

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
        Optional<Component> getDescription();

        /**
         * Gets the creator claim's {@link UUID}
         * 
         * @return The creator claim unique identifer, if available
         */
        Optional<UUID> getCreatorUniqueId();

        /**
         * Gets the {@link ClaimData}.
         * 
         * @return The claim data
         */
        ClaimData getClaimData();

        /**
         * Gets the {@link EconomyDataGetter}.
         * 
         * @return The economy data
         */
        EconomyData getEconomyData();

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
        Map<String, Map<Set<Context>, Map<String, String>>> getOptions();

        /**
         * The claim to use for snapshot.
         * 
         * @param claim The claim
         * @return The builder
         */
        Builder from(Claim claim);

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
        Builder claimUniqueId(UUID claimUniqueId);

        /**
         * The claim {@link ClaimData} the snapshot is based on.
         * 
         * @param data The claim data
         * @return The builder
         */
        Builder claimData(ClaimDataGetter data);

        /**
         * The claim {@link EconomyDataGetter} the snapshot is based on.
         * 
         * @param data The economy data
         * @return The builder
         */
        Builder economyData(EconomyDataGetter data);

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
         * @return The builder
         */
        Builder options(Map<String, Map<Set<Context>, Map<String, String>>> options);

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
