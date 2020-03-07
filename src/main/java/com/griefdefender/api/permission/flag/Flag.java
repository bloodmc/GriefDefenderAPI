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
package com.griefdefender.api.permission.flag;

import com.griefdefender.api.CatalogType;
import com.griefdefender.api.GriefDefender;
import com.griefdefender.api.claim.ClaimType;

import net.kyori.text.Component;

public interface Flag extends CatalogType {

    /**
     * Returns the default flag value associated with
     * a specific {@link ClaimType}.
     * 
     * @param type The claim type
     * @return The default flag value
     */
    boolean getDefaultClaimTypeValue(ClaimType type);

    /**
     * Gets the option permission.
     * 
     * @return The permission
     */
    String getPermission();

    /**
     * Gets the {@link Component} description for option.
     * 
     * @return The description
     */
    Component getDescription();

    /**
     * Gets a new claim builder instance for {@link Builder}.
     * 
     * @return A new claim builder instance
     */
    static Flag.Builder builder() {
        return GriefDefender.getRegistry().createBuilder(Flag.Builder.class);
    }

    interface Builder {

        /**
         * The plugin id. 
         * 
         * @param pluginId The plugin id
         * @return The builder
         */
        Builder id(String pluginId);

        /**
         * The flag name.
         * 
         * @param flagName The flag name
         * @return The builder
         */
        Builder name(String flagName);

        /**
         * The flag description.
         * 
         * @param description The flag description
         * @return The builder
         */
        Builder description(Component description);

        /**
         * The flag permission
         * 
         * @param permission The flag permission
         * @return The builder
         */
        Builder permission(String permission);

        /**
         * Resets the builder to default settings.
         * 
         * @return The builder
         */
        Builder reset();

        /**
         * Returns the {@link Flag}.
         * 
         * @return The flag
         */
        Flag build();
    }
}
