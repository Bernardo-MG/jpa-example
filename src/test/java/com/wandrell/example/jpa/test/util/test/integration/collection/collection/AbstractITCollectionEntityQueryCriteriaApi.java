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

package com.wandrell.example.jpa.test.util.test.integration.collection.collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.example.jpa.model.collection.CollectionEntity;
import com.wandrell.example.jpa.test.util.criteria.collection.CollectionEntityCriteriaFactory;

/**
 * Abstract integration tests for a {@link CollectionEntity} testing it can be
 * queried correctly by using criteria API queries.
 * <p>
 * The tests cases just show how to do query operations with a JPA entity by
 * using the criteria API.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>Retrieving all the entities with a specific values returns the correct
 * number of them.</li>
 * </ol>
 * <p>
 * This is meant to be used along a Spring context, which will set up the
 * repository and all of it's requirements.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 * @see CollectionEntity
 */
public abstract class AbstractITCollectionEntityQueryCriteriaApi
        extends AbstractTransactionalTestNGSpringContextTests {

    /**
     * Initial number of entities in the persistence context.
     */
    @Value("${entities.total}")
    private Integer       entitiesCount;

    /**
     * The JPA entity manager.
     */
    @Autowired
    private EntityManager entityManager;

    /**
     * Default constructor.
     */
    public AbstractITCollectionEntityQueryCriteriaApi() {
        super();
    }

    /**
     * Tests that retrieving all the entities with a specific values returns the
     * correct number of them.
     */
    @Test
    public final void testFindAllWithValue() {
        final Integer value; // Value to find
        final Integer count; // Number of entities expected
        final Query query;   // Query for the entity

        // Queried value
        value = 2;

        // Expected result
        count = 3;

        // Builds the query
        query = getEntityManager().createQuery(CollectionEntityCriteriaFactory
                .findAllWithValue(getEntityManager(), value));

        // The entity's id is the correct one
        Assert.assertEquals((Integer) query.getResultList().size(), count);
    }

    /**
     * Returns the JPA entity manager.
     *
     * @return the JPA entity manager
     */
    protected final EntityManager getEntityManager() {
        return entityManager;
    }

}
