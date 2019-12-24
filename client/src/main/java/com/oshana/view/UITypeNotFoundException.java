package com.oshana.view;

public class UITypeNotFoundException extends RuntimeException {
    public UITypeNotFoundException(String uiType) {
        super("UI type " + uiType + " not recognized.");
    }
}
