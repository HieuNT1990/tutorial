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

package org.opencps.dossiermgt.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import org.opencps.dossiermgt.model.ServiceConfig;
import org.opencps.dossiermgt.model.ServiceConfigModel;
import org.opencps.dossiermgt.model.ServiceConfigSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ServiceConfig service. Represents a row in the &quot;opencps_service_config&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.opencps.dossiermgt.model.ServiceConfigModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ServiceConfigImpl}.
 * </p>
 *
 * @author trungnt
 * @see ServiceConfigImpl
 * @see org.opencps.dossiermgt.model.ServiceConfig
 * @see org.opencps.dossiermgt.model.ServiceConfigModel
 * @generated
 */
@JSON(strict = true)
public class ServiceConfigModelImpl extends BaseModelImpl<ServiceConfig>
	implements ServiceConfigModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a service config model instance should use the {@link org.opencps.dossiermgt.model.ServiceConfig} interface instead.
	 */
	public static final String TABLE_NAME = "opencps_service_config";
	public static final Object[][] TABLE_COLUMNS = {
			{ "serviceConfigId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "serviceInfoId", Types.BIGINT },
			{ "serviceDomainIndex", Types.VARCHAR },
			{ "serviceAdministrationIndex", Types.VARCHAR },
			{ "dossierTemplateId", Types.BIGINT },
			{ "govAgencyCode", Types.VARCHAR },
			{ "govAgencyName", Types.VARCHAR },
			{ "govAgencyOrganizationId", Types.BIGINT },
			{ "serviceMode", Types.INTEGER },
			{ "serviceProcessId", Types.BIGINT },
			{ "domainCode", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table opencps_service_config (serviceConfigId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,serviceInfoId LONG,serviceDomainIndex VARCHAR(75) null,serviceAdministrationIndex VARCHAR(75) null,dossierTemplateId LONG,govAgencyCode VARCHAR(75) null,govAgencyName VARCHAR(75) null,govAgencyOrganizationId LONG,serviceMode INTEGER,serviceProcessId LONG,domainCode VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table opencps_service_config";
	public static final String ORDER_BY_JPQL = " ORDER BY serviceConfig.serviceConfigId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY opencps_service_config.serviceConfigId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.opencps.dossiermgt.model.ServiceConfig"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.opencps.dossiermgt.model.ServiceConfig"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.opencps.dossiermgt.model.ServiceConfig"),
			true);
	public static long DOSSIERTEMPLATEID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long SERVICEMODE_COLUMN_BITMASK = 4L;
	public static long SERVICECONFIGID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ServiceConfig toModel(ServiceConfigSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ServiceConfig model = new ServiceConfigImpl();

		model.setServiceConfigId(soapModel.getServiceConfigId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setServiceInfoId(soapModel.getServiceInfoId());
		model.setServiceDomainIndex(soapModel.getServiceDomainIndex());
		model.setServiceAdministrationIndex(soapModel.getServiceAdministrationIndex());
		model.setDossierTemplateId(soapModel.getDossierTemplateId());
		model.setGovAgencyCode(soapModel.getGovAgencyCode());
		model.setGovAgencyName(soapModel.getGovAgencyName());
		model.setGovAgencyOrganizationId(soapModel.getGovAgencyOrganizationId());
		model.setServiceMode(soapModel.getServiceMode());
		model.setServiceProcessId(soapModel.getServiceProcessId());
		model.setDomainCode(soapModel.getDomainCode());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ServiceConfig> toModels(ServiceConfigSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ServiceConfig> models = new ArrayList<ServiceConfig>(soapModels.length);

		for (ServiceConfigSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.opencps.dossiermgt.model.ServiceConfig"));

	public ServiceConfigModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _serviceConfigId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setServiceConfigId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _serviceConfigId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ServiceConfig.class;
	}

	@Override
	public String getModelClassName() {
		return ServiceConfig.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("serviceConfigId", getServiceConfigId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("serviceInfoId", getServiceInfoId());
		attributes.put("serviceDomainIndex", getServiceDomainIndex());
		attributes.put("serviceAdministrationIndex",
			getServiceAdministrationIndex());
		attributes.put("dossierTemplateId", getDossierTemplateId());
		attributes.put("govAgencyCode", getGovAgencyCode());
		attributes.put("govAgencyName", getGovAgencyName());
		attributes.put("govAgencyOrganizationId", getGovAgencyOrganizationId());
		attributes.put("serviceMode", getServiceMode());
		attributes.put("serviceProcessId", getServiceProcessId());
		attributes.put("domainCode", getDomainCode());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long serviceConfigId = (Long)attributes.get("serviceConfigId");

		if (serviceConfigId != null) {
			setServiceConfigId(serviceConfigId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long serviceInfoId = (Long)attributes.get("serviceInfoId");

		if (serviceInfoId != null) {
			setServiceInfoId(serviceInfoId);
		}

		String serviceDomainIndex = (String)attributes.get("serviceDomainIndex");

		if (serviceDomainIndex != null) {
			setServiceDomainIndex(serviceDomainIndex);
		}

		String serviceAdministrationIndex = (String)attributes.get(
				"serviceAdministrationIndex");

		if (serviceAdministrationIndex != null) {
			setServiceAdministrationIndex(serviceAdministrationIndex);
		}

		Long dossierTemplateId = (Long)attributes.get("dossierTemplateId");

		if (dossierTemplateId != null) {
			setDossierTemplateId(dossierTemplateId);
		}

		String govAgencyCode = (String)attributes.get("govAgencyCode");

		if (govAgencyCode != null) {
			setGovAgencyCode(govAgencyCode);
		}

		String govAgencyName = (String)attributes.get("govAgencyName");

		if (govAgencyName != null) {
			setGovAgencyName(govAgencyName);
		}

		Long govAgencyOrganizationId = (Long)attributes.get(
				"govAgencyOrganizationId");

		if (govAgencyOrganizationId != null) {
			setGovAgencyOrganizationId(govAgencyOrganizationId);
		}

		Integer serviceMode = (Integer)attributes.get("serviceMode");

		if (serviceMode != null) {
			setServiceMode(serviceMode);
		}

		Long serviceProcessId = (Long)attributes.get("serviceProcessId");

		if (serviceProcessId != null) {
			setServiceProcessId(serviceProcessId);
		}

		String domainCode = (String)attributes.get("domainCode");

		if (domainCode != null) {
			setDomainCode(domainCode);
		}
	}

	@JSON
	@Override
	public long getServiceConfigId() {
		return _serviceConfigId;
	}

	@Override
	public void setServiceConfigId(long serviceConfigId) {
		_serviceConfigId = serviceConfigId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getServiceInfoId() {
		return _serviceInfoId;
	}

	@Override
	public void setServiceInfoId(long serviceInfoId) {
		_serviceInfoId = serviceInfoId;
	}

	@JSON
	@Override
	public String getServiceDomainIndex() {
		if (_serviceDomainIndex == null) {
			return StringPool.BLANK;
		}
		else {
			return _serviceDomainIndex;
		}
	}

	@Override
	public void setServiceDomainIndex(String serviceDomainIndex) {
		_serviceDomainIndex = serviceDomainIndex;
	}

	@JSON
	@Override
	public String getServiceAdministrationIndex() {
		if (_serviceAdministrationIndex == null) {
			return StringPool.BLANK;
		}
		else {
			return _serviceAdministrationIndex;
		}
	}

	@Override
	public void setServiceAdministrationIndex(String serviceAdministrationIndex) {
		_serviceAdministrationIndex = serviceAdministrationIndex;
	}

	@JSON
	@Override
	public long getDossierTemplateId() {
		return _dossierTemplateId;
	}

	@Override
	public void setDossierTemplateId(long dossierTemplateId) {
		_columnBitmask |= DOSSIERTEMPLATEID_COLUMN_BITMASK;

		if (!_setOriginalDossierTemplateId) {
			_setOriginalDossierTemplateId = true;

			_originalDossierTemplateId = _dossierTemplateId;
		}

		_dossierTemplateId = dossierTemplateId;
	}

	public long getOriginalDossierTemplateId() {
		return _originalDossierTemplateId;
	}

	@JSON
	@Override
	public String getGovAgencyCode() {
		if (_govAgencyCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _govAgencyCode;
		}
	}

	@Override
	public void setGovAgencyCode(String govAgencyCode) {
		_govAgencyCode = govAgencyCode;
	}

	@JSON
	@Override
	public String getGovAgencyName() {
		if (_govAgencyName == null) {
			return StringPool.BLANK;
		}
		else {
			return _govAgencyName;
		}
	}

	@Override
	public void setGovAgencyName(String govAgencyName) {
		_govAgencyName = govAgencyName;
	}

	@JSON
	@Override
	public long getGovAgencyOrganizationId() {
		return _govAgencyOrganizationId;
	}

	@Override
	public void setGovAgencyOrganizationId(long govAgencyOrganizationId) {
		_govAgencyOrganizationId = govAgencyOrganizationId;
	}

	@JSON
	@Override
	public int getServiceMode() {
		return _serviceMode;
	}

	@Override
	public void setServiceMode(int serviceMode) {
		_columnBitmask |= SERVICEMODE_COLUMN_BITMASK;

		if (!_setOriginalServiceMode) {
			_setOriginalServiceMode = true;

			_originalServiceMode = _serviceMode;
		}

		_serviceMode = serviceMode;
	}

	public int getOriginalServiceMode() {
		return _originalServiceMode;
	}

	@JSON
	@Override
	public long getServiceProcessId() {
		return _serviceProcessId;
	}

	@Override
	public void setServiceProcessId(long serviceProcessId) {
		_serviceProcessId = serviceProcessId;
	}

	@JSON
	@Override
	public String getDomainCode() {
		if (_domainCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _domainCode;
		}
	}

	@Override
	public void setDomainCode(String domainCode) {
		_domainCode = domainCode;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ServiceConfig.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ServiceConfig toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ServiceConfig)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ServiceConfigImpl serviceConfigImpl = new ServiceConfigImpl();

		serviceConfigImpl.setServiceConfigId(getServiceConfigId());
		serviceConfigImpl.setCompanyId(getCompanyId());
		serviceConfigImpl.setGroupId(getGroupId());
		serviceConfigImpl.setUserId(getUserId());
		serviceConfigImpl.setCreateDate(getCreateDate());
		serviceConfigImpl.setModifiedDate(getModifiedDate());
		serviceConfigImpl.setServiceInfoId(getServiceInfoId());
		serviceConfigImpl.setServiceDomainIndex(getServiceDomainIndex());
		serviceConfigImpl.setServiceAdministrationIndex(getServiceAdministrationIndex());
		serviceConfigImpl.setDossierTemplateId(getDossierTemplateId());
		serviceConfigImpl.setGovAgencyCode(getGovAgencyCode());
		serviceConfigImpl.setGovAgencyName(getGovAgencyName());
		serviceConfigImpl.setGovAgencyOrganizationId(getGovAgencyOrganizationId());
		serviceConfigImpl.setServiceMode(getServiceMode());
		serviceConfigImpl.setServiceProcessId(getServiceProcessId());
		serviceConfigImpl.setDomainCode(getDomainCode());

		serviceConfigImpl.resetOriginalValues();

		return serviceConfigImpl;
	}

	@Override
	public int compareTo(ServiceConfig serviceConfig) {
		long primaryKey = serviceConfig.getPrimaryKey();

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

		if (!(obj instanceof ServiceConfig)) {
			return false;
		}

		ServiceConfig serviceConfig = (ServiceConfig)obj;

		long primaryKey = serviceConfig.getPrimaryKey();

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
		ServiceConfigModelImpl serviceConfigModelImpl = this;

		serviceConfigModelImpl._originalGroupId = serviceConfigModelImpl._groupId;

		serviceConfigModelImpl._setOriginalGroupId = false;

		serviceConfigModelImpl._originalDossierTemplateId = serviceConfigModelImpl._dossierTemplateId;

		serviceConfigModelImpl._setOriginalDossierTemplateId = false;

		serviceConfigModelImpl._originalServiceMode = serviceConfigModelImpl._serviceMode;

		serviceConfigModelImpl._setOriginalServiceMode = false;

		serviceConfigModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ServiceConfig> toCacheModel() {
		ServiceConfigCacheModel serviceConfigCacheModel = new ServiceConfigCacheModel();

		serviceConfigCacheModel.serviceConfigId = getServiceConfigId();

		serviceConfigCacheModel.companyId = getCompanyId();

		serviceConfigCacheModel.groupId = getGroupId();

		serviceConfigCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			serviceConfigCacheModel.createDate = createDate.getTime();
		}
		else {
			serviceConfigCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			serviceConfigCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			serviceConfigCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		serviceConfigCacheModel.serviceInfoId = getServiceInfoId();

		serviceConfigCacheModel.serviceDomainIndex = getServiceDomainIndex();

		String serviceDomainIndex = serviceConfigCacheModel.serviceDomainIndex;

		if ((serviceDomainIndex != null) && (serviceDomainIndex.length() == 0)) {
			serviceConfigCacheModel.serviceDomainIndex = null;
		}

		serviceConfigCacheModel.serviceAdministrationIndex = getServiceAdministrationIndex();

		String serviceAdministrationIndex = serviceConfigCacheModel.serviceAdministrationIndex;

		if ((serviceAdministrationIndex != null) &&
				(serviceAdministrationIndex.length() == 0)) {
			serviceConfigCacheModel.serviceAdministrationIndex = null;
		}

		serviceConfigCacheModel.dossierTemplateId = getDossierTemplateId();

		serviceConfigCacheModel.govAgencyCode = getGovAgencyCode();

		String govAgencyCode = serviceConfigCacheModel.govAgencyCode;

		if ((govAgencyCode != null) && (govAgencyCode.length() == 0)) {
			serviceConfigCacheModel.govAgencyCode = null;
		}

		serviceConfigCacheModel.govAgencyName = getGovAgencyName();

		String govAgencyName = serviceConfigCacheModel.govAgencyName;

		if ((govAgencyName != null) && (govAgencyName.length() == 0)) {
			serviceConfigCacheModel.govAgencyName = null;
		}

		serviceConfigCacheModel.govAgencyOrganizationId = getGovAgencyOrganizationId();

		serviceConfigCacheModel.serviceMode = getServiceMode();

		serviceConfigCacheModel.serviceProcessId = getServiceProcessId();

		serviceConfigCacheModel.domainCode = getDomainCode();

		String domainCode = serviceConfigCacheModel.domainCode;

		if ((domainCode != null) && (domainCode.length() == 0)) {
			serviceConfigCacheModel.domainCode = null;
		}

		return serviceConfigCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{serviceConfigId=");
		sb.append(getServiceConfigId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", serviceInfoId=");
		sb.append(getServiceInfoId());
		sb.append(", serviceDomainIndex=");
		sb.append(getServiceDomainIndex());
		sb.append(", serviceAdministrationIndex=");
		sb.append(getServiceAdministrationIndex());
		sb.append(", dossierTemplateId=");
		sb.append(getDossierTemplateId());
		sb.append(", govAgencyCode=");
		sb.append(getGovAgencyCode());
		sb.append(", govAgencyName=");
		sb.append(getGovAgencyName());
		sb.append(", govAgencyOrganizationId=");
		sb.append(getGovAgencyOrganizationId());
		sb.append(", serviceMode=");
		sb.append(getServiceMode());
		sb.append(", serviceProcessId=");
		sb.append(getServiceProcessId());
		sb.append(", domainCode=");
		sb.append(getDomainCode());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("org.opencps.dossiermgt.model.ServiceConfig");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>serviceConfigId</column-name><column-value><![CDATA[");
		sb.append(getServiceConfigId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceInfoId</column-name><column-value><![CDATA[");
		sb.append(getServiceInfoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceDomainIndex</column-name><column-value><![CDATA[");
		sb.append(getServiceDomainIndex());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceAdministrationIndex</column-name><column-value><![CDATA[");
		sb.append(getServiceAdministrationIndex());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierTemplateId</column-name><column-value><![CDATA[");
		sb.append(getDossierTemplateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>govAgencyCode</column-name><column-value><![CDATA[");
		sb.append(getGovAgencyCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>govAgencyName</column-name><column-value><![CDATA[");
		sb.append(getGovAgencyName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>govAgencyOrganizationId</column-name><column-value><![CDATA[");
		sb.append(getGovAgencyOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceMode</column-name><column-value><![CDATA[");
		sb.append(getServiceMode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceProcessId</column-name><column-value><![CDATA[");
		sb.append(getServiceProcessId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>domainCode</column-name><column-value><![CDATA[");
		sb.append(getDomainCode());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ServiceConfig.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ServiceConfig.class
		};
	private long _serviceConfigId;
	private long _companyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private long _serviceInfoId;
	private String _serviceDomainIndex;
	private String _serviceAdministrationIndex;
	private long _dossierTemplateId;
	private long _originalDossierTemplateId;
	private boolean _setOriginalDossierTemplateId;
	private String _govAgencyCode;
	private String _govAgencyName;
	private long _govAgencyOrganizationId;
	private int _serviceMode;
	private int _originalServiceMode;
	private boolean _setOriginalServiceMode;
	private long _serviceProcessId;
	private String _domainCode;
	private long _columnBitmask;
	private ServiceConfig _escapedModel;
}