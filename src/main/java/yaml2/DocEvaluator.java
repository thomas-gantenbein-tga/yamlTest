package yaml2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import yaml2.model.MetaData;
import yaml2.rules.Rule;
import yaml2.rules.RuleCreator;

public class DocEvaluator {
	private List<Rule> documentTypeRules;

	public DocEvaluator(List<Rule> documentTypeRules) {
		this.documentTypeRules = documentTypeRules;
	}

	public List<String> evaluateDocType(Object data) {
		List<String> docTypeNames = new ArrayList<String>();
		for (Rule rule : documentTypeRules) {
			if (rule.isRuleSatisfied(data)) {
				docTypeNames.add((String) rule.getReturnValue());
			}
		}
		return docTypeNames;
	}

	public Map<String, Object> evaluateMetaData(Object data, List<MetaData> metaDataList) {
		RuleCreator ruleCreator = new RuleCreator();
		Map<String, Object> metaDataResult = new HashMap<String, Object>();
		for (MetaData metaData : metaDataList) {
			Rule rule = ruleCreator.createMetaDataRule(metaData);
			if (rule.isRuleSatisfied(data)) {
				metaDataResult.put(metaData.getName(), rule.getReturnValue());
			}
		}
		return metaDataResult;
	}

}
