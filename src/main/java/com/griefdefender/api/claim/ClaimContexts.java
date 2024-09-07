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

import com.griefdefender.api.permission.Context;
import com.griefdefender.api.permission.ContextKeys;

/**
 * Contains a list of all possible default and override contexts used for flags.
 */
public class ClaimContexts {

    /**
     * Contexts used to represent a group of default permissions based on type.
     * 
     * Note: Permissions set with this context will override permissions using {@link ClaimContexts#GLOBAL_DEFAULT_CONTEXT}.
     */
    public static final Context GLOBAL_DEFAULT_CONTEXT = new Context(ContextKeys.CLAIM_DEFAULT, "global");
    public static final Context ADMIN_DEFAULT_CONTEXT = new Context(ContextKeys.CLAIM_DEFAULT, "admin");
    public static final Context BASIC_DEFAULT_CONTEXT = new Context(ContextKeys.CLAIM_DEFAULT, "basic");
    public static final Context PLOT_DEFAULT_CONTEXT = new Context(ContextKeys.CLAIM_DEFAULT, "plot");
    public static final Context SUBDIVISION_DEFAULT_CONTEXT = new Context(ContextKeys.CLAIM_DEFAULT, "subdivision");
    public static final Context TOWN_DEFAULT_CONTEXT = new Context(ContextKeys.CLAIM_DEFAULT, "town");
    public static final Context USER_DEFAULT_CONTEXT = new Context(ContextKeys.CLAIM_DEFAULT, "user");
    public static final Context WILDERNESS_DEFAULT_CONTEXT = new Context(ContextKeys.CLAIM_DEFAULT, "wilderness");

    /**
     * Override contexts are used to force a permission to a {@link ClaimType}.
     */
    public static final Context GLOBAL_OVERRIDE_CONTEXT = new Context(ContextKeys.CLAIM_OVERRIDE, "global");
    public static final Context ADMIN_OVERRIDE_CONTEXT = new Context(ContextKeys.CLAIM_OVERRIDE, "admin");
    public static final Context BASIC_OVERRIDE_CONTEXT = new Context(ContextKeys.CLAIM_OVERRIDE, "basic");
    public static final Context PLOT_OVERRIDE_CONTEXT = new Context(ContextKeys.CLAIM_OVERRIDE, "plot");
    public static final Context SUBDIVISION_OVERRIDE_CONTEXT = new Context(ContextKeys.CLAIM_OVERRIDE, "subdivision");
    public static final Context TOWN_OVERRIDE_CONTEXT = new Context(ContextKeys.CLAIM_OVERRIDE, "town");
    public static final Context USER_OVERRIDE_CONTEXT = new Context(ContextKeys.CLAIM_OVERRIDE, "user");
    public static final Context WILDERNESS_OVERRIDE_CONTEXT = new Context(ContextKeys.CLAIM_OVERRIDE, "wilderness");

    /**
     * Rent Context
     */
    public static final Context RENT_CONTEXT = new Context(ContextKeys.RENT, "rent");
}
