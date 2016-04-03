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

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.google.common.base.MoreObjects;

@Entity(name = "EmbeddedKeyEntity")
@Table(name = "embedded_key_entities")
public class EmbeddedCompositeKeyEntity {

    @EmbeddedId
    private EmbeddableCompositeKey key;

    @Column(name = "name", nullable = false)
    private String                 name = "";

    public EmbeddedCompositeKeyEntity() {
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

        final EmbeddedCompositeKeyEntity other = (EmbeddedCompositeKeyEntity) obj;
        return Objects.equals(key, other.key);
    }

    public final String getName() {
        return name;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(key);
    }

    public final void setName(final String name) {
        this.name = name;
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("key", key).toString();
    }

}
