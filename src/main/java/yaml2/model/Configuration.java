package yaml2.model;

import java.util.List;

public class Configuration {
	private List<DocTypeClassification> docTypeClassifications;
	private List<DocumentMetaDataDefinition> documentMetaDataDefinitions;

	public List<DocTypeClassification> getDocTypeClassifications() {
		return docTypeClassifications;
	}

	public void setDocTypeClassifications(List<DocTypeClassification> docTypeDefinitions) {
		this.docTypeClassifications = docTypeDefinitions;
	}

	public List<DocumentMetaDataDefinition> getDocumentMetaDataDefinitions() {
		return documentMetaDataDefinitions;
	}

	public void setDocumentMetaDataDefinitions(List<DocumentMetaDataDefinition> metaDataDefinitions) {
		this.documentMetaDataDefinitions = metaDataDefinitions;
	}
	
	public List<MetaData> getMetaDataListByDocumentType(String documentType) {
		for (DocumentMetaDataDefinition metaDataDefinition : documentMetaDataDefinitions) {
			if (metaDataDefinition.getDocumentType().equals(documentType)) {
				return metaDataDefinition.getMetaData();
			}
		}
		return null;
	}
	
	
}


	
	

