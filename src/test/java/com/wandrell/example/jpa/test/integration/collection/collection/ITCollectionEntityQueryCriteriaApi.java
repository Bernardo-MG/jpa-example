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

package com.wandrell.example.jpa.test.integration.collection.collection;

import javax.persistence.criteria.CriteriaQuery;

import com.wandrell.example.jpa.model.collection.CollectionEntity;
import com.wandrell.example.jpa.test.util.criteria.collection.CollectionEntityCriteriaFactory;
import com.wandrell.example.jpa.test.util.test.integration.AbstractITEntityQueryCriteriaApi;

/**
 * Integration tests for a {@code CollectionEntity} testing it loads values
 * correctly by using the criteria API.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class ITCollectionEntityQueryCriteriaApi
        extends AbstractITEntityQueryCriteriaApi<CollectionEntity> {

    /**
     * Default constructor.
     */
    public ITCollectionEntityQueryCriteriaApi() {
        super(3);
    }

    @Override
    protected CriteriaQuery<CollectionEntity> getEntitiesQuery() {
        final Integer value; // Value to find

        // Queried value
        value = 2;

        return CollectionEntityCriteriaFactory
                .findAllWithValue(getEntityManager(), value);
    }

}
