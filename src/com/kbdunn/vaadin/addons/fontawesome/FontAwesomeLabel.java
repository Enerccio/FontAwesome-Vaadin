package com.kbdunn.vaadin.addons.fontawesome;

import com.vaadin.server.Page;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;

public class FontAwesomeLabel extends Label {

	private static final long serialVersionUID = -1987552834791565983L;
	private static final ThemeResource fontAwesomeSource = new ThemeResource("../../addons/font-awesome-4.1.0/css/font-awesome.min.css");
	
	private String size, fixedWidth, border, spin, pull, rotate, flip, inverse, stackOrder, custom;
    private FontAwesomeLabel stacked;
    private FontAwesome icon;
    
    public FontAwesomeLabel(FontAwesome icon) {
    	this.icon = icon;
    	setContentMode(ContentMode.HTML);
    	addAttachListener(new AttachListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void attach(AttachEvent event) {
				Page.getCurrent().getStyles().add(fontAwesomeSource);
				applyChanges();
			}
    	});
    }
    
    public void applyChanges() {
    	setValue(getCssHtml());
    }

    public String getCssClasses(boolean ignoreSize) {
    	String classes = "fa " + icon.clazz;
    	classes += !ignoreSize && size != null ? " " + size : "";
    	classes += fixedWidth != null ? " " + fixedWidth : "";
    	classes += border != null ? " " + border : "";
    	classes += spin != null ? " " + spin : "";
    	classes += pull != null ? " " + pull : "";
    	classes += rotate != null ? " " + rotate : "";
    	classes += flip != null ? " " + flip : "";
    	classes += inverse != null ? " " + inverse : "";
    	classes += stackOrder != null ? " " + stackOrder : "";
    	return classes;
    }
    
    public String getCssHtml() {
    	if (stacked == null) {
    		return "<i class=\"" + getCssClasses(false) + "\" style=\"" + custom + "\"/></i>";
    	} 
    	// Get stack size (bottom object takes precedence). Clear individual sizes.
    	String stackSize = size != null ? size : stacked.size != null ? stacked.size : null;
    	return "<span class=\"fa-stack " + stackSize + "\">"
    			+ "<i class=\"" + getCssClasses(true) + "\" style=\"" + custom + "\"/></i>"
    			+ stacked.getCssHtml()
    			+ "</span>";
    }
    
    public FontAwesomeLabel setCustomStyle(String css) {
    	custom = css; return this;
    }
    
    public FontAwesomeLabel setSizeLg() {
    	size = "fa-lg"; return this;
    }
    
    public FontAwesomeLabel setSize2x() {
    	size = "fa-2x"; return this;
    }
    
    public FontAwesomeLabel setSize3x() {
    	size = "fa-3x"; return this;
    }
    
    public FontAwesomeLabel setSize4x() {
    	size = "fa-4x"; return this;
    }
    
    public FontAwesomeLabel setSize5x() {
    	size = "fa-5x"; return this;
    }
    
    public FontAwesomeLabel setSize6x() {
    	custom += "font-size: 6em;"; return this;
    }
    
    public FontAwesomeLabel fixedWidth() {
    	fixedWidth = "fa-fw"; return this;
    }
    
    public FontAwesomeLabel enableBorder() {
    	border = "fa-border"; return this;
    }
    
    public FontAwesomeLabel pullLeft() {
    	pull = "pull-left"; return this;
    }
    
    public FontAwesomeLabel pullRight() {
    	pull = "pull-right"; return this;
    }
    
    public FontAwesomeLabel spin() {
    	spin = "fa-spin"; return this;
    }
    
    public FontAwesomeLabel rotate90() {
    	rotate = "fa-rotate-90"; return this;
    }
    
    public FontAwesomeLabel rotate180() {
    	rotate = "fa-rotate-180"; return this;
    }
    
    public FontAwesomeLabel rotate270() {
    	rotate = "fa-rotate-270"; return this;
    }
    
    public FontAwesomeLabel flipHorizontal() {
    	flip = "fa-flip-horizontal"; return this;
    }
    
    public FontAwesomeLabel flipVertical() {
    	flip = "fa-flip-vertical"; return this;
    }
    
    public FontAwesomeLabel inverseColor() {
    	inverse = "fa-inverse"; return this;
    }
    
    public FontAwesomeLabel stack(FontAwesome overlay) {
    	return stack(overlay.getLabel());
    }
    
    public FontAwesomeLabel stack(FontAwesomeLabel overlay) {
    	stacked = overlay;
    	stackOrder = "fa-stack-1x";
    	stacked.stackOrder = "fa-stack-2x";
    	return this;
    }
    
    public FontAwesomeLabel reverseStackSize() {
    	stackOrder = "fa-stack-2x"; 
    	if (stacked != null) stacked.stackOrder = "fa-stack-1x";
    	return this;
    }
    
    public FontAwesomeLabel clearStack() {
    	if (stacked != null) stacked.stackOrder = null;
    	stacked = null;
    	stackOrder = null;
    	return this;
    }
}