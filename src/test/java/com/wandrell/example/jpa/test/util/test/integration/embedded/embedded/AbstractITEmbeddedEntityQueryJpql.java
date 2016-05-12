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

package com.wandrell.example.jpa.test.util.test.integration.embedded.embedded;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.example.jpa.model.embedded.EmbeddedEntity;

/**
 * Abstract integration tests for a {@link EmbeddedEntity} testing it can be
 * queried correctly by using JPQL queries.
 * <p>
 * The tests cases just show how to do query operations with a JPA entity by
 * using JPQL queries.
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
 * @author Bernardo Martínez Garrido
 * @see EmbeddedEntity
 */
public abstract class AbstractITEmbeddedEntityQueryJpql
        extends AbstractTransactionalTestNGSpringContextTests {

    /**
     * The JPA entity manager.
     */
    @Autowired
    private EntityManager entityManager;

    /**
     * The query to acquire all the entities.
     */
    @Value("${query.findByName}")
    private String        findByName;

    /**
     * Default constructor.
     */
    public AbstractITEmbeddedEntityQueryJpql() {
        super();
    }

    /**
     * Tests that retrieving all the entities with a specific values returns the
     * correct number of them.
     */
    @Test
    public final void testFindByName() {
        final String name;   // Value to find
        final Integer count; // Number of entities expected
        final Query query;   // Query for the entity

        // Queried value
        name = "embedded_entity_1";

        // Expected result
        count = 1;

        // Builds the query
        query = getEntityManager().createQuery(findByName);
        query.setParameter("name", name);

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
