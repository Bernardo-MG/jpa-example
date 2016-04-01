
package com.wandrell.example.jpa.model.inheritance.perclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "PerClassTableInheritanceFirstEntity")
@Table(name = "per_class_table_inherit_first_entities")
public class PerClassTableInheritanceFirstEntity
        extends PerClassTableInheritanceRootEntity {

    @Column(name = "field_a")
    private String field_a = "";

    public PerClassTableInheritanceFirstEntity() {
        super();
    }

    public final String getField_a() {
        return field_a;
    }

    public final void setField_a(final String field_a) {
        this.field_a = field_a;
    }

}
