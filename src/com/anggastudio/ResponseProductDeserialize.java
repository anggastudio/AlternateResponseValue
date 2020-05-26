package com.anggastudio;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class ResponseProductDeserialize implements JsonDeserializer<ResponseProduct> {

    @Override
    public ResponseProduct deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        ResponseProduct responseProduct = new ResponseProduct();
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        if(jsonObject.has("product") && jsonObject.get("product").isJsonArray()){
            String string = jsonObject.get("product").toString();
            if(string != null && !string.isEmpty()){
                List<Product> productList = new Gson().fromJson(string, new TypeToken<List<Product>>() {}.getType());
                responseProduct.setProducts(productList);
            }
        } else {
            responseProduct = Util.stringToClass(jsonElement.toString(), ResponseProduct.class);
        }
        return responseProduct;
    }
}
