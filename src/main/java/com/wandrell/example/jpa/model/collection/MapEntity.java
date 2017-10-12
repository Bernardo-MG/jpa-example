/**
 * The MIT License (MIT)
 * <p>
 * Copyright (c) 2016-2017 the original author or authors.
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

package com.wandrell.example.jpa.model.collection;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

import com.google.common.base.MoreObjects;

/**
 * JPA entity with a map of simple types.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Entity(name = "MapEntity")
@Table(name = "map_entities")
public class MapEntity implements Serializable {

    /**
     * Serialization ID.
     */
    private static final long    serialVersionUID = 5033725460720096537L;

    /**
     * Entity's ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer              id               = null;

    /**
     * Name of the entity.
     * <p>
     * This is to have additional data apart from the id, to be used on the
     * tests.
     */
    @Column(name = "name", nullable = false)
    private String               name             = "";

    /**
     * Mapper integer values.
     */
    @ElementCollection
    @MapKeyColumn(name = "name")
    @CollectionTable(name = "map_entities_values",
            joinColumns = @JoinColumn(name = "map_id"))
    @Column(name = "number", nullable = false)
    private Map<String, Integer> values           = new HashMap<>();

    /**
     * Default constructor.
     */
    public MapEntity() {
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

        final MapEntity other = (MapEntity) obj;
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
     * Returns the name of the entity.
     *
     * @return the entity's name
     */
    public final String getName() {
        return name;
    }

    /**
     * Returns the mapped integer values.
     *
     * @return the mapped integer values
     */
    public final Map<String, Integer> getValues() {
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
     *            the ID for the entity
     */
    public final void setId(final Integer identifier) {
        id = checkNotNull(identifier, "Received a null pointer as identifier");
    }

    /**
     * Sets the name of the entity.
     *
     * @param name
     *            the name to set on the entity
     */
    public final void setName(final String name) {
        this.name = name;
    }

    /**
     * Sets the mapped integer values.
     *
     * @param value
     *            the mapped integer values to set in the entity
     */
    public final void setValues(final Map<String, Integer> value) {
        values = checkNotNull(value, "Received a null pointer as identifier");
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("id", id).toString();
    }

}
