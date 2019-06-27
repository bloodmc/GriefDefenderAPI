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

import com.griefdefender.api.claim.Claim;
import com.griefdefender.api.claim.ClaimSchematic;
import com.griefdefender.api.economy.BankTransaction;
import com.griefdefender.api.registry.CatalogRegistryModule;

import java.util.Optional;

public interface Registry {

    /**
     * Creates a claim builder.
     * 
     * @return The claim builder
     */
    Claim.Builder createClaimBuilder();

    /**
     * Creates a claim schematic builder.
     * 
     * @return The claim schematic builder
     */
    ClaimSchematic.Builder createClaimSchematicBuilder();

    /**
     * Creates a bank transaction builder.
     * 
     * @return The bank transaction builder
     */
    BankTransaction.Builder createBankTransactionBuilder();


    /**
     * Gets the {@link CatalogRegistryModule} for supplied 
     * catalog class.
     * 
     * @return The catalog registry module
     */
    public <T extends CatalogType> Optional<CatalogRegistryModule<T>> getRegistryModuleFor(Class<T> catalogClass);
}
