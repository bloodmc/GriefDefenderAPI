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
         * The flag name.
         * 
         * @param flagName The flag name
         * @return The builder
         */
        Builder<T> name(String name);

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
