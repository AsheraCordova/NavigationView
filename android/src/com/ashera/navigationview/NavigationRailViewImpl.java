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

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.navigation.NavigationBarView;

@SuppressLint("NewApi")
public class NavigationRailViewImpl extends BaseWidget {
	//start - body
	public final static String LOCAL_NAME = "com.google.android.material.navigationrail.NavigationRailView"; 
	public final static String GROUP_NAME = "com.google.android.material.navigationrail.NavigationRailView";

	protected com.google.android.material.navigationrail.NavigationRailView navigationRailView;
	
		@SuppressLint("NewApi")
		final static class LabelVisibilityMode extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("auto",  0xffffffff);
				mapping.put("selected",  0x00000000);
				mapping.put("labeled",  0x00000001);
				mapping.put("unlabeled",  0x00000002);
				}
		@Override
		public Map<String, Integer> getMapping() {
				return mapping;
				}

		@Override
		public Integer getDefault() {
				return 0;
				}
				}
	
	@Override
	public void loadAttributes(String attributeName) {
		ViewImpl.register(attributeName);


		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("headerLayout").withType("template"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("menuGravity").withType("gravity"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onItemSelected").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onItemReselected").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("menu").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("itemIconTint").withType("colorstate"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("itemIconSize").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("itemTextColor").withType("colorstate"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("itemBackground").withType("drawable"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("itemRippleColor").withType("colorstate"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("selectedItemId").withType("id"));
		ConverterFactory.register("com.google.android.material.navigationrail.NavigationRailView.LabelVisibilityMode", new LabelVisibilityMode());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("labelVisibilityMode").withType("com.google.android.material.navigationrail.NavigationRailView.LabelVisibilityMode"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("itemTextAppearanceInactive").withType("style"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("itemTextAppearanceActive").withType("style"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("badgeNumbers").withType("array").withArrayType("int").withOrder(10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("menuItemIds").withType("array").withArrayType("id").withOrder(-1));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("badgeBackgroundColors").withType("array").withArrayType("color").withOrder(10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("badgeTextColors").withType("array").withArrayType("color").withOrder(10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("badgeAlphas").withType("array").withArrayType("int").withOrder(10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("badgeMaxCharacterCounts").withType("array").withArrayType("int").withOrder(10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("badgeGravities").withType("array").withArrayType("gravity").withOrder(10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("badgeHorizontalOffsets").withType("array").withArrayType("dimension").withOrder(10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("badgeVerticalOffsets").withType("array").withArrayType("dimension").withOrder(10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("badgeIsVisibles").withType("array").withArrayType("boolean").withOrder(10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("badgeTextAppearanceResources").withType("array").withArrayType("style").withOrder(10));
	}
	
	public NavigationRailViewImpl() {
		super(GROUP_NAME, LOCAL_NAME);
	}
	public  NavigationRailViewImpl(String localname) {
		super(GROUP_NAME, localname);
	}
	public  NavigationRailViewImpl(String groupName, String localname) {
		super(groupName, localname);
	}

		
	public class NavigationRailViewExt extends com.google.android.material.navigationrail.NavigationRailView implements ILifeCycleDecorator, com.ashera.widget.IMaxDimension{
		private MeasureEvent measureFinished = new MeasureEvent();
		private OnLayoutEvent onLayoutEvent = new OnLayoutEvent();
		
		public IWidget getWidget() {
			return NavigationRailViewImpl.this;
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

		public NavigationRailViewExt(Context context, android.util.AttributeSet attrs, int defStyleAttr) {
	        super(context, attrs, defStyleAttr);
	    }

	    public NavigationRailViewExt(Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) {
	    	super(context, attrs, defStyleAttr, defStyleRes);
	    }
		public NavigationRailViewExt(Context context) {
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
				NavigationRailViewImpl.this.invalidate();
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
        		ViewImpl.drawableStateChanged(NavigationRailViewImpl.this);
        	}
        }
        
    	public void setState0(float value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 0, value);
    	}
    	public void setState0(int value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 0, value);
    	}
    	public void setState0(double value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 0, value);
    	}
    	
    	public void setState0(Float value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 0, value);
    	}
    	public void setState0(Integer value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 0, value);
    	}
    	public void setState0(Double value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 0, value);
    	}
    	public void setState0(Object value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 0, value);
    	}
    	public void setState1(float value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 1, value);
    	}
    	public void setState1(int value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 1, value);
    	}
    	public void setState1(double value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 1, value);
    	}
    	
    	public void setState1(Float value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 1, value);
    	}
    	public void setState1(Integer value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 1, value);
    	}
    	public void setState1(Double value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 1, value);
    	}
    	public void setState1(Object value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 1, value);
    	}
    	public void setState2(float value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 2, value);
    	}
    	public void setState2(int value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 2, value);
    	}
    	public void setState2(double value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 2, value);
    	}
    	
    	public void setState2(Float value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 2, value);
    	}
    	public void setState2(Integer value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 2, value);
    	}
    	public void setState2(Double value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 2, value);
    	}
    	public void setState2(Object value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 2, value);
    	}
    	public void setState3(float value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 3, value);
    	}
    	public void setState3(int value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 3, value);
    	}
    	public void setState3(double value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 3, value);
    	}
    	
    	public void setState3(Float value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 3, value);
    	}
    	public void setState3(Integer value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 3, value);
    	}
    	public void setState3(Double value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 3, value);
    	}
    	public void setState3(Object value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 3, value);
    	}
    	public void setState4(float value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 4, value);
    	}
    	public void setState4(int value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 4, value);
    	}
    	public void setState4(double value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 4, value);
    	}
    	
    	public void setState4(Float value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 4, value);
    	}
    	public void setState4(Integer value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 4, value);
    	}
    	public void setState4(Double value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 4, value);
    	}
    	public void setState4(Object value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 4, value);
    	}
        	public void state0() {
        		ViewImpl.state(NavigationRailViewImpl.this, 0);
        	}
        	public void state1() {
        		ViewImpl.state(NavigationRailViewImpl.this, 1);
        	}
        	public void state2() {
        		ViewImpl.state(NavigationRailViewImpl.this, 2);
        	}
        	public void state3() {
        		ViewImpl.state(NavigationRailViewImpl.this, 3);
        	}
        	public void state4() {
        		ViewImpl.state(NavigationRailViewImpl.this, 4);
        	}
                        
        public void stateYes() {
        	ViewImpl.stateYes(NavigationRailViewImpl.this);
        	
        }
        
        public void stateNo() {
        	ViewImpl.stateNo(NavigationRailViewImpl.this);
        }
     
	
	}	@Override
	public Class getViewClass() {
		return NavigationRailViewExt.class;
	}

	@Override
	public IWidget newInstance() {
		return new NavigationRailViewImpl(groupName, localName);
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
Context context = (Context) fragment.getRootActivity();
	Object systemStyle = params.get("systemStyle");
	Object systemAndroidAttrStyle = params.get("systemAndroidAttrStyle");
	
	if (systemStyle == null && systemAndroidAttrStyle == null) {
		navigationRailView = new NavigationRailViewExt(context);
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
			navigationRailView = new NavigationRailViewExt(context, null, defStyleAttr);	
		} else {
			navigationRailView = new NavigationRailViewExt(context, null, defStyleAttr, defStyleRes);
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
			case "headerLayout": {
				


		 setHeaderLayout(objValue);



			}
			break;
			case "menuGravity": {
				


	navigationRailView.setMenuGravity((int)objValue);



			}
			break;
			case "onItemSelected": {
				


		navigationRailView.setOnItemSelectedListener(new OnItemSelectedListener(this, strValue, "onNavigationItemSelected"));



			}
			break;
			case "onItemReselected": {
				


		navigationRailView.setOnItemReselectedListener(new OnItemReselectedListener(this, strValue, "onNavigationItemReselected"));



			}
			break;
			case "menu": {
				


		setMenu(objValue);



			}
			break;
			case "itemIconTint": {
				


	navigationRailView.setItemIconTintList((ColorStateList)objValue);



			}
			break;
			case "itemIconSize": {
				


	navigationRailView.setItemIconSize((int)objValue);



			}
			break;
			case "itemTextColor": {
				


	navigationRailView.setItemTextColor((ColorStateList)objValue);



			}
			break;
			case "itemBackground": {
				


	navigationRailView.setItemBackground((Drawable)objValue);



			}
			break;
			case "itemRippleColor": {
				


	navigationRailView.setItemRippleColor((ColorStateList)objValue);



			}
			break;
			case "selectedItemId": {
				


	navigationRailView.setSelectedItemId((int)objValue);



			}
			break;
			case "labelVisibilityMode": {
				


	navigationRailView.setLabelVisibilityMode((int)objValue);



			}
			break;
			case "itemTextAppearanceInactive": {
				


	navigationRailView.setItemTextAppearanceInactive((int)objValue);



			}
			break;
			case "itemTextAppearanceActive": {
				


	navigationRailView.setItemTextAppearanceActive((int)objValue);



			}
			break;
			case "badgeNumbers": {
				


		setBadgeNumbers(objValue);



			}
			break;
			case "menuItemIds": {
				


		setBadgeMenuItemIds(objValue);



			}
			break;
			case "badgeBackgroundColors": {
				


		setBadgeBackgroundColors(objValue);



			}
			break;
			case "badgeTextColors": {
				


		setBadgeTextColors(objValue);



			}
			break;
			case "badgeAlphas": {
				


		setBadgeAlphas(objValue);



			}
			break;
			case "badgeMaxCharacterCounts": {
				


		setBadgeMaxCharacterCounts(objValue);



			}
			break;
			case "badgeGravities": {
				


		setBadgeGravities(objValue);



			}
			break;
			case "badgeHorizontalOffsets": {
				


		setBadgeHorizontalOffsets(objValue);



			}
			break;
			case "badgeVerticalOffsets": {
				


		setBadgeVerticalOffsets(objValue);



			}
			break;
			case "badgeIsVisibles": {
				


		setBadgeIsVisibles(objValue);



			}
			break;
			case "badgeTextAppearanceResources": {
				


		setTextAppearanceResources(objValue);



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
		}
		
		return null;
	}
	
	@Override
	public Object asWidget() {
		return navigationRailView;
	}

	

private List<Object> badgeMenuItemIds;
private void setBadgeBackgroundColors(Object objValue) {
	setValueOnBadgeDrawable(objValue, (badge, value) -> {
		badge.setBackgroundColor((int) value);
	});
}

public static interface ValueSetter {
	void setValueOnBadgeDrawable(BadgeDrawable badgeDrawable, Object value);
}
private void setValueOnBadgeDrawable(Object objValue, ValueSetter valueSetter) {
	if (badgeMenuItemIds != null) {
		List<Object> badgeAttrs = PluginInvoker.getList(objValue);
		
		for (int i = 0; i < badgeMenuItemIds.size(); i++) {
			int id = (int) badgeMenuItemIds.get(i);
			BadgeDrawable badge = navigationRailView.getOrCreateBadge(id);
			Object value = badgeAttrs.get(i);
			valueSetter.setValueOnBadgeDrawable(badge, value);
		}
	}
}

private void setBadgeMenuItemIds(Object objValue) {
	badgeMenuItemIds = PluginInvoker.getList(objValue);
}

private void setBadgeNumbers(Object objValue) {
	setValueOnBadgeDrawable(objValue, (badge, value) -> {
		badge.setNumber((int) value);
	});
}

private void setBadgeVerticalOffsets(Object objValue) {
	setValueOnBadgeDrawable(objValue, (badge, value) -> {
		badge.setVerticalOffset((int) value);
	});	
}

private void setBadgeHorizontalOffsets(Object objValue) {
	setValueOnBadgeDrawable(objValue, (badge, value) -> {
		badge.setHorizontalOffset((int) value);
	});	
}

private void setBadgeGravities(Object objValue) {
	setValueOnBadgeDrawable(objValue, (badge, value) -> {
		badge.setBadgeGravity((int) value);
	});	
}

private void setBadgeMaxCharacterCounts(Object objValue) {
	setValueOnBadgeDrawable(objValue, (badge, value) -> {
		badge.setMaxCharacterCount((int) value);
	});	
}

private void setBadgeAlphas(Object objValue) {
	setValueOnBadgeDrawable(objValue, (badge, value) -> {
		badge.setAlpha((int) value);
	});	
}

private void setBadgeTextColors(Object objValue) {
	setValueOnBadgeDrawable(objValue, (badge, value) -> {
		badge.setBadgeTextColor((int) value);
	});
}

private void setBadgeIsVisibles(Object objValue) {
	setValueOnBadgeDrawable(objValue, (badge, value) -> {
		badge.setVisible((boolean) value);
	});
}



@SuppressLint("RestrictedApi")
private void setTextAppearanceResources(Object objValue) {
	setValueOnBadgeDrawable(objValue, (badge, value) -> {
		badge.setTextAppearance((int) value);
	});
}



private void setMenu(Object objValue) {
	String menuStr = (String) objValue;
	String menuId = menuStr.replace("@+id/", "").replace("@id/", "");

	Context context = ((androidx.fragment.app.Fragment) fragment).getContext();
	int resId = context.getResources().getIdentifier(menuId, "menu", context.getPackageName());
	navigationRailView.getMenu().clear();
	navigationRailView.inflateMenu(resId);
	
}


	@SuppressLint("NewApi")
private static class OnItemSelectedListener implements NavigationBarView.OnItemSelectedListener, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public OnItemSelectedListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public OnItemSelectedListener(IWidget w, String strValue, String action)  {
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
     
        ViewImpl.addEventInfo(obj, item, w.getFragment());
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onNavigationItemSelected", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}
}

	@SuppressLint("NewApi")
private static class OnItemReselectedListener implements NavigationBarView.OnItemReselectedListener, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public OnItemReselectedListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public OnItemReselectedListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public void onNavigationItemReselected(MenuItem item){
    
	if (action == null || action.equals("onNavigationItemReselected")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onNavigationItemReselected");
	    java.util.Map<String, Object> obj = getOnNavigationItemReselectedEventObj(item);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 EventCommandFactory.getCommand(commandName).executeCommand(w, obj, item);
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
    return;
}//#####

public java.util.Map<String, Object> getOnNavigationItemReselectedEventObj(MenuItem item) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "navigationitemreselected");
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
    w.updateModelToEventMap(obj, "onNavigationItemReselected", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}
}

	
	    @Override
	    public Object asNativeWidget() {
	        return navigationRailView;
	    }

	    private void nativeCreate(Map<String, Object> params) {
	    }
	@Override
	public void setId(String id){
		if (id != null && !id.equals("")){
			super.setId(id);
			navigationRailView.setId((int) quickConvert(id, "id"));
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
	
private NavigationRailViewCommandBuilder builder;
private NavigationRailViewBean bean;
public Object getPlugin(String plugin) {
	return WidgetFactory.getAttributable(plugin).newInstance(this);
}
public NavigationRailViewBean getBean() {
	if (bean == null) {
		bean = new NavigationRailViewBean();
	}
	return bean;
}
public NavigationRailViewCommandBuilder getBuilder() {
	if (builder == null) {
		builder = new NavigationRailViewCommandBuilder();
	}
	return builder;
}


public  class NavigationRailViewCommandBuilder extends com.ashera.layout.ViewImpl.ViewCommandBuilder <NavigationRailViewCommandBuilder> {
    public NavigationRailViewCommandBuilder() {
	}
	
	public NavigationRailViewCommandBuilder execute(boolean setter) {
		if (setter) {
			executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			getFragment().remeasure();
		}
		executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);
return this;	}

public NavigationRailViewCommandBuilder setHeaderLayout(String value) {
	Map<String, Object> attrs = initCommand("headerLayout");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationRailViewCommandBuilder setMenuGravity(String value) {
	Map<String, Object> attrs = initCommand("menuGravity");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationRailViewCommandBuilder setOnItemSelected(String value) {
	Map<String, Object> attrs = initCommand("onItemSelected");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationRailViewCommandBuilder setOnItemReselected(String value) {
	Map<String, Object> attrs = initCommand("onItemReselected");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationRailViewCommandBuilder setMenu(String value) {
	Map<String, Object> attrs = initCommand("menu");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationRailViewCommandBuilder setItemIconTint(String value) {
	Map<String, Object> attrs = initCommand("itemIconTint");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationRailViewCommandBuilder setItemIconSize(String value) {
	Map<String, Object> attrs = initCommand("itemIconSize");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationRailViewCommandBuilder setItemTextColor(String value) {
	Map<String, Object> attrs = initCommand("itemTextColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationRailViewCommandBuilder setItemBackground(String value) {
	Map<String, Object> attrs = initCommand("itemBackground");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationRailViewCommandBuilder setItemRippleColor(String value) {
	Map<String, Object> attrs = initCommand("itemRippleColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationRailViewCommandBuilder setSelectedItemId(String value) {
	Map<String, Object> attrs = initCommand("selectedItemId");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationRailViewCommandBuilder setLabelVisibilityMode(String value) {
	Map<String, Object> attrs = initCommand("labelVisibilityMode");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationRailViewCommandBuilder setItemTextAppearanceInactive(String value) {
	Map<String, Object> attrs = initCommand("itemTextAppearanceInactive");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationRailViewCommandBuilder setItemTextAppearanceActive(String value) {
	Map<String, Object> attrs = initCommand("itemTextAppearanceActive");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationRailViewCommandBuilder setBadgeNumbers(String value) {
	Map<String, Object> attrs = initCommand("badgeNumbers");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationRailViewCommandBuilder setMenuItemIds(String value) {
	Map<String, Object> attrs = initCommand("menuItemIds");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationRailViewCommandBuilder setBadgeBackgroundColors(String value) {
	Map<String, Object> attrs = initCommand("badgeBackgroundColors");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationRailViewCommandBuilder setBadgeTextColors(String value) {
	Map<String, Object> attrs = initCommand("badgeTextColors");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationRailViewCommandBuilder setBadgeAlphas(String value) {
	Map<String, Object> attrs = initCommand("badgeAlphas");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationRailViewCommandBuilder setBadgeMaxCharacterCounts(String value) {
	Map<String, Object> attrs = initCommand("badgeMaxCharacterCounts");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationRailViewCommandBuilder setBadgeGravities(String value) {
	Map<String, Object> attrs = initCommand("badgeGravities");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationRailViewCommandBuilder setBadgeHorizontalOffsets(String value) {
	Map<String, Object> attrs = initCommand("badgeHorizontalOffsets");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationRailViewCommandBuilder setBadgeVerticalOffsets(String value) {
	Map<String, Object> attrs = initCommand("badgeVerticalOffsets");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationRailViewCommandBuilder setBadgeIsVisibles(String value) {
	Map<String, Object> attrs = initCommand("badgeIsVisibles");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationRailViewCommandBuilder setBadgeTextAppearanceResources(String value) {
	Map<String, Object> attrs = initCommand("badgeTextAppearanceResources");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}
public class NavigationRailViewBean extends com.ashera.layout.ViewImpl.ViewBean{
		public NavigationRailViewBean() {
			super(NavigationRailViewImpl.this);
		}
public void setHeaderLayout(String value) {
	getBuilder().reset().setHeaderLayout(value).execute(true);
}

public void setMenuGravity(String value) {
	getBuilder().reset().setMenuGravity(value).execute(true);
}

public void setOnItemSelected(String value) {
	getBuilder().reset().setOnItemSelected(value).execute(true);
}

public void setOnItemReselected(String value) {
	getBuilder().reset().setOnItemReselected(value).execute(true);
}

public void setMenu(String value) {
	getBuilder().reset().setMenu(value).execute(true);
}

public void setItemIconTint(String value) {
	getBuilder().reset().setItemIconTint(value).execute(true);
}

public void setItemIconSize(String value) {
	getBuilder().reset().setItemIconSize(value).execute(true);
}

public void setItemTextColor(String value) {
	getBuilder().reset().setItemTextColor(value).execute(true);
}

public void setItemBackground(String value) {
	getBuilder().reset().setItemBackground(value).execute(true);
}

public void setItemRippleColor(String value) {
	getBuilder().reset().setItemRippleColor(value).execute(true);
}

public void setSelectedItemId(String value) {
	getBuilder().reset().setSelectedItemId(value).execute(true);
}

public void setLabelVisibilityMode(String value) {
	getBuilder().reset().setLabelVisibilityMode(value).execute(true);
}

public void setItemTextAppearanceInactive(String value) {
	getBuilder().reset().setItemTextAppearanceInactive(value).execute(true);
}

public void setItemTextAppearanceActive(String value) {
	getBuilder().reset().setItemTextAppearanceActive(value).execute(true);
}

public void setBadgeNumbers(String value) {
	getBuilder().reset().setBadgeNumbers(value).execute(true);
}

public void setMenuItemIds(String value) {
	getBuilder().reset().setMenuItemIds(value).execute(true);
}

public void setBadgeBackgroundColors(String value) {
	getBuilder().reset().setBadgeBackgroundColors(value).execute(true);
}

public void setBadgeTextColors(String value) {
	getBuilder().reset().setBadgeTextColors(value).execute(true);
}

public void setBadgeAlphas(String value) {
	getBuilder().reset().setBadgeAlphas(value).execute(true);
}

public void setBadgeMaxCharacterCounts(String value) {
	getBuilder().reset().setBadgeMaxCharacterCounts(value).execute(true);
}

public void setBadgeGravities(String value) {
	getBuilder().reset().setBadgeGravities(value).execute(true);
}

public void setBadgeHorizontalOffsets(String value) {
	getBuilder().reset().setBadgeHorizontalOffsets(value).execute(true);
}

public void setBadgeVerticalOffsets(String value) {
	getBuilder().reset().setBadgeVerticalOffsets(value).execute(true);
}

public void setBadgeIsVisibles(String value) {
	getBuilder().reset().setBadgeIsVisibles(value).execute(true);
}

public void setBadgeTextAppearanceResources(String value) {
	getBuilder().reset().setBadgeTextAppearanceResources(value).execute(true);
}

}


	
	//end - body


private void setHeaderLayout(Object headerTemplate) {
	navigationRailView.removeHeaderView();
	navigationRailView.addHeaderView((View) ((IWidget) headerTemplate).loadLazyWidgets((com.ashera.model.LoopParam) null).asWidget());
}
}
