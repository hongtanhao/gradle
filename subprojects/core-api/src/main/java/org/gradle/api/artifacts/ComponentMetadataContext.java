/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.api.artifacts;

import org.gradle.api.Incubating;

/**
 * Provides access to compoment metadata from a {@link ComponentMetadataRule}.
 *
 * @since 4.9
 */
@Incubating
public interface ComponentMetadataContext {

    /**
     * Used to access a specific descriptor format.
     * For Ivy descriptor, an {@link org.gradle.api.artifacts.ivy.IvyModuleDescriptor ivy module descriptor} is returned.
     *
     * @param descriptorClass the descriptor class
     * @param <T> the descriptor type
     *
     * @return a descriptor, or {@code null} if there was none of the requested type.
     *
     * @see org.gradle.api.artifacts.ivy.IvyModuleDescriptor
     */
    <T> T getDescriptor(Class<T> descriptorClass);

    ComponentMetadataDetails getDetails();
}