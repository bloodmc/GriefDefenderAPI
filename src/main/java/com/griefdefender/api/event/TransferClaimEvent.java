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

import java.util.UUID;

import net.kyori.event.Cancellable;

/**
 * An event that is fired after a {@link Claim} has been transferred to a new owner.
 */
public interface TransferClaimEvent extends ClaimEvent, Cancellable {

    /**
     * Gets the original owner's {@link UUID} of {@link Claim}.
     * 
     * @return The original owner's uuid
     */
    UUID getOriginalOwner();

    /**
     * Gets the new owner's {@link UUID} of {@link Claim}.
     * 
     * @return The new owner's uuid
     */
    UUID getNewOwner();

    /**
     * Sets the new owner's {@link UUID}
     * 
     * @param uuid
     */
    void setNewOwner(UUID uuid);
}
