package cn.xiaoxian.pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "user", catalog = "znt2")

public class User implements java.io.Serializable {

	// Fields

	private String userid;
	private String password;
	private Integer points;
	private Timestamp registeredtime;
	private String sex;
	private String email;
	private String image;
	private Set<Answer> answers = new HashSet<Answer>(0);
	private Set<Question> questions = new HashSet<Question>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userid) {
		this.userid = userid;
	}

	/** full constructor */
	public User(String userid, String password, Integer points, Timestamp registeredtime, String sex, String email,
			String image, Set<Answer> answers, Set<Question> questions) {
		this.userid = userid;
		this.password = password;
		this.points = points;
		this.registeredtime = registeredtime;
		this.sex = sex;
		this.email = email;
		this.image = image;
		this.answers = answers;
		this.questions = questions;
	}

	// Property accessors
	@Id

	@Column(name = "userid", unique = true, nullable = false, length = 200)

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Column(name = "password", length = 32)

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "points")

	public Integer getPoints() {
		return this.points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	@Column(name = "registeredtime", length = 19)

	public Timestamp getRegisteredtime() {
		return this.registeredtime;
	}

	public void setRegisteredtime(Timestamp registeredtime) {
		this.registeredtime = registeredtime;
	}

	@Column(name = "sex", length = 10)

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "email", length = 50)

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "image", length = 200)

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")

	public Set<Answer> getAnswers() {
		return this.answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")

	public Set<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

}