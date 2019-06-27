/*
 * This file is part of GriefDefenderAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
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
package com.griefdefender.api.registry;

import com.griefdefender.api.CatalogType;
import com.griefdefender.api.Registry;
import com.griefdefender.api.permission.flag.Flag;

/**
 * A module that handles registrations of {@link Object}s, usually
 * {@link CatalogType}s. The use of this is to manage like-object
 * registrations in a centralized manner, without requiring hard
 * {@code ids} or content affecting behavior. All {@code module}s
 * are to be loaded and registered with the {@link Registry}.
 *
 */
public interface RegistryModule<T> {

    /**
     * Performs default registrations of objects for use with the
     * {@link Registry}. This is only called once, either at the
     * pre-initialization phase of the {@link Registry}
     */
    default void registerDefaults() { }

    /**
     * Used to register a custom type such as a {@link Flag}.
     * 
     * @param type The custom type to register
     */
    void registerCustomType(T type);
}
