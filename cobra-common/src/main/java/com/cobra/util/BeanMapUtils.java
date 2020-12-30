package com.cobra.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BeanMapUtils {


    public static <T> T map2bean(Map<Object,Object> map,Class<T> beanType) throws Exception {
        T t=beanType.newInstance();
        PropertyDescriptor[] pds= Introspector.getBeanInfo(beanType,Object.class)
                .getPropertyDescriptors();
        for (PropertyDescriptor pd : pds) {
            for (Map.Entry entry : map.entrySet()) {
                if(entry.getKey().equals(pd.getName())) {
                    pd.getWriteMethod().invoke(t, entry.getValue());
                }
            }
        }
        return t;
    }

    public static Map<Object,Object> bean2map(Object bean) throws Exception {

        Map<Object,Object> map=new HashMap<>();
        BeanInfo info=Introspector.getBeanInfo(bean.getClass(),Object.class);
        PropertyDescriptor []pds=info.getPropertyDescriptors();
        for(PropertyDescriptor pd:pds) {
            Object key=pd.getName();
            Object value= pd.getReadMethod().invoke(bean);
            map.put(key, value);
        }
        return map;
    }



}

