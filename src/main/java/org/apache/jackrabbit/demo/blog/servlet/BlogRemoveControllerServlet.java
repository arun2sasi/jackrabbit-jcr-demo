/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.jackrabbit.demo.blog.servlet;

import java.io.IOException;

import javax.jcr.RepositoryException;
import javax.jcr.SimpleCredentials;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jackrabbit.demo.blog.model.BlogManager;

/**
 * Controller class which handles deleting of blog entries
 *
 */
 public class BlogRemoveControllerServlet extends ControllerServlet {
		
	 /**
	 * Serial version id
	 */
	private static final long serialVersionUID = 4358955541231867065L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			   
		 		String UUID = request.getParameter("UUID");
			  
			   try {
				   
					//log in to the repository and aquire a session   
					session = repository.login(new SimpleCredentials("username","password".toCharArray()));
					
					// Get the username of the current session. "username" attribute is set in LoginController when the user log in to the system.
					String username = (String)request.getSession().getAttribute("username");
					
					if (username == null) {
						//set the attributes which are required by user messae page
						request.setAttribute("msgTitle", "Authentication Required");
						request.setAttribute("msgBody", "Only logged in users are allowed to delete blog entries.");
						request.setAttribute("urlText", "go back to login page");
						request.setAttribute("url","/jackrabbit-jcr-demo/blog/index.jsp");	
						
						//forward the request to user massage page
			            RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/blog/userMessage.jsp");
			            requestDispatcher.forward(request, response);
			            return;
					}
					
					BlogManager.removeBlogEntry(UUID,username,session);
					
					//set the attributes which are required by user messae page
					request.setAttribute("msgTitle", "Delete");
					request.setAttribute("msgBody", "Blog entry was successfully deleted from your blog");
					request.setAttribute("urlText", "go back to blog page");
					request.setAttribute("url","/jackrabbit-jcr-demo/blog/view");	
					
					//forward the request to user massage page
		            RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/blog/userMessage.jsp");
		            requestDispatcher.forward(request, response);
				
			
			   } catch (RepositoryException e) {
					throw new ServletException("Couldn't delete blog entry.Error occured while accessing the repository",e);
			   } finally {
				   if (session != null) {
				    session.logout();
				   }
			   }
		}   	  	    
}