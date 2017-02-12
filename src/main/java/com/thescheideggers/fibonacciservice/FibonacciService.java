/*
 * Copyright (c) 2014 Test Inc.
 * All rights reserved.
 *
 * This distribution may include materials developed by third parties.
 */
package com.thescheideggers.fibonacciservice;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * <p>
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
 * The resource is contained in the body of the POST request.
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
 * <p>
 * Copyright: Copyright (c) 2014</p>
 * <p>
 * Company: Test Inc.</p>
 * <p/>
 * @author <a href="mailto:William.Scheidegger@GMail.com?subject=FibonacciService%20JavaDoc">William Scheidegger</a>
 */
public class FibonacciService
{
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
    * The Context for this RESTful Service.
    */
   @Context
   private UriInfo context;

   /**
    * Creates a new instance of FibonacciResource
    */
   public FibonacciService()
   {
   }

   /**
    * Returns the max number of values in the sequence.
    * <p/>
    * @return the max number of values in the sequence
    */
   @Path("/fibonacci")
   @GET
   @Consumes({MediaType.TEXT_HTML})
   @Produces({MediaType.TEXT_HTML})
   public String getFibonacciHtml()
   {
      return "<html><body>"+FibonacciImpl.getFibonacciString(FibonacciImpl.LEN_MAX)+"</body></html>";
   }

   /**
    * Returns the desired sequence.
    * <p/>
    * @param len the desired number of values in the sequence
    * <p/>
    * @return the desired sequence
    */
   @Path("/fibonacci/{len}")
   @GET
   @Consumes({MediaType.TEXT_HTML})
   @Produces({MediaType.TEXT_HTML})
   //public String getFibonacciHtml()
   public String getFibonacciHtml(@PathParam("len") String len)
   {
      int length;
      String rtn;
      try
      {
         length = Integer.parseInt(len);
         rtn = "<html><body>"+FibonacciImpl.getFibonacciString(length)+"</body></html>";
      }
      catch(NumberFormatException ex)
      {
         rtn = "<html><body><b>ERROR:</b> "+ex.getMessage()+"</body></html>";
      }
      return rtn;
   }

   /**
    * Returns the max number of values in the sequence as a String.
    * <p/>
    * @return the max number of values in the sequence as a String
    */
   @Path("fibonacci")
   @GET
   @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
   public FibonacciResponseString getFibonacciString()
   {
      return new FibonacciResponseString(FibonacciImpl.getFibonacciString(FibonacciImpl.LEN_MAX));
   }

   /**
    * Returns the max number of values in the sequence as an Array.
    * <p/>
    * @return the max number of values in the sequence as an Array
    */
   @Path("fibonacciArray")
   @GET
   @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
   public FibonacciResponseArray getFibonacciArray()
   {
      final FibonacciResponseArray rtn = new FibonacciResponseArray();
      try
      {
         rtn.setValue(FibonacciImpl.getFibonacci(FibonacciImpl.LEN_MAX));
      }
      catch(IllegalArgumentException ex)
      {
         rtn.setError(ex.getMessage());
      }
      return rtn;
   }

   /**
    * Returns the desired sequence as a String.
    * <p/>
    * @param request the desired number of values in the sequence
    * <p/>
    * @return the desired sequence as a String
    */
   @Path("fibonacci")
   @PUT
   @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
   @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
   public FibonacciResponseString putFibonacciString(final FibonacciRequest request)
   {
      return new FibonacciResponseString(FibonacciImpl.getFibonacciString(request.getValue()));
   }

   /**
    * Returns the desired sequence as an Array.
    * <p/>
    * @param request the desired number of values in the sequence
    * <p/>
    * @return the desired sequence as an Array
    */
   @Path("fibonacciArray")
   @PUT
   @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
   @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
   public FibonacciResponseArray putFibonacciArray(final FibonacciRequest request)
   {
      final FibonacciResponseArray rtn = new FibonacciResponseArray();
      try
      {
         rtn.setValue(FibonacciImpl.getFibonacci(request.getValue()));
      }
      catch(IllegalArgumentException ex)
      {
         rtn.setError(ex.getMessage());
      }
      return rtn;
   }
}
