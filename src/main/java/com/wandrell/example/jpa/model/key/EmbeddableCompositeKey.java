
package com.wandrell.example.jpa.model.key;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.common.base.MoreObjects;

@Embeddable
public class EmbeddableCompositeKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id1", nullable = false, unique = true)
    int  id1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id2", nullable = false, unique = true)
    long id2;

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
