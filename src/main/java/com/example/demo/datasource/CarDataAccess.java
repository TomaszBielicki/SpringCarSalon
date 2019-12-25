package com.example.demo.datasource;

import com.example.demo.model.Car;
import com.example.demo.utils.CarHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class CarDataAccess {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDataAccess(JdbcTemplate jdbcTemplateq) {
        this.jdbcTemplate = jdbcTemplateq;
    }

    public List<Car> selectAllCars(){

        final String sql = "SELECT id, namee FROM car";

        return jdbcTemplate.query(
                sql,
                (resultSet, i) -> {
                    String car_id = resultSet.getString("id");
                    String car_name = resultSet.getString("namee");

                 return new Car(UUID.fromString(car_id), car_name);
                }

        );
    }

    public int insert(Car car) {
        final String sql = "INSERT INTO car (id, namee)" +
                "VALUES (?, ?)";

       return jdbcTemplate.update(
                sql,
                CarHelper.getCar(car)

        );
    }
}
