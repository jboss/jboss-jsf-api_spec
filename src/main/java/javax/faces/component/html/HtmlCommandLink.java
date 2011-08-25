/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * 
 * Copyright (c) 1997-2010 Oracle and/or its affiliates. All rights reserved.
 * 
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 * 
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 * 
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 * 
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 * 
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package javax.faces.component.html;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.component.behavior.ClientBehaviorHolder;
import javax.el.MethodExpression;
import javax.el.ValueExpression;


/*
 * ******* GENERATED CODE - DO NOT EDIT *******
 */


/**
 * <p>Represents an HTML <code>a</code> element for a hyperlink that acts
 * like a submit button.  This component must be placed inside
 * a form, and requires JavaScript to be enabled in the client.</p>
 * <p>By default, the <code>rendererType</code> property must be set to "<code>javax.faces.Link</code>".
 * This value can be changed by calling the <code>setRendererType()</code> method.</p>
 */
public class HtmlCommandLink extends javax.faces.component.UICommand implements ClientBehaviorHolder {



    private static final String OPTIMIZED_PACKAGE = "javax.faces.component.";

    public HtmlCommandLink() {
        super();
        setRendererType("javax.faces.Link");
    }


    /**
     * <p>The standard component type for this component.</p>
     */
    public static final String COMPONENT_TYPE = "javax.faces.HtmlCommandLink";


    protected enum PropertyKeys {
        accesskey,
        charset,
        coords,
        dir,
        disabled,
        hreflang,
        lang,
        onblur,
        onclick,
        ondblclick,
        onfocus,
        onkeydown,
        onkeypress,
        onkeyup,
        onmousedown,
        onmousemove,
        onmouseout,
        onmouseover,
        onmouseup,
        rel,
        rev,
        shape,
        style,
        styleClass,
        tabindex,
        target,
        title,
        type,
;
        String toString;
        PropertyKeys(String toString) { this.toString = toString; }
        PropertyKeys() { }
        public String toString() {
            return ((toString != null) ? toString : super.toString());
        }
}

    /**
     * <p>Return the value of the <code>accesskey</code> property.</p>
     * <p>Contents: Access key that, when pressed, transfers focus
     * to this element.
     */
    public java.lang.String getAccesskey() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.accesskey);

    }

    /**
     * <p>Set the value of the <code>accesskey</code> property.</p>
     */
    public void setAccesskey(java.lang.String accesskey) {
        getStateHelper().put(PropertyKeys.accesskey, accesskey);
        handleAttribute("accesskey", accesskey);
    }


    /**
     * <p>Return the value of the <code>charset</code> property.</p>
     * <p>Contents: The character encoding of the resource designated
     * by this hyperlink.
     */
    public java.lang.String getCharset() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.charset);

    }

    /**
     * <p>Set the value of the <code>charset</code> property.</p>
     */
    public void setCharset(java.lang.String charset) {
        getStateHelper().put(PropertyKeys.charset, charset);
        handleAttribute("charset", charset);
    }


    /**
     * <p>Return the value of the <code>coords</code> property.</p>
     * <p>Contents: The position and shape of the hot spot on the screen
     * (for use in client-side image maps).
     */
    public java.lang.String getCoords() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.coords);

    }

    /**
     * <p>Set the value of the <code>coords</code> property.</p>
     */
    public void setCoords(java.lang.String coords) {
        getStateHelper().put(PropertyKeys.coords, coords);
        handleAttribute("coords", coords);
    }


    /**
     * <p>Return the value of the <code>dir</code> property.</p>
     * <p>Contents: Direction indication for text that does not inherit directionality.
     * Valid values are "LTR" (left-to-right) and "RTL" (right-to-left).
     */
    public java.lang.String getDir() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.dir);

    }

    /**
     * <p>Set the value of the <code>dir</code> property.</p>
     */
    public void setDir(java.lang.String dir) {
        getStateHelper().put(PropertyKeys.dir, dir);
        handleAttribute("dir", dir);
    }


    /**
     * <p>Return the value of the <code>disabled</code> property.</p>
     * <p>Contents: Flag indicating that this element must never
     * receive focus or be included in a subsequent
     * submit.
     */
    public boolean isDisabled() {
        return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.disabled, false);

    }

    /**
     * <p>Set the value of the <code>disabled</code> property.</p>
     */
    public void setDisabled(boolean disabled) {
        getStateHelper().put(PropertyKeys.disabled, disabled);
    }


    /**
     * <p>Return the value of the <code>hreflang</code> property.</p>
     * <p>Contents: The language code of the resource designated
     * by this hyperlink.
     */
    public java.lang.String getHreflang() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.hreflang);

    }

    /**
     * <p>Set the value of the <code>hreflang</code> property.</p>
     */
    public void setHreflang(java.lang.String hreflang) {
        getStateHelper().put(PropertyKeys.hreflang, hreflang);
        handleAttribute("hreflang", hreflang);
    }


    /**
     * <p>Return the value of the <code>lang</code> property.</p>
     * <p>Contents: Code describing the language used in the generated markup
     * for this component.
     */
    public java.lang.String getLang() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.lang);

    }

    /**
     * <p>Set the value of the <code>lang</code> property.</p>
     */
    public void setLang(java.lang.String lang) {
        getStateHelper().put(PropertyKeys.lang, lang);
        handleAttribute("lang", lang);
    }


    /**
     * <p>Return the value of the <code>onblur</code> property.</p>
     * <p>Contents: Javascript code executed when this element loses focus.
     */
    public java.lang.String getOnblur() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.onblur);

    }

    /**
     * <p>Set the value of the <code>onblur</code> property.</p>
     */
    public void setOnblur(java.lang.String onblur) {
        getStateHelper().put(PropertyKeys.onblur, onblur);
        handleAttribute("onblur", onblur);
    }


    /**
     * <p>Return the value of the <code>onclick</code> property.</p>
     * <p>Contents: Javascript code executed when a pointer button is
     * clicked over this element.
     */
    public java.lang.String getOnclick() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.onclick);

    }

    /**
     * <p>Set the value of the <code>onclick</code> property.</p>
     */
    public void setOnclick(java.lang.String onclick) {
        getStateHelper().put(PropertyKeys.onclick, onclick);
    }


    /**
     * <p>Return the value of the <code>ondblclick</code> property.</p>
     * <p>Contents: Javascript code executed when a pointer button is
     * double clicked over this element.
     */
    public java.lang.String getOndblclick() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.ondblclick);

    }

    /**
     * <p>Set the value of the <code>ondblclick</code> property.</p>
     */
    public void setOndblclick(java.lang.String ondblclick) {
        getStateHelper().put(PropertyKeys.ondblclick, ondblclick);
        handleAttribute("ondblclick", ondblclick);
    }


    /**
     * <p>Return the value of the <code>onfocus</code> property.</p>
     * <p>Contents: Javascript code executed when this element receives focus.
     */
    public java.lang.String getOnfocus() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.onfocus);

    }

    /**
     * <p>Set the value of the <code>onfocus</code> property.</p>
     */
    public void setOnfocus(java.lang.String onfocus) {
        getStateHelper().put(PropertyKeys.onfocus, onfocus);
        handleAttribute("onfocus", onfocus);
    }


    /**
     * <p>Return the value of the <code>onkeydown</code> property.</p>
     * <p>Contents: Javascript code executed when a key is
     * pressed down over this element.
     */
    public java.lang.String getOnkeydown() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.onkeydown);

    }

    /**
     * <p>Set the value of the <code>onkeydown</code> property.</p>
     */
    public void setOnkeydown(java.lang.String onkeydown) {
        getStateHelper().put(PropertyKeys.onkeydown, onkeydown);
        handleAttribute("onkeydown", onkeydown);
    }


    /**
     * <p>Return the value of the <code>onkeypress</code> property.</p>
     * <p>Contents: Javascript code executed when a key is
     * pressed and released over this element.
     */
    public java.lang.String getOnkeypress() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.onkeypress);

    }

    /**
     * <p>Set the value of the <code>onkeypress</code> property.</p>
     */
    public void setOnkeypress(java.lang.String onkeypress) {
        getStateHelper().put(PropertyKeys.onkeypress, onkeypress);
        handleAttribute("onkeypress", onkeypress);
    }


    /**
     * <p>Return the value of the <code>onkeyup</code> property.</p>
     * <p>Contents: Javascript code executed when a key is
     * released over this element.
     */
    public java.lang.String getOnkeyup() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.onkeyup);

    }

    /**
     * <p>Set the value of the <code>onkeyup</code> property.</p>
     */
    public void setOnkeyup(java.lang.String onkeyup) {
        getStateHelper().put(PropertyKeys.onkeyup, onkeyup);
        handleAttribute("onkeyup", onkeyup);
    }


    /**
     * <p>Return the value of the <code>onmousedown</code> property.</p>
     * <p>Contents: Javascript code executed when a pointer button is
     * pressed down over this element.
     */
    public java.lang.String getOnmousedown() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.onmousedown);

    }

    /**
     * <p>Set the value of the <code>onmousedown</code> property.</p>
     */
    public void setOnmousedown(java.lang.String onmousedown) {
        getStateHelper().put(PropertyKeys.onmousedown, onmousedown);
        handleAttribute("onmousedown", onmousedown);
    }


    /**
     * <p>Return the value of the <code>onmousemove</code> property.</p>
     * <p>Contents: Javascript code executed when a pointer button is
     * moved within this element.
     */
    public java.lang.String getOnmousemove() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.onmousemove);

    }

    /**
     * <p>Set the value of the <code>onmousemove</code> property.</p>
     */
    public void setOnmousemove(java.lang.String onmousemove) {
        getStateHelper().put(PropertyKeys.onmousemove, onmousemove);
        handleAttribute("onmousemove", onmousemove);
    }


    /**
     * <p>Return the value of the <code>onmouseout</code> property.</p>
     * <p>Contents: Javascript code executed when a pointer button is
     * moved away from this element.
     */
    public java.lang.String getOnmouseout() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.onmouseout);

    }

    /**
     * <p>Set the value of the <code>onmouseout</code> property.</p>
     */
    public void setOnmouseout(java.lang.String onmouseout) {
        getStateHelper().put(PropertyKeys.onmouseout, onmouseout);
        handleAttribute("onmouseout", onmouseout);
    }


    /**
     * <p>Return the value of the <code>onmouseover</code> property.</p>
     * <p>Contents: Javascript code executed when a pointer button is
     * moved onto this element.
     */
    public java.lang.String getOnmouseover() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.onmouseover);

    }

    /**
     * <p>Set the value of the <code>onmouseover</code> property.</p>
     */
    public void setOnmouseover(java.lang.String onmouseover) {
        getStateHelper().put(PropertyKeys.onmouseover, onmouseover);
        handleAttribute("onmouseover", onmouseover);
    }


    /**
     * <p>Return the value of the <code>onmouseup</code> property.</p>
     * <p>Contents: Javascript code executed when a pointer button is
     * released over this element.
     */
    public java.lang.String getOnmouseup() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.onmouseup);

    }

    /**
     * <p>Set the value of the <code>onmouseup</code> property.</p>
     */
    public void setOnmouseup(java.lang.String onmouseup) {
        getStateHelper().put(PropertyKeys.onmouseup, onmouseup);
        handleAttribute("onmouseup", onmouseup);
    }


    /**
     * <p>Return the value of the <code>rel</code> property.</p>
     * <p>Contents: The relationship from the current document
     * to the anchor specified by this hyperlink.
     * The value of this attribute is a space-separated
     * list of link types.
     */
    public java.lang.String getRel() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.rel);

    }

    /**
     * <p>Set the value of the <code>rel</code> property.</p>
     */
    public void setRel(java.lang.String rel) {
        getStateHelper().put(PropertyKeys.rel, rel);
        handleAttribute("rel", rel);
    }


    /**
     * <p>Return the value of the <code>rev</code> property.</p>
     * <p>Contents: A reverse link from the anchor specified
     * by this hyperlink to the current document.
     * The value of this attribute is a space-separated
     * list of link types.
     */
    public java.lang.String getRev() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.rev);

    }

    /**
     * <p>Set the value of the <code>rev</code> property.</p>
     */
    public void setRev(java.lang.String rev) {
        getStateHelper().put(PropertyKeys.rev, rev);
        handleAttribute("rev", rev);
    }


    /**
     * <p>Return the value of the <code>shape</code> property.</p>
     * <p>Contents: The shape of the hot spot on the screen
     * (for use in client-side image maps).  Valid
     * values are:  default (entire region); rect
     * (rectangular region); circle (circular region);
     * and poly (polygonal region).
     */
    public java.lang.String getShape() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.shape);

    }

    /**
     * <p>Set the value of the <code>shape</code> property.</p>
     */
    public void setShape(java.lang.String shape) {
        getStateHelper().put(PropertyKeys.shape, shape);
        handleAttribute("shape", shape);
    }


    /**
     * <p>Return the value of the <code>style</code> property.</p>
     * <p>Contents: CSS style(s) to be applied when this component is rendered.
     */
    public java.lang.String getStyle() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.style);

    }

    /**
     * <p>Set the value of the <code>style</code> property.</p>
     */
    public void setStyle(java.lang.String style) {
        getStateHelper().put(PropertyKeys.style, style);
        handleAttribute("style", style);
    }


    /**
     * <p>Return the value of the <code>styleClass</code> property.</p>
     * <p>Contents: Space-separated list of CSS style class(es) to be applied when
     * this element is rendered.  This value must be passed through
     * as the "class" attribute on generated markup.
     */
    public java.lang.String getStyleClass() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.styleClass);

    }

    /**
     * <p>Set the value of the <code>styleClass</code> property.</p>
     */
    public void setStyleClass(java.lang.String styleClass) {
        getStateHelper().put(PropertyKeys.styleClass, styleClass);
    }


    /**
     * <p>Return the value of the <code>tabindex</code> property.</p>
     * <p>Contents: Position of this element in the tabbing order
     * for the current document.  This value must be
     * an integer between 0 and 32767.
     */
    public java.lang.String getTabindex() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.tabindex);

    }

    /**
     * <p>Set the value of the <code>tabindex</code> property.</p>
     */
    public void setTabindex(java.lang.String tabindex) {
        getStateHelper().put(PropertyKeys.tabindex, tabindex);
        handleAttribute("tabindex", tabindex);
    }


    /**
     * <p>Return the value of the <code>target</code> property.</p>
     * <p>Contents: Name of a frame where the resource
     * retrieved via this hyperlink is to
     * be displayed.
     */
    public java.lang.String getTarget() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.target);

    }

    /**
     * <p>Set the value of the <code>target</code> property.</p>
     */
    public void setTarget(java.lang.String target) {
        getStateHelper().put(PropertyKeys.target, target);
    }


    /**
     * <p>Return the value of the <code>title</code> property.</p>
     * <p>Contents: Advisory title information about markup elements generated
     * for this component.
     */
    public java.lang.String getTitle() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.title);

    }

    /**
     * <p>Set the value of the <code>title</code> property.</p>
     */
    public void setTitle(java.lang.String title) {
        getStateHelper().put(PropertyKeys.title, title);
        handleAttribute("title", title);
    }


    /**
     * <p>Return the value of the <code>type</code> property.</p>
     * <p>Contents: The content type of the resource designated
     * by this hyperlink.
     */
    public java.lang.String getType() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.type);

    }

    /**
     * <p>Set the value of the <code>type</code> property.</p>
     */
    public void setType(java.lang.String type) {
        getStateHelper().put(PropertyKeys.type, type);
        handleAttribute("type", type);
    }


    private static final Collection<String> EVENT_NAMES = Collections.unmodifiableCollection(Arrays.asList("blur","click","action","dblclick","focus","keydown","keypress","keyup","mousedown","mousemove","mouseout","mouseover","mouseup"));

    public Collection<String> getEventNames() {
        return EVENT_NAMES;    }


    public String getDefaultEventName() {
        return "action";    }


    private void handleAttribute(String name, Object value) {
        List<String> setAttributes = (List<String>) this.getAttributes().get("javax.faces.component.UIComponentBase.attributesThatAreSet");
        if (setAttributes == null) {
            String cname = this.getClass().getName();
            if (cname != null && cname.startsWith(OPTIMIZED_PACKAGE)) {
                setAttributes = new ArrayList<String>(6);
                this.getAttributes().put("javax.faces.component.UIComponentBase.attributesThatAreSet", setAttributes);
            }
        }
        if (setAttributes != null) {
            if (value == null) {
                ValueExpression ve = getValueExpression(name);
                if (ve == null) {
                    setAttributes.remove(name);
                }
            } else if (!setAttributes.contains(name)) {
                setAttributes.add(name);
            }
        }
    }

}
