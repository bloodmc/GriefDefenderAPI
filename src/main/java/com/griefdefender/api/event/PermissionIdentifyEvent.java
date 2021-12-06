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

import org.checkerframework.checker.nullness.qual.Nullable;

import com.griefdefender.api.User;
import com.griefdefender.api.permission.Context;

/**
 * Represents an event that is called before GD processes an identifier for an event object.
 * For example, if a minecraft horse is the event object, GD would return 'minecraft:horse'.
 * However, if a plugin has modified horses then it could override this identifier and return
 * its own id in the format of 'pluginid:name'.
 * <p>
 * Plugins can use this event to alter id's for objects it owns.
 */
public interface PermissionIdentifyEvent extends ClaimEvent {

    /**
     * The original identifier for permission object processed in event manager.
     * 
     * For example, if a vanilla pig was being processed, this would return 'minecraft:pig'.
     * 
     * @return The original permission object identifier
     */
    String getOriginalIdentifier();

    /**
     * The final identifier for permission object processed in event manager.
     * In order to
     * 
     * 
     * @return The original permission object identifier
     */
    String getFinalIdentifier();

    /**
     * Gets the mutable context set associated with permission object.
     * 
     * @return The mutable context set.
     */
    Set<Context> getContexts();

    /**
     * Gets the permission object such as a block, entity, or item usually associated with an event.
     * 
     * @return The permission object.
     */
    Object getPermissionObject();

    /** Gets the {@link User} associated with permission object.
     * 
     * @return The user, if available
     */
    @Nullable
    User getUser();

    /**
     * Gets the permission action location.
     * 
     * @return The permission action location
     */
    Object getLocation();

    /**
     * Sets a new identifier replacing the original.
     * 
     * @param id The new identifier
     */
    void setNewIdentifier(String id);

    /**
     * Whether permission object is source.
     * 
     * @return true if source, false if not
     */
    boolean isSource();
}
