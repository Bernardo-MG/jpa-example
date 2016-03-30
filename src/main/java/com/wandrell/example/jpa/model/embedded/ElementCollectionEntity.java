
package com.wandrell.example.jpa.model.embedded;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.google.common.base.MoreObjects;

@Entity(name = "MultiValueEntity")
@Table(name = "multivalue_entities")
public class ElementCollectionEntity {

    @ElementCollection
    @CollectionTable(name = "data", joinColumns = @JoinColumn(name = "id") )
    private Collection<EmbeddableData> data = new LinkedList<EmbeddableData>();

    /**
     * Entity's ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer                    id   = null;

    public ElementCollectionEntity() {
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

        final ElementCollectionEntity other = (ElementCollectionEntity) obj;
        return Objects.equals(id, other.id);
    }

    public final Collection<EmbeddableData> getData() {
        return data;
    }

    public final Integer getId() {
        return id;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(id);
    }

    public final void setData(final Collection<EmbeddableData> data) {
        this.data = data;
    }

    public final void setId(final Integer id) {
        this.id = id;
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("id", id).toString();
    }

}
