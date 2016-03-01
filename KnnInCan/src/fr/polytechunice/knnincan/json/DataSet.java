package fr.polytechunice.knnincan.json;

public class DataSet {

	String datasetid;
    Fields fields;
    
    public DataSet() {
		super();
	}
	
	public String getDatasetid() {
		return datasetid;
	}
	public void setDatasetid(String datasetid) {
		this.datasetid = datasetid;
	}
	public Fields getFields() {
		return fields;
	}
	public void setFields(Fields fields) {
		this.fields = fields;
	}

    
}
