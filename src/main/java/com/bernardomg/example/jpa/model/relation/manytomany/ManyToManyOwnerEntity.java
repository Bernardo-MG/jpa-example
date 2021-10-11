
package com.bernardomg.example.jpa.model.relation.manytomany;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.StringJoiner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Entity with a many to many relationship and the main declaration for it.
 * <p>
 * It is the owner entity because it contains the actual definition of the
 * relationship, while the other entity will just be mapped to it.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Entity(name = "ManyToManyOwnerEntity")
@Table(name = "many_to_many_owner_entities")
public class ManyToManyOwnerEntity implements Serializable {

    /**
     * Serialization ID.
     */
    private static final long                  serialVersionUID = 7907869801056876634L;

    /**
     * Entity's ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer                            id               = null;

    /**
     * Mapped entities.
     */
    @ManyToMany
    @JoinTable(name = "many_to_many_joined",
            joinColumns = @JoinColumn(name = "owner_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "mapped_id",
                    referencedColumnName = "id"))
    private Collection<ManyToManyMappedEntity> mapped;

    /**
     * Name of the entity.
     * <p>
     * This is to have additional data apart from the id, to be used on the
     * tests.
     */
    @Column(name = "name", nullable = false)
    private String                             name             = "";

    /**
     * Default constructor.
     */
    public ManyToManyOwnerEntity() {
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

        final ManyToManyOwnerEntity other = (ManyToManyOwnerEntity) obj;
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
     * Returns the mapped entities.
     *
     * @return the mapped entities.
     */
    public Collection<ManyToManyMappedEntity> getMapped() {
        return mapped;
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
     * Sets the mapped entities.
     *
     * @param value
     *            the mapped entities to set in the entity
     */
    public void setMapped(final Collection<ManyToManyMappedEntity> value) {
        mapped = Objects.requireNonNull(value,
                "Received a null pointer as mapped");
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
