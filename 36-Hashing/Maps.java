import java.util.*;
public class Maps {
    public static void main(String[] args) {
        HashMap<String, Integer> menu = new HashMap<>();
        menu.put("coffee", 40); 
        menu.put("hot choco", 45); 
        menu.put("chicken puff", 30); 
        menu.put("brownie", 40); 
        System.out.println(menu);
        // get
        System.out.println(menu.get("brownie"));
        System.out.println(menu.get("ice"));
        System.out.println(menu.containsKey("ice"));
        System.out.println(menu.remove("chicken puff"));
        System.out.println(menu);
        System.out.println();
        // iterate
        Set<String> keys = menu.keySet();
        for(String k : keys) {
            System.out.println(k + " : " + menu.get(k));
        }
        Set<Map.Entry<String, Integer>> pairs = menu.entrySet();
        for (Map.Entry<String,Integer> entry : pairs) {
            System.out.println(pairs);
            System.out.println(entry);
        }

    }
    
}
