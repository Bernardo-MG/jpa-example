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

package com.wandrell.example.jpa.test.util.test.integration.collection.map;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import com.wandrell.example.jpa.model.collection.MapEntity;
import com.wandrell.example.jpa.test.util.test.integration.AbstractITEntityModify;

/**
 * Abstract integration tests for a {@link MapEntity} testing it can be
 * modified.
 *
 * @author Bernardo Martínez Garrido
 * @see MapEntity
 */
public abstract class AbstractITMapEntityModify
        extends AbstractITEntityModify<MapEntity> {

    /**
     * Value to set on the name for the tests.
     */
    private final String               name   = "The new name";

    /**
     * Values to set on the entity.
     */
    private final Map<String, Integer> values = new LinkedHashMap<String, Integer>();

    /**
     * Default constructor.
     */
    public AbstractITMapEntityModify() {
        super();
    }

    @BeforeTest
    public final void initializeValues() {
        values.put("value_11", 11);
        values.put("value_55", 55);
    }

    @Override
    protected final void assertEntityModified(final MapEntity entity) {
        Assert.assertEquals(entity.getName(), name);
        Assert.assertEquals(entity.getValues(), values);
    }

    @Override
    protected final void modifyEntity(final MapEntity entity) {
        entity.setName(name);
        entity.setValues(values);
    }

}