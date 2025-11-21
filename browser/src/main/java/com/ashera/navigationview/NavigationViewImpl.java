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
// start - imports
import java.util.*;

import r.android.annotation.SuppressLint;
import r.android.content.Context;
import r.android.os.Build;
import r.android.view.*;
import r.android.widget.*;
import r.android.view.View.*;

import com.ashera.widget.BaseHasWidgets;

import r.android.annotation.SuppressLint;

import com.ashera.core.IFragment;
import com.ashera.widget.bus.*;
import com.ashera.converter.*;
import com.ashera.widget.bus.Event.*;
import com.ashera.widget.*;
import com.ashera.widget.IWidgetLifeCycleListener.*;
import com.ashera.layout.*;

import org.teavm.jso.dom.html.HTMLElement;

import static com.ashera.widget.IWidget.*;
//end - imports
import r.android.content.res.ColorStateList;
import r.android.graphics.drawable.Drawable;
import com.google.android.material.navigation.NavigationView;
public class NavigationViewImpl extends BaseHasWidgets {
	//start - body
	private HTMLElement htmlElement;
	public final static String LOCAL_NAME = "com.google.android.material.navigation.NavigationView"; 
	public final static String GROUP_NAME = "com.google.android.material.navigation.NavigationView";
	private com.google.android.material.navigation.NavigationView navigationView;
	

	
	@Override
	public void loadAttributes(String localName) {
		ViewGroupImpl.register(localName);

		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("itemBackground").withType("drawable").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("itemHorizontalPadding").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("itemIconPadding").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("itemIconSize").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("itemIconTint").withType("colorstate").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("itemMaxLines").withType("int").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("itemTextColor").withType("colorstate").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("itemVerticalPadding").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("menu").withType("resourcestring").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("headerLayout").withType("template").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onItemSelected").withType("string").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("dividerInsetStart").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("dividerInsetEnd").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("subheaderInsetStart").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("subheaderInsetEnd").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("itemTextAppearance").withType("string").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
	
	}
	
	public NavigationViewImpl() {
		super(GROUP_NAME, LOCAL_NAME);
	}
	public  NavigationViewImpl(String localname) {
		super(GROUP_NAME, localname);
	}
	public  NavigationViewImpl(String groupName, String localname) {
		super(groupName, localname);
	}

	@Override
	public IWidget newInstance() {
		return new NavigationViewImpl(groupName, localName);
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
		navigationView = new NavigationViewExt();
		
		nativeCreate(params);
		
		
		ViewGroupImpl.registerCommandConveter(this);

	}

	@Override
	public Object asWidget() {
		return navigationView;
	}

	@Override
	public boolean remove(IWidget w) {
		boolean remove = super.remove(w);
		navigationView.removeView((View) w.asWidget());
		 nativeRemoveView(w);            
		return remove;
	}
	
	@Override
    public boolean remove(int index) {
		IWidget widget = widgets.get(index);
        boolean remove = super.remove(index);

        if (index + 1 <= navigationView.getChildCount()) {
            navigationView.removeViewAt(index);
            nativeRemoveView(widget);
        }    
        return remove;
    }

	private void nativeRemoveView(IWidget widget) {
		r.android.animation.LayoutTransition layoutTransition = navigationView.getLayoutTransition();
		if (layoutTransition != null && (
				layoutTransition.isTransitionTypeEnabled(r.android.animation.LayoutTransition.CHANGE_DISAPPEARING) ||
				layoutTransition.isTransitionTypeEnabled(r.android.animation.LayoutTransition.DISAPPEARING)
				)) {
			addToBufferedRunnables(() -> ViewGroupImpl.nativeRemoveView(widget));          
		} else {
			ViewGroupImpl.nativeRemoveView(widget);
		}
	}
	
	@Override
	public void add(IWidget w, int index) {
		if (index != -2) {
			View view = (View) w.asWidget();
			createLayoutParams(view);
			    if (index == -1) {
			        navigationView.addView(view);
			    } else {
			        navigationView.addView(view, index);
			    }
		}
		
		ViewGroupImpl.nativeAddView(asNativeWidget(), w.asNativeWidget());
		super.add(w, index);
	}
	
	private void createLayoutParams(View view) {
		com.google.android.material.navigation.NavigationView.LayoutParams layoutParams = (com.google.android.material.navigation.NavigationView.LayoutParams) view.getLayoutParams();
		
		layoutParams = (com.google.android.material.navigation.NavigationView.LayoutParams) view.getLayoutParams();
		if (layoutParams == null) {
			layoutParams = new com.google.android.material.navigation.NavigationView.LayoutParams(-2, -2);
			view.setLayoutParams(layoutParams);
		}  else {
			layoutParams.height = -2;
			layoutParams.width = -2;
		}
	}
	
	private com.google.android.material.navigation.NavigationView.LayoutParams getLayoutParams(View view) {
		return (com.google.android.material.navigation.NavigationView.LayoutParams) view.getLayoutParams();		
	}
	
	@SuppressLint("NewApi")
	@Override
	public void setChildAttribute(IWidget w, WidgetAttribute key, String strValue, Object objValue) {
		View view = (View) w.asWidget();
		com.google.android.material.navigation.NavigationView.LayoutParams layoutParams = getLayoutParams(view);
		ViewGroupImpl.setChildAttribute(w, key, objValue, layoutParams);		
		
		switch (key.getAttributeName()) {
		case "layout_width":
			layoutParams.width = (int) objValue;
			break;	
		case "layout_height":
			layoutParams.height = (int) objValue;
			break;
		default:
			break;
		}
		
		
		view.setLayoutParams(layoutParams);		
	}
	
	@SuppressLint("NewApi")
	@Override
	public Object getChildAttribute(IWidget w, WidgetAttribute key) {
		Object attributeValue = ViewGroupImpl.getChildAttribute(w, key);		
		if (attributeValue != null) {
			return attributeValue;
		}
		View view = (View) w.asWidget();
		com.google.android.material.navigation.NavigationView.LayoutParams layoutParams = getLayoutParams(view);

		switch (key.getAttributeName()) {
		case "layout_width":
			return layoutParams.width;
		case "layout_height":
			return layoutParams.height;
		}
		
		return null;

	}
	
		
	public class NavigationViewExt extends com.google.android.material.navigation.NavigationView implements ILifeCycleDecorator, com.ashera.widget.IMaxDimension{
		private MeasureEvent measureFinished = new MeasureEvent();
		private OnLayoutEvent onLayoutEvent = new OnLayoutEvent();
		private List<IWidget> overlays;
		public IWidget getWidget() {
			return NavigationViewImpl.this;
		}
		private int mMaxWidth = -1;
		private int mMaxHeight = -1;
		@Override
		public void setMaxWidth(int width) {
			mMaxWidth = width;
		}
		@Override
		public void setMaxHeight(int height) {
			mMaxHeight = height;
		}
		@Override
		public int getMaxWidth() {
			return mMaxWidth;
		}
		@Override
		public int getMaxHeight() {
			return mMaxHeight;
		}

		public NavigationViewExt() {
			super();
			
		}
		
		@Override
		public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

			if(mMaxWidth > 0) {
	        	widthMeasureSpec = MeasureSpec.makeMeasureSpec(mMaxWidth, MeasureSpec.AT_MOST);
	        }
	        if(mMaxHeight > 0) {
	            heightMeasureSpec = MeasureSpec.makeMeasureSpec(mMaxHeight, MeasureSpec.AT_MOST);

	        }

	        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
			IWidgetLifeCycleListener listener = (IWidgetLifeCycleListener) getListener();
			if (listener != null) {
			    measureFinished.setWidth(getMeasuredWidth());
			    measureFinished.setHeight(getMeasuredHeight());
				listener.eventOccurred(EventId.measureFinished, measureFinished);
			}
		}
		
		@Override
		protected void onLayout(boolean changed, int l, int t, int r, int b) {
			super.onLayout(changed, l, t, r, b);
			ViewImpl.setDrawableBounds(NavigationViewImpl.this, l, t, r, b);
			if (!isOverlay()) {
			ViewImpl.nativeMakeFrame(asNativeWidget(), l, t, r, b);
			}
			replayBufferedEvents();
	        ViewImpl.redrawDrawables(NavigationViewImpl.this);
	        overlays = ViewImpl.drawOverlay(NavigationViewImpl.this, overlays);
			
			IWidgetLifeCycleListener listener = (IWidgetLifeCycleListener) getListener();
			if (listener != null) {
				onLayoutEvent.setB(b);
				onLayoutEvent.setL(l);
				onLayoutEvent.setR(r);
				onLayoutEvent.setT(t);
				onLayoutEvent.setChanged(changed);
				listener.eventOccurred(EventId.onLayout, onLayoutEvent);
			}
			
			if (isInvalidateOnFrameChange() && isInitialised()) {
				NavigationViewImpl.this.invalidate();
			}
		}	
		
		@Override
		public void execute(String method, Object... canvas) {
			
		}

		public void updateMeasuredDimension(int width, int height) {
			setMeasuredDimension(width, height);
		}


		@Override
		public ILifeCycleDecorator newInstance(IWidget widget) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void setAttribute(WidgetAttribute widgetAttribute,
				String strValue, Object objValue) {
			throw new UnsupportedOperationException();
		}		
		

		@Override
		public List<String> getMethods() {
			throw new UnsupportedOperationException();
		}
		
		@Override
		public void initialized() {
			throw new UnsupportedOperationException();
		}
		
        @Override
        public Object getAttribute(WidgetAttribute widgetAttribute) {
            throw new UnsupportedOperationException();
        }
        @Override
        public void drawableStateChanged() {
        	super.drawableStateChanged();
        	if (!isWidgetDisposed()) {
        		ViewImpl.drawableStateChanged(NavigationViewImpl.this);
        	}
        }
        private Map<String, IWidget> templates;
    	@Override
    	public r.android.view.View inflateView(java.lang.String layout) {
    		if (templates == null) {
    			templates = new java.util.HashMap<String, IWidget>();
    		}
    		IWidget template = templates.get(layout);
    		if (template == null) {
    			template = (IWidget) quickConvert(layout, "template");
    			templates.put(layout, template);
    		}
    		
    		IWidget widget = template.loadLazyWidgets(NavigationViewImpl.this);
			return (View) widget.asWidget();
    	}   
        
    	@Override
		public void remeasure() {
    		if (getFragment() != null) {
    			getFragment().remeasure();
    		}
		}
    	
        @Override
		public void removeFromParent() {
        	NavigationViewImpl.this.getParent().remove(NavigationViewImpl.this);
		}
        @Override
        public void getLocationOnScreen(int[] appScreenLocation) {
        	appScreenLocation[0] = htmlElement.getBoundingClientRect().getLeft();
        	appScreenLocation[1] = htmlElement.getBoundingClientRect().getTop();
        }
        @Override
        public void getWindowVisibleDisplayFrame(r.android.graphics.Rect displayFrame){
        	
        	org.teavm.jso.dom.html.TextRectangle boundingClientRect = htmlElement.getBoundingClientRect();
			displayFrame.top = boundingClientRect.getTop();
        	displayFrame.left = boundingClientRect.getLeft();
        	displayFrame.bottom = boundingClientRect.getBottom();
        	displayFrame.right = boundingClientRect.getRight();
        }
        @Override
		public void offsetTopAndBottom(int offset) {
			super.offsetTopAndBottom(offset);
			ViewImpl.nativeMakeFrame(asNativeWidget(), getLeft(), getTop(), getRight(), getBottom());
		}
		@Override
		public void offsetLeftAndRight(int offset) {
			super.offsetLeftAndRight(offset);
			ViewImpl.nativeMakeFrame(asNativeWidget(), getLeft(), getTop(), getRight(), getBottom());
		}
		@Override
		public void setMyAttribute(String name, Object value) {
			if (name.equals("state0")) {
				setState0(value);
				return;
			}
			if (name.equals("state1")) {
				setState1(value);
				return;
			}
			if (name.equals("state2")) {
				setState2(value);
				return;
			}
			if (name.equals("state3")) {
				setState3(value);
				return;
			}
			if (name.equals("state4")) {
				setState4(value);
				return;
			}
			NavigationViewImpl.this.setAttribute(name, value, !(value instanceof String));
		}
        @Override
        public void setVisibility(int visibility) {
            super.setVisibility(visibility);
            ((HTMLElement)asNativeWidget()).getStyle().setProperty("display", visibility != View.VISIBLE ? "none" : "block");
            
        }
        
    	public void setState0(Object value) {
    		ViewImpl.setState(NavigationViewImpl.this, 0, value);
    	}
    	public void setState1(Object value) {
    		ViewImpl.setState(NavigationViewImpl.this, 1, value);
    	}
    	public void setState2(Object value) {
    		ViewImpl.setState(NavigationViewImpl.this, 2, value);
    	}
    	public void setState3(Object value) {
    		ViewImpl.setState(NavigationViewImpl.this, 3, value);
    	}
    	public void setState4(Object value) {
    		ViewImpl.setState(NavigationViewImpl.this, 4, value);
    	}
        	public void state0() {
        		ViewImpl.state(NavigationViewImpl.this, 0);
        	}
        	public void state1() {
        		ViewImpl.state(NavigationViewImpl.this, 1);
        	}
        	public void state2() {
        		ViewImpl.state(NavigationViewImpl.this, 2);
        	}
        	public void state3() {
        		ViewImpl.state(NavigationViewImpl.this, 3);
        	}
        	public void state4() {
        		ViewImpl.state(NavigationViewImpl.this, 4);
        	}
                        
        public void stateYes() {
        	ViewImpl.stateYes(NavigationViewImpl.this);
        	
        }
        
        public void stateNo() {
        	ViewImpl.stateNo(NavigationViewImpl.this);
        }
     
		@Override
		public void endViewTransition(r.android.view.View view) {
			super.endViewTransition(view);
			runBufferedRunnables();
		}
	
	}
	@Override
	public Class getViewClass() {
		return NavigationViewExt.class;
	}
	
	@SuppressLint("NewApi")
	@Override
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
				ViewGroupImpl.setAttribute(this,  key, strValue, objValue, decorator);
		Object nativeWidget = asNativeWidget();
		switch (key.getAttributeName()) {
			case "itemBackground": {


	navigationView.setItemBackground((Drawable)objValue);



			}
			break;
			case "itemHorizontalPadding": {


	navigationView.setItemHorizontalPadding((int)objValue);



			}
			break;
			case "itemIconPadding": {


	navigationView.setItemIconPadding((int)objValue);



			}
			break;
			case "itemIconSize": {


	navigationView.setItemIconSize((int)objValue);



			}
			break;
			case "itemIconTint": {


	navigationView.setItemIconTintList((ColorStateList)objValue);



			}
			break;
			case "itemMaxLines": {


	navigationView.setItemMaxLines((int)objValue);



			}
			break;
			case "itemTextColor": {


	navigationView.setItemTextColor((ColorStateList)objValue);



			}
			break;
			case "itemVerticalPadding": {


	navigationView.setItemVerticalPadding((int)objValue);



			}
			break;
			case "menu": {


		setMenu(objValue);



			}
			break;
			case "headerLayout": {


		 setHeaderLayout(objValue);



			}
			break;
			case "onItemSelected": {


		navigationView.setNavigationItemSelectedListener(new OnNavigationItemSelectedListener(this, strValue, "onNavigationItemSelected"));



			}
			break;
			case "dividerInsetStart": {


	navigationView.setDividerInsetStart((int)objValue);



			}
			break;
			case "dividerInsetEnd": {


	navigationView.setDividerInsetEnd((int)objValue);



			}
			break;
			case "subheaderInsetStart": {


	navigationView.setSubheaderInsetStart((int)objValue);



			}
			break;
			case "subheaderInsetEnd": {


	navigationView.setSubheaderInsetEnd((int)objValue);



			}
			break;
			case "itemTextAppearance": {


	navigationView.setItemTextAppearance((String)objValue);



			}
			break;
		default:
			break;
		}
		
	}
	
	@Override
	@SuppressLint("NewApi")
	public Object getAttribute(WidgetAttribute key, ILifeCycleDecorator decorator) {
		Object attributeValue = ViewGroupImpl.getAttribute(this, key, decorator);
		if (attributeValue != null) {
			return attributeValue;
		}
		Object nativeWidget = asNativeWidget();
		switch (key.getAttributeName()) {
			case "itemBackground": {
return navigationView.getItemBackground();			}
			case "itemHorizontalPadding": {
return navigationView.getItemHorizontalPadding();			}
			case "itemIconPadding": {
return navigationView.getItemIconPadding();			}
			case "itemIconTint": {
return navigationView.getItemIconTintList();			}
			case "itemMaxLines": {
return navigationView.getItemMaxLines();			}
			case "itemTextColor": {
return navigationView.getItemTextColor();			}
			case "itemVerticalPadding": {
return navigationView.getItemVerticalPadding();			}
		}
		return null;
	}


	@Override
    public Object asNativeWidget() {
        return htmlElement;
    }
    
    @Override
    public void requestLayout() {
    	if (isInitialised()) {
    		ViewImpl.requestLayout(this, asNativeWidget());
    	}
    }
    
    @Override
    public void invalidate() {
    	if (isInitialised()) {
    		ViewImpl.invalidate(this, asNativeWidget());
    	}
    }
    
	

private void setMenu(Object objValue) {
	
	String menuStr = (String) objValue;
	String key = menuStr.replace("@menu/", "");
	String json = com.ashera.utils.ResourceBundleUtils.getString("menu/menu", key, fragment);
	navigationView.getMenu().clear();
	navigationView.inflateMenu((HasWidgets) this,  json, fragment);
}



private IWidget header;
private IWidget headerTemplate;
private void setHeaderLayout(Object headerTemplate) {
	this.headerTemplate = (IWidget) headerTemplate;
}

@Override
public java.lang.Object invokeMethod(java.lang.String methodName, java.lang.Object... args) {
	switch (methodName) {
	case "addHeaderView":
		if (headerTemplate != null) {
			if (header != null) {
				remove(header);
				navigationView.removeHeaderView((View) header.asWidget());
			}
			header = ((IWidget) headerTemplate).loadLazyWidgets((HasWidgets) ((ILifeCycleDecorator)args[0]).getWidget());
			navigationView.addHeaderView((View) header.asWidget());
		}
		break;

	default:
		break;
	}
	return super.invokeMethod(methodName, args);
}


	@SuppressLint("NewApi")
private static class OnNavigationItemSelectedListener implements NavigationView.OnNavigationItemSelectedListener, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public OnNavigationItemSelectedListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public OnNavigationItemSelectedListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public boolean onNavigationItemSelected(MenuItem item){
    boolean result = true;
    
	if (action == null || action.equals("onNavigationItemSelected")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onNavigationItemSelected");
	    java.util.Map<String, Object> obj = getOnNavigationItemSelectedEventObj(item);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 Object commandResult = EventCommandFactory.getCommand(commandName).executeCommand(w, obj, item);
		    	 if (commandResult != null) {
		    		 result = (boolean) commandResult;
		    	 }
		    }

			break;
		default:
			break;
		}
		
		if (obj.containsKey("refreshUiFromModel")) {
			Object widgets = obj.remove("refreshUiFromModel");
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, widgets, true);
		}
		if (w.getModelUiToPojoEventIds() != null) {
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, w.getModelUiToPojoEventIds(), true);
		}
		if (strValue != null && !strValue.isEmpty() && !strValue.trim().startsWith("+")) {
		    com.ashera.core.IActivity activity = (com.ashera.core.IActivity)w.getFragment().getRootActivity();
		    if (activity != null) {
		    	activity.sendEventMessage(obj);
		    }
		}
	}
    return result;
}//#####

public java.util.Map<String, Object> getOnNavigationItemSelectedEventObj(MenuItem item) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "navigationitemselected");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    obj.put("namespace", w.getFragment().getNamespace());
    
    if (w.getComponentId() != null) {
    	obj.put("componentId", w.getComponentId());
    }
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        ViewImpl.addEventInfo(obj, item);
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onNavigationItemSelected", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}
}


	@Override
	public void setId(String id){
		if (id != null && !id.equals("")){
			super.setId(id);
			navigationView.setId((int) quickConvert(id, "id"));
		}
	}
	
    
    @Override
    public void setVisible(boolean b) {
        ((View)asWidget()).setVisibility(b ? View.VISIBLE : View.GONE);
    }

		//end - body


private void nativeCreate(Map<String, Object> params) {
	htmlElement = org.teavm.jso.dom.html.HTMLDocument.current().createElement("div");
	htmlElement.getStyle().setProperty("box-sizing", "border-box");
	navigationView.initNavigationView();
}
}
