package com.liuencier.csp.core.component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo2 {

    public static void main(String[] args) {
        String line[] = new String[] {
                "04-|--|-jmyuncker@aol.com-|-r4Vp5iL2VbM=-|-maiden  name|--",
                "06-|--|-fernandograciliano@hotmail.com-|-Cm8mAzxAiwzioxG6CatHBw==-|-Flamengo|--",
                "07-|--|-witold.sadowski@gmail.com-|-n+TZlu41zyHioxG6CatHBw==-|-|--",
                "08-|--|-isolon08@gmail.com-|-FAniAwP+U13ioxG6CatHBw==-|-|--",
                "09-|--|-ojaimayorga2@yahoo.com-|-kxiV+a47bSlf+E5Ulu/AzA==-|-newest|--",
                "103238710-|--|-sanscia@hotmail.com-|-UimSy9NunUU=-|-reg|--",
                "103238711-|--|-hmgc_@hotmail.com-|-sKZcDAyegNzioxG6CatHBw==-|-muacacias|--",
                "103238712-|--|-jose_rb15@hotmail.com-|-7EdrqFiVnE8=-|-scream|--",
                "103238713-|--|-roy_pol@yahoo.com-|-mvOh9x97N02evXXgSB9QHg==-|-mobile|--",
                "103238714-|--|-mvgepte@yahoo.com-|-vOIOzz9q+SIjK53VtQ56Pw==-|-itim b|--" };

        String regex="\\w+([-+_.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < line.length; i++) {
            Matcher matcher = pattern.matcher(line[i]);
            if (matcher.find()) {   //while效果更好一些
                System.out.println(matcher.group());
            }
        }
    }


}
