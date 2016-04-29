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

package com.wandrell.example.jpa.test.util.test.integration.temporal.time;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wandrell.example.jpa.model.simple.SimpleEntity;
import com.wandrell.example.jpa.model.temporal.TimeEntity;
import com.wandrell.example.jpa.test.util.criteria.TimeEntityCriteriaFactory;

/**
 * Abstract integration tests for a {@link TimeEntity} testing it can be queried
 * correctly by using criteria API queries.
 * <p>
 * The tests cases just show how to do query operations with a JPA entity by
 * using the criteria API.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>Retrieving all the entities before a time gives the correct number of
 * them when using a Java {@code Time} for the time</li>
 * <li>Retrieving all the entities before a time gives the correct number of
 * them when using a {@code Calendar} for the time</li>
 * <li>Retrieving all the entities before a time gives the correct number of
 * them when using a {@code Time} for the time</li>
 * <li>Retrieving all the entities after a time gives the correct number of them
 * when using a Java {@code Time} for the time</li>
 * <li>Retrieving all the entities after a time gives the correct number of them
 * when using a {@code Calendar} for the time</li>
 * <li>Retrieving all the entities after a time gives the correct number of them
 * when using a {@code Time} for the time</li>
 * <li>Retrieving all the entities in a time gives the correct number of them
 * when using a Java {@code Time} for the time</li>
 * <li>Retrieving all the entities in a time gives the correct number of them
 * when using a {@code Calendar} for the time</li>
 * <li>Retrieving all the entities in a time gives the correct number of them
 * when using a {@code Time} for the time</li>
 * </ol>
 * <p>
 * This is meant to be used along a Spring context, which will set up the
 * repository and all of it's requirements.
 *
 * @author Bernardo Martínez Garrido
 * @see SimpleEntity
 */
public abstract class AbstractITTimeEntityQueryCriteriaApi
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
     * Time for the test ranges.
     */
    private Time          time;

    /**
     * String to generate the time for the test ranges.
     */
    private String        timeString = "11:11:11";

    /**
     * Default constructor.
     */
    public AbstractITTimeEntityQueryCriteriaApi() {
        super();
        // TODO: Add the time to the configuration files
        // TODO: Add the query results counts to the configuration files
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
    public final void testGetAfterTime_Calendar() {
        Assert.assertEquals((Integer) getEntityManager()
                .createQuery(TimeEntityCriteriaFactory
                        .findAfterTime(getEntityManager(), calendar))
                .getResultList().size(), new Integer(3));
    }

    /**
     * Tests that retrieving all the entities after a time gives the correct
     * number of them when using a Java {@code Time} for the time.
     */
    @Test
    public final void testGetAfterTime_Java() {
        Assert.assertEquals((Integer) getEntityManager()
                .createQuery(TimeEntityCriteriaFactory
                        .findAfterTime(getEntityManager(), date))
                .getResultList().size(), new Integer(3));
    }

    /**
     * Tests that retrieving all the entities after a time gives the correct
     * number of them when using a {@code Time} for the time.
     */
    @Test
    public final void testGetAfterTime_Sql() {
        Assert.assertEquals((Integer) getEntityManager()
                .createQuery(TimeEntityCriteriaFactory
                        .findAfterSqlTime(getEntityManager(), time))
                .getResultList().size(), new Integer(3));
    }

    /**
     * Tests that retrieving all the entities before a time gives the correct
     * number of them when using a {@code Calendar} for the time.
     */
    @Test
    public final void testGetBeforeTime_Calendar() {
        Assert.assertEquals((Integer) getEntityManager()
                .createQuery(TimeEntityCriteriaFactory
                        .findBeforeTime(getEntityManager(), calendar))
                .getResultList().size(), new Integer(2));
    }

    /**
     * Tests that retrieving all the entities before a time gives the correct
     * number of them when using a Java {@code Time} for the time.
     */
    @Test
    public final void testGetBeforeTime_Java() {
        Assert.assertEquals((Integer) getEntityManager()
                .createQuery(TimeEntityCriteriaFactory
                        .findBeforeTime(getEntityManager(), date))
                .getResultList().size(), new Integer(2));
    }

    /**
     * Tests that retrieving all the entities before a time gives the correct
     * number of them when using a {@code Time} for the time.
     */
    @Test
    public final void testGetBeforeTime_Sql() {
        Assert.assertEquals((Integer) getEntityManager()
                .createQuery(TimeEntityCriteriaFactory
                        .findBeforeSqlTime(getEntityManager(), time))
                .getResultList().size(), new Integer(2));
    }

    /**
     * Tests that retrieving all the entities in a time gives the correct number
     * of them when using a {@code Calendar} for the time.
     */
    @Test
    public final void testGetInTime_Calendar() {
        Assert.assertEquals((Integer) getEntityManager()
                .createQuery(TimeEntityCriteriaFactory
                        .findInTime(getEntityManager(), calendar))
                .getResultList().size(), new Integer(1));
    }

    /**
     * Tests that retrieving all the entities in a time gives the correct number
     * of them when using a Java {@code Time} for the time.
     */
    @Test
    public final void testGetInTime_Java() {
        Assert.assertEquals((Integer) getEntityManager()
                .createQuery(TimeEntityCriteriaFactory
                        .findInTime(getEntityManager(), date))
                .getResultList().size(), new Integer(1));
    }

    /**
     * Tests that retrieving all the entities in a time gives the correct number
     * of them when using a {@code Time} for the time.
     */
    @Test
    public final void testGetInTime_Sql() {
        Assert.assertEquals((Integer) getEntityManager()
                .createQuery(TimeEntityCriteriaFactory
                        .findInSqlTime(getEntityManager(), time))
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
