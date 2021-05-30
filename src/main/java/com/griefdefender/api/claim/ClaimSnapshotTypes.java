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

public final class ClaimSnapshotTypes {

    /**
     * Represents a global {@link ClaimSnapshotType} that is available to only admins.
     */
    public static final ClaimSnapshotType ADMIN = DummyObjectProvider.createFor(ClaimSnapshotType.class, "ADMIN");

    /**
     * Represents a {@link ClaimSnapshotType} that is available to all trusted users of a specific {@link Claim}.
     */
    public static final ClaimSnapshotType CLAIM = DummyObjectProvider.createFor(ClaimSnapshotType.class, "CLAIM");

    /**
     * Represents a global {@link ClaimSnapshotType} that is available to all users.
     */
    public static final ClaimSnapshotType PUBLIC = DummyObjectProvider.createFor(ClaimSnapshotType.class, "PUBLIC");

    /**
     * Represents a {@link ClaimSnapshotType} that is available to a specific {@link User}.
     */
    public static final ClaimSnapshotType USER = DummyObjectProvider.createFor(ClaimSnapshotType.class, "USER");

    // Suppress default constructor to ensure non-instantiability.
    private ClaimSnapshotTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}
