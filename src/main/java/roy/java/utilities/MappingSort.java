package roy.java.utilities;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MappingSort {
    public static void main(String[] args) {
        MappingSort mappingSort = new MappingSort();
        Map<String,String> value = mappingSort.getAllSortedMaps();
        Set setvalue = value.entrySet();
        Iterator i = setvalue.iterator();
        while(i.hasNext()){
            Map.Entry me = (Map.Entry)i.next();
            System.out.println(me.getKey()+"--->"+me.getValue());

        }
        System.out.println("=====================================================");
        mappingSort.getAllSortedMaps().forEach(
                (k,v)->{
                    System.out.println(k+"-->"+v);
                }
        );
        System.out.println("=====================================================");
        for (Map.Entry<String,String> e : mappingSort.getAllSortedMaps().entrySet()){
            System.out.println(e.getKey()+"--->"+e.getValue());
        }
    }

    public Map<String,String> getAllSortedMaps(){

        Map<String,String> value = new TreeMap<>();
        value.put("Zero","Tested");
        value.put("BTest","Name");
        value.put("Cool","Temp");
        value.put("Math","Test");
        return value;
    }
}
