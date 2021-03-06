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

/**
 * <p class="changed_added_2_0"><span class="changed_modified_2_2">This</span>
 * component is paired with the
 * <code>javax.faces.Button</code> or <code>javax.faces.Link</code>
 * renderers and encapsulates properties relating to the rendering of
 * outcomes directly to the response.  This enables bookmarkability in
 * JSF applications.</p>
 *
 * @since 2.0
 */
public class UIOutcomeTarget extends UIOutput {


    // ------------------------------------------------------ Manifest Constants


    /**
     * <p>The standard component type for this component.</p>
     */
    public static final String COMPONENT_TYPE = "javax.faces.OutcomeTarget";


    /**
     * <p>The standard component family for this component.</p>
     */
    public static final String COMPONENT_FAMILY = "javax.faces.OutcomeTarget";


    enum PropertyKeys {
        includeViewParams,
        outcome,
        disableClientWindow
    }


    // ------------------------------------------------------------ Constructors


    /**
     * <p>Create a new {@link UIOutcomeTarget} instance with default property
     * values.</p>
     */
    public UIOutcomeTarget() {
        super();
        setRendererType("javax.faces.Link");

    }


    // -------------------------------------------------------------- Properties


    @Override
    public String getFamily() {
        return COMPONENT_FAMILY;
    }

    
    /**
     * <p class="changed_added_2_0">Return whether or not the view
     * parameters should be encoded into the target url.</p>
     *
     * @since 2.0
     */
    public boolean isIncludeViewParams() {

        return (Boolean) getStateHelper().eval(PropertyKeys.includeViewParams, false);

    }

    /**
     * <p class="changed_added_2_0">Set whether or not the page
     * parameters should be encoded into the target url.</p>
     *
     * @param includeViewParams The state of the switch for encoding
     * page parameters
     *
     * @since 2.0
     */
    public void setIncludeViewParams(boolean includeViewParams) {

        getStateHelper().put(PropertyKeys.includeViewParams, includeViewParams);

    }
    
    /**
     * <p class="changed_added_2_2">Return whether or not the client window
     * should be encoded into the target url.</p>
     *
     * @since 2.0
     */
    public boolean isDisableClientWindow() {
        return (Boolean) getStateHelper().eval(PropertyKeys.disableClientWindow, false);
    }
    
    /**
     * <p class="changed_added_2_2">Set whether or not the client window
     * should be encoded into the target url.</p>
     * 
     * @param disableClientWindow if @{code true}, the client window will not be included
     * in this outcome target.
     * 
     * @since 2.2
     */

    public void setDisableClientWindow(boolean disableClientWindow) {
        getStateHelper().put(PropertyKeys.disableClientWindow, disableClientWindow);
    }



    /**
     * <p class="changed_added_2_0">Returns the <code>outcome</code>
     * property of the <code>UIOutcomeTarget</code>. This value is
     * passed to the {@link javax.faces.application.NavigationHandler}
     * when resolving the target url of this component.</p>
     *
     * @since 2.0
     */
    public String getOutcome() {

        return (String) getStateHelper().eval(PropertyKeys.outcome);

    }

    /**
     * <p class="changed_added_2_0">Sets the <code>outcome</code>
     * property of the <code>UIOutcomeTarget</code>.  This value is
     * passed to the NavigationHandler when resolving the target url of
     * this component.</p>
     *
     * @since 2.0
     *
     * @param outcome the navigation outcome
     */
    public void setOutcome(String outcome) {

        getStateHelper().put(PropertyKeys.outcome, outcome);

    }


}
