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
 * Answer entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "answer", catalog = "znt2")

public class Answer implements java.io.Serializable {

	// Fields

	private Integer aid;//回答id
	private Question question;//问题
	private User user;//用户
	private String content;//回答内容
	private Timestamp retdate;//回答时间
	private Set<Question> questions = new HashSet<Question>(0);

	// Constructors

	/** default constructor */
	public Answer() {
	}

	/** full constructor */
	public Answer(Question question, User user, String content, Timestamp retdate, Set<Question> questions) {
		this.question = question;
		this.user = user;
		this.content = content;
		this.retdate = retdate;
		this.questions = questions;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "aid", unique = true, nullable = false)

	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "qid")

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid")

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "content", length = 65535)

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "retdate", length = 19)

	public Timestamp getRetdate() {
		return this.retdate;
	}

	public void setRetdate(Timestamp retdate) {
		this.retdate = retdate;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "answer")

	public Set<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

}