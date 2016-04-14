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

package com.wandrell.example.jpa.model.inheritance.multiple;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity for multiple inheritance entities.
 *
 * @author Bernardo Martínez Garrido
 */
@Entity(name = "MultipleTableInheritanceDescriptionEntity")
@DiscriminatorValue("B")
@Table(name = "multiple_table_inherit_description_entities")
public class MultipleTableInheritanceDescriptionEntity
        extends MultipleTableInheritanceRootEntity {

    /**
     * Serialization ID.
     */
    private static final long serialVersionUID = -9208638219453280651L;

    @Column(name = "description")
    private Long              description;

    /**
     * Default constructor.
     */
    public MultipleTableInheritanceDescriptionEntity() {
        super();
    }

    public final Long getDescription() {
        return description;
    }

    public final void setDescription(final Long description) {
        this.description = checkNotNull(description,
                "Received a null pointer as description");
    }

}
