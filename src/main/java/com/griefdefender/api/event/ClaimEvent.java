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

import com.griefdefender.api.User;
import com.griefdefender.api.claim.Claim;
import net.kyori.adventure.text.Component;

import java.util.List;
import java.util.Optional;

import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Base event when one or more {@link Claim}s are affected.
 */
public interface ClaimEvent extends Event {

    /**
     * The source object that caused this event.
     * 
     * <br>Note: If no source available, pass mod/plugin instance.
     * 
     * @return The source
     */
    Object getSource();

    /**
     * The source {@link User} that caused this event.
     * 
     * @return The source user, if available
     */
    @Nullable User getSourceUser();

    /**
     * Gets the immutable list of claims.
     * 
     * @return The immutable list of claims
     */
    List<Claim> getClaims();

    /**
     * Gets the first claim.
     * 
     * Note: This is a helper method for events that will usually always
     * contain one claim instead of calling {@link #getClaims}.
     * 
     * @return The first claim
     */
    default Claim getClaim() {
        return this.getClaims().get(0);
    }

    /**
     * Sets the claim message to be presented to {@link Subject}
     * if applicable.
     * 
     * @param message The message
     */
    void setMessage(Component message);

    /**
     * Gets the claim message.
     * 
     * Note: This is only available if event was cancelled.
     * 
     * @return The claim message, if available
     */
    Optional<Component> getMessage();
}
