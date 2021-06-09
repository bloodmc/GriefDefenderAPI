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
import net.kyori.event.Cancellable;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.Title;

import java.util.Optional;
import java.util.UUID;

import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * An event that is fired when a {@link User} or entity crosses a {@link Claim} border.
 */
public interface BorderClaimEvent extends ClaimEvent, Cancellable  {

    /**
     * Gets the claim the entity is attempting to exit.
     * 
     * @return The source claim
     */
    Claim getExitClaim();

    /**
     * Gets the claim the entity is attempting to enter.
     * 
     * @return The destination claim
     */
    default Claim getEnterClaim() {
        return this.getClaim();
    }

    /**
     * Gets the target {@link UUID} of entity
     * that entered {@link Claim}.
     *
     * @return The target uuid of entity
     */
    UUID getEntityUniqueId();

    /**
     * Gets the target {@link User}
     *
     * @return The target user if available
     */
    @Nullable User getUser();

    /**
     * Gets the event enter message, if available.
     */
    Optional<Component> getEnterChatMessage();

    /**
     * Gets the event exit message, if available.
     */
    Optional<Component> getExitChatMessage();

    /**
     * Gets the event enter action bar message, if available.
     */
    Optional<Component> getEnterActionBar();

    /**
     * Gets the event exit action bar, if available.
     */
    Optional<Component> getExitActionBar();

    /**
     * Gets the event enter message, if available.
     */
    Optional<Title> getEnterTitle();

    /**
     * Gets the event exit message, if available.
     */
    Optional<Title> getExitTitle();

    /**
     * Sets the enter message for this event only.
     * 
     * @param message The message to set
     */
    void setEnterChatMessage(@Nullable Component message);

    /**
     * Sets the exit message for this event only.
     * 
     * @param message The message to set
     */
    void setExitChatMessage(@Nullable Component message);

    /**
     * Sets the enter action bar message for this event only.
     * 
     * Note: Setting message to {@code null} will hide any message set.
     * 
     * @param message The message to set
     */
    void setEnterActionBar(@Nullable Component message);

    /**
     * Sets the exit action bar message for this event only.
     * 
     * Note: Setting message to {@code null} will hide any message set.
     * 
     * @param message The message to set
     */
    void setExitActionBar(@Nullable Component message);

    /**
     * Sets the enter title for this event only.
     * 
     * @param message The message to set
     */
    void setEnterTitle(@Nullable Title title);

    /**
     * Sets the exit title for this event only.
     * 
     * @param message The message to set
     */
    void setExitTitle(@Nullable Title title);
}