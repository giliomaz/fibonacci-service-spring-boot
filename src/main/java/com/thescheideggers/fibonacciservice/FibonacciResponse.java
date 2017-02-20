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

/**
 * This is the abstract super Response object for the FibonacciService.
 * Since JAX-RS supports automatic mapping from a JAXB annotated class to XML and JSON,
 * some of the magic is already taken care of.
 *
 * @author <a href="mailto:William.Scheidegger@GMail.com?subject=FibonacciResponse%20JavaDoc">William Scheidegger</a>
 */
public abstract class FibonacciResponse {
    /**
     * The "ID" of this Response.
     */
    private final long id;

    public FibonacciResponse(final long unique) {
        id = unique;
    }

    /**
     * Returns the "ID" of this Response.
     *
     * @return the "ID" of this Response
     */
    public long getId() {
        return id;
    }
}
