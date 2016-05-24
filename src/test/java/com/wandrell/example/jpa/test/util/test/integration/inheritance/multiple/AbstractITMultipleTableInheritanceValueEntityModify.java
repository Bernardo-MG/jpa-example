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

package com.wandrell.example.jpa.test.util.test.integration.inheritance.multiple;

import org.testng.Assert;

import com.wandrell.example.jpa.model.enumeration.EnumerationEntity;
import com.wandrell.example.jpa.model.inheritance.multiple.MultipleTableInheritanceValueEntity;
import com.wandrell.example.jpa.test.util.test.integration.AbstractITEntityModify;

/**
 * Abstract integration tests for a {@link EnumerationEntity} testing it can be
 * modified.
 *
 * @author Bernardo Martínez Garrido
 * @see EnumerationEntity
 */
public abstract class AbstractITMultipleTableInheritanceValueEntityModify
        extends AbstractITEntityModify<MultipleTableInheritanceValueEntity> {

    /**
     * Name to set on the entity for the tests.
     */
    private final String  name  = "entity";

    /**
     * Value to set on the entity for the tests.
     */
    private final Integer value = 123;

    /**
     * Default constructor.
     */
    public AbstractITMultipleTableInheritanceValueEntityModify() {
        super();
    }

    @Override
    protected final void assertEntityModified(
            final MultipleTableInheritanceValueEntity entity) {
        Assert.assertEquals(entity.getName(), name);
        Assert.assertEquals(entity.getValue(), value);
    }

    @Override
    protected final void
            modifyEntity(final MultipleTableInheritanceValueEntity entity) {
        entity.setName(name);
        entity.setValue(value);
    }

}
