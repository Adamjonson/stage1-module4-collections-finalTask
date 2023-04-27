package com.epam.mjc.collections.combined;

import java.util.*;

public class MapFromKeysCreator {
    public Map<Integer, Set<String>> createMap(Map<String, Integer> sourceMap) {
        Map<Integer, Set<String>> myMap = new HashMap<>();
        List<Integer> nums = new ArrayList<>();
        List<String> keys = new ArrayList<>();
        for (String key : sourceMap.keySet()){
            nums.add(key.length());
            keys.add(key);
        }
        for (Integer num : nums){
            System.out.println(num);
        }
        for (Integer num : nums){
            for (String key : keys){
                if (num == key.length()){
                    // contains or not
                    if (!myMap.containsKey(num)) {
                        Set<String> inKey = new HashSet<>();
                        inKey.add(key);
                        myMap.put(num, inKey);
                    }else {
                        Set<String> existingKeys = myMap.get(num);
                        existingKeys.add(key);
                        myMap.put(num, existingKeys);
                    }
                }
            }

        }
        return myMap;
    }
}
