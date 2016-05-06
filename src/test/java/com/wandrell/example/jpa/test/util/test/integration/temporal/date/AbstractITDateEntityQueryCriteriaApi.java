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

package com.wandrell.example.jpa.test.util.test.integration.temporal.date;

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

import com.wandrell.example.jpa.model.temporal.DateEntity;
import com.wandrell.example.jpa.test.util.criteria.temporal.DateEntityCriteriaFactory;

/**
 * Abstract integration tests for a {@link DateEntity} testing it can be queried
 * correctly by using criteria API queries.
 * <p>
 * The tests cases just show how to do query operations with a JPA entity by
 * using the criteria API.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>Retrieving all the entities before a date gives the correct number of
 * them when using a Java {@code Date} for the date</li>
 * <li>Retrieving all the entities before a date gives the correct number of
 * them when using a {@code Calendar} for the date</li>
 * <li>Retrieving all the entities before a date gives the correct number of
 * them when using a SQL {@code Date} for the date</li>
 * <li>Retrieving all the entities after a date gives the correct number of them
 * when using a Java {@code Date} for the date</li>
 * <li>Retrieving all the entities after a date gives the correct number of them
 * when using a {@code Calendar} for the date</li>
 * <li>Retrieving all the entities after a date gives the correct number of them
 * when using a SQL {@code Date} for the date</li>
 * <li>Retrieving all the entities in a date gives the correct number of them
 * when using a Java {@code Date} for the date</li>
 * <li>Retrieving all the entities in a date gives the correct number of them
 * when using a {@code Calendar} for the date</li>
 * <li>Retrieving all the entities in a date gives the correct number of them
 * when using a SQL {@code Date} for the date</li>
 * </ol>
 * <p>
 * This is meant to be used along a Spring context, which will set up the
 * repository and all of it's requirements.
 *
 * @author Bernardo Martínez Garrido
 * @see DateEntity
 */
public abstract class AbstractITDateEntityQueryCriteriaApi
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
     * String to generate the date for the test ranges.
     */
    private String        dateString = "1991-05-02";

    /**
     * The JPA entity manager.
     */
    @Autowired
    private EntityManager entityManager;

    /**
     * SQL date for the test ranges.
     */
    private java.sql.Date sqlDate;

    /**
     * Default constructor.
     */
    public AbstractITDateEntityQueryCriteriaApi() {
        super();
        // TODO: Add the date to the configuration files
        // TODO: Add the query results counts to the configuration files
    }

    /**
     * Initializes the date to be used in the tests.
     *
     * @throws ParseException
     *             if the date string can't be parsed
     */
    @BeforeClass
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
        Assert.assertEquals((Integer) getEntityManager()
                .createQuery(DateEntityCriteriaFactory
                        .findAfterDate(getEntityManager(), calendar))
                .getResultList().size(), new Integer(3));
    }

    /**
     * Tests that retrieving all the entities after a date gives the correct
     * number of them when using a Java {@code Date} for the date.
     */
    @Test
    public final void testGetAfterDate_Java() {
        Assert.assertEquals((Integer) getEntityManager()
                .createQuery(DateEntityCriteriaFactory
                        .findAfterDate(getEntityManager(), date))
                .getResultList().size(), new Integer(3));
    }

    /**
     * Tests that retrieving all the entities after a date gives the correct
     * number of them when using a SQL {@code Date} for the date.
     */
    @Test
    public final void testGetAfterDate_Sql() {
        Assert.assertEquals((Integer) getEntityManager()
                .createQuery(DateEntityCriteriaFactory
                        .findAfterSqlDate(getEntityManager(), sqlDate))
                .getResultList().size(), new Integer(3));
    }

    /**
     * Tests that retrieving all the entities before a date gives the correct
     * number of them when using a {@code Calendar} for the date.
     */
    @Test
    public final void testGetBeforeDate_Calendar() {
        Assert.assertEquals((Integer) getEntityManager()
                .createQuery(DateEntityCriteriaFactory
                        .findBeforeDate(getEntityManager(), calendar))
                .getResultList().size(), new Integer(2));
    }

    /**
     * Tests that retrieving all the entities before a date gives the correct
     * number of them when using a Java {@code Date} for the date.
     */
    @Test
    public final void testGetBeforeDate_Java() {
        Assert.assertEquals((Integer) getEntityManager()
                .createQuery(DateEntityCriteriaFactory
                        .findBeforeDate(getEntityManager(), date))
                .getResultList().size(), new Integer(2));
    }

    /**
     * Tests that retrieving all the entities before a date gives the correct
     * number of them when using a SQL {@code Date} for the date.
     */
    @Test
    public final void testGetBeforeDate_Sql() {
        Assert.assertEquals((Integer) getEntityManager()
                .createQuery(DateEntityCriteriaFactory
                        .findBeforeSqlDate(getEntityManager(), sqlDate))
                .getResultList().size(), new Integer(2));
    }

    /**
     * Tests that retrieving all the entities in a date gives the correct number
     * of them when using a {@code Calendar} for the date.
     */
    @Test
    public final void testGetInDate_Calendar() {
        Assert.assertEquals((Integer) getEntityManager()
                .createQuery(DateEntityCriteriaFactory
                        .findInDate(getEntityManager(), calendar))
                .getResultList().size(), new Integer(1));
    }

    /**
     * Tests that retrieving all the entities in a date gives the correct number
     * of them when using a Java {@code Date} for the date.
     */
    @Test
    public final void testGetInDate_Java() {
        Assert.assertEquals((Integer) getEntityManager()
                .createQuery(DateEntityCriteriaFactory
                        .findInDate(getEntityManager(), date))
                .getResultList().size(), new Integer(1));
    }

    /**
     * Tests that retrieving all the entities in a date gives the correct number
     * of them when using a SQL {@code Date} for the date.
     */
    @Test
    public final void testGetInDate_Sql() {
        Assert.assertEquals((Integer) getEntityManager()
                .createQuery(DateEntityCriteriaFactory
                        .findInSqlDate(getEntityManager(), sqlDate))
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
