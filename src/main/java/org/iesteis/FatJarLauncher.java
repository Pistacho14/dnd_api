package org.iesteis;

import javafx.application.Application;

public final class FatJarLauncher {

    private FatJarLauncher() {
    }

    public static void main(String[] args) {
        Application.launch(MainApp.class, args);
    }
}
