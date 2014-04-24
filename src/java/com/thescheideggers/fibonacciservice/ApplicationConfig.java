/*
 * Copyright (c) 2014 Test Inc.
 * All rights reserved.
 *
 * This distribution may include materials developed by third parties.
 */
package com.thescheideggers.fibonacciservice;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 * <p>
 * This is the ApplicationConfig.
 * <p>
 * Copyright: Copyright (c) 2014</p>
 * <p>
 * Company: Test Inc.</p>
 * <p/>
 * @author <a href="mailto:William.Scheidegger@GMail.com?subject=ApplicationConfig%20JavaDoc">William Scheidegger</a>
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application
{

   @Override
   public Set<Class<?>> getClasses()
   {
      Set<Class<?>> resources = new java.util.HashSet<>();
      addRestResourceClasses(resources);
      return resources;
   }

   /**
    * Do not modify addRestResourceClasses() method.
    * It is automatically populated with
    * all resources defined in the project.
    * If required, comment out calling this method in getClasses().
    */
   private void addRestResourceClasses(Set<Class<?>> resources)
   {
      resources.add(com.thescheideggers.fibonacciservice.FibonacciService.class);
   }
   
}
