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
package com.griefdefender.api;

import com.google.common.base.Supplier;
import com.griefdefender.api.claim.Claim;
import com.griefdefender.api.registry.CatalogRegistryModule;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import org.checkerframework.checker.nullness.qual.Nullable;

public interface Registry {

    /**
     * Registers a {@link Supplier} for creating the desired {@link Builder}.
     *
     * @param builderClass The builder class
     * @param supplier The supplier
     * @param <T> The type of builder/supplier
     * @return This registry, for chaining
     */
    <T> Registry registerBuilderSupplier(Class<T> builderClass, Supplier<? extends T> supplier);

    /**
     * Gets a builder of the desired class type, examples may include:
     * {@link Claim.Builder}, etc.
     *
     * @param builderClass The class of the builder
     * @param <T> The type of builder
     * @return The builder, if available
     * @throws IllegalArgumentException If there is no supplier for the given
     *      builder class
     */
    <T> T createBuilder(Class<T> builderClass) throws IllegalArgumentException;

    /**
     * Attempts to retrieve the specific type of {@link CatalogType} based on
     * the string id given.
     *
     * <p>Some types may not be available for various reasons including but not
     * restricted to: mods adding custom types, plugins providing custom types,
     * game version changes.</p>
     *
     * @param typeClass The class of the type of {@link CatalogType}
     * @param id The case insensitive string id of the dummy type
     * @param <T> The type of dummy type
     * @return The found dummy type, if available
     * @see CatalogType
     */
    <T extends CatalogType> Optional<T> getType(Class<T> typeClass, String id);

    /**
     * Gets a collection of all available found specific types of
     * {@link CatalogType} requested.
     *
     * <p>The presented {@link CatalogType}s may not exist in default catalogs
     * due to various reasons including but not restricted to: mods, plugins,
     * game changes.</p>
     *
     * @param typeClass The class of {@link CatalogType}
     * @param <T> The type of {@link CatalogType}
     * @return A collection of all known types of the requested catalog type
     */
    <T extends CatalogType> Collection<T> getAllOf(Class<T> typeClass);

    /**
     * Gets a collection of all available found specific types of
     * {@link CatalogType} requested.
     *
     * @param pluginId The plugin id to check for types
     * @param typeClass The class of {@link CatalogType}
     * @param <T> The type of {@link CatalogType}
     * @return A collection of all known types of the requested catalog type
     */
    <T extends CatalogType> Collection<T> getAllFor(String pluginId, Class<T> typeClass);

    /**
     * Gets the {@link CatalogRegistryModule} for supplied 
     * catalog class.
     * 
     * @return The catalog registry module
     */
    public <T extends CatalogType> Optional<CatalogRegistryModule<T>> getRegistryModuleFor(Class<T> catalogClass);

    /**
     * Attempts to lookup a given object's identifier in registry.
     * 
     * Note: Accepts common Minecraft objects such as Block, Entity, TileEntity, Item, and ItemStack.
     * Note: The object passed should represent the API object version of the platform.
     * 
     * @param object The object
     * @return The identifier, if available
     */
    @Nullable
    public String lookupId(Object object);

    /**
     * Attempts to lookup a player's username by {@link UUID}.
     * 
     * @param uuid The player's UUID
     * @return The username, if available
     */
    @Nullable
    public String lookupUsername(UUID uuid);
}
