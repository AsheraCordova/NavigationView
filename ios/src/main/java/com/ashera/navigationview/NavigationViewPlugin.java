package com.ashera.navigationview;

import com.ashera.widget.WidgetFactory;

public class NavigationViewPlugin  {
    public static void initPlugin() {
    	//start - widgets
        WidgetFactory.register(new com.ashera.navigationview.BottomNavigationViewImpl());
        WidgetFactory.register(new com.ashera.navigationview.BottomNavigationMenuViewImpl());
        WidgetFactory.register(new com.ashera.navigationview.BottomNavigationItemViewImpl());
        WidgetFactory.register(new com.ashera.navigationview.BaselineLayoutImpl());
        WidgetFactory.register(new com.ashera.navigationview.NavigationRailViewImpl());
        WidgetFactory.register(new com.ashera.navigationview.NavigationRailMenuViewImpl());
        WidgetFactory.register(new com.ashera.navigationview.NavigationRailItemViewImpl());
        WidgetFactory.register(new com.ashera.navigationview.NavigationViewImpl());
        WidgetFactory.register(new com.ashera.navigationview.NavigationMenuItemViewImpl());
        //end - widgets
    }
}
