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

/**
 * This class will work as a Common class for everything related to the sites
 * @author danilo.ramirez
 */
public class Common {
    
    /**
     * This will join the strings using a separator
     * @param arr
     * @param separator
     * @return 
     */
    public static String stringJoin(Object[] arr, String separator) {
        if (null == arr || 0 == arr.length) return "";
        StringBuilder sb = new StringBuilder(512);
        sb.append(String.valueOf(arr[0]));
        //if (arr.length == 1) return sb.toString();
        for (int i = 1; i < arr.length; i++) sb.append(separator).append(String.valueOf(arr[i]));
        return sb.toString();
    }
}
