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

import java.util.Scanner;

/**
 * This class was made thinking on having a centralize way to manage
 * all console messages
 * @author danilo.ramirez
 */

public class Console {
    /**
     * This is the level character
     */
    public static final char LEVEL_ADD = '-';
    
    /**
     * This will print a one line message
     * @param t 
     */
    public static void l(String t){
        System.out.println( t );
    }
    
    /**
     * This will print a one line message with a level indicated
     * @param t
     * @param level 
     */
    public static void ll(String t , int level){
        String aux = "";
        for( int i = 0 ; i < level ; i++ ){
            aux += LEVEL_ADD;
        }
        System.out.println( aux + " " + t );
    }
    
    /**
     * This will print a message (no the one line)
     * @param t 
     */
    public static void w(String t){
        System.out.print( t );
    }
    
    /**
     * This will print an error message
     * @param t 
     */
    public static void e( String t ){
        System.err.println( t );
    }
    
    /**
     * This method will read an string from the user input
     * @param m The message will be showed to ask for the input of the user
     * @return 
     */
    public static String readString(String m){
        Console.w( m );
        Scanner scan= new Scanner(System.in);
        String text = scan.nextLine();
        return text;
    }
    /**
     * This will print a space line
     */
    public static void space(){
        System.out.println();
    }
    
    /**
     * This will print a space line X times
     * @param times The amount of empty lines to print
     */
    public static void space(int times){
        for( int i = 0 ; i < times ; i++ ){
            System.out.println();
        }
    }
}