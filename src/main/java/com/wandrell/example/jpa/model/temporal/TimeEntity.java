/**
 * The MIT License (MIT)
 * <p>
 * Copyright (c) 2016 the original author or authors.
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.wandrell.example.jpa.model.temporal;

import java.sql.Time;
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

@Entity(name = "TimeEntity")
@Table(name = "time_entities")
public final class TimeEntity {

    @Temporal(TemporalType.TIME)
    @Column(name = "calendar_time", nullable = false)
    private Calendar calendarTime;

    /**
     * Entity's ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer  id = null;

    @Temporal(TemporalType.TIME)
    @Column(name = "java_time", nullable = false)
    private Date     javaTime;

    @Column(name = "sql_time", nullable = false)
    private Time     sqlTime;

    public TimeEntity() {
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

        final TimeEntity other = (TimeEntity) obj;
        return Objects.equals(id, other.id);
    }

    public final Calendar getCalendarTime() {
        return calendarTime;
    }

    public final Integer getId() {
        return id;
    }

    public final Date getJavaTime() {
        return javaTime;
    }

    public final Time getSqlTime() {
        return sqlTime;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(id);
    }

    public final void setCalendarTime(final Calendar calendarTime) {
        this.calendarTime = calendarTime;
    }

    public final void setId(final Integer id) {
        this.id = id;
    }

    public final void setJavaTime(final Date javaTime) {
        this.javaTime = javaTime;
    }

    public final void setSqlTime(final Time sqlTime) {
        this.sqlTime = sqlTime;
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("id", id).toString();
    }

}
