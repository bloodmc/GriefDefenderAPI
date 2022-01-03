package com.griefdefender.api.data;

import java.util.Set;

public interface ClanData extends ClanDataGetter {

    /**
     * Sets the trusted clan accessor tags.
     * 
     * @param The set of accessor tags
     */
    void setAccessorTags(Set<String> accessorTags);

    /**
     * Sets the trusted builder tags.
     * 
     * @param The set of builder tags
     */
    void setBuilderTags(Set<String> builderTags);

    /**
     * Sets the trusted container tags.
     * 
     * @param The set of container tags
     */
    void setContainerTags(Set<String> containerTags);

    /**
     * Sets the trusted manager tags.
     * 
     * @param The set of manager tags
     */
    void setManagerTags(Set<String> managerTags);

    /**
     * Sets the trusted resident tags.
     * 
     * @param The set of resident tags
     */
    void setResidentTags(Set<String> residentTags);
}
