
package com.wandrell.example.jpa.model.relation.oneToOne;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.google.common.base.MoreObjects;

@Entity(name = "OneToOneSourceEntity")
@Table(name = "one_to_one_source_entities")
public class OneToOneSourceEntity {

    /**
     * Entity's ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer               id   = null;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inverse_id")
    private OneToOneInverseEntity inverse;

    /**
     * Name of the entity.
     * <p>
     * This is to have additional data apart from the id, to be used on the
     * tests.
     */
    @Column(name = "name", nullable = false)
    private String                name = "";

    public OneToOneSourceEntity() {
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

        final OneToOneSourceEntity other = (OneToOneSourceEntity) obj;
        return Objects.equals(id, other.id);
    }

    public final Integer getId() {
        return id;
    }

    public final OneToOneInverseEntity getInverse() {
        return inverse;
    }

    public final String getName() {
        return name;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(id);
    }

    public final void setId(final Integer identifier) {
        id = checkNotNull(identifier, "Received a null pointer as identifier");
    }

    public final void setInverse(final OneToOneInverseEntity inverse) {
        this.inverse = inverse;
    }

    public final void setName(final String name) {
        this.name = checkNotNull(name, "Received a null pointer as name");
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("id", id).toString();
    }

}
