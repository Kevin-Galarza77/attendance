package com.keax.Attendance.model;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data  
@Entity
@Table(name = "password_resets")
public class PasswordReset  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reset_id")
    private int resetId;
	
    @Column(nullable = false, unique = true)
    private String token;
    
    @Column(nullable = false)
    private Timestamp expiration;
    
    @Column(nullable = false)
    private Boolean used;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;
	
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
}
