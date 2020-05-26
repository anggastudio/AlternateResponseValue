package com.anggastudio;

import java.util.List;

public class Main {



    public static void main(String[] args) {

        String responseObject = "{\n" +
                "              \"product\": {\n" +
                "                \"name\": \"Laptop SNSV\",\n" +
                "                \"description\": \"Laptop yang namanya kebalik\",\n" +
                "                \"price\": 15000000\n" +
                "              }\n" +
                "            }";

        String responseArray = "{\n" +
                "              \"product\": []\n" +
                "            }";

//        ResponseProduct responseProduct = Util.stringToClass(responseObject, ResponseProduct.class, new ResponseProductDeserialize());
        ResponseProduct responseProduct = Util.stringToClass(responseArray, ResponseProduct.class, new ResponseProductDeserialize());

        List<Product> products = responseProduct.getProducts();
        String toPrint = Util.classToString(responseProduct);
        System.out.println(toPrint);
    }
}
