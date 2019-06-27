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

import com.griefdefender.api.Tristate;
import com.griefdefender.api.claim.Claim;
import com.griefdefender.api.claim.ClaimContexts;
import com.griefdefender.api.claim.TrustType;
import com.griefdefender.api.permission.flag.Flag;
import com.griefdefender.api.permission.option.Option;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public interface PermissionManager {

    default Tristate getFinalPermission(Claim claim, String subject, Flag flag, Object source, Object target, Set<Context> contexts) {
        return getFinalPermission(claim, subject, flag, source, target, contexts, false);
    }

    default Tristate getFinalPermission(Claim claim, String subject, Flag flag, Object source, Object target, Set<Context> contexts, boolean checkOverride) {
        return getFinalPermission(claim, subject, flag, source, target, contexts, null, checkOverride);
    }

    Tristate getFinalPermission(Claim claim, String subject, Flag flag, Object source, Object target, Set<Context> contexts, TrustType type, boolean checkOverride);

    /**
     * Clears claim permissions on the {@link Subject}.
     * 
     * Note: All permissions will be cleared from all claim contexts. If you require
     * a specific context, use {@link #clearPermissions(Subject, Context)}.
     * 
     * @param claim The claim
     * @param subject The subject
     * @return The result of clear
     */
    CompletableFuture<PermissionResult> clearAllPermissions(Claim claim, String subject);

    /**
     * Clears claim permissions from specified {@link Context}.
     * 
     * Note: This uses the default subject which applies to all users in claim.
     * 
     * @param claim The claim
     * @param contexts The contexts holding the permissions
     * @return The result of clear
     */
    CompletableFuture<PermissionResult> clearPermissions(Claim claim, Set<Context> contexts);

    /**
     * Clears claim permissions on the {@link Subject} from specified {@link Context}.
     * 
     * @param claim The claim
     * @param subject The subject
     * @param contexts The contexts holding the permissions
     * @return The result of clear
     */
    CompletableFuture<PermissionResult> clearPermissions(Claim claim, String subject, Set<Context> contexts);

    /**
     * Gets the {@link Flag} permission value of {@link Subject} for target.
     * 
     * @param claim The claim
     * @param subject The subject
     * @param flag The claim flag
     * @param target The target id
     * @return The permission value, or {@link Tristate#UNDEFINED} if none
     */
    default Tristate getPermissionValue(Claim claim, String subject, Flag flag, String target) {
        final Set<Context> contexts = new HashSet<>();
        contexts.add(claim.getContext());
        return getPermissionValue(claim, subject, flag, target, contexts);
    }

    /**
     * Gets the {@link Flag} permission value for target with {@link Context}.
     * 
     * Note: This uses the default subject which applies to all users in claim.
     * 
     * @param claim The claim
     * @param flag The claim flag
     * @param target The target id
     * @param contexts The claim contexts
     * @return The permission value, or {@link Tristate#UNDEFINED} if none
     */
    Tristate getPermissionValue(Claim claim, Flag flag, String target, Set<Context> contexts);

    /**
     * Gets the {@link Flag} permission value of {@link Subject} for target with {@link Context}.
     * 
     * Note: Only the default subject supports default and override context. Attempting to pass another subject 
     * with these specific contexts will always return {@link Tristate#UNDEFINED}.
     * 
     * @param claim The claim
     * @param subject The subject
     * @param flag The claim flag
     * @param target The target id
     * @param contexts The claim contexts
     * @return The permission value, or {@link Tristate#UNDEFINED} if none
     */
    Tristate getPermissionValue(Claim claim, String subject, Flag flag, String target, Set<Context> contexts);

    /**
     * Gets all flag permissions with {@link Context}'s.
     * 
     * @param contexts The claim contexts
     * @return A map containing all permissions, empty if none
     */
    Map<String, Boolean> getPermissions(Set<Context> contexts);

    /**
     * Gets the {@link Subject}'s flag permissions with {@link Context}.
     * 
     * @param subject The subject
     * @param contexts The claim contexts
     * @return A map containing all permissions, empty if none
     */
    Map<String, Boolean> getPermissions(String subject, Set<Context> contexts);

    /**
     * Sets {@link Flag} permission for target on the {@link Subject}.
     * 
     * @param claim The claim
     * @param subject The subject
     * @param flag The claim flag
     * @param value The new value
     * @return The result of set
     */
    default CompletableFuture<PermissionResult> setPermission(Claim claim, String subject, Flag flag, String target, Tristate value) {
        final Set<Context> contexts = new HashSet<>();
        contexts.add(claim.getContext());
        return setPermission(claim, subject, flag, target, value, contexts);
    }

    /**
     * Sets {@link Flag} permission with {@link Context}.
     * 
     * Note: This uses the default subject which applies to all users in claim.
     * 
     * @param claim The claim
     * @param flag The claim flag
     * @param value The new values
     * @param contexts The claim contexts
     * @return The result of set
     */
    CompletableFuture<PermissionResult> setPermission(Claim claim, Flag flag, Tristate value, Set<Context> contexts);

    /**
     * Sets {@link Flag} permission on {@link Subject} with {@link Context}.
     * 
     * @param claim The claim
     * @param subject The subject
     * @param flag The claim flag
     * @param value The new value
     * @param contexts The claim contexts
     * @return The result of set
     */
    CompletableFuture<PermissionResult> setPermission(Claim claim, String subject, Flag flag, Tristate value, Set<Context> contexts);

    /**
     * Sets {@link Flag} permission for target with {@link Context}.
     * 
     * Note: This uses the default subject which applies to all users in claim.
     * 
     * @param claim The claim
     * @param flag The claim flag
     * @param target The target id
     * @param value The new value
     * @param contexts The claim contexts
     * @return The result of set
     */
    CompletableFuture<PermissionResult> setPermission(Claim claim, Flag flag, String target, Tristate value, Set<Context> contexts);

    /**
     * Sets {@link Flag} permission for target on {@link Subject} with {@link Context}.
     * 
     * @param claim The claim
     * @param subject The subject
     * @param flag The claim flag
     * @param target The target id
     * @param value The new value
     * @param contexts The claim contexts
     * @return The result of set
     */
    CompletableFuture<PermissionResult> setPermission(Claim claim, String subject, Flag flag, String target, Tristate value, Set<Context> contexts);

    /**
     * Gets the global {@link ClaimOption} option value in the default subject's current context.
     * 
     * Note: This uses the default subject which applies to all users in all claims.
     * 
     * @param option The claim option
     * @return The option value
     */
    default Optional<String> getOptionValue(Option option) {
        return getOptionValue(option, new HashSet<>());
    }

    /**
     * Gets the global {@link ClaimOption} option value in the default subject with {@link Context}'s.
     * 
     * Note: This uses the default subject which applies to all users in all claims.
     * 
     * @param option The claim option
     * @param contexts The claim contexts
     * @return The option value
     */
    Optional<String> getOptionValue(Option option, Set<Context> contexts);

    /**
     * Gets the global {@link ClaimOption} option value for subject with {@link Context}'s.
     * 
     * Note: This is only the default value for option. Options set in claims will override this unless the {@link ClaimContexts#CLAIM_OVERRIDE_CONTEXT} is used.
     * 
     * @param subject The subject
     * @param option The claim option
     * @param contexts The claim contexts
     * @return The option value
     */
    default Optional<String> getOptionValue(String subject, Option option) {
        return getOptionValue(subject, option, new HashSet<>());
    }

    /**
     * Gets the {@link ClaimOption} option value for subject with {@link Context}'s.
     * 
     * @param subject The subject
     * @param option The claim option
     * @param contexts The claim contexts
     * @return The option value
     */
    Optional<String> getOptionValue(String subject, Option option, Set<Context> contexts);
}
