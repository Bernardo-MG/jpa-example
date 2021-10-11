
package com.bernardomg.example.jpa.model.relation.manytoone;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity with a many to one relationship.
 *
 * @author Bernardo Mart&iacute;nez Garrido
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
    public String getName() {
        return name;
    }

    /**
     * Returns the entity in the 'one' side.
     *
     * @return the entity in the 'one' side
     */
    public OneToManyEntity getOneToMany() {
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
        id = Objects.requireNonNull(identifier,
                "Received a null pointer as identifier");
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

    /**
     * Sets the entity in the 'one' side.
     *
     * @param value
     *            the entity to set in the 'one' side.
     */
    public void setOneToMany(final OneToManyEntity value) {
        oneToMany = Objects.requireNonNull(value,
                "Received a null pointer as oneToMany");
    }

    @Override
    public final String toString() {
        return new StringJoiner(" | ", this.getClass().getSimpleName() + "[ ",
                " ]").add("id=" + id).toString();
    }

}
