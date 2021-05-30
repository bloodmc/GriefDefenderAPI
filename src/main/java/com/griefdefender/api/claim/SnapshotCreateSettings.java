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

import java.util.UUID;

import org.checkerframework.checker.nullness.qual.Nullable;

import com.griefdefender.api.GriefDefender;

/**
 * Represents creation settings used to create a {@link ClaimSnapshot}.
 */
public interface SnapshotCreateSettings {

    /**
     * Gets the creation {@link Type}.
     * 
     * @return The creation type
     */
    ClaimSnapshotType getType();

    /**
     * The group associated with a {@link Type}.
     * 
     * Note: This does not apply to {@link Type#CLAIM}.
     * 
     * @return The group
     */
    @Nullable String getGroup();

    /**
     * The user associated with {@link Type#PLAYER}.
     * 
     * @return The user uuid, if available
     */
    @Nullable UUID getUserUniqueId();

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

    /**
     * Gets whether to include children claims.
     * 
     * @return True if children included, false if not
     */
    boolean includeChildren();

    /**
     * Sets the creation {@link Type}.
     * 
     * @param type The creation type
     */
    void setType(ClaimSnapshotType type);

    /**
     * Sets the group name.
     * 
     * @param group The group name
     */
    void setGroup(String group);

    /**
     * Sets the user {@link UUID}.
     * 
     * Note: This only applies to {@link Type#PLAYER}.
     * 
     * @param uuid The user uuid
     */
    void setUserUniqueId(UUID uuid);

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

    /**
     * Sets whether to include children.
     * 
     * @param includeChildren
     */
    void setIncludeChildren(boolean includeChildren);

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
         * The user associated with {@link Type#PLAYER}.
         * 
         * @return The user uuid, if available
         */
        @Nullable UUID getUserUniqueId();

        /**
         * Gets the create {@link ClaimSnapshotType}.
         * 
         * @return The create type
         */
        ClaimSnapshotType getType();

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

        /**
         * Gets whether to include children claims.
         * 
         * @return True if children included, false if not
         */
        boolean includeChildren();

        /**
         * Sets whether to create a schematic of claim.
         * 
         * @param create True to create schematic, false if not
         * @return The builder
         */
        Builder createSchematic(boolean create);

        /**
         * Sets whether claim settings should be copied.
         * 
         * @param copy True to copy, false if not
         * @return The builder
         */
        Builder copyClaimSettings(boolean copy);

        /**
         * Sets whether option data should be copied.
         * 
         * @param copy True to copy, false if not
         * @return The builder
         */
        Builder copyOptions(boolean copy);

        /**
         * Sets whether permission data should be copied.
         * 
         * @param copy True to copy, false if not
         * @return The builder
         */
        Builder copyPermissions(boolean copy);

        /**
         * Sets whether trust data should be copied.
         * 
         * @param copy True to copy, false if not
         * @return The builder
         */
        Builder copyTrust(boolean copy);

        /**
         * Sets the creation {@link ClaimSnapshotType}.
         * 
         * @param type The creation type
         * @return The builder
         */
        Builder type(ClaimSnapshotType type);

        /**
         * Sets the group name.
         * 
         * @param group The group name
         * @return The builder
         */
        Builder group(String group);

        /**
         * Sets the user {@link UUID}.
         * 
         * Note: This only applies to {@link Type#PLAYER}.
         * 
         * @param uuid The user uuid
         * @return The builder
         */
        Builder user(UUID uuid);

        /**
         * Sets whether to include children.
         * 
         * @param includeChildren True to include, false if not
         * @return The builder
         */
        Builder children(boolean includeChildren);

        /**
         * Resets the builder to default settings.
         * 
         * @return The builder
         */
        Builder reset();

        /**
         * Returns the {@link SnapshotCreateSettings}.
         * 
         * @return The snapshot creation settings
         */
        SnapshotCreateSettings build();
    }
}
