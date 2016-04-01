
package com.wandrell.example.jpa.model.type;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.common.base.MoreObjects;

@Entity(name = "DatesEntity")
@Table(name = "dates_entities")
public final class DatesEntity {

    @Temporal(TemporalType.DATE)
    @Column(name = "calendar_date", nullable = false)
    private Calendar      calendarDate;

    @Temporal(TemporalType.TIME)
    @Column(name = "calendar_time", nullable = false)
    private Calendar      calendarTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "calendar_timestamp", nullable = false)
    private Calendar      calendarTimestamp;

    /**
     * Entity's ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer       id = null;

    @Temporal(TemporalType.DATE)
    @Column(name = "java_date", nullable = false)
    private Date          javaDate;

    @Temporal(TemporalType.TIME)
    @Column(name = "java_time", nullable = false)
    private Date          javaTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "java_timestamp", nullable = false)
    private Date          javaTimestamp;

    @Column(name = "sql_date", nullable = false)
    private java.sql.Date sqlDate;

    @Column(name = "sql_time", nullable = false)
    private Time          sqlTime;

    @Column(name = "sql_timestamp", nullable = false)
    private Timestamp     sqlTimestamp;

    public DatesEntity() {
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

        final DatesEntity other = (DatesEntity) obj;
        return Objects.equals(id, other.id);
    }

    public final Calendar getCalendarDate() {
        return calendarDate;
    }

    public final Calendar getCalendarTime() {
        return calendarTime;
    }

    public final Calendar getCalendarTimestamp() {
        return calendarTimestamp;
    }

    public final Integer getId() {
        return id;
    }

    public final Date getJavaDate() {
        return javaDate;
    }

    public final Date getJavaTime() {
        return javaTime;
    }

    public final Date getJavaTimestamp() {
        return javaTimestamp;
    }

    public final java.sql.Date getSqlDate() {
        return sqlDate;
    }

    public final Time getSqlTime() {
        return sqlTime;
    }

    public final Timestamp getSqlTimestamp() {
        return sqlTimestamp;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(id);
    }

    public final void setCalendarDate(final Calendar calendarDate) {
        this.calendarDate = calendarDate;
    }

    public final void setCalendarTime(final Calendar calendarTime) {
        this.calendarTime = calendarTime;
    }

    public final void setCalendarTimestamp(final Calendar calendarTimestamp) {
        this.calendarTimestamp = calendarTimestamp;
    }

    public final void setId(final Integer id) {
        this.id = id;
    }

    public final void setJavaDate(final Date javaDate) {
        this.javaDate = javaDate;
    }

    public final void setJavaTime(final Date javaTime) {
        this.javaTime = javaTime;
    }

    public final void setJavaTimestamp(final Date javaTimestamp) {
        this.javaTimestamp = javaTimestamp;
    }

    public final void setSqlDate(final java.sql.Date sqlDate) {
        this.sqlDate = sqlDate;
    }

    public final void setSqlTime(final Time sqlTime) {
        this.sqlTime = sqlTime;
    }

    public final void setSqlTimestamp(final Timestamp sqlTimestamp) {
        this.sqlTimestamp = sqlTimestamp;
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("id", id).toString();
    }

}