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
 * This is the ResponseArray object for the FibonacciService.
 * Since JAX-RS supports automatic mapping from a JAXB annotated class to XML and JSON,
 * some of the magic is already taken care of.
 *
 * @author <a href="mailto:William.Scheidegger@GMail.com?subject=FibonacciResponseArray%20JavaDoc">William Scheidegger</a>
 */
@XmlRootElement(name="FibonacciResponse")
public class FibonacciResponseArray extends FibonacciResponse {
    ///**
    // * Class name.
    // */
    //private static final String CLASS_NAME = FibonacciResponseArray.class.getName();
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
    private long[] value;
    /**
     * Any error codes for this response.
     */
    private String error;

    /**
     * Public constructor to initialize the "Value" at a minimum.
     *
     * @param id the unique id
     */
    public FibonacciResponseArray(final long id) {
        this(id, new long[0], null);
    }

    /**
     * Constructs a new Response with the specified "Value".
     *
     * @param id  the unique id
     * @param aL  the initial value
     * @param err any error codes.
     */
    public FibonacciResponseArray(final long id, final long[] aL, final String err) {
        super(id);
        if (aL == null || aL.length == 0) {
            value = new long[0];
        } else {
            value = new long[aL.length];
            System.arraycopy(aL, 0, value, 0, value.length);
        }
        error = err;
    }

    /**
     * Returns the "Value" of this Response.
     *
     * @return the "Value" of this Response
     */
    public long[] getValue() {
        final long[] rtn;
        if (value == null || value.length == 0) {
            rtn = new long[0];
        } else {
            rtn = new long[value.length];
            System.arraycopy(value, 0, rtn, 0, rtn.length);
        }
        return rtn;
    }

    /**
     * Sets the "Value" of this Response.
     *
     * @param aL the new "Value"
     */
    public void setValue(final long[] aL) {
        if (aL == null || aL.length == 0) {
            value = new long[0];
        } else {
            value = new long[aL.length];
            System.arraycopy(aL, 0, value, 0, value.length);
        }
    }

    /**
     * Returns the error of this Response.
     *
     * @return the error of this Response
     */
    public String getError() {
        return error;
    }

    /**
     * Sets the error of this Response.
     *
     * @param err the new error
     */
    public void setError(final String err) {
        error = err;
    }
}
