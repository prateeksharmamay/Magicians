package server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class GridResource extends ServerResource {
	
    @Get
    public JsonRepresentation represent() throws IOException {
    	
    	int grid [][] = new int[6][6];
    	
    	for(int i = 0 ; i < 6 ; i++){
    		for(int j = 0 ; j < 6 ; j++){
    			grid [i][j] = (Math.random()<0.5)?0:1;
    			System.out.println("grid [i][j]: "+grid [i][j]);
    		}
    		System.out.println();
    	}
    	
    	JSONObject response = new JSONObject();
    	response.put("grid", grid);
    	
        return (new JsonRepresentation(response));
    }
}
