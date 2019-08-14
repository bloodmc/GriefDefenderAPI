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

import com.griefdefender.api.util.generator.DummyObjectProvider;

public class ResultTypes {

    public static final ResultType ECONOMY_MODE_NOT_ENABLED = DummyObjectProvider.createFor(ResultType.class, "ECONOMY_MODE_NOT_ENABLED");
    public static final ResultType SOURCE_NOT_VALID = DummyObjectProvider.createFor(ResultType.class, "SOURCE_NOT_VALID");
    public static final ResultType TARGET_NOT_VALID = DummyObjectProvider.createFor(ResultType.class, "TARGET_NOT_VALID");
    public static final ResultType CONTEXT_NOT_VALID = DummyObjectProvider.createFor(ResultType.class, "CONTEXT_NOT_VALID");
    public static final ResultType EVENT_CANCELLED = DummyObjectProvider.createFor(ResultType.class, "EVENT_CANCELLED");
    public static final ResultType FAILURE = DummyObjectProvider.createFor(ResultType.class, "FAILURE");
    public static final ResultType NO_PERMISSION = DummyObjectProvider.createFor(ResultType.class, "NO PERMISSION");
    public static final ResultType SUBJECT_DOES_NOT_EXIST = DummyObjectProvider.createFor(ResultType.class, "SUBJECT_DOES_NOT_EXIST");
    public static final ResultType SUCCESS = DummyObjectProvider.createFor(ResultType.class, "SUCCESS");
}
