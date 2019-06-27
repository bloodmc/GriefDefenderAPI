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
package com.griefdefender.api.claim;

import com.griefdefender.api.util.generator.DummyObjectProvider;

public class TrustTypes {

    /**
     * Represents no specific trust.
     * Note: This is usually passed when a plugin wants to remove all trusts.
     */
    public static final TrustType NONE = DummyObjectProvider.createFor(TrustType.class, "NONE");

    /**
     * Allows access to interact with all blocks except inventory.
     */
    public static final TrustType ACCESSOR = DummyObjectProvider.createFor(TrustType.class, "ACCESSOR");

    /**
     * Inherits trust from both {@link #ACCESSOR} and {@link #CONTAINER}
     * as well as adds ability to place and break blocks.
     */
    public static final TrustType BUILDER = DummyObjectProvider.createFor(TrustType.class, "BUILDER");

    /**
     * Allows access to interact with all blocks including inventory.
     */
    public static final TrustType CONTAINER = DummyObjectProvider.createFor(TrustType.class, "CONTAINER");

    /**
     * Allows full access to claim including management.
     * Note: Managers can only transfer and abandon children claims.
     */
    public static final TrustType MANAGER = DummyObjectProvider.createFor(TrustType.class, "MANAGER");
}
