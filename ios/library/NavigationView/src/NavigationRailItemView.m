//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-javafx-widget\AndroidJNavigationView\src\main\java\com\google\android\material\navigationrail\NavigationRailItemView.java
//

#include "IdGenerator.h"
#include "J2ObjC_source.h"
#include "NavigationBarItemView.h"
#include "NavigationRailItemView.h"
#include "PluginInvoker.h"
#include "View.h"
#include "java/lang/Math.h"


@interface ADXNavigationRailItemView ()

- (void)hackForDimensionOnFrameLayoutWrapperWithInt:(jint)bestHeight;

@end

__attribute__((unused)) static void ADXNavigationRailItemView_hackForDimensionOnFrameLayoutWrapperWithInt_(ADXNavigationRailItemView *self, jint bestHeight);

@implementation ADXNavigationRailItemView

J2OBJC_IGNORE_DESIGNATED_BEGIN
- (instancetype)init {
  ADXNavigationRailItemView_init(self);
  return self;
}
J2OBJC_IGNORE_DESIGNATED_END

- (void)onMeasureWithInt:(jint)widthMeasureSpec
                 withInt:(jint)heightMeasureSpec {
  [super onMeasureWithInt:widthMeasureSpec withInt:heightMeasureSpec];
  if (ADView_MeasureSpec_getModeWithInt_(heightMeasureSpec) == ADView_MeasureSpec_UNSPECIFIED) {
    jint preferredHeight = ADView_MeasureSpec_getSizeWithInt_(heightMeasureSpec);
    jint measuredHeight = [self getMeasuredHeight];
    jint bestHeight = JavaLangMath_maxWithInt_withInt_(measuredHeight, preferredHeight);
    [self setMeasuredDimensionWithInt:[self getMeasuredWidthAndState] withInt:ADView_resolveSizeAndStateWithInt_withInt_withInt_(bestHeight, heightMeasureSpec, 0)];
    ADXNavigationRailItemView_hackForDimensionOnFrameLayoutWrapperWithInt_(self, bestHeight);
  }
}

- (NSString *)getItemLayoutResId {
  return @"@layout/design_navigation_rail_item_new";
}

- (jint)getItemDefaultMarginResId {
  return JreFpToInt(ASPluginInvoker_convertDpToPixelWithNSString_(@"6dp"));
}

- (void)hackForDimensionOnFrameLayoutWrapperWithInt:(jint)bestHeight {
  ADXNavigationRailItemView_hackForDimensionOnFrameLayoutWrapperWithInt_(self, bestHeight);
}

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, NULL, 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "V", 0x4, 0, 1, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x4, -1, -1, -1, -1, -1, -1 },
    { NULL, "I", 0x4, -1, -1, -1, -1, -1, -1 },
    { NULL, "V", 0x2, 2, 3, -1, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  #pragma clang diagnostic ignored "-Wundeclared-selector"
  methods[0].selector = @selector(init);
  methods[1].selector = @selector(onMeasureWithInt:withInt:);
  methods[2].selector = @selector(getItemLayoutResId);
  methods[3].selector = @selector(getItemDefaultMarginResId);
  methods[4].selector = @selector(hackForDimensionOnFrameLayoutWrapperWithInt:);
  #pragma clang diagnostic pop
  static const void *ptrTable[] = { "onMeasure", "II", "hackForDimensionOnFrameLayoutWrapper", "I" };
  static const J2ObjcClassInfo _ADXNavigationRailItemView = { "NavigationRailItemView", "com.google.android.material.navigationrail", ptrTable, methods, NULL, 7, 0x1, 5, 0, -1, -1, -1, -1, -1 };
  return &_ADXNavigationRailItemView;
}

@end

void ADXNavigationRailItemView_init(ADXNavigationRailItemView *self) {
  ADXNavigationBarItemView_init(self);
}

ADXNavigationRailItemView *new_ADXNavigationRailItemView_init() {
  J2OBJC_NEW_IMPL(ADXNavigationRailItemView, init)
}

ADXNavigationRailItemView *create_ADXNavigationRailItemView_init() {
  J2OBJC_CREATE_IMPL(ADXNavigationRailItemView, init)
}

void ADXNavigationRailItemView_hackForDimensionOnFrameLayoutWrapperWithInt_(ADXNavigationRailItemView *self, jint bestHeight) {
  ADView *navigationBarFlWrapper = JreRetainedLocalValue([self findViewByIdWithInt:ASIdGenerator_getIdWithNSString_(@"@+id/navigation_bar_fl_wrapper")]);
  [((ADView *) nil_chk(navigationBarFlWrapper)) setMinimumHeightWithInt:bestHeight];
  [navigationBarFlWrapper setMinimumWidthWithInt:ASPluginInvoker_getScreenWidth()];
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(ADXNavigationRailItemView)