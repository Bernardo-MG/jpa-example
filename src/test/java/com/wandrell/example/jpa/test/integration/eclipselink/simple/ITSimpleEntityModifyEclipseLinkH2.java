/**
 * The MIT License (MIT)
 * <p>
 * Copyright (c) 2015 the original author or authors.
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.wandrell.example.jpa.test.integration.eclipselink.simple;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import com.wandrell.example.jpa.test.util.config.context.PersistenceContextConfig;
import com.wandrell.example.jpa.test.util.config.context.TestContextConfig;
import com.wandrell.example.jpa.test.util.config.properties.PersistenceProviderPropertiesConfig;
import com.wandrell.example.jpa.test.util.config.properties.QueryPropertiesPaths;
import com.wandrell.example.jpa.test.util.config.properties.TestPropertiesConfig;
import com.wandrell.example.jpa.test.util.test.integration.simple.AbstractITSimpleEntityModify;

/**
 * Integration tests for a {@code SimpleEntity} testing it can be modified.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
@ContextConfiguration(locations = { TestContextConfig.DEFAULT,
        TestContextConfig.ENTITY_MODIFIABLE,
        PersistenceContextConfig.ECLIPSELINK })
@TestPropertySource(
        locations = { TestPropertiesConfig.LIQUIBASE,
                TestPropertiesConfig.SIMPLE_ENTITY,
                PersistenceProviderPropertiesConfig.ECLIPSELINK,
                
                 
                 QueryPropertiesPaths.SIMPLE_ENTITY },
        properties = { "jpa.persistenceUnitName=entities_eclipselink_h2_modify",
                 })
public final class ITSimpleEntityModifyEclipseLinkH2
        extends AbstractITSimpleEntityModify {

    /**
     * Default constructor.
     */
    public ITSimpleEntityModifyEclipseLinkH2() {
        super();
    }

}