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

package com.wandrell.example.jpa.test.integration.hibernate.enumeration.h2;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import com.wandrell.example.jpa.test.util.config.context.PersistenceContextConfig;
import com.wandrell.example.jpa.test.util.config.context.TestContextConfig;
import com.wandrell.example.jpa.test.util.config.properties.DataBaseScriptsPropertiesConfig;
import com.wandrell.example.jpa.test.util.config.properties.DataBaseUserPropertiesConfig;
import com.wandrell.example.jpa.test.util.config.properties.HibernateDialectPropertiesConfig;
import com.wandrell.example.jpa.test.util.config.properties.JdbcPropertiesPaths;
import com.wandrell.example.jpa.test.util.config.properties.JpaPropertiesConfig;
import com.wandrell.example.jpa.test.util.config.properties.PersistenceProviderPropertiesConfig;
import com.wandrell.example.jpa.test.util.config.properties.QueryPropertiesPaths;
import com.wandrell.example.jpa.test.util.config.properties.TestPropertiesConfig;
import com.wandrell.example.jpa.test.util.test.integration.enumeration.AbstractITEnumerationEntityQueryJpql;

/**
 * Integration tests for a {@code EnumerationEntity} testing it loads values
 * correctly by using JPQL queries.
 *
 * @author Bernardo Martínez Garrido
 */
@ContextConfiguration(locations = { TestContextConfig.DEFAULT,
        PersistenceContextConfig.HIBERNATE })
@TestPropertySource(
        locations = { TestPropertiesConfig.ENUMERATION,
                PersistenceProviderPropertiesConfig.HIBERNATE,
                DataBaseUserPropertiesConfig.DEFAULT,
                DataBaseScriptsPropertiesConfig.MSSQL, JpaPropertiesConfig.H2,
                JdbcPropertiesPaths.H2, HibernateDialectPropertiesConfig.H2,
                QueryPropertiesPaths.ENUMERATION },
        properties = { "jpa.persistenceUnitName=enumeration_hibernate_h2",
                "jdbc.url=jdbc:h2:mem:test_hibernate;DB_CLOSE_ON_EXIT=FALSE" })
public final class ITEnumerationEntityQueryJpqlEclipseLinkH2
        extends AbstractITEnumerationEntityQueryJpql {

    /**
     * Default constructor.
     */
    public ITEnumerationEntityQueryJpqlEclipseLinkH2() {
        super();
    }

}
