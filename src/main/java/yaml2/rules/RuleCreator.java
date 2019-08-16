package yaml2.rules;

import java.util.ArrayList;
import java.util.List;

import yaml2.model.DocTypeClassification;
import yaml2.model.MetaData;
import yaml2.model.RuleDefinition;

public class RuleCreator {

	public RuleCreator() {

	}

	public List<Rule> createDocTypeRules(List<DocTypeClassification> docTypeDefinitions) {
		List<Rule> rules = new ArrayList<Rule>();
		for (DocTypeClassification docTypeDefinition : docTypeDefinitions) {
			String ruleType = docTypeDefinition.getRuleDefinition().getRuleType();
			RuleDefinition ruleDefinition = docTypeDefinition.getRuleDefinition();
			rules.add(createRule(ruleType, ruleDefinition));
		}
		return rules;
	}

	public Rule createMetaDataRule(MetaData metaData) {
		String ruleType = metaData.getRuleDefinition().getRuleType();
		RuleDefinition ruleDefinition = metaData.getRuleDefinition();
		return createRule(ruleType, ruleDefinition);
	}

	private Rule createRule(String ruleType, RuleDefinition ruleDefinition) {
		switch (ruleType) {
		case "ifFoundThenReturnValue": {
			String regex = (String) ruleDefinition.getRuleData().get("regex");
			Object returnValue = ruleDefinition.getRuleData().get("returnValue");
			return new RegexFoundRule(regex, returnValue);
		}
		case "ifFoundThenReturnHit": {
			String regex = (String) ruleDefinition.getRuleData().get("regex");
			int regexGroup = (int) ruleDefinition.getRuleData().get("groupNumber");
			return new RegexValueRule(regex, regexGroup);
		}
		default:
			throw new IllegalArgumentException("Unsupported rule type '" + ruleType + "'. Consider extending class '"
					+ this.getClass().getCanonicalName() + "'");
		}
	}

}
