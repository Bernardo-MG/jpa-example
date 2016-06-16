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

package com.wandrell.example.jpa.test.util.test.integration.table;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.example.jpa.model.table.SecondaryTableEntity;
import com.wandrell.example.jpa.test.util.criteria.table.SecondaryTableEntityCriteriaFactory;

/**
 * Abstract integration tests for a {@link SecondaryTableEntity} testing it
 * loads values correctly by using the criteria API.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>Retrieving an entity by the secondary table value returns the expected
 * entity.</li>
 * </ol>
 * <p>
 * This is meant to be used along a Spring context, which will set up the
 * repository and all of it's requirements.
 *
 * @author Bernardo Martínez Garrido
 * @see SecondaryTableEntity
 */
public abstract class AbstractITSecondaryTableEntityQueryCriteriaApi
        extends AbstractTransactionalTestNGSpringContextTests {

    /**
     * The JPA entity manager.
     */
    @Autowired
    private EntityManager entityManager;

    /**
     * Default constructor.
     */
    public AbstractITSecondaryTableEntityQueryCriteriaApi() {
        super();
        // TODO: Add the query results counts to the configuration files
    }

    /**
     * Tests that retrieving an entity by the secondary table value returns the
     * expected entity.
     */
    @Test
    public final void testFindBySecondaryValue() {
        final Query query;                 // Query for the entity
        final SecondaryTableEntity entity; // Tested entity

        // Builds the query
        query = getEntityManager()
                .createQuery(SecondaryTableEntityCriteriaFactory
                        .findBySecondaryValue(entityManager, "value_b_2"));

        // Acquires the entity
        entity = (SecondaryTableEntity) query.getSingleResult();

        // The entity's id is the correct one
        Assert.assertEquals(entity.getId(), new Integer(2));
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