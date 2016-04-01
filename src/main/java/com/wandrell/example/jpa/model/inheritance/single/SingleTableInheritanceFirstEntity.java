
package com.wandrell.example.jpa.model.inheritance.single;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "SingleTableInheritanceFirstEntity")
@DiscriminatorValue("A")
public class SingleTableInheritanceFirstEntity
        extends SingleTableInheritanceRootEntity {

    @Column(name = "field_a")
    private String field_a = "";

    public SingleTableInheritanceFirstEntity() {
        super();
    }

    public final String getField_a() {
        return field_a;
    }

    public final void setField_a(final String field_a) {
        this.field_a = field_a;
    }

}
