/*
 * Copyright 2016 aliba.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.oneandone.rest.POJO.Requests;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author aliba
 */
public class CreateSharedStorageRequest extends BaseRequest {
    private String name;
    private String description;
    private int size;
    @JsonProperty("datacenter_id")
    private String datacenterId;

    /**
     * Name of the shared storage
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    
    /**
     * Id of the data center
     */
    public String getDataCenter() {
        return datacenterId;
    }

    /**
     * @param datacenterId the data center to set
     */
    public void setDataCenter(String datacenterId) {
        this.datacenterId = datacenterId;
    }

    /**
     * @return Description of the shared storage
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return Size of shared storage","minimum": "50","maximum": "2000","multipleOf": "50",

     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
}
