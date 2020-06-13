/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lendle.courses.soa.finalexam;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author lendle
 */
@Path("food")
public class FoodResource {
    /**
     * question 6 (10%):
     * add DI for foodService
     */
    private FoodService foodService=null;
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Food getFood(@PathParam("id") int id){
        return foodService.getFood(id);
    }
    
    /*
    question 7 (15%):
    add the required annotations and codes to complete the implementation
    of this service method
    */
    public void addFood(Food food){
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateTask(Food food){
        foodService.updateFood(food);
    }
    
    /*
    question 8 (15%):
    add the required annotations and codes to complete the implementation
    of this service method
    */
    public void deleteFood(int id){
    }
}
