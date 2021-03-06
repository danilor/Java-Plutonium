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

import com.daniloramirezcr.Plutonium.Data.Origin;
import com.daniloramirezcr.Plutonium.Data.Where;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Map;

/**
 * This class should work as a base for all model objects. A model will be a data object that can, automatically,
 * fill its information. This is inspired on Laravel eloquent models, but without its full DB connection
 * since these models will work with only one single connection.
 * Most the the places where I described "tables", "rows" or "attributes" are actually data related, but that does
 * not mean the are actually from a table.
 * 
 * Since it extends the Origin class, it will has all query methods
 * @author danilo.ramirez
 */
abstract public class Model extends Origin{
    /**
     * The origin indicates the "table" where this model will take the information from
     */
    protected String origin = "";
    
    /**
     * This are going to be the dynamic "attributes" from each element of the "tables".
     */
    protected Map< String , Attribute > attributes;

    public Model(){
        
    }
 
    /**
     * Constructor
     */
    /*public Model( ) {
            this.initializeMap(); // Create the map object
    }*/
    
     /**
     * Constructor
     * If there comes with an ID, then we have to search for this ID in the table
     */
    /*public Model( int id ) throws Exception {
            this.initializeMap(); // Create the map object
            this.fillWithResultSet( this.table(this.origin).where(new Where("id",id)).q() );
    }*/
    
    public void find( int id ) throws Exception{
        
        this.table( this.origin );
        
        ///this.fillWithResultSet( this.table(this.origin).where(new Where("id",id)).q() );
    }
    
    /**
     * We are going to initialize the MAP
     */
    private void initializeMap(){
        /**
        * We initialize the Map structure if it has not been initialized
        */
        if( this.attributes == null ){
            this.attributes = new HashMap<String, Attribute>();
        }
    }
    
    
    private void fillWithResultSet( ResultSet rs ) throws Exception{
        
        ResultSetMetaData rsmd = rs.getMetaData();
        
        int totalColumns = rsmd.getColumnCount();
        
        while (rs.next()) {
                /*System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("name") + "\t" +
                                   rs.getDouble("capacity"));
                */
                for( int i = 0 ; i < totalColumns ; i ++ ){
                    this.addAttribute( String.valueOf( rsmd.getColumnName( i ) ) , String.valueOf( rs.getObject( rsmd.getColumnName( i ) ) )  );
                }
                
        }
    }
    /**
     * This will read one attribute.
     * If the attribute does not exist, we return only empty string.
     * TODO: see if there is a better way to return the NON EXISTING key
     * @return 
     */
    public Object read( String key ){
        if( this.attributes.containsKey( key ) ){
            return this.attributes.get( key ).getValueAsString();
        }else{
            return String.valueOf( "" );
        }
    }
    /**
     * 
     * @return 
     */
    public String getOrigin()  {
        return origin;
    }

    /**
     * 
     * @param origin 
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    
    /**
     * This will set a single attribute element
     * @param key
     * @param v 
     */
    public void addAttribute( String key , Object v){
        Attribute aux = new Attribute();
        aux.setValue(v);
        this.attributes.put(key, aux);
    }
    
    /**
     * Returns one single value in Attribute format
     * @param key
     * @return 
     */
    public Attribute getAttribute( String key){
        return this.attributes.get(key);
    }
   
}
