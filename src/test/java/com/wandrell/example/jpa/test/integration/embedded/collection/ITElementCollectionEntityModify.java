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

package com.wandrell.example.jpa.test.integration.embedded.collection;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import com.wandrell.example.jpa.model.embedded.ElementCollectionEntity;
import com.wandrell.example.jpa.model.embedded.EmbeddableData;
import com.wandrell.example.jpa.test.util.config.context.TestContextConfig;
import com.wandrell.example.jpa.test.util.config.properties.QueryPropertiesPaths;
import com.wandrell.example.jpa.test.util.config.properties.TestPropertiesConfig;
import com.wandrell.example.jpa.test.util.test.integration.AbstractITEntityModify;

/**
 * Integration tests for a {@code ElementCollectionEntity} testing it can be
 * modified.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
@ContextConfiguration(locations = { TestContextConfig.DEFAULT,
        TestContextConfig.ENTITY_MODIFIABLE, })
@TestPropertySource(locations = { TestPropertiesConfig.ELEMENT_COLLECTION,
        QueryPropertiesPaths.ELEMENT_COLLECTION })
public final class ITElementCollectionEntityModify
        extends AbstractITEntityModify<ElementCollectionEntity> {

    /**
     * Value to set on the name for the tests.
     */
    private final EmbeddableData data = new EmbeddableData();

    /**
     * Default constructor.
     */
    public ITElementCollectionEntityModify() {
        super(5);
    }

    @BeforeTest
    public final void initializeValue() {
        data.setName("name");
        data.setDescription("desc");
    }

    @Override
    protected final void
            assertEntityModified(final ElementCollectionEntity entity) {
        Assert.assertEquals(entity.getValues().iterator().next().getName(),
                "name");
    }

    @Override
    protected final void modifyEntity(final ElementCollectionEntity entity) {
        entity.getValues().clear();
        entity.getValues().add(data);
    }

}
