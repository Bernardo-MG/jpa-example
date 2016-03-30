
package com.wandrell.example.jpa.model.type;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.common.base.MoreObjects;

@Entity(name = "EnumEntity")
@Table(name = "enum_entities")
public final class EnumEntity {

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "enum_ordinal", nullable = false)
    private TestEnum enumOrdinal;

    @Enumerated(EnumType.STRING)
    @Column(name = "enum_string", nullable = false)
    private TestEnum enumString;

    /**
     * Entity's ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer  id = null;

    public EnumEntity() {
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

        final EnumEntity other = (EnumEntity) obj;
        return Objects.equals(id, other.id);
    }

    public final TestEnum getEnumOrdinal() {
        return enumOrdinal;
    }

    public final TestEnum getEnumString() {
        return enumString;
    }

    public final Integer getId() {
        return id;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(id);
    }

    public final void setEnumOrdinal(final TestEnum enumOrdinal) {
        this.enumOrdinal = enumOrdinal;
    }

    public final void setEnumString(final TestEnum enumString) {
        this.enumString = enumString;
    }

    public final void setId(final Integer id) {
        this.id = id;
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("id", id).toString();
    }

}
