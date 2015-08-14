
import java.util.*;

import java.io.Console;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class WordChecker {
  public static void main(String[] args) {
    // staticFileLocation("/public");
    // String layout = "templates/layout.vtl";
    // get("/", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   model.put("template", "templates/home.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    
    // get("/results", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   model.put("template", "templates/results.vtl");
    
    //   String sentence = request.queryParams("sentence");
    //   String word = request.queryParams("word");
    
    //   Integer getChanged = getChanged(sentence, word);
    
    //   model.put("sentence", sentence);
    //   model.put("word", word);
    //   model.put("getChanged", getChanged(sentence, word));
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());

  }
  public static Integer getChanged(String sent, String wrd){
        String sentence = sent.toLowerCase();
        String word = wrd.toLowerCase();
        Integer repeats = 0;
        List<String> allergyList = Arrays.asList(sentence.split(" "));
        
        for(Object temp : allergyList) {
            if(temp.equals(word)) {
                repeats += 1;
            } 
           
        }


         return repeats;


  }
}
