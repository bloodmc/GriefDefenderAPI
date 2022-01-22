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

import java.util.List;

import javax.annotation.Nullable;

import com.griefdefender.api.GriefDefender;

import net.kyori.adventure.text.Component;

public interface Icon {

    /**
     * Gets the id used for icon.
     * 
     * @return The icon id
     */
    String getId();

    /**
     * Gets the icon title.
     * 
     * @return The icon title
     */
    Component getTitle();

    /**
     * Gets the icon lore.
     * 
     * @return The icon lore
     */
    Component getLore();

    /**
     * Gets the icon sound.
     * 
     * @return The icon sound
     */
    @Nullable String getSound();

    /**
     * Gets the icon model data.
     * 
     * @return The icon model data, if available
     */
    @Nullable Integer getModelData();

    /**
     * Gets the icon meta.
     * 
     * @return The icon meta
     */
    int getMeta();

    /**
     * Gets the icon quantity.
     * 
     * @return The icon quantity
     */
    int getQuantity();

    /**
     * Gets whether this icon is enchanted.
     * 
     * @return whether icon is enchanted
     */
    boolean isEnchanted();

    /**
     * Gets the list of {@link IconFlag}'s.
     * 
     * @return An immutable list of icon flags
     */
    List<IconFlag> getIconFlags();

    /**
     * Gets a new {@link Icon} builder instance for {@link Builder}.
     * 
     * @return A new icon builder instance
     */
    public static Icon.Builder builder() {
        return GriefDefender.getRegistry().createBuilder(Icon.Builder.class);
    }

    public interface Builder {

        String getId();

        String getSound();

        Integer getModelData();

        int getMeta();

        int getQuantity();

        boolean getIsEnchanted();

        Component getTitle();

        Component getLore();

        List<IconFlag> getIconFlags();

        Builder id(String id);

        Builder sound(String sound);

        Builder meta(int meta);

        Builder model(int model);

        Builder quantity(int quantity);

        Builder title(Component title);

        Builder lore(Component lore);

        Builder enchanted(boolean enchanted);

        Builder iconFlags(IconFlag... flags);

        Builder reset();

        Icon build();
    }
}
