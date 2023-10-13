package com.lucenesearch.client.http;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.lucenesearch.model.Product;
import com.lucenesearch.model.Products;

import java.io.IOException;
import java.util.ArrayList;

public class TestService {

    public static void main(String args[]) {

        HttpService httpService = new HttpService();

        try {
            String res = httpService.get("https://pbapps.in/api/v2/sales/parts");
            //System.out.println(res);

            ArrayList<Product> products = new Gson().fromJson(res, new TypeToken<ArrayList<Product>>() {
            }.getType());

           // JsonArray convertedObject = new Gson().fromJson(res, JsonArray.class);

          //  convertedObject.forEach((k)-> {

            //            System.out.println(k.getAsJsonObject().get("id"));
           //         }
           //         );

            // Products products = new Gson().fromJson(res, Products.class);
            products.forEach((k)-> {
                System.out.println(k);
            });

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
