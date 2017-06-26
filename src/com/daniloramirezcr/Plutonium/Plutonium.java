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
package com.daniloramirezcr.Plutonium;

import com.daniloramirezcr.Plutonium.Config.Config;
import com.daniloramirezcr.Plutonium.Data.Connection;
import com.daniloramirezcr.Plutonium.Data.Origin;
import com.daniloramirezcr.Plutonium.Util.FilePReader;

/**
 * This is the framework main class.
 * It should work as singleton
 * @author danilo.ramirez
 */
public class Plutonium {

    /**
     * The plutonium object for the Singleton structure
     */
    private static Plutonium myObj;

    private static String logFolder = "logs";
    
    private Config configuration;
    private Connection dataOrigin;
    
    /**
     * Constructor
     */
    public Plutonium() throws Error{
        this.configuration = Config.getInstance();
        try{
            this.dataOrigin = new Connection( );
        }catch(Exception | Error err){
            /**
             * If it could not connect, we are only sending an error if we have to (I mean,
             * I am sending the error only if it it wants to use it)
             */
            this.dataOrigin =  null;
        }   
        /**
         * Now we are going to create a folder to store logs if need it.
         * We don't actually care if it was successful or not, so we are 
         * not doing anything with its response
         */
        FilePReader.createDir( logFolder );
        
    }
    
    /**
     * It returns the configuration object
     * @return 
     */
    public Config getConfiguration(){
        return this.configuration;
    }
    
    
    /**
     * It will return the connection object
     * @return 
     */
    public Connection connection() throws Error
    {
        /**
         * if it is null, that means that we could not success on a connection
         */
        if( this.dataOrigin == null ){
            throw new Error("Connection invalid");
        }
        return this.dataOrigin;
    }
    

    /**
     * Create a static method to get instance.
     * @return Plutonium the Plutonium 
     */
    public static Plutonium getInstance(){
        if(myObj == null){
            myObj = new Plutonium();
        }
        return myObj;
    }
}
