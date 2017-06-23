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
package com.daniloramirezcr.Plutonium.Models;

/**
 * This will represent an attribute in the models
 * @author danilo.ramirez
 */
public class Attribute {
    
    /**
     * The actual value. We are using the type OBJECT because
     * we are not fully sure what information it is going to contain (neither its type)
     */
    private Object value;

    /**
     * The type of attribute
     */
    private int type = 0;
    
    /**
     * Constant for the type numeric
     */
    public static final int TYPE_NUMERIC = 1;
    
    /**
     * Constant for the type string
     */
    public static final int TYPE_STRING = 2;
    
    /**
     * Constant for the type float
     */
    public static final int TYPE_FLOAT = 3;
    
    /**
     * Constant for the type datetime
     */
    public static final int TYPE_DATETIME = 4;
    
    /**
     * Constructor
     */
    public Attribute() {
        
    }

    /**
     * Sets the value
     * @param value 
     */
    public void setValue(Object value) {
        this.value = value;
    }
   
    /**
     * Gets the value
     * @return 
     */
    public Object getValue(){
        return this.value;
    }
    
    /**
     * Returns the value in string format
     * @return 
     */
    public String getValueAsString(){
        return String.valueOf(this.getValue());
    }

    /**
     * Get the type of attribute
     * @return 
     */
    public int getType() {
        return type;
    }
    
    /**
     * Sets thte type of attribute
     * @param type 
     */
    public void setType(int type) {
        this.type = type;
    }
    
    
    
}
