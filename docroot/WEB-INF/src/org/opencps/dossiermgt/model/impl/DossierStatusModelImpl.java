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
import com.liferay.portal.kernel.util.DateUtil;
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

import org.opencps.dossiermgt.model.DossierStatus;
import org.opencps.dossiermgt.model.DossierStatusModel;
import org.opencps.dossiermgt.model.DossierStatusSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the DossierStatus service. Represents a row in the &quot;opencps_dossier_status&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.opencps.dossiermgt.model.DossierStatusModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DossierStatusImpl}.
 * </p>
 *
 * @author trungnt
 * @see DossierStatusImpl
 * @see org.opencps.dossiermgt.model.DossierStatus
 * @see org.opencps.dossiermgt.model.DossierStatusModel
 * @generated
 */
@JSON(strict = true)
public class DossierStatusModelImpl extends BaseModelImpl<DossierStatus>
	implements DossierStatusModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dossier status model instance should use the {@link org.opencps.dossiermgt.model.DossierStatus} interface instead.
	 */
	public static final String TABLE_NAME = "opencps_dossier_status";
	public static final Object[][] TABLE_COLUMNS = {
			{ "dossierStatusId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "dossierId", Types.BIGINT },
			{ "fileGroupId", Types.BIGINT },
			{ "dossierStatus", Types.INTEGER },
			{ "actionInfo", Types.VARCHAR },
			{ "messageInfo", Types.VARCHAR },
			{ "updateDatetime", Types.TIMESTAMP },
			{ "syncStatus", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table opencps_dossier_status (dossierStatusId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,dossierId LONG,fileGroupId LONG,dossierStatus INTEGER,actionInfo VARCHAR(75) null,messageInfo VARCHAR(75) null,updateDatetime DATE null,syncStatus INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table opencps_dossier_status";
	public static final String ORDER_BY_JPQL = " ORDER BY dossierStatus.modifiedDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY opencps_dossier_status.modifiedDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.opencps.dossiermgt.model.DossierStatus"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.opencps.dossiermgt.model.DossierStatus"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.opencps.dossiermgt.model.DossierStatus"),
			true);
	public static long DOSSIERID_COLUMN_BITMASK = 1L;
	public static long FILEGROUPID_COLUMN_BITMASK = 2L;
	public static long MODIFIEDDATE_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static DossierStatus toModel(DossierStatusSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		DossierStatus model = new DossierStatusImpl();

		model.setDossierStatusId(soapModel.getDossierStatusId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setDossierId(soapModel.getDossierId());
		model.setFileGroupId(soapModel.getFileGroupId());
		model.setDossierStatus(soapModel.getDossierStatus());
		model.setActionInfo(soapModel.getActionInfo());
		model.setMessageInfo(soapModel.getMessageInfo());
		model.setUpdateDatetime(soapModel.getUpdateDatetime());
		model.setSyncStatus(soapModel.getSyncStatus());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<DossierStatus> toModels(DossierStatusSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<DossierStatus> models = new ArrayList<DossierStatus>(soapModels.length);

		for (DossierStatusSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.opencps.dossiermgt.model.DossierStatus"));

	public DossierStatusModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _dossierStatusId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDossierStatusId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dossierStatusId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DossierStatus.class;
	}

	@Override
	public String getModelClassName() {
		return DossierStatus.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dossierStatusId", getDossierStatusId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dossierId", getDossierId());
		attributes.put("fileGroupId", getFileGroupId());
		attributes.put("dossierStatus", getDossierStatus());
		attributes.put("actionInfo", getActionInfo());
		attributes.put("messageInfo", getMessageInfo());
		attributes.put("updateDatetime", getUpdateDatetime());
		attributes.put("syncStatus", getSyncStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dossierStatusId = (Long)attributes.get("dossierStatusId");

		if (dossierStatusId != null) {
			setDossierStatusId(dossierStatusId);
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

		Long dossierId = (Long)attributes.get("dossierId");

		if (dossierId != null) {
			setDossierId(dossierId);
		}

		Long fileGroupId = (Long)attributes.get("fileGroupId");

		if (fileGroupId != null) {
			setFileGroupId(fileGroupId);
		}

		Integer dossierStatus = (Integer)attributes.get("dossierStatus");

		if (dossierStatus != null) {
			setDossierStatus(dossierStatus);
		}

		String actionInfo = (String)attributes.get("actionInfo");

		if (actionInfo != null) {
			setActionInfo(actionInfo);
		}

		String messageInfo = (String)attributes.get("messageInfo");

		if (messageInfo != null) {
			setMessageInfo(messageInfo);
		}

		Date updateDatetime = (Date)attributes.get("updateDatetime");

		if (updateDatetime != null) {
			setUpdateDatetime(updateDatetime);
		}

		Integer syncStatus = (Integer)attributes.get("syncStatus");

		if (syncStatus != null) {
			setSyncStatus(syncStatus);
		}
	}

	@JSON
	@Override
	public long getDossierStatusId() {
		return _dossierStatusId;
	}

	@Override
	public void setDossierStatusId(long dossierStatusId) {
		_dossierStatusId = dossierStatusId;
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
		_groupId = groupId;
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
		_columnBitmask = -1L;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getDossierId() {
		return _dossierId;
	}

	@Override
	public void setDossierId(long dossierId) {
		_columnBitmask |= DOSSIERID_COLUMN_BITMASK;

		if (!_setOriginalDossierId) {
			_setOriginalDossierId = true;

			_originalDossierId = _dossierId;
		}

		_dossierId = dossierId;
	}

	public long getOriginalDossierId() {
		return _originalDossierId;
	}

	@JSON
	@Override
	public long getFileGroupId() {
		return _fileGroupId;
	}

	@Override
	public void setFileGroupId(long fileGroupId) {
		_columnBitmask |= FILEGROUPID_COLUMN_BITMASK;

		if (!_setOriginalFileGroupId) {
			_setOriginalFileGroupId = true;

			_originalFileGroupId = _fileGroupId;
		}

		_fileGroupId = fileGroupId;
	}

	public long getOriginalFileGroupId() {
		return _originalFileGroupId;
	}

	@JSON
	@Override
	public int getDossierStatus() {
		return _dossierStatus;
	}

	@Override
	public void setDossierStatus(int dossierStatus) {
		_dossierStatus = dossierStatus;
	}

	@JSON
	@Override
	public String getActionInfo() {
		if (_actionInfo == null) {
			return StringPool.BLANK;
		}
		else {
			return _actionInfo;
		}
	}

	@Override
	public void setActionInfo(String actionInfo) {
		_actionInfo = actionInfo;
	}

	@JSON
	@Override
	public String getMessageInfo() {
		if (_messageInfo == null) {
			return StringPool.BLANK;
		}
		else {
			return _messageInfo;
		}
	}

	@Override
	public void setMessageInfo(String messageInfo) {
		_messageInfo = messageInfo;
	}

	@JSON
	@Override
	public Date getUpdateDatetime() {
		return _updateDatetime;
	}

	@Override
	public void setUpdateDatetime(Date updateDatetime) {
		_updateDatetime = updateDatetime;
	}

	@JSON
	@Override
	public int getSyncStatus() {
		return _syncStatus;
	}

	@Override
	public void setSyncStatus(int syncStatus) {
		_syncStatus = syncStatus;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			DossierStatus.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DossierStatus toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (DossierStatus)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DossierStatusImpl dossierStatusImpl = new DossierStatusImpl();

		dossierStatusImpl.setDossierStatusId(getDossierStatusId());
		dossierStatusImpl.setCompanyId(getCompanyId());
		dossierStatusImpl.setGroupId(getGroupId());
		dossierStatusImpl.setUserId(getUserId());
		dossierStatusImpl.setCreateDate(getCreateDate());
		dossierStatusImpl.setModifiedDate(getModifiedDate());
		dossierStatusImpl.setDossierId(getDossierId());
		dossierStatusImpl.setFileGroupId(getFileGroupId());
		dossierStatusImpl.setDossierStatus(getDossierStatus());
		dossierStatusImpl.setActionInfo(getActionInfo());
		dossierStatusImpl.setMessageInfo(getMessageInfo());
		dossierStatusImpl.setUpdateDatetime(getUpdateDatetime());
		dossierStatusImpl.setSyncStatus(getSyncStatus());

		dossierStatusImpl.resetOriginalValues();

		return dossierStatusImpl;
	}

	@Override
	public int compareTo(DossierStatus dossierStatus) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				dossierStatus.getModifiedDate());

		value = value * -1;

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

		if (!(obj instanceof DossierStatus)) {
			return false;
		}

		DossierStatus dossierStatus = (DossierStatus)obj;

		long primaryKey = dossierStatus.getPrimaryKey();

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
		DossierStatusModelImpl dossierStatusModelImpl = this;

		dossierStatusModelImpl._originalDossierId = dossierStatusModelImpl._dossierId;

		dossierStatusModelImpl._setOriginalDossierId = false;

		dossierStatusModelImpl._originalFileGroupId = dossierStatusModelImpl._fileGroupId;

		dossierStatusModelImpl._setOriginalFileGroupId = false;

		dossierStatusModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DossierStatus> toCacheModel() {
		DossierStatusCacheModel dossierStatusCacheModel = new DossierStatusCacheModel();

		dossierStatusCacheModel.dossierStatusId = getDossierStatusId();

		dossierStatusCacheModel.companyId = getCompanyId();

		dossierStatusCacheModel.groupId = getGroupId();

		dossierStatusCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			dossierStatusCacheModel.createDate = createDate.getTime();
		}
		else {
			dossierStatusCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			dossierStatusCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			dossierStatusCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		dossierStatusCacheModel.dossierId = getDossierId();

		dossierStatusCacheModel.fileGroupId = getFileGroupId();

		dossierStatusCacheModel.dossierStatus = getDossierStatus();

		dossierStatusCacheModel.actionInfo = getActionInfo();

		String actionInfo = dossierStatusCacheModel.actionInfo;

		if ((actionInfo != null) && (actionInfo.length() == 0)) {
			dossierStatusCacheModel.actionInfo = null;
		}

		dossierStatusCacheModel.messageInfo = getMessageInfo();

		String messageInfo = dossierStatusCacheModel.messageInfo;

		if ((messageInfo != null) && (messageInfo.length() == 0)) {
			dossierStatusCacheModel.messageInfo = null;
		}

		Date updateDatetime = getUpdateDatetime();

		if (updateDatetime != null) {
			dossierStatusCacheModel.updateDatetime = updateDatetime.getTime();
		}
		else {
			dossierStatusCacheModel.updateDatetime = Long.MIN_VALUE;
		}

		dossierStatusCacheModel.syncStatus = getSyncStatus();

		return dossierStatusCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{dossierStatusId=");
		sb.append(getDossierStatusId());
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
		sb.append(", dossierId=");
		sb.append(getDossierId());
		sb.append(", fileGroupId=");
		sb.append(getFileGroupId());
		sb.append(", dossierStatus=");
		sb.append(getDossierStatus());
		sb.append(", actionInfo=");
		sb.append(getActionInfo());
		sb.append(", messageInfo=");
		sb.append(getMessageInfo());
		sb.append(", updateDatetime=");
		sb.append(getUpdateDatetime());
		sb.append(", syncStatus=");
		sb.append(getSyncStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("org.opencps.dossiermgt.model.DossierStatus");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>dossierStatusId</column-name><column-value><![CDATA[");
		sb.append(getDossierStatusId());
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
			"<column><column-name>dossierId</column-name><column-value><![CDATA[");
		sb.append(getDossierId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileGroupId</column-name><column-value><![CDATA[");
		sb.append(getFileGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierStatus</column-name><column-value><![CDATA[");
		sb.append(getDossierStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>actionInfo</column-name><column-value><![CDATA[");
		sb.append(getActionInfo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>messageInfo</column-name><column-value><![CDATA[");
		sb.append(getMessageInfo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updateDatetime</column-name><column-value><![CDATA[");
		sb.append(getUpdateDatetime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>syncStatus</column-name><column-value><![CDATA[");
		sb.append(getSyncStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = DossierStatus.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			DossierStatus.class
		};
	private long _dossierStatusId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private long _dossierId;
	private long _originalDossierId;
	private boolean _setOriginalDossierId;
	private long _fileGroupId;
	private long _originalFileGroupId;
	private boolean _setOriginalFileGroupId;
	private int _dossierStatus;
	private String _actionInfo;
	private String _messageInfo;
	private Date _updateDatetime;
	private int _syncStatus;
	private long _columnBitmask;
	private DossierStatus _escapedModel;
}