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

package javax.faces.component;

import java.io.IOException;
import javax.el.ValueExpression;
import javax.faces.FactoryFinder;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.render.RenderKit;
import javax.faces.render.RenderKitFactory;
import javax.faces.render.Renderer;

/**
 * <p class="changed_added_2_0"><strong>UIViewParameter</strong> represents a
 * binding between a request parameter and a model property or {@link UIViewRoot}
 * property. This is a bi-directional binding.</p>
 *
 * <div class="changed_added_2_0">

 * <p>The {@link javax.faces.view.ViewDeclarationLanguage}
 * implementation must cause an instance of this component to appear in
 * the view for each occurrence of an <code>&lt;f:viewParam /&gt;</code>
 * element placed inside of an <code>&lt;f:metadata /&gt;</code>
 * element.  The user must place this facet within the
 * <code>UIViewRoot</code>.</p>

 * <p>Because this class extends <code>UIInput</code> any actions that
 * one would normally take on a <code>UIInput</code> instance are valid
 * for instances of this class.  Instances of this class participate in
 * the regular JSF lifecycle, including on Ajax requests.</p>

 * </div>
 *
 * @since 2.0
 */
public class UIViewParameter extends UIInput {

    
    // ------------------------------------------------------ Manifest Constants


    /**
     * <p>The standard component type for this component.</p>
     */
    public static final String COMPONENT_TYPE = "javax.faces.ViewParameter";


    /**
     * <p>The standard component family for this component.</p>
     */
    public static final String COMPONENT_FAMILY = "javax.faces.ViewParameter";


    enum PropertyKeys {
        name,
        submittedValue
    }

    // ------------------------------------------------------ Instance Variables

    private Renderer inputTextRenderer = null;
    
    // ------------------------------------------------------------ Constructors


    /**
     * <p>Create a new {@link UIViewParameter} instance with default
     * property values.</p>
     */
    public UIViewParameter() {

        super();
        setRendererType(null);

    }


    // ------------------------------------------------------ Instance Variables


    /**
     * <p>The raw value is the "implicit" binding for this view parameter. This property
     * maintains the submitted value of the view parameter for the duration of the request.
     * If the view parameter does not explicitly specify a value expression, then when the
     * request ends, this value is stored with the state of this component to use as the
     * submitted value on an ensuing postback.</p>
     */
    private String rawValue;


    // -------------------------------------------------------------- Properties


    @Override
    public String getFamily() {

        return (COMPONENT_FAMILY);

    }

    /**
     * <p class="changed_added_2_0">Return the request parameter name
     * from which the value is retrieved.</p>
     * @since 2.0
     */
    public String getName() {

        return (String) getStateHelper().eval(PropertyKeys.name);

    }


    /**
     * <p class="changed_added_2_0">Set the request parameter name from
     * which the value is retrieved.</p>
     *
     * @param name The new request parameter name.
     * @since 2.0
     */
    public void setName(String name) {

        getStateHelper().put(PropertyKeys.name, name);

    }

    /**
     * <p class="changed_added_2_0">Return <code>false</code>.  The
     * immediate setting is not relevant for view parameters and must be
     * assumed to be <code>false</code>.</p>
     * @since 2.0
     */
    @Override
    public boolean isImmediate() {
        return false;
    }

    /**
     * <p class="changed_added_2_0">Assume that the submitted value is
     * always a string.</p>
     * @since 2.0
     */
    @Override
    public String getSubmittedValue() {
        return (String) getStateHelper().get(PropertyKeys.submittedValue);
    }

    /**
     * PENDING (docs)  Interesting that submitted value isn't saved by the parent
     * @param submittedValue The new submitted value
     */
    @Override
    public void setSubmittedValue(Object submittedValue) {
        getStateHelper().put(PropertyKeys.submittedValue, submittedValue);
    }

    // ----------------------------------------------------- UIComponent Methods


    // This is the "Apply Request Phase" step
    // QUESTION should we just override processDecodes() directly?
    // ANSWER: In this case, no.  We don't want to take responsibility for 
    // traversing any children we may have in the future.

    /**
     * <p class="changed_added_2_0">Override behavior from superclass to
     * pull a value from the incoming request parameter map under the
     * name given by {@link #getName} and store it with a call to {@link
     * UIInput#setSubmittedValue}.</p>
     * @since 2.0
     */
    @Override
    public void decode(FacesContext context) {
        if (context == null) {
            throw new NullPointerException();
        }

        // QUESTION can we move forward and support an array? no different than UISelectMany; perhaps need to know
        // if the value expression is single or multi-valued
        // ANSWER: I'd rather not right now.
        String paramValue = context.getExternalContext().getRequestParameterMap().get(getName());

        // submitted value will stay as previous value (null on initial request) if a parameter is absent
        if (paramValue != null) {
            setSubmittedValue(paramValue);
        }

        rawValue = (String) getSubmittedValue();
        setValid(true);

    }
    
    /**
     * <p class="changed_added_2_0">Specialize superclass behavior to treat
     * <code>null</code> differently.  In this class, a <code>null</code> value
     * along with the "required" flag being set to <code>true</code> will
     * cause a validation failure. </p>
     * @param context
     * @since 2.0
     */

    @Override
    public void processValidators(FacesContext context) {
        if (context == null) {
            throw new NullPointerException();
        }

        // Skip processing if our rendered flag is false
        if (!isRendered()) {
            return;
        }

        // we have to override since UIInput assumes that a null value means don't check
        if (getSubmittedValue() == null && isRequired()) {
            String requiredMessageStr = getRequiredMessage();
            FacesMessage message;
            if (null != requiredMessageStr) {
                message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                           requiredMessageStr,
                                           requiredMessageStr);
            } else {
                message =
                     MessageFactory.getMessage(context, REQUIRED_MESSAGE_ID,
                          MessageFactory.getLabel(
                               context, this));
            }
            context.addMessage(getClientId(context), message);
            setValid(false);
            context.validationFailed();
            context.renderResponse();
        }
        else {
            super.processValidators(context);
        }
    }

    /**
     * <p class="changed_added_2_0">Call through to superclass {@link
     * UIInput#updateModel} then take the additional action of pushing
     * the value into request scope if and only if the value is not a
     * value expression, is valid, and the local value was set on this
     * lifecycle execution.</p>
     * @since 2.0
     */

    @Override
    public void updateModel(FacesContext context) {
        super.updateModel(context);
        if (!hasValueExpression() && isValid() && isLocalValueSet()) {
            // QUESTION should this be done even when a value expression is present?
            // ANSWER: I don't see why not.
            context.getExternalContext().getRequestMap().put(getName(), getLocalValue());
        }
    }

    // This is called during the real "Render Response" phase

    /**
     * <p class="changed_added_2_0">Called specially by {@link
     * UIViewRoot#encodeEnd}, this method simply sets the submitted
     * value to be the return from {@link #getStringValue}.</p>
     * @since 2.0
     */
    @Override
    public void encodeAll(FacesContext context) throws IOException {
        if (context == null) {
            throw new NullPointerException();
        }

        // if there is a value expression, update view parameter w/ latest value after render
        // QUESTION is it okay that a null string value may be suppressing the view parameter value?
        // ANSWER: I'm not sure.
        setSubmittedValue(getStringValue(context));
    }

    /**
     * <p class="changed_added_2_0">If the value of this parameter comes
     * from a <code>ValueExpression</code> return the value of the
     * expression, otherwise, return the local value.</p>
     *
     * @since 2.0
     */

    public String getStringValue(FacesContext context) {
        String result = null;
        if (hasValueExpression()) {
            result = getStringValueFromModel(context);
        } else {
            result = (null != rawValue) ? rawValue : (String) getValue();
        }
        return result;
    }

    /**
     * <p class="changed_added_2_0">Manually perform standard conversion
     * steps to get a string value from the value expression.</p>
     *
     * @since 2.0
     */

    public String getStringValueFromModel(FacesContext context)
        throws ConverterException {
        ValueExpression ve = getValueExpression("value");
        if (ve == null) {
            return null;
        }

        Object currentValue = ve.getValue(context.getELContext());

        // If there is a converter attribute, use it to to ask application
        // instance for a converter with this identifer.
        Converter c = getConverter();

        if (c == null) {
            // if value is null and no converter attribute is specified, then
            // return null (null has meaning for a view parameters; it means remove it).
            if (currentValue == null) {
                return null;
            }
            // Do not look for "by-type" converters for Strings
            if (currentValue instanceof String) {
                return (String) currentValue;
            }

            // if converter attribute set, try to acquire a converter
            // using its class type.

            Class converterType = currentValue.getClass();
            c = context.getApplication().createConverter(converterType);

            // if there is no default converter available for this identifier,
            // assume the model type to be String.
            if (c == null) {
                return currentValue.toString();
            }
        }

        return c.getAsString(context, this, currentValue);
    }

    /**
     * <p class="changed_added_2_0">Because this class has no {@link
     * Renderer}, leverage the one from the standard HTML_BASIC {@link
     * RenderKit} with <code>component-family: javax.faces.Input</code>
     * and <code>renderer-type: javax.faces.Text</code> and call its
     * {@link Renderer#getConvertedValue} method.</p>
     *
     * @since 2.0
     */ 
    @Override
    protected Object getConvertedValue(FacesContext context, Object submittedValue)
          throws ConverterException {

        return getInputTextRenderer(context).getConvertedValue(context, this, 
                submittedValue);

    }
    
    private Renderer getInputTextRenderer(FacesContext context) {
        if (null == inputTextRenderer) {
            RenderKitFactory rkf = (RenderKitFactory) 
                    FactoryFinder.getFactory(FactoryFinder.RENDER_KIT_FACTORY);
            RenderKit standard = rkf.getRenderKit(context, RenderKitFactory.HTML_BASIC_RENDER_KIT);
            inputTextRenderer = standard.
                    getRenderer("javax.faces.Input", "javax.faces.Text");
        }
        assert(null != inputTextRenderer);
        return inputTextRenderer;
    }

    // ----------------------------------------------------- Helper Methods

    private boolean hasValueExpression() {
        return null != getValueExpression("value");
    }

    
    /**
     * <p class="changed_added_2_0">Inner class to encapsulate a
     * <code>UIViewParameter</code> instance so that it may be safely
     * referenced regardless of whether or not the current view is the
     * same as the view in which this <code>UIViewParameter</code>
     * resides.</p>
     * @since 2.0
     */
    
    public static class Reference {
        
        private StateHolderSaver saver;
        private int indexInParent;
        private String viewIdAtTimeOfConstruction;
        
	/**
	 * <p class="changed_added_2_0">Construct a reference to a
	 * <code>UIViewParameter</code>.  This constructor cause the
	 * {@link StateHolder#saveState} method to be called on
	 * argument <code>UIViewParameter</code>.</p>
	 *
	 * @param context the <code>FacesContext</code>for this request
	 * @param indexInParent the index of the
	 * <code>UIViewParameter</code> in its parent
	 * <code>UIPanel</code>.
	 * @param viewIdAtTimeOfConstruction the viewId of the view in
	 * which the <code>UIViewParameter</code> is included.  This may
	 * not be the same as the viewId from the <code>context</code>
	 * argument.
	 *
	 * @since 2.0
	 */
        public Reference(FacesContext context, 
                UIViewParameter param, 
                int indexInParent,
                String viewIdAtTimeOfConstruction)     {
            this.saver = new StateHolderSaver(context, param);
            this.indexInParent = indexInParent;
            this.viewIdAtTimeOfConstruction = viewIdAtTimeOfConstruction;
        }

	/**
	 * <p class="changed_added_2_0">Return the
	 * <code>UIViewParameter</code> to which this instance refers.
	 * If the current viewId is the same as the viewId passed to our
	 * constructor, use the index passed to the constructor to find
	 * the actual <code>UIViewParameter</code> instance and return
	 * it.  Otherwise, call {@link StateHolder#restoreState} on the
	 * saved state and return the result.</p>
	 *
	 * @param context the <code>FacesContext</code>for this request
	 *
	 * @since 2.0
	 */
        
        public UIViewParameter getUIViewParameter(FacesContext context) {
            UIViewParameter result = null;
            UIViewRoot root = context.getViewRoot();
            // If the view root is the same as when we were constructed...
            if (this.viewIdAtTimeOfConstruction.equals(root.getViewId())) {
                // get the actual view parameter from the tree...
                UIComponent metadataFacet = root.getFacet(UIViewRoot.METADATA_FACET_NAME);
                result = (UIViewParameter) metadataFacet.getChildren().get(indexInParent);
            } else {
                // otherwise, use the saved one
                result = (UIViewParameter) this.saver.restore(context);
            }
            
            return result;
        }
        
    }

}
