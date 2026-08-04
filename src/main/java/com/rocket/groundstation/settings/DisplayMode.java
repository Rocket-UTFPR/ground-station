package com.rocket.groundstation.settings;


public enum DisplayMode {
    WINDOWED,
    FULLSCREEN,
    BORDERLESSWINDOW;
    
    public static DisplayMode valueOf(Object o){
        if(o.equals("Janela")) return WINDOWED;
        else if(o.equals("Tela cheia")) return FULLSCREEN;        
        else if(o.equals("Janela sem bordas")) return BORDERLESSWINDOW;
        else return null;
    }
}
