/*
 * This file is part of GriefDefenderAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;

import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * A cause represents the reason or initiator of an event.
 *
 * <p>For example, if a block of sand is placed where it drops, the block of
 * sand would create a falling sand entity, which then would place another block
 * of sand. The block place event for the final block of sand would have the
 * cause chain of the block of sand -&gt; falling sand entity.</p>
 *
 * <p>It is not possible to accurately describe the chain of causes in all
 * scenarios so a best effort approach is generally acceptable. For example, a
 * player might press a lever, activating a complex Redstone circuit, which
 * would then launch TNT and cause the destruction of some blocks, but tracing
 * this event would be too complicated and thus may not be attempted.</p>
 */
@SuppressWarnings("unchecked")
public final class EventCause implements Iterable<Object> {

    /**
     * Creates a new {@link Builder} to make a new {@link EventCause}.
     *
     * @return The new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Constructs a new cause with the specified event context and cause.
     *
     * @param cause The direct object cause
     * @return The constructed cause
     */
    public static EventCause of(Object cause) {
        if (cause == null) {
            throw new NullPointerException("Cause cannot be null!");
        }
        return new EventCause(new Object[] {cause});
    }

    /**
     * Constructs a new cause with the specified event context and causes.
     *
     * @param cause The direct object cause
     * @param causes Other associated causes
     * @return The built cause
     */
    public static EventCause of(Object cause, Object... causes) {
        Builder builder = builder();
        builder.append(cause);
        for (Object namedCause : causes) {
            builder.append(namedCause);
        }
        return builder.build();
    }

    /**
     * Constructs a new cause with the specified event context and causes.
     *
     * @param iterable The associated causes
     * @return The built cause
     */
    public static EventCause of(Iterable<Object> iterable) {
        Builder builder = builder();
        for (Object cause : iterable) {
            builder.append(cause);
        }
        return builder.build();
    }

    final Object[] cause;

    // lazy load
    @Nullable private List<Object> immutableCauses;

    /**
     * Constructs a new cause.
     *
     * @param ctx The event context
     * @param causes The causes
     */
    EventCause(Object[] causes) {
        final Object[] objects = new Object[causes.length];
        for (int index = 0; index < causes.length; index++) {
            objects[index] = causes[index];
        }
        this.cause = objects;
    }

    /**
     * Constructs a new cause.
     *
     * @param causes The causes
     */
    EventCause(Collection<Object> causes) {
        final Object[] objects = new Object[causes.size()];
        int index = 0;
        for (Object cause: causes) {
            objects[index++] = cause;
        }
        this.cause = objects;
    }

    /**
     * Gets the root {@link Object} of this cause.
     *
     * @return The root object cause for this cause
     */
    public Object root() {
        return this.cause[0];
    }

    /**
     * Gets the first <code>T</code> object of this {@link EventCause}, if available.
     *
     * @param target The class of the target type
     * @param <T> The type of object being queried for
     * @return The first element of the type, if available
     */
    public <T> Optional<T> first(Class<T> target) {
        for (Object aCause : this.cause) {
            if (target.isInstance(aCause)) {
                return Optional.of((T) aCause);
            }
        }
        return Optional.empty();
    }

    /**
     * Gets the last object instance of the {@link Class} of type
     * <code>T</code>.
     *
     * @param target The class of the target type
     * @param <T> The type of object being queried for
     * @return The last element of the type, if available
     */
    public <T> Optional<T> last(Class<T> target) {
        for (int i = this.cause.length - 1; i >= 0; i--) {
            if (target.isInstance(this.cause[i])) {
                return Optional.of((T) this.cause[i]);
            }
        }
        return Optional.empty();
    }

    /**
     * Gets the object immediately before the object that is an instance of the
     * {@link Class} passed in.
     *
     * @param clazz The class of the object
     * @return The object
     */
    public Optional<?> before(Class<?> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException(String.valueOf("The provided class cannot be null!"));
        }
        if (this.cause.length == 1) {
            return Optional.empty();
        }
        for (int i = 0; i < this.cause.length; i++) {
            if (clazz.isInstance(this.cause[i]) && i > 0) {
                return Optional.of(this.cause[i - 1]);
            }
        }
        return Optional.empty();
    }

    /**
     * Gets the object immediately after the object that is an instance of the
     * {@link Class} passed in.
     *
     * @param clazz The class to type check
     * @return The object after, if available
     */
    public Optional<?> after(Class<?> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException(String.valueOf("The provided class cannot be null!"));
        }
        if (this.cause.length == 1) {
            return Optional.empty();
        }
        for (int i = 0; i < this.cause.length; i++) {
            if (clazz.isInstance(this.cause[i]) && i + 1 < this.cause.length) {
                return Optional.of(this.cause[i + 1]);
            }
        }
        return Optional.empty();
    }

    /**
     * Returns whether the target class matches any object of this {@link EventCause}
     * .
     * 
     * @param target The class of the target type
     * @return True if found, false otherwise
     */
    public boolean containsType(Class<?> target) {
        if (target == null) {
            throw new IllegalArgumentException("The provided class cannot be null!");
        }
        for (Object aCause : this.cause) {
            if (target.isInstance(aCause)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Checks if this cause contains of any of the provided {@link Object}. This
     * is the equivalent to checking based on {@link #equals(Object)} for each
     * object in this cause.
     *
     * @param object The object to check if it is contained
     * @return True if the object is contained within this cause
     */
    public boolean contains(Object object) {
        for (Object aCause : this.cause) {
            if (aCause.equals(object)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets an {@link ImmutableList} of all objects that are instances of the
     * given {@link Class} type <code>T</code>.
     *
     * @param <T> The type of objects to query for
     * @param target The class of the target type
     * @return An immutable list of the objects queried
     */
    public <T> List<T> allOf(Class<T> target) {
        List<T> builder = new ArrayList<>();
        for (Object aCause : this.cause) {
            if (target.isInstance(aCause)) {
                builder.add((T) aCause);
            }
        }
        return Collections.unmodifiableList(builder);
    }

    /**
     * Gets an immutable {@link List} with all object causes that are not
     * instances of the provided {@link Class}.
     *
     * @param ignoredClass The class of object types to ignore
     * @return The list of objects not an instance of the provided class
     */
    public List<Object> noneOf(Class<?> ignoredClass) {
        List<Object> builder = new ArrayList<>();
        for (Object cause : this.cause) {
            if (!ignoredClass.isInstance(cause)) {
                builder.add(cause);
            }
        }
        return Collections.unmodifiableList(builder);
    }

    /**
     * Gets an {@link List} of all causes within this {@link EventCause}.
     *
     * @return An immutable list of all the causes
     */
    public List<Object> all() {
        if (this.immutableCauses == null) {
            this.immutableCauses = Arrays.asList(this.cause);
        }
        return Collections.unmodifiableList(this.immutableCauses);
    }

    /**
     * Creates a new {@link EventCause} where the objects are added at the end of the
     * cause array of objects.
     *
     * @param additional The additional object to add
     * @return The new cause
     */
    public EventCause with(Object additional) {
        if (additional == null) {
            throw new NullPointerException("No null arguments allowed!");
        }
        List<Object> list = new ArrayList<>();
        list.add(additional);
        return with(list);
    }

    /**
     * Creates a new {@link EventCause} where the objects are added at the end of the
     * cause array of objects.
     *
     * @param additional The additional object to add
     * @param additionals The remaining objects to add
     * @return The new cause
     */
    public EventCause with(Object additional, Object... additionals) {
        if (additional == null) {
            throw new NullPointerException("No null arguments allowed!");
        }
        List<Object> list = new ArrayList<>();
        list.add(additional);
        for (Object object : additionals) {
            list.add(object);
        }
        return with(list);
    }

    /**
     * Creates a new {@link EventCause} where the objects are added at the end of the
     * cause array of objects.
     *
     * @param iterable The additional objects
     * @return The new cause
     */
    public EventCause with(Iterable<Object> iterable) {
        EventCause.Builder builder = new Builder().from(this);
        for (Object o : iterable) {
            builder.append(o);
        }
        return builder.build();
    }

    /**
     * Merges this cause with the other cause.
     *
     * @param cause The cause to merge with this
     * @return The new merged cause
     */
    public EventCause with(EventCause cause) {
        EventCause.Builder builder = builder().from(this);
        for (int i = 0; i < cause.cause.length; i++) {
            builder.append(cause.cause[i]);
        }
        return builder.build();
    }

    @Override
    public Iterator<Object> iterator() {
        return new Itr();
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (object instanceof EventCause) {
            EventCause cause = ((EventCause) object);
            return Arrays.equals(this.cause, cause.cause);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.cause);
    }

    @Override
    public String toString() {
        String causeString = "Cause[Stack={";
        StringJoiner joiner = new StringJoiner(", ");
        for (int i = 0; i < this.cause.length; i++) {
            joiner.add(this.cause[i].toString());
        }
        return causeString + joiner.toString() + "}]";
    }

    private class Itr implements Iterator<Object> {

        private int index = 0;

        Itr() { }

        @Override
        public Object next() {
            if (this.index >= EventCause.this.cause.length) {
                throw new NoSuchElementException();
            }
            return EventCause.this.cause[this.index++];
        }

        @Override
        public boolean hasNext() {
            return this.index != EventCause.this.cause.length;
        }

    }

    public static final class Builder {

        final List<Object> causes = new ArrayList<>();

        Builder() {

        }

        /**
         * Appends the specified object to the cause.
         *
         * @param cause The object to append to the cause.
         * @return The modified builder, for chaining
         */
        public Builder append(Object cause) {
            if (cause == null) {
                throw new NullPointerException("Cause cannot be null!");
            }
            if (!this.causes.isEmpty() && this.causes.get(this.causes.size() - 1) == cause) {
                return this;
            }
            this.causes.add(cause);
            return this;
        }

        /**
         * Inserts the specified object into the cause.
         *
         * @param position The position to insert into
         * @param cause The object to insert into the cause
         * @return The modified builder, for chaining
         */
        public Builder insert(int position, Object cause) {
            if (cause == null) {
                throw new NullPointerException(String.valueOf("Cause cannot be null!"));
            }
            this.causes.add(position, cause);
            return this;
        }

        /**
         * Appends all specified objects onto the cause.
         *
         * @param causes The objects to add onto the cause
         * @return The modified builder, for chaining
         */
        public Builder appendAll(Collection<Object> causes) {
            if (causes == null) {
                throw new NullPointerException("Causes cannot be null!");
            }
            causes.forEach(this::append);
            return this;
        }

        /**
         * Constructs a new {@link EventCause} with information added to the builder.
         *
         * @param ctx The context to build the cause with
         * @return The built cause
         */
        public EventCause build() {
            return new EventCause(this.causes);
        }

        public Builder from(EventCause value) {
            for (int i = 0; i < value.cause.length; i++) {
                this.causes.add(value.cause[i]);
            }
            return this;
        }

        public Builder reset() {
            this.causes.clear();
            return this;
        }
    }

}