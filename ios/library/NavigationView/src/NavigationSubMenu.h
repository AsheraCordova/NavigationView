//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-javafx-widget\AndroidJNavigationView\src\main\java\com\google\android\material\internal\NavigationSubMenu.java
//

#include "J2ObjC_header.h"

#pragma push_macro("INCLUDE_ALL_NavigationSubMenu")
#ifdef RESTRICT_NavigationSubMenu
#define INCLUDE_ALL_NavigationSubMenu 0
#else
#define INCLUDE_ALL_NavigationSubMenu 1
#endif
#undef RESTRICT_NavigationSubMenu

#if !defined (ADXNavigationSubMenu_) && (INCLUDE_ALL_NavigationSubMenu || defined(INCLUDE_ADXNavigationSubMenu))
#define ADXNavigationSubMenu_

#define RESTRICT_SubMenuBuilder 1
#define INCLUDE_ADXSubMenuBuilder 1
#include "SubMenuBuilder.h"

@class ADContext;
@class ADXMenuBuilder;
@class ADXMenuItemImpl;
@class ADXNavigationMenu;

@interface ADXNavigationSubMenu : ADXSubMenuBuilder

#pragma mark Public

- (instancetype)initWithADContext:(ADContext *)context
            withADXNavigationMenu:(ADXNavigationMenu *)menu
              withADXMenuItemImpl:(ADXMenuItemImpl *)item;

// Disallowed inherited constructors, do not use.

- (instancetype)initWithADContext:(ADContext *)arg0
               withADXMenuBuilder:(ADXMenuBuilder *)arg1
              withADXMenuItemImpl:(ADXMenuItemImpl *)arg2 NS_UNAVAILABLE;

@end

J2OBJC_EMPTY_STATIC_INIT(ADXNavigationSubMenu)

FOUNDATION_EXPORT void ADXNavigationSubMenu_initWithADContext_withADXNavigationMenu_withADXMenuItemImpl_(ADXNavigationSubMenu *self, ADContext *context, ADXNavigationMenu *menu, ADXMenuItemImpl *item);

FOUNDATION_EXPORT ADXNavigationSubMenu *new_ADXNavigationSubMenu_initWithADContext_withADXNavigationMenu_withADXMenuItemImpl_(ADContext *context, ADXNavigationMenu *menu, ADXMenuItemImpl *item) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ADXNavigationSubMenu *create_ADXNavigationSubMenu_initWithADContext_withADXNavigationMenu_withADXMenuItemImpl_(ADContext *context, ADXNavigationMenu *menu, ADXMenuItemImpl *item);

J2OBJC_TYPE_LITERAL_HEADER(ADXNavigationSubMenu)

@compatibility_alias ComGoogleAndroidMaterialInternalNavigationSubMenu ADXNavigationSubMenu;

#endif

#pragma pop_macro("INCLUDE_ALL_NavigationSubMenu")
