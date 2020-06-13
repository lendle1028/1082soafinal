/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lendle.courses.soa.finalexam;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author lendle
 */
@Service
public class JdbcFoodService implements FoodService {
    /**
     * question 2 (10%):
     * add DI for jdbcTemplate
     */
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Food> getFoods() {
        List<Food> ret = jdbcTemplate.query("select * from food", new FoodRowMapper());
        return ret;
    }

    @Override
    public List<Food> getFoodsByName(String name) {
        return jdbcTemplate.query("select * from food where name like ?",
                new Object[]{"%"+name+"%"}, new FoodRowMapper());
    }

    @Override
    public List<Food> getFoodsByPrice(double price) {
        return jdbcTemplate.query("select * from food where price<=?",
                new Object[]{price}, new FoodRowMapper());
    }

    @Override
    public Food getFood(int id) {
        return jdbcTemplate.queryForObject("select * from food where id=?",
                new Object[]{id},
                new FoodRowMapper());
    }

    @Override
    public void addFood(Food food) {
        jdbcTemplate.update("insert into food (name, price, description) values (?,?,?)",
                food.getName(), food.getPrice(), food.getDescription());
    }

    @Override
    public void updateFood(Food food) {
        //question 3 (15%):
        //use jdbcTemplate to update the given food
        
        
        //////////////////////////////////////////////
    }

    @Override
    public void deleteFood(int id) {
        jdbcTemplate.update("delete from food where id=?", id);
    }

    static class FoodRowMapper implements RowMapper<Food> {

        public Food mapRow(ResultSet rs, int i) throws SQLException {
            Food food = new Food();
            food.setId(rs.getInt("id"));
            food.setName(rs.getString("name"));
            food.setPrice(rs.getDouble("price"));
            food.setDescription(rs.getString("description"));
            return food;
        }
    }

}
