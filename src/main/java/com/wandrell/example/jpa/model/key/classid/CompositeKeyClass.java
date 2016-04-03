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

import java.util.Objects;

import com.google.common.base.MoreObjects;

public class CompositeKeyClass {

    int  id1;

    long id2;

    public CompositeKeyClass() {
        super();
    }

    public CompositeKeyClass(final int id1, final long id2) {
        super();

        this.id1 = id1;
        this.id2 = id2;
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

        final CompositeKeyClass other = (CompositeKeyClass) obj;
        return Objects.equals(id1, other.id1) && Objects.equals(id2, other.id2);
    }

    public final Integer getId1() {
        return id1;
    }

    public final Long getId2() {
        return id2;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(id1, id2);
    }

    public final void setId1(final Integer id1) {
        this.id1 = id1;
    }

    public final void setId2(final Long id2) {
        this.id2 = id2;
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("id1", id1).add("id2", id2)
                .toString();
    }
}