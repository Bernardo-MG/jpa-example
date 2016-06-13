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
 * Configuration class for the test properties files.
 * <p>
 * These contain generic data required in several tests.
 *
 * @author Bernardo Martínez Garrido
 */
public class TestPropertiesConfig {

    /**
     * Boolean converter entity.
     */
    public static final String BOOLEAN_CONVERTER            = "classpath:config/entity/test-boolean-converter-entity.properties";

    /**
     * Class Id entity.
     */
    public static final String CLASS_ID                     = "classpath:config/entity/test-classid-entity.properties";

    /**
     * Collection entity.
     */
    public static final String COLLECTION                   = "classpath:config/entity/test-collection-entity.properties";

    /**
     * Date entity.
     */
    public static final String DATE                         = "classpath:config/entity/test-date-entity.properties";

    /**
     * Element collection entity.
     */
    public static final String ELEMENT_COLLECTION           = "classpath:config/entity/test-element-collection-entity.properties";

    /**
     * Embedded data entity.
     */
    public static final String EMBEDDED                     = "classpath:config/entity/test-embedded-entity.properties";

    /**
     * Enumeration entity.
     */
    public static final String ENUMERATION                  = "classpath:config/entity/test-enumeration-entity.properties";

    /**
     * Map entity.
     */
    public static final String MAP                          = "classpath:config/entity/test-map-entity.properties";

    /**
     * Multiple table inheritance value entity.
     */
    public static final String MULTIPLE_INHERITANCE_VALUE   = "classpath:config/entity/test-multiple-table-inheritance-value-entity.properties";

    /**
     * Segregated table inheritance value entity.
     */
    public static final String SEGREGATED_INHERITANCE_VALUE = "classpath:config/entity/test-segregated-table-inheritance-value-entity.properties";

    /**
     * Simple entity.
     */
    public static final String SIMPLE_ENTITY                = "classpath:config/entity/test-simple-entity.properties";

    /**
     * Single table inheritance value entity.
     */
    public static final String SINGLE_INHERITANCE_VALUE     = "classpath:config/entity/test-single-table-inheritance-value-entity.properties";

    /**
     * Superclass table inheritance value entity.
     */
    public static final String SUPERCLASS_INHERITANCE_VALUE = "classpath:config/entity/test-superclass-table-inheritance-value-entity.properties";

    /**
     * Time entity.
     */
    public static final String TIME                         = "classpath:config/entity/test-time-entity.properties";

    /**
     * Timestamp entity.
     */
    public static final String TIMESTAMP                    = "classpath:config/entity/test-timestamp-entity.properties";

    /**
     * Private constructor to avoid initialization.
     */
    private TestPropertiesConfig() {
        super();
    }

}
