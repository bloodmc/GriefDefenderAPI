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

public class ContextKeys {

    /**
     * Represents a {@link Claim} context key.
     * 
     * Note: This context links a permission to a claim.
     * Only accepts a {@link UUID} as a value.
     */
    public static final String CLAIM = "gd_claim";

    /**
     * Represents a {@link Claim} or {@link ClaimType} default context key.
     * 
     * Note: This context is only applied as a default to a claim.
     * Accepts the following values :
     * <ul>
     * <li>global
     * <li>admin
     * <li>basic
     * <li>subdivision
     * <li>town
     * <li>wilderness
     * <li>claim uuid
     * </ul>
     */
    public static final String CLAIM_DEFAULT = "gd_claim_default";

    /**
     * Represents a {@link Claim} or {@link ClaimType} override context key.
     * 
     * Note: This context forces a permission to all users of a
     * claim including owners.
     * Accepts the following values :
     * <ul>
     * <li>global
     * <li>admin
     * <li>basic
     * <li>subdivision
     * <li>town
     * <li>wilderness
     * <li>claim uuid
     * </ul>
     */
    public static final String CLAIM_OVERRIDE = "gd_claim_override";

    /**
     * Represents a flag context key.
     * 
     * Note: This is only used for {@link Option}'s to
     * pair it with a {@link Flag}.
     */
    public static final String FLAG = "gd_flag";

    /**
     * Represents a {@link Flag} source context key.
     */
    public static final String SOURCE = "source";

    /**
     * Represents one or more block state context key.
     */
    public static final String STATE = "state";

    /**
     * Represents a {@link Flag} target.
     */
    public static final String TARGET = "target";
}
