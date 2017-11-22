
package com.bernardomg.example.jpa.model.relation.onetoone;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.google.common.base.MoreObjects;

/**
 * Entity with a one to one relationship mapped to another class.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Entity(name = "OneToOneInverseEntity")
@Table(name = "one_to_one_inverse_entities")
public class OneToOneInverseEntity implements Serializable {

    /**
     * Serialization ID.
     */
    private static final long    serialVersionUID = -1518449549877765486L;

    /**
     * Entity's ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer              id               = null;

    /**
     * Name of the entity.
     * <p>
     * This is to have additional data apart from the id, to be used on the
     * tests.
     */
    @Column(name = "name", nullable = false)
    private String               name             = "";

    /**
     * One to one entity with the main declaration of the relationship.
     */
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "inverse")
    private OneToOneSourceEntity source;

    /**
     * Default constructor.
     */
    public OneToOneInverseEntity() {
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

        final OneToOneInverseEntity other = (OneToOneInverseEntity) obj;
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
     * Returns the one to one entity with the main declaration of the
     * relationship.
     * 
     * @return the one to one entity with the main declaration of the
     *         relationship
     */
    public final OneToOneSourceEntity getSource() {
        return source;
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
        name = checkNotNull(value, "Received a null pointer as name");
    }

    /**
     * Sets the one to one entity with the main declaration of the relationship.
     * 
     * @param value
     *            the one to one entity with the main declaration of the
     *            relationship
     */
    public final void setSource(final OneToOneSourceEntity value) {
        source = checkNotNull(value, "Received a null pointer as source");
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("id", id).toString();
    }

}
