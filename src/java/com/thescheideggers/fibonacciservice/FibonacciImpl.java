/*
 * Copyright (c) 2014 Test Inc.
 * All rights reserved.
 *
 * This distribution may include materials developed by third parties.
 */
package com.thescheideggers.fibonacciservice;

/**
 * <p>
 * This is the algorithmic implementation to create a Fibonacci Sequence.</p>
 * <p>
 * Copyright: Copyright (c) 2014</p>
 * <p>
 * Company: Test Inc.</p>
 * <p/>
 * @author <a href="mailto:William.Scheidegger@GMail.com?subject=FibonacciImpl%20JavaDoc">William Scheidegger</a>
 */
public class FibonacciImpl
{
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
   private FibonacciImpl()
   {
   }

   /**
    * Returns a Fibonacci sequence of the specified length.
    * <p/>
    * @param len the desired length of the Fibonacci sequence
    * <p/>
    * @return the Fibonacci sequence
    * <p/>
    * @throws IllegalArgumentException if an the length is less than one
    */
   public static long[] getFibonacci(int len) throws IllegalArgumentException
   {
      final long[] rtn;
      // IF the desired length is LESS THAN then Minimum Length,
      // THEN throw a Runtime Exception;
      // ELSE IF the desired length is GREATER THAN the Maximum length,
      // THEN truncate to Maximum length;
      // ELSE create the array to the desired length.
      if(len < FibonacciImpl.LEN_MIN)
      {
         throw new IllegalArgumentException("Length was less than 1. [" + len + "]");
      }
      /*else*/if(len > FibonacciImpl.LEN_MAX)
      {
         rtn = new long[FibonacciImpl.LEN_MAX];
      }
      else
      {
         rtn = new long[len];
      }

      // Initialize the first element.
      rtn[0] = 0;
      // IF there are at least two elements,
      // THEN initialize the second element.
      if(rtn.length > 1)
      {
         rtn[1] = 1;
      }
      // FOR EACH additional element,
      // add the value of the two previous elements to obtain the value of
      // the current element.
      for(int idx = 2; idx < rtn.length; idx++)
      {
         rtn[idx] = rtn[idx - 1] + rtn[idx - 2];
      }
      return rtn;
   }
}
