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

package com.wandrell.example.jpa.test.util.test.integration;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.function.Supplier;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import com.wandrell.example.jpa.model.simple.SimpleEntity;
import com.wandrell.example.jpa.test.util.criteria.GenericCriteriaFactory;

/**
 * Abstract integration tests verifying that entities can be modified.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 * @see SimpleEntity
 * 
 * @param <V>
 *            type of the entity
 */
public abstract class AbstractITEntityModify<V>
        extends AbstractIntegrationTest {

    /**
     * Class of the tested entity.
     * <p>
     * Used for creating new instances.
     */
    private final Class<V>    entityClass;

    /**
     * Supplier for generating new instances of the entity.
     */
    private final Supplier<V> entitySupplier;

    /**
     * Initial number of entities in the persistence context.
     */
    private final Integer     initialEntitiesCount;

    /**
     * Default constructor.
     * 
     * @param supplier
     *            supplier for the entity being tested
     * @param entities
     *            expected number of entities
     */
    @SuppressWarnings("unchecked")
    public AbstractITEntityModify(final Supplier<V> supplier,
            final Integer entities) {
        super();

        entitySupplier = checkNotNull(supplier,
                "Received a null pointer as entity supplier");
        initialEntitiesCount = checkNotNull(entities,
                "Received a null pointer as entities count");

        entityClass = (Class<V>) entitySupplier.get().getClass();
    }

    /**
     * Tests that persisting an entity adds that entity to the persistence
     * context.
     */
    @Test
    @Transactional
    public final void testCreate_Persisted() {
        final V newEntity; // New entity

        newEntity = getNewEntity();

        // Sets up the entity
        modifyEntity(newEntity);

        // Persists the entity
        getEntityManager().persist(newEntity);
        // Flushed to force updating ids
        getEntityManager().flush();

        // Checks the entity has been added
        Assertions.assertEquals(getEntitiesCount(),
                new Integer(getInitialEntitiesCount() + 1));
    }

    /**
     * Tests that updating an entity changes it.
     */
    @Test
    public final void testUpdate_Persisted() {
        final V entity;   // Original entity
        final V modified; // Updated entity
        final Object id;  // Id of the entity to update

        id = getId();

        // Acquires the entity
        entity = findById(id);

        // Changes the entity
        modifyEntity(entity);
        getEntityManager().persist(entity);

        // Retrieves the entity again
        modified = findById(id);

        // Checks that the entity has been saved correctly
        assertEntityModified(modified);
    }

    /**
     * Returns the entity matching the received id.
     * 
     * @param id
     *            id to search for
     * @return the entity matching the received id
     */
    @SuppressWarnings("unchecked")
    private final V findById(final Object id) {
        final Query query; // Query for the entity

        // Builds the query
        query = getEntityManager().createQuery(getCriteriaQuery(id));

        // Acquires the entity
        return (V) query.getSingleResult();
    }

    /**
     * Returns the number of entities in the database.
     * 
     * @return the number of entities in the database
     */
    private final Integer getEntitiesCount() {
        return getEntityManager().createQuery(GenericCriteriaFactory
                .findAll(getEntityManager(), getEntityClass())).getResultList()
                .size();
    }

    /**
     * Returns the entity class.
     * 
     * @return the entity class
     */
    private final Class<V> getEntityClass() {
        return entityClass;
    }

    /**
     * Returns the initial number of entities in the persistence context.
     * 
     * @return the initial number of entities
     */
    private final Integer getInitialEntitiesCount() {
        return initialEntitiesCount;
    }

    /**
     * Creates a new entity from the entity class.
     * 
     * @return a new entity
     */
    private final V getNewEntity() {
        return getSupplier().get();
    }

    /**
     * Returns the entity supplier.
     * 
     * @return the entity supplier
     */
    private final Supplier<V> getSupplier() {
        return entitySupplier;
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
     * Returns the query for finding an entity by its id.
     * 
     * @param id
     *            id to search
     * @return query for the entity matching the received id
     */
    protected CriteriaQuery<V> getCriteriaQuery(final Object id) {
        return GenericCriteriaFactory.findById(getEntityManager(),
                getEntityClass(), id);
    }

    /**
     * Returns the id used to find the entity to update.
     * 
     * @return the id used to find the entity to update
     */
    protected Object getId() {
        return new Integer(1);
    }

    /**
     * Modifies the received entity.
     *
     * @param entity
     *            the entity to modify
     */
    protected abstract void modifyEntity(final V entity);

}
