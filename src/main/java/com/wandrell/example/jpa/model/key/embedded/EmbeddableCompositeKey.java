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

package com.wandrell.example.jpa.model.key.embedded;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.google.common.base.MoreObjects;

/**
 * Embeddable composite key.
 *
 * @author Bernardo Martínez Garrido
 * @see EmbeddedCompositeKeyEntity
 */
@Embeddable
public class EmbeddableCompositeKey implements Serializable {

    /**
     * Serialization ID.
     */
    private static final long serialVersionUID = 7216971993025321859L;

    /**
     * First id.
     */
    @Column(name = "id1", nullable = false, unique = true)
    private Integer           id;

    /**
     * Second id.
     */
    @Column(name = "id2", nullable = false, unique = true)
    private Long              supportId;

    /**
     * Default constructor.
     */
    public EmbeddableCompositeKey() {
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

        final EmbeddableCompositeKey other = (EmbeddableCompositeKey) obj;
        return Objects.equals(id, other.id)
                && Objects.equals(supportId, other.supportId);
    }

    /**
     * Returns the first id.
     *
     * @return the first id
     */
    public final Integer getId() {
        return id;
    }

    /**
     * Returns the second id.
     *
     * @return the second id
     */
    public final Long getSupportId() {
        return supportId;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(id, supportId);
    }

    /**
     * Sets the first id.
     *
     * @param identifier
     *            the first id for the entity
     */
    public final void setId(final Integer identifier) {
        this.id = checkNotNull(identifier,
                "Received a null pointer as the identifier");
    }

    /**
     * Sets the second id.
     *
     * @param identifier
     *            the second id for the entity
     */
    public final void setSupportId(final Long identifier) {
        this.supportId = checkNotNull(identifier,
                "Received a null pointer as the identifier");
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("id1", id)
                .add("id2", supportId).toString();
    }

}
