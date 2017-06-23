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

    
    private Config configuration;
    
    /**
     * Constructor
     */
    public Plutonium() {
        this.configuration = new Config();
    }
    
    
    /**
     * It returns the configuration object
     * @return 
     */
    public Config getConfiguration(){
        return this.configuration;
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
