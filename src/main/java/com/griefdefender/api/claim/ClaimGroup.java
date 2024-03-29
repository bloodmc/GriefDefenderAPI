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

import java.time.Instant;
import java.util.UUID;

import org.checkerframework.checker.nullness.qual.Nullable;

import com.griefdefender.api.ContextSource;
import com.griefdefender.api.GriefDefender;
import com.griefdefender.api.claim.ClaimSnapshot.Builder;

import net.kyori.adventure.text.Component;

public interface ClaimGroup extends ContextSource {

    /**
     * Gets the {@link UUID} associated with group.
     * 
     * <br><br>Note: The uuid is the identifier used
     * in permissions.
     * 
     * @return The claim group uuid
     */
    UUID getUniqueId();

    /**
     * Gets the claim group name
     * 
     * @return The claim group name
     */
    String getName();

    /**
     * Gets the claim group description {@link Component}.
     * 
     * @return The claim group description, if available
     */
    @Nullable Component getDescription();

    /**
     * Gets the creation date of claim group.
     * 
     * @return The claim group creation date
     */
    Instant getDateCreated();

    /**
     * Gets the {@link ClaimGroupType}.
     * 
     * @return The claim group type
     */
    ClaimGroupType getType();

    /**
     * Gets the {@link ClaimGroupSyncMode}.
     * 
     * @return The claim group sync mode
     */
    ClaimGroupSyncMode getSyncMode();

    /**
     * Gets the user uuid this is associated with if any.
     * 
     * @return The user uuid, if available
     */
    @Nullable UUID getUserUniqueId();

    /**
     * Gets a new {@link ClaimGroup} builder instance for {@link Builder}.
     * 
     * @return A new claim group builder instance
     */
    public static ClaimGroup.Builder builder() {
        return GriefDefender.getRegistry().createBuilder(ClaimGroup.Builder.class);
    }

    public interface Builder {

        /**
         * Gets the {@link UUID} associated with group.
         * 
         * <br><br>Note: The uuid is the identifier used
         * in permissions.
         * 
         * @return The claim group uuid
         */
        UUID getUniqueId();

        /**
         * Gets the claim group name
         * 
         * @return The claim group name
         */
        String getName();

        /**
         * Gets the claim group description {@link Component}.
         * 
         * @return The claim group description, if available
         */
        @Nullable Component getDescription();

        /**
         * Gets the creation date of claim group.
         * 
         * @return The claim group creation date
         */
        Instant getDateCreated();

        /**
         * Gets the {@link ClaimGroupType}.
         * 
         * @return The claim group type
         */
        ClaimGroupType getType();

        /**
         * Gets the {@link ClaimGroupSyncMode}.
         * 
         * @return The claim group sync mode
         */
        ClaimGroupSyncMode getSyncMode();

        /**
         * Gets the user uuid this is associated with if any.
         * 
         * @return The user uuid, if available
         */
        @Nullable UUID getUserUniqueId();

        /**
         * Sets the {@link ClaimGroup}'s {@link UUID}.
         * 
         * Note: If not set, a new uuid will be generated.
         * 
         * @param uuid The uuid to set
         * @return The builder
         */
        Builder uuid(UUID uuid);

        /**
         * Sets the {@link User}'s UUID to assign this group to.
         * 
         * <br><br>Note: This is only required if type is
         * {@link ClaimGroupTypes#USER}.
         * 
         * @param userUniqueId The user uuid
         * @return The builder
         */
        Builder user(UUID userUniqueId);

        /**
         * The {@link Component} description of claim group.
         * 
         * @param description The description
         * @return The claim group description
         */
        Builder description(Component description);

        /**
         * The claim group creation date.
         * 
         * Note: If not set, date will be set on build.
         * 
         * @param dateCreated The claim group creation date
         * @return The builder
         */
        Builder dateCreated(Instant dateCreated);

        /**
         * Sets the claim group name.
         * 
         * @param name The claim group name
         * @return The builder
         */
        Builder name(String name);

        /**
         * Sets the {@link ClaimGroupSyncMode}.
         * 
         * @param mode The claim group sync mode.
         * @return The builder
         */
        Builder syncMode(ClaimGroupSyncMode mode);

        /**
         * Sets the {@link ClaimGroupType}.
         * 
         * @param type The claim group type
         * @return The builder
         */
        Builder type(ClaimGroupType type);

        /**
         * Resets the builder to default settings.
         * 
         * @return The builder
         */
        Builder reset();

        /**
         * Returns the {@link ClaimGroup}.
         * 
         * @return The claim group
         */
        ClaimGroup build();
    }
}
