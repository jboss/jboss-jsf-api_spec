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

package javax.faces.component.behavior;

import java.util.Collection;
import java.util.Collections;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

/**
 * <p class="changed_added_2_0"><strong>ClientBehaviorContext</strong>
 * provides context information that may be useful to 
 * {@link javax.faces.component.behavior.ClientBehavior#getScript}
 * implementations.
 * </p>
 *
 * @since 2.0
 */
public abstract class ClientBehaviorContext {
	
    /**
     * <p class="changed_added_2_0">Creates a ClientBehaviorContext instance.</p>
     *
     * @param context the <code>FacesContext</code> for the current request.
     * @param component the component instance to which the 
     * <code>ClientBehavior</code> is attached.
     * @param eventName the name of the behavior event to which the
     * <code>ClientBehavior</code> is attached.
     * @param sourceId the id to use as the ClientBehavior's "source".
     * @param parameters the collection of parameters for submitting
     * ClientBehaviors to include in the request.
     * @return a <code>ClientBehaviorContext</code> instance configured with the
     * provided values.
     * @throws NullPointerException if <code>context</code>,
     * <code>component</code> or <code>eventName</code>
     *  is <code>null</code>
     *
     * @since 2.0
     */
    public static ClientBehaviorContext createClientBehaviorContext(FacesContext context,
                                                        UIComponent component,
                                                        String eventName,
                                                        String sourceId,
                                                        Collection<ClientBehaviorContext.Parameter> parameters) {

        return new ClientBehaviorContextImpl(context, component, eventName, sourceId, parameters);
    }

    /**
     * <p class="changed_added_2_0">Returns the {@link FacesContext} for 
     * the current request.</p>
     *
     * @since 2.0
     */
    abstract public FacesContext getFacesContext();

    /**
     * <p class="changed_added_2_0">Returns the {@link UIComponent} that is 
     * requesting the {@link ClientBehavior} script.</p>
     *
     * @since 2.0
     */
    abstract public UIComponent getComponent();

    /**
     * <p class="changed_added_2_0">Returns the name of the behavior event 
     * for which the ClientBehavior script is being requested. </p>
     *
     * @since 2.0
     */
    abstract public String getEventName();

    /**
     * <p class="changed_added_2_0">Returns an id for use as the 
     * {@link ClientBehavior} source.  ClientBehavior implementations that submit back 
     * to the Faces lifecycle are required to identify which component 
     * triggered the ClientBehavior-initiated request via the 
     * <code>javax.faces.source</code> request parameter.  In 
     * most cases, th source id can be trivially derived from the element 
     * to which the behavior's client-side script is attached - ie. the 
     * source id is typically the id of this element.  However, in components 
     * which produce more complex content, the behavior script may not be able to
     * determine the correct id to use for the javax.faces.source
     * value.  The {@link ClientBehaviorContext#getSourceId} method allows the component 
     * to pass this information into the {@link ClientBehavior#getScript}
     * implementation.</p>
     *
     * @return the id for the behavior's script to use as the "source", or
     * null if the Behavior's script can identify the source from the DOM.
     *
     * @since 2.0
     */
    abstract public String getSourceId();

    /**
     * <p class="changed_added_2_0">Returns parameters that "submitting" 
     * {@link ClientBehavior} implementations should include when posting back data 
     * into the Faces lifecycle.  If no parameters are specified, this method
     * returns an empty (non-null) collection.</p>
     *
     * @since 2.0
     */
    abstract public Collection<ClientBehaviorContext.Parameter> getParameters();

    // Little static member class that provides a default implementation
    private static final class ClientBehaviorContextImpl extends ClientBehaviorContext {
        private FacesContext context;
        private UIComponent component;
        private String eventName;
        private String sourceId;
        private Collection<ClientBehaviorContext.Parameter> parameters;

        private ClientBehaviorContextImpl(FacesContext context,
                                    UIComponent component,
                                    String eventName,
                                    String sourceId,
                                    Collection<ClientBehaviorContext.Parameter> parameters) {

            if (null == context) {
                throw new NullPointerException();
            }

            if (null == component) {
                throw new NullPointerException();
            }

            if (null == eventName) {
                throw new NullPointerException();
            }

            this.context = context;
            this.component = component;
            this.eventName = eventName;
            this.sourceId = sourceId;

            this.parameters =  (parameters == null) ? 
                                   Collections.<ClientBehaviorContext.Parameter>emptyList() : 
                                   parameters;
        }        

        @Override
        public FacesContext getFacesContext() {
            return context;
        }

        @Override
        public UIComponent getComponent() {
            return component;
        }

        @Override
        public String getEventName() {
            return eventName;
        }

        @Override
        public String getSourceId() {
            return sourceId;
        }

        @Override
        public Collection<ClientBehaviorContext.Parameter> getParameters() {
            return parameters;
        }
    }

    /**
     * <p class="changed_added_2_0"><strong>Parameter</strong> instances
     * represent name/value pairs that "submitting" ClientBehavior implementations
     * should include when posting back into the Faces lifecycle.  ClientBehavior
     * implementations can determine which Parameters to include by calling
     * ClientBehaviorContext.getParameters().
     * </p>
     *
     * @since 2.0
     */
    public static class Parameter {

        private String name;
        private Object value;

        /**
         * <p class="changed_added_2_0">Creates a Parameter instance.</p>
         * @param name the name of the parameter
         * @param value the value of the parameter
         * @throws NullPointerException if <code>name</code>
         * is null.
         *
         * @since 2.0
         */
        public Parameter(String name, Object value) {

            if (null == name) {
                throw new NullPointerException();
            }

            this.name = name;
            this.value = value;
        }

        /**
         * <p class="changed_added_2_0">Returns the Parameter's name.</p>
         *
         * @since 2.0
         */
        public String getName() {
            return name;
        }

        /**
         * <p class="changed_added_2_0">Returns the Parameter's value.</p>
         *
         * @since 2.0
         */
        public Object getValue() {
            return value;
        }
    }
}
