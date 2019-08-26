package jdk.jdk8.lambaPrinciple;

import java.util.function.Function;

public class lambaPrinciple {


    Function<String, String> format = new Function<String, String>() {
        @Override
        public String apply(String input){
            return Character.toUpperCase(input.charAt(0)) + input.substring(1);
        }
    };
}
