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
 * Paths to the queries properties files.
 * <p>
 * These files contain the JPQL queries used to get data from the persistence
 * context, but also some related data, such as the total number of entities.
 *
 * @author Bernardo Martínez Garrido
 */
public class QueryPropertiesPaths {

    /**
     * Boolean converter entity.
     */
    public static final String BOOLEAN_CONVERTER            = "classpath:config/persistence/query/test-boolean-converter-entity-query.properties";

    /**
     * Collection entity.
     */
    public static final String COLLECTION                   = "classpath:config/persistence/query/test-collection-entity-query.properties";

    /**
     * Date entity.
     */
    public static final String DATE                         = "classpath:config/persistence/query/test-date-entity-query.properties";

    /**
     * Element collection entity.
     */
    public static final String ELEMENT_COLLECTION           = "classpath:config/persistence/query/test-element-collection-entity-query.properties";

    /**
     * Embedded data entity.
     */
    public static final String EMBEDDED                     = "classpath:config/persistence/query/test-embedded-entity-query.properties";

    /**
     * Enumeration entity.
     */
    public static final String ENUMERATION                  = "classpath:config/persistence/query/test-enumeration-entity-query.properties";

    /**
     * Collection entity.
     */
    public static final String MAP                          = "classpath:config/persistence/query/test-map-entity-query.properties";

    /**
     * Multiple table inheritance value entity.
     */
    public static final String MULTIPLE_INHERITANCE_VALUE   = "classpath:config/persistence/query/test-multiple-table-inheritance-value-entity-query.properties";

    /**
     * Segregated table inheritance value entity.
     */
    public static final String SEGREGATED_INHERITANCE_VALUE = "classpath:config/persistence/query/test-segregated-table-inheritance-value-entity-query.properties";

    /**
     * Simple entity.
     */
    public static final String SIMPLE_ENTITY                = "classpath:config/persistence/query/test-simple-entity-query.properties";

    /**
     * Single table inheritance value entity.
     */
    public static final String SINGLE_INHERITANCE_VALUE     = "classpath:config/persistence/query/test-single-table-inheritance-value-entity-query.properties";

    /**
     * Superclass table inheritance value entity.
     */
    public static final String SUPERCLASS_INHERITANCE_VALUE = "classpath:config/persistence/query/test-superclass-table-inheritance-value-entity-query.properties";

    /**
     * Time entity.
     */
    public static final String TIME                         = "classpath:config/persistence/query/test-time-entity-query.properties";

    /**
     * Time entity.
     */
    public static final String TIMESTAMP                    = "classpath:config/persistence/query/test-timestamp-entity-query.properties";

    /**
     * Private constructor to avoid initialization.
     */
    private QueryPropertiesPaths() {
        super();
    }

}
