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

import java.util.List;
import java.util.Set;

import com.griefdefender.api.CatalogType;
import com.griefdefender.api.GriefDefender;
import com.griefdefender.api.Tristate;
import com.griefdefender.api.permission.Context;

import net.kyori.text.Component;

/**
 * Represents a flag definition which can hold one or more {@link Flag} permissions.
 */
public interface FlagDefinition extends CatalogType {

    /**
     * Whether this definition is enabled.
     * 
     * @return true if enabled
     */
    boolean isEnabled();

    /**
     * Gets the group name associated with this flag definition.
     * 
     * @return The group name
     */
    String getGroupName();

    /**
     * Gets the friendly description.
     * 
     * @return The friendly description
     */
    String getFriendlyDescription();

    /**
     * Gets the default value.
     *  
     * @return The default value
     */
    Tristate getDefaultValue();

    /**
     * Gets the description.
     * 
     * @return The description
     */
    Component getDescription();

    /**
     * Gets the contexts associated with this definition.
     * 
     * @return The definition contexts
     */
    Set<Context> getContexts();

    /**
     * Gets the {@link FlagData} associated with this definition.
     * 
     * @return The flag data
     */
    List<FlagData> getFlagData();

    /**
     * Gets a list of {@link Flag}'s associated with this definition.
     * 
     * @return The list of flags
     */
    List<Flag> getFlags();

    /**
     * Adds {@link FlagData} to this definition.
     * 
     * @param flagData The flag data to add
     */
    void addFlagData(FlagData flagData);

    /**
     * Sets {@link Context}'s associated with this definition.
     * 
     * @param contexts
     */
    void setContexts(Set<Context> contexts);

    /**
     * Set to enable or disable this definition.
     * 
     * @param enabled
     */
    void setIsEnabled(boolean enabled);

    /**
     * Sets the default value of definition.
     * 
     * @param value The default value
     */
    void setDefaultValue(Tristate value);

    /**
     * Sets the group associated with this definition.
     * 
     * @param group The group name
     */
    void setGroupName(String group);

    /**
     * Gets a new claim builder instance for {@link Builder}.
     * 
     * @return A new claim builder instance
     */
    static FlagDefinition.Builder builder() {
        return GriefDefender.getRegistry().createBuilder(FlagDefinition.Builder.class);
    }

    interface Builder {

        /**
         * Whether this definition is enabled.
         * 
         * @param enabled
         * @return The builder
         */
        Builder enabled(boolean enabled);

        /**
         * Sets the default value.
         * 
         * @param value The default value
         * @return The builder
         */
        Builder defaultValue(Tristate value);

        /**
         * Sets the flag data.
         * 
         * @param data The flag data
         * @return The builder
         */
        Builder flagData(List<FlagData> data);

        /**
         * Sets the contexts.
         * 
         * @param contexts The contexts
         * @return The builder
         */
        Builder contexts(Set<Context> contexts);

        /**
         * Sets the definition name.
         * 
         * @param name The definition name
         * @return The builder
         */
        Builder name(String name);

        /**
         * Sets the description.
         * 
         * @param description The description
         * @return The builder
         */
        Builder description(Component description);

        /**
         * Resets the builder to default settings.
         * 
         * @return The builder
         */
        Builder reset();

        /**
         * Returns the {@link FlagDefinition}.
         * 
         * @return The flag data
         */
        FlagDefinition build();
    }
}
