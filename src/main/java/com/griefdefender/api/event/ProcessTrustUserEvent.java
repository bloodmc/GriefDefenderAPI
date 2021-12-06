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

import com.griefdefender.api.User;
import com.griefdefender.api.claim.TrustResult;

/**
 * Represents an event that is called before GD processes a player's trust.
 * <p>
 * This event allows a plugin to override a player's trust based on it's needs.
 */
public interface ProcessTrustUserEvent extends TrustClaimEvent {

    /**
     * The original trust result for {@link User}.
     * 
     * @return The original trust result
     */
    TrustResult getOriginalTrustResult();

    /**
     * The final trust result for {@link User}.
     * 
     * Note: If not changed, this will be same as original result.
     * 
     * @return The final trust result
     */
    TrustResult getFinalTrustResult();

    /**
     * Gets the {@link User} trust target
     *
     * @return The user trust target
     */
     User getUser();

     /**
      * Gets the trust action location.
      * 
      * <br><br>Note: This is only available during flag permission checks.
      * 
      * @return The trust action location, if available
      */
     @Nullable Object getLocation();

    /**
     * Sets a new trust result for {@link User} replacing the original.
     * 
     * @param result The new trust result
     */
    void setNewTrustResult(TrustResult result);
}
