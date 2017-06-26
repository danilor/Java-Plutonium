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
import com.daniloramirezcr.Plutonium.Data.Driver.SqlLite;
import com.daniloramirezcr.Plutonium.Data.Exceptions.ConnectionException;
import com.daniloramirezcr.Plutonium.Plutonium;
import java.net.ConnectException;

/**
 * This is the connection class, and it should contain the Driver connector
 * @author danilo.ramirez
 */
public class Connection {
    
    private Origin connector;

    /**
     * This will create and set ready the connection class.
     * The only reason we are reading the driver string in here is because I want to throw an error if the driver is not accepted
     * @throws Error 
     */
    public Connection() throws ConnectionException
    {
    
        this.connector = new Origin( );
                
        
    }

    public Origin getConnector() {
        return connector;
    }
    
    
    
    
    
}
