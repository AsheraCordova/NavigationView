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

import androidx.core.view.*;

import static com.ashera.widget.IWidget.*;
//end - imports
import r.android.content.res.ColorStateList;
import r.android.graphics.drawable.Drawable;
import com.google.android.material.navigation.NavigationView;

public class NavigationViewImpl extends BaseHasWidgets {
	//start - body
	private Object pane;
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
        	org.eclipse.swt.widgets.Control control = (org.eclipse.swt.widgets.Control) asNativeWidget();
			appScreenLocation[0] = control.toDisplay(0, 0).x;
        	appScreenLocation[1] = control.toDisplay(0, 0).y;
        }
        @Override
        public void getWindowVisibleDisplayFrame(r.android.graphics.Rect displayFrame){
        	org.eclipse.swt.widgets.Shell shell = ((org.eclipse.swt.widgets.Control)asNativeWidget()).getShell();
        	displayFrame.left = shell.toDisplay(0, 0).x ;
			displayFrame.top = shell.getShell().toDisplay(0, 0).y ;
        	displayFrame.bottom = displayFrame.top + shell.getClientArea().height;
        	displayFrame.right = displayFrame.left + shell.getBounds().width;
        	
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
            org.eclipse.swt.widgets.Control control = ((org.eclipse.swt.widgets.Control)asNativeWidget());
            if (!control.isDisposed()) {
            	control.setVisible(View.VISIBLE == visibility);
            }
            
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
				ViewGroupImpl.setAttribute(this, key, strValue, objValue, decorator);
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
        return pane;
    }
    public boolean isWidgetDisposed() {
		return ((org.eclipse.swt.widgets.Control) pane).isDisposed();
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
		    activity.sendEventMessage(obj);
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
    public int getStyle(String key, int initStyle, Map<String, Object> params, IFragment fragment) {
    	if (params == null) {
    		return initStyle;
    	}
    	Object style = params.get(key);
		if (style == null) {
			return initStyle;
		}
		int convertFrom = (int) ConverterFactory.get("swtbitflag").convertFrom(style.toString(), null, fragment);
		return convertFrom;
	}
	
	public int getStyle(Map<String, Object> params, IFragment fragment) {
		return getStyle("swtStyle", org.eclipse.swt.SWT.NONE, params, fragment);
	}
	
	public int getStyle(int initStyle, Map<String, Object> params, IFragment fragment) {
		return getStyle("swtStyle", initStyle, params, fragment);
	}

	
private NavigationViewCommandBuilder builder;
private NavigationViewBean bean;
public Object getPlugin(String plugin) {
	return WidgetFactory.getAttributable(plugin).newInstance(this);
}
public NavigationViewBean getBean() {
	if (bean == null) {
		bean = new NavigationViewBean();
	}
	return bean;
}
public NavigationViewCommandBuilder getBuilder() {
	if (builder == null) {
		builder = new NavigationViewCommandBuilder();
	}
	return builder;
}


public  class NavigationViewCommandBuilder extends com.ashera.layout.ViewGroupImpl.ViewGroupCommandBuilder <NavigationViewCommandBuilder> {
    public NavigationViewCommandBuilder() {
	}
	
	public NavigationViewCommandBuilder execute(boolean setter) {
		if (setter) {
			executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			getFragment().remeasure();
		}
		executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);
return this;	}

public NavigationViewCommandBuilder tryGetItemBackground() {
	Map<String, Object> attrs = initCommand("itemBackground");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getItemBackground() {
	Map<String, Object> attrs = initCommand("itemBackground");
	return attrs.get("commandReturnValue");
}
public NavigationViewCommandBuilder setItemBackground(String value) {
	Map<String, Object> attrs = initCommand("itemBackground");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationViewCommandBuilder tryGetItemHorizontalPadding() {
	Map<String, Object> attrs = initCommand("itemHorizontalPadding");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getItemHorizontalPadding() {
	Map<String, Object> attrs = initCommand("itemHorizontalPadding");
	return attrs.get("commandReturnValue");
}
public NavigationViewCommandBuilder setItemHorizontalPadding(String value) {
	Map<String, Object> attrs = initCommand("itemHorizontalPadding");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationViewCommandBuilder tryGetItemIconPadding() {
	Map<String, Object> attrs = initCommand("itemIconPadding");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getItemIconPadding() {
	Map<String, Object> attrs = initCommand("itemIconPadding");
	return attrs.get("commandReturnValue");
}
public NavigationViewCommandBuilder setItemIconPadding(String value) {
	Map<String, Object> attrs = initCommand("itemIconPadding");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationViewCommandBuilder setItemIconSize(String value) {
	Map<String, Object> attrs = initCommand("itemIconSize");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationViewCommandBuilder tryGetItemIconTint() {
	Map<String, Object> attrs = initCommand("itemIconTint");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getItemIconTint() {
	Map<String, Object> attrs = initCommand("itemIconTint");
	return attrs.get("commandReturnValue");
}
public NavigationViewCommandBuilder setItemIconTint(String value) {
	Map<String, Object> attrs = initCommand("itemIconTint");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationViewCommandBuilder tryGetItemMaxLines() {
	Map<String, Object> attrs = initCommand("itemMaxLines");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getItemMaxLines() {
	Map<String, Object> attrs = initCommand("itemMaxLines");
	return attrs.get("commandReturnValue");
}
public NavigationViewCommandBuilder setItemMaxLines(int value) {
	Map<String, Object> attrs = initCommand("itemMaxLines");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationViewCommandBuilder tryGetItemTextColor() {
	Map<String, Object> attrs = initCommand("itemTextColor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getItemTextColor() {
	Map<String, Object> attrs = initCommand("itemTextColor");
	return attrs.get("commandReturnValue");
}
public NavigationViewCommandBuilder setItemTextColor(String value) {
	Map<String, Object> attrs = initCommand("itemTextColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationViewCommandBuilder tryGetItemVerticalPadding() {
	Map<String, Object> attrs = initCommand("itemVerticalPadding");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getItemVerticalPadding() {
	Map<String, Object> attrs = initCommand("itemVerticalPadding");
	return attrs.get("commandReturnValue");
}
public NavigationViewCommandBuilder setItemVerticalPadding(String value) {
	Map<String, Object> attrs = initCommand("itemVerticalPadding");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationViewCommandBuilder setMenu(String value) {
	Map<String, Object> attrs = initCommand("menu");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationViewCommandBuilder setHeaderLayout(String value) {
	Map<String, Object> attrs = initCommand("headerLayout");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationViewCommandBuilder setOnItemSelected(String value) {
	Map<String, Object> attrs = initCommand("onItemSelected");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationViewCommandBuilder setDividerInsetStart(String value) {
	Map<String, Object> attrs = initCommand("dividerInsetStart");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationViewCommandBuilder setDividerInsetEnd(String value) {
	Map<String, Object> attrs = initCommand("dividerInsetEnd");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationViewCommandBuilder setSubheaderInsetStart(String value) {
	Map<String, Object> attrs = initCommand("subheaderInsetStart");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationViewCommandBuilder setSubheaderInsetEnd(String value) {
	Map<String, Object> attrs = initCommand("subheaderInsetEnd");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationViewCommandBuilder setItemTextAppearance(String value) {
	Map<String, Object> attrs = initCommand("itemTextAppearance");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}
public class NavigationViewBean extends com.ashera.layout.ViewGroupImpl.ViewGroupBean{
		public NavigationViewBean() {
			super(NavigationViewImpl.this);
		}
public Object getItemBackground() {
	return getBuilder().reset().tryGetItemBackground().execute(false).getItemBackground(); 
}
public void setItemBackground(String value) {
	getBuilder().reset().setItemBackground(value).execute(true);
}

public Object getItemHorizontalPadding() {
	return getBuilder().reset().tryGetItemHorizontalPadding().execute(false).getItemHorizontalPadding(); 
}
public void setItemHorizontalPadding(String value) {
	getBuilder().reset().setItemHorizontalPadding(value).execute(true);
}

public Object getItemIconPadding() {
	return getBuilder().reset().tryGetItemIconPadding().execute(false).getItemIconPadding(); 
}
public void setItemIconPadding(String value) {
	getBuilder().reset().setItemIconPadding(value).execute(true);
}

public void setItemIconSize(String value) {
	getBuilder().reset().setItemIconSize(value).execute(true);
}

public Object getItemIconTint() {
	return getBuilder().reset().tryGetItemIconTint().execute(false).getItemIconTint(); 
}
public void setItemIconTint(String value) {
	getBuilder().reset().setItemIconTint(value).execute(true);
}

public Object getItemMaxLines() {
	return getBuilder().reset().tryGetItemMaxLines().execute(false).getItemMaxLines(); 
}
public void setItemMaxLines(int value) {
	getBuilder().reset().setItemMaxLines(value).execute(true);
}

public Object getItemTextColor() {
	return getBuilder().reset().tryGetItemTextColor().execute(false).getItemTextColor(); 
}
public void setItemTextColor(String value) {
	getBuilder().reset().setItemTextColor(value).execute(true);
}

public Object getItemVerticalPadding() {
	return getBuilder().reset().tryGetItemVerticalPadding().execute(false).getItemVerticalPadding(); 
}
public void setItemVerticalPadding(String value) {
	getBuilder().reset().setItemVerticalPadding(value).execute(true);
}

public void setMenu(String value) {
	getBuilder().reset().setMenu(value).execute(true);
}

public void setHeaderLayout(String value) {
	getBuilder().reset().setHeaderLayout(value).execute(true);
}

public void setOnItemSelected(String value) {
	getBuilder().reset().setOnItemSelected(value).execute(true);
}

public void setDividerInsetStart(String value) {
	getBuilder().reset().setDividerInsetStart(value).execute(true);
}

public void setDividerInsetEnd(String value) {
	getBuilder().reset().setDividerInsetEnd(value).execute(true);
}

public void setSubheaderInsetStart(String value) {
	getBuilder().reset().setSubheaderInsetStart(value).execute(true);
}

public void setSubheaderInsetEnd(String value) {
	getBuilder().reset().setSubheaderInsetEnd(value).execute(true);
}

public void setItemTextAppearance(String value) {
	getBuilder().reset().setItemTextAppearance(value).execute(true);
}

}


private NavigationViewCommandParamsBuilder paramsBuilder;
private NavigationViewParamsBean paramsBean;

public NavigationViewParamsBean getParamsBean() {
	if (paramsBean == null) {
		paramsBean = new NavigationViewParamsBean();
	}
	return paramsBean;
}
public NavigationViewCommandParamsBuilder getParamsBuilder() {
	if (paramsBuilder == null) {
		paramsBuilder = new NavigationViewCommandParamsBuilder();
	}
	return paramsBuilder;
}



public class NavigationViewParamsBean extends com.ashera.layout.ViewGroupImpl.ViewGroupParamsBean{
}





public class NavigationViewCommandParamsBuilder extends com.ashera.layout.ViewGroupImpl.ViewGroupCommandParamsBuilder<NavigationViewCommandParamsBuilder>{
}

	//end - body
private void nativeCreate(Map<String, Object> params) {

    pane = new org.eclipse.swt.widgets.Composite((org.eclipse.swt.widgets.Composite)ViewImpl.getParent(this), getStyle(params, fragment));
    ((org.eclipse.swt.widgets.Composite)pane).setLayout(new org.eclipse.nebula.widgets.layout.AbsoluteLayout());
    navigationView.initNavigationView();

}

//start - headerlayout
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
//end - headerlayout
}
