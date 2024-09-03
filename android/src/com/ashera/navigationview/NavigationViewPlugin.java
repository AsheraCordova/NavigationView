package com.ashera.navigationview;

import com.ashera.widget.WidgetFactory;

public class NavigationViewPlugin  {
    public static void initPlugin() {
    	//start - widgets
        WidgetFactory.register(new com.ashera.navigationview.BottomNavigationViewImpl());
        WidgetFactory.register(new com.ashera.navigationview.NavigationRailViewImpl());
        //end - widgets
    }
}
