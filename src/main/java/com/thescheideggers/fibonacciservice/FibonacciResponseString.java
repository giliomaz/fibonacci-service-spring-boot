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
 * This is the ResponseString object for the FibonacciService.
 * Since JAX-RS supports automatic mapping from a JAXB annotated class to XML and JSON,
 * some of the magic is already taken care of.
 *
 * @author <a href="mailto:William.Scheidegger@GMail.com?subject=FibonacciResponseString%20JavaDoc">William Scheidegger</a>
 */
@XmlRootElement
public class FibonacciResponseString extends FibonacciResponse {
    ///**
    // * Class name.
    // */
    //private static final String CLASS_NAME = FibonacciResponseString.class.getName();
    ///**
    // * Logger.
    // */
    //private static final Logger LOGGER = Logger.getLogger(CLASS_NAME);
    /**
     * Serial Version UID.
     */
    private static final long serialVersionUID = 103640251760933139L;
    /**
     * The "Value" of this Response.
     */
    private String value;

    /**
     * Public constructor to initialize the "Value" at a minimum.
     *
     * @param id the unique id
     */
    public FibonacciResponseString(final long id) {
        this(id, "");
    }

    /**
     * Constructs a new Response with the specified "Value".
     *
     * @param id  the unique id
     * @param val the initial value
     */
    public FibonacciResponseString(final long id, final String val) {
        super(id);
        value = val;
    }

    /**
     * Returns the "Value" of this Response.
     *
     * @return the "Value" of this Response
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the "Value" of this Response.
     *
     * @param s the new "Value"
     */
    public void setValue(final String s) {
        value = s;
    }
}
