/*
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */

package io.github;

import org.apache.hc.core5.http.HttpConnection;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.impl.Http1StreamListener;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class LoggingHttp1StreamListener implements Http1StreamListener {

    public static final LoggingHttp1StreamListener INSTANCE = new LoggingHttp1StreamListener();

    private final Logger connLog = LoggerFactory.getLogger("org.apache.hc.core5.http.connection");

    @Override
    public void onRequestHead(final HttpConnection connection, final HttpRequest request) {
    }

    @Override
    public void onResponseHead(final HttpConnection connection, final HttpResponse response) {
    }

    @Override
    public void onExchangeComplete(final HttpConnection connection, final boolean keepAlive) {
        if (connLog.isDebugEnabled()) {
            if (keepAlive) {
                connLog.debug("{} connection is kept alive", LoggingSupport.getId(connection));
            } else {
                connLog.debug("{} connection is not kept alive", LoggingSupport.getId(connection));
            }
        }
    }

}
