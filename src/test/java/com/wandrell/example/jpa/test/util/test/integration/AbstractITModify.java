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
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.example.jpa.model.simple.DefaultSimpleEntity;
import com.wandrell.example.jpa.model.simple.SimpleEntity;

/**
 * Abstract integration tests for a {@link SimpleEntity} testing it can be
 * modified.
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
public abstract class AbstractITModify
        extends AbstractTransactionalTestNGSpringContextTests {

    /**
     * The entity manager for the test context.
     */
    @Autowired(required = false)
    private EntityManager       emanager;

    /**
     * Initial number of entities in the persistence context.
     */
    @Value("${entities.total}")
    private Integer             entitiesCount;

    /**
     * The JPA entity manager.
     */
    @Autowired
    private EntityManager       entityManager;

    /**
     * The query to acquire all the entities.
     */
    @Value("${query.findAll}")
    private String              findAll;

    /**
     * The query to acquire an entity by the id.
     */
    @Value("${query.byId}")
    private String              findById;

    /**
     * Entity for the addition test.
     */
    @Autowired
    @Qualifier("newEntity")
    private DefaultSimpleEntity newEntity;

    /**
     * Default constructor.
     */
    public AbstractITModify() {
        super();
    }

    /**
     * Tests that persisting an entity adds that entity to the persistence
     * context.
     */
    @Test
    @Transactional
    public final void testAdd() {
        // Checks that the id has not been assigned
        Assert.assertNull(newEntity.getId());

        // Sets the name
        newEntity.setName("name");

        // Adds the entity
        getEntityManager().persist(newEntity);

        if (emanager != null) {
            // Flushed to force updating ids
            emanager.flush();
        }

        // Checks the entity has been added
        Assert.assertEquals(
                getEntityManager().createQuery(findAll).getResultList().size(),
                entitiesCount + 1);

        // Checks that the id has been assigned
        Assert.assertNotNull(newEntity.getId());
        Assert.assertTrue(newEntity.getId() >= 0);
    }

    /**
     * Tests that removing an entity removes that entity from the persistence
     * context.
     */
    @Test
    @Transactional
    public final void testRemove() {
        final DefaultSimpleEntity entity; // Entity being tested
        final Query query;                // Query for the entity
        Boolean caught;                   // Flag for the exception being caught

        // Builds the query
        query = getEntityManager().createQuery(findById);
        query.setParameter("id", 1);

        // Acquires the entity
        entity = (DefaultSimpleEntity) query.getSingleResult();

        // Removes the entity
        getEntityManager().remove(entity);

        // Checks that the number of entities has decreased
        Assert.assertEquals(
                getEntityManager().createQuery(findAll).getResultList().size(),
                entitiesCount - 1);

        // Tries to retrieve the removed entity
        // The entity no longer exists
        caught = false;
        try {
            query.getSingleResult();
        } catch (final NoResultException e) {
            caught = true;
        }
        Assert.assertTrue(caught);
    }

    /**
     * Tests that updating an entity changes it.
     */
    @Test
    public final void testUpdate() {
        final String nameChange;    // Name set on the entity
        DefaultSimpleEntity entity; // The entity being tested
        final Query query;          // Query for the entity

        // Builds the query
        query = getEntityManager().createQuery(findById);
        query.setParameter("id", 1);

        // Acquires the entity
        entity = (DefaultSimpleEntity) query.getSingleResult();

        // Changes the entity name
        nameChange = "The new name";
        entity.setName(nameChange);
        getEntityManager().persist(entity);

        // Retrieves the entity again
        entity = (DefaultSimpleEntity) query.getSingleResult();

        // Checks the entity's name
        Assert.assertEquals(entity.getName(), nameChange);
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
