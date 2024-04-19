package com.msUser.msUser.Core.Utilities.Results;

public class ErrorDataResult<T> extends DataResult<T> {
	public ErrorDataResult(T data, String message) {
		super(data, false, message);
		// TODO Auto-generated constructor stub
	}

	public ErrorDataResult(T data) {
		super(data, false);
		// TODO Auto-generated constructor stub
	}

	public ErrorDataResult() {
		super(null, false);
	}
}
