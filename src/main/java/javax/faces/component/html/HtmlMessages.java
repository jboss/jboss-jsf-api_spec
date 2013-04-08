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
import java.util.List;

import javax.faces.context.FacesContext;
import javax.el.MethodExpression;
import javax.el.ValueExpression;


/*
 * ******* GENERATED CODE - DO NOT EDIT *******
 */


/**
 * 
 * <p>By default, the <code>rendererType</code> property must be set to "<code>javax.faces.Messages</code>".
 * This value can be changed by calling the <code>setRendererType()</code> method.</p>
 */
public class HtmlMessages extends javax.faces.component.UIMessages {



    private static final String OPTIMIZED_PACKAGE = "javax.faces.component.";

    public HtmlMessages() {
        super();
        setRendererType("javax.faces.Messages");
    }


    /**
     * <p>The standard component type for this component.</p>
     */
    public static final String COMPONENT_TYPE = "javax.faces.HtmlMessages";


    protected enum PropertyKeys {
        dir,
        errorClass,
        errorStyle,
        fatalClass,
        fatalStyle,
        infoClass,
        infoStyle,
        lang,
        layout,
        role,
        style,
        styleClass,
        title,
        tooltip,
        warnClass,
        warnStyle,
;
        String toString;
        PropertyKeys(String toString) { this.toString = toString; }
        PropertyKeys() { }
        public String toString() {
            return ((toString != null) ? toString : super.toString());
        }
}

    /**
     * <p>Return the value of the <code>dir</code> property.</p>
     * <p>Contents: Direction indication for text that does not inherit directionality.
     * Valid values are "LTR" (left-to-right) and "RTL" (right-to-left).
     * These attributes are case sensitive when rendering to XHTML, so
     * care must be taken to have the correct case.
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
     * <p>Return the value of the <code>errorClass</code> property.</p>
     * <p>Contents: CSS style class to apply to any message
     * with a severity class of "ERROR".
     */
    public java.lang.String getErrorClass() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.errorClass);

    }

    /**
     * <p>Set the value of the <code>errorClass</code> property.</p>
     */
    public void setErrorClass(java.lang.String errorClass) {
        getStateHelper().put(PropertyKeys.errorClass, errorClass);
    }


    /**
     * <p>Return the value of the <code>errorStyle</code> property.</p>
     * <p>Contents: CSS style(s) to apply to any message
     * with a severity class of "ERROR".
     */
    public java.lang.String getErrorStyle() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.errorStyle);

    }

    /**
     * <p>Set the value of the <code>errorStyle</code> property.</p>
     */
    public void setErrorStyle(java.lang.String errorStyle) {
        getStateHelper().put(PropertyKeys.errorStyle, errorStyle);
    }


    /**
     * <p>Return the value of the <code>fatalClass</code> property.</p>
     * <p>Contents: CSS style class to apply to any message
     * with a severity class of "FATAL".
     */
    public java.lang.String getFatalClass() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.fatalClass);

    }

    /**
     * <p>Set the value of the <code>fatalClass</code> property.</p>
     */
    public void setFatalClass(java.lang.String fatalClass) {
        getStateHelper().put(PropertyKeys.fatalClass, fatalClass);
    }


    /**
     * <p>Return the value of the <code>fatalStyle</code> property.</p>
     * <p>Contents: CSS style(s) to apply to any message
     * with a severity class of "FATAL".
     */
    public java.lang.String getFatalStyle() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.fatalStyle);

    }

    /**
     * <p>Set the value of the <code>fatalStyle</code> property.</p>
     */
    public void setFatalStyle(java.lang.String fatalStyle) {
        getStateHelper().put(PropertyKeys.fatalStyle, fatalStyle);
    }


    /**
     * <p>Return the value of the <code>infoClass</code> property.</p>
     * <p>Contents: CSS style class to apply to any message
     * with a severity class of "INFO".
     */
    public java.lang.String getInfoClass() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.infoClass);

    }

    /**
     * <p>Set the value of the <code>infoClass</code> property.</p>
     */
    public void setInfoClass(java.lang.String infoClass) {
        getStateHelper().put(PropertyKeys.infoClass, infoClass);
    }


    /**
     * <p>Return the value of the <code>infoStyle</code> property.</p>
     * <p>Contents: CSS style(s) to apply to any message
     * with a severity class of "INFO".
     */
    public java.lang.String getInfoStyle() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.infoStyle);

    }

    /**
     * <p>Set the value of the <code>infoStyle</code> property.</p>
     */
    public void setInfoStyle(java.lang.String infoStyle) {
        getStateHelper().put(PropertyKeys.infoStyle, infoStyle);
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
     * <p>Return the value of the <code>layout</code> property.</p>
     * <p>Contents: The type of layout markup to use when rendering
     * error messages.  Valid values are "table" (an HTML
     * table) and "list" (an HTML list).  If not specified,
     * the default value is "list".
     */
    public java.lang.String getLayout() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.layout, "list");

    }

    /**
     * <p>Set the value of the <code>layout</code> property.</p>
     */
    public void setLayout(java.lang.String layout) {
        getStateHelper().put(PropertyKeys.layout, layout);
    }


    /**
     * <p>Return the value of the <code>role</code> property.</p>
     * <p>Contents: <p class="changed_added_2_2">Per the WAI-ARIA spec and its
     * relationship to HTML5 (Section title ARIA Role Attriubute),
     * every HTML element may have a "role" attribute whose value
     * must be passed through unmodified on the element on which it
     * is declared in the final rendered markup.  The attribute, if
     * specified, must have a value that is a string literal that is,
     * or an EL Expression that evaluates to, a set of
     * space-separated tokens representing the various WAI-ARIA roles
     * that the element belongs to.
     * </p>
     * 
     * <p class="changed_added_2_2">It is the page author's
     * responsibility to ensure that the user agent is capable of
     * correctly interpreting the value of this attribute.</p>
     */
    public java.lang.String getRole() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.role);

    }

    /**
     * <p>Set the value of the <code>role</code> property.</p>
     */
    public void setRole(java.lang.String role) {
        getStateHelper().put(PropertyKeys.role, role);
        handleAttribute("role", role);
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
     * <p>Return the value of the <code>tooltip</code> property.</p>
     * <p>Contents: Flag indicating whether the detail portion of the
     * message should be displayed as a tooltip.
     */
    public boolean isTooltip() {
        return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.tooltip, false);

    }

    /**
     * <p>Set the value of the <code>tooltip</code> property.</p>
     */
    public void setTooltip(boolean tooltip) {
        getStateHelper().put(PropertyKeys.tooltip, tooltip);
    }


    /**
     * <p>Return the value of the <code>warnClass</code> property.</p>
     * <p>Contents: CSS style class to apply to any message
     * with a severity class of "WARN".
     */
    public java.lang.String getWarnClass() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.warnClass);

    }

    /**
     * <p>Set the value of the <code>warnClass</code> property.</p>
     */
    public void setWarnClass(java.lang.String warnClass) {
        getStateHelper().put(PropertyKeys.warnClass, warnClass);
    }


    /**
     * <p>Return the value of the <code>warnStyle</code> property.</p>
     * <p>Contents: CSS style(s) to apply to any message
     * with a severity class of "WARN".
     */
    public java.lang.String getWarnStyle() {
        return (java.lang.String) getStateHelper().eval(PropertyKeys.warnStyle);

    }

    /**
     * <p>Set the value of the <code>warnStyle</code> property.</p>
     */
    public void setWarnStyle(java.lang.String warnStyle) {
        getStateHelper().put(PropertyKeys.warnStyle, warnStyle);
    }


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
