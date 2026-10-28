module org.iesteis {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires tools.jackson.dataformat.xml;
    requires com.fasterxml.jackson.annotation;
    requires java.net.http;
    requires java.sql;
    requires org.slf4j;
    opens org.iesteis to javafx.fxml;
    opens org.iesteis.model to tools.jackson.databind;
    opens org.iesteis.model.AbilityScore to tools.jackson.databind;
    opens org.iesteis.model.Alignments to tools.jackson.databind;
    opens org.iesteis.model.Background to tools.jackson.databind;
    opens org.iesteis.model.Classes to tools.jackson.databind;
    opens org.iesteis.model.Conditions to tools.jackson.databind;
    opens org.iesteis.model.DamageTypes to tools.jackson.databind;
    opens org.iesteis.model.Equipment to tools.jackson.databind;
    opens org.iesteis.model.Feats to tools.jackson.databind;
    exports org.iesteis;
}