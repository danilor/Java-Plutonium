/*
 * Copyright 2017 Danilo Ramírez Mattey 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * Software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * 
 * All external libraries and coding that may be found here have their own license and restrictions.
 * 
 */
package com.daniloramirezcr.Plutonium.Data;

/**
 * This class represent a where statement
 * @author danilo.ramirez
 */
public class Where {
    
    public static String DEFAULT_COMPARISON = "=";
    
    /**
     * The field we are comparing
     */
    private String field;
    /**
     * The comparison type
     */
    private String comparison;
    
    /**
     * The value to compare
     */
    private Object value;

    /**
     * Gets the fields
     * @return 
     */
    public String getField() {
        return field;
    }

    /**
     * Sets the field
     * @param field 
     */
    public void setField(String field) {
        this.field = field;
    }

    /**
     * Gets the comparison
     * @return 
     */
    public String getComparison() {
        return comparison;
    }

    /**
     * Sets the comparison
     * @param comparison 
     */
    public void setComparison(String comparison) {
        this.comparison = comparison;
    }

    /**
     * Gets the value
     * @return 
     */
    public Object getValue() {
        return value;
    }

    /**
     * Sets the value
     * @param value 
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Simple constructor
     * @param field
     * @param value 
     */
    public Where(String field, Object value) {
        this.field = field;
        this.value = value;
        this.comparison = DEFAULT_COMPARISON;
    }

    /**
     * Constructor with comparison
     * @param field
     * @param comparison
     * @param value 
     */
    public Where(String field, String comparison, Object value) {
        this.field = field;
        this.comparison = comparison;
        this.value = value;
    }
    
}
