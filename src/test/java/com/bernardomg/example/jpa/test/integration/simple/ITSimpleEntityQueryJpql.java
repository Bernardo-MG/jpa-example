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

package com.bernardomg.example.jpa.test.integration.simple;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import com.bernardomg.example.jpa.model.simple.DefaultSimpleEntity;
import com.bernardomg.example.jpa.model.simple.SimpleEntity;
import com.bernardomg.example.jpa.test.config.test.integration.AbstractITEntityQuery;

/**
 * Integration tests for a {@code SimpleEntity} testing it can be queried
 * correctly by using JPQL queries.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
public class ITSimpleEntityQueryJpql
        extends AbstractITEntityQuery<DefaultSimpleEntity> {

    /**
     * The query to acquire all the entities.
     */
    @Value("${query.findAll}")
    private String findAll;

    /**
     * The query to acquire an entity by the id.
     */
    @Value("${query.findById}")
    private String findById;

    /**
     * Default constructor.
     */
    public ITSimpleEntityQueryJpql() {
        super();
    }

    /**
     * Tests that retrieving all the entities gives the correct number of them.
     */
    @Test
    public final void testFindAll() {
        final Integer count; // Number of entities expected

        // Expected result
        count = 30;

        assertResultSizeEquals(count, getAllQuery());
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
        query = getEntityManager().createQuery(findById);
        query.setParameter("id", id);

        // Acquires the entity
        entity = (SimpleEntity) query.getSingleResult();

        // The id is correct
        Assertions.assertEquals(id, entity.getId());
    }

    /**
     * Tests that retrieving a not existing entity throws an exception.
     */
    @Test
    public final void testFindById_NotExisting_Null() {
        final Integer id;  // Invalid entity ID
        final Query query; // Query for the entity

        // Invalid entity id
        id = 100;

        // Builds the query
        query = getEntityManager().createQuery(findById);
        query.setParameter("id", id);

        // Tries to acquire the entity
        Assertions.assertThrows(NoResultException.class, () -> {
            query.getSingleResult();
        });
    }

    /**
     * Returns the query for the test.
     * 
     * @return the query for the test
     */
    private final Query getAllQuery() {
        return getEntityManager().createQuery(findAll);
    }

}
