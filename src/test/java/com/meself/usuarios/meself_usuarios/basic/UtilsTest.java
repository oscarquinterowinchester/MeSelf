package com.meself.usuarios.meself_usuarios.basic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


// @ExtendWith(MockitoExtension.class)

public class UtilsTest {

    Utils utils = new Utils();

    @Test
    public void isInvalidLenght_strTest(){

        String valor = null; 
        int max_size = 5;
        int min_size = 1;

      boolean isInvalid =  utils.isInvalidLenght_str(valor, max_size, min_size);

      assertTrue(isInvalid);


    }

    @Test
    public void isInvalidEmailTest(){

        String valor = "@.";
      boolean isInvalid =  utils.isInvalidEmail(valor);

      assertTrue(isInvalid);


    }

    
    



    

}
