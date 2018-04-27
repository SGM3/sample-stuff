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

package sample.thing.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import sample.thing.model.SampleThing;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SampleThing in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see SampleThing
 * @generated
 */
@ProviderType
public class SampleThingCacheModel implements CacheModel<SampleThing>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SampleThingCacheModel)) {
			return false;
		}

		SampleThingCacheModel sampleThingCacheModel = (SampleThingCacheModel)obj;

		if (sampleId == sampleThingCacheModel.sampleId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, sampleId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", sampleId=");
		sb.append(sampleId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", someString=");
		sb.append(someString);
		sb.append(", someBoolean=");
		sb.append(someBoolean);
		sb.append(", someInt=");
		sb.append(someInt);
		sb.append(", someDate=");
		sb.append(someDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SampleThing toEntityModel() {
		SampleThingImpl sampleThingImpl = new SampleThingImpl();

		if (uuid == null) {
			sampleThingImpl.setUuid(StringPool.BLANK);
		}
		else {
			sampleThingImpl.setUuid(uuid);
		}

		sampleThingImpl.setSampleId(sampleId);
		sampleThingImpl.setGroupId(groupId);
		sampleThingImpl.setCompanyId(companyId);
		sampleThingImpl.setUserId(userId);

		if (userName == null) {
			sampleThingImpl.setUserName(StringPool.BLANK);
		}
		else {
			sampleThingImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			sampleThingImpl.setCreateDate(null);
		}
		else {
			sampleThingImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			sampleThingImpl.setModifiedDate(null);
		}
		else {
			sampleThingImpl.setModifiedDate(new Date(modifiedDate));
		}

		sampleThingImpl.setStatus(status);
		sampleThingImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			sampleThingImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			sampleThingImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			sampleThingImpl.setStatusDate(null);
		}
		else {
			sampleThingImpl.setStatusDate(new Date(statusDate));
		}

		if (someString == null) {
			sampleThingImpl.setSomeString(StringPool.BLANK);
		}
		else {
			sampleThingImpl.setSomeString(someString);
		}

		sampleThingImpl.setSomeBoolean(someBoolean);
		sampleThingImpl.setSomeInt(someInt);

		if (someDate == Long.MIN_VALUE) {
			sampleThingImpl.setSomeDate(null);
		}
		else {
			sampleThingImpl.setSomeDate(new Date(someDate));
		}

		sampleThingImpl.resetOriginalValues();

		return sampleThingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		sampleId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		someString = objectInput.readUTF();

		someBoolean = objectInput.readBoolean();

		someInt = objectInput.readInt();
		someDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(sampleId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		if (someString == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(someString);
		}

		objectOutput.writeBoolean(someBoolean);

		objectOutput.writeInt(someInt);
		objectOutput.writeLong(someDate);
	}

	public String uuid;
	public long sampleId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public String someString;
	public boolean someBoolean;
	public int someInt;
	public long someDate;
}