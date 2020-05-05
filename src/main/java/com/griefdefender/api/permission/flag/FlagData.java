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
package com.griefdefender.api.permission.flag;

import java.util.Set;

import com.griefdefender.api.GriefDefender;
import com.griefdefender.api.permission.Context;

/**
 * Represents flag permission data stored in a {@link FlagDefinition}.
 */
public interface FlagData {

    /**
     * Gets the {@link Flag} associated with this data.
     * 
     * @return The flag
     */
    Flag getFlag();

    /**
     * Gets the {@link Context}'s associated with this data.
     * 
     * @return The contexts
     */
    Set<Context> getContexts();

    /**
     * Checks if {@link FlagData} matches this data.
     * 
     * @param flagData The flag data to check
     * @return Whether this data matches
     */
    default boolean matches(FlagData flagData) {
        if (flagData == null) {
            return false;
        }
        return this.matches(flagData.getFlag(), flagData.getContexts());
    }

    /**
     * Checks if a {@link Flag} with {@link Context}'s match this data.
     * 
     * @param flag The flag to check
     * @param contexts The contexts to check
     * @return Whether this data matches
     */
    boolean matches(Flag flag, Set<Context> contexts);

    /**
     * Gets a new claim builder instance for {@link Builder}.
     * 
     * @return A new claim builder instance
     */
    public static FlagData.Builder builder() {
        return GriefDefender.getRegistry().createBuilder(FlagData.Builder.class);
    }

    public interface Builder {

        /**
         * The {@link Flag} associated with this data.
         * 
         * @param flag The flag
         * @return The builder
         */
        Builder flag(Flag flag);

        /**
         * The {@link Context} associated with this data.
         * 
         * @param context The context
         * @return The builder
         */
        Builder context(Context context);

        /**
         * The {@link Context}'s associated with this data.
         * 
         * @param contexts The contexts
         * @return The builder
         */
        Builder contexts(Set<Context> contexts);

        /**
         * Resets the builder to default settings.
         * 
         * @return The builder
         */
        Builder reset();

        /**
         * Returns the {@link FlagData}.
         * 
         * @return The flag data
         */
        FlagData build();
    }
}
