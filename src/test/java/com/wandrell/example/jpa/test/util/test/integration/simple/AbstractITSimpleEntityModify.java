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

package com.wandrell.example.jpa.test.util.test.integration.simple;

import org.testng.Assert;

import com.wandrell.example.jpa.model.simple.SimpleEntity;
import com.wandrell.example.jpa.test.util.test.integration.AbstractITEntityModify;

/**
 * Abstract integration tests for a {@link SimpleEntity} testing it can be
 * modified.
 * <p>
 * The tests cases just show how to do create, remove and update operations with
 * a JPA entity.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>Persisting an entity adds that entity to the persistence context.</li>
 * <li>Removing an entity removes that entity from the persistence context.</li>
 * <li>Updating an entity changes it.</li>
 * </ol>
 * <p>
 * This is meant to be used along a Spring context, which will set up the
 * repository and all of it's requirements.
 *
 * @author Bernardo Martínez Garrido
 * @see SimpleEntity
 */
public abstract class AbstractITSimpleEntityModify
        extends AbstractITEntityModify<SimpleEntity> {

    /**
     * Name for the tests.
     */
    private final String name = "The new name";

    /**
     * Default constructor.
     */
    public AbstractITSimpleEntityModify() {
        super();
    }

    @Override
    protected final void assertEntityModified(final SimpleEntity entity) {
        Assert.assertEquals(entity.getName(), name);
    }

    @Override
    protected final Integer getId(final SimpleEntity entity) {
        return entity.getId();
    }

    @Override
    protected final void modifyEntity(final SimpleEntity entity) {
        entity.setName(name);
    }

}
