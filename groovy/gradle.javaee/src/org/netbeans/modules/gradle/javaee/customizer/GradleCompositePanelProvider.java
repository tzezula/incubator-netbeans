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

package org.netbeans.modules.gradle.javaee.customizer;

import org.netbeans.modules.gradle.api.GradleBaseProject;
import org.netbeans.modules.gradle.api.NbGradleProject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ui.support.ProjectCustomizer;
import org.netbeans.modules.web.common.ui.api.CssPreprocessorsUI;
import org.openide.util.Lookup;

/**
 *
 * @author Laszlo Kishalmi
 */
public class GradleCompositePanelProvider implements ProjectCustomizer.CompositeCategoryProvider {
    
    @ProjectCustomizer.CompositeCategoryProvider.Registration(projectType = NbGradleProject.GRADLE_PROJECT_TYPE, position = 259)
    public static ProjectCustomizer.CompositeCategoryProvider createCssPreprocessors() {
        return new FilterProvider(CssPreprocessorsUI.getDefault().createCustomizer(), "war");
    }

    @ProjectCustomizer.CompositeCategoryProvider.Registration(projectType = NbGradleProject.GRADLE_PROJECT_TYPE, position = 301)
    public static ProjectCustomizer.CompositeCategoryProvider createRunPanel() {
        return new FilterProvider(new GradleCompositePanelProvider(), "war");
    }
    
    @Override
    public ProjectCustomizer.Category createCategory(Lookup context) {
        return ProjectCustomizer.Category.create("Run", "Run", null);
    }

    @Override
    public JComponent createComponent(ProjectCustomizer.Category category, Lookup context) {
        CustomizerRunWar cust = new CustomizerRunWar(context.lookup(Project.class));
        category.setStoreListener((ActionEvent e) -> {
            cust.save();
        });
        return cust;
    }
    
    private static class FilterProvider implements ProjectCustomizer.CompositeCategoryProvider {

        final ProjectCustomizer.CompositeCategoryProvider original;
        final String plugin;
        

        public FilterProvider(ProjectCustomizer.CompositeCategoryProvider original, String plugin) {
            this.original = original;
            this.plugin = plugin;
        }

        @Override
        public ProjectCustomizer.Category createCategory(Lookup context) {
            Project project = context.lookup(Project.class);
            assert project != null;
            GradleBaseProject gbp = GradleBaseProject.get(project);
            if (!gbp.getPlugins().contains(plugin)) {
                return null;
            }
            return original.createCategory(context);
        }

        @Override
        public JComponent createComponent(ProjectCustomizer.Category category, Lookup context) {
            return original.createComponent(category, context);
        }

    }
}
