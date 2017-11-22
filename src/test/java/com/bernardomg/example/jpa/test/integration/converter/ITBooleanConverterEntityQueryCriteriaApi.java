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

package com.bernardomg.example.jpa.test.integration.converter;

import javax.persistence.Query;

import org.junit.jupiter.api.Test;

import com.bernardomg.example.jpa.model.converter.BooleanConverterEntity;
import com.bernardomg.example.jpa.test.util.criteria.converter.BooleanConverterEntityCriteriaFactory;
import com.bernardomg.example.jpa.test.util.test.integration.AbstractITEntityQuery;

/**
 * Integration tests for a {@code BooleanConverterEntity} testing it loads
 * values correctly by using the criteria API.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class ITBooleanConverterEntityQueryCriteriaApi
        extends AbstractITEntityQuery<BooleanConverterEntity> {

    /**
     * Default constructor.
     */
    public ITBooleanConverterEntityQueryCriteriaApi() {
        super();
    }

    /**
     * Tests that retrieving all the entities with a {@code false} flag gives
     * the correct number of them.
     */
    @Test
    public final void testGetEntity_AllFalse() {
        final Integer count; // Number of entities expected

        // Expected result
        count = 2;

        assertResultSizeEquals(count, getAllFalseQuery());
    }

    /**
     * Tests that retrieving all the entities with a {@code true} flag gives the
     * correct number of them.
     */
    @Test
    public final void testGetEntity_AllTrue() {
        final Integer count; // Number of entities expected

        // Expected result
        count = 3;

        assertResultSizeEquals(count, getAllTrueQuery());
    }

    /**
     * Returns the query for the test.
     * 
     * @return the query for the test
     */
    private final Query getAllFalseQuery() {
        final Boolean value; // Value to find

        // Queried value
        value = false;

        return getQuery(BooleanConverterEntityCriteriaFactory
                .findAllByFlag(getEntityManager(), value));
    }

    /**
     * Returns the query for the test.
     * 
     * @return the query for the test
     */
    private final Query getAllTrueQuery() {
        final Boolean value; // Value to find

        // Queried value
        value = true;

        return getQuery(BooleanConverterEntityCriteriaFactory
                .findAllByFlag(getEntityManager(), value));
    }

}
