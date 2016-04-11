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

package com.wandrell.example.jpa.model.embedded;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.google.common.base.MoreObjects;

/**
 * Entity using a collection of embeddable objects.
 *
 * @author Bernardo Martínez Garrido
 * @see EmbeddableData
 */
@Entity(name = "ElementCollectionEntity")
@Table(name = "element_collection_entities")
public class ElementCollectionEntity implements Serializable {

    /**
     * Serialization ID.
     */
    private static final long          serialVersionUID = 2888164164144934845L;

    /**
     * Entity's ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer                    id               = null;

    /**
     * Embeddable objects.
     */
    @ElementCollection
    @CollectionTable(name = "data", joinColumns = @JoinColumn(name = "id") )
    private Collection<EmbeddableData> values           = new LinkedList<EmbeddableData>();

    /**
     * Default constructor.
     */
    public ElementCollectionEntity() {
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

        final ElementCollectionEntity other = (ElementCollectionEntity) obj;
        return Objects.equals(id, other.id);
    }

    /**
     * Returns the entity's id.
     *
     * @return the entity's id
     */
    public final Integer getId() {
        return id;
    }

    /**
     * Returns the embeddable objects.
     *
     * @return the embeddable objects
     */
    public final Collection<EmbeddableData> getValues() {
        return values;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Sets the entity's id.
     *
     * @param identifier
     *            the id to set in the entity
     */
    public final void setId(final Integer identifier) {
        id = checkNotNull(identifier, "Received a null pointer as identifier");
    }

    /**
     * Sets the embeddable objects.
     *
     * @param value
     *            embeddable objects to set in the entity
     */
    public final void setValues(final Collection<EmbeddableData> value) {
        this.values = checkNotNull(value, "Received a null pointer as values");
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("id", id).toString();
    }

}
