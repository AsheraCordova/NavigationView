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

/*-[
#include <UIKit/UIKit.h>
#include "ASUIView.h"
#include "HasLifeCycleDecorators.h"
]-*/
import com.google.j2objc.annotations.Property;
import androidx.core.view.*;

import static com.ashera.widget.IWidget.*;
//end - imports

import com.google.android.material.navigation.NavigationBarView;

import r.android.graphics.drawable.Drawable;
import r.android.content.res.ColorStateList;
import com.google.android.material.badge.BadgeDrawable;

public class NavigationRailViewImpl extends BaseHasWidgets {
	//start - body
	private @Property Object uiView;
	public final static String LOCAL_NAME = "com.google.android.material.navigationrail.NavigationRailView"; 
	public final static String GROUP_NAME = "com.google.android.material.navigationrail.NavigationRailView";
	private com.google.android.material.navigationrail.NavigationRailView navigationRailView;
	

	
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
	public void loadAttributes(String localName) {
		ViewGroupImpl.register(localName);

		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onItemSelected").withType("string").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onItemReselected").withType("string").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("menu").withType("resourcestring").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("itemIconTint").withType("colorstate").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("itemIconSize").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("itemTextColor").withType("colorstate").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("itemBackground").withType("drawable").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("selectedItemId").withType("id").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		ConverterFactory.register("com.google.android.material.navigationrail.NavigationRailView.LabelVisibilityMode", new LabelVisibilityMode());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("labelVisibilityMode").withType("com.google.android.material.navigationrail.NavigationRailView.LabelVisibilityMode").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("badgeNumbers").withType("array").withArrayType("int").withOrder(10).withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("menuItemIds").withType("array").withArrayType("id").withOrder(-1).withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("badgeAlphas").withType("array").withArrayType("int").withOrder(10).withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("badgeMaxCharacterCounts").withType("array").withArrayType("int").withOrder(10).withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("badgeGravities").withType("array").withArrayType("gravity").withOrder(10).withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("badgeHorizontalOffsets").withType("array").withArrayType("dimension").withOrder(10).withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("badgeVerticalOffsets").withType("array").withArrayType("dimension").withOrder(10).withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("badgeIsVisibles").withType("array").withArrayType("boolean").withOrder(10).withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("menuGravity").withType("gravity").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("itemTextAppearanceInactive").withType("string").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("itemTextAppearanceActive").withType("string").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("badgeBackgroundColors").withType("array").withArrayType("colorint").withOrder(10).withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("badgeTextColors").withType("array").withArrayType("colorint").withOrder(10).withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("badgeTextAppearanceResources").withType("array").withArrayType("string").withOrder(10).withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("headerLayout").withType("template"));
	
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

	@Override
	public IWidget newInstance() {
		return new NavigationRailViewImpl(groupName, localName);
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
		navigationRailView = new NavigationRailViewExt();
		
		nativeCreate(params);
		
		
		ViewGroupImpl.registerCommandConveter(this);
		setWidgetOnNativeClass();
	}
	private native void setWidgetOnNativeClass() /*-[
		((ASUIView*) [self asNativeWidget]).widget = self;
	]-*/;

	@Override
	public Object asWidget() {
		return navigationRailView;
	}

	@Override
	public boolean remove(IWidget w) {
		boolean remove = super.remove(w);
		navigationRailView.removeView((View) w.asWidget());
		 nativeRemoveView(w);            
		return remove;
	}
	
	@Override
    public boolean remove(int index) {
		IWidget widget = widgets.get(index);
        boolean remove = super.remove(index);

        if (index + 1 <= navigationRailView.getChildCount()) {
            navigationRailView.removeViewAt(index);
            nativeRemoveView(widget);
        }    
        return remove;
    }

	private void nativeRemoveView(IWidget widget) {
		r.android.animation.LayoutTransition layoutTransition = navigationRailView.getLayoutTransition();
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
			        navigationRailView.addView(view);
			    } else {
			        navigationRailView.addView(view, index);
			    }
		}
		
		ViewGroupImpl.nativeAddView(asNativeWidget(), w.asNativeWidget());
		super.add(w, index);
	}
	
	private void createLayoutParams(View view) {
		com.google.android.material.navigationrail.NavigationRailView.LayoutParams layoutParams = (com.google.android.material.navigationrail.NavigationRailView.LayoutParams) view.getLayoutParams();
		
		layoutParams = (com.google.android.material.navigationrail.NavigationRailView.LayoutParams) view.getLayoutParams();
		if (layoutParams == null) {
			layoutParams = new com.google.android.material.navigationrail.NavigationRailView.LayoutParams(-2, -2);
			view.setLayoutParams(layoutParams);
		}  else {
			layoutParams.height = -2;
			layoutParams.width = -2;
		}
	}
	
	private com.google.android.material.navigationrail.NavigationRailView.LayoutParams getLayoutParams(View view) {
		return (com.google.android.material.navigationrail.NavigationRailView.LayoutParams) view.getLayoutParams();		
	}
	
	@SuppressLint("NewApi")
	@Override
	public void setChildAttribute(IWidget w, WidgetAttribute key, String strValue, Object objValue) {
		View view = (View) w.asWidget();
		com.google.android.material.navigationrail.NavigationRailView.LayoutParams layoutParams = getLayoutParams(view);
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
		com.google.android.material.navigationrail.NavigationRailView.LayoutParams layoutParams = getLayoutParams(view);

		switch (key.getAttributeName()) {
		case "layout_width":
			return layoutParams.width;
		case "layout_height":
			return layoutParams.height;
		}
		
		return null;

	}
	
@com.google.j2objc.annotations.WeakOuter		
	public class NavigationRailViewExt extends com.google.android.material.navigationrail.NavigationRailView implements ILifeCycleDecorator, com.ashera.widget.IMaxDimension{
		private MeasureEvent measureFinished = new MeasureEvent();
		private OnLayoutEvent onLayoutEvent = new OnLayoutEvent();
		private List<IWidget> overlays;
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

		public NavigationRailViewExt() {
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
			ViewImpl.setDrawableBounds(NavigationRailViewImpl.this, l, t, r, b);
			if (!isOverlay()) {
			ViewImpl.nativeMakeFrame(asNativeWidget(), l, t, r, b);
			}
			replayBufferedEvents();
	        ViewImpl.redrawDrawables(NavigationRailViewImpl.this);
	        overlays = ViewImpl.drawOverlay(NavigationRailViewImpl.this, overlays);
			
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
        		ViewImpl.drawableStateChanged(NavigationRailViewImpl.this);
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
    		
    		IWidget widget = template.loadLazyWidgets(NavigationRailViewImpl.this);
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
        	NavigationRailViewImpl.this.getParent().remove(NavigationRailViewImpl.this);
		}
        @Override
        public void getLocationOnScreen(int[] appScreenLocation) {
        	appScreenLocation[0] = ViewImpl.getLocationXOnScreen(asNativeWidget());
        	appScreenLocation[1] = ViewImpl.getLocationYOnScreen(asNativeWidget());
        }
        @Override
        public void getWindowVisibleDisplayFrame(r.android.graphics.Rect displayFrame){
        	
        	displayFrame.left = ViewImpl.getLocationXOnScreen(asNativeWidget());
        	displayFrame.top = ViewImpl.getLocationYOnScreen(asNativeWidget());
        	displayFrame.right = displayFrame.left + getWidth();
        	displayFrame.bottom = displayFrame.top + getHeight();
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
			NavigationRailViewImpl.this.setAttribute(name, value, !(value instanceof String));
		}
        @Override
        public void setVisibility(int visibility) {
            super.setVisibility(visibility);
            ViewImpl.nativeSetVisibility(asNativeWidget(), visibility != View.VISIBLE);
            
        }
        
    	public void setState0(Object value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 0, value);
    	}
    	public void setState1(Object value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 1, value);
    	}
    	public void setState2(Object value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 2, value);
    	}
    	public void setState3(Object value) {
    		ViewImpl.setState(NavigationRailViewImpl.this, 3, value);
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
     
		@Override
		public void endViewTransition(r.android.view.View view) {
			super.endViewTransition(view);
			runBufferedRunnables();
		}
	
	}
	@Override
	public Class getViewClass() {
		return NavigationRailViewExt.class;
	}
	
	@SuppressLint("NewApi")
	@Override
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
				ViewGroupImpl.setAttribute(this, key, strValue, objValue, decorator);
		Object nativeWidget = asNativeWidget();
		switch (key.getAttributeName()) {
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
			case "selectedItemId": {


	navigationRailView.setSelectedItemId((int)objValue);



			}
			break;
			case "labelVisibilityMode": {


	navigationRailView.setLabelVisibilityMode((int)objValue);



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
			case "menuGravity": {


	navigationRailView.setMenuGravity((int)objValue);



			}
			break;
			case "itemTextAppearanceInactive": {


	navigationRailView.setItemTextAppearanceInactive((String)objValue);



			}
			break;
			case "itemTextAppearanceActive": {


	navigationRailView.setItemTextAppearanceActive((String)objValue);



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
			case "badgeTextAppearanceResources": {


		setTextAppearanceResources(objValue);



			}
			break;
			case "headerLayout": {


		 setHeaderLayout(objValue);



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
		}
		return null;
	}


	@Override
    public Object asNativeWidget() {
        return uiView;
    }
    public native boolean checkIosVersion(String v) /*-[
		return ([[[UIDevice currentDevice] systemVersion] compare:v options:NSNumericSearch] == NSOrderedDescending);
	]-*/;
    
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



private void setMenu(Object objValue) {
	
	String menuStr = (String) objValue;
	String key = menuStr.replace("@menu/", "");
	String json = com.ashera.utils.ResourceBundleUtils.getString("menu/menu", key, fragment);
	navigationRailView.getMenu().clear();
	navigationRailView.inflateMenu((HasWidgets) this,  json, fragment);
}



private void setTextAppearanceResources(Object objValue) {
	setValueOnBadgeDrawable(objValue, (badge, value) -> {
		badge.setTextAppearanceResource((String) value);
	});
	
}



private IWidget header;
private void setHeaderLayout(Object headerTemplate) {
	if (header != null) {
		remove(header);
		navigationRailView.removeHeaderView();
	}
	
	header = ((IWidget) headerTemplate).loadLazyWidgets(this);
	navigationRailView.addHeaderView((View) header.asWidget());
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
     
        ViewImpl.addEventInfo(obj, item);
    
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
		    if (activity != null) {
		    	activity.sendEventMessage(obj);
		    }
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
     
        ViewImpl.addEventInfo(obj, item);
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onNavigationItemReselected", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}
}


	@Override
	public void setId(String id){
		if (id != null && !id.equals("")){
			super.setId(id);
			navigationRailView.setId((int) quickConvert(id, "id"));
		}
	}
	
    
    @Override
    public void setVisible(boolean b) {
        ((View)asWidget()).setVisibility(b ? View.VISIBLE : View.GONE);
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


public  class NavigationRailViewCommandBuilder extends com.ashera.layout.ViewGroupImpl.ViewGroupCommandBuilder <NavigationRailViewCommandBuilder> {
    public NavigationRailViewCommandBuilder() {
	}
	
	public NavigationRailViewCommandBuilder execute(boolean setter) {
		if (setter) {
			executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			getFragment().remeasure();
		}
		executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);
return this;	}

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
public NavigationRailViewCommandBuilder setMenuGravity(String value) {
	Map<String, Object> attrs = initCommand("menuGravity");
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
public NavigationRailViewCommandBuilder setBadgeTextAppearanceResources(String value) {
	Map<String, Object> attrs = initCommand("badgeTextAppearanceResources");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public NavigationRailViewCommandBuilder setHeaderLayout(String value) {
	Map<String, Object> attrs = initCommand("headerLayout");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}
public class NavigationRailViewBean extends com.ashera.layout.ViewGroupImpl.ViewGroupBean{
		public NavigationRailViewBean() {
			super(NavigationRailViewImpl.this);
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

public void setSelectedItemId(String value) {
	getBuilder().reset().setSelectedItemId(value).execute(true);
}

public void setLabelVisibilityMode(String value) {
	getBuilder().reset().setLabelVisibilityMode(value).execute(true);
}

public void setBadgeNumbers(String value) {
	getBuilder().reset().setBadgeNumbers(value).execute(true);
}

public void setMenuItemIds(String value) {
	getBuilder().reset().setMenuItemIds(value).execute(true);
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

public void setMenuGravity(String value) {
	getBuilder().reset().setMenuGravity(value).execute(true);
}

public void setItemTextAppearanceInactive(String value) {
	getBuilder().reset().setItemTextAppearanceInactive(value).execute(true);
}

public void setItemTextAppearanceActive(String value) {
	getBuilder().reset().setItemTextAppearanceActive(value).execute(true);
}

public void setBadgeBackgroundColors(String value) {
	getBuilder().reset().setBadgeBackgroundColors(value).execute(true);
}

public void setBadgeTextColors(String value) {
	getBuilder().reset().setBadgeTextColors(value).execute(true);
}

public void setBadgeTextAppearanceResources(String value) {
	getBuilder().reset().setBadgeTextAppearanceResources(value).execute(true);
}

public void setHeaderLayout(String value) {
	getBuilder().reset().setHeaderLayout(value).execute(true);
}

}


private NavigationRailViewCommandParamsBuilder paramsBuilder;
private NavigationRailViewParamsBean paramsBean;

public NavigationRailViewParamsBean getParamsBean() {
	if (paramsBean == null) {
		paramsBean = new NavigationRailViewParamsBean();
	}
	return paramsBean;
}
public NavigationRailViewCommandParamsBuilder getParamsBuilder() {
	if (paramsBuilder == null) {
		paramsBuilder = new NavigationRailViewCommandParamsBuilder();
	}
	return paramsBuilder;
}



public class NavigationRailViewParamsBean extends com.ashera.layout.ViewGroupImpl.ViewGroupParamsBean{
}





public class NavigationRailViewCommandParamsBuilder extends com.ashera.layout.ViewGroupImpl.ViewGroupCommandParamsBuilder<NavigationRailViewCommandParamsBuilder>{
}

	//end - body

public void nativeCreate(Map<String, Object> params) {
	nativeCreate();
	navigationRailView.initNavigationBarView();
}
public native void nativeCreate()/*-[
	ASUIView* uiView = [ASUIView new];
	uiView.backgroundColor = [UIColor clearColor];
	uiView_ = uiView;
]-*/;
}
