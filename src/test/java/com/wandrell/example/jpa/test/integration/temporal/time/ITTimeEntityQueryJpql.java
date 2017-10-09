/**
 * The MIT License (MIT)
 * <p>
 * Copyright (c) 2016-2017 the the original author or authors.
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

package com.wandrell.example.jpa.test.integration.temporal.time;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import com.wandrell.example.jpa.test.util.test.integration.AbstractIntegrationTest;

/**
 * Integration tests for a {@code DateEntity} testing it loads values correctly
 * by using JPQL queries.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
public abstract class ITTimeEntityQueryJpql extends AbstractIntegrationTest {

    /**
     * Calendar for the test ranges.
     */
    private Calendar     calendar;

    /**
     * Java date for the test ranges.
     */
    private Date         date;

    /**
     * The query to acquire all the after a time, using the calendar.
     */
    @Value("${query.afterTime.calendar}")
    private String       findAfterTimeCalendar;

    /**
     * The query to acquire all the after a time, using the Java date.
     */
    @Value("${query.afterTime.java}")
    private String       findAfterTimeJava;

    /**
     * The query to acquire all the after a time, using the SQL time.
     */
    @Value("${query.afterTime.sql}")
    private String       findAfterTimeSql;

    /**
     * The query to acquire all the before a time, using the calendar.
     */
    @Value("${query.beforeTime.calendar}")
    private String       findBeforeDateCalendar;

    /**
     * The query to acquire all the before a time, using the Java date.
     */
    @Value("${query.beforeTime.java}")
    private String       findBeforeTimeJava;

    /**
     * The query to acquire all the before a time, using the SQL time.
     */
    @Value("${query.beforeTime.sql}")
    private String       findBeforeTimeSql;

    /**
     * The query to acquire all the before a time, using the calendar.
     */
    @Value("${query.inTime.calendar}")
    private String       findInTimeCalendar;

    /**
     * The query to acquire all the before a time, using the Java date.
     */
    @Value("${query.inTime.java}")
    private String       findInTimeJava;

    /**
     * The query to acquire all the before a time, using the SQL time.
     */
    @Value("${query.inTime.sql}")
    private String       findInTimeSql;

    /**
     * Time for the test ranges.
     */
    private Time         time;

    /**
     * String to generate the time for the test ranges.
     */
    private final String timeString = "11:11:11";

    /**
     * Default constructor.
     */
    public ITTimeEntityQueryJpql() {
        super();
    }

    /**
     * Initializes the time to be used in the tests.
     *
     * @throws ParseException
     *             if the time string can't be parsed
     */
    @Before
    public final void setUpDate() throws ParseException {
        final DateFormat format; // Format for parsing the time string

        format = new SimpleDateFormat("hh:mm:ss", Locale.ENGLISH);

        date = format.parse(timeString);

        time = new Time(date.getTime());

        calendar = Calendar.getInstance();
        calendar.setTime(date);
    }

    /**
     * Tests that retrieving all the entities after a time gives the correct
     * number of them when using a {@code Calendar} for the time.
     */
    @Test
    public final void testGetAfterDate_Calendar() {
        final Query query;         // Query for the entity

        // Builds the query
        query = getEntityManager().createQuery(findAfterTimeCalendar);
        query.setParameter("time", calendar);

        Assert.assertEquals((Integer) query.getResultList().size(),
                new Integer(3));
    }

    /**
     * Tests that retrieving all the entities after a time gives the correct
     * number of them when using a Java {@code Date} for the time.
     */
    @Test
    public final void testGetAfterDate_Java() {
        final Query query;         // Query for the entity

        // Builds the query
        query = getEntityManager().createQuery(findAfterTimeJava);
        query.setParameter("time", date);

        Assert.assertEquals((Integer) query.getResultList().size(),
                new Integer(3));
    }

    /**
     * Tests that retrieving all the entities after a time gives the correct
     * number of them when using a {@code Time} for the time.
     */
    @Test
    public final void testGetAfterDate_Sql() {
        final Query query;         // Query for the entity

        // Builds the query
        query = getEntityManager().createQuery(findAfterTimeSql);
        query.setParameter("time", time);

        Assert.assertEquals((Integer) query.getResultList().size(),
                new Integer(3));
    }

    /**
     * Tests that retrieving all the entities before a time gives the correct
     * number of them when using a {@code Calendar} for the time.
     */
    @Test
    public final void testGetBeforeDate_Calendar() {
        final Query query;         // Query for the entity

        // Builds the query
        query = getEntityManager().createQuery(findBeforeDateCalendar);
        query.setParameter("time", calendar);

        Assert.assertEquals((Integer) query.getResultList().size(),
                new Integer(2));
    }

    /**
     * Tests that retrieving all the entities before a time gives the correct
     * number of them when using a Java {@code Date} for the time.
     */
    @Test
    public final void testGetBeforeDate_Java() {
        final Query query;         // Query for the entity

        // Builds the query
        query = getEntityManager().createQuery(findBeforeTimeJava);
        query.setParameter("time", date);

        Assert.assertEquals((Integer) query.getResultList().size(),
                new Integer(2));
    }

    /**
     * Tests that retrieving all the entities before a time gives the correct
     * number of them when using a {@code Time} for the time.
     */
    @Test
    public final void testGetBeforeDate_Sql() {
        final Query query;         // Query for the entity

        // Builds the query
        query = getEntityManager().createQuery(findBeforeTimeSql);
        query.setParameter("time", time);

        Assert.assertEquals((Integer) query.getResultList().size(),
                new Integer(2));
    }

    /**
     * Tests that retrieving all the entities in a time gives the correct number
     * of them when using a {@code Calendar} for the time.
     */
    @Test
    public final void testGetInDate_Calendar() {
        final Query query;         // Query for the entity

        // Builds the query
        query = getEntityManager().createQuery(findInTimeCalendar);
        query.setParameter("time", calendar);

        Assert.assertEquals((Integer) query.getResultList().size(),
                new Integer(1));
    }

    /**
     * Tests that retrieving all the entities in a time gives the correct number
     * of them when using a Java {@code Date} for the time.
     */
    @Test
    public final void testGetInDate_Java() {
        final Query query;         // Query for the entity

        // Builds the query
        query = getEntityManager().createQuery(findInTimeJava);
        query.setParameter("time", date);

        Assert.assertEquals((Integer) query.getResultList().size(),
                new Integer(1));
    }

    /**
     * Tests that retrieving all the entities in a time gives the correct number
     * of them when using a {@code Time} for the time.
     */
    @Test
    public final void testGetInDate_Sql() {
        final Query query;         // Query for the entity

        // Builds the query
        query = getEntityManager().createQuery(findInTimeSql);
        query.setParameter("time", time);

        Assert.assertEquals((Integer) query.getResultList().size(),
                new Integer(1));
    }

}
