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
package com.oneandone.sdk;

import com.oneandone.rest.POJO.Requests.CreateLoadBalancerRequest;
import com.oneandone.rest.client.RestClientException;
import com.oneandone.rest.POJO.Requests.UpdateLoadBalancerRequest;
import com.oneandone.rest.POJO.Response.LoadBalancerResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author aliba
 */
public class LoadBalancersApi extends OneAndOneAPIBase {

    public LoadBalancersApi() {
        super("load_balancers", "");
    }

    /**
     * Returns a list of your load balancers.
     * @param page Allows to use pagination. Sets the number of servers that will be shown in each page.
     * @param perPage Current page to show.
     * @param sort Allows to sort the result by priority:sort=name retrieves a list of elements ordered by their names.sort=-creation_date retrieves a list of elements ordered according to their creation date in descending order of priority.
     * @param query Allows to search one string in the response and return the elements that contain it. In order to specify the string use parameter q:    q=My server
     * @param fields Returns only the parameters requested: fields=id,name,description,hardware.ram
     * @return List LoadBalancerResponse
     * @throws RestClientException
     * @throws IOException
     */
    public List<LoadBalancerResponse> getLoadBalancers(int page, int perPage, String sort, String query, String fields) throws RestClientException, IOException {
        String queryUrl = getUrlBase().concat(resource).concat("?");
        boolean firstParameter = true;

        if (page != 0) {
            if (!firstParameter) {
                queryUrl = queryUrl.concat("&");
            }
            queryUrl = queryUrl.concat("page=").concat(Integer.toString(page));
            firstParameter = false;
        }
        if (perPage != 0) {
            if (!firstParameter) {
                queryUrl = queryUrl.concat("&");
            }
            queryUrl = queryUrl.concat("per_page=").concat(Integer.toString(perPage));
            firstParameter = false;
        }
        if (sort != null && !sort.isEmpty()) {
            if (!firstParameter) {
                queryUrl = queryUrl.concat("&");
            }
            queryUrl = queryUrl.concat("sort=").concat(sort);
            firstParameter = false;
        }
        if (query != null && !query.isEmpty()) {
            if (!firstParameter) {
                queryUrl = queryUrl.concat("&");
            }
            queryUrl = queryUrl.concat("q=").concat(query);
            firstParameter = false;
        }
        if (fields != null && !fields.isEmpty()) {
            if (!firstParameter) {
                queryUrl = queryUrl.concat("&");
            }
            queryUrl = queryUrl.concat("fields=").concat(fields);
        }
        LoadBalancerResponse[] result = client.get(queryUrl, null, LoadBalancerResponse[].class);
        return Arrays.asList(result);
    }

    /**
     * Returns information about a load balancer.
     * @param balancerId Returns information about a load balancer.
     * @return LoadBalancerResponse 
     * @throws RestClientException
     * @throws IOException
     */
    public LoadBalancerResponse getLoadBalancer(String balancerId) throws RestClientException, IOException {
        return client.get(getUrlBase().concat(resource).concat("/").concat(balancerId), null, LoadBalancerResponse.class);
    }

    /**
     * Creates a new load balancer.
     * @param object CreateLoadBalancerRequest
     * @return LoadBalancerResponse
     * @throws RestClientException
     * @throws IOException
     
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     */
    public LoadBalancerResponse createLoadBalancer(CreateLoadBalancerRequest object) throws RestClientException, IOException {
        return client.create(getUrlBase().concat(resource), object, LoadBalancerResponse.class, 202);
    }

    /**
     * Removes a load balancer.
     * @param balancerId Unique load balancer's identifier.
     * @return LoadBalancerResponse
     * @throws RestClientException
     * @throws IOException
     */
    public LoadBalancerResponse deleteLoadBalancer(String balancerId) throws RestClientException, IOException {
        return client.delete(getUrlBase().concat(resource).concat("/").concat(balancerId), LoadBalancerResponse.class);
    }

    /**
     * Modifies a load balancer.
     * @param balancerId Unique load balancer's identifier.
     * @param object UpdateLoadBalancerRequest
     * @return LoadBalancerResponse
     * @throws RestClientException
     * @throws IOException
     */
    public LoadBalancerResponse updateLoadBalancer(String balancerId, UpdateLoadBalancerRequest object) throws RestClientException, IOException {
        return client.update(getUrlBase().concat(resource).concat("/").concat(balancerId), object, LoadBalancerResponse.class, 202);
    }
}
