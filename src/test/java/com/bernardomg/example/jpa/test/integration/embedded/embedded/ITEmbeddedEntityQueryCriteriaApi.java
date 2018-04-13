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

package com.bernardomg.example.jpa.test.integration.embedded.embedded;

import javax.persistence.Query;

import org.junit.jupiter.api.Test;

import com.bernardomg.example.jpa.model.embedded.EmbeddedEntity;
import com.bernardomg.example.jpa.test.util.criteria.embedded.EmbeddedEntityCriteriaFactory;
import com.bernardomg.example.jpa.test.util.test.integration.AbstractITEntityQuery;

/**
 * Integration tests for a {@code EmbeddedEntity} testing it loads values
 * correctly by using the criteria API.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
public class ITEmbeddedEntityQueryCriteriaApi
        extends AbstractITEntityQuery<EmbeddedEntity> {

    /**
     * Default constructor.
     */
    public ITEmbeddedEntityQueryCriteriaApi() {
        super();
    }

    /**
     * Tests that retrieving all the entities with a specific values returns the
     * correct number of them.
     */
    @Test
    public final void testFindByName() {
        final Integer count; // Number of entities expected

        // Expected result
        count = 1;

        // Reads the expected number of entities
        assertResultSizeEquals(count, getQuery());
    }

    /**
     * Returns the query for the test.
     * 
     * @return the query for the test
     */
    private final Query getQuery() {
        final String name;   // Value to find

        // Queried value
        name = "embedded_entity_1";

        return getQuery(EmbeddedEntityCriteriaFactory
                .findByName(getEntityManager(), name));
    }

}
