package com.cybertek.utilities.OfficeHoursUtilities;

public class AmazonUtils {
    public static double priceConverter(String price){
        String temp = "";
        for(int i = 0; i < price.length(); i++){
            if(Character.isDigit(price.charAt(i))){
                temp += "" + price.charAt(i);
            }
            if(price.charAt(i) == '.'){
                temp+=price.charAt(i);
            }
        }
        return Double.parseDouble(temp);
    }
}
