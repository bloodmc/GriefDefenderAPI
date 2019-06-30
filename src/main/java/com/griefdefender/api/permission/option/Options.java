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

import com.griefdefender.api.util.generator.DummyObjectProvider;

public final class Options {

    public static final Option ABANDON_RETURN_RATIO = DummyObjectProvider.createFor(Option.class, "abandon-return-ratio");
    public static final Option CREATE_LIMIT = DummyObjectProvider.createFor(Option.class, "create-limit");
    public static final Option EXPIRATION = DummyObjectProvider.createFor(Option.class, "expiration");
    public static final Option MAX_SIZE_X = DummyObjectProvider.createFor(Option.class, "max-size-x");
    public static final Option MAX_SIZE_Y = DummyObjectProvider.createFor(Option.class, "max-size-y");
    public static final Option MAX_SIZE_Z = DummyObjectProvider.createFor(Option.class, "max-size-z");
    public static final Option MIN_SIZE_X = DummyObjectProvider.createFor(Option.class, "min-size-x");
    public static final Option MIN_SIZE_Y = DummyObjectProvider.createFor(Option.class, "min-size-y");
    public static final Option MIN_SIZE_Z = DummyObjectProvider.createFor(Option.class, "min-size-z");
    public static final Option TAX_EXPIRATION = DummyObjectProvider.createFor(Option.class, "tax-expiration");
    public static final Option TAX_EXPIRATION_DAYS_KEEP = DummyObjectProvider.createFor(Option.class, "tax-expiration-days-keep");
    public static final Option TAX_RATE = DummyObjectProvider.createFor(Option.class, "tax-rate");

    // Global
    public static final Option BLOCKS_ACCRUED_PER_HOUR = DummyObjectProvider.createFor(Option.class, "blocks-accrued-per-hour");
    public static final Option CHEST_EXPIRATION = DummyObjectProvider.createFor(Option.class, "chest-expiration");
    public static final Option CREATE_MODE = DummyObjectProvider.createFor(Option.class, "create-mode");
    public static final Option ECONOMY_BLOCK_COST = DummyObjectProvider.createFor(Option.class, "economy-block-cost");
    public static final Option ECONOMY_BLOCK_SELL_RETURN = DummyObjectProvider.createFor(Option.class, "economy-block-sell-return");
    public static final Option INITIAL_BLOCKS = DummyObjectProvider.createFor(Option.class, "initial-blocks");
    public static final Option MAX_ACCRUED_BLOCKS = DummyObjectProvider.createFor(Option.class, "max-accrued-blocks");
    public static final Option MAX_LEVEL = DummyObjectProvider.createFor(Option.class, "max-level");
    public static final Option MIN_LEVEL = DummyObjectProvider.createFor(Option.class, "min-level");
    public static final Option RADIUS_LIST = DummyObjectProvider.createFor(Option.class, "radius-list");
    public static final Option RADIUS_INSPECT = DummyObjectProvider.createFor(Option.class, "radius-inspect");
}
