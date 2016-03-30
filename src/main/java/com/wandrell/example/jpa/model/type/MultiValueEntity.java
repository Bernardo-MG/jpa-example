
package com.wandrell.example.jpa.model.type;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.common.base.MoreObjects;

@Entity(name = "MultiValueEntity")
@Table(name = "multivalue_entities")
public class MultiValueEntity {

    /**
     * Entity's ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer              id          = null;

    @Column(name = "integersCol", nullable = false)
    private Collection<Integer>  integersCol = new LinkedList<Integer>();

    @Column(name = "integersMap", nullable = false)
    private Map<String, Integer> integersMap = new LinkedHashMap<String, Integer>();

    public MultiValueEntity() {
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

        final MultiValueEntity other = (MultiValueEntity) obj;
        return Objects.equals(id, other.id);
    }

    public final Collection<Integer> getIntegersCol() {
        return integersCol;
    }

    public final Map<String, Integer> getIntegersMap() {
        return integersMap;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(id);
    }

    public final void setIntegersCol(final Collection<Integer> integersCol) {
        this.integersCol = integersCol;
    }

    public final void setIntegersMap(final Map<String, Integer> integersMap) {
        this.integersMap = integersMap;
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("id", id).toString();
    }

}
