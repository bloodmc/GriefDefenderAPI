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
package com.griefdefender.api.permission;

import com.griefdefender.api.GriefDefender;
import com.griefdefender.api.Subject;
import com.griefdefender.api.Tristate;
import com.griefdefender.api.claim.Claim;
import com.griefdefender.api.claim.ClaimContexts;
import com.griefdefender.api.claim.TrustType;
import com.griefdefender.api.permission.flag.Flag;
import com.griefdefender.api.permission.flag.FlagDefinition;
import com.griefdefender.api.permission.option.Option;
import com.griefdefender.api.permission.option.OptionDefinition;

import io.leangen.geantyref.TypeToken;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import org.checkerframework.checker.nullness.qual.Nullable;

public interface PermissionManager {

    /**
    * Gets the active {@link Flag} permission value for {@link Subject} in {@link Claim}.
    * 
    * @param claim The target claim
    * @param subject The subject
    * @param flag The flag
    * @param contexts The contexts
    * @return The active flag value
    */
    default Tristate getActiveFlagPermissionValue(Claim claim, Subject subject, Flag flag, Set<Context> contexts) {
        return getActiveFlagPermissionValue(claim, subject, flag, null, null, contexts, false);
    }

    /**
    * Gets the active {@link Flag} permission value for {@link Subject} in {@link Claim}.
    * 
    * @param claim The target claim
    * @param subject The subject
    * @param flag The flag
    * @param contexts The contexts
    * @param type The trust type
    * @return The active flag value
    */
    default Tristate getActiveFlagPermissionValue(Claim claim, Subject subject, Flag flag, Set<Context> contexts, TrustType type) {
        return getActiveFlagPermissionValue(claim, subject, flag, null, null, contexts, type, false);
    }

    /**
    * Gets the active {@link Flag} permission value for {@link Subject} in {@link Claim}.
    * 
    * @param claim The target claim
    * @param subject The subject
    * @param flag The flag
    * @param contexts The contexts
    * @param checkOverride Whether to check override
    * @return The active flag value
    */
    default Tristate getActiveFlagPermissionValue(Claim claim, Subject subject, Flag flag, Set<Context> contexts, boolean checkOverride) {
        return getActiveFlagPermissionValue(claim, subject, flag, null, null, contexts, checkOverride);
    }

    /**
    * Gets the active {@link Flag} permission value for {@link Subject} in {@link Claim}.
    * 
    * @param claim The target claim
    * @param subject The subject
    * @param flag The flag
    * @param contexts The contexts
    * @param type The trust type
    * @param checkOverride Whether to check override
    * @return The active flag value
    */
    default Tristate getActiveFlagPermissionValue(Claim claim, Subject subject, Flag flag, Set<Context> contexts, TrustType type, boolean checkOverride) {
        return getActiveFlagPermissionValue(claim, subject, flag, null, null, contexts, type, checkOverride);
    }

    /**
    * Gets the active {@link Flag} permission value for {@link Subject} in {@link Claim}.
    * 
    * @param claim The target claim
    * @param subject The subject
    * @param flag The flag
    * @param source The source
    * @param target The target
    * @param contexts The contexts
    * @return The active flag value
    */
    default Tristate getActiveFlagPermissionValue(Claim claim, Subject subject, Flag flag, Object source, Object target, Set<Context> contexts) {
        return getActiveFlagPermissionValue(claim, subject, flag, source, target, contexts, false);
    }

    /**
    * Gets the active {@link Flag} permission value for {@link Subject} in {@link Claim}.
    * 
    * @param claim The target claim
    * @param subject The subject
    * @param flag The flag
    * @param source The source
    * @param target The target
    * @param contexts The contexts
    * @param checkOverride Whether to check override
    * @return The active flag value
    */
    default Tristate getActiveFlagPermissionValue(Claim claim, Subject subject, Flag flag, Object source, Object target, Set<Context> contexts, boolean checkOverride) {
        return getActiveFlagPermissionValue(claim, subject, flag, source, target, contexts, null, checkOverride);
    }

    /**
    * Gets the active {@link Flag} permission value for {@link Subject} in {@link Claim}.
    * 
    * @param claim The target claim
    * @param subject The subject
    * @param flag The flag
    * @param source The source
    * @param target The target
    * @param contexts The contexts
    * @param type The trust type
    * @param checkOverride Whether to check override
    * @return The active flag value
    */
    Tristate getActiveFlagPermissionValue(Claim claim, Subject subject, Flag flag, Object source, Object target, Set<Context> contexts, TrustType type, boolean checkOverride);

    /**
    * Gets the active {@link Flag} permission value for {@link Subject} in {@link Claim}.
    * 
    * @param event The event
    * @param location The location
    * @param claim The target claim
    * @param subject The subject
    * @param flag The flag
    * @param source The source
    * @param target The target
    * @param contexts The contexts
    * @param type The trust type
    * @param checkOverride Whether to check override
    * @return The active flag value
    */
    Tristate getActiveFlagPermissionValue(Object event, Object location, Claim claim, Subject subject, Flag flag, Object source, Object target, Set<Context> contexts, TrustType type, boolean checkOverride);

    /**
    * Gets the active {@link Flag} permission value for {@link Subject} in {@link Claim}.
    * 
    * @param event The event
    * @param blockX The block X position 
    * @param blockY The block Y position 
    * @param blockZ The block Z position 
    * @param claim The target claim
    * @param subject The subject
    * @param flag The flag
    * @param source The source
    * @param target The target
    * @param contexts The contexts
    * @param type The trust type
    * @param checkOverride Whether to check override
    * @return
    */
    Tristate getActiveFlagPermissionValue(Object event, int blockX, int blockY, int blockZ, Claim claim, Subject subject, Flag flag, Object source, Object target, Set<Context> contexts, TrustType type, boolean checkOverride);

    /**
     * Gets the active {@link OptionDefinition} value in {@link Claim}.
     * 
     * @param definition The option definition
     * @return The active value
     */
    String getActiveOptionDefinitionValue(Claim claim, OptionDefinition definition);

    /**
     * Gets the active {@link OptionDefinition} value in {@link Claim}.
     * 
     * @param definition The option definition
     * @return The active value
     */
    String getActiveOptionDefinitionValue(Claim claim, Subject subject, OptionDefinition definition);

    /**
     * Clears permissions on the {@link Subject}.
     * 
     * Note: All claim specific permissions will be cleared on subject. If you require
     * specific contexts, use {@link #clearFlagPermissions(Subject, Set)}.
     * 
     * @param claim The claim
     * @param subject The subject
     * @return The permission result future
     */
    CompletableFuture<PermissionResult> clearAllFlagPermissions(Subject subject);

    /**
     * Clears permissions from specified {@link Context}'s on the default {@link Subject}.
     * 
     * Note: This uses the default subject which applies to all users in claim.
     * 
     * @param contexts The contexts holding the permissions
     * @return The result of clear
     */
    CompletableFuture<PermissionResult> clearFlagPermissions(Set<Context> contexts);

    /**
     * Clears permissions from specified {@link Context}'s on the {@link Subject}.
     * 
     * @param subject The subject
     * @param contexts The contexts holding the permissions
     * @return The result of clear
     */
    CompletableFuture<PermissionResult> clearFlagPermissions(Subject subject, Set<Context> contexts);

    /**
     * Gets the {@link Flag} permission value with {@link Context}'s.
     * 
     * Note: This uses the default subject which applies to all users.
     * 
     * @param flag The claim flag
     * @param contexts The claim contexts
     * @return The permission value, or {@link Tristate#UNDEFINED} if none
     */
    Tristate getFlagPermissionValue(Flag flag, Set<Context> contexts);

    /**
     * Gets the {@link Flag} permission value with {@link Context}'s of {@link Subject}.
     * 
     * Note: Only the default subject supports default and override context. Attempting to pass another subject 
     * with these specific contexts will always return {@link Tristate#UNDEFINED}.
     * 
     * @param flag The claim flag
     * @param subject The subject
     * @param contexts The claim contexts
     * @return The permission value, or {@link Tristate#UNDEFINED} if none
     */
    Tristate getFlagPermissionValue(Flag flag, Subject subject, Set<Context> contexts);

    /**
     * Gets all flag permissions with {@link Context}'s.
     * 
     * @param contexts The claim contexts
     * @return A map containing all permissions, empty if none
     */
    Map<String, Boolean> getFlagPermissions(Set<Context> contexts);

    /**
     * Gets the {@link Subject}'s flag permissions with {@link Context}.
     * 
     * @param subject The subject
     * @param contexts The claim contexts
     * @return A map containing all permissions, empty if none
     */
    Map<String, Boolean> getFlagPermissions(Subject subject, Set<Context> contexts);

    /**
     * Sets {@link Flag} permission with {@link Context}'s.
     * 
     * Note: This uses the default subject which applies to all users.
     * 
     * @param flag The claim flag
     * @param value The new values
     * @param contexts The claim contexts
     * @return The permission result future
     */
    CompletableFuture<PermissionResult> setFlagPermission(Flag flag, Tristate value, Set<Context> contexts);

    /**
     * Sets {@link Flag} permission with {@link Context}'s on {@link Subject}.
     * 
     * @param flag The claim flag
     * @param subject The subject identifier
     * @param value The new value
     * @param contexts The claim contexts
     * @return The permission result future
     */
    CompletableFuture<PermissionResult> setFlagPermission(Flag flag, Subject subject, Tristate value, Set<Context> contexts);

    /**
     * Sets {@link FlagDefinition} on default {@link Subject}.
     *
     * @param definition The flag definition
     * @param value The new value
     * @return The permission result future
     */
    default CompletableFuture<PermissionResult> setFlagDefinition(FlagDefinition definition, Tristate value) {
        return this.setFlagDefinition(GriefDefender.getCore().getDefaultSubject(), definition, value);
    }

    /**
     * Set {@link FlagDefinition} on {@link Subject}.
     *
     * @param subject The subject
     * @param definition The flag definition
     * @param value The new value
     * @return The permission result future
     */
    CompletableFuture<PermissionResult> setFlagDefinition(Subject subject, FlagDefinition definition, Tristate value);

    /**
     * Sets {@link OptionDefinition} on default {@link Subject}.
     *
     * @param definition The option definition
     * @param value The new value
     * @return The permission result future
     */
    default CompletableFuture<PermissionResult> setOptionDefinition(OptionDefinition definition, String value) {
        return this.setOptionDefinition(GriefDefender.getCore().getDefaultSubject(), definition, value);
    }

    /**
     * Set {@link OptionDefinition} on {@link Subject}.
     *
     * @param subject The subject
     * @param definition The option definition
     * @param value The new value
     * @return The permission result future
     */
    CompletableFuture<PermissionResult> setOptionDefinition(Subject subject, OptionDefinition definition, String value);

    /**
    * Gets the active {@link Option} value with {@link Context}'s.
    * 
    * @param type The option type
    * @param option The option
    * @param claim The claim
    * @param contexts The contexts
    * @return The active option value
    */
    default <T> T getActiveOptionValue(TypeToken<T> type, Option<T> option, Claim claim, Set<Context> contexts) {
        return getActiveOptionValue(type, option, GriefDefender.getCore().getDefaultSubject(), claim, contexts);
    }

    /**
    * Gets the active {@link Option} value with {@link Context}'s.
    * 
    * @param type The option type
    * @param option The option
    * @param subject The subject
    * @param claim The claim
    * @param contexts The contexts
    * @return The active option value
    */
    default <T> T getActiveOptionValue(TypeToken<T> type, Option<T> option, Subject subject, Claim claim) {
        return getActiveOptionValue(type, option, subject, claim, new HashSet<>());
    }

    /**
    * Gets the active {@link Option} value with {@link Context}'s.
    * 
    * @param type The option type
    * @param option The option
    * @param subject The subject
    * @param claim The claim
    * @param contexts The contexts
    * @return The active option value
    */
    <T> T getActiveOptionValue(TypeToken<T> type, Option<T> option, Subject subject, Claim claim, Set<Context> contexts);

    /**
     * Sets {@link Option} to a value.
     *
     * <p>Passing a null value will unset the option.</p>
     *
     * @param option The option to set. Case-insensitive.
     * @param value The value to set.
     * @param contexts The context combination to set the given option in
     * @return The permission result future
     */
    CompletableFuture<PermissionResult> setOption(Option option, String value, Set<Context> contexts);

    /**
     * Sets {@link Option} with {@link Context}'s on {@link Subject}.
     *
     * <p>Passing a null value will unset the option.</p>
     *
     * @param option The option to set. Case-insensitive.
     * @param subject The subject identifier
     * @param value The value to set.
     * @param contexts The context combination to set the given option in
     * @return The permission result future
     */
    CompletableFuture<PermissionResult> setOption(Option option, Subject subject, String value, Set<Context> contexts);

    /**
     * Adds a value to a multi option with contexts to a holder.
     * 
     * @param subject The subject
     * @param option The multi option to update
     * @param value The value to add
     * @param contexts The contexts
     * @return The permission result future
     */
    CompletableFuture<PermissionResult> addOptionListValue(Subject subject, Option option, String value, Set<Context> contexts);

    /**
     * Removes a value from a multi option with contexts to a holder.
     * 
     * @param subject The subject
     * @param option The multi option to update
     * @param value The value to remove
     * @param contexts The contexts
     * @return The permission result future
     */
    CompletableFuture<PermissionResult> removeOptionListValue(Subject subject, Option option, String value, Set<Context> contexts);

    /**
     * Gets the global {@link Option} option value in the default subject's current context.
     * 
     * Note: This uses the default subject which applies to all users in all claims.
     * 
     * @param option The claim option
     * @return The option value
     */
    default @Nullable String getOptionValue(Option option) {
        return getOptionValue(option, new HashSet<>());
    }

    /**
     * Gets the global {@link Option} option value in the default subject's current context.
     * 
     * Note: This uses the default subject which applies to all users in all claims.
     * @param <T>
     * 
     * @param option The claim option
     * @return The option value
     */
     default <T> T getOptionValue(TypeToken<T> type, Option<T> option) {
         return getOptionValue(type, option, new HashSet<>());
     }

    /**
     * Gets the global {@link Option} option value with {@link Context}'s.
     * 
     * Note: This uses the default subject which applies to all users in all claims.
     * 
     * @param option The claim option
     * @param contexts The claim contexts
     * @return The option value
     */
     @Nullable String getOptionValue(Option option, Set<Context> contexts);

    /**
     * Gets the global {@link Option} option value with {@link Context}'s.
     * 
     * Note: This uses the default subject which applies to all users in all claims.
     * 
     * @param option The claim option
     * @param contexts The claim contexts
     * @return The option value
     */
     <T> T getOptionValue(TypeToken<T> type, Option<T> option, Set<Context> contexts);

    /**
     * Gets the global {@link Option} option value for subject with {@link Context}'s.
     * 
     * Note: This is only the default value for option. Options set in claims will override this unless the {@link ClaimContexts#CLAIM_OVERRIDE_CONTEXT} is used.
     * 
     * @param subject The subject
     * @param option The claim option
     * @param contexts The claim contexts
     * @return The option value
     */
    default @Nullable String getOptionValue(Subject subject, Option option) {
        return getOptionValue(subject, option, new HashSet<>());
    }

    /**
     * Gets the {@link Option} option value with {@link Context}'s on {@link Subject}.
     * 
     * @param subject The subject
     * @param option The claim option
     * @param contexts The claim contexts
     * @return The option value
     */
    default <T> T getOptionValue(TypeToken<T> type, Subject subject, Option<T> option) {
        return getOptionValue(type, subject, option, new HashSet<>());
    }

    /**
     * Gets the {@link Option} option value with {@link Context}'s on {@link Subject}.
     * 
     * @param subject The subject
     * @param option The claim option
     * @param contexts The claim contexts
     * @return The option value
     */
    @Nullable String getOptionValue(Subject subject, Option option, Set<Context> contexts);

    /**
     * Gets the {@link Option} option value with {@link Context}'s on {@link Subject}.
     * 
     * @param subject The subject
     * @param option The claim option
     * @param contexts The claim contexts
     * @return The option value
     */
    <T> T getOptionValue(TypeToken<T> type, Subject subject, Option<T> option, Set<Context> contexts);

    /**
     * Gets the permission value of {@link Subject}.
     * 
     * @param subject The subject
     * @param permission The permission
     * @return The permission value
     */
    Tristate getPermissionValue(Subject subject, String permission);

    /**
     * Clear all options.
     *
     * @return Whether the operation was successful
     */
    CompletableFuture<PermissionResult> clearOptions();

    /**
     * Clear all options in the given context combination.
     *
     * <p>Passing an empty context set clears options in the global
     * context.</p>
     *
     * @param contexts The context combination
     * @return Whether the operation was successful (any options were removed)
     */
    CompletableFuture<PermissionResult> clearOptions(Set<Context> contexts);

    /**
     * Checks for enchantments in item and adds them to context set.
     * 
     * @param itemstack The item to check
     * @param contexts The context set to use
     */
    void addItemEnchantmentContexts(Object item, Set<Context> contexts);
}
