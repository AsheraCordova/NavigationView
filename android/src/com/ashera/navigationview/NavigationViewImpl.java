package com.ashera.navigationview;
//start - imports

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import android.content.Context;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.widget.*;
import androidx.core.view.*;
import android.view.*;
import android.graphics.drawable.*;


import android.os.Build;
import android.view.View;
import android.text.*;

import com.ashera.core.IFragment;
import com.ashera.converter.*;

import android.annotation.SuppressLint;

import com.ashera.layout.*;
import com.ashera.plugin.*;
import com.ashera.widget.bus.*;
import com.ashera.widget.*;
import com.ashera.widget.bus.Event.*;
import com.ashera.widget.IWidgetLifeCycleListener.EventId;
import com.ashera.widget.IWidgetLifeCycleListener.EventId.*;


import static com.ashera.widget.IWidget.*;
//end - imports

import android.content.res.ColorStateList;
import com.google.android.material.navigation.NavigationView;
@SuppressLint("NewApi")
public class NavigationViewImpl extends BaseWidget {
	//start - body
	public final static String LOCAL_NAME = "com.google.android.material.navigation.NavigationView"; 
	public final static String GROUP_NAME = "com.google.android.material.navigation.NavigationView";

	protected com.google.android.material.navigation.NavigationView navigationView;
	
	
	@Override
	public void loadAttributes(String attributeName) {
		ViewImpl.register(attributeName);


		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("itemBackground").withType("drawable"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("itemHorizontalPadding").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("itemIconPadding").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("itemIconSize").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("itemIconTint").withType("colorstate"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("itemMaxLines").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("itemTextAppearance").withType("style"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("itemTextAppearanceActiveBoldEnabled").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("itemTextColor").withType("colorstate"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("itemVerticalPadding").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("menu").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("headerLayout").withType("template"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onItemSelected").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("bottomInsetScrimEnabled").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("dividerInsetStart").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("dividerInsetEnd").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("subheaderInsetStart").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("subheaderInsetEnd").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("topInsetScrimEnabled").withType("boolean"));
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

		
	public class NavigationViewExt extends com.google.android.material.navigation.NavigationView implements ILifeCycleDecorator, com.ashera.widget.IMaxDimension{
		private MeasureEvent measureFinished = new MeasureEvent();
		private OnLayoutEvent onLayoutEvent = new OnLayoutEvent();
		
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

		public NavigationViewExt(Context context, android.util.AttributeSet attrs, int defStyleAttr) {
	        super(context, attrs, defStyleAttr);
	    }

		public NavigationViewExt(Context context) {
			super(context);
			
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
			
			ViewImpl.nativeMakeFrame(asNativeWidget(), l, t, r, b);
			
			replayBufferedEvents();
			
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
		public void onDraw(Canvas canvas) {
			Runnable runnable = () -> super.onDraw(canvas);
			executeMethodListeners("onDraw", runnable, canvas);
		}

		@Override
		public void draw(Canvas canvas) {
			Runnable runnable = () -> super.draw(canvas);
			executeMethodListeners("draw", runnable, canvas);
		}

		@SuppressLint("WrongCall")
		@Override
		public void execute(String method, Object... args) {
			switch (method) {
				case "onDraw":
					setOnMethodCalled(true);
					super.onDraw((Canvas) args[0]);
					break;

				case "draw":
					setOnMethodCalled(true);
					super.draw((Canvas) args[0]);
					break;

				default:
					break;
			}
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
        
    	public void setState0(float value) {
    		ViewImpl.setState(NavigationViewImpl.this, 0, value);
    	}
    	public void setState0(int value) {
    		ViewImpl.setState(NavigationViewImpl.this, 0, value);
    	}
    	public void setState0(double value) {
    		ViewImpl.setState(NavigationViewImpl.this, 0, value);
    	}
    	
    	public void setState0(Float value) {
    		ViewImpl.setState(NavigationViewImpl.this, 0, value);
    	}
    	public void setState0(Integer value) {
    		ViewImpl.setState(NavigationViewImpl.this, 0, value);
    	}
    	public void setState0(Double value) {
    		ViewImpl.setState(NavigationViewImpl.this, 0, value);
    	}
    	public void setState0(Object value) {
    		ViewImpl.setState(NavigationViewImpl.this, 0, value);
    	}
    	public void setState1(float value) {
    		ViewImpl.setState(NavigationViewImpl.this, 1, value);
    	}
    	public void setState1(int value) {
    		ViewImpl.setState(NavigationViewImpl.this, 1, value);
    	}
    	public void setState1(double value) {
    		ViewImpl.setState(NavigationViewImpl.this, 1, value);
    	}
    	
    	public void setState1(Float value) {
    		ViewImpl.setState(NavigationViewImpl.this, 1, value);
    	}
    	public void setState1(Integer value) {
    		ViewImpl.setState(NavigationViewImpl.this, 1, value);
    	}
    	public void setState1(Double value) {
    		ViewImpl.setState(NavigationViewImpl.this, 1, value);
    	}
    	public void setState1(Object value) {
    		ViewImpl.setState(NavigationViewImpl.this, 1, value);
    	}
    	public void setState2(float value) {
    		ViewImpl.setState(NavigationViewImpl.this, 2, value);
    	}
    	public void setState2(int value) {
    		ViewImpl.setState(NavigationViewImpl.this, 2, value);
    	}
    	public void setState2(double value) {
    		ViewImpl.setState(NavigationViewImpl.this, 2, value);
    	}
    	
    	public void setState2(Float value) {
    		ViewImpl.setState(NavigationViewImpl.this, 2, value);
    	}
    	public void setState2(Integer value) {
    		ViewImpl.setState(NavigationViewImpl.this, 2, value);
    	}
    	public void setState2(Double value) {
    		ViewImpl.setState(NavigationViewImpl.this, 2, value);
    	}
    	public void setState2(Object value) {
    		ViewImpl.setState(NavigationViewImpl.this, 2, value);
    	}
    	public void setState3(float value) {
    		ViewImpl.setState(NavigationViewImpl.this, 3, value);
    	}
    	public void setState3(int value) {
    		ViewImpl.setState(NavigationViewImpl.this, 3, value);
    	}
    	public void setState3(double value) {
    		ViewImpl.setState(NavigationViewImpl.this, 3, value);
    	}
    	
    	public void setState3(Float value) {
    		ViewImpl.setState(NavigationViewImpl.this, 3, value);
    	}
    	public void setState3(Integer value) {
    		ViewImpl.setState(NavigationViewImpl.this, 3, value);
    	}
    	public void setState3(Double value) {
    		ViewImpl.setState(NavigationViewImpl.this, 3, value);
    	}
    	public void setState3(Object value) {
    		ViewImpl.setState(NavigationViewImpl.this, 3, value);
    	}
    	public void setState4(float value) {
    		ViewImpl.setState(NavigationViewImpl.this, 4, value);
    	}
    	public void setState4(int value) {
    		ViewImpl.setState(NavigationViewImpl.this, 4, value);
    	}
    	public void setState4(double value) {
    		ViewImpl.setState(NavigationViewImpl.this, 4, value);
    	}
    	
    	public void setState4(Float value) {
    		ViewImpl.setState(NavigationViewImpl.this, 4, value);
    	}
    	public void setState4(Integer value) {
    		ViewImpl.setState(NavigationViewImpl.this, 4, value);
    	}
    	public void setState4(Double value) {
    		ViewImpl.setState(NavigationViewImpl.this, 4, value);
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
     
	
	}	@Override
	public Class getViewClass() {
		return NavigationViewExt.class;
	}

	@Override
	public IWidget newInstance() {
		return new NavigationViewImpl(groupName, localName);
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
Context context = (Context) fragment.getRootActivity();
	Object systemStyle = params.get("systemStyle");
	Object systemAndroidAttrStyle = params.get("systemAndroidAttrStyle");
	
	if (systemStyle == null && systemAndroidAttrStyle == null) {
		navigationView = new NavigationViewExt(context);
	} else {
		int defStyleAttr = 0;
		int defStyleRes = 0;
		
		if (systemStyle != null) {
			defStyleRes = context.getResources().getIdentifier((String) systemStyle, "style", context.getPackageName());	
		}
		
		if (systemAndroidAttrStyle != null) {
			defStyleAttr = context.getResources().getIdentifier((String) systemAndroidAttrStyle, "attr", "android");	
		}
		
		if (defStyleRes == 0) {
			navigationView = new NavigationViewExt(context, null, defStyleAttr);	
		} else {
		}
		
	}

		nativeCreate(params);	
		ViewImpl.registerCommandConveter(this);
	}

	@Override
	@SuppressLint("NewApi")
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		Object nativeWidget = asNativeWidget();
		ViewImpl.setAttribute(this,  key, strValue, objValue, decorator);
		
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
			case "itemTextAppearance": {
				


	navigationView.setItemTextAppearance((int)objValue);



			}
			break;
			case "itemTextAppearanceActiveBoldEnabled": {
				


	navigationView.setItemTextAppearanceActiveBoldEnabled((boolean)objValue);



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
			case "bottomInsetScrimEnabled": {
				


	navigationView.setBottomInsetScrimEnabled((boolean)objValue);



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
			case "topInsetScrimEnabled": {
				


	navigationView.setTopInsetScrimEnabled((boolean)objValue);



			}
			break;
		default:
			break;
		}
		
	}
	
	@Override
	@SuppressLint("NewApi")
	public Object getAttribute(WidgetAttribute key, ILifeCycleDecorator decorator) {
		Object nativeWidget = asNativeWidget();
		Object attributeValue = ViewImpl.getAttribute(this, nativeWidget, key, decorator);
		if (attributeValue != null) {
			return attributeValue;
		}
		switch (key.getAttributeName()) {
			case "itemBackground": {
return navigationView.getItemBackground();				}
			case "itemHorizontalPadding": {
return navigationView.getItemHorizontalPadding();				}
			case "itemIconPadding": {
return navigationView.getItemIconPadding();				}
			case "itemIconTint": {
return navigationView.getItemIconTintList();				}
			case "itemMaxLines": {
return navigationView.getItemMaxLines();				}
			case "itemTextColor": {
return navigationView.getItemTextColor();				}
			case "itemVerticalPadding": {
return navigationView.getItemVerticalPadding();				}
		}
		
		return null;
	}
	
	@Override
	public Object asWidget() {
		return navigationView;
	}

	

private void setMenu(Object objValue) {
	String menuStr = (String) objValue;
	String menuId = menuStr.replace("@+id/", "").replace("@id/", "");

	Context context = ((androidx.fragment.app.Fragment) fragment).getContext();
	int resId = context.getResources().getIdentifier(menuId, "menu", context.getPackageName());
	navigationView.getMenu().clear();
	navigationView.inflateMenu(resId);
	
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
    
    if (w.getComponentId() != null) {
    	obj.put("componentId", w.getComponentId());
    }
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        ViewImpl.addEventInfo(obj, item, w.getFragment());
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onNavigationItemSelected", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}
}

	
	    @Override
	    public Object asNativeWidget() {
	        return navigationView;
	    }

	    private void nativeCreate(Map<String, Object> params) {
	    }
	@Override
	public void setId(String id){
		if (id != null && !id.equals("")){
			super.setId(id);
			navigationView.setId((int) quickConvert(id, "id"));
		}
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

	
		//end - body


private View headerView;
private void setHeaderLayout(Object headerTemplate) {
	if (headerView != null) {
		navigationView.removeHeaderView(headerView);
	}
	headerView = (View) ((IWidget) headerTemplate).loadLazyWidgets((com.ashera.model.LoopParam) null).asWidget();
	navigationView.addHeaderView(headerView);
}
}
