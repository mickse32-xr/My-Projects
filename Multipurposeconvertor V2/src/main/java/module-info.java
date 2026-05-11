module com.example.multipurposeconvertorv2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.multipurposeconvertorv2 to javafx.fxml;
    exports com.example.multipurposeconvertorv2;
}