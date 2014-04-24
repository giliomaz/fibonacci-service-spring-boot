/*
 * Copyright (c) 2014 Test Inc.
 * All rights reserved.
 *
 * This distribution may include materials developed by third parties.
 */
package com.thescheideggers.fibonacciservice;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author wdschei
 */
@Path("fibonacci")
public class FibonacciService
{
   @Context
   private UriInfo context;

   /**
    * Creates a new instance of FibonacciResource
    */
   public FibonacciService()
   {
   }

   /**
    * Retrieves representation of an instance of com.thescheideggers.fibonacciservice.FibonacciResource
    * @return an instance of java.lang.String
    */
   @GET
   @Produces("application/json")
   public String getJson()
   {
      //TODO return proper representation object
      throw new UnsupportedOperationException();
   }

   /**
    * PUT method for updating or creating an instance of FibonacciResource
    * @param content representation for the resource
    * @return an HTTP response with content of the updated or created resource.
    */
   @PUT
   @Consumes("application/json")
   public void putJson(String content)
   {
   }
}
