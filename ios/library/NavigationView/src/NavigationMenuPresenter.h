//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-javafx-widget\AndroidJNavigationView\src\main\java\com\google\android\material\internal\NavigationMenuPresenter.java
//

#include "J2ObjC_header.h"

#pragma push_macro("INCLUDE_ALL_NavigationMenuPresenter")
#ifdef RESTRICT_NavigationMenuPresenter
#define INCLUDE_ALL_NavigationMenuPresenter 0
#else
#define INCLUDE_ALL_NavigationMenuPresenter 1
#endif
#undef RESTRICT_NavigationMenuPresenter

#if !defined (ADXNavigationMenuPresenter_) && (INCLUDE_ALL_NavigationMenuPresenter || defined(INCLUDE_ADXNavigationMenuPresenter))
#define ADXNavigationMenuPresenter_

#define RESTRICT_MenuPresenter 1
#define INCLUDE_ADXMenuPresenter 1
#include "MenuPresenter.h"

@class ADColorStateList;
@class ADContext;
@class ADDrawable;
@class ADLinearLayout;
@class ADView;
@class ADViewGroup;
@class ADXMenuBuilder;
@class ADXNavigationMenuPresenter_LayoutInflater;
@class ADXNavigationMenuPresenter_NavigationMenuAdapter;
@class ADXRecyclerView;
@protocol ADView_OnClickListener;

@interface ADXNavigationMenuPresenter : NSObject < ADXMenuPresenter > {
 @public
  ADLinearLayout *headerLayout_;
  ADXMenuBuilder *menu_;
  ADXNavigationMenuPresenter_NavigationMenuAdapter *adapter_;
  ADXNavigationMenuPresenter_LayoutInflater *layoutInflater_;
  jint subheaderTextAppearance_;
  ADColorStateList *subheaderColor_;
  jboolean textAppearanceActiveBoldEnabled_;
  ADColorStateList *textColor_;
  ADColorStateList *iconTintList_;
  ADDrawable *itemBackground_;
  jint itemHorizontalPadding_;
  jint itemVerticalPadding_;
  jint itemIconPadding_;
  jint itemIconSize_;
  jint dividerInsetStart_;
  jint dividerInsetEnd_;
  jint subheaderInsetStart_;
  jint subheaderInsetEnd_;
  jboolean hasCustomItemIconSize_;
  jboolean isBehindStatusBar_;
  jint paddingSeparator_;
  id<ADView_OnClickListener> onClickListener_;
}

#pragma mark Public

- (instancetype)init;

- (void)addHeaderViewWithADView:(ADView *)view;

- (jboolean)flagActionItems;

- (jint)getHeaderCount;

- (ADView *)getHeaderViewWithInt:(jint)index;

- (ADDrawable *)getItemBackground;

- (jint)getItemHorizontalPadding;

- (jint)getItemIconPadding;

- (jint)getItemMaxLines;

- (ADColorStateList *)getItemTextColor;

- (ADColorStateList *)getItemTintList;

- (jint)getItemVerticalPadding;

- (ADXRecyclerView *)getMenuViewWithADViewGroup:(ADViewGroup *)root;

- (void)initForMenuWithADContext:(ADContext *)context
              withADXMenuBuilder:(ADXMenuBuilder *)menu OBJC_METHOD_FAMILY_NONE;

- (void)removeHeaderViewWithADView:(ADView *)view;

- (void)setDividerInsetEndWithInt:(jint)dividerInsetEnd;

- (void)setDividerInsetStartWithInt:(jint)dividerInsetStart;

- (void)setIdWithInt:(jint)id_;

- (void)setItemBackgroundWithADDrawable:(ADDrawable *)itemBackground;

- (void)setItemHorizontalPaddingWithInt:(jint)itemHorizontalPadding;

- (void)setItemIconPaddingWithInt:(jint)itemIconPadding;

- (void)setItemIconSizeWithInt:(jint)itemIconSize;

- (void)setItemIconTintListWithADColorStateList:(ADColorStateList *)tint;

- (void)setItemMaxLinesWithInt:(jint)itemMaxLines;

- (void)setItemTextAppearanceWithNSString:(NSString *)resId;

- (void)setItemTextColorWithADColorStateList:(ADColorStateList *)textColor;

- (void)setItemVerticalPaddingWithInt:(jint)itemVerticalPadding;

- (void)setSubheaderInsetEndWithInt:(jint)subheaderInsetEnd;

- (void)setSubheaderInsetStartWithInt:(jint)subheaderInsetStart;

- (void)setUpdateSuspendedWithBoolean:(jboolean)updateSuspended;

- (void)updateMenuViewWithBoolean:(jboolean)cleared;

@end

J2OBJC_EMPTY_STATIC_INIT(ADXNavigationMenuPresenter)

J2OBJC_FIELD_SETTER(ADXNavigationMenuPresenter, headerLayout_, ADLinearLayout *)
J2OBJC_FIELD_SETTER(ADXNavigationMenuPresenter, menu_, ADXMenuBuilder *)
J2OBJC_FIELD_SETTER(ADXNavigationMenuPresenter, adapter_, ADXNavigationMenuPresenter_NavigationMenuAdapter *)
J2OBJC_FIELD_SETTER(ADXNavigationMenuPresenter, layoutInflater_, ADXNavigationMenuPresenter_LayoutInflater *)
J2OBJC_FIELD_SETTER(ADXNavigationMenuPresenter, subheaderColor_, ADColorStateList *)
J2OBJC_FIELD_SETTER(ADXNavigationMenuPresenter, textColor_, ADColorStateList *)
J2OBJC_FIELD_SETTER(ADXNavigationMenuPresenter, iconTintList_, ADColorStateList *)
J2OBJC_FIELD_SETTER(ADXNavigationMenuPresenter, itemBackground_, ADDrawable *)
J2OBJC_FIELD_SETTER(ADXNavigationMenuPresenter, onClickListener_, id<ADView_OnClickListener>)

inline jint ADXNavigationMenuPresenter_get_NO_TEXT_APPEARANCE_SET(void);
#define ADXNavigationMenuPresenter_NO_TEXT_APPEARANCE_SET 0
J2OBJC_STATIC_FIELD_CONSTANT(ADXNavigationMenuPresenter, NO_TEXT_APPEARANCE_SET, jint)

FOUNDATION_EXPORT void ADXNavigationMenuPresenter_init(ADXNavigationMenuPresenter *self);

FOUNDATION_EXPORT ADXNavigationMenuPresenter *new_ADXNavigationMenuPresenter_init(void) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ADXNavigationMenuPresenter *create_ADXNavigationMenuPresenter_init(void);

J2OBJC_TYPE_LITERAL_HEADER(ADXNavigationMenuPresenter)

@compatibility_alias ComGoogleAndroidMaterialInternalNavigationMenuPresenter ADXNavigationMenuPresenter;

#endif

#if !defined (ADXNavigationMenuPresenter_ViewHolder_) && (INCLUDE_ALL_NavigationMenuPresenter || defined(INCLUDE_ADXNavigationMenuPresenter_ViewHolder))
#define ADXNavigationMenuPresenter_ViewHolder_

#define RESTRICT_RecyclerView 1
#define INCLUDE_ADXRecyclerView_ViewHolder 1
#include "RecyclerView.h"

@class ADView;

@interface ADXNavigationMenuPresenter_ViewHolder : ADXRecyclerView_ViewHolder

#pragma mark Public

- (instancetype)initWithADView:(ADView *)itemView;

@end

J2OBJC_EMPTY_STATIC_INIT(ADXNavigationMenuPresenter_ViewHolder)

FOUNDATION_EXPORT void ADXNavigationMenuPresenter_ViewHolder_initWithADView_(ADXNavigationMenuPresenter_ViewHolder *self, ADView *itemView);

J2OBJC_TYPE_LITERAL_HEADER(ADXNavigationMenuPresenter_ViewHolder)

#endif

#if !defined (ADXNavigationMenuPresenter_NavigationMenuAdapter_) && (INCLUDE_ALL_NavigationMenuPresenter || defined(INCLUDE_ADXNavigationMenuPresenter_NavigationMenuAdapter))
#define ADXNavigationMenuPresenter_NavigationMenuAdapter_

#define RESTRICT_RecyclerView 1
#define INCLUDE_ADXRecyclerView_Adapter 1
#include "RecyclerView.h"

@class ADViewGroup;
@class ADXMenuItemImpl;
@class ADXNavigationMenuPresenter_ViewHolder;

@interface ADXNavigationMenuPresenter_NavigationMenuAdapter : ADXRecyclerView_Adapter

#pragma mark Public

- (ADXNavigationMenuPresenter_ViewHolder *)createViewHolderWithADViewGroup:(ADViewGroup *)arg0
                                                                   withInt:(jint)arg1;

- (jint)getItemCount;

- (jint)getItemViewTypeWithInt:(jint)position;

- (void)onBindViewHolderWithADXRecyclerView_ViewHolder:(ADXNavigationMenuPresenter_ViewHolder *)holder
                                               withInt:(jint)position;

- (ADXNavigationMenuPresenter_ViewHolder *)onCreateViewHolderWithADViewGroup:(ADViewGroup *)parent
                                                                     withInt:(jint)viewType;

- (void)onViewRecycledWithADXRecyclerView_ViewHolder:(ADXNavigationMenuPresenter_ViewHolder *)holder;

- (void)setCheckedItemWithADXMenuItemImpl:(ADXMenuItemImpl *)checkedItem;

- (void)setUpdateSuspendedWithBoolean:(jboolean)updateSuspended;

- (void)update;

@end

J2OBJC_EMPTY_STATIC_INIT(ADXNavigationMenuPresenter_NavigationMenuAdapter)

J2OBJC_TYPE_LITERAL_HEADER(ADXNavigationMenuPresenter_NavigationMenuAdapter)

#endif

#if !defined (ADXNavigationMenuPresenter_LayoutInflater_) && (INCLUDE_ALL_NavigationMenuPresenter || defined(INCLUDE_ADXNavigationMenuPresenter_LayoutInflater))
#define ADXNavigationMenuPresenter_LayoutInflater_

@class ADContext;
@class ADView;
@class ADViewGroup;
@protocol ADView_OnClickListener;

@interface ADXNavigationMenuPresenter_LayoutInflater : NSObject

#pragma mark Public

- (instancetype)init;

+ (ADXNavigationMenuPresenter_LayoutInflater *)fromWithADContext:(ADContext *)context;

- (ADView *)inflateWithNSString:(NSString *)layout
                withADViewGroup:(ADViewGroup *)parent
                    withBoolean:(jboolean)b;

- (void)recurseSetWithADViewGroup:(ADViewGroup *)parent
       withADView_OnClickListener:(id<ADView_OnClickListener>)onClickListener;

@end

J2OBJC_EMPTY_STATIC_INIT(ADXNavigationMenuPresenter_LayoutInflater)

FOUNDATION_EXPORT void ADXNavigationMenuPresenter_LayoutInflater_init(ADXNavigationMenuPresenter_LayoutInflater *self);

FOUNDATION_EXPORT ADXNavigationMenuPresenter_LayoutInflater *new_ADXNavigationMenuPresenter_LayoutInflater_init(void) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ADXNavigationMenuPresenter_LayoutInflater *create_ADXNavigationMenuPresenter_LayoutInflater_init(void);

FOUNDATION_EXPORT ADXNavigationMenuPresenter_LayoutInflater *ADXNavigationMenuPresenter_LayoutInflater_fromWithADContext_(ADContext *context);

J2OBJC_TYPE_LITERAL_HEADER(ADXNavigationMenuPresenter_LayoutInflater)

#endif

#pragma pop_macro("INCLUDE_ALL_NavigationMenuPresenter")
