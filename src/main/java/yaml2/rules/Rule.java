package yaml2.rules;

public interface Rule {
	boolean isRuleSatisfied(Object data);
	Object getReturnValue();
}
