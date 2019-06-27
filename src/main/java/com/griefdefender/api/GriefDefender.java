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
package com.griefdefender.api;

import static com.google.common.base.Preconditions.checkState;

import com.google.inject.Inject;
import com.griefdefender.api.event.EventManager;
import com.griefdefender.api.permission.PermissionManager;

import javax.annotation.Nullable;

public final class GriefDefender {

    @Inject private static Core core;
    @Inject private static EventManager eventManager;
    @Inject private static PermissionManager permissionManager;
    @Inject private static Registry registry;
    @Inject private static Version version;

    private static <T> T check(@Nullable T instance) {
        checkState(instance != null, "GriefDefender has not been initialized!");
        return instance;
    }

    /**
     * Gets the {@link Core} API.
     * 
     * @return The core API
     */
    public static Core getCore() {
        return check(core);
    }

    /**
     * Gets the {@link EventManager}.
     * 
     * @return The event manager
     */
    public static EventManager getEventManager() {
        return check(eventManager);
    }

    /**
     * Gets the {@link PermissionManager}.
     * 
     * @return The permission manager
     */
    public static PermissionManager getPermissionManager() {
        return check(permissionManager);
    }

    /**
     * Gets the {@link Registry}.
     * 
     * @return The registry
     */
    public static Registry getRegistry() {
        return check(registry);
    }

    /**
     * Gets the {@link Version}.
     * 
     * @return The version
     */
    public static Version getVersion() {
        return check(version);
    }
}
