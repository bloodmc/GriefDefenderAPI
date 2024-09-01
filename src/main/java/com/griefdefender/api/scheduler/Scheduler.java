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
package com.griefdefender.api.scheduler;

/**
 * Represents a scheduler for executing tasks.
 */
public interface Scheduler {

    /**
     * Schedules a task to run on next tick.
     *
     * @param plugin The reference to the plugin scheduling task
     * @param runnable The runnable to execute
     * @return true if success, false if not
     */
    boolean runTask(Object plugin, Runnable runnable) throws IllegalArgumentException;

    /**
     * Schedules a task to run on next tick.
     *
     * @param plugin The reference to the plugin scheduling task
     * @param sender The command sender
     * @param runnable The runnable to execute
     * @return true if success, false if not
     */
    boolean runTask(Object plugin, Object sender, Runnable runnable) throws IllegalArgumentException;

    /**
     * Schedules a task to run on next tick asynchronously.
     *
     * @param plugin The reference to the plugin scheduling task
     * @param runnable The runnable to execute
     * @return The scheduled task
     */
    Task runTaskAsynchronously(Object plugin, Runnable runnable) throws IllegalArgumentException;

    /**
     * Schedules a task to run on next tick asynchronously.
     *
     * @param plugin The reference to the plugin scheduling task
     * @param sender The command sender
     * @param runnable The runnable to execute
     * @return The scheduled task
     */
    Task runTaskAsynchronously(Object plugin, Object sender, Runnable runnable) throws IllegalArgumentException;

    /**
     * Schedules a task that will run after the specified number of ticks.
     *
     * @param plugin the reference to the plugin scheduling task
     * @param runnable The runnable to execute
     * @param delay the ticks to wait before running the task
     * @return The scheduled task
     */
    Task runTaskLater(Object plugin, Runnable runnable, long delay) throws IllegalArgumentException;

    /**
     * Schedules a task that will run after the specified number of ticks.
     *
     * @param plugin The reference to the plugin scheduling task
     * @param sender The command sender
     * @param runnable The runnable to execute
     * @param delay The ticks to wait before running the task
     * @return The scheduled task
     */
    Task runTaskLater(Object plugin, Object sender, Runnable runnable, long delay) throws IllegalArgumentException;

    /**
     * Schedules a task that will run asynchronously after the specified number
     * of ticks.
     *
     * @param plugin The reference to the plugin scheduling task
     * @param runnable The runnable to execute
     * @param delay The ticks to wait before running the task
     * @return The scheduled task
     */
    Task runTaskLaterAsynchronously(Object plugin, Runnable runnable, long delay) throws IllegalArgumentException;

    /**
     * Schedules a task that will run asynchronously after the specified number
     * of ticks.
     *
     * @param plugin The reference to the plugin scheduling task
     * @param sender The command sender
     * @param runnable The runnable to execute
     * @param delay The ticks to wait before running the task
     * @return The scheduled task
     */
    Task runTaskLaterAsynchronously(Object plugin, Object sender, Runnable runnable, long delay) throws IllegalArgumentException;

    /**
     * Schedules a repeating task that will run until cancelled, starting after
     * the specified number of server ticks.
     *
     * @param plugin The reference to the plugin scheduling task
     * @param runnable The runnable to execute
     * @param delay The ticks to wait before running the task
     * @param period The ticks to wait between runs
     */
    Task runTaskTimer(Object plugin, Runnable runnable, long delay, long period) throws IllegalArgumentException;

    /**
     * Schedules a repeating task that will run until cancelled, starting after
     * the specified number of server ticks.
     *
     * @param plugin The reference to the plugin scheduling task
     * @param sender The command sender
     * @param runnable The runnable to execute
     * @param delay The ticks to wait before running the task
     * @param period The ticks to wait between runs
     */
    Task runTaskTimer(Object plugin, Object sender, Runnable runnable, long delay, long period) throws IllegalArgumentException;
}
