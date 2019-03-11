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

package com.bernardomg.example.jpa.test.integration.temporal.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Query;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import com.bernardomg.example.jpa.model.temporal.DateEntity;
import com.bernardomg.example.jpa.test.util.test.integration.AbstractITEntityQuery;

/**
 * Integration tests for a {@code DateEntity} testing it loads values correctly
 * by using JPQL queries.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Disabled("Entities not supported by Hibernate")
public class ITDateEntityQueryJpql extends AbstractITEntityQuery<DateEntity> {

    /**
     * Calendar for the test ranges.
     */
    private Calendar      calendar;

    /**
     * Java date for the test ranges.
     */
    private Date          date;

    /**
     * String to generate the date for the test ranges.
     */
    private final String  dateString = "1991-05-02";

    /**
     * The query to acquire all the after a date, using the calendar.
     */
    @Value("${query.afterDate.calendar}")
    private String        findAfterDateCalendar;

    /**
     * The query to acquire all the after a date, using the Java date.
     */
    @Value("${query.afterDate.java}")
    private String        findAfterDateJava;

    /**
     * The query to acquire all the after a date, using the SQL date.
     */
    @Value("${query.afterDate.sql}")
    private String        findAfterDateSql;

    /**
     * The query to acquire all the before a date, using the calendar.
     */
    @Value("${query.beforeDate.calendar}")
    private String        findBeforeDateCalendar;

    /**
     * The query to acquire all the before a date, using the Java date.
     */
    @Value("${query.beforeDate.java}")
    private String        findBeforeDateJava;

    /**
     * The query to acquire all the before a date, using the SQL date.
     */
    @Value("${query.beforeDate.sql}")
    private String        findBeforeDateSql;

    /**
     * The query to acquire all the before a date, using the calendar.
     */
    @Value("${query.inDate.calendar}")
    private String        findInDateCalendar;

    /**
     * The query to acquire all the before a date, using the Java date.
     */
    @Value("${query.inDate.java}")
    private String        findInDateJava;

    /**
     * The query to acquire all the before a date, using the SQL date.
     */
    @Value("${query.inDate.sql}")
    private String        findInDateSql;

    /**
     * SQL date for the test ranges.
     */
    private java.sql.Date sqlDate;

    /**
     * Default constructor.
     */
    public ITDateEntityQueryJpql() {
        super();
    }

    /**
     * Initializes the date to be used in the tests.
     *
     * @throws ParseException
     *             if the date string can't be parsed
     */
    @BeforeEach
    public final void setUpDate() throws ParseException {
        final DateFormat format; // Format for parsing the date string

        format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        date = format.parse(dateString);

        sqlDate = new java.sql.Date(date.getTime());

        calendar = Calendar.getInstance();
        calendar.setTime(date);
    }

    /**
     * Tests that retrieving all the entities after a date gives the correct
     * number of them when using a {@code Calendar} for the date.
     */
    @Test
    public final void testGetAfterDate_Calendar() {
        final Integer count; // Number of entities expected

        // Expected result
        count = 3;

        assertResultSizeEquals(count, getAfterDateCalendarQuery());
    }

    /**
     * Tests that retrieving all the entities after a date gives the correct
     * number of them when using a Java {@code Date} for the date.
     */
    @Test
    public final void testGetAfterDate_Java() {
        final Integer count; // Number of entities expected

        // Expected result
        count = 3;

        assertResultSizeEquals(count, getAfterDateJavaQuery());
    }

    /**
     * Tests that retrieving all the entities after a date gives the correct
     * number of them when using a SQL {@code Date} for the date.
     */
    @Test
    public final void testGetAfterDate_Sql() {
        final Integer count; // Number of entities expected

        // Expected result
        count = 3;

        assertResultSizeEquals(count, getAfterDateSqlQuery());
    }

    /**
     * Tests that retrieving all the entities before a date gives the correct
     * number of them when using a {@code Calendar} for the date.
     */
    @Test
    public final void testGetBeforeDate_Calendar() {
        final Integer count; // Number of entities expected

        // Expected result
        count = 2;

        assertResultSizeEquals(count, getBeforeDateCalendarQuery());
    }

    /**
     * Tests that retrieving all the entities before a date gives the correct
     * number of them when using a Java {@code Date} for the date.
     */
    @Test
    public final void testGetBeforeDate_Java() {
        final Integer count; // Number of entities expected

        // Expected result
        count = 2;

        assertResultSizeEquals(count, getBeforeDateJavaQuery());
    }

    /**
     * Tests that retrieving all the entities before a date gives the correct
     * number of them when using a SQL {@code Date} for the date.
     */
    @Test
    public final void testGetBeforeDate_Sql() {
        final Integer count; // Number of entities expected

        // Expected result
        count = 2;

        assertResultSizeEquals(count, getBeforeDateSqlQuery());
    }

    /**
     * Tests that retrieving all the entities in a date gives the correct number
     * of them when using a {@code Calendar} for the date.
     */
    @Test
    public final void testGetInDate_Calendar() {
        final Integer count; // Number of entities expected

        // Expected result
        count = 1;

        assertResultSizeEquals(count, getInDateSqlCalendar());
    }

    /**
     * Tests that retrieving all the entities in a date gives the correct number
     * of them when using a Java {@code Date} for the date.
     */
    @Test
    public final void testGetInDate_Java() {
        final Integer count; // Number of entities expected

        // Expected result
        count = 1;

        assertResultSizeEquals(count, getInDateJavaQuery());
    }

    /**
     * Tests that retrieving all the entities in a date gives the correct number
     * of them when using a SQL {@code Date} for the date.
     */
    @Test
    public final void testGetInDate_Sql() {
        final Integer count; // Number of entities expected

        // Expected result
        count = 1;

        assertResultSizeEquals(count, getInDateSqlQuery());
    }

    /**
     * Returns the query for the test.
     * 
     * @return the query for the test
     */
    private final Query getAfterDateCalendarQuery() {
        final Query query;

        query = getQuery(findAfterDateCalendar);
        query.setParameter("date", calendar);

        return query;
    }

    /**
     * Returns the query for the test.
     * 
     * @return the query for the test
     */
    private final Query getAfterDateJavaQuery() {
        final Query query;

        query = getQuery(findAfterDateJava);
        query.setParameter("date", date);

        return query;
    }

    /**
     * Returns the query for the test.
     * 
     * @return the query for the test
     */
    private final Query getAfterDateSqlQuery() {
        final Query query;

        query = getQuery(findAfterDateSql);
        query.setParameter("date", sqlDate);

        return query;
    }

    /**
     * Returns the query for the test.
     * 
     * @return the query for the test
     */
    private final Query getBeforeDateCalendarQuery() {
        final Query query;

        query = getQuery(findBeforeDateCalendar);
        query.setParameter("date", calendar);

        return query;
    }

    /**
     * Returns the query for the test.
     * 
     * @return the query for the test
     */
    private final Query getBeforeDateJavaQuery() {
        final Query query;

        query = getQuery(findBeforeDateJava);
        query.setParameter("date", date);

        return query;
    }

    /**
     * Returns the query for the test.
     * 
     * @return the query for the test
     */
    private final Query getBeforeDateSqlQuery() {
        final Query query;

        query = getQuery(findBeforeDateSql);
        query.setParameter("date", sqlDate);

        return query;
    }

    /**
     * Returns the query for the test.
     * 
     * @return the query for the test
     */
    private final Query getInDateJavaQuery() {
        final Query query;

        query = getQuery(findInDateJava);
        query.setParameter("date", date);

        return query;
    }

    /**
     * Returns the query for the test.
     * 
     * @return the query for the test
     */
    private final Query getInDateSqlCalendar() {
        final Query query;

        query = getQuery(findInDateCalendar);
        query.setParameter("date", calendar);

        return query;
    }

    /**
     * Returns the query for the test.
     * 
     * @return the query for the test
     */
    private final Query getInDateSqlQuery() {
        final Query query;

        query = getQuery(findInDateSql);
        query.setParameter("date", sqlDate);

        return query;
    }

}
