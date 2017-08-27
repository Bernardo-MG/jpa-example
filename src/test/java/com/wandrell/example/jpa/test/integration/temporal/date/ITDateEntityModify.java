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

package com.wandrell.example.jpa.test.integration.temporal.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;

import com.wandrell.example.jpa.model.temporal.DateEntity;
import com.wandrell.example.jpa.test.util.config.context.TestContextConfig;
import com.wandrell.example.jpa.test.util.test.integration.AbstractITEntityModify;

/**
 * Integration tests for a {@code DateEntity} testing it can be modified.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
@ContextConfiguration(locations = { TestContextConfig.DEFAULT })
public final class ITDateEntityModify
        extends AbstractITEntityModify<DateEntity> {

    /**
     * Value to set on the date for the tests.
     */
    private final String dateString = "1900-01-02";

    /**
     * Default constructor.
     */
    public ITDateEntityModify() {
        super(DateEntity.class, 6);
    }

    @Override
    protected final void assertEntityModified(final DateEntity entity) {
        final DateFormat format; // Format for parsing the date string
        final Date date;         // Parsed date
        final Calendar calendar; // Parsed date as calendar

        format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        try {
            date = format.parse(dateString);
            calendar = Calendar.getInstance();
            calendar.setTime(date);

            Assert.assertEquals(entity.getDate(), date);
            Assert.assertEquals(entity.getCalendar(), calendar);
            Assert.assertEquals(entity.getSqlDate(),
                    new java.sql.Date(date.getTime()));
        } catch (final ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected final void modifyEntity(final DateEntity entity) {
        final DateFormat format; // Format for parsing the date string
        final Date date;         // Parsed date
        final Calendar calendar; // Parsed date as calendar

        format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        try {
            date = format.parse(dateString);
            calendar = Calendar.getInstance();
            calendar.setTime(date);

            entity.setCalendar(calendar);
            entity.setDate(date);
            entity.setSqlDate(new java.sql.Date(date.getTime()));
        } catch (final ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
