package yaml2.rules;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexValueRule implements Rule {
	private final String regexString;
	private String returnValue;
	private int groupNumber;

	public RegexValueRule(String regex, int groupNumber) {
		regexString = regex;
		this.groupNumber = groupNumber;
	}

	@Override
	public boolean isRuleSatisfied(Object data) {
		String text = (String) data;
		Pattern regex = Pattern.compile(regexString);
		Matcher m = regex.matcher(text);
		if (m.find()) {
			returnValue = m.group(groupNumber);
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public String getReturnValue() {
		return returnValue;
	}
	
	

}
