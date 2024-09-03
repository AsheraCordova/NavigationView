// start - imports

export const enum LabelVisibilityMode {
auto = "auto",
selected = "selected",
labeled = "labeled",
unlabeled = "unlabeled",
}	
import CommandAttr from '../../widget/CommandAttr';
import IWidget from '../../widget/IWidget';
import ILayoutParam from '../../widget/ILayoutParam';
import {plainToClass, Type, Exclude, Expose, Transform} from "class-transformer";
import 'babel-polyfill';
import {Gravity} from '../../widget/TypeConstants';
import {ITranform, TransformerFactory} from '../../widget/TransformerFactory';
import {Event} from '../../app/Event';
import {MotionEvent} from '../../app/MotionEvent';
import {DragEvent} from '../../app/DragEvent';
import {KeyEvent} from '../../app/KeyEvent';
import { ScopedObject } from '../../app/ScopedObject';
import { Mixin, decorate } from 'ts-mixer';

























import {ViewGroupImpl_LayoutParams} from './ViewGroupImpl';

// end - imports
import {ViewGroupImpl} from './ViewGroupImpl';
export abstract class NavigationRailViewImpl<T> extends ViewGroupImpl<T>{
	//start - body
	static initialize() {
    }	
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "onItemSelected" }))
	onItemSelected!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "onItemReselected" }))
	onItemReselected!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "menu" }))
	menu!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "itemIconTint" }))
	itemIconTint!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "itemIconSize" }))
	itemIconSize!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "itemTextColor" }))
	itemTextColor!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "itemBackground" }))
	itemBackground!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "selectedItemId" }))
	selectedItemId!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "labelVisibilityMode" }))
	labelVisibilityMode!:CommandAttr<LabelVisibilityMode>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "badgeNumbers" }))
	badgeNumbers!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "menuItemIds" }))
	menuItemIds!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "badgeAlphas" }))
	badgeAlphas!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "badgeMaxCharacterCounts" }))
	badgeMaxCharacterCounts!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "badgeGravities" }))
	badgeGravities!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "badgeHorizontalOffsets" }))
	badgeHorizontalOffsets!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "badgeVerticalOffsets" }))
	badgeVerticalOffsets!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "badgeIsVisibles" }))
	badgeIsVisibles!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "menuGravity" }))
	menuGravity!:CommandAttr<Gravity[]>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "itemTextAppearanceInactive" }))
	itemTextAppearanceInactive!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "itemTextAppearanceActive" }))
	itemTextAppearanceActive!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "badgeBackgroundColors" }))
	badgeBackgroundColors!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "badgeTextColors" }))
	badgeTextColors!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "badgeTextAppearanceResources" }))
	badgeTextAppearanceResources!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "headerLayout" }))
	headerLayout!:CommandAttr<string>| undefined;

	@decorate(Exclude())
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.onItemSelected = undefined;
		this.onItemReselected = undefined;
		this.menu = undefined;
		this.itemIconTint = undefined;
		this.itemIconSize = undefined;
		this.itemTextColor = undefined;
		this.itemBackground = undefined;
		this.selectedItemId = undefined;
		this.labelVisibilityMode = undefined;
		this.badgeNumbers = undefined;
		this.menuItemIds = undefined;
		this.badgeAlphas = undefined;
		this.badgeMaxCharacterCounts = undefined;
		this.badgeGravities = undefined;
		this.badgeHorizontalOffsets = undefined;
		this.badgeVerticalOffsets = undefined;
		this.badgeIsVisibles = undefined;
		this.menuGravity = undefined;
		this.itemTextAppearanceInactive = undefined;
		this.itemTextAppearanceActive = undefined;
		this.badgeBackgroundColors = undefined;
		this.badgeTextColors = undefined;
		this.badgeTextAppearanceResources = undefined;
		this.headerLayout = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
	}
	

	public setOnItemSelected(value : string) : T {
		this.resetIfRequired();
		if (this.onItemSelected == null || this.onItemSelected == undefined) {
			this.onItemSelected = new CommandAttr<string>();
		}
		
		this.onItemSelected.setSetter(true);
		this.onItemSelected.setValue(value);
		this.orderSet++;
		this.onItemSelected.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnItemReselected(value : string) : T {
		this.resetIfRequired();
		if (this.onItemReselected == null || this.onItemReselected == undefined) {
			this.onItemReselected = new CommandAttr<string>();
		}
		
		this.onItemReselected.setSetter(true);
		this.onItemReselected.setValue(value);
		this.orderSet++;
		this.onItemReselected.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setMenu(value : string) : T {
		this.resetIfRequired();
		if (this.menu == null || this.menu == undefined) {
			this.menu = new CommandAttr<string>();
		}
		
		this.menu.setSetter(true);
		this.menu.setValue(value);
		this.orderSet++;
		this.menu.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setItemIconTint(value : string) : T {
		this.resetIfRequired();
		if (this.itemIconTint == null || this.itemIconTint == undefined) {
			this.itemIconTint = new CommandAttr<string>();
		}
		
		this.itemIconTint.setSetter(true);
		this.itemIconTint.setValue(value);
		this.orderSet++;
		this.itemIconTint.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setItemIconSize(value : string) : T {
		this.resetIfRequired();
		if (this.itemIconSize == null || this.itemIconSize == undefined) {
			this.itemIconSize = new CommandAttr<string>();
		}
		
		this.itemIconSize.setSetter(true);
		this.itemIconSize.setValue(value);
		this.orderSet++;
		this.itemIconSize.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setItemTextColor(value : string) : T {
		this.resetIfRequired();
		if (this.itemTextColor == null || this.itemTextColor == undefined) {
			this.itemTextColor = new CommandAttr<string>();
		}
		
		this.itemTextColor.setSetter(true);
		this.itemTextColor.setValue(value);
		this.orderSet++;
		this.itemTextColor.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setItemBackground(value : string) : T {
		this.resetIfRequired();
		if (this.itemBackground == null || this.itemBackground == undefined) {
			this.itemBackground = new CommandAttr<string>();
		}
		
		this.itemBackground.setSetter(true);
		this.itemBackground.setValue(value);
		this.orderSet++;
		this.itemBackground.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setSelectedItemId(value : string) : T {
		this.resetIfRequired();
		if (this.selectedItemId == null || this.selectedItemId == undefined) {
			this.selectedItemId = new CommandAttr<string>();
		}
		
		this.selectedItemId.setSetter(true);
		this.selectedItemId.setValue(value);
		this.orderSet++;
		this.selectedItemId.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setLabelVisibilityMode(value : LabelVisibilityMode) : T {
		this.resetIfRequired();
		if (this.labelVisibilityMode == null || this.labelVisibilityMode == undefined) {
			this.labelVisibilityMode = new CommandAttr<LabelVisibilityMode>();
		}
		
		this.labelVisibilityMode.setSetter(true);
		this.labelVisibilityMode.setValue(value);
		this.orderSet++;
		this.labelVisibilityMode.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setBadgeNumbers(value : string) : T {
		this.resetIfRequired();
		if (this.badgeNumbers == null || this.badgeNumbers == undefined) {
			this.badgeNumbers = new CommandAttr<string>();
		}
		
		this.badgeNumbers.setSetter(true);
		this.badgeNumbers.setValue(value);
		this.orderSet++;
		this.badgeNumbers.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setMenuItemIds(value : string) : T {
		this.resetIfRequired();
		if (this.menuItemIds == null || this.menuItemIds == undefined) {
			this.menuItemIds = new CommandAttr<string>();
		}
		
		this.menuItemIds.setSetter(true);
		this.menuItemIds.setValue(value);
		this.orderSet++;
		this.menuItemIds.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setBadgeAlphas(value : string) : T {
		this.resetIfRequired();
		if (this.badgeAlphas == null || this.badgeAlphas == undefined) {
			this.badgeAlphas = new CommandAttr<string>();
		}
		
		this.badgeAlphas.setSetter(true);
		this.badgeAlphas.setValue(value);
		this.orderSet++;
		this.badgeAlphas.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setBadgeMaxCharacterCounts(value : string) : T {
		this.resetIfRequired();
		if (this.badgeMaxCharacterCounts == null || this.badgeMaxCharacterCounts == undefined) {
			this.badgeMaxCharacterCounts = new CommandAttr<string>();
		}
		
		this.badgeMaxCharacterCounts.setSetter(true);
		this.badgeMaxCharacterCounts.setValue(value);
		this.orderSet++;
		this.badgeMaxCharacterCounts.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setBadgeGravities(value : string) : T {
		this.resetIfRequired();
		if (this.badgeGravities == null || this.badgeGravities == undefined) {
			this.badgeGravities = new CommandAttr<string>();
		}
		
		this.badgeGravities.setSetter(true);
		this.badgeGravities.setValue(value);
		this.orderSet++;
		this.badgeGravities.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setBadgeHorizontalOffsets(value : string) : T {
		this.resetIfRequired();
		if (this.badgeHorizontalOffsets == null || this.badgeHorizontalOffsets == undefined) {
			this.badgeHorizontalOffsets = new CommandAttr<string>();
		}
		
		this.badgeHorizontalOffsets.setSetter(true);
		this.badgeHorizontalOffsets.setValue(value);
		this.orderSet++;
		this.badgeHorizontalOffsets.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setBadgeVerticalOffsets(value : string) : T {
		this.resetIfRequired();
		if (this.badgeVerticalOffsets == null || this.badgeVerticalOffsets == undefined) {
			this.badgeVerticalOffsets = new CommandAttr<string>();
		}
		
		this.badgeVerticalOffsets.setSetter(true);
		this.badgeVerticalOffsets.setValue(value);
		this.orderSet++;
		this.badgeVerticalOffsets.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setBadgeIsVisibles(value : string) : T {
		this.resetIfRequired();
		if (this.badgeIsVisibles == null || this.badgeIsVisibles == undefined) {
			this.badgeIsVisibles = new CommandAttr<string>();
		}
		
		this.badgeIsVisibles.setSetter(true);
		this.badgeIsVisibles.setValue(value);
		this.orderSet++;
		this.badgeIsVisibles.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setMenuGravity(...value : Gravity[]) : T {
		this.resetIfRequired();
		if (this.menuGravity == null || this.menuGravity == undefined) {
			this.menuGravity = new CommandAttr<Gravity[]>();
		}
		
		this.menuGravity.setSetter(true);
		this.menuGravity.setValue(value);
		this.orderSet++;
		this.menuGravity.setOrderSet(this.orderSet);
this.menuGravity.setTransformer('gravity');		return this.thisPointer;
	}
		

	public setItemTextAppearanceInactive(value : string) : T {
		this.resetIfRequired();
		if (this.itemTextAppearanceInactive == null || this.itemTextAppearanceInactive == undefined) {
			this.itemTextAppearanceInactive = new CommandAttr<string>();
		}
		
		this.itemTextAppearanceInactive.setSetter(true);
		this.itemTextAppearanceInactive.setValue(value);
		this.orderSet++;
		this.itemTextAppearanceInactive.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setItemTextAppearanceActive(value : string) : T {
		this.resetIfRequired();
		if (this.itemTextAppearanceActive == null || this.itemTextAppearanceActive == undefined) {
			this.itemTextAppearanceActive = new CommandAttr<string>();
		}
		
		this.itemTextAppearanceActive.setSetter(true);
		this.itemTextAppearanceActive.setValue(value);
		this.orderSet++;
		this.itemTextAppearanceActive.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setBadgeBackgroundColors(value : string) : T {
		this.resetIfRequired();
		if (this.badgeBackgroundColors == null || this.badgeBackgroundColors == undefined) {
			this.badgeBackgroundColors = new CommandAttr<string>();
		}
		
		this.badgeBackgroundColors.setSetter(true);
		this.badgeBackgroundColors.setValue(value);
		this.orderSet++;
		this.badgeBackgroundColors.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setBadgeTextColors(value : string) : T {
		this.resetIfRequired();
		if (this.badgeTextColors == null || this.badgeTextColors == undefined) {
			this.badgeTextColors = new CommandAttr<string>();
		}
		
		this.badgeTextColors.setSetter(true);
		this.badgeTextColors.setValue(value);
		this.orderSet++;
		this.badgeTextColors.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setBadgeTextAppearanceResources(value : string) : T {
		this.resetIfRequired();
		if (this.badgeTextAppearanceResources == null || this.badgeTextAppearanceResources == undefined) {
			this.badgeTextAppearanceResources = new CommandAttr<string>();
		}
		
		this.badgeTextAppearanceResources.setSetter(true);
		this.badgeTextAppearanceResources.setValue(value);
		this.orderSet++;
		this.badgeTextAppearanceResources.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setHeaderLayout(value : string) : T {
		this.resetIfRequired();
		if (this.headerLayout == null || this.headerLayout == undefined) {
			this.headerLayout = new CommandAttr<string>();
		}
		
		this.headerLayout.setSetter(true);
		this.headerLayout.setValue(value);
		this.orderSet++;
		this.headerLayout.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		
	//end - body

}
	
//start - staticinit

export class NavigationRailView extends NavigationRailViewImpl<NavigationRailView> implements IWidget{
    getThisPointer(): NavigationRailView {
        return this;
    }
    
   	public getClass() {
		return NavigationRailView;
	}
	
   	constructor(id: string, path: string[], event: string) {
		super(id, path, event);	
	}
}

NavigationRailViewImpl.initialize();
export interface OnNavigationItemSelectedEvent extends Event{
        //item:MenuItem;


}
export interface OnNavigationItemReselectedEvent extends Event{
        //item:MenuItem;


}

//end - staticinit
