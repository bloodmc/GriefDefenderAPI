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

import com.griefdefender.api.GriefDefender;

/**
 * Represents settings used when applying a {@link ClaimSnapshot}.
 */
public interface SnapshotApplySettings {

    /**
     * Gets the claim {@link ApplyType}.
     * 
     * @return The claim apply type
     */
    ApplyType getClaimApplyType();

    /**
     * Gets the option {@link ApplyType}.
     * 
     * @return The option apply type
     */
    ApplyType getOptionApplyType();

    /**
     * Gets the permission {@link ApplyType}.
     * 
     * @return The permission apply type
     */
    ApplyType getPermissionApplyType();

    /**
     * Gets the trust {@link ApplyType}.
     * 
     * @return The trust apply type
     */
    ApplyType getTrustApplyType();

    /**
     * Sets the claim {@link ApplyType}.
     * 
     * @param type The claim apply type
     */
    void setClaimApplyType(ApplyType type);

    /**
     * Sets the option {@link ApplyType}.
     * 
     * @param type The option apply type
     */
    void setOptionApplyType(ApplyType type);

    /**
     * Sets the permission {@link ApplyType}.
     * 
     * @param type The permission apply type
     */
    void setPermissionApplyType(ApplyType type);

    /**
     * Sets the trust {@link ApplyType}.
     * 
     * @param type The trust apply type
     */
    void setTrustApplyType(ApplyType type);

    public static SnapshotApplySettings.Builder builder() {
        return GriefDefender.getRegistry().createBuilder(SnapshotApplySettings.Builder.class);
    }

    public interface Builder {

        ApplyType getClaimApplyType();

        ApplyType getOptionApplyType();

        ApplyType getPermissionApplyType();

        ApplyType getTrustApplyType();

        Builder claimApplyType(ApplyType type);

        Builder optionApplyType(ApplyType type);

        Builder permissionApplyType(ApplyType type);

        Builder trustApplyType(ApplyType type);

        Builder reset();

        SnapshotApplySettings build();
    }
}
