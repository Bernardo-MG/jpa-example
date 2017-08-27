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

package com.wandrell.example.jpa.test.util.criteria.table;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.wandrell.example.jpa.model.table.SecondaryTableEntity;
import com.wandrell.example.jpa.model.table.SecondaryTableEntity_;

/**
 * Factory for creating criteria API queries for the
 * {@code SecondaryTableEntity}.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
public class SecondaryTableEntityCriteriaFactory {

    /**
     * Generates a query to find all the entities where the value of the flag is
     * the same as the received one.
     *
     * @param entityManager
     *            the entity manager with the entity's data
     * @param value
     *            the value to search for
     * @return the query to find all the entities with a flag having the
     *         received value
     */
    public static final CriteriaQuery<SecondaryTableEntity>
            findBySecondaryValue(final EntityManager entityManager,
                    final String value) {
        final CriteriaBuilder builder;                   // Builder
        final CriteriaQuery<SecondaryTableEntity> query; // Query
        final Root<SecondaryTableEntity> entity;         // Root entity

        // Prepares the criteria API query
        builder = entityManager.getCriteriaBuilder();
        query = builder.createQuery(SecondaryTableEntity.class);
        entity = query.from(SecondaryTableEntity.class);

        // Generates a select query
        query.select(entity);
        query.where(
                builder.equal(entity.get(SecondaryTableEntity_.field2), value));

        // Orders by the id
        query.orderBy(builder.asc(entity.get(SecondaryTableEntity_.id)));

        return query;
    }

    /**
     * Private constructor to avoid initialization.
     */
    private SecondaryTableEntityCriteriaFactory() {
        super();
    }

}
