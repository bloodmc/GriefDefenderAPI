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

import java.util.Set;

import com.griefdefender.api.Clan;
import com.griefdefender.api.claim.Claim;

/**
 * An event that is fired when one or more clan trust changes in a {@link Claim}.
 */
public interface ClanTrustClaimEvent extends TrustClaimEvent {

    /**
     * Gets the set of clans requesting trust.
     * 
     * @return The set of clans requesting trust
     */
    Set<Clan> getClans();

    /**
     * Fired when a group is added to claim trust.
     */
    interface Add extends ClanTrustClaimEvent, TrustClaimEvent.Add {};

    /**
     * Fired when a group is removed from claim trust.
     */
    interface Remove extends ClanTrustClaimEvent, TrustClaimEvent.Remove {};
}
