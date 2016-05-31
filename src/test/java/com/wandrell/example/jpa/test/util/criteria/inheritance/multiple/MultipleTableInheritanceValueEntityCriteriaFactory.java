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

package com.wandrell.example.jpa.test.util.criteria.inheritance.multiple;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.wandrell.example.jpa.model.inheritance.multiple.MultipleTableInheritanceRootEntity_;
import com.wandrell.example.jpa.model.inheritance.multiple.MultipleTableInheritanceValueEntity;
import com.wandrell.example.jpa.model.inheritance.multiple.MultipleTableInheritanceValueEntity_;

/**
 * Factory for creating criteria API queries for the
 * {@link MultipleTableInheritanceValueEntity}.
 *
 * @author Bernardo Martínez Garrido
 */
public class MultipleTableInheritanceValueEntityCriteriaFactory {

    /**
     * Generates a query to find all the entities where the value is the equal
     * to the received one.
     *
     * @param entityManager
     *            the entity manager with the entity's data
     * @param value
     *            the value to search for
     * @return the query to find all the entities with a value equal to the
     *         received one
     */
    public static final CriteriaQuery<MultipleTableInheritanceValueEntity>
            findAllWithValue(final EntityManager entityManager,
                    final Integer value) {
        final CriteriaBuilder builder;                // Builder
        final CriteriaQuery<MultipleTableInheritanceValueEntity> query; // Query
        final Root<MultipleTableInheritanceValueEntity> entity;         // Root
                                                                        // entity

        // Prepares the criteria API query
        builder = entityManager.getCriteriaBuilder();
        query = builder.createQuery(MultipleTableInheritanceValueEntity.class);
        entity = query.from(MultipleTableInheritanceValueEntity.class);

        // Generates a select query
        query.select(entity);
        query.where(builder.equal(
                entity.get(MultipleTableInheritanceValueEntity_.value), value));

        // Orders by the id
        query.orderBy(builder
                .asc(entity.get(MultipleTableInheritanceRootEntity_.id)));

        return query;
    }

    /**
     * Private constructor to avoid initialization.
     */
    private MultipleTableInheritanceValueEntityCriteriaFactory() {
        super();
    }

}
