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

package com.wandrell.example.jpa.test.util.test.integration.converter;

import org.testng.Assert;

import com.wandrell.example.jpa.model.converter.BooleanConverterEntity;
import com.wandrell.example.jpa.model.simple.SimpleEntity;
import com.wandrell.example.jpa.test.util.test.integration.AbstractITEntityModify;

/**
 * Abstract integration tests for a {@link SimpleEntity} testing it can be
 * modified.
 *
 * @author Bernardo Martínez Garrido
 * @see SimpleEntity
 */
public abstract class AbstractITBooleanConverterEntityModify
        extends AbstractITEntityModify<BooleanConverterEntity> {

    /**
     * Flag for the tests,
     */
    private final Boolean flag = true;

    /**
     * Default constructor.
     */
    public AbstractITBooleanConverterEntityModify() {
        super();
    }

    @Override
    protected final void
            assertEntityModified(final BooleanConverterEntity entity) {
        Assert.assertEquals(entity.getFlag(), flag);
    }

    @Override
    protected final Integer getId(final BooleanConverterEntity entity) {
        return entity.getId();
    }

    @Override
    protected final void modifyEntity(final BooleanConverterEntity entity) {
        entity.setFlag(flag);
    }

}
