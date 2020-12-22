package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentListController implements Initializable {

	private DepartmentService service;
	
	@FXML
	private TableView<Department> tableViewDepartment;
	@FXML
	private TableColumn<Department, Integer> tableColumnId;
	@FXML
	private TableColumn<Department, Integer> tableColumnName;
	@FXML
	private Button btnNew;
	
	private ObservableList<Department> obslist;
	
	@FXML
	public void onBtnNewAction() {
		System.out.println("Button New clicked.");
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rs) {
		initializeNodes();
	}

	private void initializeNodes() {
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
	}

	public void setService(DepartmentService service) {
		this.service = service;
	}
	
	public void updateTableView() {
		if(service == null)
			throw new IllegalStateException("Service was null");
		
		List<Department> departmentList = service.findAll();
		obslist = FXCollections.observableArrayList(departmentList);
		tableViewDepartment.setItems(obslist);
	}

}
