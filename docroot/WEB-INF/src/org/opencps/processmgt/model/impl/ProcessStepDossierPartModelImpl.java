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

import org.opencps.processmgt.model.ProcessStepDossierPart;
import org.opencps.processmgt.model.ProcessStepDossierPartModel;
import org.opencps.processmgt.model.ProcessStepDossierPartSoap;
import org.opencps.processmgt.service.persistence.ProcessStepDossierPartPK;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ProcessStepDossierPart service. Represents a row in the &quot;opencps_processstep_dossierpart&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.opencps.processmgt.model.ProcessStepDossierPartModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProcessStepDossierPartImpl}.
 * </p>
 *
 * @author khoavd
 * @see ProcessStepDossierPartImpl
 * @see org.opencps.processmgt.model.ProcessStepDossierPart
 * @see org.opencps.processmgt.model.ProcessStepDossierPartModel
 * @generated
 */
@JSON(strict = true)
public class ProcessStepDossierPartModelImpl extends BaseModelImpl<ProcessStepDossierPart>
	implements ProcessStepDossierPartModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a process step dossier part model instance should use the {@link org.opencps.processmgt.model.ProcessStepDossierPart} interface instead.
	 */
	public static final String TABLE_NAME = "opencps_processstep_dossierpart";
	public static final Object[][] TABLE_COLUMNS = {
			{ "processStepId", Types.BIGINT },
			{ "dossierPartId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table opencps_processstep_dossierpart (processStepId LONG not null,dossierPartId LONG not null,primary key (processStepId, dossierPartId))";
	public static final String TABLE_SQL_DROP = "drop table opencps_processstep_dossierpart";
	public static final String ORDER_BY_JPQL = " ORDER BY processStepDossierPart.id.processStepId ASC, processStepDossierPart.id.dossierPartId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY opencps_processstep_dossierpart.processStepId ASC, opencps_processstep_dossierpart.dossierPartId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.opencps.processmgt.model.ProcessStepDossierPart"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.opencps.processmgt.model.ProcessStepDossierPart"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.opencps.processmgt.model.ProcessStepDossierPart"),
			true);
	public static long PROCESSSTEPID_COLUMN_BITMASK = 1L;
	public static long DOSSIERPARTID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ProcessStepDossierPart toModel(
		ProcessStepDossierPartSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ProcessStepDossierPart model = new ProcessStepDossierPartImpl();

		model.setProcessStepId(soapModel.getProcessStepId());
		model.setDossierPartId(soapModel.getDossierPartId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ProcessStepDossierPart> toModels(
		ProcessStepDossierPartSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ProcessStepDossierPart> models = new ArrayList<ProcessStepDossierPart>(soapModels.length);

		for (ProcessStepDossierPartSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.opencps.processmgt.model.ProcessStepDossierPart"));

	public ProcessStepDossierPartModelImpl() {
	}

	@Override
	public ProcessStepDossierPartPK getPrimaryKey() {
		return new ProcessStepDossierPartPK(_processStepId, _dossierPartId);
	}

	@Override
	public void setPrimaryKey(ProcessStepDossierPartPK primaryKey) {
		setProcessStepId(primaryKey.processStepId);
		setDossierPartId(primaryKey.dossierPartId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ProcessStepDossierPartPK(_processStepId, _dossierPartId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ProcessStepDossierPartPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return ProcessStepDossierPart.class;
	}

	@Override
	public String getModelClassName() {
		return ProcessStepDossierPart.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("processStepId", getProcessStepId());
		attributes.put("dossierPartId", getDossierPartId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long processStepId = (Long)attributes.get("processStepId");

		if (processStepId != null) {
			setProcessStepId(processStepId);
		}

		Long dossierPartId = (Long)attributes.get("dossierPartId");

		if (dossierPartId != null) {
			setDossierPartId(dossierPartId);
		}
	}

	@JSON
	@Override
	public long getProcessStepId() {
		return _processStepId;
	}

	@Override
	public void setProcessStepId(long processStepId) {
		_columnBitmask |= PROCESSSTEPID_COLUMN_BITMASK;

		if (!_setOriginalProcessStepId) {
			_setOriginalProcessStepId = true;

			_originalProcessStepId = _processStepId;
		}

		_processStepId = processStepId;
	}

	public long getOriginalProcessStepId() {
		return _originalProcessStepId;
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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ProcessStepDossierPart toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ProcessStepDossierPart)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ProcessStepDossierPartImpl processStepDossierPartImpl = new ProcessStepDossierPartImpl();

		processStepDossierPartImpl.setProcessStepId(getProcessStepId());
		processStepDossierPartImpl.setDossierPartId(getDossierPartId());

		processStepDossierPartImpl.resetOriginalValues();

		return processStepDossierPartImpl;
	}

	@Override
	public int compareTo(ProcessStepDossierPart processStepDossierPart) {
		ProcessStepDossierPartPK primaryKey = processStepDossierPart.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProcessStepDossierPart)) {
			return false;
		}

		ProcessStepDossierPart processStepDossierPart = (ProcessStepDossierPart)obj;

		ProcessStepDossierPartPK primaryKey = processStepDossierPart.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public void resetOriginalValues() {
		ProcessStepDossierPartModelImpl processStepDossierPartModelImpl = this;

		processStepDossierPartModelImpl._originalProcessStepId = processStepDossierPartModelImpl._processStepId;

		processStepDossierPartModelImpl._setOriginalProcessStepId = false;

		processStepDossierPartModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ProcessStepDossierPart> toCacheModel() {
		ProcessStepDossierPartCacheModel processStepDossierPartCacheModel = new ProcessStepDossierPartCacheModel();

		processStepDossierPartCacheModel.processStepId = getProcessStepId();

		processStepDossierPartCacheModel.dossierPartId = getDossierPartId();

		return processStepDossierPartCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{processStepId=");
		sb.append(getProcessStepId());
		sb.append(", dossierPartId=");
		sb.append(getDossierPartId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("org.opencps.processmgt.model.ProcessStepDossierPart");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>processStepId</column-name><column-value><![CDATA[");
		sb.append(getProcessStepId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierPartId</column-name><column-value><![CDATA[");
		sb.append(getDossierPartId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ProcessStepDossierPart.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ProcessStepDossierPart.class
		};
	private long _processStepId;
	private long _originalProcessStepId;
	private boolean _setOriginalProcessStepId;
	private long _dossierPartId;
	private long _columnBitmask;
	private ProcessStepDossierPart _escapedModel;
}