/*
 * _=_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_=
 * Fibonacci Service
 * _-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
 * Copyright (C) 2014 - 2017 Coffeehouse Consultants
 * _-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
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
 * =_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_=_
 */
package com.thescheideggers.fibonacciservice;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 * REST Web Service.</p>
 * <a href="http://vichargrave.com/restful-web-service-development-with-netbeans-and-tomcat-tutorial/">
 * Vic Hargrave described it as
 * </a>:
 * <p/>
 * <b>HTTP Service Requests</b>
 * <p/>
 * RESTful web services are implemented using one or more of the following four HTTP request types depending on the design of the system.
 * These services loosely map to the so-called CRUD operations: Create, Retrieve, Update and Delete.
 * <ul>
 * <li><b>PUT - </b>
 * Adds a resource on the server.
 * The resource is contained in the body of the PUT request.
 * PUT is analogous to an SQL insert statement.
 * </li>
 * <li><b>GET – </b>
 * Retrieves a resource from the server.
 * The resource is specified with a URL and may include a <i>?</i> to delineate the request from the request parameters.
 * GET is analogous to an SQL select statement.
 * </li>
 * <li><b>POST - </b>
 * Updates a resource on the server.
 * The resource is contained in the body of the POST request.
 * POST is analogous to an SQL update statement.
 * </li>
 * <li><b>DELETE – </b>
 * Deletes a resource on the server.
 * The resource is specified in the URL only.
 * DELETE is analogous to an SQL delete command.
 * </li>
 * </ul>
 *
 * @author <a href="mailto:William.Scheidegger@GMail.com?subject=FibonacciService%20JavaDoc">William Scheidegger</a>
 */
@RestController
public class FibonacciController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(
            path = {"/fibonacci", "/fibonacci/{length}"},
            method = GET,
            produces = {APPLICATION_JSON_VALUE, TEXT_XML_VALUE, TEXT_HTML_VALUE})
    public FibonacciResponseString getFibonacciString(HttpServletResponse response, @PathVariable(required = false) Optional<Integer> length) {
        final FibonacciResponseString rtn = new FibonacciResponseString(counter.incrementAndGet());
        try {
            rtn.setValue(FibonacciImpl.getFibonacciString(length.orElse(FibonacciImpl.LEN_MAX)));
        } catch (IllegalArgumentException ex) {
            rtn.setValue(ex.getMessage());
            response.setStatus(FORBIDDEN.value());
        }
        return rtn;
    }

    @RequestMapping(
            path = {"/fibonacciArray", "/fibonacciArray/{length}"},
            method = GET,
            produces = {APPLICATION_JSON_VALUE, TEXT_XML_VALUE, TEXT_HTML_VALUE})
    public FibonacciResponse getFibonacciArray(HttpServletResponse response, @PathVariable(required = false) Optional<Integer> length) {
        final FibonacciResponseArray rtn = new FibonacciResponseArray(counter.incrementAndGet());
        try {
            rtn.setValue(FibonacciImpl.getFibonacci(length.orElse(FibonacciImpl.LEN_MAX)));
        } catch (IllegalArgumentException ex) {
            rtn.setError(ex.getMessage());
            response.setStatus(FORBIDDEN.value());
        }
        return rtn;
    }

    @RequestMapping(
            path = "/fibonacci",
            method = PUT,
            produces = {APPLICATION_JSON_VALUE, TEXT_XML_VALUE, TEXT_HTML_VALUE})
    public FibonacciResponseString putFibonacciString(HttpServletResponse response, FibonacciRequest fibReq) {
        final FibonacciResponseString rtn = new FibonacciResponseString(counter.incrementAndGet());
        try {
            rtn.setValue(FibonacciImpl.getFibonacciString((Optional.of(fibReq.getValue())).orElse(FibonacciImpl.LEN_MAX)));
        } catch (IllegalArgumentException ex) {
            rtn.setValue(ex.getMessage());
            response.setStatus(FORBIDDEN.value());
        }
        return rtn;
    }

    @RequestMapping(
            path = "/fibonacciArray",
            method = PUT,
            produces = {APPLICATION_JSON_VALUE, TEXT_XML_VALUE, TEXT_HTML_VALUE})
    public FibonacciResponse putFibonacciArray(HttpServletResponse response, FibonacciRequest fibReq) {
        final FibonacciResponseArray rtn = new FibonacciResponseArray(counter.incrementAndGet());
        try {
            rtn.setValue(FibonacciImpl.getFibonacci((Optional.of(fibReq.getValue())).orElse(FibonacciImpl.LEN_MAX)));
        } catch (IllegalArgumentException ex) {
            rtn.setError(ex.getMessage());
            response.setStatus(FORBIDDEN.value());
        }
        return rtn;
    }
}
