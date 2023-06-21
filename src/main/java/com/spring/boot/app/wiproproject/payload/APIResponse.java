package com.spring.boot.app.wiproproject.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class APIResponse {
	
	private String massage;
	private boolean success;

}
