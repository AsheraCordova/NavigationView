//start - license
/*
 * Copyright (c) 2025 Ashera Cordova
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
//end - license
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
        WidgetFactory.register(new com.ashera.navigationview.NavigationViewImpl());
        WidgetFactory.register(new com.ashera.navigationview.NavigationMenuItemViewImpl());
        //end - widgets
    }
}
