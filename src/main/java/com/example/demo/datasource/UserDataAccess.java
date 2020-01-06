package com.example.demo.datasource;

import com.example.demo.model.User;
import com.example.demo.utils.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class UserDataAccess {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDataAccess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> selectAllUsers(){

            final String sql = "SELECT id, namee FROM users";

            return jdbcTemplate.query(
                    sql,
                    (resultSet, i) -> {
                        String user_ID = resultSet.getString("id");
                        String userName = resultSet.getString("namee");

                        return new User(UUID.fromString(user_ID), userName);
                    }
            );
    }

    public int insert (User user){
        final String sql = "INSERT INTO users(id, namee)" +
                "VALUES (?, ?)";

        return jdbcTemplate.update(
                sql,
                UserHelper.getUser(user)

        );
    }
}
