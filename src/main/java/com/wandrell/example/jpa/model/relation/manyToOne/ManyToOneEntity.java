
package com.wandrell.example.jpa.model.relation.manyToOne;

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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.common.base.MoreObjects;

/**
 * Entity with a many to one relationship.
 *
 * @author Bernardo Martínez Garrido
 */
@Entity(name = "ManyToOneEntity")
@Table(name = "many_to_one_entities")
public class ManyToOneEntity implements Serializable {

    /**
     * Serialization ID.
     */
    private static final long serialVersionUID = -2695810398258763234L;

    /**
     * Entity's ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer           id               = null;

    /**
     * Name of the entity.
     * <p>
     * This is to have additional data apart from the id, to be used on the
     * tests.
     */
    @Column(name = "name", nullable = false)
    private String            name             = "";

    /**
     * Entity in the 'one' side.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "one_to_many_id")
    private OneToManyEntity   oneToMany;

    /**
     * Default constructor.
     */
    public ManyToOneEntity() {
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

        final ManyToOneEntity other = (ManyToOneEntity) obj;
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
     * Returns the name of the entity.
     *
     * @return the entity's name
     */
    public final String getName() {
        return name;
    }

    /**
     * Returns the entity in the 'one' side.
     *
     * @return the entity in the 'one' side
     */
    public final OneToManyEntity getOneToMany() {
        return oneToMany;
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
     * Sets the name of the entity.
     *
     * @param value
     *            the name to set in the entity
     */
    public final void setName(final String value) {
        this.name = checkNotNull(value, "Received a null pointer as name");
    }

    /**
     * Sets the entity in the 'one' side.
     *
     * @param value
     *            the entity to set in the 'one' side.
     */
    public final void setOneToMany(final OneToManyEntity value) {
        this.oneToMany = checkNotNull(value,
                "Received a null pointer as oneToMany");
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("id", id).toString();
    }

}
