package com.softgroup.common.protocol;

import java.io.Serializable;

/**
 * Created by VYA on 21.02.2017.
 */
public class Request<T extends Serializable> extends RoutedAction<T> {

	private static final long serialVersionUID = -1024761631293962969L;


	private ActionHeader actionHeader;

	private T data;

	public ActionHeader getActionHeader() {
		return actionHeader;
	}

	public void setActionHeader(ActionHeader actionHeader) {
		this.actionHeader = actionHeader;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
