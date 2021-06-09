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
package com.griefdefender.api.claim;

import net.kyori.adventure.text.Component;

import java.util.List;
import java.util.Optional;

import org.checkerframework.checker.nullness.qual.Nullable;

import com.griefdefender.api.GriefDefender;
import com.griefdefender.api.User;

public interface TrustResult {

    /**
     * Gets the {@link TrustResultType} of trust action which adds
     * extra context when result is a success or not.
     * 
     * @return The result type
     */
    TrustResultType getResultType();

    /**
     * Gets the result message.
     * 
     * Note: normally this is set during event cancellations.
     * 
     * @return The result message, if available
     */
    Optional<Component> getMessage();

    /**
     * Gets an unmodifiable list of resulting claims involved in trust action.
     * 
     * @return The unmodifiable list of resulting claims if available, otherwise an empty list
     */
    List<Claim> getClaims();

    /**
     * Gets the {@link User} involved in trust action.
     * 
     * @return The user
     */
    User getUser();

    /**
     * Gets the {@link TrustType} required for {@link User}.
     * 
     * @return The trust type
     */
    TrustType getRequiredTrust();

    /**
     * Gets the first resulting claim.
     * 
     * Note: This is a helper method for results that will usually always
     * contain one claim instead of calling {@link #getClaims}.
     * 
     * @return The result claim
     */
    default @Nullable Claim getClaim() {
        List<Claim> claimList = this.getClaims();
        if (claimList.isEmpty()) {
            return null;
        }

        return claimList.get(0);
    }

    /**
     * Whether the trust result was a success.
     * 
     * @return Whether the trust result was a success
     */
     default boolean successful() {
         return this.getResultType().successType();
     }

     /**
      * Gets a new {@link TrustResult} builder instance.
      * 
      * @return A new claim builder instance
      */
     public static TrustResult.Builder builder() {
         return GriefDefender.getRegistry().createBuilder(TrustResult.Builder.class);
     }

     public interface Builder {

         /**
          * The {@link TrustResultType}.
          * 
          * @param type The trust result type
          * @return The builder
          */
         Builder type(TrustResultType type);

         /**
          * The list of claims affected by trust.
          * 
          * @param claims
          * @return The builder
          */
         Builder claims(List<Claim> claims);

         /**
          * The {@link User} involved in trust action.
          * 
          * @param user The user
          * @return The builder
          */
         Builder user(User user);

         /**
          * The trust result message to send to {@link User}.
          * 
          * Note: This is optional.
          * 
          * @param message The trust result message
          * @return The builder
          */
         Builder message(Component message);

         /**
          * The required {@link TrustType} for {@link User}.
          * 
          * @param trustType The required trust type
          * @return The builder
          */
         Builder trust(TrustType trustType);

         /**
          * Resets the builder to default settings.
          * 
          * @return The builder
          */
         Builder reset();

         /**
          * Returns the {@TrustResult}.
          * 
          * @return The trust result
          */
         TrustResult build();
     }
}
