/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lendle.courses.soa.finalexam;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author lendle
 */
@Path("foods")
public class FoodsResource {
    /**
     * question 4 (10%):
     * add DI for foodService
     */
    private FoodService foodService=null;

    public void setFoodService(FoodService foodService) {
        this.foodService = foodService;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Food> getFoods(){
        return foodService.getFoods();
    }
    
    /*
     * question 5 (10%):
       implement a GET service
       using sub path
       subject/xxxxxx
       
       for example, webapi/foods/name/abc
       should connect to this web service, and abc is the subject value
     */
    
    public List<Food> getFoodsByName(String name){
        return foodService.getFoodsByName(name);
    }
    
    @GET
    @Path("price/{price}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Food> getFoodsByPrice(@PathParam("price") double price){
        return foodService.getFoodsByPrice(price);
    }
}
