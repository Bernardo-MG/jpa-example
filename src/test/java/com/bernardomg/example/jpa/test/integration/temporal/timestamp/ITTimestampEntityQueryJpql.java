/**
 * The MIT License (MIT)
 * <p>
 * Copyright (c) 2016-2019 the the original author or authors.
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

package com.bernardomg.example.jpa.test.integration.temporal.timestamp;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Query;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit.jupiter.EnabledIf;

import com.bernardomg.example.jpa.model.temporal.TimestampEntity;
import com.bernardomg.example.jpa.test.util.test.integration.AbstractITEntityQuery;

/**
 * Integration tests for a {@code TimestampEntity} testing it loads values
 * correctly by using JPQL queries.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
@EnabledIf(expression = "#{!'${jpa.adapter.class}'.contains('Hibernate')}",
        reason = "Supports persisted timestamp", loadContext = true)
public class ITTimestampEntityQueryJpql
        extends AbstractITEntityQuery<TimestampEntity> {

    /**
     * Calendar for the test ranges.
     */
    private Calendar     calendar;

    /**
     * Java date for the test ranges.
     */
    private Date         date;

    /**
     * The query to acquire all the after a date, using the calendar.
     */
    @Value("${query.afterTimestamp.calendar}")
    private String       findAfterTimestampCalendar;

    /**
     * The query to acquire all the after a date, using the Java date.
     */
    @Value("${query.afterTimestamp.java}")
    private String       findAfterTimestampJava;

    /**
     * The query to acquire all the after a date, using the SQL date.
     */
    @Value("${query.afterTimestamp.sql}")
    private String       findAfterTimestampSql;

    /**
     * The query to acquire all the before a date, using the calendar.
     */
    @Value("${query.beforeTimestamp.calendar}")
    private String       findBeforeTimestampCalendar;

    /**
     * The query to acquire all the before a date, using the Java date.
     */
    @Value("${query.beforeTimestamp.java}")
    private String       findBeforeTimestampJava;

    /**
     * The query to acquire all the before a date, using the SQL date.
     */
    @Value("${query.beforeTimestamp.sql}")
    private String       findBeforeTimestampSql;

    /**
     * The query to acquire all the before a date, using the calendar.
     */
    @Value("${query.inTimestamp.calendar}")
    private String       findInTimestampCalendar;

    /**
     * The query to acquire all the before a date, using the Java date.
     */
    @Value("${query.inTimestamp.java}")
    private String       findInTimestampJava;

    /**
     * The query to acquire all the before a date, using the SQL date.
     */
    @Value("${query.inTimestamp.sql}")
    private String       findInTimestampSql;

    /**
     * Timestamp for the test ranges.
     */
    private Timestamp    timestamp;

    /**
     * String to generate the timestamp for the test ranges.
     */
    private final String timestampString = "1991-05-02 11:11:11";

    /**
     * Default constructor.
     */
    public ITTimestampEntityQueryJpql() {
        super();
    }

    /**
     * Initializes the timestamp to be used in the tests.
     *
     * @throws ParseException
     *             if the timestamp string can't be parsed
     */
    @BeforeEach
    public final void setUpDate() throws ParseException {
        final DateFormat format; // Format for parsing the timestamp string

        format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);

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
    public final void testGetAfterTime_Calendar() {
        final Integer count; // Number of entities expected

        // Expected result
        count = 3;

        assertResultSizeEquals(count, getAfterTimeCalendarQuery());
    }

    /**
     * Tests that retrieving all the entities after a timestamp gives the
     * correct number of them when using a Java {@code Date} for the timestamp.
     */
    @Test
    public final void testGetAfterTime_Java() {
        final Integer count; // Number of entities expected

        // Expected result
        count = 3;

        assertResultSizeEquals(count, getAfterTimeJavaQuery());
    }

    /**
     * Tests that retrieving all the entities after a timestamp gives the
     * correct number of them when using a {@code Timestamp} for the timestamp.
     */
    @Test
    public final void testGetAfterTime_Sql() {
        final Integer count; // Number of entities expected

        // Expected result
        count = 3;

        assertResultSizeEquals(count, getAfterTimeSqlQuery());
    }

    /**
     * Tests that retrieving all the entities before a timestamp gives the
     * correct number of them when using a {@code Calendar} for the timestamp.
     */
    @Test
    public final void testGetBeforeTime_Calendar() {
        final Integer count; // Number of entities expected

        // Expected result
        count = 2;

        assertResultSizeEquals(count, getBeforeTimeCalendarQuery());
    }

    /**
     * Tests that retrieving all the entities before a timestamp gives the
     * correct number of them when using a Java {@code Date} for the timestamp.
     */
    @Test
    public final void testGetBeforeTime_Java() {
        final Integer count; // Number of entities expected

        // Expected result
        count = 2;

        assertResultSizeEquals(count, getBeforeTimeJavaQuery());
    }

    /**
     * Tests that retrieving all the entities before a timestamp gives the
     * correct number of them when using a {@code Timestamp} for the timestamp.
     */
    @Test
    public final void testGetBeforeTime_Sql() {
        final Integer count; // Number of entities expected

        // Expected result
        count = 2;

        assertResultSizeEquals(count, getBeforeTimeSqlQuery());
    }

    /**
     * Tests that retrieving all the entities in a timestamp gives the correct
     * number of them when using a {@code Calendar} for the timestamp.
     */
    @Test
    public final void testGetInTime_Calendar() {
        final Integer count; // Number of entities expected

        // Expected result
        count = 1;

        assertResultSizeEquals(count, getInTimeCalendarQuery());
    }

    /**
     * Tests that retrieving all the entities in a timestamp gives the correct
     * number of them when using a Java {@code Date} for the timestamp.
     */
    @Test
    public final void testGetInTime_Java() {
        final Integer count; // Number of entities expected

        // Expected result
        count = 1;

        assertResultSizeEquals(count, getInTimeJavaQuery());
    }

    /**
     * Tests that retrieving all the entities in a timestamp gives the correct
     * number of them when using a {@code Timestamp} for the timestamp.
     */
    @Test
    public final void testGetInTime_Sql() {
        final Integer count; // Number of entities expected

        // Expected result
        count = 1;

        assertResultSizeEquals(count, getInTimeSqlQuery());
    }

    /**
     * Returns the query for the test.
     * 
     * @return the query for the test
     */
    private final Query getAfterTimeCalendarQuery() {
        final Query query;

        query = getQuery(findAfterTimestampCalendar);
        query.setParameter("timestamp", calendar);

        return query;
    }

    /**
     * Returns the query for the test.
     * 
     * @return the query for the test
     */
    private final Query getAfterTimeJavaQuery() {
        final Query query;

        query = getQuery(findAfterTimestampJava);
        query.setParameter("timestamp", date);

        return query;
    }

    /**
     * Returns the query for the test.
     * 
     * @return the query for the test
     */
    private final Query getAfterTimeSqlQuery() {
        final Query query;

        query = getQuery(findAfterTimestampSql);
        query.setParameter("timestamp", timestamp);

        return query;
    }

    /**
     * Returns the query for the test.
     * 
     * @return the query for the test
     */
    private final Query getBeforeTimeCalendarQuery() {
        final Query query;

        query = getQuery(findBeforeTimestampCalendar);
        query.setParameter("timestamp", calendar);

        return query;
    }

    /**
     * Returns the query for the test.
     * 
     * @return the query for the test
     */
    private final Query getBeforeTimeJavaQuery() {
        final Query query;

        query = getQuery(findBeforeTimestampJava);
        query.setParameter("timestamp", date);

        return query;
    }

    /**
     * Returns the query for the test.
     * 
     * @return the query for the test
     */
    private final Query getBeforeTimeSqlQuery() {
        final Query query;

        query = getQuery(findBeforeTimestampSql);
        query.setParameter("timestamp", timestamp);

        return query;
    }

    /**
     * Returns the query for the test.
     * 
     * @return the query for the test
     */
    private final Query getInTimeCalendarQuery() {
        final Query query;

        query = getQuery(findInTimestampCalendar);
        query.setParameter("timestamp", calendar);

        return query;
    }

    /**
     * Returns the query for the test.
     * 
     * @return the query for the test
     */
    private final Query getInTimeJavaQuery() {
        final Query query;

        query = getQuery(findInTimestampJava);
        query.setParameter("timestamp", date);

        return query;
    }

    /**
     * Returns the query for the test.
     * 
     * @return the query for the test
     */
    private final Query getInTimeSqlQuery() {
        final Query query;

        query = getQuery(findInTimestampSql);
        query.setParameter("timestamp", timestamp);

        return query;
    }

}
