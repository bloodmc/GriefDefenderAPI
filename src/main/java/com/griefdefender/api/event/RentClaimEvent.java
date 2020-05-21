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

import com.griefdefender.api.User;
import com.griefdefender.api.economy.PaymentType;

import net.kyori.event.Cancellable;

/**
 * An event that is fired before a claim is rented.
 * 
 * Note: Canceling this event will prevent claim being rented.
 */
public interface RentClaimEvent extends ClaimEvent, Cancellable  {

    /**
     * Gets the original rent balance.
     * 
     * Note: This is the previous balance
     * before the new rate was applied.
     * 
     * @return The original rent balance
     */
    double getOriginalRentBalance();

    /**
     * Gets the original rent rate for claim.
     * 
     * @return The original rent rate
     */
    double getOriginalRentRate();

    /**
     * Gets the current rent balance due.
     * 
     * Note: To adjust the rent balance, use {@link #setRentRate(double)}
     * 
     * @return The current rent balance
     */
    double getRentBalance();

    /**
     * Gets the current rent rate.
     * 
     * @return The current rent rate
     */
    double getRentRate();

    /**
     * Sets a new rent rate for claim.
     * 
     * @param newRentRate The new rent rate.
     */
    void setRentRate(double newRentRate);

    /**
     * Gets the {@link User} being charged.
     * 
     * @return The user being charged
     */
    User getRenter();

    /**
     * Gets the rent {@link PaymentType}
     * 
     * @return The payment type
     */
    PaymentType getPaymentType();
}
