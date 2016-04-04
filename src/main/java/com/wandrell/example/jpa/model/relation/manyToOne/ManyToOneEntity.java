
package com.wandrell.example.jpa.model.relation.manyToOne;

import static com.google.common.base.Preconditions.checkNotNull;

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

@Entity(name = "ManyToOneEntity")
@Table(name = "many_to_one_entities")
public class ManyToOneEntity {

    /**
     * Entity's ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer         id   = null;

    /**
     * Name of the entity.
     * <p>
     * This is to have additional data apart from the id, to be used on the
     * tests.
     */
    @Column(name = "name", nullable = false)
    private String          name = "";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "one_to_many_id")
    private OneToManyEntity oneToMany;

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

    public final Integer getId() {
        return id;
    }

    public final String getName() {
        return name;
    }

    public final OneToManyEntity getOneToMany() {
        return oneToMany;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(id);
    }

    public final void setId(final Integer identifier) {
        id = checkNotNull(identifier, "Received a null pointer as identifier");
    }

    public final void setName(final String name) {
        this.name = checkNotNull(name, "Received a null pointer as name");
    }

    public final void setOneToMany(final OneToManyEntity oneToMany) {
        this.oneToMany = oneToMany;
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("id", id).toString();
    }

}
