/*
 * Copyright (c) 2014 Test Inc.
 * All rights reserved.
 *
 * This distribution may include materials developed by third parties.
 */
package com.thescheideggers.fibonacciservice;

import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * <p>
 * This is the Known Answer Test (KAT) for the Fibonacci Service.</p>
 * <p>
 * Copyright: Copyright (c) 2014</p>
 * <p>
 * Company: Test Inc.</p>
 * <p/>
 * @author <a href="mailto:William.Scheidegger@GMail.com?subject=FibonacciImplTest%20JavaDoc">William Scheidegger</a>
 */
public class FibonacciServiceTest
{
   /**
    * Class name.
    */
   private static final String CLASS_NAME = FibonacciServiceTest.class.getName();
   /**
    * Logger.
    */
   private static final Logger LOGGER = Logger.getLogger(CLASS_NAME);
   /**
    * Serial Version UID.
    */
   private static final long serialVersionUID = 103640251760933139L;

   public FibonacciServiceTest()
   {
   }

   @BeforeClass
   public static void setUpClass()
   {
   }

   @AfterClass
   public static void tearDownClass()
   {
   }

   @Before
   public void setUp()
   {
   }

   @After
   public void tearDown()
   {
   }

   /**
    * Test of getFibonacciHtml method, of class FibonacciService.
    */
   @Test
   public void testGetFibonacciHtml_0args()
   {
      LOGGER.finest("Starting...");
      final String expResult = "<html><body>"
                               + "0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 "
                               + "610 987 1597 2584 4181 6765 10946 17711 28657 46368 "
                               + "75025 121393 196418 317811 514229 832040 1346269 2178309 "
                               + "3524578 5702887 9227465 14930352 24157817 39088169 63245986 "
                               + "102334155 165580141 267914296 433494437 701408733 1134903170 "
                               + "1836311903 2971215073 4807526976 7778742049 12586269025 "
                               + "20365011074 32951280099 53316291173 86267571272 139583862445 "
                               + "225851433717 365435296162 591286729879 956722026041 1548008755920 "
                               + "2504730781961 4052739537881 6557470319842 10610209857723 "
                               + "17167680177565 27777890035288 44945570212853 72723460248141 "
                               + "117669030460994 190392490709135 308061521170129 498454011879264 "
                               + "806515533049393 1304969544928657 2111485077978050 3416454622906707 "
                               + "5527939700884757 8944394323791464 14472334024676221 23416728348467685 "
                               + "37889062373143906 61305790721611591 99194853094755497 160500643816367088 "
                               + "259695496911122585 420196140727489673 679891637638612258 1100087778366101931 "
                               + "1779979416004714189 2880067194370816120 4660046610375530309 7540113804746346429"
                               + "</body></html>";
      final Client client = createClient();
      final WebTarget target = client.target("http://localhost:8080/FibonacciService/webresources/fibonacci");
      final Response response = target
              .request(MediaType.TEXT_HTML)
              .accept(MediaType.TEXT_HTML)
              .get();
      final String result = response.readEntity(String.class);
      assertEquals(expResult, result);
      LOGGER.finest("Finished.");
   }

   /**
    * Test of getFibonacciHtml method, of class FibonacciService.
    */
   @Test
   public void testGetFibonacciHtml_String()
   {
      LOGGER.finest("Starting...");
      final String expResult = "<html><body>"
                               + "0 1 1 2 3"
                               + "</body></html>";
      final Client client = createClient();
      final WebTarget target = client.target("http://localhost:8080/FibonacciService/webresources/fibonacci/5");
      final Response response = target
              .request(MediaType.TEXT_HTML)
              .accept(MediaType.TEXT_HTML)
              .get();
      final String result = response.readEntity(String.class);
      assertEquals(expResult, result);
      LOGGER.finest("Finished.");
   }

   /**
    * Test of getFibonacciString method, of class FibonacciService.
    */
   @Test
   public void testGetFibonacciString_XML()
   {
      LOGGER.finest("Starting...");
      final String expResult = "0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 "
                               + "610 987 1597 2584 4181 6765 10946 17711 28657 46368 "
                               + "75025 121393 196418 317811 514229 832040 1346269 2178309 "
                               + "3524578 5702887 9227465 14930352 24157817 39088169 63245986 "
                               + "102334155 165580141 267914296 433494437 701408733 1134903170 "
                               + "1836311903 2971215073 4807526976 7778742049 12586269025 "
                               + "20365011074 32951280099 53316291173 86267571272 139583862445 "
                               + "225851433717 365435296162 591286729879 956722026041 1548008755920 "
                               + "2504730781961 4052739537881 6557470319842 10610209857723 "
                               + "17167680177565 27777890035288 44945570212853 72723460248141 "
                               + "117669030460994 190392490709135 308061521170129 498454011879264 "
                               + "806515533049393 1304969544928657 2111485077978050 3416454622906707 "
                               + "5527939700884757 8944394323791464 14472334024676221 23416728348467685 "
                               + "37889062373143906 61305790721611591 99194853094755497 160500643816367088 "
                               + "259695496911122585 420196140727489673 679891637638612258 1100087778366101931 "
                               + "1779979416004714189 2880067194370816120 4660046610375530309 7540113804746346429";
      final Client client = createClient();
      final WebTarget target = client.target("http://localhost:8080/FibonacciService/webresources/fibonacci");
      final Response response = target
              .request(MediaType.APPLICATION_XML)
              .accept(MediaType.APPLICATION_XML)
              .get();
      final FibonacciResponseString result = response.readEntity(FibonacciResponseString.class);
      assertEquals(expResult, result.getValue());
      LOGGER.finest("Finished.");
   }

   /**
    * Test of getFibonacciString method, of class FibonacciService.
    */
   @Test
   public void testGetFibonacciString_JSON()
   {
      LOGGER.finest("Starting...");
      final String expResult = "0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 "
                               + "610 987 1597 2584 4181 6765 10946 17711 28657 46368 "
                               + "75025 121393 196418 317811 514229 832040 1346269 2178309 "
                               + "3524578 5702887 9227465 14930352 24157817 39088169 63245986 "
                               + "102334155 165580141 267914296 433494437 701408733 1134903170 "
                               + "1836311903 2971215073 4807526976 7778742049 12586269025 "
                               + "20365011074 32951280099 53316291173 86267571272 139583862445 "
                               + "225851433717 365435296162 591286729879 956722026041 1548008755920 "
                               + "2504730781961 4052739537881 6557470319842 10610209857723 "
                               + "17167680177565 27777890035288 44945570212853 72723460248141 "
                               + "117669030460994 190392490709135 308061521170129 498454011879264 "
                               + "806515533049393 1304969544928657 2111485077978050 3416454622906707 "
                               + "5527939700884757 8944394323791464 14472334024676221 23416728348467685 "
                               + "37889062373143906 61305790721611591 99194853094755497 160500643816367088 "
                               + "259695496911122585 420196140727489673 679891637638612258 1100087778366101931 "
                               + "1779979416004714189 2880067194370816120 4660046610375530309 7540113804746346429";
      final Client client = createClient();
      final WebTarget target = client.target("http://localhost:8080/FibonacciService/webresources/fibonacci");
      final Response response = target
              .request(MediaType.APPLICATION_JSON)
              .accept(MediaType.APPLICATION_JSON)
              .get();
      final FibonacciResponseString result = response.readEntity(FibonacciResponseString.class);
      assertEquals(expResult, result.getValue());
      LOGGER.finest("Finished.");
   }

   /**
    * Test of getFibonacciArray method, of class FibonacciService.
    */
   @Test
   public void testGetFibonacciArray_XML()
   {
      LOGGER.finest("Starting...");
      final long[] expResult = new long[]
      {
         0L, 1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L, 55L, 89L, 144L, 233L, 377L,
         610L, 987L, 1597L, 2584L, 4181L, 6765L, 10946L, 17711L, 28657L, 46368L,
         75025L, 121393L, 196418L, 317811L, 514229L, 832040L, 1346269L, 2178309L,
         3524578L, 5702887L, 9227465L, 14930352L, 24157817L, 39088169L, 63245986L,
         102334155L, 165580141L, 267914296L, 433494437L, 701408733L, 1134903170L,
         1836311903L, 2971215073L, 4807526976L, 7778742049L, 12586269025L,
         20365011074L, 32951280099L, 53316291173L, 86267571272L, 139583862445L,
         225851433717L, 365435296162L, 591286729879L, 956722026041L, 1548008755920L,
         2504730781961L, 4052739537881L, 6557470319842L, 10610209857723L,
         17167680177565L, 27777890035288L, 44945570212853L, 72723460248141L,
         117669030460994L, 190392490709135L, 308061521170129L, 498454011879264L,
         806515533049393L, 1304969544928657L, 2111485077978050L, 3416454622906707L,
         5527939700884757L, 8944394323791464L, 14472334024676221L, 23416728348467685L,
         37889062373143906L, 61305790721611591L, 99194853094755497L, 160500643816367088L,
         259695496911122585L, 420196140727489673L, 679891637638612258L, 1100087778366101931L,
         1779979416004714189L, 2880067194370816120L, 4660046610375530309L, 7540113804746346429L
      };
      final Client client = createClient();
      final WebTarget target = client.target("http://localhost:8080/FibonacciService/webresources/fibonacciArray");
      final Response response = target
              .request(MediaType.APPLICATION_XML)
              .accept(MediaType.APPLICATION_XML)
              .get();
      final FibonacciResponseArray result = response.readEntity(FibonacciResponseArray.class);
      assertArrayEquals(expResult, result.getValue());
      LOGGER.finest("Finished.");
   }

   /**
    * Test of getFibonacciArray method, of class FibonacciService.
    */
   @Test
   public void testGetFibonacciArray_JSON()
   {
      LOGGER.finest("Starting...");
      final long[] expResult = new long[]
      {
         0L, 1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L, 55L, 89L, 144L, 233L, 377L,
         610L, 987L, 1597L, 2584L, 4181L, 6765L, 10946L, 17711L, 28657L, 46368L,
         75025L, 121393L, 196418L, 317811L, 514229L, 832040L, 1346269L, 2178309L,
         3524578L, 5702887L, 9227465L, 14930352L, 24157817L, 39088169L, 63245986L,
         102334155L, 165580141L, 267914296L, 433494437L, 701408733L, 1134903170L,
         1836311903L, 2971215073L, 4807526976L, 7778742049L, 12586269025L,
         20365011074L, 32951280099L, 53316291173L, 86267571272L, 139583862445L,
         225851433717L, 365435296162L, 591286729879L, 956722026041L, 1548008755920L,
         2504730781961L, 4052739537881L, 6557470319842L, 10610209857723L,
         17167680177565L, 27777890035288L, 44945570212853L, 72723460248141L,
         117669030460994L, 190392490709135L, 308061521170129L, 498454011879264L,
         806515533049393L, 1304969544928657L, 2111485077978050L, 3416454622906707L,
         5527939700884757L, 8944394323791464L, 14472334024676221L, 23416728348467685L,
         37889062373143906L, 61305790721611591L, 99194853094755497L, 160500643816367088L,
         259695496911122585L, 420196140727489673L, 679891637638612258L, 1100087778366101931L,
         1779979416004714189L, 2880067194370816120L, 4660046610375530309L, 7540113804746346429L
      };
      final Client client = createClient();
      final WebTarget target = client.target("http://localhost:8080/FibonacciService/webresources/fibonacci");
      final Response response = target
              .request(MediaType.APPLICATION_JSON)
              .accept(MediaType.APPLICATION_JSON)
              .get();
      final FibonacciResponseArray result = response.readEntity(FibonacciResponseArray.class);
      assertArrayEquals(expResult, result.getValue());
      LOGGER.finest("Finished.");
   }

   /**
    * Test of putFibonacci method, of class FibonacciService.
    */
   @Test
   public void testPutFibonacciString_XML()
   {
      LOGGER.finest("Starting...");
      final String expResult = "0 1 1 2 3";
      final FibonacciRequest request = new FibonacciRequest(5);
      final Entity entity = Entity.xml(request);
      final Client client = createClient();
      final WebTarget target = client.target("http://localhost:8080/FibonacciService/webresources/fibonacci");
      final Response response = target
              .request(MediaType.APPLICATION_XML)
              .accept(MediaType.APPLICATION_XML)
              .put(entity);
      final FibonacciResponseString result = response.readEntity(FibonacciResponseString.class);
      assertEquals(expResult, result.getValue());
      LOGGER.finest("Finished.");
   }

   /**
    * Test of putFibonacci method, of class FibonacciService.
    */
   @Test
   public void testPutFibonacciString_JSON()
   {
      LOGGER.finest("Starting...");
      final String expResult = "0 1 1 2 3";
      final FibonacciRequest request = new FibonacciRequest(5);
      final Entity entity = Entity.json(request);
      final Client client = createClient();
      final WebTarget target = client.target("http://localhost:8080/FibonacciService/webresources/fibonacci");
      final Response response = target
              .request(MediaType.APPLICATION_XML)
              .accept(MediaType.APPLICATION_XML)
              .put(entity);
      final FibonacciResponseString result = response.readEntity(FibonacciResponseString.class);
      assertEquals(expResult, result.getValue());
      LOGGER.finest("Finished.");
   }

   /**
    * Test of putFibonacciArray method, of class FibonacciService.
    */
   @Test
   public void testPutFibonacciArray_XML()
   {
      LOGGER.finest("Starting...");
      final long[] expResult = new long[]
      {
         0L, 1L, 1L, 2L, 3L
      };
      final Client client = createClient();
      final WebTarget target = client.target("http://localhost:8080/FibonacciService/webresources/fibonacciArray");
      final FibonacciRequest request = new FibonacciRequest(5);
      final Entity entity = Entity.xml(request);
      final Response response = target
              .request(MediaType.APPLICATION_XML)
              .accept(MediaType.APPLICATION_XML)
              .put(entity);
      final FibonacciResponseArray result = response.readEntity(FibonacciResponseArray.class);
      assertArrayEquals(expResult, result.getValue());
      LOGGER.finest("Finished.");
   }

   /**
    * Test of putFibonacciArray method, of class FibonacciService.
    */
   @Test
   public void testPutFibonacciArray_JSON()
   {
      LOGGER.finest("Starting...");
      final long[] expResult = new long[]
      {
         0L, 1L, 1L, 2L, 3L
      };
      final Client client = createClient();
      final WebTarget target = client.target("http://localhost:8080/FibonacciService/webresources/fibonacciArray");
      final FibonacciRequest request = new FibonacciRequest(5);
      final Entity entity = Entity.json(request);
      final Response response = target
              .request(MediaType.APPLICATION_JSON)
              .accept(MediaType.APPLICATION_JSON)
              .put(entity);
      final FibonacciResponseArray result = response.readEntity(FibonacciResponseArray.class);
      assertArrayEquals(expResult, result.getValue());
      LOGGER.finest("Finished.");
   }

   Client createClient()
   {
      return ClientBuilder
              .newBuilder()
              .register(JacksonJaxbJsonProvider.class)
              .build();
   }
}
