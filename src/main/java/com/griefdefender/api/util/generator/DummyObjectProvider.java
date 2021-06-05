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
package com.griefdefender.api.util.generator;

import com.griefdefender.api.CatalogType;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This class dynamically generates a dummy class for a given interface (usually a {@link CatalogType}).
 *
 * <p>The generated class implements all of the interface's methods, but
 * throws an {@link UnsupportedOperationException} with an informative error message.</p>
 */
public final class DummyObjectProvider {

    static final DummyClassGeneratorProvider factoryProvider = new DummyClassGeneratorProvider("com.griefdefender.api.util.dummy");
    static Map<Class<?>, Class<?>> cacheMap = new ConcurrentHashMap<>();

    /**
     * Creates a new dummy class implementing the specified interface.
     *
     * @param type The interface to generate a dummy class for
     * @param fieldName field name to pass to constructor
     * @param <T> The type of class to be created
     * @return The generated dummy class
     */
    @SuppressWarnings("unchecked")
    public static <T> T createFor(Class<T> type, String fieldName) {
        try {
            if (cacheMap.get(type) != null) {
                return (T) cacheMap.get(type).getConstructor(String.class).newInstance(fieldName);
            }
            final Class<?> dummyClass = factoryProvider.create(type, UnsupportedOperationException.class);
            cacheMap.put(type, dummyClass);
            return (T) dummyClass.getConstructor(String.class).newInstance(fieldName);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(String.format("Failed to instantiate dummy class for class %s", type), e);
        }
    }

    /**
     * Creates a new dummy class implementing the specified interface.
     *
     * @param type The interface to generate a dummy class for
     * @param fieldName field name to pass to constructor
     * @param <T> Base type for the dummy class
     * @param <I> Interface for the dummy class to implement
     * @return The generated dummy class
     */
    @SuppressWarnings("unchecked")
    public static <T, I extends T> I createExtendedFor(Class<T> type, String fieldName) {
        try {
            if (cacheMap.get(type) != null) {
                return (I) cacheMap.get(type).getConstructor(String.class).newInstance(fieldName);
            }
            final Class<?> dummyClass = factoryProvider.create(type, UnsupportedOperationException.class);
            cacheMap.put(type, dummyClass);
            return (I) dummyClass.getConstructor(String.class).newInstance(fieldName);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(String.format("Failed to instantiate dummy class for class %s", type), e);
        }
    }

}
