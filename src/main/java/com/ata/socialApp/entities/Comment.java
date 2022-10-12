package com.ata.socialApp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name="comments")
@Transactional
public class Comment {
	
				@Id
				private Long id;
			
				@ManyToOne(fetch = FetchType.LAZY)
				@JoinColumn(name="post_id", nullable=false)
				@OnDelete(action = OnDeleteAction.CASCADE)
				@JsonIgnore
				private Post post;
				
				@ManyToOne(fetch = FetchType.LAZY)
				@JoinColumn(name="user_id", nullable=false)
				@OnDelete(action = OnDeleteAction.CASCADE)
				@JsonIgnore
				private User user;
				
				
				@Column(columnDefinition = "text")
				private String text;
}
