/**  
 * Project Name:common  
 * File Name:UserModel.java   
 *  
*/

package com.emart.entity;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @since JDK 1.6
 * @see
 */
public class UserModel extends UserEntity{
	@NotBlank
	private String userName;
	
	private String confirmPassword;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
}
