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

import com.daniloramirezcr.Plutonium.Data.Origin;
import com.daniloramirezcr.Plutonium.Util.Console;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class will extend the origin parent.
 * Will work as a main source connection for the SQL Lite database
 * @author danilo.ramirez
 */
public class SqlLite extends Driver
{
    
    
    /**
     * Constructor
     * @param path
     * @param name
     */
    public SqlLite( String path , String name ) {
        // For the SQL Lite we are using only the database name and location to built the connection string
        this.setDname(name); 
        this.setLocation(path);
        this.constructConnectionString();
    }
    
    /**
     * It constructs the path and returns it.
     */
    private String constructConnectionString(){
        
        String auxLocation = "";
        if( this.getLocation() != "" ){
            auxLocation = this.getLocation() + File.separator;
        }
        
        File f = new File( this.getDname() );
        if( !f.exists() ){
            System.out.println("File does not exist");
        }

        this.connectionString = auxLocation + this.getDname();
        return CONNECTION_INITIAL + this.connectionString.toString(); // I don't care if it is redundant, we can re use this later for another purpose.
    }
    
    
    public Connection connect() throws Exception{
         String url = this.constructConnectionString();
         Connection conn = null;
         try {
            conn = DriverManager.getConnection(url);
         }catch (SQLException e) {
            throw new Exception(e.getLocalizedMessage());
        }
         
         return conn;
         
    }

    /**
     * This method will execute the formed query
     * @param query 
     */
    @Override
    public ResultSet query(String query) throws Exception {
        try{
            Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement( query );
             ResultSet rs  = pstmt.executeQuery();
             return rs;
        }catch(Error | Exception err){
            throw new Exception( "Query could not be executed: " + query );
        }
    }
}
