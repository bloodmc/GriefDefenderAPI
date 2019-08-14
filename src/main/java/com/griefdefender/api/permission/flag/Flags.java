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
package com.griefdefender.api.permission.flag;

import com.griefdefender.api.claim.Claim;
import com.griefdefender.api.util.generator.DummyObjectProvider;

public final class Flags {

    /**
     * Used to allow or deny a block break.
     */
    public static final Flag BLOCK_BREAK = DummyObjectProvider.createFor(Flag.class, "block-break");
    /**
     * Used to allow or deny a block growth.
     */
    public static final Flag BLOCK_GROW = DummyObjectProvider.createFor(Flag.class, "block-grow");
    /**
     * Used to allow or deny a block modify.
     */
    public static final Flag BLOCK_MODIFY = DummyObjectProvider.createFor(Flag.class, "block-modify");
    /**
     * Used to allow or deny a block place.
     */
    public static final Flag BLOCK_PLACE = DummyObjectProvider.createFor(Flag.class, "block-place");
    /**
     * Used to allow or deny a collision with a block.
     */
    public static final Flag COLLIDE_BLOCK = DummyObjectProvider.createFor(Flag.class, "collide-block");
    /**
     * Used to allow or deny a collision with an entity.
     */
    public static final Flag COLLIDE_ENTITY = DummyObjectProvider.createFor(Flag.class, "collide-entity");
    /**
     * Used to allow or deny a user on a command execution.
     */
    public static final Flag COMMAND_EXECUTE = DummyObjectProvider.createFor(Flag.class, "command-execute");
    /**
     * Used to allow or deny a user on a command execution during PvP.
     */
    public static final Flag COMMAND_EXECUTE_PVP = DummyObjectProvider.createFor(Flag.class, "command-execute-pvp");
    /**
     * Used to allow or deny entering a {@link Claim}.
     */
    public static final Flag ENTER_CLAIM = DummyObjectProvider.createFor(Flag.class, "enter-claim");
    /**
     * Used to allow or deny an entity spawn during chunk load.
     */
    public static final Flag ENTITY_CHUNK_SPAWN = DummyObjectProvider.createFor(Flag.class, "entity-chunk-spawn");
    /**
     * Used to allow or deny damage to an entity.
     */
    public static final Flag ENTITY_DAMAGE = DummyObjectProvider.createFor(Flag.class, "entity-damage");
    /**
     * Used to allow or deny mounting an entity.
     */
    public static final Flag ENTITY_RIDING = DummyObjectProvider.createFor(Flag.class, "entity-riding");
    /**
     * Used to allow or deny an entity spawn.
     * 
     * Note: This not include items, see {@link #ITEM_SPAWN}
     */
    public static final Flag ENTITY_SPAWN = DummyObjectProvider.createFor(Flag.class, "entity-spawn");
    /**
     * Used to allow or deny a teleport from a {@link Claim}.
     */
    public static final Flag ENTITY_TELEPORT_FROM = DummyObjectProvider.createFor(Flag.class, "entity-teleport-from");
    /**
     * Used to allow or deny a teleport to a {@link Claim}.
     */
    public static final Flag ENTITY_TELEPORT_TO = DummyObjectProvider.createFor(Flag.class, "entity-teleport-to");
    /**
     * Used to allow or deny exiting a {@link Claim}.
     */
    public static final Flag EXIT_CLAIM = DummyObjectProvider.createFor(Flag.class, "exit-claim");
    /**
     * Used to allow or deny an explosion from breaking one or more blocks.
     */
    public static final Flag EXPLOSION_BLOCK = DummyObjectProvider.createFor(Flag.class, "explosion-block");
    /**
     * Used to allow or deny an explosion from damaging one or more entities.
     */
    public static final Flag EXPLOSION_ENTITY = DummyObjectProvider.createFor(Flag.class, "explosion-entity");
    /**
     * Used to allow or deny fire spreading.
     */
    public static final Flag FIRE_SPREAD = DummyObjectProvider.createFor(Flag.class, "fire-spread");
    /**
     * Used to allow or deny a player from left-clicking a block.
     */
    public static final Flag INTERACT_BLOCK_PRIMARY = DummyObjectProvider.createFor(Flag.class, "interact-block-primary");
    /**
     * Used to allow or deny a player from right-clicking a block.
     */
    public static final Flag INTERACT_BLOCK_SECONDARY = DummyObjectProvider.createFor(Flag.class, "interact-block-secondary");
    /**
     * Used to allow or deny a player from left-clicking an entity.
     */
    public static final Flag  INTERACT_ENTITY_PRIMARY = DummyObjectProvider.createFor(Flag.class, "interact-entity-primary");
    /**
     * Used to allow or deny a player from right-clicking an entity.
     */
    public static final Flag INTERACT_ENTITY_SECONDARY = DummyObjectProvider.createFor(Flag.class, "interact-entity-secondary");
    /**
     * Used to allow or deny a user from opening an inventory container.
     */
    public static final Flag INTERACT_INVENTORY = DummyObjectProvider.createFor(Flag.class, "interact-inventory");
    /**
     * Used to allow or deny a user from clicking an item in an inventory slot.
     */
    public static final Flag INTERACT_INVENTORY_CLICK = DummyObjectProvider.createFor(Flag.class, "interact-inventory-click");
    /**
     * Used to allow or deny a player from left-clicking with an item in hand.
     */
    public static final Flag INTERACT_ITEM_PRIMARY = DummyObjectProvider.createFor(Flag.class, "interact-item-primary");
    /**
     * Used to allow or deny a player from right-clicking with an item in hand.
     */
    public static final Flag INTERACT_ITEM_SECONDARY = DummyObjectProvider.createFor(Flag.class, "interact-item-secondary");
    /**
     * Used to allow or deny an item from dropping into the world.
     */
    public static final Flag ITEM_DROP = DummyObjectProvider.createFor(Flag.class, "item-drop");
    /**
     * Used to allow or deny an item from being picked up.
     */
    public static final Flag ITEM_PICKUP = DummyObjectProvider.createFor(Flag.class, "item-pickup");
    /**
     * Used to allow or deny an item spawn.
     */
    public static final Flag ITEM_SPAWN = DummyObjectProvider.createFor(Flag.class, "item-spawn");
    /**
     * Used to allow or deny an item from being used.
     * 
     * Note: This only affects items that have durations such as food.
     */
    public static final Flag ITEM_USE = DummyObjectProvider.createFor(Flag.class, "item-use");
    /**
     * Used to allow or deny leaves from decaying.
     */
    public static final Flag LEAF_DECAY = DummyObjectProvider.createFor(Flag.class, "leaf-decay");
    /**
     * Used to allow or deny liquid from flowing.
     */
    public static final Flag LIQUID_FLOW = DummyObjectProvider.createFor(Flag.class, "liquid-flow");
    /**
     * Used to allow or deny a portal from being used.
     * 
     * Note: This may also require using {@link #COLLIDE_BLOCK}.
     */
    public static final Flag PORTAL_USE = DummyObjectProvider.createFor(Flag.class, "portal-use");
    /**
     * Used to allow or deny a projectile from hitting a block.
     */
    public static final Flag PROJECTILE_IMPACT_BLOCK = DummyObjectProvider.createFor(Flag.class, "projectile-impact-block");
    /**
     * Used to allow or deny a projectile from hitting an entity.
     */
    public static final Flag PROJECTILE_IMPACT_ENTITY = DummyObjectProvider.createFor(Flag.class, "projectile-impact-entity");
}
