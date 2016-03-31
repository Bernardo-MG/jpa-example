
package com.wandrell.example.jpa.model.type;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.swing.ImageIcon;

import com.google.common.base.MoreObjects;

@Entity(name = "ImageIconEntity")
@Table(name = "image_icon_entities")
public class ImageIconEntity {

    /**
     * Entity's ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer   id = null;

    @Column(name = "picture", nullable = false)
    @Lob
    private ImageIcon picture;

    public ImageIconEntity() {
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

        final ImageIconEntity other = (ImageIconEntity) obj;
        return Objects.equals(id, other.id);
    }

    public final Integer getId() {
        return id;
    }

    public final ImageIcon getPicture() {
        return picture;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(id);
    }

    public final void setId(final Integer id) {
        this.id = id;
    }

    public final void setPicture(final ImageIcon picture) {
        this.picture = picture;
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("id", id).toString();
    }

}
