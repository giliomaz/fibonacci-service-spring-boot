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

import javax.xml.bind.annotation.XmlRootElement;

/**
 * This is the Request object for the FibonacciService.
 * Since JAX-RS supports automatic mapping from a JAXB annotated class to XML and JSON,
 * some of the magic is already taken care of.
 *
 * @author <a href="mailto:William.Scheidegger@GMail.com?subject=FibonacciRequest%20JavaDoc">William Scheidegger</a>
 */
@XmlRootElement
public class FibonacciRequest {
    ///**
    // * Class name.
    // */
    //private static final String CLASS_NAME = FibonacciRequest.class.getName();
    ///**
    // * Logger.
    // */
    //private static final Logger LOGGER = Logger.getLogger(CLASS_NAME);
    /**
     * Serial Version UID.
     */
    private static final long serialVersionUID = 103640251760933139L;
    /**
     * The "Value" of this Request.
     */
    private int value;

    /**
     * Public no-arg constructor to initialize the "Value" at a minimum.
     */
    public FibonacciRequest() {
        value = 0;
    }

    /**
     * Constructs a new Request with the specified "Value".
     *
     * @param i the initial value
     */
    public FibonacciRequest(final int i) {
        value = i;
    }

    /**
     * Returns the "Value" of this Request.
     *
     * @return the "Value" of this Request
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the "Value" of this Request.
     *
     * @param i the new "Value"
     */
    public void setValue(final int i) {
        value = i;
    }
}
