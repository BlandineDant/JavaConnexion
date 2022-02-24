module org.openjfx.javafx_archetype_simple {
    requires javafx.controls;
    requires javafx.fxml;
	requires json.simple;
	requires javafx.base;
	requires javafx.graphics;
	requires junit;
    opens org.openjfx.javafx_archetype_simple to javafx.fxml;
    exports org.openjfx.javafx_archetype_simple;
}
