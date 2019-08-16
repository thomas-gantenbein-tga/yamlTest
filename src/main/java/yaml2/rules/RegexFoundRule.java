package yaml2.rules;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexFoundRule implements Rule {

	private String regexString;
	private Object returnValue;
	
	public RegexFoundRule(String regexString, Object returnValue) {
		this.regexString = regexString;
		this.returnValue = returnValue;
	}
	
	@Override
	public boolean isRuleSatisfied(Object data) {
		String text = (String) data;
		Pattern regex = Pattern.compile(this.regexString);
		Matcher m = regex.matcher(text);
		return m.find();
	}

	@Override
	public Object getReturnValue() {
		// TODO Auto-generated method stub
		return returnValue;
	}

}
