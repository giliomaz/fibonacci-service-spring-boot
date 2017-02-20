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
 * This is the algorithmic implementation to create a Fibonacci Sequence.
 *
 * @author <a href="mailto:William.Scheidegger@GMail.com?subject=FibonacciImpl%20JavaDoc">William Scheidegger</a>
 */
public class FibonacciImpl {
    ///**
    // * Class name.
    // */
    //private static final String CLASS_NAME = FibonacciImpl.class.getName();
    ///**
    // * Logger.
    // */
    //private static final Logger LOGGER = Logger.getLogger(CLASS_NAME);
    ///**
    // * Serial Version UID.
    // */
    //private static final long serialVersionUID = 103640251760933139L;
    /**
     * Minimum length.
     */
    public static final int LEN_MIN = 1;

    /**
     * Maximum length.
     */
    public static final int LEN_MAX = 93;

    /**
     * Private constructor to prevent anyone from instantiating it.
     */
    private FibonacciImpl() {
    }

    /**
     * Returns a Fibonacci sequence of the specified length.
     *
     * @param len the desired length of the Fibonacci sequence
     * @return the Fibonacci sequence as a String
     * @throws IllegalArgumentException if an the length is less than one
     */
    public static String getFibonacciString(int len) throws IllegalArgumentException {
        final StringBuilder rtn = new StringBuilder();
        final long[] vals = FibonacciImpl.getFibonacci(len);
        boolean first = true;
        // FOR each element of the array...
        for (long val : vals) {
            // IF this is the first time through the loop,
            // THEN reset the flag;
            // ELSE append a space to the buffer.
            if (first) {
                first = false;
            } else {
                rtn.append(" ");
            }
            // Append the value of the current element.
            rtn.append(val);
        }
        return rtn.toString();
    }

    /**
     * Returns a Fibonacci sequence of the specified length.
     *
     * @param len the desired length of the Fibonacci sequence
     * @return the Fibonacci sequence
     * @throws IllegalArgumentException if an the length is less than one
     */
    public static long[] getFibonacci(int len) throws IllegalArgumentException {
        final long[] rtn;
        // IF the desired length is LESS THAN then Minimum Length,
        // THEN throw a Runtime Exception;
        // ELSE IF the desired length is GREATER THAN the Maximum length,
        // THEN throw a Runtime Exception;
        // ELSE create the array to the desired length.
        if (len < FibonacciImpl.LEN_MIN) {
            throw new IllegalArgumentException(String.format("Length was less than %d. [%d]", FibonacciImpl.LEN_MIN, len));
        } else if (len > FibonacciImpl.LEN_MAX) {
            throw new IllegalArgumentException(String.format("Length was greater than %d. [%d]", FibonacciImpl.LEN_MAX, len));
        } else {
            rtn = new long[len];
        }

        // Initialize the first element.
        rtn[0] = 0;
        // IF there are at least two elements,
        // THEN initialize the second element.
        if (rtn.length > 1) {
            rtn[1] = 1;
        }
        // FOR EACH additional element,
        // add the value of the two previous elements to obtain the value of
        // the current element.
        for (int idx = 2; idx < rtn.length; idx++) {
            rtn[idx] = rtn[idx - 1] + rtn[idx - 2];
        }
        return rtn;
    }
}
