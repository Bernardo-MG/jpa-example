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

package com.wandrell.example.jpa.test.integration.embedded.collection;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Value;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.example.jpa.model.embedded.EmbeddableData;
import com.wandrell.example.jpa.test.util.test.integration.AbstractIntegrationTest;

/**
 * Integration tests for a {@code ElementCollectionEntity} testing it loads
 * values correctly by using JPQL queries.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class ITElementCollectionEntityQueryJpql
        extends AbstractIntegrationTest {

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
        final EmbeddableData data; // Value to find
        final Integer count;       // Number of entities expected
        final Query query;         // Query for the entity

        // Queried value
        data = new EmbeddableData();
        data.setName("name_2");
        data.setDescription("desc_2");

        // Expected result
        count = 4;

        // Builds the query
        query = getEntityManager().createQuery(findContained);
        query.setParameter("name", data.getName());
        query.setParameter("description", data.getDescription());

        // The entity's id is the correct one
        Assert.assertEquals((Integer) query.getResultList().size(), count);
    }

}
