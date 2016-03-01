package fr.polytechunice.knnincan.json;

public class DataSet {

	String datasetid;
    Coordinate fields;
    
    public DataSet() {
		super();
	}
	
	public String getDatasetid() {
		return datasetid;
	}
	public void setDatasetid(String datasetid) {
		this.datasetid = datasetid;
	}
	public Coordinate getFields() {
		return fields;
	}
	public void setFields(Coordinate fields) {
		this.fields = fields;
	}

    
}
