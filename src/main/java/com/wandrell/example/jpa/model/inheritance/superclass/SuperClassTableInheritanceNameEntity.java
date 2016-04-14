/**
 * The MIT License (MIT)
 * <p>
 * Copyright (c) 2016 the original author or authors.
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

package com.wandrell.example.jpa.model.inheritance.superclass;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity for super class inheritance entities.
 *
 * @author Bernardo Martínez Garrido
 */
@Entity(name = "SuperClassTableInheritanceNameEntity")
@Table(name = "super_class_table_inherit_name_entities")
@AttributeOverride(name = "id", column = @Column(name = "id_entity") )
public class SuperClassTableInheritanceNameEntity
        extends SuperClassTableInheritanceRootEntity {

    /**
     * Serialization ID.
     */
    private static final long serialVersionUID = 448987499302198165L;

    /**
     * The name.
     */
    @Column(name = "name")
    private String            name             = "";

    /**
     * Default constructor.
     */
    public SuperClassTableInheritanceNameEntity() {
        super();
    }

    /**
     * Returns the name.
     *
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * Sets the name.
     * 
     * @param name
     *            the name to set in the entity
     */
    public final void setName(final String name) {
        this.name = checkNotNull(name, "Received a null pointer as name");
    }

}