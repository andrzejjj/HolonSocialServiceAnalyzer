package hssa.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Result {
	
	private final StringProperty result1;
	private final StringProperty result2;
	
	public Result() {
        this(null, null);
    }
	
	public Result(String result1, String result2) {
        this.result1 = new SimpleStringProperty(result1);
        this.result2 = new SimpleStringProperty(result2);
    }

	public String getResult1() {
        return result1.get();
    }

    public void setResult1(String value) {
        this.result1.set(value);
    }

    public StringProperty getResult1Property() {
        return result1;
    }
    
    public String getResult2() {
        return result2.get();
    }

    public void setResult2(String value) {
        this.result2.set(value);
    }
    
    public StringProperty getResult2Property() {
        return result2;
    }
}
