/*
 * Copyright 2010-2011 Ning, Inc.
 *
 * Ning licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.ning.jetty.core.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogInvalidResourcesServlet extends HttpServlet
{
    private static final Logger log = LoggerFactory.getLogger(LogInvalidResourcesServlet.class);

    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException
    {
        sendError(request, response);
    }

    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException
    {
        sendError(request, response);
    }

    private void sendError(final HttpServletRequest request, final HttpServletResponse response) throws IOException
    {
        log.warn(String.format("The invalid resource [%s] was requested from servlet [%s] on path [%s]", request.getPathInfo(), getServletConfig().getServletName(), request.getServletPath()));
        response.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
}
