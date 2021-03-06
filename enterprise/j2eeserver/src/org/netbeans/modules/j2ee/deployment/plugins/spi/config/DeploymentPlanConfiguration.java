/*
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
 */

package org.netbeans.modules.j2ee.deployment.plugins.spi.config;

import java.io.OutputStream;
import org.netbeans.modules.j2ee.deployment.common.api.ConfigurationException;

/**
 * Configuration useful for creating the deployment plan file. The 
 * deployment plan file is created when the JSR-88 based deployment is used.
 * <p>
 * Implementation of this interface should be registered in the {@link ModuleConfiguration}
 * lookup.
 * 
 * @since 1.23
 * @author sherold
 */
public interface DeploymentPlanConfiguration {
    
    /**
     * Write the deployment plan file to the specified output stream.
     * 
     * @param outputStream the deployment paln file should be written to.
     * @throws ConfigurationException if an error during saving the deployment
     *         plan configuration occurs.
     */
    void save(OutputStream outputStream) throws ConfigurationException;
    
}
