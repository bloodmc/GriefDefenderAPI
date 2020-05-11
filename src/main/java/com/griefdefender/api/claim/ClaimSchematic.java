package com.griefdefender.api.claim;

import com.flowpowered.math.vector.Vector3i;
import com.griefdefender.api.GriefDefender;

import java.time.Instant;
import java.util.Optional;

public interface ClaimSchematic {

    /**
     * Gets the claim schematic is stored in.
     * 
     * @return The claim schematic is stored in
     */
    Claim getClaim();

    /**
     * Gets the name of the schematic.
     * 
     * @return The schematic name
     */
    String getName();

    /**
     * Gets the schematic creation date.
     * 
     * @return The date created
     */
    Instant getDateCreated();

    /**
     * Gets origin of schematic.
     * 
     * @return The origin pos
     */
    Vector3i getOrigin();

    /**
     * Sets origin of schematic.
     * 
     * @param pos The new origin pos
     */
    void setOrigin(Vector3i pos);

    /**
     * Sets origin of schematic.
     * 
     * @param x X coordinate
     * @param y Y coordinate
     * @param z Z coordinate
     */
    void setOrigin(int x, int y, int z);

    /**
     * Applies schematic to claim.
     * 
     * @return If schematic apply was successful, false if not
     */
    boolean apply();

    /**
     * Gets a new claim schematic builder instance for {@link Builder}.
     * 
     * @return A new claim schematic builder instance
     */
    public static ClaimSchematic.Builder builder() {
        return GriefDefender.getRegistry().createBuilder(ClaimSchematic.Builder.class);
    }

    public interface Builder {

        /**
         * The claim to use for schematic.
         * 
         * @param claim The claim
         * @return The builder
         */
        Builder claim(Claim claim);

        /**
         * The schematic name.
         * 
         * @param name
         * @return The builder
         */
        Builder name(String name);

        /**
         * The origin to use for claim.
         * 
         * @param origin The origin
         * @return The builder
         */
        Builder origin(Vector3i origin);

        /**
         * The origin to use for claim.
         * 
         * @param x X coordinate
         * @param y Y coordinate
         * @param z Z coordinate
         * @return The builder
         */
        Builder origin(int x, int y, int z);

        /**
         * Resets the builder to default settings.
         * 
         * @return The builder
         */
        Builder reset();

        /**
         * Returns the {@link ClaimResult}.
         * 
         * @return The created schematic, if successful
         */
        Optional<ClaimSchematic> build();
    }
}
