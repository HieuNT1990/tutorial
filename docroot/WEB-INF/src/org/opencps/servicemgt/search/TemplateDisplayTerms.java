/**
 * OpenCPS is the open source Core Public Services software Copyright (C)
 * 2016-present OpenCPS community This program is free software: you can
 * redistribute it and/or modify it under the terms of the GNU Affero General
 * Public License as published by the Free Software Foundation, either version 3
 * of the License, or any later version. This program is distributed in the hope
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Affero General Public License for more details. You should have received a
 * copy of the GNU Affero General Public License along with this program. If
 * not, see <http://www.gnu.org/licenses/>
 */

package org.opencps.servicemgt.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * @author khoavd
 */
public class TemplateDisplayTerms extends DisplayTerms {

	/**
	 * @param request
	 */
	public static final String TEMPLATE_ID = "templatefileId";
	protected long templateFileId;
	public TemplateDisplayTerms(PortletRequest request) {

		super(request);
		templateFileId = ParamUtil.getLong(request, TEMPLATE_ID);
		
	}
	public long getTemplateFileId() {
		return templateFileId;
	}
	public void setTemplateFileId(long templateFileId) {
		this.templateFileId = templateFileId;
	}
	public static String getTemplateId() {
		return TEMPLATE_ID;
	}

}
