package yaml2.rules;

public class StaticRule implements Rule {

	private Object returnValue;

	public StaticRule(Object returnValue) {
		this.returnValue = returnValue;
	}

	@Override
	public boolean isRuleSatisfied(Object data) {
		return true;
	}

	@Override
	public Object getReturnValue() {
		return returnValue;
	}

}
