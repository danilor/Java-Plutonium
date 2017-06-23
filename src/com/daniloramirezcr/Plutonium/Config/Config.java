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
package com.daniloramirezcr.Plutonium.Config;

import com.daniloramirezcr.Plutonium.Util.Console;
import java.util.Map;

/**
 * This class will handle the configuration file
 * @author danilo.ramirez
 */
public class Config {
    /**
     * Indicates the name of the configuration file
     */
    
        private INIReader reader;
    
        public static final String INI_FILE = "plutonium";
        /**
         * Indicates the extension of the configuration file
         */
        public static final String INI_EXTENSION = ".ini";

        private Map<String,String> attributes;
        
        /**
         * The config constructor. It will try to read the information on the ini file when
         * being built
         */
    public Config() {
        this.reader = new INIReader( INI_FILE + INI_EXTENSION );
        try{
            this.attributes = reader.read();
        }catch(Exception err){
            Console.e(err.getLocalizedMessage());
        }
    }

    /**
     * Gets the attributes
     * @param attributes 
     */
    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    /**
     * Gets the INIReader
     * @return 
     */
    public INIReader getReader() {
        return reader;
    }
    
    
    /**
     * Returns true if a configuration element exists
     * @param key
     * @return 
     */
    public boolean exist( String key ){
        return this.attributes.containsKey(key);
    }
    
    /**
     * Returns the value of a key. If it does not exist, then it will return an empty string
     * @param key
     * @return 
     */
    public String get( String key ){
        if( this.exist(key) ){
            return String.valueOf( this.attributes.get(key) );
        }else{
            return String.valueOf("");
        }
    }   
}
