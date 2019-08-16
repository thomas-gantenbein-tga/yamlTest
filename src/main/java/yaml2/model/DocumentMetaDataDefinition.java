package yaml2.model;

import java.util.List;

public class DocumentMetaDataDefinition {
	
	String documentType;
	private List<MetaData> metaDataList;
	
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public List<MetaData> getMetaData() {
		return metaDataList;
	}
	public void setMetaData(List<MetaData> metaData) {
		this.metaDataList = metaData;
	}

}
