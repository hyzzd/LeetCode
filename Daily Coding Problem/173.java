import java.util.*;

class Main {

    public static List<String, Integer> flatten(JSONObject input) {
        List<String, Integer> res = new LinkedList<>();
        Stack<String> stack = new Stack<>();

        Iterator<Map.Entry> itr1 = input.entrySet().iterator();
        while (itr1.hasNext()) {
            Map.Entry pair = itr1.next();
            if (pair.getValue() instanceof Integer) {
                res.add(pair.getKey(), pair.getValue());
            } else {
                if (stack.isEmpty()) {
                    stack.push((String) pair.getKey());
                } else {
                    stack.push(stack.peek() + pair.getKey());
                }
                List<String, Integer> sub = flatten(pair.getValue());
                res.addAll(sub);
            }
        }
        return res;
    }

    public static main(String[] args){
        // creating JSONObject 
        JSONObject jo = new JSONObject(); 
        JSONObject subJo = new JSONObject(); 
        JSONObject subSubJo = new JSONObject(); 
                
        // putting data to JSONObject 
        subSubJo.put("baz", 8);
        subJo.put("bar", subSubJo);
        subJo.put("a", 5);
        jo.put("foo", subJo); 
        jo.put("key", 3); 

        // writing JSON to file:"JSONExample.json" in cwd 
        PrintWriter pw = new PrintWriter("JSONExample.json"); 
        pw.write(jo.toJSONString()); 
          
        pw.flush(); 
        pw.close(); 

        // parsing file "JSONExample.json" 
        Object obj = new JSONParser().parse(new FileReader("JSONExample.json")); 
          
        // typecasting obj to JSONObject 
        List<String, Integer> res = flatten((JSONObject) obj);
    }
}