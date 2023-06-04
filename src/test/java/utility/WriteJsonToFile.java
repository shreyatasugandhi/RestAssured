package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class WriteJsonToFile {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws FileNotFoundException {
        // creating JSONObject
        JSONObject jo = new JSONObject();
          
        // putting data to JSONObject
        jo.put("firstName", "John");
        jo.put("lastName", "Smith");
        jo.put("age", 25);
          
        System.out.println("JSON Object in round 1 \n"+jo.toJSONString());
          
        // for address data, first create LinkedHashMap
        Map m = new LinkedHashMap(4);
        m.put("streetAddress", "21 2nd Street");
        m.put("city", "New York");
        m.put("state", "NY");
        m.put("postalCode", 10021);
        
        System.out.println("Map in round 1 \n"+m.toString());
        
        // putting address to JSONObject
        jo.put("address", m);
        
        System.out.println("JSON Object after adding map \n"+jo.toJSONString());
        
        // for phone numbers, first create JSONArray 
        JSONArray ja = new JSONArray();
          
        m = new LinkedHashMap(2);
        m.put("type", "home");
        m.put("number", "212 555-1234");
          
        System.out.println("Map in round 2 \n"+m.toString());
        
        // adding map to list
        ja.add(m);
        System.out.println("Array in round 1 \n"+ja.toJSONString());
        
        m = new LinkedHashMap(2);
        m.put("type", "fax");
        m.put("number", "212 555-1234");
          
        System.out.println("Map in round 3 \n"+m.toString());
        
        // adding map to list
        ja.add(m);
        
        System.out.println("Array in round 2 \n"+ja.toJSONString());
          
        // putting phoneNumbers to JSONObject
        jo.put("phoneNumbers", ja);
        
        System.out.println("JSON Object after adding JSONArray \n"+jo.toJSONString());
        
        // writing JSON to file:"JSONExample.json" in current working directory
        PrintWriter pw = new PrintWriter(new File(System.getProperty("user.dir") 
        		+ "\\src\\test\\resources\\JSONExample.json"));
        pw.write(jo.toJSONString());
        
        System.out.println("JSON Object Final \n"+jo.toJSONString());
          
        pw.flush();
        pw.close();
    }

}
