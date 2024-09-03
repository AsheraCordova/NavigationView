//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-javafx-widget\AndroidJNavigationView\src\main\java\com\google\android\material\bottomnavigation\BottomNavigationView.java
//

#include "BottomNavigationMenuView.h"
#include "BottomNavigationView.h"
#include "Context.h"
#include "HasWidgets.h"
#include "ILifeCycleDecorator.h"
#include "IOSClass.h"
#include "IWidget.h"
#include "J2ObjC_source.h"
#include "NavigationBarMenuView.h"
#include "NavigationBarPresenter.h"
#include "NavigationBarView.h"
#include "WidgetFactory.h"


@implementation ADXBottomNavigationView

J2OBJC_IGNORE_DESIGNATED_BEGIN
- (instancetype)init {
  ADXBottomNavigationView_init(self);
  return self;
}
J2OBJC_IGNORE_DESIGNATED_END

- (void)setItemHorizontalTranslationEnabledWithBoolean:(jboolean)itemHorizontalTranslationEnabled {
  ADXBottomNavigationMenuView *menuView = (ADXBottomNavigationMenuView *) cast_chk([self getMenuView], [ADXBottomNavigationMenuView class]);
  if ([((ADXBottomNavigationMenuView *) nil_chk(menuView)) isItemHorizontalTranslationEnabled] != itemHorizontalTranslationEnabled) {
    [menuView setItemHorizontalTranslationEnabledWithBoolean:itemHorizontalTranslationEnabled];
    [((ADXNavigationBarPresenter *) nil_chk([self getPresenter])) updateMenuViewWithBoolean:false];
  }
}

- (jboolean)isItemHorizontalTranslationEnabled {
  return [((ADXBottomNavigationMenuView *) nil_chk(((ADXBottomNavigationMenuView *) cast_chk([self getMenuView], [ADXBottomNavigationMenuView class])))) isItemHorizontalTranslationEnabled];
}

- (jint)getMaxItemCount {
  return ADXBottomNavigationView_MAX_ITEM_COUNT;
}

- (ADXNavigationBarMenuView *)createNavigationBarMenuViewWithADContext:(ADContext *)context {
  NSString *name = [ADXBottomNavigationMenuView_class_() getName];
  id<ASIWidget> widget = ASWidgetFactory_createWidgetWithNSString_withNSString_withASHasWidgets_withBoolean_(name, name, (id<ASHasWidgets>) cast_check([((id<ASILifeCycleDecorator>) cast_check(self, ASILifeCycleDecorator_class_())) getWidget], ASHasWidgets_class_()), false);
  return (ADXBottomNavigationMenuView *) cast_chk([((id<ASIWidget>) nil_chk(widget)) asWidget], [ADXBottomNavigationMenuView class]);
}

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, NULL, 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 0, 1, -1, -1, -1, -1 },
    { NULL, "Z", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "I", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "LADXNavigationBarMenuView;", 0x4, 2, 3, -1, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  #pragma clang diagnostic ignored "-Wundeclared-selector"
  methods[0].selector = @selector(init);
  methods[1].selector = @selector(setItemHorizontalTranslationEnabledWithBoolean:);
  methods[2].selector = @selector(isItemHorizontalTranslationEnabled);
  methods[3].selector = @selector(getMaxItemCount);
  methods[4].selector = @selector(createNavigationBarMenuViewWithADContext:);
  #pragma clang diagnostic pop
  static const J2ObjcFieldInfo fields[] = {
    { "MAX_ITEM_COUNT", "I", .constantValue.asInt = ADXBottomNavigationView_MAX_ITEM_COUNT, 0x18, -1, -1, -1, -1 },
  };
  static const void *ptrTable[] = { "setItemHorizontalTranslationEnabled", "Z", "createNavigationBarMenuView", "LADContext;" };
  static const J2ObjcClassInfo _ADXBottomNavigationView = { "BottomNavigationView", "com.google.android.material.bottomnavigation", ptrTable, methods, fields, 7, 0x1, 5, 1, -1, -1, -1, -1, -1 };
  return &_ADXBottomNavigationView;
}

@end

void ADXBottomNavigationView_init(ADXBottomNavigationView *self) {
  ADXNavigationBarView_init(self);
}

ADXBottomNavigationView *new_ADXBottomNavigationView_init() {
  J2OBJC_NEW_IMPL(ADXBottomNavigationView, init)
}

ADXBottomNavigationView *create_ADXBottomNavigationView_init() {
  J2OBJC_CREATE_IMPL(ADXBottomNavigationView, init)
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(ADXBottomNavigationView)