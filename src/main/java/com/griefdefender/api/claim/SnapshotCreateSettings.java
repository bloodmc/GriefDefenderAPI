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

import org.checkerframework.checker.nullness.qual.Nullable;

import com.griefdefender.api.GriefDefender;

/**
 * Represents creation settings used to create a {@link ClaimSnapshot}.
 */
public interface SnapshotCreateSettings {

    enum Type {

        /**
         * Represents a snapshot that can only be used by admins.
         */
        ADMIN,
        /**
         * Represents a snapshot that can only be used with a specific {@link Claim}.
         */
        CLAIM,
        /**
         * Represents a snapshot tied to a player that can be used on any {@link Claim} owned by them.
         */
        PLAYER,
        /**
         * Represents a snapshot that can be used by all players on any {@link Claim} owned by them.
         */
        PUBLIC
    }

    /**
     * Gets the creation {@link Type}.
     * 
     * @return The creation type
     */
    Type getType();

    /**
     * The group associated with a {@link Type}.
     * 
     * Note: This does not apply to {@link Type#CLAIM}.
     * 
     * @return The group
     */
    @Nullable String getGroup();

    /**
     * Whether to create schematic.
     * 
     * @return True if creating schematic, false if not
     */
    boolean createSchematic();

    /**
     * Whether to copy claim settings.
     * 
     * @return True if copying claim settings, false if not
     */
    boolean copyClaimSettings();

    /**
     * Whether to copy option data.
     * 
     * @return True if copying option data, false if not
     */
    boolean copyOptions();

    /**
     * Whether to copy permission data.
     * 
     * @return True if copying permission data, false if not
     */
    boolean copyPermissions();

    /**
     * Whether to copy trust data.
     * 
     * @return True if copying trust data, false if not
     */
    boolean copyTrust();

    void setType(Type type);

    void setGroup(String group);

    /**
     * Sets whether to copy claim settings.
     * 
     * @param copy
     */
    void setCopyClaimSettings(boolean copy);

    /**
     * Sets whether to copy option data.
     * 
     * @param copy
     */
    void setCopyOptions(boolean copy);

    /**
     * Sets whether to copy permission data.
     * 
     * @param copy
     */
    void setCopyPermissions(boolean copy);

    /**
     * Sets whether to copy trust data.
     * 
     * @param copy
     */
    void setCopyTrust(boolean copy);

    /**
     * Sets whether to copy schematic data.
     * 
     * @param create
     */
    void setCreateSchematic(boolean create);

    public static SnapshotCreateSettings.Builder builder() {
        return GriefDefender.getRegistry().createBuilder(SnapshotCreateSettings.Builder.class);
    }

    public interface Builder {

        /**
         * Gets the group associated with a {@link Type}.
         * 
         * @return The group, if available
         */
        @Nullable String getGroup();

        /**
         * Gets the create {@link Type}.
         * 
         * @return The create type
         */
        Type getType();

        /**
         * Gets whether a schematic will be created.
         * 
         * @return True if schematic will be created, false if not
         */
        boolean getCreateSchematic();

        /**
         * Gets whether claim settings will be copied.
         * 
         * @return True if claim settings will be copied, false if not
         */
        boolean getCopyClaimSettings();

        /**
         * Gets whether claim options will be copied.
         * 
         * @return True if claim options will be copied, false if not
         */
        boolean getCopyOptions();

        /**
         * Gets whether claim permissions will be copied.
         * 
         * @return True if claim permissions will be copied, false if not
         */
        boolean getCopyPermissions();

        /**
         * Gets whether claim trust will be copied.
         * 
         * @return True if claim trust will be copied, false if not
         */
        boolean getCopyTrust();

        Builder createSchematic(boolean create);

        Builder copyClaimSettings(boolean copy);

        Builder copyOptions(boolean copy);

        Builder copyPermissions(boolean copy);

        Builder copyTrust(boolean copy);

        Builder type(Type type);

        Builder group(String group);

        Builder reset();

        SnapshotCreateSettings build();
    }
}
