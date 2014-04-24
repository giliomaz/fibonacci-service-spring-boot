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
 * This is the ResponseString object.
 * Since JAX-RS supports automatic mapping from a JAXB annotated class to XML and JSON,
 * some of the magic is already taken care of.</p>
 * <p>
 * Copyright: Copyright (c) 2014</p>
 * <p>
 * Company: Test Inc.</p>
 * <p/>
 * @author <a href="mailto:William.Scheidegger@GMail.com?subject=ResponseString%20JavaDoc">William Scheidegger</a>
 */
@XmlRootElement
public class ResponseString
{
   private String value;

   /**
    * Public no-arg constructor to initialize the "Value" at a minimum.
    */
   public ResponseString()
   {
      value = "";
   }

   /**
    * Constructs a new Response with the specified "Value".
    * <p/>
    * @param s the initial value
    */
   public ResponseString(final String s)
   {
      value = s;
   }

   /**
    * Returns the "Value" of this Response.
    * <p/>
    * @return the "Value" of this Response
    */
   public String getValue()
   {
      return value;
   }

   /**
    * Sets the "Value" of this Response.
    * <p>
    * @param s the new "Value"
    */
   public void setValue(final String s)
   {
      value = s;
   }
}
