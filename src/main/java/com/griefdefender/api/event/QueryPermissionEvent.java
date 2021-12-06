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
package com.griefdefender.api.event;

import org.checkerframework.checker.nullness.qual.Nullable;

import com.griefdefender.api.Tristate;

/**
 * The base event that is fired before and after GD queries permission provider for result.
 */
public interface QueryPermissionEvent extends PermissionEvent {

    /**
     * Gets the query action location.
     * 
     * @return The query action location, if available
     */
    @Nullable Object getLocation();

    /**
     * An event that is fired before all GD permission checks take place.
     * 
     * <br><br>Note: Cancelling this event will force a {@link Tristate#FALSE} result.
     */
    interface Pre extends QueryPermissionEvent {

        /**
         * The final permission result.
         * 
         * <br><br>Note: If not set, this will always return {@link Tristate#UNDEFINED}
         * as it takes place before permission checks.
         * 
         * @return The final permission result
         */
        Tristate getFinalResult();

        /**
         * Sets the final result to bypass all permission checks.
         * 
         * <br><br>Note: If set, {@link Post} will not be fired.
         * 
         * @param result The final result
         */
        void setFinalResult(Tristate result);
    }

    /**
     * An event that is fired after GD queries permission provider for result.
     * 
     * <br><br>Note: Cancelling this event will force a {@link Tristate#FALSE} result.
     */
    interface Post extends QueryPermissionEvent {

        /**
         * The original permission result.
         * 
         * @return The original permission result
         */
        Tristate getOriginalResult();

        /**
         * The final permission result.
         * 
         * @return The final permission result
         */
        Tristate getFinalResult();

        /**
         * Sets a new permission result replacing the original.
         * 
         * @param result The new permission result
         */
        void setNewResult(Tristate result);
    }
}
