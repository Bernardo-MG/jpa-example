
package com.wandrell.example.jpa.model.relation.onetoone;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
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

/**
 * Entity with a one to one relationship and the main declaration for it.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Entity(name = "OneToOneSourceEntity")
@Table(name = "one_to_one_source_entities")
public class OneToOneSourceEntity implements Serializable {

    /**
     * Serialization ID.
     */
    private static final long     serialVersionUID = -1542505296838977668L;

    /**
     * Entity's ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer               id               = null;

    /**
     * One to one entity with the inverse declaration of the relationship.
     */
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
    private String                name             = "";

    /**
     * Default constructor.
     */
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

    /**
     * Returns the ID assigned to this entity.
     *
     * @return the entity's ID
     */
    public final Integer getId() {
        return id;
    }

    /**
     * Returns the one to one entity with the inverse declaration of the
     * relationship.
     *
     * @return the one to one entity with the inverse declaration of the
     *         relationship
     */
    public final OneToOneInverseEntity getInverse() {
        return inverse;
    }

    /**
     * Returns the name of the entity.
     *
     * @return the entity's name
     */
    public final String getName() {
        return name;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Sets the ID assigned to this entity.
     *
     * @param identifier
     *            the ID for the entity
     */
    public final void setId(final Integer identifier) {
        id = checkNotNull(identifier, "Received a null pointer as identifier");
    }

    /**
     * Sets the one to one entity with the inverse declaration of the
     * relationship.
     * 
     * @param value
     *            the one to one entity with the inverse declaration of the
     *            relationship to set in the entity
     */
    public final void setInverse(final OneToOneInverseEntity value) {
        this.inverse = checkNotNull(value,
                "Received a null pointer as inverse");
    }

    /**
     * Sets the name of the entity.
     *
     * @param value
     *            the name to set in the entity
     */
    public final void setName(final String value) {
        this.name = checkNotNull(value, "Received a null pointer as name");
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("id", id).toString();
    }

}
