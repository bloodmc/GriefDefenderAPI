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

public final class ClaimVisualTypes {

    /**
     * Represents a claim visual type used for {@link ClaimTypes#ADMIN}.
     */
    public static final ClaimVisualType ADMIN = DummyObjectProvider.createFor(ClaimVisualType.class, "ADMIN");

    /**
     * Represents a claim visual type used for {@link ClaimTypes#BASIC}.
     */
    public static final ClaimVisualType BASIC = DummyObjectProvider.createFor(ClaimVisualType.class, "BASIC");

    /**
     * Represents the default claim visual type.
     */
    public static final ClaimVisualType DEFAULT = DummyObjectProvider.createFor(ClaimVisualType.class, "DEFAULT");

    /**
     * Represents a claim visual type used when an error occurs such as a claim overlapping.
     */
    public static final ClaimVisualType ERROR = DummyObjectProvider.createFor(ClaimVisualType.class, "ERROR");

    /**
     * Represents a claim visual type used to visualize a section of blocks selected for restore.
     */
    public static final ClaimVisualType RESTORE = DummyObjectProvider.createFor(ClaimVisualType.class, "RESTORE");

    /**
     * Represents a claim visual type used for {@link ClaimTypes#SUBDIVISION}.
     */
    public static final ClaimVisualType SUBDIVISION = DummyObjectProvider.createFor(ClaimVisualType.class, "SUBDIVISION");

    /**
     * Represents a claim visual type used for {@link ClaimTypes#TOWN}.
     */
    public static final ClaimVisualType TOWN = DummyObjectProvider.createFor(ClaimVisualType.class, "TOWN");


    // Suppress default constructor to ensure non-instantiability.
    private ClaimVisualTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}
