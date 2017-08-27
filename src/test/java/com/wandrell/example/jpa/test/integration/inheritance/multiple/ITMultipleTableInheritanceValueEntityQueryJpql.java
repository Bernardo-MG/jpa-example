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

package com.wandrell.example.jpa.test.integration.inheritance.multiple;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Value;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.example.jpa.test.util.test.integration.AbstractIntegrationTest;

/**
 * Integration tests for a {@code MultipleTableInheritanceValueEntity} testing
 * it loads values correctly by using JPQL queries.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class ITMultipleTableInheritanceValueEntityQueryJpql
        extends AbstractIntegrationTest {

    /**
     * The query to acquire all the entities by the ordinal value.
     */
    @Value("${query.multipleTable.findAllWithValue}")
    private String findAllWithValue;

    /**
     * Default constructor.
     */
    public ITMultipleTableInheritanceValueEntityQueryJpql() {
        super();
    }

    /**
     * Tests that retrieving all the entities with a specific enum, through the
     * ordinal value, gives the correct number of them.
     */
    @Test
    public final void testFindAllWithValue() {
        final Query query; // Query for the entity

        // Builds the query
        query = getEntityManager().createQuery(findAllWithValue);
        query.setParameter("value", 11);

        // The number of results is the expected one
        Assert.assertEquals(query.getResultList().size(), 1);
    }

}
