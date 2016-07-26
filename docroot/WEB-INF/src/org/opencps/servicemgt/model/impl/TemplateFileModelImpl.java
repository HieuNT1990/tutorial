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

import org.opencps.servicemgt.model.TemplateFile;
import org.opencps.servicemgt.model.TemplateFileModel;
import org.opencps.servicemgt.model.TemplateFileSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the TemplateFile service. Represents a row in the &quot;opencps_templatefile&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.opencps.servicemgt.model.TemplateFileModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TemplateFileImpl}.
 * </p>
 *
 * @author khoavd
 * @see TemplateFileImpl
 * @see org.opencps.servicemgt.model.TemplateFile
 * @see org.opencps.servicemgt.model.TemplateFileModel
 * @generated
 */
@JSON(strict = true)
public class TemplateFileModelImpl extends BaseModelImpl<TemplateFile>
	implements TemplateFileModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a template file model instance should use the {@link org.opencps.servicemgt.model.TemplateFile} interface instead.
	 */
	public static final String TABLE_NAME = "opencps_templatefile";
	public static final Object[][] TABLE_COLUMNS = {
			{ "templatefileId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "fileName", Types.VARCHAR },
			{ "fileNo", Types.VARCHAR },
			{ "fileEntryId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table opencps_templatefile (templatefileId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,fileName VARCHAR(75) null,fileNo VARCHAR(75) null,fileEntryId LONG)";
	public static final String TABLE_SQL_DROP = "drop table opencps_templatefile";
	public static final String ORDER_BY_JPQL = " ORDER BY templateFile.templatefileId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY opencps_templatefile.templatefileId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.opencps.servicemgt.model.TemplateFile"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.opencps.servicemgt.model.TemplateFile"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.opencps.servicemgt.model.TemplateFile"),
			true);
	public static long FILENAME_COLUMN_BITMASK = 1L;
	public static long FILENO_COLUMN_BITMASK = 2L;
	public static long GROUPID_COLUMN_BITMASK = 4L;
	public static long TEMPLATEFILEID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static TemplateFile toModel(TemplateFileSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		TemplateFile model = new TemplateFileImpl();

		model.setTemplatefileId(soapModel.getTemplatefileId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setFileName(soapModel.getFileName());
		model.setFileNo(soapModel.getFileNo());
		model.setFileEntryId(soapModel.getFileEntryId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<TemplateFile> toModels(TemplateFileSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<TemplateFile> models = new ArrayList<TemplateFile>(soapModels.length);

		for (TemplateFileSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.opencps.servicemgt.model.TemplateFile"));

	public TemplateFileModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _templatefileId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTemplatefileId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _templatefileId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return TemplateFile.class;
	}

	@Override
	public String getModelClassName() {
		return TemplateFile.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("templatefileId", getTemplatefileId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("fileName", getFileName());
		attributes.put("fileNo", getFileNo());
		attributes.put("fileEntryId", getFileEntryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long templatefileId = (Long)attributes.get("templatefileId");

		if (templatefileId != null) {
			setTemplatefileId(templatefileId);
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

		String fileName = (String)attributes.get("fileName");

		if (fileName != null) {
			setFileName(fileName);
		}

		String fileNo = (String)attributes.get("fileNo");

		if (fileNo != null) {
			setFileNo(fileNo);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}
	}

	@JSON
	@Override
	public long getTemplatefileId() {
		return _templatefileId;
	}

	@Override
	public void setTemplatefileId(long templatefileId) {
		_templatefileId = templatefileId;
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
	public String getFileName() {
		if (_fileName == null) {
			return StringPool.BLANK;
		}
		else {
			return _fileName;
		}
	}

	@Override
	public void setFileName(String fileName) {
		_columnBitmask |= FILENAME_COLUMN_BITMASK;

		if (_originalFileName == null) {
			_originalFileName = _fileName;
		}

		_fileName = fileName;
	}

	public String getOriginalFileName() {
		return GetterUtil.getString(_originalFileName);
	}

	@JSON
	@Override
	public String getFileNo() {
		if (_fileNo == null) {
			return StringPool.BLANK;
		}
		else {
			return _fileNo;
		}
	}

	@Override
	public void setFileNo(String fileNo) {
		_columnBitmask |= FILENO_COLUMN_BITMASK;

		if (_originalFileNo == null) {
			_originalFileNo = _fileNo;
		}

		_fileNo = fileNo;
	}

	public String getOriginalFileNo() {
		return GetterUtil.getString(_originalFileNo);
	}

	@JSON
	@Override
	public long getFileEntryId() {
		return _fileEntryId;
	}

	@Override
	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			TemplateFile.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TemplateFile toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (TemplateFile)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TemplateFileImpl templateFileImpl = new TemplateFileImpl();

		templateFileImpl.setTemplatefileId(getTemplatefileId());
		templateFileImpl.setCompanyId(getCompanyId());
		templateFileImpl.setGroupId(getGroupId());
		templateFileImpl.setUserId(getUserId());
		templateFileImpl.setCreateDate(getCreateDate());
		templateFileImpl.setModifiedDate(getModifiedDate());
		templateFileImpl.setFileName(getFileName());
		templateFileImpl.setFileNo(getFileNo());
		templateFileImpl.setFileEntryId(getFileEntryId());

		templateFileImpl.resetOriginalValues();

		return templateFileImpl;
	}

	@Override
	public int compareTo(TemplateFile templateFile) {
		long primaryKey = templateFile.getPrimaryKey();

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

		if (!(obj instanceof TemplateFile)) {
			return false;
		}

		TemplateFile templateFile = (TemplateFile)obj;

		long primaryKey = templateFile.getPrimaryKey();

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
		TemplateFileModelImpl templateFileModelImpl = this;

		templateFileModelImpl._originalGroupId = templateFileModelImpl._groupId;

		templateFileModelImpl._setOriginalGroupId = false;

		templateFileModelImpl._originalFileName = templateFileModelImpl._fileName;

		templateFileModelImpl._originalFileNo = templateFileModelImpl._fileNo;

		templateFileModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<TemplateFile> toCacheModel() {
		TemplateFileCacheModel templateFileCacheModel = new TemplateFileCacheModel();

		templateFileCacheModel.templatefileId = getTemplatefileId();

		templateFileCacheModel.companyId = getCompanyId();

		templateFileCacheModel.groupId = getGroupId();

		templateFileCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			templateFileCacheModel.createDate = createDate.getTime();
		}
		else {
			templateFileCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			templateFileCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			templateFileCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		templateFileCacheModel.fileName = getFileName();

		String fileName = templateFileCacheModel.fileName;

		if ((fileName != null) && (fileName.length() == 0)) {
			templateFileCacheModel.fileName = null;
		}

		templateFileCacheModel.fileNo = getFileNo();

		String fileNo = templateFileCacheModel.fileNo;

		if ((fileNo != null) && (fileNo.length() == 0)) {
			templateFileCacheModel.fileNo = null;
		}

		templateFileCacheModel.fileEntryId = getFileEntryId();

		return templateFileCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{templatefileId=");
		sb.append(getTemplatefileId());
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
		sb.append(", fileName=");
		sb.append(getFileName());
		sb.append(", fileNo=");
		sb.append(getFileNo());
		sb.append(", fileEntryId=");
		sb.append(getFileEntryId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("org.opencps.servicemgt.model.TemplateFile");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>templatefileId</column-name><column-value><![CDATA[");
		sb.append(getTemplatefileId());
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
			"<column><column-name>fileName</column-name><column-value><![CDATA[");
		sb.append(getFileName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileNo</column-name><column-value><![CDATA[");
		sb.append(getFileNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileEntryId</column-name><column-value><![CDATA[");
		sb.append(getFileEntryId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = TemplateFile.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			TemplateFile.class
		};
	private long _templatefileId;
	private long _companyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _fileName;
	private String _originalFileName;
	private String _fileNo;
	private String _originalFileNo;
	private long _fileEntryId;
	private long _columnBitmask;
	private TemplateFile _escapedModel;
}