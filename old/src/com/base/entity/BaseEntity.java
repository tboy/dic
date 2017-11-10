package com.base.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 基础实体
 * @author 
 *
 */
@MappedSuperclass
public class BaseEntity implements Serializable{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 7556449801486180557L;
	/** 主键 */
    private Long id;

    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
       
}
