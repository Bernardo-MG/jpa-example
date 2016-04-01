
package com.wandrell.example.jpa.model.inheritance.single;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "SingleTableInheritanceFirstEntity")
@DiscriminatorValue("B")
public class SingleTableInheritanceSecondEntity
        extends SingleTableInheritanceRootEntity {

    @Column(name = "field_b")
    private Long field_b;

    public SingleTableInheritanceSecondEntity() {
        super();
    }

    public final Long getField_b() {
        return field_b;
    }

    public final void setField_b(final Long field_b) {
        this.field_b = field_b;
    }

}
