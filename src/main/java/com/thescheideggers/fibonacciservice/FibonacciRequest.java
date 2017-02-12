/*
 * Copyright (c) 2014 Test Inc.
 * All rights reserved.
 *
 * This distribution may include materials developed by third parties.
 */
package com.thescheideggers.fibonacciservice;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 * This is the Request object for the FibonacciService.
 * Since JAX-RS supports automatic mapping from a JAXB annotated class to XML and JSON,
 * some of the magic is already taken care of.</p>
 * <p>
 * Copyright: Copyright (c) 2014</p>
 * <p>
 * Company: Test Inc.</p>
 * <p/>
 * @author <a href="mailto:William.Scheidegger@GMail.com?subject=FibonacciRequest%20JavaDoc">William Scheidegger</a>
 */
@XmlRootElement
public class FibonacciRequest
{
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
   public FibonacciRequest()
   {
      value = 0;
   }

   /**
    * Constructs a new Request with the specified "Value".
    * <p/>
    * @param i the initial value
    */
   public FibonacciRequest(final int i)
   {
      value = i;
   }

   /**
    * Returns the "Value" of this Request.
    * <p/>
    * @return the "Value" of this Request
    */
   public int getValue()
   {
      return value;
   }

   /**
    * Sets the "Value" of this Request.
    * <p>
    * @param i the new "Value"
    */
   public void setValue(final int i)
   {
      value = i;
   }
}
