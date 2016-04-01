
package com.wandrell.example.jpa.model.key;

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
