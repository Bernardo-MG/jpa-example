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

package com.wandrell.example.jpa.test.integration.inheritance.single;

import org.junit.Assert;

import com.wandrell.example.jpa.model.inheritance.single.SingleTableInheritanceValueEntity;
import com.wandrell.example.jpa.test.util.test.integration.AbstractITEntityModify;

/**
 * Integration tests for a {@code SingleTableInheritanceValueEntity} testing it
 * can be modified.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class ITSingleTableInheritanceValueEntityModify
        extends AbstractITEntityModify<SingleTableInheritanceValueEntity> {

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
    public ITSingleTableInheritanceValueEntityModify() {
        super(SingleTableInheritanceValueEntity::new, 2);
    }

    @Override
    protected final void assertEntityModified(
            final SingleTableInheritanceValueEntity entity) {
        Assert.assertEquals(entity.getName(), name);
        Assert.assertEquals(entity.getValue(), value);
    }

    @Override
    protected final void
            modifyEntity(final SingleTableInheritanceValueEntity entity) {
        entity.setName(name);
        entity.setValue(value);
    }

}
