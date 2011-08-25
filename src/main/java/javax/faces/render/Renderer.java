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

package javax.faces.render;


import java.io.IOException;
import java.util.Iterator;
import javax.faces.component.UIComponent;
import javax.faces.convert.ConverterException;
import javax.faces.context.FacesContext;


/**
 * <p>A <strong class="changed_modified_2_0">Renderer</strong> converts
 * the internal representation of {@link UIComponent}s into the output
 * stream (or writer) associated with the response we are creating for a
 * particular request.  Each <code>Renderer</code> knows how to render
 * one or more {@link UIComponent} types (or classes), and advertises a
 * set of render-dependent attributes that it recognizes for each
 * supported {@link UIComponent}.</p>
 *
 * <p>Families of {@link Renderer}s are packaged as a {@link RenderKit},
 * and together support the rendering of all of the {@link UIComponent}s
 * in a view associated with a {@link FacesContext}.  Within the set of
 * {@link Renderer}s for a particular {@link RenderKit}, each must be
 * uniquely identified by the <code>rendererType</code> property.</p>
 *
 * <p>Individual {@link Renderer} instances will be instantiated as requested
 * during the rendering process, and will remain in existence for the
 * remainder of the lifetime of a web application.  Because each instance
 * may be invoked from more than one request processing thread simultaneously,
 * they MUST be programmed in a thread-safe manner.</p>
 *
 * <div class="changed_added_2_0">

 * <p>If the {@link javax.faces.event.ListenerFor} annotation is
 * attached to the class definition of a <code>Renderer</code>, that
 * class must also implement {@link
 * javax.faces.event.ComponentSystemEventListener}, and the action
 * pertaining to the processing of <code>ResourceDependency</code> on a
 * <code>Renderer</code> described in {@link
 * javax.faces.event.ListenerFor} must be taken. </p>

 * <p>If the {@link javax.faces.application.ResourceDependency}
 * annotation is attached to the class definition of a
 * <code>Renderer</code>, the action pertaining to the processing of
 * <code>ResourceDependency</code> on a <code>Renderer</code> described
 * in {@link UIComponent#getChildren} must be taken. </p>

 * </div>
 */

public abstract class Renderer {
    
    
    // ------------------------------------------------------ Rendering Methods


    /**
     * <p>Decode any new state of the specified {@link UIComponent}
     * from the request contained in the specified {@link FacesContext},
     * and store that state on the {@link UIComponent}.</p>
     *
     * <p>During decoding, events may be enqueued for later processing
     * (by event listeners that have registered an interest), by calling
     * <code>queueEvent()</code> on the associated {@link UIComponent}.
     * </p>
     *
     * @param context {@link FacesContext} for the request we are processing
     * @param component {@link UIComponent} to be decoded.
     *
     * @throws NullPointerException if <code>context</code>
     *  or <code>component</code> is <code>null</code>
     */
    public void decode(FacesContext context, UIComponent component) {
	if (null == context || null == component) {
	    throw new NullPointerException();
	}
    }


    /**
     * <p>Render the beginning specified {@link UIComponent} to the
     * output stream or writer associated with the response we are creating.
     * If the conversion attempted in a previous call to
     * <code>getConvertedValue()</code> for this component failed, the state
     * information saved during execution
     * of <code>decode()</code> should be used to reproduce the incorrect
     * input.</p>
     *
     * @param context {@link FacesContext} for the request we are processing
     * @param component {@link UIComponent} to be rendered
     *
     * @throws IOException if an input/output error occurs while rendering
     * @throws NullPointerException if <code>context</code>
     *  or <code>component</code> is null
     */
    public void encodeBegin(FacesContext context,
			    UIComponent component)
        throws IOException {
	if (null == context || null == component) {
	    throw new NullPointerException();
	}
    }


    /**
     * <p>Render the child components of this {@link UIComponent}, following
     * the rules described for <code>encodeBegin()</code> to acquire the
     * appropriate value to be rendered.  This method will only be called
     * if the <code>rendersChildren</code> property of this component
     * is <code>true</code>.</p>
     *
     * @param context {@link FacesContext} for the response we are creating
     * @param component {@link UIComponent} whose children are to be rendered
     *
     * @throws IOException if an input/output error occurs while rendering
     * @throws NullPointerException if <code>context</code>
     *  or <code>component</code> is <code>null</code>
     */
    public void encodeChildren(FacesContext context, UIComponent component)
        throws IOException {
        if (context == null || component == null) {
            throw new NullPointerException();
        }
        if (component.getChildCount() > 0) {
        	Iterator<UIComponent> kids = component.getChildren().iterator();
        	while (kids.hasNext()) {
        	    UIComponent kid = kids.next();
        	    kid.encodeAll(context);
        	}
        }
    }


    /**
     * <p>Render the ending of the current state of the specified
     * {@link UIComponent}, following the rules described for
     * <code>encodeBegin()</code> to acquire the appropriate value
     * to be rendered.</p>
     *
     * @param context {@link FacesContext} for the response we are creating
     * @param component {@link UIComponent} to be rendered
     *
     * @throws IOException if an input/output error occurs while rendering
     * @throws NullPointerException if <code>context</code>
     *  or <code>component</code> is <code>null</code>
     */
    public void encodeEnd(FacesContext context,
			  UIComponent component)
        throws IOException {
	if (null == context || null == component) {
	    throw new NullPointerException();
	}
    }

    /**
     * <p>Convert the component generated client id to a form suitable
     * for transmission to the client.</p>
     *
     * <p>The default implementation returns the argument
     * <code>clientId</code> unchanged.</p>
     *
     * @param context {@link FacesContext} for the current request
     * @param clientId the client identifier to be converted to client a
     * specific format.
     *
     * @throws NullPointerException if <code>context</code>
     *  or <code>clientId</code> is <code>null</code>
     */ 
    public String convertClientId(FacesContext context, String clientId) {

        if ((context == null) || (clientId == null)) {
            throw new NullPointerException();
        }
        return (clientId);

    }

    /**
     * <p>Return a flag indicating whether this {@link Renderer} is responsible
     * for rendering the children the component it is asked to render.
     * The default implementation returns <code>false</code>.</p>
     */

    public boolean getRendersChildren() {
	return false;
    }


    /**
     * <p>Attempt to convert previously stored state information into an
     * object of the type required for this component (optionally using the
     * registered {@link javax.faces.convert.Converter} for this component,
     * if there is one).  If conversion is successful, the new value
     * should be returned from this method;  if not, a
     * {@link ConverterException} should be thrown.</p>
     * 
     * @param context {@link FacesContext} for the request we are processing
     * @param component {@link UIComponent} to be decoded.
     * @param submittedValue a value stored on the component during
     *    <code>decode</code>.
     * 
     * @throws ConverterException if the submitted value
     *   cannot be converted successfully.
     * @throws NullPointerException if <code>context</code>
     *  or <code>component</code> is <code>null</code>
     */
    public Object getConvertedValue(FacesContext context,
                                    UIComponent  component,
                                    Object       submittedValue)
        throws ConverterException {
        if ((context == null) || (component == null)) {
            throw new NullPointerException();
        }
        return submittedValue;
    }
}
