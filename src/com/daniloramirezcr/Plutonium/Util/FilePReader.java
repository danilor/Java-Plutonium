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
package com.daniloramirezcr.Plutonium.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class should work as a FIle Reader
 * @author danilo.ramirez
 */
public class FilePReader {
    
    /**
     * It reads a file and return its all content in one single string
     * @param f
     * @return
     * @throws Exception 
     */
    public static String read( File f ) throws Exception
    {
        String aux = "";
        if( !f.exists() || f.isDirectory() ){
            throw new FileNotFoundException( "The file " + f.getAbsolutePath() + " does not exist or its invalid" );
        }
        
        /**
         * This sintax is actually new for me :O
         */
        try (BufferedReader br = new BufferedReader(new java.io.FileReader( f.getAbsolutePath() ))) {
            String line;
            
            while ((line = br.readLine()) != null) {
                aux += line + System.getProperty("line.separator"); // That line separator is the equivalent for the PHP_EOF magic constant
            }
        }catch( IOException er ){
            /**
             * I guess we won't do anything if we cannot read the line actually.
             */
            throw er; // I am not fully sure why I am doing this, but hey! In the future this can change
        }
        return aux;
    }
    
    /**
     * Read a file line by line and returns an array of the lines that were read
     * @param f
     * @return
     * @throws Exception 
     */
    public static String[] readLines( File f ) throws Exception
    {
        
        List<String> aux = new ArrayList<String>();
        
        if( !f.exists() || f.isDirectory() ){
            throw new FileNotFoundException( "The file " + f.getAbsolutePath() + " does not exist or its invalid" );
        }
        
        /**
         * This sintax is actually new for me :O
         */
        try (BufferedReader br = new BufferedReader(new java.io.FileReader( f.getAbsolutePath() ))) {
            String line;
            
            while ((line = br.readLine()) != null) {
               aux.add(line);// We add each line
            }
        }catch( IOException er ){
            /**
             * I guess we won't do anything if we cannot read the line actually.
             */
            Console.e(er.getLocalizedMessage());
            throw er; // I am not fully sure why I am doing this, but hey! In the future this can change
        }
         return ((List<String>)aux).toArray(new String[aux.size()]);
    }
    
    
    /**
     * Tries to create a directory, if it is success (or of it exist) it will return true, if not, it will return false
     * @param dir
     * @return 
     */
    public static boolean createDir( String dir ){
        File d = new File( dir );
        /**
         * If it already exist, return true
         */
        if( d.exists() && d.isDirectory() ){
            return true;
        }
       
        /**
         * if it does not exist, OR it exists but its a file, lets create it
         */
        if( !d.exists() || ( d.exists() && !d.isDirectory() ) ){
            try{
                d.mkdir();
                return true;
            }catch(Error | SecurityException se){
                Console.e("The directory could not be created: " + dir);
                return false;
            }  
        }
        
        return true;
    }
    
}
