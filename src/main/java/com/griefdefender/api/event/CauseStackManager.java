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

/**
 * Manages {@link EventCause}'s.
 */
public interface CauseStackManager {

    /**
     * Gets the current {@link EventCause}.
     * 
     * @return The current event cause, or plugin instance if not available.
     */
    EventCause getCurrentCause();

    /**
     * Pushes a cause onto the stack during an event.
     * 
     * Note: It is important to always call {@link #popCause()} after usage.
     * 
     * @param cause The cause of event.
     * @return The cause stack manager
     */
    CauseStackManager pushCause(Object cause);

    /**
     * Pops the last cause off the stack.
     * 
     * @return The cause object removed.
     */
    Object popCause();

    /**
     * Checks the head cause object of stack.
     * 
     * @return The head cause object
     */
    Object peekCause();
}
