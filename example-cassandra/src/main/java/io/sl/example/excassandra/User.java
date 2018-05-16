package io.sl.example.excassandra;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(value = "users")
public class User {

	@PrimaryKey("user_id") private Long id;

	@Column("uname") private String username;
	@Column("fname") private String firstname;
	@Column("lname") private String lastname;

	public User(Long id) {
		this.setId(id);
	}
}