/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lendle.courses.soa.finalexam;

import java.util.List;

/**
 *
 * @author lendle
 */
public interface FoodService {
    public List<Food> getFoods();
    public List<Food> getFoodsByName(String name);
    public List<Food> getFoodsByPrice(double price);
    public Food getFood(int id);
    public void addFood(Food food);
    public void updateFood(Food food);
    public void deleteFood(int id);
}
