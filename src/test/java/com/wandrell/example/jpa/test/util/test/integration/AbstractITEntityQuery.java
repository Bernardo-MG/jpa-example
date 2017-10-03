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

import javax.persistence.Query;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.example.jpa.model.simple.SimpleEntity;

/**
 * Abstract integration tests verifying that entities can be modified.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 * @see SimpleEntity
 * 
 * @param <V>
 *            type of the entity
 */
public abstract class AbstractITEntityQuery<V> extends AbstractIntegrationTest {

    private final Integer expectedEntitiesCount;

    /**
     * Default constructor.
     * 
     * @param entitiesCount
     *            number of entities returned by the query
     */
    public AbstractITEntityQuery(final Integer entitiesCount) {
        super();

        expectedEntitiesCount = checkNotNull(entitiesCount,
                "Received a null pointer as entities count");
    }

    /**
     * Tests that retrieving all the entities with a specific values returns the
     * correct number of them.
     */
    @Test
    public final void testFindAllWithValue() {
        // Reads the expected number of entities
        Assert.assertEquals(getEntitiesCount(), getExpectedEntitiesCount());
    }

    private final Integer getEntitiesCount() {
        return getQuery().getResultList().size();
    }

    private final Integer getExpectedEntitiesCount() {
        return expectedEntitiesCount;
    }

    protected abstract Query getQuery();

}
