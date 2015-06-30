package hssa.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Measure {
	
	private final StringProperty measureName;
	
	public Measure() {
        this(null);
    }
	
	public Measure(String measureName) {
        this.measureName = new SimpleStringProperty(measureName);
    }

	public String getMeasureName() {
        return measureName.get();
    }

    public void setMeasureName(String value) {
        this.measureName.set(value);
    }
}