package com.fei.util;

import java.util.HashMap;

/**
 * @author Administrator
 *
 */
public class MySessionContext {
	
	 private static MySessionContext instance;    
	    private HashMap<String,Integer> mymap;    
	    private MySessionContext()    
	    {    
	        mymap = new HashMap<String,Integer>();    
	    }    
	    public static MySessionContext getInstance()    
	    {    
	        if(instance==null)    
	        {    
	            instance = new MySessionContext();    
	        }    
	        return instance;    
	    }    
	    public synchronized void AddSession(String key,int value)    
	    {    
	        if(key!=null)    
	        {    
	            mymap.put(key, value);    
	        }    
	    }    
	    public synchronized void DelSession(String key)    
	    {    
	        if(key!=null)    
	        {    
	            mymap.remove(key);    
	        }    
	    }    
	    public synchronized int getSession(String key)    
	    {    
	        if(key==null)return 0;    
	        return mymap.get(key);    
	    }    
}
