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

import com.griefdefender.api.claim.Claim;
import com.griefdefender.api.economy.PaymentTransaction;
import com.griefdefender.api.economy.TransactionType;
import com.griefdefender.api.economy.PaymentType;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Contains all economy data of a {@link Claim}.
 */
public interface EconomyData {

    /**
     * Gets the payment transaction log.
     * 
     * @param type The payment transaction type
     * @return The payment transaction log
     */
    List<String> getPaymentTransactionLog(TransactionType type);

    /**
     * Gets a list of {@link UUID}'s of users 
     * currently renting claim.
     * 
     * @return The list of uuid's renting claim
     */
    List<UUID> getRenters();

    /**
     * Gets the first instant rent was not paid.
     * 
     * @return The instant, if available
     */
    @Nullable Instant getRentPastDueDate();

    /**
     * Gets the first instant tax was not paid.
     * 
     * @return The instant, if available
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
     * Gets the rent start date.
     * 
     * @return The rent start date, if available
     */
    @Nullable Instant getRentStartDate();

    /**
     * Gets the next rent payment due date.
     * 
     * @return The rent payment due date
     */
    @Nullable Instant getRentPaymentDueDate();

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
    double getRentBalance();

    /**
     * Gets the current owed tax balance.
     * 
     * @return The tax balance
     */
    double getTaxBalance();

    /**
     * Gets the maximum number of time the 
     * current renter can rent for.
     * 
     * @return The maximum number of rent time
     */
    int getRentMax();

    /**
     * Clears the payment transaction log.
     */
    void clearPaymentTransactionLog();

    /**
     * Sets the {link PaymentType}.
     * 
     * @param type The payment type
     */
    void setPaymentType(PaymentType type);

    /**
     * Sets the rent balance of {@link Claim}.
     * 
     * @param balance The new rent balance
     */
    void setRentBalance(double balance);

    /**
     * Sets the maximum number of rent time.
     * 
     * @param max The max rent time
     */
    void setRentMax(int max);

    /**
     * Sets the new rent past due date.
     * 
     * @param date The new date
     */
    void setRentPastDueDate(Instant date);

    /**
     * Sets the rent start date.
     * 
     * @param date The start date
     */
    void setRentStartDate(Instant date);

    /**
     * Sets a rent rate for {@link Claim}.
     * 
     * @param rate
     */
    void setRentRate(double rate);

    
    /**
     * Sets a sale price for {@link Claim}.
     * 
     * @param price
     */
    void setSalePrice(double price);

    /**
     * Enables or disables the rental of {@link Claim}.
     * 
     * @param forRent true to enable, false to disable
     */
    void setForRent(boolean forRent);

    /**
     * Enables or disables the sale of {@link Claim}.
     * 
     * @param forSale true to enable, false to disable
     */
    void setForSale(boolean forSale);

    /**
     * Sets the tax balance of {@link Claim}.
     * 
     * @param balance The new tax balance
     */
    void setTaxBalance(double balance);

    /**
     * Sets the new tax past due date.
     * 
     * @param date The new date
     */
    void setTaxPastDueDate(Instant date);

    /**
     * Adds a payment transaction to the {@link Claim} log.
     * 
     * @param transaction The payment transaction
     */
    void addPaymentTransaction(PaymentTransaction transaction);
}
