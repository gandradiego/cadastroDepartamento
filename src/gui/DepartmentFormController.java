package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DepartmentFormController implements Initializable {

	@FXML
	private TextField txtFieldId;
	@FXML
	private TextField txtFieldName;
	@FXML
	private Label labelError;
	@FXML
	private Button btnSave;
	@FXML
	private Button btnCancel;
	
	@FXML
	public void onBtnSaveAction() {
		System.out.println("Botão salvar");
	}
	
	@FXML
	public void onBtnCancelAction() {
		System.out.println("Botão cancelar");
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	private void initializeNodes() {
		Constraints.setTextFieldInteger(txtFieldId);
		Constraints.setTextFieldMaxLength(txtFieldName, 30);
	}

}
