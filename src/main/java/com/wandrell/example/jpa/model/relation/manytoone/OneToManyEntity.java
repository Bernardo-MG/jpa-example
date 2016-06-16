
package com.wandrell.example.jpa.model.relation.manytoone;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.common.base.MoreObjects;

/**
 * Entity with a one to many relationship.
 *
 * @author Bernardo Martínez Garrido
 */
@Entity(name = "OneToManyEntity")
@Table(name = "one_to_many_entities")
public class OneToManyEntity implements Serializable {

    /**
     * Serialization ID.
     */
    private static final long           serialVersionUID = -2230997873462793335L;

    /**
     * Entity's ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer                     id               = null;

    /**
     * Entities in the "many" side.
     */
    @OneToMany(mappedBy = "oneToMany")
    private Collection<ManyToOneEntity> manyToOne;

    /**
     * Name of the entity.
     * <p>
     * This is to have additional data apart from the id, to be used on the
     * tests.
     */
    @Column(name = "name", nullable = false)
    private String                      name             = "";

    /**
     * Default constructor.
     */
    public OneToManyEntity() {
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

        final OneToManyEntity other = (OneToManyEntity) obj;
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
     * Returns the entities in the "many" side.
     *
     * @return the entities in the "many" side
     */
    public final Collection<ManyToOneEntity> getManyToOne() {
        return manyToOne;
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
     * Sets the entities in the "many" side.
     *
     * @param value
     *            the entities to set in the "many" side
     */
    public final void setManyToOne(final List<ManyToOneEntity> value) {
        this.manyToOne = checkNotNull(value,
                "Received a null pointer as manyToOne");
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
