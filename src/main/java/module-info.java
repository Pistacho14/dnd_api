module org.iesteis {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    opens org.iesteis to javafx.fxml;
    exports org.iesteis;
}