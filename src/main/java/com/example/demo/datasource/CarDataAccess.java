package com.example.demo.datasource;

import com.example.demo.model.Car;
import com.example.demo.utils.CarHelper;
import com.example.demo.utils.ModelCar;
import com.example.demo.utils.TypeCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public class CarDataAccess {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDataAccess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List <Car> findCarByModel(String modelName) {
        final String sql = "SELECT * FROM car WHERE modelcar = ?";

        return jdbcTemplate.query(
                sql,
                new Object[]{modelName},
                (rs, i) -> {
                    ModelCar modelCar = Enum.valueOf(ModelCar.class, rs.getString("modelcar"));
                    LocalDate localDate = rs.getObject("productiondate", LocalDate.class);
                    TypeCar typeCar = Enum.valueOf(TypeCar.class, rs.getString("typecar"));
                    return new Car(modelCar, localDate, typeCar);

                }
        );
    }

    public List<Car> selectAllCars(){

        final String sql = "SELECT * FROM car";

        return jdbcTemplate.query(
                sql,
                (resultSet, i) -> {
                    TypeCar typecar =Enum.valueOf(TypeCar.class, resultSet.getString("typecar"));
                    LocalDate date = resultSet.getObject("productiondate", LocalDate.class);
                    ModelCar modelCar = Enum.valueOf(ModelCar.class, resultSet.getString("modelcar"));

                 return new Car(modelCar, date, typecar);

                }

        );
    }

    public int insert(Car car) {
        final String sql = "INSERT INTO car (id, productiondate, modelcar, typecar)" +
                "VALUES (?, ?, ?, ?)";

       return jdbcTemplate.update(
                sql,
                CarHelper.getCar(car)

        );
    }
}
