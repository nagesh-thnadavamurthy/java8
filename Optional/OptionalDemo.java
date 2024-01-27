package com.javatechie;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {



    public static com.javatechie.CustomerData getCustomerByEmailId(String email) throws Exception {
        List<com.javatechie.CustomerData> customerData = EkartDataBase.getAll();
       return customerData.stream()
                .filter(customer -> customer.getEmail().equals(email))
                .findAny().orElseThrow(()->new Exception("no customer present with this email id"));

    }

    public static void main(String[] args) throws Exception {

        com.javatechie.CustomerData customerData =new com.javatechie.CustomerData(101, "john", "test@gmail.com", Arrays.asList("397937955", "21654725"));

        //empty
        //of
        //ofNullable

        Optional<Object> emptyOptional = Optional.empty();
        System.out.println(emptyOptional);

        //Optional<String> emailOptional = Optional.of(customer.getEmail());
        //System.out.println(emailOptional);

       // Optional<String> emailOptional2 = Optional.ofNullable(customerData.getEmail());
       /* if(emailOptional2.isPresent()){
            System.out.println(emailOptional2.get());
        }*/
       // System.out.println(emailOptional2.orElse("default@email.com"));

       // System.out.println(emailOptional2.orElseThrow(()->new IllegalArgumentException("email not present")));


      //  System.out.println(emailOptional2.map(String::toUpperCase).orElseGet(()->"default email..."));

        getCustomerByEmailId("pqr");
    }
}
