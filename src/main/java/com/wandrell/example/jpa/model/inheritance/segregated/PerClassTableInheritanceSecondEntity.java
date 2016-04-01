
package com.wandrell.example.jpa.model.inheritance.segregated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "PerClassTableInheritanceSecondEntity")
@Table(name = "per_class_table_inherit_second_entities")
public class PerClassTableInheritanceSecondEntity
        extends PerClassTableInheritanceRootEntity {

    @Column(name = "field_b")
    private Long field_b;

    public PerClassTableInheritanceSecondEntity() {
        super();
    }

    public final Long getField_b() {
        return field_b;
    }

    public final void setField_b(final Long field_b) {
        this.field_b = field_b;
    }

}
