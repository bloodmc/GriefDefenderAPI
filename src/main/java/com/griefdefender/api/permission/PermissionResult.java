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
package com.griefdefender.api.permission;

import com.griefdefender.api.claim.ClaimResult;
import net.kyori.text.Component;

import java.util.Optional;

public interface PermissionResult {

    /**
     * Gets the {@link ResultType} of flag action.
     * 
     * @return The result type
     */
    ResultType getResultType();

    /**
     * Gets the result message.
     * 
     * Note: normally this is set during event cancellations.
     * 
     * @return The result message, if available
     */
    Optional<Component> getMessage();

    /**
     * A simple helper method to determine if the {@link ClaimResult}
     * was a success.
     * 
     * @return Whether the claim result was a success
     */
    default boolean successful() {
        return this.getResultType() == ResultTypes.SUCCESS;
    }
}
