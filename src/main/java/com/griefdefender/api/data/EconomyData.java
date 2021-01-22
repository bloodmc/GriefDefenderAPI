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

import com.griefdefender.api.GriefDefender;
import com.griefdefender.api.User;
import com.griefdefender.api.claim.Claim;
import com.griefdefender.api.economy.PaymentTransaction;
import com.griefdefender.api.economy.TransactionType;
import com.griefdefender.api.economy.PaymentType;

import java.time.Instant;
import java.util.UUID;

import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Contains all economy data of a {@link Claim}.
 */
public interface EconomyData extends EconomyDataGetter {

    /**
     * Sets the rent balance of {@link User}.
     * 
     * @param uuid The user uuid
     * @param balance The new rent balance
     */
    void setRentBalance(UUID uuid, double balance);

    /**
     * Sets whether renters or rental trusted users have the ability to break blocks in {@link Claim}.
     * 
     * Note: This defaults to false.
     * 
     * @param breakAbility
     */
    void setRentalBreakAbility(boolean breakAbility);

    /**
     * Clears the payment transactions.
     * 
     * @param type The payment transaction type
     */
    void clearPaymentTransactions(TransactionType type);

    /**
     * Sets the {link PaymentType}.
     * 
     * @param type The payment type
     */
    void setPaymentType(PaymentType type);

    /**
     * Sets the minimum time to rent.
     * 
     * Note: The time is based on {@link #getPaymentType()}.
     * 
     * @param min The min rent time
     */
    void setRentMinTime(int min);

    /**
     * Sets the maximum time to rent.
     * 
     * Note: The time is based on {@link #getPaymentType()}.
     *  
     * @param max The max rent time
     */
    void setRentMaxTime(int max);

    /**
     * Sets the new rent past due date.
     * 
     * @param date The new date
     */
    void setRentPastDueDate(@Nullable Instant date);

    /**
     * Sets the rent start date.
     * 
     * @param date The start date
     */
    void setRentStartDate(@Nullable Instant date);

    /**
     * Sets the rent end date.
     * 
     * Note: If set, renters may rent until
     * end date. Once end date is reached, the claim
     * will no longer be rentable.
     * 
     * @param date The end date
     */
    void setRentEndDate(@Nullable Instant date);

    /**
     * Sets a rent rate for {@link Claim}.
     * 
     * @param rate
     */
    void setRentRate(double rate);

    /**
     * Sets the sale end date.
     * 
     * Note: The claim will no longer be for sale
     * when end date is reached.
     * 
     * @param date The end date
     */
    void setSaleEndDate(@Nullable Instant date);

    /**
     * Sets a sale price for {@link Claim}.
     * 
     * @param price The sale price
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
    void setTaxPastDueDate(@Nullable Instant date);

    /**
     * Adds a payment transaction to the {@link Claim} log.
     * 
     * @param transaction The payment transaction
     */
    void addPaymentTransaction(PaymentTransaction transaction);

    /**
     * Gets a new economy data builder instance for {@link Builder}.
     * 
     * @return A new economy data builder instance
     */
    public static EconomyData.Builder builder() {
        return GriefDefender.getRegistry().createBuilder(EconomyData.Builder.class);
    }

    public interface Builder {
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
         * Gets the rent rate of {@link Claim}.
         * 
         * @return The rent rate, or -1 if not set.
         */
        double getRentRate();

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
         * Sets whether renters or rental trusted users have the ability to break blocks in {@link Claim}.
         * 
         * Note: This defaults to false.
         * 
         * @param breakAbility
         */
        Builder rentalBreakAbility(boolean breakAbility);

        /**
         * Sets the {link PaymentType}.
         * 
         * @param type The payment type
         */
        Builder paymentType(PaymentType type);

        /**
         * Sets the minimum time to rent.
         * 
         * Note: The time is based on {@link #getPaymentType()}.
         * 
         * @param min The min rent time
         */
        Builder rentMinTime(int min);

        /**
         * Sets the maximum time to rent.
         * 
         * Note: The time is based on {@link #getPaymentType()}.
         *  
         * @param max The max rent time
         */
        Builder rentMaxTime(int max);

        /**
         * Sets the rent end date.
         * 
         * Note: If set, renters may rent until
         * end date. Once end date is reached, the claim
         * will no longer be rentable.
         * 
         * @param date The end date
         */
        Builder rentEndDate(@Nullable Instant date);

        /**
         * Sets a rent rate for {@link Claim}.
         * 
         * @param rate
         */
        Builder rentRate(double rate);

        /**
         * Sets the sale end date.
         * 
         * Note: The claim will no longer be for sale
         * when end date is reached.
         * 
         * @param date The end date
         */
        Builder saleEndDate(@Nullable Instant date);

        /**
         * Sets a sale price for {@link Claim}.
         * 
         * @param price The sale price
         */
        Builder salePrice(double price);

        /**
         * Enables or disables the rental of {@link Claim}.
         * 
         * @param forRent true to enable, false to disable
         */
        Builder forRent(boolean forRent);

        /**
         * Enables or disables the sale of {@link Claim}.
         * 
         * @param forSale true to enable, false to disable
         */
        Builder forSale(boolean forSale);

        /**
         * Returns the {@link EconomyData}.
         * 
         * @return The created economy data
         */
        EconomyData build();
    }
}
