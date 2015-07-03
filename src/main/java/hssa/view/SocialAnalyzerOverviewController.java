package hssa.view;

import hssa.Main;
import hssa.model.Measure;
import hssa.model.Result;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

public class SocialAnalyzerOverviewController {

	private Main mainApp;
	
	@FXML
    private ListView<Measure> measureList;
	
	@FXML
    private TableView<Result> resultTable;
	private ObservableList<Result> resultData;
	
    @FXML
    private TableColumn<Result, String> result1Column;
    
    @FXML
    private TableColumn<Result, String> result2Column;
	
	@FXML
    private void initialize() {
		initMeasures();
		initResults();
    }
	
	private void initMeasures() {
		
		measureList.setCellFactory(new Callback<ListView<Measure>, ListCell<Measure>>() {

            @Override
            public ListCell<Measure> call(ListView<Measure> param) {
                ListCell<Measure> cell = new ListCell<Measure>() {

                    @Override
                    protected void updateItem(Measure item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item.getMeasureName());
                        } else {
                            setText("");
                        }
                    }
                };
                return cell;
            }
        });
		
		measureList.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> calculateResults(newValue));
	}
	
	private void initResults() {
		result1Column.setCellValueFactory(cellData -> cellData.getValue().getResult1Property());
		result2Column.setCellValueFactory(cellData -> cellData.getValue().getResult2Property());
		
		resultData = FXCollections.observableArrayList();
		resultTable.setItems(resultData);
	}
	
	private void calculateResults(Measure measure) {
		List<Result> results = mainApp.getAgentManager().calculateMeasure(measure.getMeasureName());
		resultData.clear();
		resultData.addAll(results);
		resultTable.sort();
	}

	public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
        
		ObservableList<Measure> measureData = FXCollections.observableArrayList();
        for(String operationName : mainApp.getAgentManager().GetAvailableMeasures())
        	measureData.add(new Measure(operationName));
        
        measureList.setItems(measureData);
    }
}
