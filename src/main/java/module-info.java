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
    opens org.iesteis.model.abilityScore to tools.jackson.databind;
    opens org.iesteis.model.alignments to tools.jackson.databind;
    opens org.iesteis.model.background to tools.jackson.databind;
    opens org.iesteis.model.classes to tools.jackson.databind;
    opens org.iesteis.model.conditions to tools.jackson.databind;
    opens org.iesteis.model.damageTypes to tools.jackson.databind;
    opens org.iesteis.model.equipment to tools.jackson.databind;
    opens org.iesteis.model.feats to tools.jackson.databind;
    exports org.iesteis;
}