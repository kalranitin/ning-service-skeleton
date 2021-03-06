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

package com.ning.jetty.jdbi.arecibo;

import com.ning.arecibo.jmx.AreciboProfile;
import com.ning.arecibo.jmx.MBeanRegistrar;

import com.google.inject.Inject;

/**
 * Exposes BoneCP stats to Arecibo. To use it:
 * <p/>
 * bind(BoneCPAreciboConnector.class).asEagerSingleton();
 */
public class BoneCPAreciboConnector
{
    @Inject
    public BoneCPAreciboConnector(final AreciboProfile profile)
    {
        new MBeanRegistrar("com.jolbox.bonecp:type=BoneCP")
                .addValue("CacheHitRatio")
                .addCounter("CacheHits")
                .addCounter("CacheMiss")
                .addValue("ConnectionWaitTimeAvg")
                .addCounter("ConnectionsRequested")
                .addValue("StatementExecuteTimeAvg")
                .addValue("StatementPrepareTimeAvg")
                .addCounter("StatementsCached")
                .addCounter("StatementsExecuted")
                .addCounter("StatementsPrepared")
                .addValue("TotalCreatedConnections")
                .addValue("TotalFree")
                .addValue("TotalLeased")
                .register(profile);
    }
}
