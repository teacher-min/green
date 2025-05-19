package org.edu.demo1.api.user.exception;

import lombok.Getter;

@Getter
public class UserException extends RuntimeException {

    private static final long serialVersionUID = 8408219378115630044L;

	public UserException(UserExceptionResult userExceptionResult) {
        super(userExceptionResult.getMessage());
    }
	
}
