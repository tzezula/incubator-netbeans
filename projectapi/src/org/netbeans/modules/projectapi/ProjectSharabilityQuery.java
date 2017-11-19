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

package org.netbeans.modules.projectapi;

import java.io.File;
import org.netbeans.api.project.FileOwnerQuery;
import org.netbeans.api.project.Project;
import org.netbeans.api.queries.SharabilityQuery;
import org.openide.util.BaseUtilities;

/**
 * Delegates {@link SharabilityQuery} to implementations in project lookup.
 * @author Jesse Glick
 */
@SuppressWarnings("deprecation")
@org.openide.util.lookup.ServiceProvider(service=org.netbeans.spi.queries.SharabilityQueryImplementation.class)
public class ProjectSharabilityQuery implements org.netbeans.spi.queries.SharabilityQueryImplementation {

    public ProjectSharabilityQuery() {}
    
    public @Override int getSharability(File file) {
        Project p = FileOwnerQuery.getOwner(BaseUtilities.toURI(file));
        if (p != null) {
            org.netbeans.spi.queries.SharabilityQueryImplementation sqi = p.getLookup().lookup(org.netbeans.spi.queries.SharabilityQueryImplementation.class);
            if (sqi != null) {
                return sqi.getSharability(file);
            }
        }
        return SharabilityQuery.UNKNOWN;
    }
    
}
