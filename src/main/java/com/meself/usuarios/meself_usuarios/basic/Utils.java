package com.meself.usuarios.meself_usuarios.basic;

import org.springframework.stereotype.Component;

@Component
public class Utils {


    public void isObjectInvalid(Object obj){

        if(obj == null){
            throw new NullPointerException();
        }
    }

}
