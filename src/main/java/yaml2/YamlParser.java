package yaml2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

import yaml2.model.Configuration;
import yaml2.model.DocTypeClassification;
import yaml2.model.MetaData;
import yaml2.rules.Rule;
import yaml2.rules.RuleCreator;

public class YamlParser {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		File file = new File(YamlParser.class.getClassLoader().getResource("doctypes.yaml").getFile());

		try (InputStream in = new FileInputStream(file)) {
			Yaml yaml = new Yaml();
			Configuration config = yaml.loadAs(in, Configuration.class);
			List<DocTypeClassification> docTypeDefinitions = config.getDocTypeClassifications();
			RuleCreator ruleCreator = new RuleCreator();
			List<Rule> rules = ruleCreator.createDocTypeRules(docTypeDefinitions);
			DocEvaluator docEvaluator = new DocEvaluator(rules);
			
			String pdfText = "asdf Kundennummer: 1234 Archiviert am:";
			List<String> docTypes = docEvaluator.evaluateDocType(pdfText);
			System.out.println("Dokumenttyp: " + docTypes);

			List<MetaData> metaData = config.getMetaDataListByDocumentType(docTypes.get(0));
			Map<String, Object> metaDataMap = docEvaluator.evaluateMetaData(pdfText, metaData);
			System.out.println(metaDataMap);
			
			pdfText = "Dokumenttyp: ganzEgal Kundennummer: 9";
			docTypes = docEvaluator.evaluateDocType(pdfText);
			System.out.println("Dokumenttyp: " + docTypes);

			metaData = config.getMetaDataListByDocumentType(docTypes.get(0));
			metaDataMap = docEvaluator.evaluateMetaData(pdfText, metaData);
			System.out.println(metaDataMap);
		}
	}

}
