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
package com.griefdefender.api;

import com.griefdefender.api.claim.Claim;

/**
 * Contains the command result data of a command sender permission check.
 */
public interface CommandResult {

    /**
     * Gets the {@link Claim} associated with command.
     * 
     * @return The claim
     */
    public Claim getClaim();

    /**
     * Gets the command location.
     * 
     * @return The command location
     */
    public Object getLocation();

    /**
     * Gets the {@link User} associated with command.
     * 
     * @return The user
     */
    public User getUser();

    /**
     * Gets the player that ran command.
     * 
     * @return The player source, if available
     */
    public Object getPlayerSource();

    /**
     * Checks if command sender is admin.
     * 
     * @return true if admin, false if not
     */
    public boolean isAdmin();

    /**
     * Checks if command sender can run command.
     * 
     * @return true if allowed, false if not
     */
    public boolean successful();
}
