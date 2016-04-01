
package com.wandrell.example.jpa.model.inheritance.multiple;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "MultipleTableInheritanceFirstEntity")
@DiscriminatorValue("A")
@Table(name = "multiple_table_inherit_first_entities")
public class MultipleTableInheritanceFirstEntity
        extends MultipleTableInheritanceRootEntity {

    @Column(name = "field_a")
    private String field_a = "";

    public MultipleTableInheritanceFirstEntity() {
        super();
    }

    public final String getField_a() {
        return field_a;
    }

    public final void setField_a(final String field_a) {
        this.field_a = field_a;
    }

}
