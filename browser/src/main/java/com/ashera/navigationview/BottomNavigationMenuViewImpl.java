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

public class BottomNavigationMenuViewImpl extends BaseHasWidgets {
	//start - body
	private HTMLElement htmlElement;
	public final static String LOCAL_NAME = "com.google.android.material.bottomnavigation.BottomNavigationMenuView"; 
	public final static String GROUP_NAME = "com.google.android.material.bottomnavigation.BottomNavigationMenuView";
	private com.google.android.material.bottomnavigation.BottomNavigationMenuView bottomNavigationMenuView;
	

	
	@Override
	public void loadAttributes(String localName) {
		ViewGroupImpl.register(localName);

	
	}
	
	public BottomNavigationMenuViewImpl() {
		super(GROUP_NAME, LOCAL_NAME);
	}
	public  BottomNavigationMenuViewImpl(String localname) {
		super(GROUP_NAME, localname);
	}
	public  BottomNavigationMenuViewImpl(String groupName, String localname) {
		super(groupName, localname);
	}

	@Override
	public IWidget newInstance() {
		return new BottomNavigationMenuViewImpl(groupName, localName);
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
		bottomNavigationMenuView = new BottomNavigationMenuViewExt();
		
		nativeCreate(params);
		
		
		ViewGroupImpl.registerCommandConveter(this);
	}

	@Override
	public Object asWidget() {
		return bottomNavigationMenuView;
	}

	@Override
	public boolean remove(IWidget w) {
		boolean remove = super.remove(w);
		bottomNavigationMenuView.removeView((View) w.asWidget());
		 nativeRemoveView(w);            
		return remove;
	}
	
	@Override
    public boolean remove(int index) {
		IWidget widget = widgets.get(index);
        boolean remove = super.remove(index);

        if (index + 1 <= bottomNavigationMenuView.getChildCount()) {
            bottomNavigationMenuView.removeViewAt(index);
            nativeRemoveView(widget);
        }    
        return remove;
    }

	private void nativeRemoveView(IWidget widget) {
		r.android.animation.LayoutTransition layoutTransition = bottomNavigationMenuView.getLayoutTransition();
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
			        bottomNavigationMenuView.addView(view);
			    } else {
			        bottomNavigationMenuView.addView(view, index);
			    }
		}
		
		ViewGroupImpl.nativeAddView(asNativeWidget(), w.asNativeWidget());
		super.add(w, index);
	}
	
	private void createLayoutParams(View view) {
		com.google.android.material.bottomnavigation.BottomNavigationMenuView.LayoutParams layoutParams = (com.google.android.material.bottomnavigation.BottomNavigationMenuView.LayoutParams) view.getLayoutParams();
		
		layoutParams = (com.google.android.material.bottomnavigation.BottomNavigationMenuView.LayoutParams) view.getLayoutParams();
		if (layoutParams == null) {
			layoutParams = new com.google.android.material.bottomnavigation.BottomNavigationMenuView.LayoutParams(-2, -2);
			view.setLayoutParams(layoutParams);
		}  else {
			layoutParams.height = -2;
			layoutParams.width = -2;
		}
	}
	
	private com.google.android.material.bottomnavigation.BottomNavigationMenuView.LayoutParams getLayoutParams(View view) {
		return (com.google.android.material.bottomnavigation.BottomNavigationMenuView.LayoutParams) view.getLayoutParams();		
	}
	
	@SuppressLint("NewApi")
	@Override
	public void setChildAttribute(IWidget w, WidgetAttribute key, String strValue, Object objValue) {
		View view = (View) w.asWidget();
		com.google.android.material.bottomnavigation.BottomNavigationMenuView.LayoutParams layoutParams = getLayoutParams(view);
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
		com.google.android.material.bottomnavigation.BottomNavigationMenuView.LayoutParams layoutParams = getLayoutParams(view);

		switch (key.getAttributeName()) {
		case "layout_width":
			return layoutParams.width;
		case "layout_height":
			return layoutParams.height;
		}
		
		return null;

	}
	
		
	public class BottomNavigationMenuViewExt extends com.google.android.material.bottomnavigation.BottomNavigationMenuView implements ILifeCycleDecorator, com.ashera.widget.IMaxDimension{
		private MeasureEvent measureFinished = new MeasureEvent();
		private OnLayoutEvent onLayoutEvent = new OnLayoutEvent();
		private List<IWidget> overlays;
		public IWidget getWidget() {
			return BottomNavigationMenuViewImpl.this;
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

		public BottomNavigationMenuViewExt() {
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
			ViewImpl.setDrawableBounds(BottomNavigationMenuViewImpl.this, l, t, r, b);
			if (!isOverlay()) {
			ViewImpl.nativeMakeFrame(asNativeWidget(), l, t, r, b);
			}
			replayBufferedEvents();
	        ViewImpl.redrawDrawables(BottomNavigationMenuViewImpl.this);
	        overlays = ViewImpl.drawOverlay(BottomNavigationMenuViewImpl.this, overlays);
			
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
				BottomNavigationMenuViewImpl.this.invalidate();
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
        		ViewImpl.drawableStateChanged(BottomNavigationMenuViewImpl.this);
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
    		
    		IWidget widget = template.loadLazyWidgets(BottomNavigationMenuViewImpl.this);
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
        	BottomNavigationMenuViewImpl.this.getParent().remove(BottomNavigationMenuViewImpl.this);
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
			BottomNavigationMenuViewImpl.this.setAttribute(name, value, !(value instanceof String));
		}
        @Override
        public void setVisibility(int visibility) {
            super.setVisibility(visibility);
            ((HTMLElement)asNativeWidget()).getStyle().setProperty("display", visibility != View.VISIBLE ? "none" : "block");
            
        }
        
    	public void setState0(Object value) {
    		ViewImpl.setState(BottomNavigationMenuViewImpl.this, 0, value);
    	}
    	public void setState1(Object value) {
    		ViewImpl.setState(BottomNavigationMenuViewImpl.this, 1, value);
    	}
    	public void setState2(Object value) {
    		ViewImpl.setState(BottomNavigationMenuViewImpl.this, 2, value);
    	}
    	public void setState3(Object value) {
    		ViewImpl.setState(BottomNavigationMenuViewImpl.this, 3, value);
    	}
    	public void setState4(Object value) {
    		ViewImpl.setState(BottomNavigationMenuViewImpl.this, 4, value);
    	}
        	public void state0() {
        		ViewImpl.state(BottomNavigationMenuViewImpl.this, 0);
        	}
        	public void state1() {
        		ViewImpl.state(BottomNavigationMenuViewImpl.this, 1);
        	}
        	public void state2() {
        		ViewImpl.state(BottomNavigationMenuViewImpl.this, 2);
        	}
        	public void state3() {
        		ViewImpl.state(BottomNavigationMenuViewImpl.this, 3);
        	}
        	public void state4() {
        		ViewImpl.state(BottomNavigationMenuViewImpl.this, 4);
        	}
                        
        public void stateYes() {
        	ViewImpl.stateYes(BottomNavigationMenuViewImpl.this);
        	
        }
        
        public void stateNo() {
        	ViewImpl.stateNo(BottomNavigationMenuViewImpl.this);
        }
     
		@Override
		public void endViewTransition(r.android.view.View view) {
			super.endViewTransition(view);
			runBufferedRunnables();
		}
	
	}
	@Override
	public Class getViewClass() {
		return BottomNavigationMenuViewExt.class;
	}
	
	@SuppressLint("NewApi")
	@Override
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
				ViewGroupImpl.setAttribute(this, key, strValue, objValue, decorator);
		Object nativeWidget = asNativeWidget();

	}
	
	@Override
	@SuppressLint("NewApi")
	public Object getAttribute(WidgetAttribute key, ILifeCycleDecorator decorator) {
		Object attributeValue = ViewGroupImpl.getAttribute(this, key, decorator);
		if (attributeValue != null) {
			return attributeValue;
		}
		Object nativeWidget = asNativeWidget();
		return null;
	}


	@Override
    public Object asNativeWidget() {
        return htmlElement;
    }
    private void nativeCreate(Map<String, Object> params) {
    	htmlElement = org.teavm.jso.dom.html.HTMLDocument.current().createElement("div");
    	htmlElement.getStyle().setProperty("box-sizing", "border-box");
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
    
	

	@Override
	public void setId(String id){
		if (id != null && !id.equals("")){
			super.setId(id);
			bottomNavigationMenuView.setId((int) quickConvert(id, "id"));
		}
	}
	
    
    @Override
    public void setVisible(boolean b) {
        ((View)asWidget()).setVisibility(b ? View.VISIBLE : View.GONE);
    }

	
private BottomNavigationMenuViewCommandBuilder builder;
private BottomNavigationMenuViewBean bean;
public Object getPlugin(String plugin) {
	return WidgetFactory.getAttributable(plugin).newInstance(this);
}
public BottomNavigationMenuViewBean getBean() {
	if (bean == null) {
		bean = new BottomNavigationMenuViewBean();
	}
	return bean;
}
public BottomNavigationMenuViewCommandBuilder getBuilder() {
	if (builder == null) {
		builder = new BottomNavigationMenuViewCommandBuilder();
	}
	return builder;
}


public  class BottomNavigationMenuViewCommandBuilder extends com.ashera.layout.ViewGroupImpl.ViewGroupCommandBuilder <BottomNavigationMenuViewCommandBuilder> {
    public BottomNavigationMenuViewCommandBuilder() {
	}
	
	public BottomNavigationMenuViewCommandBuilder execute(boolean setter) {
		if (setter) {
			executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			getFragment().remeasure();
		}
		executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);
return this;	}

}
public class BottomNavigationMenuViewBean extends com.ashera.layout.ViewGroupImpl.ViewGroupBean{
		public BottomNavigationMenuViewBean() {
			super(BottomNavigationMenuViewImpl.this);
		}
}


private BottomNavigationMenuViewCommandParamsBuilder paramsBuilder;
private BottomNavigationMenuViewParamsBean paramsBean;

public BottomNavigationMenuViewParamsBean getParamsBean() {
	if (paramsBean == null) {
		paramsBean = new BottomNavigationMenuViewParamsBean();
	}
	return paramsBean;
}
public BottomNavigationMenuViewCommandParamsBuilder getParamsBuilder() {
	if (paramsBuilder == null) {
		paramsBuilder = new BottomNavigationMenuViewCommandParamsBuilder();
	}
	return paramsBuilder;
}



public class BottomNavigationMenuViewParamsBean extends com.ashera.layout.ViewGroupImpl.ViewGroupParamsBean{
}





public class BottomNavigationMenuViewCommandParamsBuilder extends com.ashera.layout.ViewGroupImpl.ViewGroupCommandParamsBuilder<BottomNavigationMenuViewCommandParamsBuilder>{
}

	//end - body
}
