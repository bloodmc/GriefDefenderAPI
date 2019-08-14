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

import java.util.Optional;
import java.util.Set;

import com.griefdefender.api.Subject;
import com.griefdefender.api.permission.Context;

import net.kyori.event.Cancellable;
import net.kyori.text.Component;

public interface PermissionEvent extends Cancellable, Event {

    /**
     * Gets the {@link Subject}
     * 
     * @return The subject
     */
    Subject getSubject();

    /**
     * Gets the {@link Context}'s associated with event.
     * 
     * @return The context set or empty set
     */
    Set<Context> getContexts();

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
