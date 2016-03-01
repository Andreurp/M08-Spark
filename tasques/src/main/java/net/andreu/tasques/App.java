package net.andreu.tasques;

import static spark.Spark.get;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App 
{

	static ArrayList<tasca> llista = new ArrayList<tasca>();
	
    public static void main( String[] args )
    {
    	HashMap<String, ArrayList<tasca>> tasques = new HashMap<String, ArrayList<tasca>>();
    	
    	tasques.put("tasques", llista);
    	get("/tasques", (rq, rs) -> new ModelAndView(tasques, "index.mustache"), new MustacheTemplateEngine());
    	
    	
    	post("/tasques", (rq, rs) -> {
    		
    		String [] completades = rq.queryParamsValues("anteriors");
    		for (tasca t : llista) {
				t.marca(false);
    		}
    		if (completades!=null) {
    			for (int i = 0; i<completades.length;i++) {
        			for (tasca t : llista) {
            			if (t.text().equals(completades[i])){
            				t.marca(true);
            			}
            		}
        		}
    		}
    		
    		String novaTasca = rq.queryParams("tasca");
    		if (!(novaTasca.equals(""))) {
    			llista.add(new tasca(rq.queryParams("tasca")));
        		tasques.put("tasques", llista);
    		}
    		rs.redirect("/tasques");
    		return null;
    	});
    }
}
