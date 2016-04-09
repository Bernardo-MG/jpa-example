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

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.google.common.base.MoreObjects;

/**
 * Embeddabble entity to be added into a JPA entity.
 * 
 * @author Bernardo Martínez Garrido
 */
@Embeddable
public final class EmbeddableData {

    /**
     * Description of the entity.
     */
    @Column(name = "desc", nullable = false)
    private String desc = "";

    /**
     * Name of the entity.
     */
    @Column(name = "name", nullable = false)
    private String name = "";

    /**
     * Default constructor.
     */
    public EmbeddableData() {
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

        final EmbeddableData other = (EmbeddableData) obj;
        return Objects.equals(name, other.name)
                && Objects.equals(desc, other.desc);
    }

    /**
     * Returns the description of the entity.
     * 
     * @return the description of the entity
     */
    public final String getDescription() {
        return desc;
    }

    /**
     * Returns the name of the entity.
     * 
     * @return the name of the entity
     */
    public final String getName() {
        return name;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(name, desc);
    }

    /**
     * Sets the description of the entity.
     * 
     * @param description
     *            the description to set in the entity
     */
    public final void setDescription(final String description) {
        this.desc = description;
    }

    /**
     * Sets the name of the entity.
     * 
     * @param name
     *            the name to set in the entity
     */
    public final void setName(final String name) {
        this.name = name;
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", name)
                .add("description", desc).toString();
    }

}
