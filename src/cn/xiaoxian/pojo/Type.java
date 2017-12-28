package cn.xiaoxian.pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Type entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "type", catalog = "znt2")

public class Type implements java.io.Serializable {

	// Fields

	private Integer tid;
	private String title;
	private String description;
	private Set<Question> questions = new HashSet<Question>(0);

	// Constructors

	/** default constructor */
	public Type() {
	}

	/** minimal constructor */
	public Type(String title) {
		this.title = title;
	}

	/** full constructor */
	public Type(String title, String description, Set<Question> questions) {
		this.title = title;
		this.description = description;
		this.questions = questions;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "tid", unique = true, nullable = false)

	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	@Column(name = "title", nullable = false, length = 200)

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "description", length = 65535)

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "type")

	public Set<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

}