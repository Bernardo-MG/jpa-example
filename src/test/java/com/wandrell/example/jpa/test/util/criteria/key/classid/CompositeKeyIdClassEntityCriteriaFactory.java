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

package com.wandrell.example.jpa.test.util.criteria.key.classid;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.wandrell.example.jpa.model.key.classid.CompositeKeyIdClassEntity;
import com.wandrell.example.jpa.model.key.classid.CompositeKeyIdClassEntity_;

/**
 * Factory for creating criteria API queries for the
 * {@link CompositeKeyIdClassEntity}.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
public class CompositeKeyIdClassEntityCriteriaFactory {

    /**
     * Finds all the entities with the specified ids.
     *
     * @param entityManager
     *            the entity manager with the entity's data
     * @param id1
     *            first id
     * @param id2
     *            second id
     * @return all the entities with a time equal to the specified time
     */
    public static final CriteriaQuery<CompositeKeyIdClassEntity> findByIds(
            final EntityManager entityManager, final Integer id1,
            final Integer id2) {
        final CriteriaBuilder builder;         // Builder
        final CriteriaQuery<CompositeKeyIdClassEntity> query; // Query
        final Root<CompositeKeyIdClassEntity> entity;         // Root entity

        // Prepares the criteria API query
        builder = entityManager.getCriteriaBuilder();
        query = builder.createQuery(CompositeKeyIdClassEntity.class);
        entity = query.from(CompositeKeyIdClassEntity.class);

        // Generates a select query
        query.select(entity);
        query.where(builder.and(
                builder.equal(entity.get(CompositeKeyIdClassEntity_.id), id1),
                builder.equal(entity.get(CompositeKeyIdClassEntity_.supportId),
                        id2)));

        // Orders by the id
        query.orderBy(builder.asc(entity.get(CompositeKeyIdClassEntity_.id)));

        return query;
    }

    /**
     * Private constructor to avoid initialization.
     */
    private CompositeKeyIdClassEntityCriteriaFactory() {
        super();
    }

}
