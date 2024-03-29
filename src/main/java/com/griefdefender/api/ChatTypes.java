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
package com.griefdefender.api;

import com.griefdefender.api.util.generator.DummyObjectProvider;

/**
 * ChatTypes is a list of the default chat types that are available in Vanilla
 * Minecraft.
 */
public final class ChatTypes {

    private ChatTypes() {
    }
    // SORTFIELDS:ON

    /**
     * The position right above the inventory, experience, health, item name,
     * etc. bars.
     */
    public static ChatType ACTION_BAR = DummyObjectProvider.createFor(ChatType.class, "ACTION_BAR");

    /**
     * The standard chat position in prompt at the bottom-left.
     */
    public static ChatType CHAT = DummyObjectProvider.createFor(ChatType.class, "CHAT");
    // SORTFIELDS:OFF

}
