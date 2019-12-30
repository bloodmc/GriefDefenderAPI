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
package com.griefdefender.api.permission.option;

import com.griefdefender.api.CatalogType;
import com.griefdefender.api.GriefDefender;
import net.kyori.text.Component;

import java.util.Set;

public interface Option<T> extends CatalogType {

    /**
     * Whether this option can only apply globally.
     * 
     * @return <code>true</code> if the option only
     *         applies globally. 
     *         <code>false</code> otherwise.
     */
    boolean isGlobal();

    /**
     * Whether this option can support multiple values.
     * 
     * @return <code>true</code> if the option supports
     *          multiple values. 
     *         <code>false</code> otherwise.
     */
    boolean multiValued();

    /**
     * A set of required context keys that must be set.
     * 
     * @return An immutable set of required context keys
     */
    Set<String> getRequiredContextKeys();

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
     * Gets the default value.
     * 
     * @return The default value
     */
    T getDefaultValue();

    /**
     * Gets the allowed type for the value of this option.
     * 
     * @return The allowed type
     */
    Class<T> getAllowedType();

    /**
     * Creates a builder to be used for creating a new {@link EventContextKey}.
     *
     * @param clazz The class the key will allow access to
     * @param <T> The type of the value stored with this key
     * @return The constructed builder
     */
    @SuppressWarnings("unchecked")
    static <T> Builder<T> builder(Class<T> clazz) {
        return GriefDefender.getRegistry().createBuilder(Builder.class).type(clazz);
    }

    interface Builder<T> {

        Builder<T> type(Class<T> tClass);

        /**
         * The plugin id. 
         * 
         * @param id The plugin id
         * @return The builder
         */
        Builder<T> id(String pluginId);

        /**
         * The option name.
         * 
         * @param name The option name
         * @return The builder
         */
        Builder<T> name(String name);

        /**
         * The option description.
         * 
         * @param description The option description
         * @return The builder
         */
        Builder<T> description(Component description);

        /**
         * Whether the option supports multiple values.
         * 
         * @param multi True if multi, false otherwise 
         * @return The builder
         */
        Builder<T> multiValued(boolean multi);

        /**
         * The required context keys.
         * 
         * @param keys The context keys
         * @return The builder
         */
        Builder<T> requiredContextKeys(Set<String> keys);

        /**
         * Resets the builder to default settings.
         * 
         * @return The builder
         */
        Builder<T> reset();

        /**
         * Returns the {@link Option}.
         * 
         * @return The option
         */
        Option<T> build();
    }
}
