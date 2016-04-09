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

package com.wandrell.example.jpa.model.key.classid;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.google.common.base.MoreObjects;

@Entity(name = "CompositeKeyIdClassEntity")
@Table(name = "composite_key_idclass_entities")
@IdClass(CompositeKey.class)
public class CompositeKeyIdClassEntity {

    @Id
    @Column(name = "id1", nullable = false, unique = true)
    private Integer id1;

    @Id
    @Column(name = "id2", nullable = false, unique = true)
    private Long    id2;

    @Column(name = "name", nullable = false)
    private String  name = "";

    public CompositeKeyIdClassEntity() {
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

        final CompositeKeyIdClassEntity other = (CompositeKeyIdClassEntity) obj;
        return Objects.equals(id1, other.id1) && Objects.equals(id2, other.id2);
    }

    public final Integer getId1() {
        return id1;
    }

    public final Long getId2() {
        return id2;
    }

    public final String getName() {
        return name;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(id1, id2);
    }

    public final void setId1(final Integer id1) {
        this.id1 = checkNotNull(id1, "Received a null pointer as id 1");
    }

    public final void setId2(final Long id2) {
        this.id2 = checkNotNull(id2, "Received a null pointer as id 2");
    }

    public final void setName(final String name) {
        this.name = checkNotNull(name, "Received a null pointer as name");
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("id1", id1).add("id2", id2)
                .toString();
    }

}
