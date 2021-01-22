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

import org.checkerframework.checker.nullness.qual.Nullable;

import com.flowpowered.math.vector.Vector3i;

public interface LocatableEconomyData extends EconomyData {

    /**
     * Gets the rent sign location.
     * 
     * @return The rent sign position, if available
     */
    @Nullable Vector3i getRentSignPosition();

    /**
     * Gets the sale sign location.
     * 
     * @return The sale sign position, if available
     */
    @Nullable Vector3i getSaleSignPosition();

    /**
     * Sets the sign position of claim being rented.
     * 
     * @param pos The rent sign pos
     */
    void setRentSignPosition(@Nullable Vector3i pos);

    /**
     * Sets the sign position of claim being sold.
     * 
     * @param pos The sell sign pos
     */
    void setSaleSignPosition(@Nullable Vector3i pos);
}
