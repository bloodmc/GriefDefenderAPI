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

import com.griefdefender.api.Tristate;
import com.griefdefender.api.claim.Claim;
import com.griefdefender.api.permission.Context;
import com.griefdefender.api.permission.option.type.CreateModeType;
import com.griefdefender.api.permission.option.type.CreateModeTypes;
import com.griefdefender.api.permission.option.type.GameModeType;
import com.griefdefender.api.permission.option.type.GameModeTypes;
import com.griefdefender.api.permission.option.type.WeatherType;
import com.griefdefender.api.permission.option.type.WeatherTypes;
import com.griefdefender.api.util.generator.DummyObjectProvider;

import java.util.List;

@SuppressWarnings("unchecked")
public final class Options {

    /**
     * The amount of days before a newly created {@link Claim} can be abandoned.
     */
    public static final Option<Integer> ABANDON_DELAY = DummyObjectProvider.createFor(Option.class, "abandon-delay");

    /**
     * The portion of basic claim blocks returned to a player 
     * when a {@link Claim} is abandoned.
     */
    public static final Option<Double> ABANDON_RETURN_RATIO = DummyObjectProvider.createFor(Option.class, "abandon-return-ratio");

    /**
     * Maximum number of basic claims per player.<br>
     * 
     * Note: (-1 = unlimited)
     */
    public static final Option<Integer> CREATE_LIMIT = DummyObjectProvider.createFor(Option.class, "create-limit");

    /**
     * Number of days of inactivity before a basic claim will be deleted.
     */
    public static final Option<Integer> EXPIRATION = DummyObjectProvider.createFor(Option.class, "expiration");

    /**
     * The max size in blocks that the x-axis can be.
     */
    public static final Option<Integer> MAX_SIZE_X = DummyObjectProvider.createFor(Option.class, "max-size-x");

    /**
     * The max size in blocks that the y-axis can be.
     */
    public static final Option<Integer> MAX_SIZE_Y = DummyObjectProvider.createFor(Option.class, "max-size-y");

    /**
     * The max size in blocks that the z-axis can be.
     */
    public static final Option<Integer> MAX_SIZE_Z = DummyObjectProvider.createFor(Option.class, "max-size-z");

    /**
     * The min size in blocks that the x-axis can be.
     */
    public static final Option<Integer> MIN_SIZE_X = DummyObjectProvider.createFor(Option.class, "min-size-x");

    /**
     * The min size in blocks that the y-axis can be.
     */
    public static final Option<Integer> MIN_SIZE_Y = DummyObjectProvider.createFor(Option.class, "min-size-y");

    /**
     * The min size in blocks that the z-axis can be.
     */
    public static final Option<Integer> MIN_SIZE_Z = DummyObjectProvider.createFor(Option.class, "min-size-z");

    /**
     * Number of days after not paying taxes before a claim will be frozen.
     */
    public static final Option<Integer> TAX_EXPIRATION = DummyObjectProvider.createFor(Option.class, "tax-expiration");

    /**
     * Number of days to keep a basic claim after frozen and before being deleted.
     */
    public static final Option<Integer> TAX_EXPIRATION_DAYS_KEEP = DummyObjectProvider.createFor(Option.class, "tax-expiration-days-keep");

    /**
     * Tax is calculated by the number of claimblocks in the basic claim.
     */
    public static final Option<Double> TAX_RATE = DummyObjectProvider.createFor(Option.class, "tax-rate");

    /**
     * Blocks earned per hour.
     */
    public static final Option<Integer> BLOCKS_ACCRUED_PER_HOUR = DummyObjectProvider.createFor(Option.class, "blocks-accrued-per-hour");

    /**
     * Number of days of inactivity before an automatic chest claim will be deleted.
     */
    public static final Option<Integer> CHEST_EXPIRATION = DummyObjectProvider.createFor(Option.class, "chest-expiration");

    /**
     * The default claiming mode set for players on login.<br>
     * 
     * Accepts the following values :
     * <ul>
     * <li>{@link CreateModeTypes#AREA}
     * <li>{@link CreateModeTypes#VOLUME}
     * <li>{@link CreateModeTypes#UNDEFINED}
     * </ul>
     */
    public static final Option<CreateModeType> CREATE_MODE = DummyObjectProvider.createFor(Option.class, "create-mode");

    /**
     * The economy amount to charge per block of a {@link Claim}.<br>
     * 
     * Note: The formula to calculate price is {amount} * {@link Claim#getClaimBlocks()}
     */
    public static final Option<Double> ECONOMY_BLOCK_COST = DummyObjectProvider.createFor(Option.class, "economy-block-cost");

    /**
     * The return ration for selling claim blocks.
     */
    public static final Option<Double> ECONOMY_BLOCK_SELL_RETURN = DummyObjectProvider.createFor(Option.class, "economy-block-sell-return");

    /**
     * The number of claim blocks a player has initially, by default.
     */
    public static final Option<Integer> INITIAL_BLOCKS = DummyObjectProvider.createFor(Option.class, "initial-blocks");

    /**
     * The total number of claim blocks accrued by a player.
     * 
     * Note: This does not account for bonus blocks.
     */
    public static final Option<Integer> ACCRUED_BLOCKS = DummyObjectProvider.createFor(Option.class, "accrued-blocks");

    /**
     * The total number of bonus claim blocks given to a player.
     */
    public static final Option<Integer> BONUS_BLOCKS = DummyObjectProvider.createFor(Option.class, "bonus-blocks");

    /**
     * The limit on accrued blocks (over time). doesn't limit purchased or admin-gifted blocks.
     */
    public static final Option<Integer> MAX_ACCRUED_BLOCKS = DummyObjectProvider.createFor(Option.class, "max-accrued-blocks");

    /**
     * The maximum level that a claim can be created in.
     */
    public static final Option<Integer> MAX_LEVEL = DummyObjectProvider.createFor(Option.class, "max-level");

    /**
     * The minimum level that a claim can be created in.
     */
    public static final Option<Integer> MIN_LEVEL = DummyObjectProvider.createFor(Option.class, "min-level");

    /**
     * The radius in blocks used to search for nearby claims while inspecting.
     */
    public static final Option<Integer> RADIUS_INSPECT = DummyObjectProvider.createFor(Option.class, "radius-inspect");

    /**
     * Used to determine if a raid can occur in a {@link Claim}.
     */
    public static final Option<Boolean> RAID = DummyObjectProvider.createFor(Option.class, "raid");

    /**
     * Used to determine the spawn limit for a specific set of {@link Context}'s in a claim.
     * 
     * Note: Supports multiple values.
     */
    public static final Option<Integer> SPAWN_LIMIT = DummyObjectProvider.createFor(Option.class, "spawn-limit");

    /**
     * Used for executing a command on {@link Claim} enter with specific {@link Context}'s.<br>
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
    public static final Option<List<String>> PLAYER_COMMAND_ENTER = DummyObjectProvider.createFor(Option.class, "player-command-enter");

    /**
     * Used for executing a command on {@link Claim} exit with specific {@link Context}'s.<br>
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
    public static final Option<List<String>> PLAYER_COMMAND_EXIT = DummyObjectProvider.createFor(Option.class, "player-command-exit");

    /**
     * Used to determine if a player is unable to fly in a {@link Claim}.<br>
     * 
     * Note: This does not give players the ability to fly, it merely removes
     * the ability if set. This provides the greatest compatibility with
     * plugins.
     */
    public static final Option<Boolean> PLAYER_DENY_FLIGHT = DummyObjectProvider.createFor(Option.class, "player-deny-flight");

    /**
     * Used to determine if a player can be in godmode within a {@link Claim}.<br>
     * 
     * Note: This does not give players the ability to be in godmode, it merely removes
     * the ability if set. This provides the greatest compatibility with
     * plugins.
     */
    public static final Option<Boolean> PLAYER_DENY_GODMODE = DummyObjectProvider.createFor(Option.class, "player-deny-godmode");

    /**
     * Used to if a player's hunger is denied in a {@link Claim}.<br>
     * 
     * Note: This does not give players the ability to gain hunger, it merely removes
     * the ability to cause hunger if set. This provides the greatest compatibility with
     * plugins.
     */
    public static final Option<Boolean> PLAYER_DENY_HUNGER = DummyObjectProvider.createFor(Option.class, "player-deny-hunger");

    /**
     * Used to determine the gamemode of a player in a {@link Claim}.<br>
     * 
     * Accepts the following values :
     * <ul>
     * <li>{@link GameModeTypes#ADVENTURE}
     * <li>{@link GameModeTypes#CREATIVE}
     * <li>{@link GameModeTypes#SURVIVAL}
     * <li>{@link GameModeTypes#SPECTATOR}
     * <li>{@link GameModeTypes#UNDEFINED}
     * </ul>
     */
    public static final Option<GameModeType> PLAYER_GAMEMODE = DummyObjectProvider.createFor(Option.class, "player-gamemode");

    /**
     * Used to set the health regen amount for a player in a {@link Claim}.<br>
     * 
     * Note: If the player is at max health, this will have no effect.<br>
     * Note: (-1 = undefined)
     */
    public static final Option<Double> PLAYER_HEALTH_REGEN = DummyObjectProvider.createFor(Option.class, "player-health-regen");

    /**
     * Used to determine if a player can keep inventory after death in a {@link Claim}.<br>
     * 
     * Accepts the following values :
     * <ul>
     * <li>{@link Tristate#TRUE}
     * <li>{@link Tristate#FALSE}
     * <li>{@link Tristate#UNDEFINED}
     * </ul>
     */
    public static final Option<Tristate> PLAYER_KEEP_INVENTORY = DummyObjectProvider.createFor(Option.class, "player-keep-inventory");

    /**
     * Used to determine if a player can keep their level after death in a {@link Claim}.<br>
     * 
     * Accepts the following values :
     * <ul>
     * <li>{@link Tristate#TRUE}
     * <li>{@link Tristate#FALSE}
     * <li>{@link Tristate#UNDEFINED}
     * </ul>
     */
    public static final Option<Tristate> PLAYER_KEEP_LEVEL = DummyObjectProvider.createFor(Option.class, "player-keep-level");

    /**
     * Used to determine the delay before teleporting a player to a new location.
     */
    public static final Option<Integer> PLAYER_TELEPORT_DELAY = DummyObjectProvider.createFor(Option.class, "player-teleport-delay");

    /**
     * Used to set a player's walk speed in a {@link Claim}.<br>
     * 
     * Note: (-1.0 = undefined)
     */
    public static final Option<Double> PLAYER_WALK_SPEED = DummyObjectProvider.createFor(Option.class, "player-walk-speed");

    /**
     * Used to set a player's weather in a {@link Claim}.<br>
     * Accepts the following values :
     * <ul>
     * <li>{@link WeatherTypes#CLEAR}
     * <li>{@link WeatherTypes#DOWNFALL}
     * <li>{@link WeatherTypes#UNDEFINED}
     * </ul>
     */
    public static final Option<WeatherType> PLAYER_WEATHER = DummyObjectProvider.createFor(Option.class, "player-weather");

    /**
     * Used to determine if players can combat each other.
     */
    public static final Option<Tristate> PVP = DummyObjectProvider.createFor(Option.class, "pvp");

    /**
     * Used to determine if a player can use commands during PvP combat.
     */
    public static final Option<Boolean> PVP_COMBAT_COMMAND = DummyObjectProvider.createFor(Option.class, "pvp-combat-command");

    /**
     * Used to determine if a player can teleport during PvP combat.
     */
    public static final Option<Boolean> PVP_COMBAT_TELEPORT = DummyObjectProvider.createFor(Option.class, "pvp-combat-teleport");

    /**
     * Used to determine how many seconds PvP combat is considered to continue after the most recent damage.
     */
    public static final Option<Integer> PVP_COMBAT_TIMEOUT = DummyObjectProvider.createFor(Option.class, "pvp-combat-timeout");
}
