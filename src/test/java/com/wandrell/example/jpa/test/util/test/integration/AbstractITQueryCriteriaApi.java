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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.example.jpa.model.simple.DefaultSimpleEntity;
import com.wandrell.example.jpa.model.simple.DefaultSimpleEntity_;
import com.wandrell.example.jpa.model.simple.SimpleEntity;

/**
 * Abstract integration tests for a {@link SimpleEntity} testing it can be
 * queried correctly by using criteria API queries.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>Retrieving all the entities gives the correct number of them.</li>
 * <li>Retrieving an existing entity returns it.</li>
 * <li>Retrieving a not existing entity throws an exception.</li>
 * </ol>
 * <p>
 * This is meant to be used along a Spring context, which will set up the
 * repository and all of it's requirements.
 *
 * @author Bernardo Martínez Garrido
 * @see SimpleEntity
 */
public abstract class AbstractITQueryCriteriaApi
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
    public AbstractITQueryCriteriaApi() {
        super();
    }

    /**
     * Tests that retrieving all the entities gives the correct number of them.
     */
    @Test
    public final void testGetAll() {
        Assert.assertEquals((Integer) getEntityManager()
                .createQuery(getFindAll()).getResultList().size(),
                entitiesCount);
    }

    /**
     * Tests that retrieving an existing entity returns it.
     */
    @Test
    public final void testGetEntity_Existing_Entity() {
        final Integer id;          // Entity ID
        final SimpleEntity entity; // Tested entity
        final Query query;         // Query for the entity

        // Entity's id
        id = 1;

        // Builds the query
        query = getEntityManager().createQuery(getFindById(id));

        // Acquires the entity
        entity = (SimpleEntity) query.getSingleResult();

        // The entity's id is the correct one
        Assert.assertEquals(entity.getId(), id);
    }

    /**
     * Tests that retrieving a not existing entity throws an exception.
     */
    @Test(expectedExceptions = { NoResultException.class })
    public final void testGetEntity_NotExisting_Null() {
        final Integer id;          // Invalid entity ID
        final SimpleEntity entity; // Tested entity
        final Query query;         // Query for the entity

        // Invalid entity id
        id = 123;

        // Builds the query
        query = getEntityManager().createQuery(getFindById(id));

        // Tries to acquire the entity
        entity = (SimpleEntity) query.getSingleResult();

        // The entity is null
        Assert.assertEquals(entity, null);
    }

    /**
     * Generates the query to find all the entities by using the Criteria API.
     *
     * @return the query to find all the entities
     */
    private final CriteriaQuery<DefaultSimpleEntity> getFindAll() {
        final CriteriaBuilder builder;                  // Builder
        final CriteriaQuery<DefaultSimpleEntity> query; // Query
        Root<DefaultSimpleEntity> entity;               // Root entity

        builder = getEntityManager().getCriteriaBuilder();
        query = builder.createQuery(DefaultSimpleEntity.class);
        entity = query.from(DefaultSimpleEntity.class);

        // Generates a select query
        query.select(entity);

        // Orders by the id
        query.orderBy(builder.asc(entity.get(DefaultSimpleEntity_.id)));

        return query;
    }

    /**
     * Generates the query to find an the entity by the id by using the Criteria
     * API.
     *
     * @return the query to find an the entity by the id
     */
    private final CriteriaQuery<DefaultSimpleEntity>
            getFindById(final Integer id) {
        final CriteriaBuilder builder;                  // Builder
        final CriteriaQuery<DefaultSimpleEntity> query; // Query
        Root<DefaultSimpleEntity> entity;               // Root entity

        builder = getEntityManager().getCriteriaBuilder();
        query = builder.createQuery(DefaultSimpleEntity.class);
        entity = query.from(DefaultSimpleEntity.class);

        // Generates a select query
        query.select(entity);

        // Queries the entities with the specified id
        query.where(builder.equal(entity.get(DefaultSimpleEntity_.id), id));

        // Orders by the id
        query.orderBy(builder.asc(entity.get(DefaultSimpleEntity_.id)));

        return query;
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
