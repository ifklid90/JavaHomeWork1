import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by user on 15.10.14.
 */
public class TopWords {
    public static void main(String[] args) throws FileNotFoundException {

        int topNumb = Integer.parseInt(args[0]);

        File file = new File("text.txt");
        Scanner sc = new Scanner(file);

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        while (sc.hasNext()){
            String word = sc.next();
            Integer i = map.get(word);
            if (i == null){
                map.put(word, 1);
            } else {
                Integer newI = i + 1;

                map.put(word, newI);
            }
        }

        sc.close();

        TreeMap<String, Integer> sortedMap = SortByValue(map);
//        System.out.println(sortedMap);

        Set set = sortedMap.entrySet();
        Iterator i = sortedMap.entrySet().iterator();
        int count = 1;
        while(i.hasNext() && count <= topNumb){
            Map.Entry entry = (Map.Entry)i.next();
            System.out.println(entry.getKey());
            count++;
        }


    }

    public static TreeMap<String, Integer> SortByValue
            (HashMap<String, Integer> map) {
        ValueComparator vc =  new ValueComparator(map);
        TreeMap<String,Integer> sortedMap = new TreeMap<String,Integer>(vc);
        sortedMap.putAll(map);
        return sortedMap;
    }
}

class ValueComparator implements Comparator<String> {

    Map<String, Integer> map;

    public ValueComparator(Map<String, Integer> base) {
        this.map = base;
    }

    public int compare(String a, String b) {
        if (map.get(a) >= map.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}