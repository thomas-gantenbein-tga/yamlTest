package yaml2.model;

import java.util.Map;

public class RuleDefinition {
	private String ruleType;
	private Map<String, Object> ruleData;
	
	public String getRuleType() {
		return ruleType;
	}
	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}
	public Map<String,Object> getRuleData() {
		return ruleData;
	}
	public void setRuleData(Map<String, Object> ruleData) {
		this.ruleData = ruleData;
	}
	
	
}
