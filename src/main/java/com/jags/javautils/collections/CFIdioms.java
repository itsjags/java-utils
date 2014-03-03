package com.jags.javautils.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CFIdioms
{
   public static void main(String[] args)
   {
      List<String> innerPlanetNames = Arrays.asList("Mercury", "Venus", "Earth", 
                                                    "Mars");
      System.out.println(innerPlanetNames);

      System.out.println();

      String[] _innerPlanetNames = innerPlanetNames.toArray(new String[0]);
      for (String _innerPlanetName: _innerPlanetNames)
         System.out.println(_innerPlanetName);

      System.out.println();

      Collection<String> c = new ArrayList<String>();
      c.add("first");
      c.add(null);
      c.add("second");
      c.add(null);
      c.add("third");
      c.add(null);
      System.out.println(c);
      c.removeAll(Collections.singleton(null));
      System.out.println(c);

      System.out.println();

      List<String> names = Arrays.asList("John", "Jane", "Tom", "Jane", "Tom",
                                         "Brian");
      System.out.println(names);
      System.out.println(new HashSet<String>(names));
      System.out.println(new LinkedHashSet<String>(names));

      System.out.println();

      Map<String, String> capitals = new TreeMap<String, String>();
      capitals.put("United States", "Washington");
      capitals.put("Russia", "Moscow");
      capitals.put("England", "London");
      capitals.put("France", "Paris");
      for (Map.Entry<String, String> entry: capitals.entrySet())
         System.out.println(entry.getKey()+": "+entry.getValue());
   }
}