/**
 * The MIT License (MIT)
 * <p>
 * Copyright (c) 2016-2021 the original author or authors.
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

package com.bernardomg.example.jpa.model.sequencing;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * JPA entity using an table-generated id.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Entity(name = "TableGeneratedIdEntity")
@Table(name = "table_id_entities")
@TableGenerator(name = "TABLE_GENERATOR", table = "SEQUENCE",
        pkColumnName = "seq_name", valueColumnName = "seq_count",
        initialValue = 10, allocationSize = 10)
public final class TableGeneratedIdEntity implements Serializable {

    /**
     * Serialization ID.
     */
    private static final long serialVersionUID = 5324556222584901497L;

    /**
     * Entity's ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "TABLE_GENERATOR")
    @Column(name = "id", nullable = false, unique = true)
    private final Integer     id               = null;

    /**
     * Name of the entity.
     * <p>
     * This is to have additional data apart from the id, to be used on the
     * tests.
     */
    @Column(name = "name", nullable = false)
    private String            name             = "";

    /**
     * Default constructor.
     */
    public TableGeneratedIdEntity() {
        super();
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final TableGeneratedIdEntity other = (TableGeneratedIdEntity) obj;
        return Objects.equals(id, other.id);
    }

    /**
     * Returns the name of the entity.
     *
     * @return the entity's name
     */
    public final String getName() {
        return name;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Sets the name of the entity.
     *
     * @param value
     *            the name to set on the entity
     */
    public final void setName(final String value) {
        name = Objects.requireNonNull(value, "Received a null pointer as name");
    }

    @Override
    public final String toString() {
        return new StringJoiner(" | ", this.getClass().getSimpleName() + "[ ",
                " ]").add("id=" + id).toString();
    }

}
