/*
 * File   : $Source: /alkacon/cvs/opencms/src-modules/org/opencms/ade/sitemap/client/ui/Attic/CmsPage.java,v $
 * Date   : $Date: 2010/03/31 12:19:02 $
 * Version: $Revision: 1.2 $
 *
 * This library is part of OpenCms -
 * the Open Source Content Management System
 *
 * Copyright (C) 2002 - 2009 Alkacon Software (http://www.alkacon.com)
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * For further information about Alkacon Software, please see the
 * company website: http://www.alkacon.com
 *
 * For further information about OpenCms, please see the
 * project website: http://www.opencms.org
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package org.opencms.ade.sitemap.client.ui;

import org.opencms.ade.sitemap.client.ui.css.I_CmsLayoutBundle;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Provides a place holder for the tool-bar.<p>
 * 
 * @author Michael Moossen
 * 
 * @version $Revision: 1.2 $
 * 
 * @since 8.0.0
 */
public class CmsPage extends Composite {

    /**
     * @see com.google.gwt.uibinder.client.UiBinder
     */
    protected interface I_CmsPageUiBinder extends UiBinder<Widget, CmsPage> {
        // GWT interface, nothing to do here
    }

    /** The ui-binder instance for this class. */
    private static I_CmsPageUiBinder uiBinder = GWT.create(I_CmsPageUiBinder.class);

    /** DIV to hold the page elements. */
    @UiField
    protected HTMLPanel m_panel;

    /** The panel id. */
    private String m_id;

    /**
     * Constructor.<p>
     */
    public CmsPage() {

        I_CmsLayoutBundle.INSTANCE.pageCss().ensureInjected();
        initWidget(uiBinder.createAndBindUi(this));
    }

    /**
     * Delegate method.<p>
     * 
     * @param w the widget to add
     * 
     * @see com.google.gwt.user.client.ui.HTMLPanel#add(com.google.gwt.user.client.ui.Widget)
     */
    public void add(Widget w) {

        m_panel.add(w, ensureId());
    }

    /**
     * Delegate method.<p>
     * 
     * @see com.google.gwt.user.client.ui.HTMLPanel#clear()
     */
    public void clear() {

        m_panel.clear();
    }

    /**
     * Delegate method.<p>
     * 
     * @param w the widget to remove
     * 
     * @return <code>true</code> if removed
     * 
     * @see com.google.gwt.user.client.ui.ComplexPanel#remove(com.google.gwt.user.client.ui.Widget)
     */
    public boolean remove(Widget w) {

        return m_panel.remove(w);
    }

    /**
     * Returns this panel's unique id.<p>
     * 
     * @return this panel's unique id
     */
    protected String ensureId() {

        if (m_id == null) {
            m_id = HTMLPanel.createUniqueId();
            m_panel.getElement().setId(m_id);
        }
        return m_id;
    }
}