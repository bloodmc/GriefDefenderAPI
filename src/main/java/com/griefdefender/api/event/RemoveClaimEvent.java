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

public interface RemoveClaimEvent extends ClaimEvent {

    /**
     * Whether this claim will restore on removal.
     * 
     * @return Whether this claim will restore on removal.
     */
    boolean isRestoring();

    /**
     * Whether this claim should restore back to original state on removal.<br>
     * Note: This setting will be ignored if auto-restore functionality is disabled.<br>
     * 
     * If nature restore is enabled, this will restore claim back to world gen state.<br>
     * If schematic restore is enabled, this will restore claim back to claim creation {@link ClaimSchematic}.
     * 
     * @param shouldRestore Whether this claim should restore back to original state
     */
    void shouldRestore(boolean restore);

    /**
     * Fired when a claim is abandoned.
     */
    interface Abandon extends RemoveClaimEvent {};

    /**
     * Fired when a claim is deleted.
     */
    interface Delete extends RemoveClaimEvent {};
}
