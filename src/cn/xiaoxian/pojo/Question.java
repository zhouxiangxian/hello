package cn.xiaoxian.pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Question entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "question", catalog = "znt2")

public class Question implements java.io.Serializable {

	// Fields

	private Integer qid;
	private Answer answer;
	private User user;
	private Type type;
	private String title;
	private Timestamp pubtime;
	private Integer status;
	private Integer points;
	private Integer count;
	private String content;
	private Set<Answer> answers = new HashSet<Answer>(0);

	// Constructors

	/** default constructor */
	public Question() {
	}

	/** minimal constructor */
	public Question(String title, Timestamp pubtime) {
		this.title = title;
		this.pubtime = pubtime;
	}

	/** full constructor */
	public Question(Answer answer, User user, Type type, String title, Timestamp pubtime, Integer status,
			Integer points, Integer count, String content, Set<Answer> answers) {
		this.answer = answer;
		this.user = user;
		this.type = type;
		this.title = title;
		this.pubtime = pubtime;
		this.status = status;
		this.points = points;
		this.count = count;
		this.content = content;
		this.answers = answers;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "qid", unique = true, nullable = false)

	public Integer getQid() {
		return this.qid;
	}

	public void setQid(Integer qid) {
		this.qid = qid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aid")

	public Answer getAnswer() {
		return this.answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid")

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tid")

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Column(name = "title", nullable = false, length = 200)

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "pubtime", nullable = false, length = 19)

	public Timestamp getPubtime() {
		return this.pubtime;
	}

	public void setPubtime(Timestamp pubtime) {
		this.pubtime = pubtime;
	}

	@Column(name = "status")

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "points")

	public Integer getPoints() {
		return this.points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	@Column(name = "count")

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Column(name = "content", length = 65535)

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "question")

	public Set<Answer> getAnswers() {
		return this.answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}

}