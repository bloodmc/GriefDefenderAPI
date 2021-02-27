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
import com.griefdefender.api.GriefDefender;

import java.time.Instant;
import java.util.UUID;

import org.checkerframework.checker.nullness.qual.Nullable;

public interface ClaimSchematic {

    /**
     * Gets the claim schematic is stored in.
     * 
     * @return The claim schematic is stored in
     */
    Claim getClaim();

    /**
     * Gets the name of the schematic.
     * 
     * @return The schematic name
     */
    String getName();

    /**
     * Gets the schematic creation date.
     * 
     * @return The date created
     */
    Instant getDateCreated();

    /**
     * Gets origin of schematic.
     * 
     * @return The origin pos
     */
    Vector3i getOrigin();

    /**
     * Sets origin of schematic.
     * 
     * @param pos The new origin pos
     */
    void setOrigin(Vector3i pos);

    /**
     * Sets origin of schematic.
     * 
     * @param x X coordinate
     * @param y Y coordinate
     * @param z Z coordinate
     */
    void setOrigin(int x, int y, int z);

    /**
     * Whether schematic has entities.
     * 
     * @return true if schematic has entities, false if not
     */
    boolean hasEntities();

    /**
     * Applies schematic to claim.
     * 
     * @return If schematic apply was successful, false if not
     */
    boolean apply();

    /**
     * Gets a new claim schematic builder instance for {@link Builder}.
     * 
     * @return A new claim schematic builder instance
     */
    public static ClaimSchematic.Builder builder() {
        return GriefDefender.getRegistry().createBuilder(ClaimSchematic.Builder.class);
    }

    public interface Builder {

        /**
         * The claim to use for schematic.
         * 
         * @param claim The claim
         * @return The builder
         */
        Builder claim(Claim claim);

        /**
         * The schematic name.
         * 
         * @param name
         * @return The builder
         */
        Builder name(String name);

        /**
         * The origin to use for claim.
         * 
         * @param origin The origin
         * @return The builder
         */
        Builder origin(Vector3i origin);

        /**
         * The origin to use for claim.
         * 
         * @param x X coordinate
         * @param y Y coordinate
         * @param z Z coordinate
         * @return The builder
         */
        Builder origin(int x, int y, int z);

        /**
         * Whether entities should be copied.
         * 
         * @param entities true if entities should be copied
         * @return The builder
         */
        Builder entities(boolean entities);

        /**
         * Whether nbt data should be copied.
         * 
         * @param nbt true if nbt data should be copied
         * @return The builder
         */
        Builder nbt(boolean nbt);

        /**
         * The user's {@link UUID} creating the schematic.
         * 
         * @param uuid The user uuid
         * @return The builder
         */
        Builder user(UUID uuid);

        /**
         * Resets the builder to default settings.
         * 
         * @return The builder
         */
        Builder reset();

        /**
         * Returns the {@link ClaimResult}.
         * 
         * @return The created schematic, if successful
         */
         @Nullable ClaimSchematic build();
    }
}
