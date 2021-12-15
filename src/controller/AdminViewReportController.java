package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

public class AdminViewReportController {
    public AnchorPane ReportContext;

    public void AddminDashBoard(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("/view/AdminDashBoard.fxml");
        Parent load = FXMLLoader.load(resource);
        ReportContext.getChildren().clear();
        ReportContext.getChildren().add(load);
    }
}
