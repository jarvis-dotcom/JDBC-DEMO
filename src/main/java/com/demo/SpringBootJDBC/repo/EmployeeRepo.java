package com.demo.SpringBootJDBC.repo;

import com.demo.SpringBootJDBC.config.QueryConfig;
import com.demo.SpringBootJDBC.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeRepo {

    private final JdbcTemplate jdbcTemplate;
    private final QueryConfig queryConfig;

    public EmployeeRepo(JdbcTemplate jdbcTemplate, QueryConfig queryConfig) {
        this.jdbcTemplate = jdbcTemplate;
        this.queryConfig=queryConfig;
    }


    public int save(Employee employee) {
        String insertQuery = queryConfig.getInsert();
        return jdbcTemplate.update(insertQuery, employee.getId(), employee.getName());
    }

    public List<Employee> findAll() {
        String query = queryConfig.getFindAll();
        return jdbcTemplate.query(query, mapper(new Employee()));
    }

    public int deleteAll(){
        String deleteQuery = queryConfig.getDeleteAll();
        return jdbcTemplate.update(deleteQuery);
    }
    private RowMapper<Employee> mapper(Employee emp) {
        return new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                Employee emp = new Employee();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                return emp;
            }
        };
    }


}
