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

import com.flowpowered.math.vector.Vector3i;
import com.griefdefender.api.claim.Claim;
import com.griefdefender.api.claim.ClaimType;
import net.kyori.adventure.text.Component;
import net.kyori.event.Cancellable;

import java.util.Optional;

import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * An event that is fired before a {@link Claim} is changed.
 * 
 * Note: Canceling this event will prevent claim change.
 */
public interface ChangeClaimEvent extends ClaimEvent, Cancellable {

    /**
     * An event that is fired when a {@link Claim} display name is changed.
     */
    interface DisplayName extends ChangeClaimEvent {
        /**
         * Gets the original claim display name.
         *          
         * @return The original claim display name if available
         */
        Optional<Component> getOriginalDisplayName();

        /**
         * Gets the new claim display name.
         * 
         * @return The new claim display name, if available
         */
        Optional<Component> getDisplayName();

        /**
         * Sets and overrides the event display name.
         * 
         * @param displayName The new claim display name
         */
        void setDisplayName(@Nullable Component displayName);
    }

    /**
     * An event that is fired when a {@link Claim} friendly identifier is changed.
     */
    interface Identifier extends ChangeClaimEvent {
        /**
         * Gets the original claim identifier.
         * 
         * @return The original claim identifier
         */
        @Nullable String getOriginalIdentifier();

        /**
         * Gets the new claim identifier.
         * 
         * @return The new claim identifier
         */
        @Nullable String getIdentifier();
    }

    /**
     * An event that is fired when a {@link ClaimType} is changed.
     */
    interface Type extends ChangeClaimEvent {
        /**
         * Gets the original {@link ClaimType}.
         * 
         * @return The original claim type
         */
        ClaimType getOriginalType();
    
        /**
         * Gets the new {@link ClaimType}.
         * 
         * @return The new claim type
         */
        ClaimType getType();
    }

    /**
     * An event that is fired when a {@link Claim} is resized.
     */
    interface Resize extends ChangeClaimEvent {
        /**
         * The start corner location for resize.
         * 
         * @return The start location
         */
        Vector3i getStartCorner();

        /**
         * The end corner location to resize to.
         * 
         * @return The end corner location
         */
        Vector3i getEndCorner();
    }
}
