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

package com.wandrell.example.jpa.test.util.test.integration;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.example.jpa.model.simple.SimpleEntity;

/**
 * Abstract integration tests for an entity testing it can be modified.
 * <p>
 * The tests cases just show how to do create, remove and update operations with
 * a JPA entity.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>Persisting an entity adds that entity to the persistence context.</li>
 * <li>Removing an entity removes that entity from the persistence context.</li>
 * <li>Updating an entity changes it.</li>
 * </ol>
 * <p>
 * This is meant to be used along a Spring context, which will set up the
 * repository and all of it's requirements.
 *
 * @author Bernardo Martínez Garrido
 * @see SimpleEntity
 */
public abstract class AbstractITEntityModify<V>
        extends AbstractTransactionalTestNGSpringContextTests {

    /**
     * The entity manager for the test context.
     */
    @Autowired(required = false)
    private EntityManager emanager;

    /**
     * Initial number of entities in the persistence context.
     */
    @Value("${entities.total}")
    private Integer       entitiesCount;

    /**
     * The query to acquire all the entities.
     */
    @Value("${query.findAll}")
    private String        findAll;

    /**
     * The query to acquire an entity by the id.
     */
    @Value("${query.findById}")
    private String        findById;

    /**
     * Entity for the addition test.
     */
    @Autowired
    @Qualifier("newEntity")
    private V             newEntity;

    /**
     * Default constructor.
     */
    public AbstractITEntityModify() {
        super();
    }

    /**
     * Tests that persisting an entity adds that entity to the persistence
     * context.
     */
    @SuppressWarnings("unchecked")
    @Test
    @Transactional
    public final void testCreate() {
        final V queried; // Queried back entity
        final Query query;                    // Query to recover the entity
        final Integer id; // Id of the created entity

        // Sets up the entity
        modifyEntity(newEntity);

        // Adds the entity
        getEntityManager().persist(newEntity);

        if (getEntityManager() != null) {
            // Flushed to force updating ids
            getEntityManager().flush();
        }

        // Checks the entity has been added
        Assert.assertEquals(
                getEntityManager().createQuery(findAll).getResultList().size(),
                entitiesCount + 1);

        // Checks that the entity was created correctly
        id = getId(newEntity);
        Assert.assertNotNull(id);
        Assert.assertTrue(id >= 0);

        // Queries the created entity from the DB

        // Builds the query
        query = getEntityManager().createQuery(findById);
        query.setParameter("id", getId(newEntity));

        // Acquires the entity
        queried = (V) query.getSingleResult();

        // Checks that the queried entity is equal to the persisted one
        Assert.assertEquals(queried, newEntity);
    }

    /**
     * Tests that updating an entity changes it.
     */
    @SuppressWarnings("unchecked")
    @Test
    public final void testUpdate() {
        V entity; // The entity being tested
        final Query query;             // Query for the entity

        // Builds the query
        query = getEntityManager().createQuery(findById);
        query.setParameter("id", 1);

        // Acquires the entity
        entity = (V) query.getSingleResult();

        // Changes the entity name
        modifyEntity(entity);
        getEntityManager().persist(entity);

        // Retrieves the entity again
        entity = (V) query.getSingleResult();

        // Checks that the entity has been saved correctly
        assertEntityModified(entity);
    }

    /**
     * Asserts that the entity has received the expected modifications.
     * <p>
     * If this expectation fails, then an {@code AssertionError} will be thrown.
     *
     * @param entity
     *            the entity to check
     */
    protected abstract void assertEntityModified(final V entity);

    /**
     * Returns the JPA entity manager.
     *
     * @return the JPA entity manager
     */
    protected final EntityManager getEntityManager() {
        return emanager;
    }

    /**
     * Returns the id for the received entity.
     *
     * @param entity
     *            the entity where to get the id from
     * @return the entity's id
     */
    protected abstract Integer getId(final V entity);

    /**
     * Modifies the received entity.
     *
     * @param entity
     *            the entity to modify
     */
    protected abstract void modifyEntity(final V entity);

}
