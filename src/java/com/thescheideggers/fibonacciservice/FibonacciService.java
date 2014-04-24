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
    * Returns the max number of values in the sequence.
    * <p/>
    * @return the max number of values in the sequence
    */
   @Path("fibonacci")
   @GET
   @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
   public ResponseString getFibonacci()
   ////////////////////////////////////////////////////////////////////////////////
   ////  NOTE: Another alternate implementation might be to return the array in the JSON
   ////public ResponseArray getFibonacci()
   ////////////////////////////////////////////////////////////////////////////////
   {
      return new ResponseString(FibonacciImpl.getFibonacciString(FibonacciImpl.LEN_MAX));
      //return new ResponseArray(FibonacciImpl.getFibonacci(FibonacciImpl.LEN_MAX));
   }

   /**
    * Returns the desired sequence.
    * <p/>
    * @param request the desired number of values in the sequence
    * <p/>
    * @return the desired sequence
    */
   @Path("fibonacci")
   @PUT
   @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
   @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
   public ResponseString putFibonacci(final Request request)
   ////////////////////////////////////////////////////////////////////////////////
   ////  NOTE: Another alternate implementation might be to return the array in the JSON
   ////public ResponseArray putFibonacci(final Request request)
   ////////////////////////////////////////////////////////////////////////////////
   {
      return new ResponseString(FibonacciImpl.getFibonacciString(request.getValue()));
      //return new ResponseArray(FibonacciImpl.getFibonacci(request.getValue()));
   }
}
