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
package com.griefdefender.api.event;

import java.util.Optional;

import com.griefdefender.api.User;

import net.kyori.adventure.text.Component;
import net.kyori.event.Cancellable;

/** 
 * 
 * Represents an event involving a transaction with one or more claim blocks.
 */
public interface BlockTransactionEvent extends Cancellable, Event {

    /**
     * The amount of blocks involved in transaction.
     * 
     * @return The amount of blocks
     */
    int getAmount();

    /**
     * The block transaction price.
     * 
     * @return The block transaction price
     */
    double getPrice();

    /**
     * The {@link User} involved in transaction.
     * 
     * @return The user involved in transaction
     */
    User getUser();

    /**
     * Sets the claim message to be presented to {@link Subject}
     * if applicable.
     * 
     * @param message The message
     */
    void setMessage(Component message);

    /**
     * Gets the claim message.
     * 
     * Note: This is only available if event was cancelled.
     * 
     * @return The claim message, if available
     */
    Optional<Component> getMessage();

    /**
     * Fired when a player attempts to buys bonus blocks.
     */
    interface Buy extends BlockTransactionEvent {

        /**
         * The current bonus blocks this user has.
         * 
         * @return The current bonus block total
         */
        int currentTotal();

        /**
         * The new total bonus blocks this user will have 
         * if transaction completes.
         * 
         * @return The new total bonus block total
         */
        int getNewTotal();
    }

    /**
     * Fired when a player attempts to sell blocks.
     */
    interface Sell extends BlockTransactionEvent {

        /**
         * The current blocks this user has.
         * 
         * @return The current block total
         */
        int currentTotal();

        /**
         * The new total blocks this user will have 
         * if transaction completes.
         * 
         * @return The new total block total
         */
        int getNewTotal();
    }
}
