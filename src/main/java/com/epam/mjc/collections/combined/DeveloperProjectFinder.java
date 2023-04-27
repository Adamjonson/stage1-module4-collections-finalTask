package com.epam.mjc.collections.combined;

import java.util.*;
class LengthFirstComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if (o1.length()!=o2.length()) {
            return o2.length()-o1.length(); //overflow impossible since lengths are non-negative
        }
        return o2.compareTo(o1);
    }
}
public class DeveloperProjectFinder {
    public List<String> findDeveloperProject(Map<String, Set<String>> projects, String developer) {
        Map<String, List<String>> devProjectsMap = new HashMap<>();

        for (String project : projects.keySet()){
            Set<String> developersOfAProject = projects.get(project);
            for (String dev : developersOfAProject){
                // cotains or not
                if (!devProjectsMap.containsKey(dev)){
                    List<String> devProject = new ArrayList<>();
                    devProject.add(project);
                    devProjectsMap.put(dev, devProject);
                }else {
                    List<String> devProjectList;
                    devProjectList = devProjectsMap.get(dev);
                    devProjectList.add(project);
                    devProjectsMap.put(dev, devProjectList);
                }
            }
        }
        if (devProjectsMap.isEmpty() || devProjectsMap.get(developer) == null){
            List<String> EmptyList = Collections.emptyList();
            return EmptyList;
        }
        for (String key : devProjectsMap.keySet()){
            List<String> sortList = devProjectsMap.get(key);
            Collections.sort(sortList, new LengthFirstComparator());
            devProjectsMap.put(key, sortList);
        }


        return devProjectsMap.get(developer);
    }

}
