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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link SampleThing}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SampleThing
 * @generated
 */
@ProviderType
public class SampleThingWrapper implements SampleThing,
	ModelWrapper<SampleThing> {
	public SampleThingWrapper(SampleThing sampleThing) {
		_sampleThing = sampleThing;
	}

	@Override
	public Class<?> getModelClass() {
		return SampleThing.class;
	}

	@Override
	public String getModelClassName() {
		return SampleThing.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("sampleId", getSampleId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("someString", getSomeString());
		attributes.put("someBoolean", getSomeBoolean());
		attributes.put("someInt", getSomeInt());
		attributes.put("someDate", getSomeDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long sampleId = (Long)attributes.get("sampleId");

		if (sampleId != null) {
			setSampleId(sampleId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		String someString = (String)attributes.get("someString");

		if (someString != null) {
			setSomeString(someString);
		}

		Boolean someBoolean = (Boolean)attributes.get("someBoolean");

		if (someBoolean != null) {
			setSomeBoolean(someBoolean);
		}

		Integer someInt = (Integer)attributes.get("someInt");

		if (someInt != null) {
			setSomeInt(someInt);
		}

		Date someDate = (Date)attributes.get("someDate");

		if (someDate != null) {
			setSomeDate(someDate);
		}
	}

	@Override
	public java.lang.Object clone() {
		return new SampleThingWrapper((SampleThing)_sampleThing.clone());
	}

	@Override
	public int compareTo(SampleThing sampleThing) {
		return _sampleThing.compareTo(sampleThing);
	}

	/**
	* Returns the company ID of this sample thing.
	*
	* @return the company ID of this sample thing
	*/
	@Override
	public long getCompanyId() {
		return _sampleThing.getCompanyId();
	}

	/**
	* Returns the create date of this sample thing.
	*
	* @return the create date of this sample thing
	*/
	@Override
	public Date getCreateDate() {
		return _sampleThing.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _sampleThing.getExpandoBridge();
	}

	/**
	* Returns the group ID of this sample thing.
	*
	* @return the group ID of this sample thing
	*/
	@Override
	public long getGroupId() {
		return _sampleThing.getGroupId();
	}

	/**
	* Returns the modified date of this sample thing.
	*
	* @return the modified date of this sample thing
	*/
	@Override
	public Date getModifiedDate() {
		return _sampleThing.getModifiedDate();
	}

	/**
	* Returns the primary key of this sample thing.
	*
	* @return the primary key of this sample thing
	*/
	@Override
	public long getPrimaryKey() {
		return _sampleThing.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _sampleThing.getPrimaryKeyObj();
	}

	/**
	* Returns the sample ID of this sample thing.
	*
	* @return the sample ID of this sample thing
	*/
	@Override
	public long getSampleId() {
		return _sampleThing.getSampleId();
	}

	/**
	* Returns the some boolean of this sample thing.
	*
	* @return the some boolean of this sample thing
	*/
	@Override
	public boolean getSomeBoolean() {
		return _sampleThing.getSomeBoolean();
	}

	/**
	* Returns the some date of this sample thing.
	*
	* @return the some date of this sample thing
	*/
	@Override
	public Date getSomeDate() {
		return _sampleThing.getSomeDate();
	}

	/**
	* Returns the some int of this sample thing.
	*
	* @return the some int of this sample thing
	*/
	@Override
	public int getSomeInt() {
		return _sampleThing.getSomeInt();
	}

	/**
	* Returns the some string of this sample thing.
	*
	* @return the some string of this sample thing
	*/
	@Override
	public java.lang.String getSomeString() {
		return _sampleThing.getSomeString();
	}

	/**
	* Returns the status of this sample thing.
	*
	* @return the status of this sample thing
	*/
	@Override
	public int getStatus() {
		return _sampleThing.getStatus();
	}

	/**
	* Returns the status by user ID of this sample thing.
	*
	* @return the status by user ID of this sample thing
	*/
	@Override
	public long getStatusByUserId() {
		return _sampleThing.getStatusByUserId();
	}

	/**
	* Returns the status by user name of this sample thing.
	*
	* @return the status by user name of this sample thing
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _sampleThing.getStatusByUserName();
	}

	/**
	* Returns the status by user uuid of this sample thing.
	*
	* @return the status by user uuid of this sample thing
	*/
	@Override
	public java.lang.String getStatusByUserUuid() {
		return _sampleThing.getStatusByUserUuid();
	}

	/**
	* Returns the status date of this sample thing.
	*
	* @return the status date of this sample thing
	*/
	@Override
	public Date getStatusDate() {
		return _sampleThing.getStatusDate();
	}

	/**
	* Returns the user ID of this sample thing.
	*
	* @return the user ID of this sample thing
	*/
	@Override
	public long getUserId() {
		return _sampleThing.getUserId();
	}

	/**
	* Returns the user name of this sample thing.
	*
	* @return the user name of this sample thing
	*/
	@Override
	public java.lang.String getUserName() {
		return _sampleThing.getUserName();
	}

	/**
	* Returns the user uuid of this sample thing.
	*
	* @return the user uuid of this sample thing
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _sampleThing.getUserUuid();
	}

	/**
	* Returns the uuid of this sample thing.
	*
	* @return the uuid of this sample thing
	*/
	@Override
	public java.lang.String getUuid() {
		return _sampleThing.getUuid();
	}

	@Override
	public int hashCode() {
		return _sampleThing.hashCode();
	}

	/**
	* Returns <code>true</code> if this sample thing is approved.
	*
	* @return <code>true</code> if this sample thing is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _sampleThing.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _sampleThing.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this sample thing is denied.
	*
	* @return <code>true</code> if this sample thing is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _sampleThing.isDenied();
	}

	/**
	* Returns <code>true</code> if this sample thing is a draft.
	*
	* @return <code>true</code> if this sample thing is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _sampleThing.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _sampleThing.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this sample thing is expired.
	*
	* @return <code>true</code> if this sample thing is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _sampleThing.isExpired();
	}

	/**
	* Returns <code>true</code> if this sample thing is inactive.
	*
	* @return <code>true</code> if this sample thing is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _sampleThing.isInactive();
	}

	/**
	* Returns <code>true</code> if this sample thing is incomplete.
	*
	* @return <code>true</code> if this sample thing is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _sampleThing.isIncomplete();
	}

	@Override
	public boolean isNew() {
		return _sampleThing.isNew();
	}

	/**
	* Returns <code>true</code> if this sample thing is pending.
	*
	* @return <code>true</code> if this sample thing is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _sampleThing.isPending();
	}

	/**
	* Returns <code>true</code> if this sample thing is scheduled.
	*
	* @return <code>true</code> if this sample thing is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _sampleThing.isScheduled();
	}

	/**
	* Returns <code>true</code> if this sample thing is some boolean.
	*
	* @return <code>true</code> if this sample thing is some boolean; <code>false</code> otherwise
	*/
	@Override
	public boolean isSomeBoolean() {
		return _sampleThing.isSomeBoolean();
	}

	@Override
	public void persist() {
		_sampleThing.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_sampleThing.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this sample thing.
	*
	* @param companyId the company ID of this sample thing
	*/
	@Override
	public void setCompanyId(long companyId) {
		_sampleThing.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this sample thing.
	*
	* @param createDate the create date of this sample thing
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_sampleThing.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_sampleThing.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_sampleThing.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_sampleThing.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this sample thing.
	*
	* @param groupId the group ID of this sample thing
	*/
	@Override
	public void setGroupId(long groupId) {
		_sampleThing.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this sample thing.
	*
	* @param modifiedDate the modified date of this sample thing
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_sampleThing.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_sampleThing.setNew(n);
	}

	/**
	* Sets the primary key of this sample thing.
	*
	* @param primaryKey the primary key of this sample thing
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_sampleThing.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_sampleThing.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the sample ID of this sample thing.
	*
	* @param sampleId the sample ID of this sample thing
	*/
	@Override
	public void setSampleId(long sampleId) {
		_sampleThing.setSampleId(sampleId);
	}

	/**
	* Sets whether this sample thing is some boolean.
	*
	* @param someBoolean the some boolean of this sample thing
	*/
	@Override
	public void setSomeBoolean(boolean someBoolean) {
		_sampleThing.setSomeBoolean(someBoolean);
	}

	/**
	* Sets the some date of this sample thing.
	*
	* @param someDate the some date of this sample thing
	*/
	@Override
	public void setSomeDate(Date someDate) {
		_sampleThing.setSomeDate(someDate);
	}

	/**
	* Sets the some int of this sample thing.
	*
	* @param someInt the some int of this sample thing
	*/
	@Override
	public void setSomeInt(int someInt) {
		_sampleThing.setSomeInt(someInt);
	}

	/**
	* Sets the some string of this sample thing.
	*
	* @param someString the some string of this sample thing
	*/
	@Override
	public void setSomeString(java.lang.String someString) {
		_sampleThing.setSomeString(someString);
	}

	/**
	* Sets the status of this sample thing.
	*
	* @param status the status of this sample thing
	*/
	@Override
	public void setStatus(int status) {
		_sampleThing.setStatus(status);
	}

	/**
	* Sets the status by user ID of this sample thing.
	*
	* @param statusByUserId the status by user ID of this sample thing
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_sampleThing.setStatusByUserId(statusByUserId);
	}

	/**
	* Sets the status by user name of this sample thing.
	*
	* @param statusByUserName the status by user name of this sample thing
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_sampleThing.setStatusByUserName(statusByUserName);
	}

	/**
	* Sets the status by user uuid of this sample thing.
	*
	* @param statusByUserUuid the status by user uuid of this sample thing
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_sampleThing.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Sets the status date of this sample thing.
	*
	* @param statusDate the status date of this sample thing
	*/
	@Override
	public void setStatusDate(Date statusDate) {
		_sampleThing.setStatusDate(statusDate);
	}

	/**
	* Sets the user ID of this sample thing.
	*
	* @param userId the user ID of this sample thing
	*/
	@Override
	public void setUserId(long userId) {
		_sampleThing.setUserId(userId);
	}

	/**
	* Sets the user name of this sample thing.
	*
	* @param userName the user name of this sample thing
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_sampleThing.setUserName(userName);
	}

	/**
	* Sets the user uuid of this sample thing.
	*
	* @param userUuid the user uuid of this sample thing
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_sampleThing.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this sample thing.
	*
	* @param uuid the uuid of this sample thing
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_sampleThing.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<SampleThing> toCacheModel() {
		return _sampleThing.toCacheModel();
	}

	@Override
	public SampleThing toEscapedModel() {
		return new SampleThingWrapper(_sampleThing.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _sampleThing.toString();
	}

	@Override
	public SampleThing toUnescapedModel() {
		return new SampleThingWrapper(_sampleThing.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _sampleThing.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SampleThingWrapper)) {
			return false;
		}

		SampleThingWrapper sampleThingWrapper = (SampleThingWrapper)obj;

		if (Objects.equals(_sampleThing, sampleThingWrapper._sampleThing)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _sampleThing.getStagedModelType();
	}

	@Override
	public SampleThing getWrappedModel() {
		return _sampleThing;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _sampleThing.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _sampleThing.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_sampleThing.resetOriginalValues();
	}

	private final SampleThing _sampleThing;
}