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

package com.wandrell.example.jpa.test.integration.simple;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import com.wandrell.example.jpa.model.simple.SimpleEntity;
import com.wandrell.example.jpa.test.util.criteria.simple.SimpleEntityCriteriaFactory;
import com.wandrell.example.jpa.test.util.test.integration.AbstractIntegrationTest;

/**
 * Integration tests for a {@code SimpleEntity} testing it can be queried
 * correctly by using criteria API queries.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class ITSimpleEntityQueryCriteriaApi
        extends AbstractIntegrationTest {

    /**
     * Initial number of entities in the persistence context.
     */
    private final Integer entitiesCount = 30;

    /**
     * Default constructor.
     */
    public ITSimpleEntityQueryCriteriaApi() {
        super();
        // TODO: Use the new JUnit 5 annotations
    }

    /**
     * Tests that retrieving all the entities gives the correct number of them.
     */
    @Test
    public final void testFindAll() {
        final Integer count;

        count = getEntityManager()
                .createQuery(
                        SimpleEntityCriteriaFactory.findAll(getEntityManager()))
                .getResultList().size();
        Assertions.assertEquals(count, entitiesCount);
    }

    /**
     * Tests that retrieving an existing entity returns it.
     */
    @Test
    public final void testFindById_Existing_Entity() {
        final Integer id;          // Entity ID
        final SimpleEntity entity; // Tested entity
        final Query query;         // Query for the entity

        // Entity's id
        id = 1;

        // Builds the query
        query = getEntityManager().createQuery(
                SimpleEntityCriteriaFactory.findById(getEntityManager(), id));

        // Acquires the entity
        entity = (SimpleEntity) query.getSingleResult();

        // The id is correct
        Assertions.assertEquals(id, entity.getId());
    }

    /**
     * Tests that retrieving a not existing entity throws an exception.
     */
    @Test(expected = NoResultException.class)
    public final void testFindById_NotExisting_Null() {
        final Integer id;          // Invalid entity ID
        final SimpleEntity entity; // Tested entity
        final Query query;         // Query for the entity

        // Invalid entity id
        id = entitiesCount + 100;

        // Builds the query
        query = getEntityManager().createQuery(
                SimpleEntityCriteriaFactory.findById(getEntityManager(), id));

        // Tries to acquire the entity
        entity = (SimpleEntity) query.getSingleResult();

        // The entity is null
        Assertions.assertNull(entity);
    }

}
