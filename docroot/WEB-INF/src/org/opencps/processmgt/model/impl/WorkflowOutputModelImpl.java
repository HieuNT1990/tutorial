/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.opencps.processmgt.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import org.opencps.processmgt.model.WorkflowOutput;
import org.opencps.processmgt.model.WorkflowOutputModel;
import org.opencps.processmgt.model.WorkflowOutputSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the WorkflowOutput service. Represents a row in the &quot;opencps_workflowoutput&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.opencps.processmgt.model.WorkflowOutputModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link WorkflowOutputImpl}.
 * </p>
 *
 * @author khoavd
 * @see WorkflowOutputImpl
 * @see org.opencps.processmgt.model.WorkflowOutput
 * @see org.opencps.processmgt.model.WorkflowOutputModel
 * @generated
 */
@JSON(strict = true)
public class WorkflowOutputModelImpl extends BaseModelImpl<WorkflowOutput>
	implements WorkflowOutputModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a workflow output model instance should use the {@link org.opencps.processmgt.model.WorkflowOutput} interface instead.
	 */
	public static final String TABLE_NAME = "opencps_workflowoutput";
	public static final Object[][] TABLE_COLUMNS = {
			{ "workflowOutputId", Types.BIGINT },
			{ "processWorkflowId", Types.BIGINT },
			{ "dossierPartId", Types.BIGINT },
			{ "required", Types.BOOLEAN },
			{ "esign", Types.BOOLEAN },
			{ "postback", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table opencps_workflowoutput (workflowOutputId LONG not null primary key,processWorkflowId LONG,dossierPartId LONG,required BOOLEAN,esign BOOLEAN,postback BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table opencps_workflowoutput";
	public static final String ORDER_BY_JPQL = " ORDER BY workflowOutput.workflowOutputId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY opencps_workflowoutput.workflowOutputId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.opencps.processmgt.model.WorkflowOutput"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.opencps.processmgt.model.WorkflowOutput"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.opencps.processmgt.model.WorkflowOutput"),
			true);
	public static long PROCESSWORKFLOWID_COLUMN_BITMASK = 1L;
	public static long WORKFLOWOUTPUTID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static WorkflowOutput toModel(WorkflowOutputSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		WorkflowOutput model = new WorkflowOutputImpl();

		model.setWorkflowOutputId(soapModel.getWorkflowOutputId());
		model.setProcessWorkflowId(soapModel.getProcessWorkflowId());
		model.setDossierPartId(soapModel.getDossierPartId());
		model.setRequired(soapModel.getRequired());
		model.setEsign(soapModel.getEsign());
		model.setPostback(soapModel.getPostback());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<WorkflowOutput> toModels(WorkflowOutputSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<WorkflowOutput> models = new ArrayList<WorkflowOutput>(soapModels.length);

		for (WorkflowOutputSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.opencps.processmgt.model.WorkflowOutput"));

	public WorkflowOutputModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _workflowOutputId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setWorkflowOutputId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _workflowOutputId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return WorkflowOutput.class;
	}

	@Override
	public String getModelClassName() {
		return WorkflowOutput.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("workflowOutputId", getWorkflowOutputId());
		attributes.put("processWorkflowId", getProcessWorkflowId());
		attributes.put("dossierPartId", getDossierPartId());
		attributes.put("required", getRequired());
		attributes.put("esign", getEsign());
		attributes.put("postback", getPostback());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long workflowOutputId = (Long)attributes.get("workflowOutputId");

		if (workflowOutputId != null) {
			setWorkflowOutputId(workflowOutputId);
		}

		Long processWorkflowId = (Long)attributes.get("processWorkflowId");

		if (processWorkflowId != null) {
			setProcessWorkflowId(processWorkflowId);
		}

		Long dossierPartId = (Long)attributes.get("dossierPartId");

		if (dossierPartId != null) {
			setDossierPartId(dossierPartId);
		}

		Boolean required = (Boolean)attributes.get("required");

		if (required != null) {
			setRequired(required);
		}

		Boolean esign = (Boolean)attributes.get("esign");

		if (esign != null) {
			setEsign(esign);
		}

		Boolean postback = (Boolean)attributes.get("postback");

		if (postback != null) {
			setPostback(postback);
		}
	}

	@JSON
	@Override
	public long getWorkflowOutputId() {
		return _workflowOutputId;
	}

	@Override
	public void setWorkflowOutputId(long workflowOutputId) {
		_workflowOutputId = workflowOutputId;
	}

	@JSON
	@Override
	public long getProcessWorkflowId() {
		return _processWorkflowId;
	}

	@Override
	public void setProcessWorkflowId(long processWorkflowId) {
		_columnBitmask |= PROCESSWORKFLOWID_COLUMN_BITMASK;

		if (!_setOriginalProcessWorkflowId) {
			_setOriginalProcessWorkflowId = true;

			_originalProcessWorkflowId = _processWorkflowId;
		}

		_processWorkflowId = processWorkflowId;
	}

	public long getOriginalProcessWorkflowId() {
		return _originalProcessWorkflowId;
	}

	@JSON
	@Override
	public long getDossierPartId() {
		return _dossierPartId;
	}

	@Override
	public void setDossierPartId(long dossierPartId) {
		_dossierPartId = dossierPartId;
	}

	@JSON
	@Override
	public boolean getRequired() {
		return _required;
	}

	@Override
	public boolean isRequired() {
		return _required;
	}

	@Override
	public void setRequired(boolean required) {
		_required = required;
	}

	@JSON
	@Override
	public boolean getEsign() {
		return _esign;
	}

	@Override
	public boolean isEsign() {
		return _esign;
	}

	@Override
	public void setEsign(boolean esign) {
		_esign = esign;
	}

	@JSON
	@Override
	public boolean getPostback() {
		return _postback;
	}

	@Override
	public boolean isPostback() {
		return _postback;
	}

	@Override
	public void setPostback(boolean postback) {
		_postback = postback;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			WorkflowOutput.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public WorkflowOutput toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (WorkflowOutput)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		WorkflowOutputImpl workflowOutputImpl = new WorkflowOutputImpl();

		workflowOutputImpl.setWorkflowOutputId(getWorkflowOutputId());
		workflowOutputImpl.setProcessWorkflowId(getProcessWorkflowId());
		workflowOutputImpl.setDossierPartId(getDossierPartId());
		workflowOutputImpl.setRequired(getRequired());
		workflowOutputImpl.setEsign(getEsign());
		workflowOutputImpl.setPostback(getPostback());

		workflowOutputImpl.resetOriginalValues();

		return workflowOutputImpl;
	}

	@Override
	public int compareTo(WorkflowOutput workflowOutput) {
		long primaryKey = workflowOutput.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WorkflowOutput)) {
			return false;
		}

		WorkflowOutput workflowOutput = (WorkflowOutput)obj;

		long primaryKey = workflowOutput.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		WorkflowOutputModelImpl workflowOutputModelImpl = this;

		workflowOutputModelImpl._originalProcessWorkflowId = workflowOutputModelImpl._processWorkflowId;

		workflowOutputModelImpl._setOriginalProcessWorkflowId = false;

		workflowOutputModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<WorkflowOutput> toCacheModel() {
		WorkflowOutputCacheModel workflowOutputCacheModel = new WorkflowOutputCacheModel();

		workflowOutputCacheModel.workflowOutputId = getWorkflowOutputId();

		workflowOutputCacheModel.processWorkflowId = getProcessWorkflowId();

		workflowOutputCacheModel.dossierPartId = getDossierPartId();

		workflowOutputCacheModel.required = getRequired();

		workflowOutputCacheModel.esign = getEsign();

		workflowOutputCacheModel.postback = getPostback();

		return workflowOutputCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{workflowOutputId=");
		sb.append(getWorkflowOutputId());
		sb.append(", processWorkflowId=");
		sb.append(getProcessWorkflowId());
		sb.append(", dossierPartId=");
		sb.append(getDossierPartId());
		sb.append(", required=");
		sb.append(getRequired());
		sb.append(", esign=");
		sb.append(getEsign());
		sb.append(", postback=");
		sb.append(getPostback());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("org.opencps.processmgt.model.WorkflowOutput");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>workflowOutputId</column-name><column-value><![CDATA[");
		sb.append(getWorkflowOutputId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processWorkflowId</column-name><column-value><![CDATA[");
		sb.append(getProcessWorkflowId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierPartId</column-name><column-value><![CDATA[");
		sb.append(getDossierPartId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>required</column-name><column-value><![CDATA[");
		sb.append(getRequired());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esign</column-name><column-value><![CDATA[");
		sb.append(getEsign());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>postback</column-name><column-value><![CDATA[");
		sb.append(getPostback());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = WorkflowOutput.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			WorkflowOutput.class
		};
	private long _workflowOutputId;
	private long _processWorkflowId;
	private long _originalProcessWorkflowId;
	private boolean _setOriginalProcessWorkflowId;
	private long _dossierPartId;
	private boolean _required;
	private boolean _esign;
	private boolean _postback;
	private long _columnBitmask;
	private WorkflowOutput _escapedModel;
}