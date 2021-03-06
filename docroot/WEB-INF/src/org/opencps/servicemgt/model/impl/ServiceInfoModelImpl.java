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

package org.opencps.servicemgt.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.lar.StagedModelType;
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

import org.opencps.servicemgt.model.ServiceInfo;
import org.opencps.servicemgt.model.ServiceInfoModel;
import org.opencps.servicemgt.model.ServiceInfoSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ServiceInfo service. Represents a row in the &quot;opencps_serviceinfo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.opencps.servicemgt.model.ServiceInfoModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ServiceInfoImpl}.
 * </p>
 *
 * @author khoavd
 * @see ServiceInfoImpl
 * @see org.opencps.servicemgt.model.ServiceInfo
 * @see org.opencps.servicemgt.model.ServiceInfoModel
 * @generated
 */
@JSON(strict = true)
public class ServiceInfoModelImpl extends BaseModelImpl<ServiceInfo>
	implements ServiceInfoModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a service info model instance should use the {@link org.opencps.servicemgt.model.ServiceInfo} interface instead.
	 */
	public static final String TABLE_NAME = "opencps_serviceinfo";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "serviceinfoId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "serviceNo", Types.VARCHAR },
			{ "serviceName", Types.VARCHAR },
			{ "fullName", Types.VARCHAR },
			{ "serviceProcess", Types.VARCHAR },
			{ "serviceMethod", Types.VARCHAR },
			{ "serviceDossier", Types.VARCHAR },
			{ "serviceCondition", Types.VARCHAR },
			{ "serviceDuration", Types.VARCHAR },
			{ "serviceActors", Types.VARCHAR },
			{ "serviceResults", Types.VARCHAR },
			{ "serviceRecords", Types.VARCHAR },
			{ "serviceFee", Types.VARCHAR },
			{ "serviceInstructions", Types.VARCHAR },
			{ "administrationCode", Types.VARCHAR },
			{ "administrationIndex", Types.VARCHAR },
			{ "domainCode", Types.VARCHAR },
			{ "domainIndex", Types.VARCHAR },
			{ "activeStatus", Types.INTEGER },
			{ "hasTemplateFiles", Types.INTEGER },
			{ "onlineUrl", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table opencps_serviceinfo (uuid_ VARCHAR(75) null,serviceinfoId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,serviceNo VARCHAR(75) null,serviceName VARCHAR(500) null,fullName VARCHAR(500) null,serviceProcess VARCHAR(75) null,serviceMethod VARCHAR(75) null,serviceDossier VARCHAR(75) null,serviceCondition VARCHAR(75) null,serviceDuration VARCHAR(75) null,serviceActors VARCHAR(75) null,serviceResults VARCHAR(75) null,serviceRecords VARCHAR(75) null,serviceFee VARCHAR(75) null,serviceInstructions VARCHAR(75) null,administrationCode VARCHAR(75) null,administrationIndex VARCHAR(75) null,domainCode VARCHAR(75) null,domainIndex VARCHAR(75) null,activeStatus INTEGER,hasTemplateFiles INTEGER,onlineUrl VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table opencps_serviceinfo";
	public static final String ORDER_BY_JPQL = " ORDER BY serviceInfo.serviceName ASC";
	public static final String ORDER_BY_SQL = " ORDER BY opencps_serviceinfo.serviceName ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.opencps.servicemgt.model.ServiceInfo"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.opencps.servicemgt.model.ServiceInfo"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.opencps.servicemgt.model.ServiceInfo"),
			true);
	public static long ACTIVESTATUS_COLUMN_BITMASK = 1L;
	public static long ADMINISTRATIONCODE_COLUMN_BITMASK = 2L;
	public static long COMPANYID_COLUMN_BITMASK = 4L;
	public static long DOMAINCODE_COLUMN_BITMASK = 8L;
	public static long GROUPID_COLUMN_BITMASK = 16L;
	public static long UUID_COLUMN_BITMASK = 32L;
	public static long SERVICENAME_COLUMN_BITMASK = 64L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ServiceInfo toModel(ServiceInfoSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ServiceInfo model = new ServiceInfoImpl();

		model.setUuid(soapModel.getUuid());
		model.setServiceinfoId(soapModel.getServiceinfoId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setServiceNo(soapModel.getServiceNo());
		model.setServiceName(soapModel.getServiceName());
		model.setFullName(soapModel.getFullName());
		model.setServiceProcess(soapModel.getServiceProcess());
		model.setServiceMethod(soapModel.getServiceMethod());
		model.setServiceDossier(soapModel.getServiceDossier());
		model.setServiceCondition(soapModel.getServiceCondition());
		model.setServiceDuration(soapModel.getServiceDuration());
		model.setServiceActors(soapModel.getServiceActors());
		model.setServiceResults(soapModel.getServiceResults());
		model.setServiceRecords(soapModel.getServiceRecords());
		model.setServiceFee(soapModel.getServiceFee());
		model.setServiceInstructions(soapModel.getServiceInstructions());
		model.setAdministrationCode(soapModel.getAdministrationCode());
		model.setAdministrationIndex(soapModel.getAdministrationIndex());
		model.setDomainCode(soapModel.getDomainCode());
		model.setDomainIndex(soapModel.getDomainIndex());
		model.setActiveStatus(soapModel.getActiveStatus());
		model.setHasTemplateFiles(soapModel.getHasTemplateFiles());
		model.setOnlineUrl(soapModel.getOnlineUrl());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ServiceInfo> toModels(ServiceInfoSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ServiceInfo> models = new ArrayList<ServiceInfo>(soapModels.length);

		for (ServiceInfoSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.opencps.servicemgt.model.ServiceInfo"));

	public ServiceInfoModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _serviceinfoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setServiceinfoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _serviceinfoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ServiceInfo.class;
	}

	@Override
	public String getModelClassName() {
		return ServiceInfo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("serviceinfoId", getServiceinfoId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("serviceNo", getServiceNo());
		attributes.put("serviceName", getServiceName());
		attributes.put("fullName", getFullName());
		attributes.put("serviceProcess", getServiceProcess());
		attributes.put("serviceMethod", getServiceMethod());
		attributes.put("serviceDossier", getServiceDossier());
		attributes.put("serviceCondition", getServiceCondition());
		attributes.put("serviceDuration", getServiceDuration());
		attributes.put("serviceActors", getServiceActors());
		attributes.put("serviceResults", getServiceResults());
		attributes.put("serviceRecords", getServiceRecords());
		attributes.put("serviceFee", getServiceFee());
		attributes.put("serviceInstructions", getServiceInstructions());
		attributes.put("administrationCode", getAdministrationCode());
		attributes.put("administrationIndex", getAdministrationIndex());
		attributes.put("domainCode", getDomainCode());
		attributes.put("domainIndex", getDomainIndex());
		attributes.put("activeStatus", getActiveStatus());
		attributes.put("hasTemplateFiles", getHasTemplateFiles());
		attributes.put("onlineUrl", getOnlineUrl());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long serviceinfoId = (Long)attributes.get("serviceinfoId");

		if (serviceinfoId != null) {
			setServiceinfoId(serviceinfoId);
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

		String serviceNo = (String)attributes.get("serviceNo");

		if (serviceNo != null) {
			setServiceNo(serviceNo);
		}

		String serviceName = (String)attributes.get("serviceName");

		if (serviceName != null) {
			setServiceName(serviceName);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		String serviceProcess = (String)attributes.get("serviceProcess");

		if (serviceProcess != null) {
			setServiceProcess(serviceProcess);
		}

		String serviceMethod = (String)attributes.get("serviceMethod");

		if (serviceMethod != null) {
			setServiceMethod(serviceMethod);
		}

		String serviceDossier = (String)attributes.get("serviceDossier");

		if (serviceDossier != null) {
			setServiceDossier(serviceDossier);
		}

		String serviceCondition = (String)attributes.get("serviceCondition");

		if (serviceCondition != null) {
			setServiceCondition(serviceCondition);
		}

		String serviceDuration = (String)attributes.get("serviceDuration");

		if (serviceDuration != null) {
			setServiceDuration(serviceDuration);
		}

		String serviceActors = (String)attributes.get("serviceActors");

		if (serviceActors != null) {
			setServiceActors(serviceActors);
		}

		String serviceResults = (String)attributes.get("serviceResults");

		if (serviceResults != null) {
			setServiceResults(serviceResults);
		}

		String serviceRecords = (String)attributes.get("serviceRecords");

		if (serviceRecords != null) {
			setServiceRecords(serviceRecords);
		}

		String serviceFee = (String)attributes.get("serviceFee");

		if (serviceFee != null) {
			setServiceFee(serviceFee);
		}

		String serviceInstructions = (String)attributes.get(
				"serviceInstructions");

		if (serviceInstructions != null) {
			setServiceInstructions(serviceInstructions);
		}

		String administrationCode = (String)attributes.get("administrationCode");

		if (administrationCode != null) {
			setAdministrationCode(administrationCode);
		}

		String administrationIndex = (String)attributes.get(
				"administrationIndex");

		if (administrationIndex != null) {
			setAdministrationIndex(administrationIndex);
		}

		String domainCode = (String)attributes.get("domainCode");

		if (domainCode != null) {
			setDomainCode(domainCode);
		}

		String domainIndex = (String)attributes.get("domainIndex");

		if (domainIndex != null) {
			setDomainIndex(domainIndex);
		}

		Integer activeStatus = (Integer)attributes.get("activeStatus");

		if (activeStatus != null) {
			setActiveStatus(activeStatus);
		}

		Integer hasTemplateFiles = (Integer)attributes.get("hasTemplateFiles");

		if (hasTemplateFiles != null) {
			setHasTemplateFiles(hasTemplateFiles);
		}

		String onlineUrl = (String)attributes.get("onlineUrl");

		if (onlineUrl != null) {
			setOnlineUrl(onlineUrl);
		}
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getServiceinfoId() {
		return _serviceinfoId;
	}

	@Override
	public void setServiceinfoId(long serviceinfoId) {
		_serviceinfoId = serviceinfoId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
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
	public String getServiceNo() {
		if (_serviceNo == null) {
			return StringPool.BLANK;
		}
		else {
			return _serviceNo;
		}
	}

	@Override
	public void setServiceNo(String serviceNo) {
		_serviceNo = serviceNo;
	}

	@JSON
	@Override
	public String getServiceName() {
		if (_serviceName == null) {
			return StringPool.BLANK;
		}
		else {
			return _serviceName;
		}
	}

	@Override
	public void setServiceName(String serviceName) {
		_columnBitmask = -1L;

		_serviceName = serviceName;
	}

	@JSON
	@Override
	public String getFullName() {
		if (_fullName == null) {
			return StringPool.BLANK;
		}
		else {
			return _fullName;
		}
	}

	@Override
	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	@JSON
	@Override
	public String getServiceProcess() {
		if (_serviceProcess == null) {
			return StringPool.BLANK;
		}
		else {
			return _serviceProcess;
		}
	}

	@Override
	public void setServiceProcess(String serviceProcess) {
		_serviceProcess = serviceProcess;
	}

	@JSON
	@Override
	public String getServiceMethod() {
		if (_serviceMethod == null) {
			return StringPool.BLANK;
		}
		else {
			return _serviceMethod;
		}
	}

	@Override
	public void setServiceMethod(String serviceMethod) {
		_serviceMethod = serviceMethod;
	}

	@JSON
	@Override
	public String getServiceDossier() {
		if (_serviceDossier == null) {
			return StringPool.BLANK;
		}
		else {
			return _serviceDossier;
		}
	}

	@Override
	public void setServiceDossier(String serviceDossier) {
		_serviceDossier = serviceDossier;
	}

	@JSON
	@Override
	public String getServiceCondition() {
		if (_serviceCondition == null) {
			return StringPool.BLANK;
		}
		else {
			return _serviceCondition;
		}
	}

	@Override
	public void setServiceCondition(String serviceCondition) {
		_serviceCondition = serviceCondition;
	}

	@JSON
	@Override
	public String getServiceDuration() {
		if (_serviceDuration == null) {
			return StringPool.BLANK;
		}
		else {
			return _serviceDuration;
		}
	}

	@Override
	public void setServiceDuration(String serviceDuration) {
		_serviceDuration = serviceDuration;
	}

	@JSON
	@Override
	public String getServiceActors() {
		if (_serviceActors == null) {
			return StringPool.BLANK;
		}
		else {
			return _serviceActors;
		}
	}

	@Override
	public void setServiceActors(String serviceActors) {
		_serviceActors = serviceActors;
	}

	@JSON
	@Override
	public String getServiceResults() {
		if (_serviceResults == null) {
			return StringPool.BLANK;
		}
		else {
			return _serviceResults;
		}
	}

	@Override
	public void setServiceResults(String serviceResults) {
		_serviceResults = serviceResults;
	}

	@JSON
	@Override
	public String getServiceRecords() {
		if (_serviceRecords == null) {
			return StringPool.BLANK;
		}
		else {
			return _serviceRecords;
		}
	}

	@Override
	public void setServiceRecords(String serviceRecords) {
		_serviceRecords = serviceRecords;
	}

	@JSON
	@Override
	public String getServiceFee() {
		if (_serviceFee == null) {
			return StringPool.BLANK;
		}
		else {
			return _serviceFee;
		}
	}

	@Override
	public void setServiceFee(String serviceFee) {
		_serviceFee = serviceFee;
	}

	@JSON
	@Override
	public String getServiceInstructions() {
		if (_serviceInstructions == null) {
			return StringPool.BLANK;
		}
		else {
			return _serviceInstructions;
		}
	}

	@Override
	public void setServiceInstructions(String serviceInstructions) {
		_serviceInstructions = serviceInstructions;
	}

	@JSON
	@Override
	public String getAdministrationCode() {
		if (_administrationCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _administrationCode;
		}
	}

	@Override
	public void setAdministrationCode(String administrationCode) {
		_columnBitmask |= ADMINISTRATIONCODE_COLUMN_BITMASK;

		if (_originalAdministrationCode == null) {
			_originalAdministrationCode = _administrationCode;
		}

		_administrationCode = administrationCode;
	}

	public String getOriginalAdministrationCode() {
		return GetterUtil.getString(_originalAdministrationCode);
	}

	@JSON
	@Override
	public String getAdministrationIndex() {
		if (_administrationIndex == null) {
			return StringPool.BLANK;
		}
		else {
			return _administrationIndex;
		}
	}

	@Override
	public void setAdministrationIndex(String administrationIndex) {
		_administrationIndex = administrationIndex;
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
		_columnBitmask |= DOMAINCODE_COLUMN_BITMASK;

		if (_originalDomainCode == null) {
			_originalDomainCode = _domainCode;
		}

		_domainCode = domainCode;
	}

	public String getOriginalDomainCode() {
		return GetterUtil.getString(_originalDomainCode);
	}

	@JSON
	@Override
	public String getDomainIndex() {
		if (_domainIndex == null) {
			return StringPool.BLANK;
		}
		else {
			return _domainIndex;
		}
	}

	@Override
	public void setDomainIndex(String domainIndex) {
		_domainIndex = domainIndex;
	}

	@JSON
	@Override
	public int getActiveStatus() {
		return _activeStatus;
	}

	@Override
	public void setActiveStatus(int activeStatus) {
		_columnBitmask |= ACTIVESTATUS_COLUMN_BITMASK;

		if (!_setOriginalActiveStatus) {
			_setOriginalActiveStatus = true;

			_originalActiveStatus = _activeStatus;
		}

		_activeStatus = activeStatus;
	}

	public int getOriginalActiveStatus() {
		return _originalActiveStatus;
	}

	@JSON
	@Override
	public int getHasTemplateFiles() {
		return _hasTemplateFiles;
	}

	@Override
	public void setHasTemplateFiles(int hasTemplateFiles) {
		_hasTemplateFiles = hasTemplateFiles;
	}

	@JSON
	@Override
	public String getOnlineUrl() {
		if (_onlineUrl == null) {
			return StringPool.BLANK;
		}
		else {
			return _onlineUrl;
		}
	}

	@Override
	public void setOnlineUrl(String onlineUrl) {
		_onlineUrl = onlineUrl;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				ServiceInfo.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ServiceInfo.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ServiceInfo toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ServiceInfo)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ServiceInfoImpl serviceInfoImpl = new ServiceInfoImpl();

		serviceInfoImpl.setUuid(getUuid());
		serviceInfoImpl.setServiceinfoId(getServiceinfoId());
		serviceInfoImpl.setCompanyId(getCompanyId());
		serviceInfoImpl.setGroupId(getGroupId());
		serviceInfoImpl.setUserId(getUserId());
		serviceInfoImpl.setCreateDate(getCreateDate());
		serviceInfoImpl.setModifiedDate(getModifiedDate());
		serviceInfoImpl.setServiceNo(getServiceNo());
		serviceInfoImpl.setServiceName(getServiceName());
		serviceInfoImpl.setFullName(getFullName());
		serviceInfoImpl.setServiceProcess(getServiceProcess());
		serviceInfoImpl.setServiceMethod(getServiceMethod());
		serviceInfoImpl.setServiceDossier(getServiceDossier());
		serviceInfoImpl.setServiceCondition(getServiceCondition());
		serviceInfoImpl.setServiceDuration(getServiceDuration());
		serviceInfoImpl.setServiceActors(getServiceActors());
		serviceInfoImpl.setServiceResults(getServiceResults());
		serviceInfoImpl.setServiceRecords(getServiceRecords());
		serviceInfoImpl.setServiceFee(getServiceFee());
		serviceInfoImpl.setServiceInstructions(getServiceInstructions());
		serviceInfoImpl.setAdministrationCode(getAdministrationCode());
		serviceInfoImpl.setAdministrationIndex(getAdministrationIndex());
		serviceInfoImpl.setDomainCode(getDomainCode());
		serviceInfoImpl.setDomainIndex(getDomainIndex());
		serviceInfoImpl.setActiveStatus(getActiveStatus());
		serviceInfoImpl.setHasTemplateFiles(getHasTemplateFiles());
		serviceInfoImpl.setOnlineUrl(getOnlineUrl());

		serviceInfoImpl.resetOriginalValues();

		return serviceInfoImpl;
	}

	@Override
	public int compareTo(ServiceInfo serviceInfo) {
		int value = 0;

		value = getServiceName().compareTo(serviceInfo.getServiceName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ServiceInfo)) {
			return false;
		}

		ServiceInfo serviceInfo = (ServiceInfo)obj;

		long primaryKey = serviceInfo.getPrimaryKey();

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
		ServiceInfoModelImpl serviceInfoModelImpl = this;

		serviceInfoModelImpl._originalUuid = serviceInfoModelImpl._uuid;

		serviceInfoModelImpl._originalCompanyId = serviceInfoModelImpl._companyId;

		serviceInfoModelImpl._setOriginalCompanyId = false;

		serviceInfoModelImpl._originalGroupId = serviceInfoModelImpl._groupId;

		serviceInfoModelImpl._setOriginalGroupId = false;

		serviceInfoModelImpl._originalAdministrationCode = serviceInfoModelImpl._administrationCode;

		serviceInfoModelImpl._originalDomainCode = serviceInfoModelImpl._domainCode;

		serviceInfoModelImpl._originalActiveStatus = serviceInfoModelImpl._activeStatus;

		serviceInfoModelImpl._setOriginalActiveStatus = false;

		serviceInfoModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ServiceInfo> toCacheModel() {
		ServiceInfoCacheModel serviceInfoCacheModel = new ServiceInfoCacheModel();

		serviceInfoCacheModel.uuid = getUuid();

		String uuid = serviceInfoCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			serviceInfoCacheModel.uuid = null;
		}

		serviceInfoCacheModel.serviceinfoId = getServiceinfoId();

		serviceInfoCacheModel.companyId = getCompanyId();

		serviceInfoCacheModel.groupId = getGroupId();

		serviceInfoCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			serviceInfoCacheModel.createDate = createDate.getTime();
		}
		else {
			serviceInfoCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			serviceInfoCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			serviceInfoCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		serviceInfoCacheModel.serviceNo = getServiceNo();

		String serviceNo = serviceInfoCacheModel.serviceNo;

		if ((serviceNo != null) && (serviceNo.length() == 0)) {
			serviceInfoCacheModel.serviceNo = null;
		}

		serviceInfoCacheModel.serviceName = getServiceName();

		String serviceName = serviceInfoCacheModel.serviceName;

		if ((serviceName != null) && (serviceName.length() == 0)) {
			serviceInfoCacheModel.serviceName = null;
		}

		serviceInfoCacheModel.fullName = getFullName();

		String fullName = serviceInfoCacheModel.fullName;

		if ((fullName != null) && (fullName.length() == 0)) {
			serviceInfoCacheModel.fullName = null;
		}

		serviceInfoCacheModel.serviceProcess = getServiceProcess();

		String serviceProcess = serviceInfoCacheModel.serviceProcess;

		if ((serviceProcess != null) && (serviceProcess.length() == 0)) {
			serviceInfoCacheModel.serviceProcess = null;
		}

		serviceInfoCacheModel.serviceMethod = getServiceMethod();

		String serviceMethod = serviceInfoCacheModel.serviceMethod;

		if ((serviceMethod != null) && (serviceMethod.length() == 0)) {
			serviceInfoCacheModel.serviceMethod = null;
		}

		serviceInfoCacheModel.serviceDossier = getServiceDossier();

		String serviceDossier = serviceInfoCacheModel.serviceDossier;

		if ((serviceDossier != null) && (serviceDossier.length() == 0)) {
			serviceInfoCacheModel.serviceDossier = null;
		}

		serviceInfoCacheModel.serviceCondition = getServiceCondition();

		String serviceCondition = serviceInfoCacheModel.serviceCondition;

		if ((serviceCondition != null) && (serviceCondition.length() == 0)) {
			serviceInfoCacheModel.serviceCondition = null;
		}

		serviceInfoCacheModel.serviceDuration = getServiceDuration();

		String serviceDuration = serviceInfoCacheModel.serviceDuration;

		if ((serviceDuration != null) && (serviceDuration.length() == 0)) {
			serviceInfoCacheModel.serviceDuration = null;
		}

		serviceInfoCacheModel.serviceActors = getServiceActors();

		String serviceActors = serviceInfoCacheModel.serviceActors;

		if ((serviceActors != null) && (serviceActors.length() == 0)) {
			serviceInfoCacheModel.serviceActors = null;
		}

		serviceInfoCacheModel.serviceResults = getServiceResults();

		String serviceResults = serviceInfoCacheModel.serviceResults;

		if ((serviceResults != null) && (serviceResults.length() == 0)) {
			serviceInfoCacheModel.serviceResults = null;
		}

		serviceInfoCacheModel.serviceRecords = getServiceRecords();

		String serviceRecords = serviceInfoCacheModel.serviceRecords;

		if ((serviceRecords != null) && (serviceRecords.length() == 0)) {
			serviceInfoCacheModel.serviceRecords = null;
		}

		serviceInfoCacheModel.serviceFee = getServiceFee();

		String serviceFee = serviceInfoCacheModel.serviceFee;

		if ((serviceFee != null) && (serviceFee.length() == 0)) {
			serviceInfoCacheModel.serviceFee = null;
		}

		serviceInfoCacheModel.serviceInstructions = getServiceInstructions();

		String serviceInstructions = serviceInfoCacheModel.serviceInstructions;

		if ((serviceInstructions != null) &&
				(serviceInstructions.length() == 0)) {
			serviceInfoCacheModel.serviceInstructions = null;
		}

		serviceInfoCacheModel.administrationCode = getAdministrationCode();

		String administrationCode = serviceInfoCacheModel.administrationCode;

		if ((administrationCode != null) && (administrationCode.length() == 0)) {
			serviceInfoCacheModel.administrationCode = null;
		}

		serviceInfoCacheModel.administrationIndex = getAdministrationIndex();

		String administrationIndex = serviceInfoCacheModel.administrationIndex;

		if ((administrationIndex != null) &&
				(administrationIndex.length() == 0)) {
			serviceInfoCacheModel.administrationIndex = null;
		}

		serviceInfoCacheModel.domainCode = getDomainCode();

		String domainCode = serviceInfoCacheModel.domainCode;

		if ((domainCode != null) && (domainCode.length() == 0)) {
			serviceInfoCacheModel.domainCode = null;
		}

		serviceInfoCacheModel.domainIndex = getDomainIndex();

		String domainIndex = serviceInfoCacheModel.domainIndex;

		if ((domainIndex != null) && (domainIndex.length() == 0)) {
			serviceInfoCacheModel.domainIndex = null;
		}

		serviceInfoCacheModel.activeStatus = getActiveStatus();

		serviceInfoCacheModel.hasTemplateFiles = getHasTemplateFiles();

		serviceInfoCacheModel.onlineUrl = getOnlineUrl();

		String onlineUrl = serviceInfoCacheModel.onlineUrl;

		if ((onlineUrl != null) && (onlineUrl.length() == 0)) {
			serviceInfoCacheModel.onlineUrl = null;
		}

		return serviceInfoCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(55);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", serviceinfoId=");
		sb.append(getServiceinfoId());
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
		sb.append(", serviceNo=");
		sb.append(getServiceNo());
		sb.append(", serviceName=");
		sb.append(getServiceName());
		sb.append(", fullName=");
		sb.append(getFullName());
		sb.append(", serviceProcess=");
		sb.append(getServiceProcess());
		sb.append(", serviceMethod=");
		sb.append(getServiceMethod());
		sb.append(", serviceDossier=");
		sb.append(getServiceDossier());
		sb.append(", serviceCondition=");
		sb.append(getServiceCondition());
		sb.append(", serviceDuration=");
		sb.append(getServiceDuration());
		sb.append(", serviceActors=");
		sb.append(getServiceActors());
		sb.append(", serviceResults=");
		sb.append(getServiceResults());
		sb.append(", serviceRecords=");
		sb.append(getServiceRecords());
		sb.append(", serviceFee=");
		sb.append(getServiceFee());
		sb.append(", serviceInstructions=");
		sb.append(getServiceInstructions());
		sb.append(", administrationCode=");
		sb.append(getAdministrationCode());
		sb.append(", administrationIndex=");
		sb.append(getAdministrationIndex());
		sb.append(", domainCode=");
		sb.append(getDomainCode());
		sb.append(", domainIndex=");
		sb.append(getDomainIndex());
		sb.append(", activeStatus=");
		sb.append(getActiveStatus());
		sb.append(", hasTemplateFiles=");
		sb.append(getHasTemplateFiles());
		sb.append(", onlineUrl=");
		sb.append(getOnlineUrl());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(85);

		sb.append("<model><model-name>");
		sb.append("org.opencps.servicemgt.model.ServiceInfo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceinfoId</column-name><column-value><![CDATA[");
		sb.append(getServiceinfoId());
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
			"<column><column-name>serviceNo</column-name><column-value><![CDATA[");
		sb.append(getServiceNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceName</column-name><column-value><![CDATA[");
		sb.append(getServiceName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fullName</column-name><column-value><![CDATA[");
		sb.append(getFullName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceProcess</column-name><column-value><![CDATA[");
		sb.append(getServiceProcess());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceMethod</column-name><column-value><![CDATA[");
		sb.append(getServiceMethod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceDossier</column-name><column-value><![CDATA[");
		sb.append(getServiceDossier());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceCondition</column-name><column-value><![CDATA[");
		sb.append(getServiceCondition());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceDuration</column-name><column-value><![CDATA[");
		sb.append(getServiceDuration());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceActors</column-name><column-value><![CDATA[");
		sb.append(getServiceActors());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceResults</column-name><column-value><![CDATA[");
		sb.append(getServiceResults());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceRecords</column-name><column-value><![CDATA[");
		sb.append(getServiceRecords());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceFee</column-name><column-value><![CDATA[");
		sb.append(getServiceFee());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceInstructions</column-name><column-value><![CDATA[");
		sb.append(getServiceInstructions());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>administrationCode</column-name><column-value><![CDATA[");
		sb.append(getAdministrationCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>administrationIndex</column-name><column-value><![CDATA[");
		sb.append(getAdministrationIndex());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>domainCode</column-name><column-value><![CDATA[");
		sb.append(getDomainCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>domainIndex</column-name><column-value><![CDATA[");
		sb.append(getDomainIndex());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>activeStatus</column-name><column-value><![CDATA[");
		sb.append(getActiveStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hasTemplateFiles</column-name><column-value><![CDATA[");
		sb.append(getHasTemplateFiles());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>onlineUrl</column-name><column-value><![CDATA[");
		sb.append(getOnlineUrl());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ServiceInfo.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ServiceInfo.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _serviceinfoId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _serviceNo;
	private String _serviceName;
	private String _fullName;
	private String _serviceProcess;
	private String _serviceMethod;
	private String _serviceDossier;
	private String _serviceCondition;
	private String _serviceDuration;
	private String _serviceActors;
	private String _serviceResults;
	private String _serviceRecords;
	private String _serviceFee;
	private String _serviceInstructions;
	private String _administrationCode;
	private String _originalAdministrationCode;
	private String _administrationIndex;
	private String _domainCode;
	private String _originalDomainCode;
	private String _domainIndex;
	private int _activeStatus;
	private int _originalActiveStatus;
	private boolean _setOriginalActiveStatus;
	private int _hasTemplateFiles;
	private String _onlineUrl;
	private long _columnBitmask;
	private ServiceInfo _escapedModel;
}