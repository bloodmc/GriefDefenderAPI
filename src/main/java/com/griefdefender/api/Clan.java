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

import org.checkerframework.checker.nullness.qual.Nullable;

import com.flowpowered.math.vector.Vector3i;
import com.griefdefender.api.clan.ClanHome;
import com.griefdefender.api.clan.Rank;

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
     * Get clan's base world {@link UUID}.
     * 
     * @return The clan's base world uuid
     */
    @Nullable UUID getBaseWorldUniqueId();

    /**
     * Get clan's base position.
     * 
     * @return The clan's base pos
     */
    @Nullable Vector3i getBasePos();

    /**
     * A list of {@link ClanHome}'s.
     * 
     * @return An unmodifiable list of clan homes
     */
    List<ClanHome> getHomes();

    /**
     * Get list of clan allies.
     * 
     * @return An unmodifiable list of clan allies
     */
    List<Clan> getAllies();

    /**
     * Get list of clan rivals.
     * 
     * @return An unmodifiable list of clan rivals
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

    /**
     * Get list of available clan ranks.
     * 
     * @return The clan rank list
     */
    List<Rank> getRanks();

    /**
     * Gets {@link Rank} with specified name.
     * 
     * @param rank The rank name
     * @return The rank
     */
    @Nullable Rank getRank(String rankName);

    /**
     * Checks if clan tag is ally.
     * 
     * @param tag The clan tag to check
     * @return true if ally, false if not
     */
    boolean isAlly(String tag);

    /**
     * Checks if clan tag is rival.
     * 
     * @param tag The clan tag to check
     * @return true if rival, false if not
     */
    boolean isRival(String tag);
}
