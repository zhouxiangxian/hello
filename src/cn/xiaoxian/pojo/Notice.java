package cn.xiaoxian.pojo;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Notice entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "notice", catalog = "znt2")

public class Notice implements java.io.Serializable {

	// Fields

	private Integer nid;
	private String title;
	private String content;
	private Timestamp pubtime;

	// Constructors

	/** default constructor */
	public Notice() {
	}

	/** minimal constructor */
	public Notice(String title) {
		this.title = title;
	}

	/** full constructor */
	public Notice(String title, String content, Timestamp pubtime) {
		this.title = title;
		this.content = content;
		this.pubtime = pubtime;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "nid", unique = true, nullable = false)

	public Integer getNid() {
		return this.nid;
	}

	public void setNid(Integer nid) {
		this.nid = nid;
	}

	@Column(name = "title", nullable = false, length = 50)

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content", length = 65535)

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "pubtime", length = 19)

	public Timestamp getPubtime() {
		return this.pubtime;
	}

	public void setPubtime(Timestamp pubtime) {
		this.pubtime = pubtime;
	}

}