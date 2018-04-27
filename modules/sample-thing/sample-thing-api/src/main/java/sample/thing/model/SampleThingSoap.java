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

package sample.thing.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class SampleThingSoap implements Serializable {
	public static SampleThingSoap toSoapModel(SampleThing model) {
		SampleThingSoap soapModel = new SampleThingSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSampleId(model.getSampleId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setSomeString(model.getSomeString());
		soapModel.setSomeBoolean(model.getSomeBoolean());
		soapModel.setSomeInt(model.getSomeInt());
		soapModel.setSomeDate(model.getSomeDate());

		return soapModel;
	}

	public static SampleThingSoap[] toSoapModels(SampleThing[] models) {
		SampleThingSoap[] soapModels = new SampleThingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SampleThingSoap[][] toSoapModels(SampleThing[][] models) {
		SampleThingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SampleThingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SampleThingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SampleThingSoap[] toSoapModels(List<SampleThing> models) {
		List<SampleThingSoap> soapModels = new ArrayList<SampleThingSoap>(models.size());

		for (SampleThing model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SampleThingSoap[soapModels.size()]);
	}

	public SampleThingSoap() {
	}

	public long getPrimaryKey() {
		return _sampleId;
	}

	public void setPrimaryKey(long pk) {
		setSampleId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSampleId() {
		return _sampleId;
	}

	public void setSampleId(long sampleId) {
		_sampleId = sampleId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public String getSomeString() {
		return _someString;
	}

	public void setSomeString(String someString) {
		_someString = someString;
	}

	public boolean getSomeBoolean() {
		return _someBoolean;
	}

	public boolean isSomeBoolean() {
		return _someBoolean;
	}

	public void setSomeBoolean(boolean someBoolean) {
		_someBoolean = someBoolean;
	}

	public int getSomeInt() {
		return _someInt;
	}

	public void setSomeInt(int someInt) {
		_someInt = someInt;
	}

	public Date getSomeDate() {
		return _someDate;
	}

	public void setSomeDate(Date someDate) {
		_someDate = someDate;
	}

	private String _uuid;
	private long _sampleId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private String _someString;
	private boolean _someBoolean;
	private int _someInt;
	private Date _someDate;
}