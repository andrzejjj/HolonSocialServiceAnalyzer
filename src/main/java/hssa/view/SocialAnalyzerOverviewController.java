package hssa.view;

import hssa.Main;
import hssa.model.Measure;
import hssa.model.Result;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;

public class SocialAnalyzerOverviewController {

    private static final Date minimumDateValue = new Date(Long.MIN_VALUE);
    private static final Date maximumDateValue = new Date(Long.MAX_VALUE);

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
    private DatePicker datePickerFrom;

    @FXML
    private DatePicker datePickerTo;
	
	@FXML
    private void initialize() {
		initMeasures();
        initDatePickers();
		initResults();
    }

    private Measure lastSelectedMeasure;

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
                new ChangeListener<Measure>() {
                    @Override
                    public void changed(ObservableValue<? extends Measure> observable, Measure oldValue, Measure newValue) {
                        lastSelectedMeasure = newValue;
                        calculateResults(newValue, datePickerFrom.getValue(), datePickerTo.getValue());
                    }
                });
	}

    private void initDatePickers() {
        EventHandler<ActionEvent> dateRangeChangeHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (lastSelectedMeasure != null) {
                    calculateResults(lastSelectedMeasure, datePickerFrom.getValue(), datePickerTo.getValue());
                }
            }
        };
        datePickerFrom.setOnAction(dateRangeChangeHandler);
        datePickerTo.setOnAction(dateRangeChangeHandler);
    }

    private void initResults() {
		result1Column.setCellValueFactory(cellData -> cellData.getValue().getResult1Property());
		result2Column.setCellValueFactory(cellData -> cellData.getValue().getResult2Property());
		
		resultData = FXCollections.observableArrayList();
		resultTable.setItems(resultData);
	}
	
	private void calculateResults(Measure measure, LocalDate fromDate, LocalDate toDate) {
        Date from =
                fromDate != null ?
                    convertLocalDateToDate(fromDate) :
                    minimumDateValue;
        Date to =
                toDate != null ?
                    convertLocalDateToDate(toDate) :
                    maximumDateValue;
        List<Result> results =
                mainApp.getAgentManager().calculateMeasure(measure.getMeasureName(), from, to);
		resultData.clear();
		resultData.addAll(results);
		resultTable.sort();
	}

    private Date convertLocalDateToDate(LocalDate localDate) {
        Date convertedDate;
        if (localDate == null)
            convertedDate = null;
        else
            convertedDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return convertedDate;
    }

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
        
		ObservableList<Measure> measureData = FXCollections.observableArrayList();
        for(String operationName : mainApp.getAgentManager().GetAvailableMeasures())
        	measureData.add(new Measure(operationName));
        
        measureList.setItems(measureData);
    }
}
