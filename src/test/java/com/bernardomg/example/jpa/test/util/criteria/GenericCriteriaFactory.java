/**
 * The MIT License (MIT)
 * <p>
 * Copyright (c) 2016-2019 the the original author or authors.
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

package com.bernardomg.example.jpa.test.util.criteria;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Factory for creating criteria API queries for the tests.
 * <p>
 * These queries are generic, meant to work for any entity.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class GenericCriteriaFactory {

    /**
     * Generates a query to find all the entities.
     *
     * @param entityManager
     *            the entity manager with the entity's data
     * @param entityClass
     *            the class of the the entity for which the query is generated
     * @return the query to find all the entities
     */
    public static final <V> CriteriaQuery<V> findAll(
            final EntityManager entityManager, final Class<V> entityClass) {
        final CriteriaBuilder builder; // Builder
        final CriteriaQuery<V> query;  // Query
        final Root<V> entity;          // Root entity

        // Prepares the criteria API query
        builder = entityManager.getCriteriaBuilder();
        query = builder.createQuery(entityClass);
        entity = query.from(entityClass);

        // Generates a select query
        query.select(entity);

        return query;
    }

    /**
     * Generates the query to find a single entity by the id.
     *
     * @param entityManager
     *            the entity manager with the entity's data
     * @param entityClass
     *            the class of the the entity for which the query is generated
     * @param id
     *            the id to search
     * @return the query to find an the entity by the id
     */
    public static final <V> CriteriaQuery<V> findById(
            final EntityManager entityManager, final Class<V> entityClass,
            final Object id) {
        final CriteriaBuilder builder; // Builder
        final CriteriaQuery<V> query;  // Query
        final Root<V> entity;          // Root entity

        // Prepares the criteria API query
        builder = entityManager.getCriteriaBuilder();
        query = builder.createQuery(entityClass);
        entity = query.from(entityClass);

        // Generates a select query
        query.select(entity);

        // Queries the entities with the specified id
        query.where(builder.equal(entity.get("id"), id));

        return query;
    }

    /**
     * Private constructor to avoid initialization.
     */
    private GenericCriteriaFactory() {
        super();
    }

}
