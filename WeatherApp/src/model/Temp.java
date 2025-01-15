package model;

public class Temp {
    private double day;
    
    public Temp(double day) {
		this.day = day;
	}
    
    public Temp() {
	}


	public double getDay() {
        return day;
    }

    public void setDay(double day) {
        this.day = day;
    }

  
    @Override
    public String toString() {
        return "Temp [day=" + day + "]";
    }
}
