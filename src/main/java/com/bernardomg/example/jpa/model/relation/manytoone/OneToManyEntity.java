
package com.bernardomg.example.jpa.model.relation.manytoone;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity with a one to many relationship.
 *
 * @author Bernardo Mart&iacute;nez Garrido
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
    public Collection<ManyToOneEntity> getManyToOne() {
        return manyToOne;
    }

    /**
     * Returns the name of the entity.
     *
     * @return the entity's name
     */
    public String getName() {
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
        id = Objects.requireNonNull(identifier,
                "Received a null pointer as identifier");
    }

    /**
     * Sets the entities in the "many" side.
     *
     * @param value
     *            the entities to set in the "many" side
     */
    public void setManyToOne(final List<ManyToOneEntity> value) {
        manyToOne = Objects.requireNonNull(value,
                "Received a null pointer as manyToOne");
    }

    /**
     * Sets the name of the entity.
     *
     * @param value
     *            the name to set in the entity
     */
    public void setName(final String value) {
        name = Objects.requireNonNull(value, "Received a null pointer as name");
    }

    @Override
    public final String toString() {
        return new StringJoiner(" | ", this.getClass().getSimpleName() + "[ ",
                " ]").add("id=" + id).toString();
    }

}
