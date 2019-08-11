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

import com.griefdefender.api.claim.Claim;
import com.griefdefender.api.util.generator.DummyObjectProvider;

public final class Options {

    /**
     * The portion of basic claim blocks returned to a player 
     * when a {@link Claim} is abandoned.
     */
    public static final Option ABANDON_RETURN_RATIO = DummyObjectProvider.createFor(Option.class, "abandon-return-ratio");

    /**
     * Maximum number of basic claims per player.<br>
     * 
     * Note: (0 = unlimited)
     */
    public static final Option CREATE_LIMIT = DummyObjectProvider.createFor(Option.class, "create-limit");

    /**
     * Number of days of inactivity before a basic claim will be deleted.
     */
    public static final Option EXPIRATION = DummyObjectProvider.createFor(Option.class, "expiration");

    /**
     * The max size in blocks that the x-axis can be.
     */
    public static final Option MAX_SIZE_X = DummyObjectProvider.createFor(Option.class, "max-size-x");

    /**
     * The max size in blocks that the y-axis can be.
     */
    public static final Option MAX_SIZE_Y = DummyObjectProvider.createFor(Option.class, "max-size-y");

    /**
     * The max size in blocks that the z-axis can be.
     */
    public static final Option MAX_SIZE_Z = DummyObjectProvider.createFor(Option.class, "max-size-z");

    /**
     * The min size in blocks that the x-axis can be.
     */
    public static final Option MIN_SIZE_X = DummyObjectProvider.createFor(Option.class, "min-size-x");

    /**
     * The min size in blocks that the y-axis can be.
     */
    public static final Option MIN_SIZE_Y = DummyObjectProvider.createFor(Option.class, "min-size-y");

    /**
     * The min size in blocks that the z-axis can be.
     */
    public static final Option MIN_SIZE_Z = DummyObjectProvider.createFor(Option.class, "min-size-z");

    /**
     * Number of days after not paying taxes before an automatic chest claim will be frozen.
     */
    public static final Option TAX_EXPIRATION = DummyObjectProvider.createFor(Option.class, "tax-expiration");

    /**
     * Number of days to keep a basic claim after frozen and before being deleted.
     */
    public static final Option TAX_EXPIRATION_DAYS_KEEP = DummyObjectProvider.createFor(Option.class, "tax-expiration-days-keep");

    /**
     * Tax is calculated by the number of claimblocks in the basic claim.
     */
    public static final Option TAX_RATE = DummyObjectProvider.createFor(Option.class, "tax-rate");

    /**
     * Blocks earned per hour.
     */
    public static final Option BLOCKS_ACCRUED_PER_HOUR = DummyObjectProvider.createFor(Option.class, "blocks-accrued-per-hour");

    /**
     * Number of days of inactivity before an automatic chest claim will be deleted.
     */
    public static final Option CHEST_EXPIRATION = DummyObjectProvider.createFor(Option.class, "chest-expiration");

    /**
     * The default claiming mode set for players on login.<br>
     * 
     * Note: (0 = 2D, 1 = 3D)
     */
    public static final Option CREATE_MODE = DummyObjectProvider.createFor(Option.class, "create-mode");

    /**
     * The cost in claim blocks used to sell a {@link Claim}.
     */
    public static final Option ECONOMY_BLOCK_COST = DummyObjectProvider.createFor(Option.class, "economy-block-cost");

    /**
     * The return ration for selling claim blocks.
     */
    public static final Option ECONOMY_BLOCK_SELL_RETURN = DummyObjectProvider.createFor(Option.class, "economy-block-sell-return");

    /**
     * The number of claim blocks a player has initially, by default.
     */
    public static final Option INITIAL_BLOCKS = DummyObjectProvider.createFor(Option.class, "initial-blocks");

    /**
     * The limit on accrued blocks (over time). doesn't limit purchased or admin-gifted blocks.
     */
    public static final Option MAX_ACCRUED_BLOCKS = DummyObjectProvider.createFor(Option.class, "max-accrued-blocks");

    /**
     * The maximum level that a claim can be created in.
     */
    public static final Option MAX_LEVEL = DummyObjectProvider.createFor(Option.class, "max-level");

    /**
     * The minimum level that a claim can be created in.
     */
    public static final Option MIN_LEVEL = DummyObjectProvider.createFor(Option.class, "min-level");

    /**
     * The radius in blocks used to list nearby claims.
     */
    public static final Option RADIUS_LIST = DummyObjectProvider.createFor(Option.class, "radius-list");

    /**
     * The radius in blocks used to search for nearby claims while inspecting.
     */
    public static final Option RADIUS_INSPECT = DummyObjectProvider.createFor(Option.class, "radius-inspect");

    /**
     * Used for executing a command with specific {@link Context}'s.<br>
     * Accepts the following placeholders :
     * <ul>
     * <li>%player%
     * <li>%owner%
     * <li>%uuid%
     * <li>%world%
     * <li>%server%
     * <li>%location%
     * </ul>
     */
    public static final Option PLAYER_COMMAND = DummyObjectProvider.createFor(Option.class, "command");

    /**
     * Used to determine if a player can fly in a {@link Claim}.<br>
     * 
     * Note: (-1 = undefined, 0 = false, 1 = true)
     */
    public static final Option PLAYER_FLY = DummyObjectProvider.createFor(Option.class, "player-fly");

    /**
     * Used to determine the gamemode of a player in a {@link Claim}.<br>
     * 
     * (-1 = undefined, 0 = survival, 1 = creative, 2 = adventure, 3 = spectator)
     */
    public static final Option PLAYER_GAMEMODE = DummyObjectProvider.createFor(Option.class, "player-gamemode");

    /**
     * Used to set the health regen amount for a player in a {@link Claim}.<br>
     * 
     * Note: If the player is at max health, this will have no effect.<br>
     * Note: (-1 = undefined, 0 = false, 1 = true)
     */
    public static final Option PLAYER_HEALTH_REGEN = DummyObjectProvider.createFor(Option.class, "player-health-regen");

    /**
     * Used to control a player's hunger in a {@link Claim}.<br>
     * 
     * Note: (-1 = undefined, 0 = false, 1 = true)
     */
    public static final Option PLAYER_HUNGER = DummyObjectProvider.createFor(Option.class, "player-hunger");

    /**
     * Used to determine if a player can keep inventory after death in a {@link Claim}.<br>
     * 
     * Note: (-1 = undefined, 0 = false, 1 = true)
     */
    public static final Option PLAYER_KEEP_INVENTORY = DummyObjectProvider.createFor(Option.class, "player-keep-inventory");

    /**
     * Used to determine if a player can keep their level after death in a {@link Claim}.<br>
     * 
     * Note: (-1 = undefined, 0 = false, 1 = true)
     */
    public static final Option PLAYER_KEEP_LEVEL = DummyObjectProvider.createFor(Option.class, "player-keep-level");

    /**
     * Used to set a player's walk speed in a {@link Claim}.<br>
     * 
     * Note: (-1 = undefined, 0 = false, 1 = true)
     */
    public static final Option PLAYER_WALK_SPEED = DummyObjectProvider.createFor(Option.class, "player-walk-speed");

    /**
     * Used to a player's weather in a {@link Claim}.<br>
     * 
     * Note: (-1 = undefined, 0 = clear, 1 = rain)
     */
    public static final Option PLAYER_WEATHER = DummyObjectProvider.createFor(Option.class, "player-weather");
}
