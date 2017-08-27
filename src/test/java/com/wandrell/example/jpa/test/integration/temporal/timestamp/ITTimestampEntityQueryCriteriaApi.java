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

package com.wandrell.example.jpa.test.integration.temporal.timestamp;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wandrell.example.jpa.test.util.config.context.TestContextConfig;
import com.wandrell.example.jpa.test.util.criteria.temporal.TimestampEntityCriteriaFactory;

/**
 * Integration tests for a {@code TimestampEntity} testing it loads values
 * correctly by using the criteria API.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
@ContextConfiguration(locations = { TestContextConfig.DEFAULT })
public final class ITTimestampEntityQueryCriteriaApi
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
     * Timestamp for the test ranges.
     */
    private Timestamp     timestamp;

    /**
     * String to generate the time for the test ranges.
     */
    private final String  timestampString = "1991-05-02 11:11:11";

    /**
     * Default constructor.
     */
    public ITTimestampEntityQueryCriteriaApi() {
        super();
    }

    /**
     * Initializes the time to be used in the tests.
     *
     * @throws ParseException
     *             if the time string can't be parsed
     */
    @BeforeClass
    public final void setUpTime() throws ParseException {
        final DateFormat format; // Format for parsing the time string

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
        Assert.assertEquals((Integer) getEntityManager()
                .createQuery(TimestampEntityCriteriaFactory
                        .findAfterTimestamp(getEntityManager(), calendar))
                .getResultList().size(), new Integer(3));
    }

    /**
     * Tests that retrieving all the entities after a timestamp gives the
     * correct number of them when using a Java {@code Date} for the timestamp.
     */
    @Test
    public final void testGetAfterTime_Java() {
        Assert.assertEquals((Integer) getEntityManager()
                .createQuery(TimestampEntityCriteriaFactory
                        .findAfterTimestamp(getEntityManager(), date))
                .getResultList().size(), new Integer(3));
    }

    /**
     * Tests that retrieving all the entities after a timestamp gives the
     * correct number of them when using a {@code Timestamp} for the timestamp.
     */
    @Test
    public final void testGetAfterTime_Sql() {
        Assert.assertEquals((Integer) getEntityManager()
                .createQuery(TimestampEntityCriteriaFactory
                        .findAfterSqlTimestamp(getEntityManager(), timestamp))
                .getResultList().size(), new Integer(3));
    }

    /**
     * Tests that retrieving all the entities before a timestamp gives the
     * correct number of them when using a {@code Calendar} for the timestamp.
     */
    @Test
    public final void testGetBeforeTime_Calendar() {
        Assert.assertEquals((Integer) getEntityManager()
                .createQuery(TimestampEntityCriteriaFactory
                        .findBeforeTimestamp(getEntityManager(), calendar))
                .getResultList().size(), new Integer(2));
    }

    /**
     * Tests that retrieving all the entities before a timestamp gives the
     * correct number of them when using a Java {@code Date} for the timestamp.
     */
    @Test
    public final void testGetBeforeTime_Java() {
        Assert.assertEquals((Integer) getEntityManager()
                .createQuery(TimestampEntityCriteriaFactory
                        .findBeforeTimestamp(getEntityManager(), date))
                .getResultList().size(), new Integer(2));
    }

    /**
     * Tests that retrieving all the entities before a timestamp gives the
     * correct number of them when using a {@code Timestamp} for the timestamp.
     */
    @Test
    public final void testGetBeforeTime_Sql() {
        Assert.assertEquals((Integer) getEntityManager()
                .createQuery(TimestampEntityCriteriaFactory
                        .findBeforeSqlTimestamp(getEntityManager(), timestamp))
                .getResultList().size(), new Integer(2));
    }

    /**
     * Tests that retrieving all the entities in a timestamp gives the correct
     * number of them when using a {@code Calendar} for the timestamp.
     */
    @Test
    public final void testGetInTime_Calendar() {
        Assert.assertEquals((Integer) getEntityManager()
                .createQuery(TimestampEntityCriteriaFactory
                        .findInTimestamp(getEntityManager(), calendar))
                .getResultList().size(), new Integer(1));
    }

    /**
     * Tests that retrieving all the entities in a timestamp gives the correct
     * number of them when using a Java {@code Date} for the timestamp.
     */
    @Test
    public final void testGetInTime_Java() {
        Assert.assertEquals((Integer) getEntityManager()
                .createQuery(TimestampEntityCriteriaFactory
                        .findInTimestamp(getEntityManager(), date))
                .getResultList().size(), new Integer(1));
    }

    /**
     * Tests that retrieving all the entities in a timestamp gives the correct
     * number of them when using a {@code Timestamp} for the timestamp.
     */
    @Test
    public final void testGetInTime_Sql() {
        Assert.assertEquals((Integer) getEntityManager()
                .createQuery(TimestampEntityCriteriaFactory
                        .findInSqlTimestamp(getEntityManager(), timestamp))
                .getResultList().size(), new Integer(1));
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
