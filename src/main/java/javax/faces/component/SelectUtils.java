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

import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.el.ExpressionFactory;
import javax.el.ELException;

/**
 * Contains common utility methods used by both {@link UISelectOne} and {@link
 * UISelectMany}.
 */
class SelectUtils {


    // ------------------------------------------------------------ Constructors

    
    private SelectUtils() { }


    // ------------------------------------------------- Package Private Methods

    /**
     * <p>Return <code>true</code> if the specified value matches one of the
     * available options, performing a recursive search if if a {@link
     * javax.faces.model.SelectItemGroup} instance is detected.</p>
     *
     * @param ctx          {@link FacesContext} for the current request
     * @param value        {@link UIComponent} value to be tested
     * @param items        Iterator over the {@link javax.faces.model.SelectItem}s
     *                     to be checked
     * @param converter    the {@link Converter} associated with this component
     */
    static boolean matchValue(FacesContext ctx,
                              UIComponent component,
                              Object value,
                              Iterator<SelectItem> items,
                              Converter converter) {

        while (items.hasNext()) {
            SelectItem item = items.next();
            if (item instanceof SelectItemGroup) {
                SelectItem subitems[] =
                      ((SelectItemGroup) item).getSelectItems();
                if ((subitems != null) && (subitems.length > 0)) {
                    if (matchValue(ctx, component, value, new ArrayIterator(subitems), converter)) {
                        return (true);
                    }
                }
            } else {
                Object compareValue = null;
                
                try {
                    compareValue = doConversion(ctx, component, item, value,
                        converter);
                } catch (IllegalStateException ise) {
                    continue;
                }
                
                if (null == compareValue && null == value) {
                    return true;
                }

                if (value.equals(compareValue)) {
                    return (true);
                }
            }
        }
        return (false);

    }
    
    /**
     * Returns true iff component has a {@link UISelectItem} child
     * whose itemValue exactly matches the argument value
     * @param ctx
     * @param component
     * @param value
     * @param items
     * @return
     */
    
    static boolean valueIsNoSelectionOption(FacesContext ctx,
            UIComponent component,
            Object value,
            Iterator<SelectItem> items,
            Converter converter) {
        boolean result = false;
        
        while (items.hasNext()) {
            SelectItem item = items.next();
            if (item instanceof SelectItemGroup) {
                SelectItem subitems[] =
                      ((SelectItemGroup) item).getSelectItems();
                if ((subitems != null) && (subitems.length > 0)) {
                    if (valueIsNoSelectionOption(ctx, component, value, new ArrayIterator(subitems), converter)) {
                        result = true;
                        break;
                    }
                }
            } else {
                Object compareValue = null;
                
                try {
                    compareValue = doConversion(ctx, component, item, value,
                        converter);
                } catch (IllegalStateException ise) {
                    continue;
                }
                
                if (null == compareValue && null == value &&
                    item.isNoSelectionOption()) {
                    result = true;
                    break;
                } else if (value.equals(compareValue) && item.isNoSelectionOption()) {
                    result = true;
                    break;
                }
            }
            
        }
        
        return result;
    }
    
    private static Object doConversion(FacesContext ctx, 
            UIComponent component, SelectItem item, 
            Object value, Converter converter) throws IllegalStateException {
        Object itemValue = item.getValue();
        if (itemValue == null && value == null) {
            return (null);
        }
        if ((value == null) ^ (itemValue == null)) {
            throw new IllegalStateException("Either value was null, or itemValue was null, but not both.");
        }
        Object compareValue;
        if (converter == null) {
            compareValue =
                    coerceToModelType(ctx, itemValue, value.getClass());
        } else {
            compareValue = itemValue;
            if (compareValue instanceof String
                 && !(value instanceof String)) {
                // type mismatch between the time and the value we're
                // comparing.  Invoke the Converter.
                compareValue = converter.getAsObject(ctx,
                        component,
                        (String) compareValue);
            }
        }

        return compareValue;
    }


    /**
     * Coerce the provided value to the specified type using EL coercion.
     *
     * @param ctx the {@link FacesContext} for the current request
     * @param value the value to coerce
     * @param toType the type <code>value</code> should be coerced to
     *
     * @return the result of the EL coersion
     *
     * @see ExpressionFactory#coerceToType(Object, Class)
     */
    private static Object coerceToModelType(FacesContext ctx,
                                            Object value,
                                            Class toType) {

        Object newValue;
        try {
            ExpressionFactory ef = ctx.getApplication().getExpressionFactory();
            newValue = ef.coerceToType(value, toType);
        } catch (ELException ele) {
            newValue = value;
        } catch (IllegalArgumentException iae) {
            // If coerceToType fails, per the docs it should throw
            // an ELException, however, GF 9.0 and 9.0u1 will throw
            // an IllegalArgumentException instead (see GF issue 1527).
            newValue = value;
        }

        return newValue;

    }


    // ---------------------------------------------------------- Nested Classes


    /**
     * Exposes an Array via an <code>Iterator</code>
     */
    static class ArrayIterator implements Iterator {

        public ArrayIterator(Object items[]) {
            this.items = items;
        }

        private Object items[];
        private int index = 0;

        public boolean hasNext() {
            return (index < items.length);
        }

        public Object next() {
            try {
                return (items[index++]);
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

    } // END ArrayIterator

}
