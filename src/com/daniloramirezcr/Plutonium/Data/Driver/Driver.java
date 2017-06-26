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
package com.daniloramirezcr.Plutonium.Data.Driver;

import java.sql.ResultSet;

/**
 * This is the Generic Driver
 * @author danilo.ramirez
 */
public abstract class Driver {
    public String connectionString;
    
    public static String CONNECTION_INITIAL = "jdbc:sqlite:";
    /**
     * Information to connect to the database
     */
    protected String location = "", username = "", password = "", dname = "";
    
    
    /**
     * The table name
     */
    protected String table = "";
    
   

    /**
     * Gets the location
     * @return 
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location
     * @param location 
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets the username
     * @return 
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username
     * @param username 
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password
     * @return 
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the database name
     * @return 
     */
    public String getDname() {
        return dname;
    }

    /**
     * Sets the database name
     * @param dname 
     */
    public void setDname(String dname) {
        this.dname = dname;
    }
    /**
     * This will be the main method where the users executes the querys
     * @param query 
     */
    abstract public ResultSet query( String query ) throws Exception;
    
    public abstract java.sql.Connection connect() throws Exception;
    
    
}
