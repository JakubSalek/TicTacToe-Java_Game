module com.example.kolkoikrzyzyk {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kolkoikrzyzyk to javafx.fxml;
    exports com.example.kolkoikrzyzyk;
}