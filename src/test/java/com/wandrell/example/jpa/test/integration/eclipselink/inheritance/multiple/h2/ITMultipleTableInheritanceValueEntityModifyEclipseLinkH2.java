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

package com.wandrell.example.jpa.test.integration.eclipselink.inheritance.multiple.h2;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import com.wandrell.example.jpa.test.util.config.context.PersistenceContextConfig;
import com.wandrell.example.jpa.test.util.config.context.TestContextConfig;
import com.wandrell.example.jpa.test.util.config.properties.DataBaseScriptsPropertiesConfig;
import com.wandrell.example.jpa.test.util.config.properties.DataBaseUserPropertiesConfig;
import com.wandrell.example.jpa.test.util.config.properties.JdbcPropertiesPaths;
import com.wandrell.example.jpa.test.util.config.properties.JpaPropertiesConfig;
import com.wandrell.example.jpa.test.util.config.properties.PersistenceProviderPropertiesConfig;
import com.wandrell.example.jpa.test.util.config.properties.QueryPropertiesPaths;
import com.wandrell.example.jpa.test.util.config.properties.TestPropertiesConfig;
import com.wandrell.example.jpa.test.util.test.integration.inheritance.multiple.AbstractITMultipleTableInheritanceValueEntityModify;

/**
 * Integration tests for a {@code MultipleTableInheritanceValueEntity} testing
 * it can be modified.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
@ContextConfiguration(locations = { TestContextConfig.DEFAULT,
        TestContextConfig.ENTITY_MODIFIABLE,
        PersistenceContextConfig.ECLIPSELINK })
@TestPropertySource(
        locations = { TestPropertiesConfig.MULTIPLE_INHERITANCE_VALUE,
                PersistenceProviderPropertiesConfig.ECLIPSELINK,
                DataBaseUserPropertiesConfig.DEFAULT,
                DataBaseScriptsPropertiesConfig.MSSQL, JpaPropertiesConfig.H2,
                JdbcPropertiesPaths.H2,
                QueryPropertiesPaths.MULTIPLE_INHERITANCE_VALUE },
        properties = {
                "jpa.persistenceUnitName=multiple_inheritance_eclipselink_h2_modify",
                "jdbc.url=jdbc:h2:mem:test_eclipselink_modify;DB_CLOSE_ON_EXIT=FALSE" })
public final class ITMultipleTableInheritanceValueEntityModifyEclipseLinkH2
        extends AbstractITMultipleTableInheritanceValueEntityModify {

    /**
     * Default constructor.
     */
    public ITMultipleTableInheritanceValueEntityModifyEclipseLinkH2() {
        super();
    }

}
