//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-javafx-widget\AndroidJNavigationView\src\main\java\com\google\android\material\navigation\NavigationBarPresenter.java
//

#include "J2ObjC_header.h"

#pragma push_macro("INCLUDE_ALL_NavigationBarPresenter")
#ifdef RESTRICT_NavigationBarPresenter
#define INCLUDE_ALL_NavigationBarPresenter 0
#else
#define INCLUDE_ALL_NavigationBarPresenter 1
#endif
#undef RESTRICT_NavigationBarPresenter

#if !defined (ADXNavigationBarPresenter_) && (INCLUDE_ALL_NavigationBarPresenter || defined(INCLUDE_ADXNavigationBarPresenter))
#define ADXNavigationBarPresenter_

#define RESTRICT_MenuPresenter 1
#define INCLUDE_ADXMenuPresenter 1
#include "MenuPresenter.h"

@class ADContext;
@class ADXMenuBuilder;
@class ADXNavigationBarMenuView;

@interface ADXNavigationBarPresenter : NSObject < ADXMenuPresenter >

#pragma mark Public

- (instancetype)init;

- (jboolean)flagActionItems;

- (void)initForMenuWithADContext:(ADContext *)context
              withADXMenuBuilder:(ADXMenuBuilder *)menu OBJC_METHOD_FAMILY_NONE;

- (void)setIdWithInt:(jint)id_;

- (void)setMenuViewWithADXNavigationBarMenuView:(ADXNavigationBarMenuView *)menuView;

- (void)setUpdateSuspendedWithBoolean:(jboolean)updateSuspended;

- (void)updateMenuViewWithBoolean:(jboolean)cleared;

@end

J2OBJC_EMPTY_STATIC_INIT(ADXNavigationBarPresenter)

FOUNDATION_EXPORT void ADXNavigationBarPresenter_init(ADXNavigationBarPresenter *self);

FOUNDATION_EXPORT ADXNavigationBarPresenter *new_ADXNavigationBarPresenter_init(void) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ADXNavigationBarPresenter *create_ADXNavigationBarPresenter_init(void);

J2OBJC_TYPE_LITERAL_HEADER(ADXNavigationBarPresenter)

@compatibility_alias ComGoogleAndroidMaterialNavigationNavigationBarPresenter ADXNavigationBarPresenter;

#endif

#pragma pop_macro("INCLUDE_ALL_NavigationBarPresenter")
