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
package com.griefdefender.api.data;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.checkerframework.checker.nullness.qual.Nullable;

import com.griefdefender.api.GriefDefender;
import com.griefdefender.api.User;
import com.griefdefender.api.claim.Claim;
import com.griefdefender.api.economy.PaymentTransaction;
import com.griefdefender.api.economy.PaymentType;
import com.griefdefender.api.economy.TransactionType;

public interface EconomyDataGetter {

    /**
     * Gets the {@link PaymentTransaction}'s.
     * 
     * @param type The payment transaction type
     * @return The list of payment transactions
     */
    List<PaymentTransaction> getPaymentTransactions(TransactionType type);

    /**
     * Gets a list of {@link UUID}'s of users 
     * currently renting claim.
     * 
     * @return The list of uuid's renting claim
     */
    List<UUID> getRenters();

    /**
     * Gets a list of {@link UUID}'s of delinquent
     * users who still owe a balance for past rentals.
     * 
     * @return The list of delinquent uuid's who owe balance
     */
    List<UUID> getDelinquentRenters();

    /**
     * Checks if {@link User} is renting.
     * 
     * @param user The user
     * @return true if renting, false if not
     */
    default boolean isUserRenting(User user) {
        if (user == null) {
            return false;
        }
        return this.isUserRenting(user.getUniqueId());
    }

    /**
     * Checks if {@link User} is renting.
     * 
     * @param uuid The uuid
     * @return true if renting, false if not
     */
    boolean isUserRenting(UUID uuid);

    /**
     * Gets the rent past due date.
     * 
     * Note: This will only return a date if
     * the current renter has missed a payment.
     * 
     * @return The rent past due date, if available
     */
    @Nullable Instant getRentPastDueDate();

    /**
     * Gets the tax past due date.
     * 
     * Note: This will only return a date if
     * the current tax payer has missed a payment.
     * 
     * @return The tax past due date, if available
     */
    @Nullable Instant getTaxPastDueDate();

    /**
     * Gets the {@link PaymentType}.
     * 
     * @return The payment type
     */
    PaymentType getPaymentType();

    /**
     * Gets whether claim is for sale.
     * 
     * @return whether claim is for sale
     */
    boolean isForSale();

    /**
     * Gets whether claim is for rent.
     * 
     * @return whether claim is for rent
     */
    boolean isForRent();

    /**
     * Gets rental break ability.
     * 
     * @return Whether renters or rental trusted have ability to break owner blocks.
     */
    boolean getRentalBreakAbility();

    /**
     * Gets whether claim is currently being rented.
     * 
     * @return whether claim is rented
     */
    default boolean isRented() {
        return !this.getRenters().isEmpty();
    }

    /**
     * Gets the rent rate of {@link Claim}.
     * 
     * @return The rent rate, or -1 if not set.
     */
    double getRentRate();

    /**
     * Gets the minimum rent time.
     * 
     * @return The minimum rent time
     */
    int getRentMinTime();

    /**
     * Gets the maximum rent time.
     * 
     * @return The maximum rent time
     */
    int getRentMaxTime();

    /**
     * Gets the rent start date.
     * 
     * @return The rent start date, if available
     */
    @Nullable Instant getRentStartDate();

    /**
     * Gets the rent end date.
     * 
     * Note: If not set, the claim may be 
     * rented as long as needed.
     * 
     * @return The rent end date, if available
     */
    @Nullable Instant getRentEndDate();

    /**
     * Gets the next rent payment due date.
     * 
     * @return The rent payment due date
     */
    @Nullable Instant getRentPaymentDueDate();

    /**
     * Gets the sale end date of claim.
     * 
     * @return The sale end date, if available
     */
    @Nullable Instant getSaleEndDate();

    /**
     * Gets the sale price of {@link Claim}.
     * 
     * @return The sale price, or -1 if not set.
     */
    double getSalePrice();

    /**
     * Gets the current owed rent balance.
     * 
     * @return The rent balance
     */
    double getRentBalance(UUID uuid);

    /**
     * Gets the current owed tax balance.
     * 
     * @return The tax balance
     */
    double getTaxBalance();
}