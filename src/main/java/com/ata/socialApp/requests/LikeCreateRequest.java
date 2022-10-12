package com.ata.socialApp.requests;

import lombok.Data;

@Data
public class LikeCreateRequest {
				
				private Long id;
				private Long userId;
				private Long postId;
}
