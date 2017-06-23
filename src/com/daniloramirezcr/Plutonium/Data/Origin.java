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

/**
 * This class represents the origin of the data
 * @author danilo.ramirez
 */
abstract public class Origin {
    
    /**
     * This method will be called to check the connection
     * @return boolean Indicating if the connection was successful or not
     */
    abstract public boolean checkConnection();
    
}
