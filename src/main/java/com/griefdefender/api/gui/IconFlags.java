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
package com.griefdefender.api.gui;

import com.griefdefender.api.util.generator.DummyObjectProvider;

public class IconFlags {

    /**
     * Controls whether to show enchants
     */
    public static final IconFlag HIDE_ENCHANTS = DummyObjectProvider.createFor(IconFlag.class, "HIDE_ENCHANTS");

    /**
     * Controls whether to show attributes
     */
    public static final IconFlag HIDE_ATTRIBUTES = DummyObjectProvider.createFor(IconFlag.class, "HIDE_ATTRIBUTES");

    /**
     * Controls whether to show the unbreakable state
     */
    public static final IconFlag HIDE_UNBREAKABLE = DummyObjectProvider.createFor(IconFlag.class, "HIDE_UNBREAKABLE");

    /**
     * Controls whether to show what can break or destroy
     */
    public static final IconFlag HIDE_DESTROYS = DummyObjectProvider.createFor(IconFlag.class, "HIDE_DESTROYS");

    /**
     * Controls whether to show what can be build or placed on
     */
    public static final IconFlag HIDE_PLACED_ON = DummyObjectProvider.createFor(IconFlag.class, "HIDE_PLACED_ON");

    /**
     * Controls whether to show potion effects
     */
    public static final IconFlag HIDE_POTION_EFFECTS = DummyObjectProvider.createFor(IconFlag.class, "HIDE_POTION_EFFECTS");

    /**
     * Controls whether to show dyes
     */
    public static final IconFlag HIDE_DYE = DummyObjectProvider.createFor(IconFlag.class, "HIDE_DYE");
}
