
package com.wandrell.example.jpa.model.sequencing;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.google.common.base.MoreObjects;

@Entity(name = "TableGeneratedIdEntity")
@Table(name = "table_id_entities")
@TableGenerator(name = "tab", initialValue = 0, allocationSize = 50)
public final class TableGeneratedIdEntity {

    /**
     * Entity's ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tab")
    @Column(name = "id", nullable = false, unique = true)
    private Integer id = null;

    public TableGeneratedIdEntity() {
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

        final TableGeneratedIdEntity other = (TableGeneratedIdEntity) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("id", id).toString();
    }

}
