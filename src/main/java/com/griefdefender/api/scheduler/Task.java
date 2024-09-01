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

import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Represents a task being executed by the scheduler
 */
public interface Task {

    /**
     * Retrieves the plugin owner of this task.
     *
     * @return The plugin owner
     */
    Object getPlugin();

    /**
     * Retrieves the command sender of this task, if available.
     *
     * @return The command sender
     */
    @Nullable Object getCommandSender();

    /**
     * Checks if task is a sync task.
     *
     * @return true if the task is run by main thread
     */
    boolean isSync();

    /**
     * Checks if task has been cancelled.
     *
     * @return true if the task has been cancelled
     */
    boolean isCancelled();

    /**
     * Attempts to cancel task.
     */
    void cancel();
}
