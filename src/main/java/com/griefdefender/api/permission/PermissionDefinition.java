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

import java.util.Set;

import com.griefdefender.api.CatalogType;
import com.griefdefender.api.Core;
import com.griefdefender.api.Subject;
import com.griefdefender.api.gui.Icon;

import net.kyori.adventure.text.Component;

/**
 * Represents either a flag or option definition that holds permission data with contexts.
 */
public interface PermissionDefinition extends CatalogType {

    /**
     * Whether this definition is enabled.
     * 
     * @return true if enabled
     */
    boolean isEnabled();

    /**
     * Whether this definition is for admin use only.
     * 
     * @return true if admin only
     */
    boolean isAdmin();

    /**
     * Whether this definition supports managing owner and trusted.
     * 
     * <br><br>Note: This should only be true if a player can cause the definition action(s).
     * 
     * @return true if has owner mode
     */
    boolean hasOwnerMode();

    /**
     * Gets the group name associated with this definition.
     * 
     * @return The group name
     */
    String getGroupName();

    /**
     * Gets the preset name associated with this definition.
     */
    String getPresetName();

    /**
     * Gets the friendly description.
     * 
     * @return The friendly description
     */
    String getFriendlyDescription();

    /**
     * Gets the {@link Icon}.
     * 
     * @return The icon
     */
    Icon getIcon();

    /**
     * Gets the description.
     * 
     * @return The description
     */
    Component getDescription();

    /**
     * Gets the group description.
     * 
     * @return The group description
     */
    Component getGroupDescription();

    /**
     * Gets the contexts associated with this definition.
     * 
     * @return The definition contexts
     */
    Set<Context> getContexts();

    /**
     * Gets the subject this definition will be applied to.
     * 
     * <br><br>Note: If no subject is set, {@link Core#getDefaultSubject()} will be used.
     * @return
     */
    Subject getSubject();

    /**
     * Set to enable or disable this definition.
     * 
     * @param enabled
     */
    void setIsEnabled(boolean enabled);

    /**
     * Sets the new {@link Icon}
     * 
     * @param id The new icon 
     */
    void setIcon(Icon icon);
}
