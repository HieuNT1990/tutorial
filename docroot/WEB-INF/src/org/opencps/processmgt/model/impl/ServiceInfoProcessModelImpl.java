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

import org.opencps.processmgt.model.ServiceInfoProcess;
import org.opencps.processmgt.model.ServiceInfoProcessModel;
import org.opencps.processmgt.model.ServiceInfoProcessSoap;
import org.opencps.processmgt.service.persistence.ServiceInfoProcessPK;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ServiceInfoProcess service. Represents a row in the &quot;opencps_serviceinfoprocess&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.opencps.processmgt.model.ServiceInfoProcessModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ServiceInfoProcessImpl}.
 * </p>
 *
 * @author khoavd
 * @see ServiceInfoProcessImpl
 * @see org.opencps.processmgt.model.ServiceInfoProcess
 * @see org.opencps.processmgt.model.ServiceInfoProcessModel
 * @generated
 */
@JSON(strict = true)
public class ServiceInfoProcessModelImpl extends BaseModelImpl<ServiceInfoProcess>
	implements ServiceInfoProcessModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a service info process model instance should use the {@link org.opencps.processmgt.model.ServiceInfoProcess} interface instead.
	 */
	public static final String TABLE_NAME = "opencps_serviceinfoprocess";
	public static final Object[][] TABLE_COLUMNS = {
			{ "serviceProcessId", Types.BIGINT },
			{ "serviceinfoId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table opencps_serviceinfoprocess (serviceProcessId LONG not null,serviceinfoId LONG not null,primary key (serviceProcessId, serviceinfoId))";
	public static final String TABLE_SQL_DROP = "drop table opencps_serviceinfoprocess";
	public static final String ORDER_BY_JPQL = " ORDER BY serviceInfoProcess.id.serviceProcessId ASC, serviceInfoProcess.id.serviceinfoId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY opencps_serviceinfoprocess.serviceProcessId ASC, opencps_serviceinfoprocess.serviceinfoId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.opencps.processmgt.model.ServiceInfoProcess"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.opencps.processmgt.model.ServiceInfoProcess"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.opencps.processmgt.model.ServiceInfoProcess"),
			true);
	public static long SERVICEPROCESSID_COLUMN_BITMASK = 1L;
	public static long SERVICEINFOID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ServiceInfoProcess toModel(ServiceInfoProcessSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ServiceInfoProcess model = new ServiceInfoProcessImpl();

		model.setServiceProcessId(soapModel.getServiceProcessId());
		model.setServiceinfoId(soapModel.getServiceinfoId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ServiceInfoProcess> toModels(
		ServiceInfoProcessSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ServiceInfoProcess> models = new ArrayList<ServiceInfoProcess>(soapModels.length);

		for (ServiceInfoProcessSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.opencps.processmgt.model.ServiceInfoProcess"));

	public ServiceInfoProcessModelImpl() {
	}

	@Override
	public ServiceInfoProcessPK getPrimaryKey() {
		return new ServiceInfoProcessPK(_serviceProcessId, _serviceinfoId);
	}

	@Override
	public void setPrimaryKey(ServiceInfoProcessPK primaryKey) {
		setServiceProcessId(primaryKey.serviceProcessId);
		setServiceinfoId(primaryKey.serviceinfoId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ServiceInfoProcessPK(_serviceProcessId, _serviceinfoId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ServiceInfoProcessPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return ServiceInfoProcess.class;
	}

	@Override
	public String getModelClassName() {
		return ServiceInfoProcess.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("serviceProcessId", getServiceProcessId());
		attributes.put("serviceinfoId", getServiceinfoId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long serviceProcessId = (Long)attributes.get("serviceProcessId");

		if (serviceProcessId != null) {
			setServiceProcessId(serviceProcessId);
		}

		Long serviceinfoId = (Long)attributes.get("serviceinfoId");

		if (serviceinfoId != null) {
			setServiceinfoId(serviceinfoId);
		}
	}

	@JSON
	@Override
	public long getServiceProcessId() {
		return _serviceProcessId;
	}

	@Override
	public void setServiceProcessId(long serviceProcessId) {
		_columnBitmask |= SERVICEPROCESSID_COLUMN_BITMASK;

		if (!_setOriginalServiceProcessId) {
			_setOriginalServiceProcessId = true;

			_originalServiceProcessId = _serviceProcessId;
		}

		_serviceProcessId = serviceProcessId;
	}

	public long getOriginalServiceProcessId() {
		return _originalServiceProcessId;
	}

	@JSON
	@Override
	public long getServiceinfoId() {
		return _serviceinfoId;
	}

	@Override
	public void setServiceinfoId(long serviceinfoId) {
		_columnBitmask |= SERVICEINFOID_COLUMN_BITMASK;

		if (!_setOriginalServiceinfoId) {
			_setOriginalServiceinfoId = true;

			_originalServiceinfoId = _serviceinfoId;
		}

		_serviceinfoId = serviceinfoId;
	}

	public long getOriginalServiceinfoId() {
		return _originalServiceinfoId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ServiceInfoProcess toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ServiceInfoProcess)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ServiceInfoProcessImpl serviceInfoProcessImpl = new ServiceInfoProcessImpl();

		serviceInfoProcessImpl.setServiceProcessId(getServiceProcessId());
		serviceInfoProcessImpl.setServiceinfoId(getServiceinfoId());

		serviceInfoProcessImpl.resetOriginalValues();

		return serviceInfoProcessImpl;
	}

	@Override
	public int compareTo(ServiceInfoProcess serviceInfoProcess) {
		ServiceInfoProcessPK primaryKey = serviceInfoProcess.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ServiceInfoProcess)) {
			return false;
		}

		ServiceInfoProcess serviceInfoProcess = (ServiceInfoProcess)obj;

		ServiceInfoProcessPK primaryKey = serviceInfoProcess.getPrimaryKey();

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
		ServiceInfoProcessModelImpl serviceInfoProcessModelImpl = this;

		serviceInfoProcessModelImpl._originalServiceProcessId = serviceInfoProcessModelImpl._serviceProcessId;

		serviceInfoProcessModelImpl._setOriginalServiceProcessId = false;

		serviceInfoProcessModelImpl._originalServiceinfoId = serviceInfoProcessModelImpl._serviceinfoId;

		serviceInfoProcessModelImpl._setOriginalServiceinfoId = false;

		serviceInfoProcessModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ServiceInfoProcess> toCacheModel() {
		ServiceInfoProcessCacheModel serviceInfoProcessCacheModel = new ServiceInfoProcessCacheModel();

		serviceInfoProcessCacheModel.serviceProcessId = getServiceProcessId();

		serviceInfoProcessCacheModel.serviceinfoId = getServiceinfoId();

		return serviceInfoProcessCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{serviceProcessId=");
		sb.append(getServiceProcessId());
		sb.append(", serviceinfoId=");
		sb.append(getServiceinfoId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("org.opencps.processmgt.model.ServiceInfoProcess");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>serviceProcessId</column-name><column-value><![CDATA[");
		sb.append(getServiceProcessId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceinfoId</column-name><column-value><![CDATA[");
		sb.append(getServiceinfoId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ServiceInfoProcess.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ServiceInfoProcess.class
		};
	private long _serviceProcessId;
	private long _originalServiceProcessId;
	private boolean _setOriginalServiceProcessId;
	private long _serviceinfoId;
	private long _originalServiceinfoId;
	private boolean _setOriginalServiceinfoId;
	private long _columnBitmask;
	private ServiceInfoProcess _escapedModel;
}