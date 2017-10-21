package com.rakesh.modules.decorators;

import org.springframework.util.StringUtils;

public class CapitalizeMessageDecorator implements MessageDecorator {
	public String decorate(String input) {
		return StringUtils.capitalize(input);
	}
}
