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

package com.wandrell.example.jpa.test.util.test.integration.converter;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.example.jpa.model.converter.BooleanConverterEntity;

/**
 * Abstract integration tests for a {@link BooleanConverterEntity} testing it
 * loads values correctly.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>A value equivalent to {@code true} is loaded correctly.</li>
 * <li>A value equivalent to {@code false} is loaded correctly.</li>
 * <li>A random value is loaded as {@code false}.</li>
 * </ol>
 * <p>
 * This is meant to be used along a Spring context, which will set up the
 * repository and all of it's requirements.
 *
 * @author Bernardo Martínez Garrido
 * @see BooleanConverterEntity
 */
public abstract class AbstractITBooleanConverterEntityQueryJpql
        extends AbstractTransactionalTestNGSpringContextTests {

    /**
     * The JPA entity manager.
     */
    @Autowired
    private EntityManager entityManager;

    /**
     * The query to acquire all the entities.
     */
    @Value("${query.findAll}")
    private String        findAll;

    /**
     * The query to acquire an entity by the id.
     */
    @Value("${query.byId}")
    private String        findById;

    /**
     * Default constructor.
     */
    public AbstractITBooleanConverterEntityQueryJpql() {
        super();
    }

    /**
     * Tests that a value equivalent to {@code false} is loaded correctly.
     */
    @Test
    public final void testGetEntity_FlagFalse() {
        final Integer id;                    // Entity ID
        final BooleanConverterEntity entity; // Tested entity
        final Query query;                   // Query for the entity

        // Entity's id
        id = 2;

        // Builds the query
        query = getEntityManager().createQuery(findById);
        query.setParameter("id", id);

        // Acquires the entity
        entity = (BooleanConverterEntity) query.getSingleResult();

        // The entity's id is the correct one
        Assert.assertEquals(entity.getId(), id);

        // The entity's flag is the expected
        Assert.assertEquals(entity.getFlag(), Boolean.FALSE);
    }

    /**
     * Tests that a random value is loaded as {@code false}.
     */
    @Test
    public final void testGetEntity_FlagOther() {
        final Integer id;                    // Entity ID
        final BooleanConverterEntity entity; // Tested entity
        final Query query;                   // Query for the entity

        // Entity's id
        id = 3;

        // Builds the query
        query = getEntityManager().createQuery(findById);
        query.setParameter("id", id);

        // Acquires the entity
        entity = (BooleanConverterEntity) query.getSingleResult();

        // The entity's id is the correct one
        Assert.assertEquals(entity.getId(), id);

        // The entity's flag is the expected
        Assert.assertEquals(entity.getFlag(), Boolean.FALSE);
    }

    /**
     * Tests that a value equivalent to {@code true} is loaded correctly.
     */
    @Test
    public final void testGetEntity_FlagTrue() {
        final Integer id;                    // Entity ID
        final BooleanConverterEntity entity; // Tested entity
        final Query query;                   // Query for the entity

        // Entity's id
        id = 1;

        // Builds the query
        query = getEntityManager().createQuery(findById);
        query.setParameter("id", id);

        // Acquires the entity
        entity = (BooleanConverterEntity) query.getSingleResult();

        // The entity's id is the correct one
        Assert.assertEquals(entity.getId(), id);

        // The entity's flag is the expected
        Assert.assertEquals(entity.getFlag(), Boolean.TRUE);
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
