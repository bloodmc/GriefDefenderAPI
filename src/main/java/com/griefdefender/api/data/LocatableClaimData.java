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

import java.util.Optional;
import java.util.UUID;

import org.checkerframework.checker.nullness.qual.Nullable;

import com.flowpowered.math.vector.Vector3i;

public interface LocatableClaimData extends ClaimData {

    /** Gets the claim's world {@link UUID}.
     * 
     * @return The world UUID
     */
    UUID getWorldUniqueId();

    /**
     * Gets the lesser boundary corner of claim.
     * 
     * @return The lesser boundary corner position.
     */
    Vector3i getLesserBoundaryCorner();

    /**
     * Gets the greater boundary corner of claim.
     * 
     * @return The greater boundary corner position.
     */
    Vector3i getGreaterBoundaryCorner();

    /**
     * Gets the spawn position of claim.
     * 
     * @return The spawn position, if available
     */
    Optional<Vector3i> getSpawnPos();

    /**
     * Sets the lesser boundary corner position.
     * 
     * @param pos The lesser boundary
     */
    void setLesserBoundaryCorner(Vector3i pos);

    /**
     * Sets the greater boundary corner position.
     * 
     * @param pos The greater boundary
     */
    void setGreaterBoundaryCorner(Vector3i pos);

    /**
     * Sets the spawn position of claim.
     * 
     * @param pos The new spawn position
     */
    void setSpawnPos(Vector3i pos);

    /**
     * Sets the spawn position of claim.
     * 
     * @param x X coordinate
     * @param y Y coordinate
     * @param z Z coordinate
     */
    void setSpawnPos(int x, int y, int z);

    /**
     * Sets the world {@link UUID} of claim.
     * 
     * @param worldUniqueId The world uuid
     */
    void setWorldUniqueId(UUID worldUniqueId);

    /**
     * Gets the economy data.
     * 
     * @return The economy data, if available
     */
    @Nullable LocatableEconomyData getEconomyData();
}
