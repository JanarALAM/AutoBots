package com.autobots.StreamApi;

import java.util.ArrayList;
import java.util.List;

public class FlatMap {
    public static void main(String[] args) {

        List<List<String>> nestedList=List.of(
                List.of("A","B"),
                List.of("С","В"),
                List.of("Е")
        );
        System.out.println(nestedList);

        List<String> nonNestedList=new ArrayList<>();
        for (List<String> list:nestedList){
            nonNestedList.addAll(list);
        }
        System.out.println(nonNestedList);



    }


}
