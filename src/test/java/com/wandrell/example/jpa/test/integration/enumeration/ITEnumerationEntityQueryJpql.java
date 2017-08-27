/**
 * The MIT License (MIT)
 * <p>
 * Copyright (c) 2016-2017 the the original author or authors.
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

package com.wandrell.example.jpa.test.integration.enumeration;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Value;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.example.jpa.model.enumeration.NumbersEnum;
import com.wandrell.example.jpa.test.util.test.integration.AbstractIntegrationTest;

/**
 * Integration tests for a {@code EnumerationEntity} testing it loads values
 * correctly by using JPQL queries.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class ITEnumerationEntityQueryJpql
        extends AbstractIntegrationTest {

    /**
     * The query to acquire all the entities by the ordinal value.
     */
    @Value("${query.findAllByEnumOrdinal}")
    private String findAllByOrdinal;

    /**
     * The query to acquire all the entities by the string value.
     */
    @Value("${query.findAllByEnumString}")
    private String findAllByString;

    /**
     * Default constructor.
     */
    public ITEnumerationEntityQueryJpql() {
        super();
    }

    /**
     * Tests that retrieving all the entities with a specific enum, through the
     * ordinal value, gives the correct number of them.
     */
    @Test
    public final void testGetEntity_Ordinal() {
        final Query query; // Query for the entity

        // Builds the query
        query = getEntityManager().createQuery(findAllByOrdinal);
        query.setParameter("enum", NumbersEnum.TWO);

        // Reads the expected number of entities
        Assert.assertEquals(query.getResultList().size(), 2);
    }

    /**
     * Tests that retrieving all the entities with a specific enum, through the
     * string value, gives the correct number of them.
     */
    @Test
    public final void testGetEntity_String() {
        final Query query; // Query for the entity

        // Builds the query
        query = getEntityManager().createQuery(findAllByString);
        query.setParameter("enum", NumbersEnum.TWO);

        // Reads the expected number of entities
        Assert.assertEquals(query.getResultList().size(), 2);
    }

}
