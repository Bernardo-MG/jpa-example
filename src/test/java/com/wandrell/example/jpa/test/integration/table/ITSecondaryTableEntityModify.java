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

package com.wandrell.example.jpa.test.integration.table;

import org.testng.Assert;

import com.wandrell.example.jpa.model.table.SecondaryTableEntity;
import com.wandrell.example.jpa.test.util.test.integration.AbstractITEntityModify;

/**
 * Integration tests for a {@code SecondaryTableEntity} testing it can be
 * modified.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class ITSecondaryTableEntityModify
        extends AbstractITEntityModify<SecondaryTableEntity> {

    /**
     * Value to set on the main table field for the tests.
     */
    private final String field1 = "first_field";

    /**
     * Value to set on the secondary table field for the tests.
     */
    private final String field2 = "second_field";

    /**
     * Default constructor.
     */
    public ITSecondaryTableEntityModify() {
        super(SecondaryTableEntity.class, 3);
    }

    @Override
    protected final void
            assertEntityModified(final SecondaryTableEntity entity) {
        Assert.assertEquals(entity.getField1(), field1);
        Assert.assertEquals(entity.getField2(), field2);
    }

    @Override
    protected final void modifyEntity(final SecondaryTableEntity entity) {
        entity.setField1(field1);
        entity.setField2(field2);
    }

}
