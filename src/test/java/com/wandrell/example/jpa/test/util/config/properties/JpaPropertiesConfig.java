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

package com.wandrell.example.jpa.test.util.config.properties;

/**
 * Configuration class for the test JPA properties files.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
public class JpaPropertiesConfig {

    /**
     * H2 database properties file.
     */
    public static final String H2         = "classpath:config/persistence/jpa/test-jpa-h2.properties";

    /**
     * HSQLDB database properties file.
     */
    public static final String HSQLDB     = "classpath:config/persistence/jpa/test-jpa-hsqldb.properties";

    /**
     * MySQL database properties file.
     */
    public static final String MYSQL      = "classpath:config/persistence/jpa/test-jpa-mysql.properties";

    /**
     * PostgreSQL database properties file.
     */
    public static final String POSTGRESQL = "classpath:config/persistence/jpa/test-jpa-postgresql.properties";

    /**
     * SQLite database properties file.
     */
    public static final String SQLITE     = "classpath:config/persistence/jpa/test-jpa-sqlite.properties";

    /**
     * Private constructor to avoid initialization.
     */
    private JpaPropertiesConfig() {
        super();
    }

}
