/**
 * The MIT License (MIT)
 * <p>
 * Copyright (c) 2016-2021 the the original author or authors.
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

package com.bernardomg.example.jpa.test.integration.enumeration;

import javax.persistence.Query;

import org.junit.jupiter.api.Test;

import com.bernardomg.example.jpa.model.enumeration.EnumerationEntity;
import com.bernardomg.example.jpa.model.enumeration.NumbersEnum;
import com.bernardomg.example.jpa.test.util.criteria.enumeration.EnumerationEntityCriteriaFactory;
import com.bernardomg.example.jpa.test.util.test.integration.AbstractITEntityQuery;

/**
 * Integration tests for a {@code EnumerationEntity} testing it loads values
 * correctly by using the criteria API.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
public class ITEnumerationEntityQueryCriteriaApi
        extends AbstractITEntityQuery<EnumerationEntity> {

    /**
     * Default constructor.
     */
    public ITEnumerationEntityQueryCriteriaApi() {
        super();
    }

    /**
     * Tests that retrieving all the entities with a specific enum, through the
     * ordinal value, gives the correct number of them.
     */
    @Test
    public final void testGetEntity_Ordinal() {
        final Integer count; // Number of entities expected

        // Expected result
        count = 2;

        // Reads the expected number of entities
        assertResultSizeEquals(count, getOrdinalQuery());
    }

    /**
     * Tests that retrieving all the entities with a specific enum, through the
     * string value, gives the correct number of them.
     */
    @Test
    public final void testGetEntity_String() {
        final Integer count; // Number of entities expected

        // Expected result
        count = 2;

        // Reads the expected number of entities
        assertResultSizeEquals(count, getStringQuery());
    }

    /**
     * Returns the query for the test.
     * 
     * @return the query for the test
     */
    private final Query getOrdinalQuery() {
        final NumbersEnum value; // Value to find

        // Queried value
        value = NumbersEnum.TWO;

        return getQuery(EnumerationEntityCriteriaFactory
                .findAllByOrdinal(getEntityManager(), value));
    }

    /**
     * Returns the query for the test.
     * 
     * @return the query for the test
     */
    private final Query getStringQuery() {
        final NumbersEnum value; // Value to find

        // Queried value
        value = NumbersEnum.TWO;

        return getQuery(EnumerationEntityCriteriaFactory
                .findAllByString(getEntityManager(), value));
    }

}
