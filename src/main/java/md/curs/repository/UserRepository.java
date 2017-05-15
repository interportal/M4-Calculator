package md.curs.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import md.curs.model.User;

@Repository
public class UserRepository {
	
	@PersistenceContext
    private EntityManager em;
	
	public User insertUser(User user) {

		/*jdbcTemplate.update(
				"INSERT INTO user (firstName, lastName, email, password, phone, age)" + 
				"VALUES(?, ?, ?, ?, ?, ?)",
				user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), 
				user.getPhone(), user.getAge());*/

		return em.merge(user);
	}
	
	public List<User> userList() {
		
		/*List<User> users = jdbcTemplate.query("SELECT id, firstName, lastName, age FROM user", new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int numRow) throws SQLException {
				
				User user = new User();
				
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setAge(rs.getInt("age"));
				
				return user;
			}
			
		});
		
		return users;*/
		
		return em.createQuery("FROM User", User.class)
                .getResultList();
	}
}
