package com.griefdefender.api.data;

import java.util.Set;

public interface ClanDataGetter {

    /**
     * Gets the trusted accessor tags.
     * 
     * @return The mutable accessor tags
     */
    Set<String> getAccessorTags();

    /**
     * Gets the trusted builder tags.
     * 
     * @return The mutable builder tags
     */
    Set<String> getBuilderTags();

    /**
     * Gets the trusted container tags.
     * 
     * @return The mutable container tags
     */
    Set<String> getContainerTags();

    /**
     * Gets the trusted manager tags.
     * 
     * @return The mutable manager tags
     */
    Set<String> getManagerTags();
}
