/**
 * The MIT License (MIT)
 * <p>
 * Copyright (c) 2016-2019 the the original author or authors.
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

package com.bernardomg.example.jpa.test.integration.embedded.collection;

import javax.persistence.Query;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import com.bernardomg.example.jpa.model.embedded.ElementCollectionEntity;
import com.bernardomg.example.jpa.test.util.test.integration.AbstractITEntityQuery;

/**
 * Integration tests for a {@code ElementCollectionEntity} testing it loads
 * values correctly by using JPQL queries.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
public class ITElementCollectionEntityQueryJpql
        extends AbstractITEntityQuery<ElementCollectionEntity> {

    /**
     * The query to acquire all the entities.
     */
    @Value("${query.findContained}")
    private String findContained;

    /**
     * Default constructor.
     */
    public ITElementCollectionEntityQueryJpql() {
        super();
    }

    /**
     * Tests that retrieving all the entities with a specific values returns the
     * correct number of them.
     */
    @Test
    public final void testFindContained() {
        final Integer count; // Number of entities expected

        // Expected result
        count = 4;

        // Reads the expected number of entities
        assertResultSizeEquals(count, getQuery());
    }

    /**
     * Returns the query for the test.
     * 
     * @return the query for the test
     */
    private final Query getQuery() {
        final String name; // Value to find
        final String desc; // Value to find
        final Query query;

        // Queried value
        name = "name_2";
        desc = "desc_2";

        query = getQuery(findContained);
        query.setParameter("name", name);
        query.setParameter("description", desc);

        return query;
    }

}
