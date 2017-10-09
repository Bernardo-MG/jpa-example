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

package com.wandrell.example.jpa.test.integration.collection.map;

import javax.persistence.Query;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import com.wandrell.example.jpa.test.util.test.integration.AbstractIntegrationTest;

/**
 * Integration tests for a {@code CollectionEntity} testing it loads values
 * correctly by using JPQL queries.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class ITMapEntityQueryJpql extends AbstractIntegrationTest {

    /**
     * The query to acquire all the entities.
     */
    @Value("${query.findAllWithValueInMap}")
    private String findAllWithValueInMap;

    /**
     * Default constructor.
     */
    public ITMapEntityQueryJpql() {
        super();
    }

    /**
     * Tests that retrieving all the entities with a specific values returns the
     * correct number of them.
     */
    @Test
    public final void testfindAllWithValueInMap() {
        final Integer value; // Value to find
        final Integer count; // Number of entities expected
        final Query query;   // Query for the entity

        // Queried value
        value = 2;

        // Expected result
        count = 3;

        // Builds the query
        query = getEntityManager().createQuery(findAllWithValueInMap);
        query.setParameter("value", value);

        // Reads the expected number of entities
        Assertions.assertEquals(count, (Integer) query.getResultList().size());
    }

}
