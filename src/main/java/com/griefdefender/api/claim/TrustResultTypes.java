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

import com.griefdefender.api.util.generator.DummyObjectProvider;

/**
 * Used to provide more information to a plugin when a trust
 * action is successful or denied.
 */
public final class TrustResultTypes {

    /**
     * Successful result if a {@link User} has {@link TrustTypes#ACCESSOR}.
     */
    public static final TrustResultType ACCESSOR = DummyObjectProvider.createFor(TrustResultType.class, "ACCESSOR");

    /**
     * Successful result if a {@link User} has {@link TrustTypes#CONTAINER}.
     */
    public static final TrustResultType CONTAINER = DummyObjectProvider.createFor(TrustResultType.class, "CONTAINER");

    /**
     * Successful result if a {@link User} has {@link TrustTypes#BUILDER}.
     */
    public static final TrustResultType BUILDER = DummyObjectProvider.createFor(TrustResultType.class, "BUILDER");

    /**
     * Successful result if a {@link User} has {@link TrustTypes#MANAGER}.
     */
    public static final TrustResultType MANAGER = DummyObjectProvider.createFor(TrustResultType.class, "MANAGER");

    /**
     * Successful result if a {@link Claim} has public trust.
     */
    public static final TrustResultType PUBLIC = DummyObjectProvider.createFor(TrustResultType.class, "PUBLIC");

    /**
     * Failure result if a {@link Clan} is denied.
     */
    public static final TrustResultType CLAN_DENY = DummyObjectProvider.createFor(TrustResultType.class, "CLAN_DENY");

    /**
     * Successful result if a {@link Clan} is allowed.
     */
    public static final TrustResultType CLAN_GRANT = DummyObjectProvider.createFor(TrustResultType.class, "CLAN_GRANT");

    /**
     * Failure result if a {@link ClanPlayer} is denied.
     */
    public static final TrustResultType CLAN_MEMBER_DENY = DummyObjectProvider.createFor(TrustResultType.class, "CLAN_MEMBER_DENY");

    /**
     * Successful result if a {@link ClanPlayer} is allowed.
     */
    public static final TrustResultType CLAN_MEMBER_GRANT = DummyObjectProvider.createFor(TrustResultType.class, "CLAN_MEMBER_GRANT");

    /**
     * Failure result if a {@link User} is renter.
     */
    public static final TrustResultType RENTER_DENY = DummyObjectProvider.createFor(TrustResultType.class, "RENTER_DENY");

    /**
     * Failure result if a {@link User} is a rent owner.
     */
    public static final TrustResultType RENT_OWNER_DENY = DummyObjectProvider.createFor(TrustResultType.class, "RENT_OWNER_DENY");

    /**
     * Successful result if a {@link User} is renter.
     */
    public static final TrustResultType RENTER_GRANT = DummyObjectProvider.createFor(TrustResultType.class, "RENTER_GRANT");

    /**
     * Successful result if a {@link User} is a rent owner.
     */
    public static final TrustResultType RENT_OWNER_GRANT = DummyObjectProvider.createFor(TrustResultType.class, "RENT_OWNER_GRANT");

    /**
     * Failure result if a {@link Claim} has expired.
     */
    public static final TrustResultType CLAIM_EXPIRED = DummyObjectProvider.createFor(TrustResultType.class, "CLAIM_EXPIRED");

    /**
     * Successful result if a {@link User} is ignoring claims.
     */
    public static final TrustResultType IGNORE_CLAIMS = DummyObjectProvider.createFor(TrustResultType.class, "IGNORE_CLAIMS");

    /**
     * Failure result if {@link User} is not trusted.
     */
    public static final TrustResultType NOT_TRUSTED = DummyObjectProvider.createFor(TrustResultType.class, "NOT_TRUSTED");

    /**
     * Successful result if a {@link User} is claim owner.
     */
    public static final TrustResultType OWNER = DummyObjectProvider.createFor(TrustResultType.class, "OWNER");

    /**
     * Failure result if {@link User} has a persistent deny permission set.
     */
    public static final TrustResultType PERMISSION_DENY = DummyObjectProvider.createFor(TrustResultType.class, "PERMISSION_DENY");

    /**
     * Successful result if {@link User} has a persistent grant permission set.
     */
    public static final TrustResultType PERMISSION_GRANT = DummyObjectProvider.createFor(TrustResultType.class, "PERMISSION_GRANT");

    /**
     * Failure result if a plugin cancels event.
     */
    public static final TrustResultType PLUGIN_CANCEL = DummyObjectProvider.createFor(TrustResultType.class, "PLUGIN_CANCEL");

    /**
     * Generic successful result if {@link User} is trusted.
     */
    public static final TrustResultType TRUSTED = DummyObjectProvider.createFor(TrustResultType.class, "TRUSTED");
}
