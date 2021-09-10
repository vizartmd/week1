package com.servicedao.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

public class DynamicReflect {
    public static Object getInstance(String className,Map<String,Object> map)throws Exception{
        Class c = Class.forName(className);
        Object obj = c.newInstance();               //Object the object
        Set<String> keys = map.keySet();            //Gets all the corresponding properties
        Field[] fAll = c.getDeclaredFields();        //Gets all the properties in the class
        for(int i=0;i<fAll.length;i++){
            for(String key:keys){                    //Loop matching
                if(fAll[i].getName().equals(key)){    //If the user passes in a property that matches the property name in the obtained class
                    Field f = c.getDeclaredField(key);//Get the property
                    //Build the setXxx() method name
                    String methodName = "set" + key.substring(0,1).toUpperCase()+key.substring(1);
                    Method method = c.getMethod(methodName, f.getType());//Get the corresponding method based on the user name of the build
                    method.invoke(obj, map.get(key));//The method call
                }else{
                    continue;
                }
            }
        }
        return obj;
    }
}