package com.meself.usuarios.meself_usuarios.basic;

import org.springframework.stereotype.Component;

@Component
public class Utils {


    public boolean isObjectInvalid(Object obj){

        if(obj == null || obj.toString().isEmpty()){
            return true;
        }

        return false;
    }

    public boolean isInvalidLenght_str(String valor, int max_size,int min_size){
           
        if(valor.trim().length() > max_size || valor.trim().length()  < min_size){
            return true;
        }
        
        return false;
    }

    public boolean isInvalidEmail(String email){

        return !email.contains("@") || !email.contains(".");
    }

    public boolean isNull(Object obj){

        return obj == null;
    }

}
