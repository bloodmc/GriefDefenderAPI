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

import com.griefdefender.api.CatalogType;
import com.griefdefender.api.GriefDefender;

/**
 * Represents a claim visual type.
 */
public interface ClaimVisualType extends CatalogType {

    /**
     * Gets the accent block id.
     * 
     * @return The accent block id
     */
    String getAccentBlockId();

    /**
     * Gets the corner block id.
     * 
     * @return The corner block id
     */
    String getCornerBlockId();

    /**
     * Gets the filler block id.
     * 
     * @return The filler block id
     */
    String getFillerBlockId();

    /**
     * Gets a new claim builder instance for {@link Builder}.
     * 
     * @return A new claim builder instance
     */
    public static ClaimVisualType.Builder builder() {
        return GriefDefender.getRegistry().createBuilder(ClaimVisualType.Builder.class);
    }

    public interface Builder {

        /**
         * Sets the visual type name.
         * 
         * @param name The visual type name
         * @return The builder
         */
        Builder name(String name);

        /**
         * Sets the accent block id.
         * 
         * @param id The accent block id
         * @return The builder
         */
        Builder accentBlock(String id);

        /**
         * Sets the corner block id.
         * 
         * @param id The corner block id
         * @return The builder
         */
        Builder cornerBlock(String id);

        /**
         * Sets the filler block id.
         * 
         * @param id The filler block id
         * @return The builder
         */
        Builder fillerBlock(String id);

        /**
         * Resets the builder to default settings.
         * 
         * @return The builder
         */
        Builder reset();

        /**
         * Returns the {@link ClaimVisualType}.
         * 
         * @return The claim visual type
         */
        ClaimVisualType build();
    }
}
