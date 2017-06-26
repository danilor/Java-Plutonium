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

import com.daniloramirezcr.Plutonium.Config.Config;
import com.daniloramirezcr.Plutonium.Data.Driver.Driver;
import com.daniloramirezcr.Plutonium.Data.Driver.SqlLite;
import com.daniloramirezcr.Plutonium.Data.Exceptions.ConnectionException;
import com.daniloramirezcr.Plutonium.Plutonium;
import com.daniloramirezcr.Plutonium.Util.Common;
import com.daniloramirezcr.Plutonium.Util.Console;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 * This class represents the origin of the data
 * @author danilo.ramirez
 */
public class Origin{
   
    /**
     * The driver name
     */
    protected String driver_name = "";

    protected Driver driver;
    
    /**
     * The
     */
    public String table;
    
    /**
     * The list of fields
     */
    protected List<String> fields;

    /**
     * The list of where statements
     */
    protected List<Where> wheres;

    
    public Origin() {
        try{
            this.configDriver();
        }catch( Exception err ){
            Console.e( err.getMessage() );
            /**
             * We are not doing anything in the case of Exception. This
             * is because I don't want to halt the execution of this application.
             */
        }
        
        
    }
    
    
    private void configDriver() throws ConnectionException{
        /**
         * Depending on the given driver, we may build a different Connection Origin object or throw an exception
         */
        switch( Plutonium.getInstance().getConfiguration().get("DB_ORIGIN") ){
            case "sqllite":
                try{
                    // We build the SqlLite object
                    this.driver = new SqlLite( Config.getInstance().get("DB_LOCATION") , Config.getInstance().get("DB_NAME")  );
                }catch(Exception | Error err){
                    throw new ConnectionException( err.getLocalizedMessage() );
                }
               break;
            default:
                new ConnectionException( "Driver does not exist: " + driver );
                break;
        }
    }
    
    
    
    
    /**
     * Gets the driver name
     * @return 
     */
    public String getDriver_name() {
        return driver_name;
    }

    /**
     * Sets the driver name
     * @param driver_name 
     */
    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    /**
     * Gets the location
     * @return 
     */
    public String getLocation() {
        return this.driver.getLocation();
    }

    /**
     * Sets the location
     * @param location 
     */
    public void setLocation(String location) {
        this.driver.setLocation(location);
    }

    /**
     * Gets the username
     * @return 
     */
    public String getUsername() {
        return this.driver.getUsername();
    }

    /**
     * Sets the username
     * @param username 
     */
    public void setUsername(String username) {
        this.driver.setUsername(username);
    }

    /**
     * Gets the password
     * @return 
     */
    public String getPassword() {
        return this.driver.getPassword();
    }

    /**
     * Sets the password
     * @param password 
     */
    public void setPassword(String password) {
        this.driver.setPassword(password);
    }

    /**
     * Gets the database name
     * @return 
     */
    public String getDname() {
        return this.driver.getDname();
    }

    /**
     * Sets the database name
     * @param dname 
     */
    public void setDname(String dname) {
        this.driver.setDname(dname);
    }
    
    
    /**
     * This will set up the table
     * @param table
     * @return 
     */
    public Origin table( String table ) {
        //return this.table( table, new String[]{"*"} );
        this.fields = new ArrayList<>();
        this.wheres = new ArrayList();
        this.table = table;
        return this;
    }
    
    /**
     * Adds one single field
     * @param field
     * @return 
     */
    public Origin field( String field ){
        this.fields.add(field);
        return this;
    }
    
    /**
     * Adds one single where to the list
     * @param where
     * @return 
     */
    public Origin where( Where where ){
        this.wheres.add(where);
        return this;
    }
    
    /**
     * This will execute the query
     * @return
     * @throws Exception 
     */
    public ResultSet q() throws Exception{ 
        if( this.table.isEmpty() ){
            throw new Exception("Table must be added before use the get method");
        }
        
        String auxField = this.table + ".*"; // The default "Fields" value
        if( this.fields.size() > 0 ){
            /**
             * If there are fields to add, then we are going to 
             */
            auxField = "";
            String[] aux = new String[ this.fields.size() ];
            for( int i = 0 ; i < this.fields.size() ; i++ ){
                aux[ i ] = this.table + "." + String.valueOf( this.fields.get(i) );
            }
            auxField = Common.stringJoin(aux, ",");
        }
        String query = "SELECT " + auxField + " FROM " + this.table + " " + "";
        return this.driver.query(query);
    }
    
    
    /**
     * This will execute a query
     * @param table
     * @return 
     */
    //public ResultSet table( String table , String[] fields ) throws Exception{
    //    return this.table( table , fields , new Where[0] );
    //}
    
     /**
     * This will execute a query
     * @param table
     * @return 
     */
    //public ResultSet table( String table , String[] fields , Where[] where ) throws Exception{
        
        /**
         * We are going to add the parameter symbol to all the fields
         */
        //for( int i = 0 ; i < fields.length ; i++ ){
        //    fields[ i ] = table + "." + fields[ i ] + "";
        //}
        
        /**
         * We prepare the WHERE string in case is any
         */
        //String whereString = "";
        /**
         * We want to know if there is any where parameter to check
         */
        //if( where.length > 0 ){
            // If there is any, we are going to use them
        //}
        
        //String query = "SELECT " + Common.stringJoin(fields, table + ",") + " FROM " + table + " " + whereString;
        //return this.query(query);
    //}
    
    
    
    
    
  
}
