/**
 * The MIT License (MIT)
 * <p>
 * Copyright (c) 2015 the original author or authors.
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

package com.wandrell.example.jpa.test.util.test.integration.temporal.timestamp;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wandrell.example.jpa.model.temporal.TimestampEntity;

/**
 * Abstract integration tests for a {@link TimestampEntity} testing it can be
 * queried correctly by using JPQL queries.
 * <p>
 * The tests cases just show how to do query operations with a JPA entity by
 * using the criteria API.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>Retrieving all the entities before a timestamp gives the correct number
 * of them when using a Java {@code Date} for the timestamp</li>
 * <li>Retrieving all the entities before a timestamp gives the correct number
 * of them when using a {@code Calendar} for the timestamp</li>
 * <li>Retrieving all the entities before a timestamp gives the correct number
 * of them when using a {@code Timestamp} for the timestamp</li>
 * <li>Retrieving all the entities after a timestamp gives the correct number of
 * them when using a Java {@code Date} for the timestamp</li>
 * <li>Retrieving all the entities after a timestamp gives the correct number of
 * them when using a {@code Calendar} for the timestamp</li>
 * <li>Retrieving all the entities after a timestamp gives the correct number of
 * them when using a {@code Timestamp} for the timestamp</li>
 * <li>Retrieving all the entities in a timestamp gives the correct number of
 * them when using a Java {@code Date} for the timestamp</li>
 * <li>Retrieving all the entities in a timestamp gives the correct number of
 * them when using a {@code Calendar} for the timestamp</li>
 * <li>Retrieving all the entities in a timestamp gives the correct number of
 * them when using a {@code Timestamp} for the timestamp</li>
 * </ol>
 * <p>
 * This is meant to be used along a Spring context, which will set up the
 * repository and all of it's requirements.
 *
 * @author Bernardo Martínez Garrido
 * @see TimestampEntity
 */
public abstract class AbstractITTimestampEntityQueryJpql
        extends AbstractTransactionalTestNGSpringContextTests {

    /**
     * Calendar for the test ranges.
     */
    private Calendar      calendar;

    /**
     * Java date for the test ranges.
     */
    private Date          date;

    /**
     * The JPA entity manager.
     */
    @Autowired
    private EntityManager entityManager;

    /**
     * The query to acquire all the after a date, using the calendar.
     */
    @Value("${query.afterTimestamp.calendar}")
    private String        findAfterTimestampCalendar;

    /**
     * The query to acquire all the after a date, using the Java date.
     */
    @Value("${query.afterTimestamp.java}")
    private String        findAfterTimestampJava;

    /**
     * The query to acquire all the after a date, using the SQL date.
     */
    @Value("${query.afterTimestamp.sql}")
    private String        findAfterTimestampSql;

    /**
     * The query to acquire all the before a date, using the calendar.
     */
    @Value("${query.beforeTimestamp.calendar}")
    private String        findBeforeTimestampCalendar;

    /**
     * The query to acquire all the before a date, using the Java date.
     */
    @Value("${query.beforeTimestamp.java}")
    private String        findBeforeTimestampJava;

    /**
     * The query to acquire all the before a date, using the SQL date.
     */
    @Value("${query.beforeTimestamp.sql}")
    private String        findBeforeTimestampSql;

    /**
     * The query to acquire all the before a date, using the calendar.
     */
    @Value("${query.inTimestamp.calendar}")
    private String        findInTimestampCalendar;

    /**
     * The query to acquire all the before a date, using the Java date.
     */
    @Value("${query.inTimestamp.java}")
    private String        findInTimestampJava;

    /**
     * The query to acquire all the before a date, using the SQL date.
     */
    @Value("${query.inTimestamp.sql}")
    private String        findInTimestampSql;

    /**
     * Timestamp for the test ranges.
     */
    private Timestamp     timestamp;

    /**
     * String to generate the timestamp for the test ranges.
     */
    private String        timestampString = "1991-05-02 11:11:11";

    /**
     * Default constructor.
     */
    public AbstractITTimestampEntityQueryJpql() {
        super();
        // TODO: Add the date to the configuration files
        // TODO: Add the query results counts to the configuration files
    }

    /**
     * Initializes the timestamp to be used in the tests.
     *
     * @throws ParseException
     *             if the timestamp string can't be parsed
     */
    @BeforeClass
    public final void setUpDate() throws ParseException {
        final DateFormat format; // Format for parsing the timestamp string

        format = new SimpleDateFormat("hh:mm:ss", Locale.ENGLISH);

        date = format.parse(timestampString);

        timestamp = new Timestamp(date.getTime());

        calendar = Calendar.getInstance();
        calendar.setTime(date);
    }

    /**
     * Tests that retrieving all the entities after a timestamp gives the
     * correct number of them when using a {@code Calendar} for the timestamp.
     */
    @Test
    public final void testGetAfterDate_Calendar() {
        final Query query;         // Query for the entity

        // Builds the query
        query = getEntityManager().createQuery(findAfterTimestampCalendar);
        query.setParameter("timestamp", calendar);

        Assert.assertEquals((Integer) query.getResultList().size(),
                new Integer(3));
    }

    /**
     * Tests that retrieving all the entities after a timestamp gives the
     * correct number of them when using a Java {@code Date} for the timestamp.
     */
    @Test
    public final void testGetAfterDate_Java() {
        final Query query;         // Query for the entity

        // Builds the query
        query = getEntityManager().createQuery(findAfterTimestampJava);
        query.setParameter("timestamp", date);

        Assert.assertEquals((Integer) query.getResultList().size(),
                new Integer(3));
    }

    /**
     * Tests that retrieving all the entities after a timestamp gives the
     * correct number of them when using a {@code Timestamp} for the timestamp.
     */
    @Test
    public final void testGetAfterDate_Sql() {
        final Query query;         // Query for the entity

        // Builds the query
        query = getEntityManager().createQuery(findAfterTimestampSql);
        query.setParameter("timestamp", timestamp);

        Assert.assertEquals((Integer) query.getResultList().size(),
                new Integer(3));
    }

    /**
     * Tests that retrieving all the entities before a timestamp gives the
     * correct number of them when using a {@code Calendar} for the timestamp.
     */
    @Test
    public final void testGetBeforeDate_Calendar() {
        final Query query;         // Query for the entity

        // Builds the query
        query = getEntityManager().createQuery(findBeforeTimestampCalendar);
        query.setParameter("timestamp", calendar);

        Assert.assertEquals((Integer) query.getResultList().size(),
                new Integer(2));
    }

    /**
     * Tests that retrieving all the entities before a timestamp gives the
     * correct number of them when using a Java {@code Date} for the timestamp.
     */
    @Test
    public final void testGetBeforeDate_Java() {
        final Query query;         // Query for the entity

        // Builds the query
        query = getEntityManager().createQuery(findBeforeTimestampJava);
        query.setParameter("timestamp", date);

        Assert.assertEquals((Integer) query.getResultList().size(),
                new Integer(2));
    }

    /**
     * Tests that retrieving all the entities before a timestamp gives the
     * correct number of them when using a {@code Timestamp} for the timestamp.
     */
    @Test
    public final void testGetBeforeDate_Sql() {
        final Query query;         // Query for the entity

        // Builds the query
        query = getEntityManager().createQuery(findBeforeTimestampSql);
        query.setParameter("timestamp", timestamp);

        Assert.assertEquals((Integer) query.getResultList().size(),
                new Integer(2));
    }

    /**
     * Tests that retrieving all the entities in a timestamp gives the correct
     * number of them when using a {@code Calendar} for the timestamp.
     */
    @Test
    public final void testGetInDate_Calendar() {
        final Query query;         // Query for the entity

        // Builds the query
        query = getEntityManager().createQuery(findInTimestampCalendar);
        query.setParameter("timestamp", calendar);

        Assert.assertEquals((Integer) query.getResultList().size(),
                new Integer(1));
    }

    /**
     * Tests that retrieving all the entities in a timestamp gives the correct
     * number of them when using a Java {@code Date} for the timestamp.
     */
    @Test
    public final void testGetInDate_Java() {
        final Query query;         // Query for the entity

        // Builds the query
        query = getEntityManager().createQuery(findInTimestampJava);
        query.setParameter("timestamp", date);

        Assert.assertEquals((Integer) query.getResultList().size(),
                new Integer(1));
    }

    /**
     * Tests that retrieving all the entities in a timestamp gives the correct
     * number of them when using a {@code Timestamp} for the timestamp.
     */
    @Test
    public final void testGetInDate_Sql() {
        final Query query;         // Query for the entity

        // Builds the query
        query = getEntityManager().createQuery(findInTimestampSql);
        query.setParameter("timestamp", timestamp);

        Assert.assertEquals((Integer) query.getResultList().size(),
                new Integer(1));
    }

    /**
     * Returns the JPA entity manager.
     *
     * @return the JPA entity manager
     */
    protected final EntityManager getEntityManager() {
        return entityManager;
    }

}
