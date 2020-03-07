package models;

public class StudentReport {
	
	private String base64Report;
	
	public StudentReport(String base64Report){
		this.base64Report = base64Report;
	}
	
	public StudentReport(){
	}

	public String getBase64Report() {
		return base64Report;
	}

	public void setBase64Report(String base64Report) {
		this.base64Report = base64Report;
	}

	
	
}
