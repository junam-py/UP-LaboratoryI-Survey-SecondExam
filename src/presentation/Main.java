package presentation;

import services.DataInitialization;

public class Main {
    public static void main(String[] args) {
        DataInitialization data = new DataInitialization();
        data.initilizeData();

        PanelManager manager = new PanelManager();
        manager.showFrame();
    }
}
