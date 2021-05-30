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

import java.util.Set;

public interface CommandCompletionEvent {

    /**
     * Gets an immutable set of current command completions.
     * 
     * @return The immutable set of command completions
     */
    Set<String> getCommandCompletions();

    /**
     * Register a custom command completion value.
     * 
     * @param commandCompletion
     */
    void register(String commandCompletion);

    /**
     * Fired when GD builds its context command completions.
     */
    interface Context extends CommandCompletionEvent {}

    /**
     * Fired when GD builds its identifier command completions.
     */
    interface Identifier extends CommandCompletionEvent {}

    /**
     * Fired when GD builds its tag command completions.
     */
    interface Tag extends CommandCompletionEvent {}
}
