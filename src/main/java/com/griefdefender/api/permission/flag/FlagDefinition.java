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

import com.griefdefender.api.GriefDefender;
import com.griefdefender.api.Subject;
import com.griefdefender.api.Tristate;
import com.griefdefender.api.gui.Icon;
import com.griefdefender.api.permission.Context;
import com.griefdefender.api.permission.PermissionDefinition;

import net.kyori.adventure.text.Component;

/**
 * Represents a flag definition which can hold one or more {@link Flag} permissions.
 */
public interface FlagDefinition extends PermissionDefinition {

    /**
     * Gets the default value.
     *  
     * @return The default value
     */
    Tristate getDefaultValue();

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
     * Sets the default value of definition.
     * 
     * @param value The default value
     */
    void setDefaultValue(Tristate value);

    /**
     * Gets a new claim builder instance for {@link Builder}.
     * 
     * @return A new claim builder instance
     */
    public static FlagDefinition.Builder builder() {
        return GriefDefender.getRegistry().createBuilder(FlagDefinition.Builder.class);
    }

    public interface Builder {

        /**
         * Whether this definition is enabled.
         * 
         * @param enabled
         * @return The builder
         */
        Builder enabled(boolean enabled);

        /**
         * Whether definition is for admin use only.
         * 
         * @param value
         * @return The builder
         */
        Builder admin(boolean value);

        /**
         * Whether this definition supports managing owner and trusted.
         * 
         * <br><br>Note: This should only be true if a player can cause the flag action(s).
         * 
         * @param value
         * @return The builder
         */
        Builder ownerMode(boolean value);

        /**
         * Sets the definition group.
         * 
         * @param group
         * @return The builder
         */
        Builder group(String group);

        /**
         * Sets the preset.
         * 
         * <br><br>Note: It is recommended to use modid.
         * <br>Note: This is where all flag definition and group information will be stored.
         * 
         * @param prest
         * @return The builder
         */
        Builder preset(String preset);

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
        Builder flagData(FlagData data);

        /**
         * Sets the flag data.
         * 
         * @param data The flag data
         * @return The builder
         */
        Builder flagData(List<FlagData> data);

        /**
         * Sets the context.
         * 
         * @param context The context
         * @return The builder
         */
        Builder context(Context context);

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
         * Sets the group description.
         * 
         * @param description The group description
         * @return The builder
         */
        Builder groupDescription(Component description);

        /**
         * Sets the subject.
         * 
         * @param subject The subject
         * @return The builder
         */
        Builder subject(Subject subject);

        /**
         * Sets the {@link Icon}.
         * 
         * @param icon The icon
         * @return The builder
         */
        Builder icon(Icon icon);

        /**
         * Resets the builder to default settings.
         * 
         * @return The builder
         */
        Builder reset();

        /**
         * Returns the {@link FlagDefinition}.
         * 
         * <br><br>Note: The preset, group, and name MUST be a unique combination 
         * as it represents the definition id.
         * 
         * @return The flag data
         */
        FlagDefinition build();
    }
}
