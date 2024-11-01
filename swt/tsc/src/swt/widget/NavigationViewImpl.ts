// start - imports

	
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
export abstract class NavigationViewImpl<T> extends ViewGroupImpl<T>{
	//start - body
	static initialize() {
    }	
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "itemBackground" }))
	itemBackground!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "itemHorizontalPadding" }))
	itemHorizontalPadding!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "itemIconPadding" }))
	itemIconPadding!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "itemIconSize" }))
	itemIconSize!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "itemIconTint" }))
	itemIconTint!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "itemMaxLines" }))
	itemMaxLines!:CommandAttr<number>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "itemTextColor" }))
	itemTextColor!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "itemVerticalPadding" }))
	itemVerticalPadding!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "menu" }))
	menu!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "headerLayout" }))
	headerLayout!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "onItemSelected" }))
	onItemSelected!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "dividerInsetStart" }))
	dividerInsetStart!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "dividerInsetEnd" }))
	dividerInsetEnd!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "subheaderInsetStart" }))
	subheaderInsetStart!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "subheaderInsetEnd" }))
	subheaderInsetEnd!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "itemTextAppearance" }))
	itemTextAppearance!:CommandAttr<string>| undefined;

	@decorate(Exclude())
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.itemBackground = undefined;
		this.itemHorizontalPadding = undefined;
		this.itemIconPadding = undefined;
		this.itemIconSize = undefined;
		this.itemIconTint = undefined;
		this.itemMaxLines = undefined;
		this.itemTextColor = undefined;
		this.itemVerticalPadding = undefined;
		this.menu = undefined;
		this.headerLayout = undefined;
		this.onItemSelected = undefined;
		this.dividerInsetStart = undefined;
		this.dividerInsetEnd = undefined;
		this.subheaderInsetStart = undefined;
		this.subheaderInsetEnd = undefined;
		this.itemTextAppearance = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
	}
	

	public tryGetItemBackground() : T {
		this.resetIfRequired();
		if (this.itemBackground == null || this.itemBackground == undefined) {
			this.itemBackground = new CommandAttr<string>()
		}
		
		this.itemBackground.setGetter(true);
		this.orderGet++;
		this.itemBackground.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getItemBackground() : string {
		if (this.itemBackground == null || this.itemBackground == undefined) {
			this.itemBackground = new CommandAttr<string>();
		}
		return this.itemBackground.getCommandReturnValue();
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
		

	public tryGetItemHorizontalPadding() : T {
		this.resetIfRequired();
		if (this.itemHorizontalPadding == null || this.itemHorizontalPadding == undefined) {
			this.itemHorizontalPadding = new CommandAttr<string>()
		}
		
		this.itemHorizontalPadding.setGetter(true);
		this.orderGet++;
		this.itemHorizontalPadding.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getItemHorizontalPadding() : string {
		if (this.itemHorizontalPadding == null || this.itemHorizontalPadding == undefined) {
			this.itemHorizontalPadding = new CommandAttr<string>();
		}
		return this.itemHorizontalPadding.getCommandReturnValue();
	}
	public setItemHorizontalPadding(value : string) : T {
		this.resetIfRequired();
		if (this.itemHorizontalPadding == null || this.itemHorizontalPadding == undefined) {
			this.itemHorizontalPadding = new CommandAttr<string>();
		}
		
		this.itemHorizontalPadding.setSetter(true);
		this.itemHorizontalPadding.setValue(value);
		this.orderSet++;
		this.itemHorizontalPadding.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetItemIconPadding() : T {
		this.resetIfRequired();
		if (this.itemIconPadding == null || this.itemIconPadding == undefined) {
			this.itemIconPadding = new CommandAttr<string>()
		}
		
		this.itemIconPadding.setGetter(true);
		this.orderGet++;
		this.itemIconPadding.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getItemIconPadding() : string {
		if (this.itemIconPadding == null || this.itemIconPadding == undefined) {
			this.itemIconPadding = new CommandAttr<string>();
		}
		return this.itemIconPadding.getCommandReturnValue();
	}
	public setItemIconPadding(value : string) : T {
		this.resetIfRequired();
		if (this.itemIconPadding == null || this.itemIconPadding == undefined) {
			this.itemIconPadding = new CommandAttr<string>();
		}
		
		this.itemIconPadding.setSetter(true);
		this.itemIconPadding.setValue(value);
		this.orderSet++;
		this.itemIconPadding.setOrderSet(this.orderSet);
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
		

	public tryGetItemIconTint() : T {
		this.resetIfRequired();
		if (this.itemIconTint == null || this.itemIconTint == undefined) {
			this.itemIconTint = new CommandAttr<string>()
		}
		
		this.itemIconTint.setGetter(true);
		this.orderGet++;
		this.itemIconTint.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getItemIconTint() : string {
		if (this.itemIconTint == null || this.itemIconTint == undefined) {
			this.itemIconTint = new CommandAttr<string>();
		}
		return this.itemIconTint.getCommandReturnValue();
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
		

	public tryGetItemMaxLines() : T {
		this.resetIfRequired();
		if (this.itemMaxLines == null || this.itemMaxLines == undefined) {
			this.itemMaxLines = new CommandAttr<number>()
		}
		
		this.itemMaxLines.setGetter(true);
		this.orderGet++;
		this.itemMaxLines.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getItemMaxLines() : number {
		if (this.itemMaxLines == null || this.itemMaxLines == undefined) {
			this.itemMaxLines = new CommandAttr<number>();
		}
		return this.itemMaxLines.getCommandReturnValue();
	}
	public setItemMaxLines(value : number) : T {
		this.resetIfRequired();
		if (this.itemMaxLines == null || this.itemMaxLines == undefined) {
			this.itemMaxLines = new CommandAttr<number>();
		}
		
		this.itemMaxLines.setSetter(true);
		this.itemMaxLines.setValue(value);
		this.orderSet++;
		this.itemMaxLines.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetItemTextColor() : T {
		this.resetIfRequired();
		if (this.itemTextColor == null || this.itemTextColor == undefined) {
			this.itemTextColor = new CommandAttr<string>()
		}
		
		this.itemTextColor.setGetter(true);
		this.orderGet++;
		this.itemTextColor.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getItemTextColor() : string {
		if (this.itemTextColor == null || this.itemTextColor == undefined) {
			this.itemTextColor = new CommandAttr<string>();
		}
		return this.itemTextColor.getCommandReturnValue();
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
		

	public tryGetItemVerticalPadding() : T {
		this.resetIfRequired();
		if (this.itemVerticalPadding == null || this.itemVerticalPadding == undefined) {
			this.itemVerticalPadding = new CommandAttr<string>()
		}
		
		this.itemVerticalPadding.setGetter(true);
		this.orderGet++;
		this.itemVerticalPadding.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getItemVerticalPadding() : string {
		if (this.itemVerticalPadding == null || this.itemVerticalPadding == undefined) {
			this.itemVerticalPadding = new CommandAttr<string>();
		}
		return this.itemVerticalPadding.getCommandReturnValue();
	}
	public setItemVerticalPadding(value : string) : T {
		this.resetIfRequired();
		if (this.itemVerticalPadding == null || this.itemVerticalPadding == undefined) {
			this.itemVerticalPadding = new CommandAttr<string>();
		}
		
		this.itemVerticalPadding.setSetter(true);
		this.itemVerticalPadding.setValue(value);
		this.orderSet++;
		this.itemVerticalPadding.setOrderSet(this.orderSet);
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
		

	public setDividerInsetStart(value : string) : T {
		this.resetIfRequired();
		if (this.dividerInsetStart == null || this.dividerInsetStart == undefined) {
			this.dividerInsetStart = new CommandAttr<string>();
		}
		
		this.dividerInsetStart.setSetter(true);
		this.dividerInsetStart.setValue(value);
		this.orderSet++;
		this.dividerInsetStart.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setDividerInsetEnd(value : string) : T {
		this.resetIfRequired();
		if (this.dividerInsetEnd == null || this.dividerInsetEnd == undefined) {
			this.dividerInsetEnd = new CommandAttr<string>();
		}
		
		this.dividerInsetEnd.setSetter(true);
		this.dividerInsetEnd.setValue(value);
		this.orderSet++;
		this.dividerInsetEnd.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setSubheaderInsetStart(value : string) : T {
		this.resetIfRequired();
		if (this.subheaderInsetStart == null || this.subheaderInsetStart == undefined) {
			this.subheaderInsetStart = new CommandAttr<string>();
		}
		
		this.subheaderInsetStart.setSetter(true);
		this.subheaderInsetStart.setValue(value);
		this.orderSet++;
		this.subheaderInsetStart.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setSubheaderInsetEnd(value : string) : T {
		this.resetIfRequired();
		if (this.subheaderInsetEnd == null || this.subheaderInsetEnd == undefined) {
			this.subheaderInsetEnd = new CommandAttr<string>();
		}
		
		this.subheaderInsetEnd.setSetter(true);
		this.subheaderInsetEnd.setValue(value);
		this.orderSet++;
		this.subheaderInsetEnd.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setItemTextAppearance(value : string) : T {
		this.resetIfRequired();
		if (this.itemTextAppearance == null || this.itemTextAppearance == undefined) {
			this.itemTextAppearance = new CommandAttr<string>();
		}
		
		this.itemTextAppearance.setSetter(true);
		this.itemTextAppearance.setValue(value);
		this.orderSet++;
		this.itemTextAppearance.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		
	//end - body

}
	
//start - staticinit

export class NavigationView extends NavigationViewImpl<NavigationView> implements IWidget{
    getThisPointer(): NavigationView {
        return this;
    }
    
   	public getClass() {
		return NavigationView;
	}
	
   	constructor(id: string, path: string[], event: string) {
		super(id, path, event);	
	}
}

NavigationViewImpl.initialize();
export interface OnNavigationItemSelectedEvent extends Event{
        //item:MenuItem;


}

//end - staticinit
