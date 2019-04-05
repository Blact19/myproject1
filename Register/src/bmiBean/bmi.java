package bmiBean;

public class bmi {
	private int Height;
	private double Weight;
	private int Patient_Id;
	public int getPatient_Id() {
		return Patient_Id;
	}
	public void setPatient_Id(int patient_Id) {
		Patient_Id = patient_Id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	private String FirstName;
	public int getHeight() {
		return Height;
	}
	public void setHeight(int height) {
		Height = height;
	}
	public double getWeight() {
		return Weight;
	}
	public void setWeight(double weight) {
		Weight = weight;
	}
	
}
