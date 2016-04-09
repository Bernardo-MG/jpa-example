
package com.wandrell.example.jpa.model.relation.manyToMany;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.google.common.base.MoreObjects;

@Entity(name = "ManyToManyOwnerEntity")
@Table(name = "many_to_many_owner_entities")
public class ManyToManyOwnerEntity {

    /**
     * Entity's ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer                            id   = null;

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
    private String                             name = "";

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

    public final Integer getId() {
        return id;
    }

    public final Collection<ManyToManyMappedEntity> getMapped() {
        return mapped;
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

    public final void setMapped(Collection<ManyToManyMappedEntity> mapped) {
        this.mapped = checkNotNull(mapped, "Received a null pointer as mapped");
    }

    public final void setName(final String name) {
        this.name = checkNotNull(name, "Received a null pointer as name");
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("id", id).toString();
    }

}
