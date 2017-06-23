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
import com.daniloramirezcr.Plutonium.Util.FilePReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * This class will read .ini files and return the result as a map
 * @author danilo.ramirez
 */
public class INIReader {

    private String location;
    private Map<String,String> items;
    private File f;
    
    /**
     * The constructor for the INIReader
     */
    public INIReader( String l  ) {
        this.location = l;
        this.items = new HashMap<String, String>();
        
    }
    /**
     * This function will actually read the ini file.
     */
    public Map<String,String> read() throws Exception{
        this.f = new File( this.location );
        
        try{
            
             String[] lines = FilePReader.readLines(f);
             for( int i = 0 ; i < lines.length ; i++ ){
                 String[] parts = lines[ i ].split("=");
                if( parts.length == 2 ){
                    /**
                     * Its only valid if it has 2 sections
                     */
                    this.items.put( parts[0] , parts[1] );
                }
             } 
        }catch( IOException er ){
            /**
             * I guess we won't do anything if we cannot read the line actually.
             */
            Console.e(er.getLocalizedMessage());
        }
        return this.items;
    }

    public File getFile() {
        return f;
    }
    
    
    
    
    
    
    
    
    
}
