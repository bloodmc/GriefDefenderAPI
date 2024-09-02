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

import org.checkerframework.checker.nullness.qual.Nullable;

import com.google.inject.Inject;
import com.griefdefender.api.event.EventManager;
import com.griefdefender.api.permission.PermissionManager;
import com.griefdefender.api.provider.AudienceProvider;
import com.griefdefender.api.scheduler.Scheduler;
import com.griefdefender.api.util.NBTUtil;

public final class GriefDefender {

    @Inject private static AudienceProvider audienceProvider;
    @Inject private static Core core;
    @Inject private static EventManager eventManager;
    @Inject private static NBTUtil nbtUtil;
    @Inject private static PermissionManager permissionManager;
    @Inject private static Registry registry;
    @Inject private static Scheduler scheduler;
    @Inject private static Version version;

    private static <T> T check(@Nullable T instance) {
        if (instance == null) {
            throw new IllegalStateException("GriefDefender has not been initialized!");
        }
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
     * Gets the {@link AudienceProvider}.
     * 
     * @return The audience provider
     */
    public static AudienceProvider getAudienceProvider() {
        return check(audienceProvider);
    }

    /**
     * Gets the {@link NBTUtil}.
     * 
     * @return The nbt util
     */
    public static NBTUtil getNBTUtil() {
        return check(nbtUtil);
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
     * Gets the {@link Scheduler}.
     * 
     * @return The scheduler
     */
    public static Scheduler getScheduler() {
        return check(scheduler);
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
