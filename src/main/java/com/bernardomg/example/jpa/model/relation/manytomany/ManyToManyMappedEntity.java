
package com.bernardomg.example.jpa.model.relation.manytomany;

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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Entity with a many to many relationship mapped to another class.
 * <p>
 * The actual definition of the relationship is contained in the other class.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Entity(name = "ManyToManyMappedEntity")
@Table(name = "many_to_many_mapped_entities")
public class ManyToManyMappedEntity implements Serializable {

    /**
     * Serialization ID.
     */
    private static final long                 serialVersionUID = 7721405709935727048L;

    /**
     * Entity's ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer                           id               = null;

    /**
     * Name of the entity.
     * <p>
     * This is to have additional data apart from the id, to be used on the
     * tests.
     */
    @Column(name = "name", nullable = false)
    private String                            name             = "";

    /**
     * Owner entities.
     */
    @ManyToMany(mappedBy = "mapped")
    private Collection<ManyToManyOwnerEntity> owners;

    /**
     * Default constructor.
     */
    public ManyToManyMappedEntity() {
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

        final ManyToManyMappedEntity other = (ManyToManyMappedEntity) obj;
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
     * Returns the owner entities.
     *
     * @return the owner entities
     */
    public Collection<ManyToManyOwnerEntity> getOwners() {
        return owners;
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
     * Sets the owner entities.
     * 
     * @param value
     *            the owner entities to set in the entity
     */
    public void setOwners(final List<ManyToManyOwnerEntity> value) {
        owners = Objects.requireNonNull(value,
                "Received a null pointer as owners");
    }

    @Override
    public final String toString() {
        return new StringJoiner(" | ", this.getClass().getSimpleName() + "[ ",
                " ]").add("id=" + id).toString();
    }

}
