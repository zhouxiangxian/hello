package cn.xiaoxian.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "admin", catalog = "znt2")

public class Admin implements java.io.Serializable {

	// Fields

	private String adminid;//管理员id
	private String password;//密码

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** full constructor */
	public Admin(String adminid, String password) {
		this.adminid = adminid;
		this.password = password;
	}

	// Property accessors
	@Id

	@Column(name = "adminid", unique = true, nullable = false, length = 200)

	public String getAdminid() {
		return this.adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	@Column(name = "password", nullable = false, length = 32)

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}