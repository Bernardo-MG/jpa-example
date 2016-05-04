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

import org.testng.Assert;

import com.wandrell.example.jpa.model.temporal.TimestampEntity;
import com.wandrell.example.jpa.test.util.test.integration.AbstractITEntityModify;

/**
 * Abstract integration tests for a {@link TimestampEntity} testing it can be
 * modified.
 *
 * @author Bernardo Martínez Garrido
 * @see TimestampEntity
 */
public abstract class AbstractITTimestampEntityModify
        extends AbstractITEntityModify<TimestampEntity> {

    /**
     * Value to set on the timestamp for the tests.
     */
    private final String timestampString = "1991-05-02 11:11:11";

    /**
     * Default constructor.
     */
    public AbstractITTimestampEntityModify() {
        super();
    }

    @Override
    protected final void assertEntityModified(final TimestampEntity entity) {
        final DateFormat format; // Format for parsing the timestamp string
        final Date date;         // Parsed timestamp
        final Calendar calendar; // Parsed timestamp as calendar

        format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);

        try {
            date = format.parse(timestampString);
            calendar = Calendar.getInstance();
            calendar.setTime(date);

            Assert.assertEquals(entity.getDate(), date);
            Assert.assertEquals(entity.getCalendar(), calendar);
            Assert.assertEquals(entity.getSqlTimestamp(),
                    new Timestamp(date.getTime()));
        } catch (final ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected final void modifyEntity(final TimestampEntity entity) {
        final DateFormat format; // Format for parsing the timestamp string
        final Date date;         // Parsed timestamp
        final Calendar calendar; // Parsed timestamp as calendar

        format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);

        try {
            date = format.parse(timestampString);
            calendar = Calendar.getInstance();
            calendar.setTime(date);

            entity.setCalendar(calendar);
            entity.setDate(date);
            entity.setSqlTimestamp(new Timestamp(date.getTime()));
        } catch (final ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
