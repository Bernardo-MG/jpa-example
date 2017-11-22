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

package com.bernardomg.example.jpa.test.util.test.integration;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import org.junit.jupiter.api.Assertions;

import com.bernardomg.example.jpa.model.simple.SimpleEntity;

/**
 * Abstract integration tests verifying that entities can be modified.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 * @see SimpleEntity
 * 
 * @param <V>
 *            type of the entity
 */
public abstract class AbstractITEntityQuery<V> extends AbstractIntegrationTest {

    /**
     * Default constructor.
     */
    public AbstractITEntityQuery() {
        super();
    }

    /**
     * Asserts that the result size from the query equals the expected count.
     * 
     * @param expectedCount
     *            expected number of elements
     * @param query
     *            query used to acquire the results
     */
    protected final void assertResultSizeEquals(final Integer expectedCount,
            final Query query) {
        final Integer readCount;

        readCount = query.getResultList().size();

        // Reads the expected number of entities
        Assertions.assertEquals(expectedCount, readCount);
    }

    /**
     * Creates a query from the received criteria query.
     * 
     * @param query
     *            criteria query for the query
     * @return a query
     */
    protected final Query getQuery(final CriteriaQuery<V> query) {
        return getEntityManager().createQuery(query);
    }

    /**
     * Creates a query from the received query string.
     * 
     * @param query
     *            query string for the query
     * @return a query
     */
    protected final Query getQuery(final String query) {
        return getEntityManager().createQuery(query);
    }

}
