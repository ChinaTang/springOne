package com.smart.dao;

import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {
    private JdbcTemplate jdbcTemplate;

    private final static String MACTH_COUNT_SQL = "SELECT * FROM " +
            "t_user WHERE user_name = ? ";

    private final static String UPDATE_LOGIN_INFO_SQL = "UPDATE t_user SET last_visit=?" +
            ",last_ip=?,credits=? WHERE user_id=?";

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public int getMatchCount(String userName, String password){
        String sql = "SELECT count(*) FROM t_user WHERE user_name =? and password=? ";

        return jdbcTemplate.queryForInt(sql, new Object[] {userName, password});
    }

    public User findUserByUserName(final String userName){
        final User user = new User();
        jdbcTemplate.query(MACTH_COUNT_SQL, new Object[]{userName}, new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
                //boolean is = rs.next();
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(userName);
                user.setCredits(rs.getInt("credits"));
            }
        });
        return user;
    }

    public void updateLoginInfo(User user){
        jdbcTemplate.update(UPDATE_LOGIN_INFO_SQL, new Object[]{user.getLastVistit(),
        user.getLastIp(), user.getCredits(), user.getUserId()});
    }
}
