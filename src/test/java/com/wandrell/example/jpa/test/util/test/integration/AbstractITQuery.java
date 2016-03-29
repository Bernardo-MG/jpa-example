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

package com.wandrell.example.jpa.test.util.test.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.example.jpa.model.DefaultSimpleEntity;

/**
 * Abstract integration tests for a {@link FilteredRepository} testing query
 * methods.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>Retrieving all the entities gives the correct number of them.</li>
 * <li>Retrieving an existing entity returns it.</li>
 * <li>Retrieving a not existing entity returns null.</li>
 * <li>Retrieving an existing collection returns it.</li>
 * <li>Retrieving a not existing collection returns an empty collection.</li>
 * </ol>
 * <p>
 * This is meant to be used along a Spring context, which will set up the
 * repository and all of it's requirements.
 *
 * @author Bernardo Martínez Garrido
 * @see FilteredRepository
 */
public abstract class AbstractITQuery
        extends AbstractTransactionalTestNGSpringContextTests {

    /**
     * Initial number of entities in the repository.
     */
    @Value("${entities.total}")
    private Integer                                      entitiesCount;

    /**
     * The repository being tested.
     */
    @Autowired
    private JpaRepository<DefaultSimpleEntity, Integer> repository;

    /**
     * Default constructor.
     */
    public AbstractITQuery() {
        super();
    }

    /**
     * Tests that retrieving all the entities gives the correct number of them.
     */
    @Test
    public final void testGetAll() {
        Assert.assertEquals((Integer) getRepository().findAll().size(),
                entitiesCount);
    }

    /**
     * Tests that retrieving an existing entity returns it.
     */
    @Test
    public final void testGetEntity_Existing_Entity() {
        final Integer id;                     // Entity ID
        final DefaultSimpleEntity entity;    // Tested entity

        // Entity's id
        id = 1;

        // Acquires the entity
        entity = getRepository().findOne(id);

        // The entity's id is the correct one
        Assert.assertEquals(entity.getId(), id);
    }

    /**
     * Tests that retrieving a not existing entity returns null.
     */
    @Test
    public final void testGetEntity_NotExisting_Null() {
        final Integer id;                     // Invalid entity ID
        final DefaultSimpleEntity entity;    // Tested entity

        // Invalid entity id
        id = 123;

        // Tries to acquire the entity
        entity = getRepository().findOne(id);

        // The entity is null
        Assert.assertEquals(entity, null);
    }

    /**
     * Returns the repository being tested.
     *
     * @return the repository being tested.
     */
    protected final JpaRepository<DefaultSimpleEntity, Integer>
            getRepository() {
        return repository;
    }

}
