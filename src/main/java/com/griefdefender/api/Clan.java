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

import java.util.List;
import java.util.UUID;

import com.flowpowered.math.vector.Vector3i;

import net.kyori.adventure.text.Component;

public interface Clan extends CatalogType {

    /**
     * Get clan name {@link Component}.
     * 
     * @return The clan name
     */
    Component getNameComponent();

    /**
     * Get clan tag {@link Component}
     * 
     * @return The clan tag
     */
    Component getTagComponent();

    /**
     * Get clan tag name.
     * 
     * @return The clan tag
     */
    String getTag();

    /**
     * Get clan description
     * 
     * @return The clan description
     */
    String getDescription();

    /**
     * Get clan's home world {@link UUID}.
     * 
     * @return The clan's home world uuid
     */
    UUID getHomeWorldUniqueId();

    /**
     * Get clan's home position.
     * 
     * @return The clan's home pos
     */
    Vector3i getHomePos();

    /**
     * Get list of clan allies.
     * 
     * @return The immutable list of clan allies
     */
    List<Clan> getAllies();

    /**
     * Get list of clan rivals.
     * 
     * @return The immutable list of clan rivals
     */
    List<Clan> getRivals();

    /**
     * Get list of clan member {@link ClanPlayer}'s
     * 
     * @return The clan member list
     */
    default List<ClanPlayer> getMembers() {
        return this.getMembers(false);
    }

    /**
     * Get list of clan member {@link ClanPlayer}'s
     * 
     * @param onlineOnly Whether the list should contain online members only
     * @return The clan member list
     */
    List<ClanPlayer> getMembers(boolean onlineOnly);

    /**
     * Get list of clan leader {@link ClanPlayer}'s
     * 
     * @return The clan leader list
     */
    default List<ClanPlayer> getLeaders() {
        return this.getLeaders(false);
    }

    /**
     * Get list of clan leader {@link ClanPlayer}'s
     * 
     * @param onlineOnly Whether the list should contain online leaders only
     * @return The clan leader list
     */
    List<ClanPlayer> getLeaders(boolean onlineOnly);
}
