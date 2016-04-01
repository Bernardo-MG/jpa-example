
package com.wandrell.example.jpa.model.inheritance.multiple;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "MultipleTableInheritanceSecondEntity")
@DiscriminatorValue("B")
@Table(name = "multiple_table_inherit_second_entities")
public class MultipleTableInheritanceSecondEntity
        extends MultipleTableInheritanceRootEntity {

    @Column(name = "field_b")
    private Long field_b;

    public MultipleTableInheritanceSecondEntity() {
        super();
    }

    public final Long getField_b() {
        return field_b;
    }

    public final void setField_b(final Long field_b) {
        this.field_b = field_b;
    }

}
