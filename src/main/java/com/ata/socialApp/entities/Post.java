package com.ata.socialApp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name="posts")
public class Post {
				
				@Id
				private Long id;
		
				@ManyToOne(fetch = FetchType.LAZY)
				@JoinColumn(name="user_id", nullable=false)
				@OnDelete(action = OnDeleteAction.CASCADE)
				@JsonIgnore
				private User user;
				
				private String title;
				
				@Lob
				@Column(columnDefinition = "text")
				private String text;

}
