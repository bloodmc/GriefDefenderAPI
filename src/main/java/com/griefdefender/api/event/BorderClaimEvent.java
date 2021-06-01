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

import com.griefdefender.api.ChatType;
import com.griefdefender.api.ChatTypes;
import com.griefdefender.api.User;
import com.griefdefender.api.claim.Claim;
import com.griefdefender.api.data.ClaimData;
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
     * Gets the event enter message if available.
     * 
     * Note: If no message is set, the {@link ClaimData#getGreeting()}
     * will be used.
     */
    Optional<Component> getEnterMessage();

    /**
     * Gets the event exit message if available.
     * 
     * Note: If no message is set, the {@link ClaimData#getFarewell()}
     * will be used.
     */
    Optional<Component> getExitMessage();

    /**
     * Gets the event enter message if available.
     * 
     * Note: If no message is set, the {@link ClaimData#getGreeting()}
     * will be used.
     */
    Optional<Title> getEnterTitle();

    /**
     * Gets the event exit message if available.
     * 
     * Note: If no message is set, the {@link ClaimData#getFarewell()}
     * will be used.
     */
    Optional<Title> getExitTitle();

    /**
     * Sets the enter message for this event only.
     * 
     * Note: Setting message to {@code null} will hide the message.
     * If no message is set, the {@link ClaimData#getGreeting()} will be used.
     * 
     * @param message The message to set
     * @param chatType The desired chat type, in which the message will be displayed
     */
    void setEnterMessage(@Nullable Component message, ChatType chatType);

    /**
     * Sets the exit message for this event only.
     * 
     * Note: Setting message to {@code null} will hide the message.
     * If no message is set, the {@link ClaimData#getFarewell()} will be used.
     * 
     * @param message The message to set
     * @param chatType The desired chat type, in which the message will be displayed
     */
    void setExitMessage(@Nullable Component message, ChatType chatType);

    /**
     * Sets the enter title for this event only.
     * 
     * Note: Setting title to {@code null} will hide the message.
     * If no title is set, the {@link ClaimData#getGreeting()} will be used.
     * 
     * @param message The message to set
     * @param chatType The desired chat type, in which the message will be displayed
     */
    void setEnterTitle(@Nullable Title title);

    /**
     * Sets the exit title for this event only.
     * 
     * Note: Setting title to {@code null} will hide the message.
     * If no message is set, the {@link ClaimData#getFarewell()} will be used.
     * 
     * @param message The message to set
     * @param chatType The desired chat type, in which the message will be displayed
     */
    void setExitTitle(@Nullable Title title);

    /**
     * Sets the exit message for this event only.
     * The message will send as the chat type {@link ChatTypes#ACTION_BAR}
     *
     * Note: Setting message to {@code null} will hide the message.
     * If no message is set, the {@link ClaimData#getFarewell()} will be used.
     *
     * For changing the ChatType see {@link BorderClaimEvent#setExitMessage(Text, ChatType)}
     *
     * @param message The message to set
     */
    default void setExitMessage(@Nullable Component message) {
        setExitMessage(message, ChatTypes.ACTION_BAR);
    }


    /**
     * Sets the enter message for this event only.
     * The message will send as the chat type {@link ChatTypes#ACTION_BAR}
     *
     * Note: Setting message to {@code null} will hide the message.
     * If no message is set, the {@link ClaimData#getGreeting()} will be used.
     *
     * For changing the ChatType see {@link BorderClaimEvent#setEnterMessage(Text, ChatType)}
     *
     * @param message The message to set
     */
    default void setEnterMessage(@Nullable Component message) {
        setEnterMessage(message, ChatTypes.ACTION_BAR);
    }

    /**
     * Returns the chat type for the exit message.
     * 
     * Note: Default is {@link ChatTypes#ACTION_BAR}
     *
     * @return The chat type
     */
    ChatType getExitMessageChatType();

    /**
     * Returns the chat type for the enter message.
     *
     * Note: Default is {@link ChatTypes#ACTION_BAR}
     * 
     * @return The chat type
     */
    ChatType getEnterMessageChatType();
}