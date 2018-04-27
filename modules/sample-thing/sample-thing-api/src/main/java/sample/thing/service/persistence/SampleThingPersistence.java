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

package sample.thing.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import sample.thing.exception.NoSuchThingException;

import sample.thing.model.SampleThing;

/**
 * The persistence interface for the sample thing service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see sample.thing.service.persistence.impl.SampleThingPersistenceImpl
 * @see SampleThingUtil
 * @generated
 */
@ProviderType
public interface SampleThingPersistence extends BasePersistence<SampleThing> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SampleThingUtil} to access the sample thing persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the sample things where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching sample things
	*/
	public java.util.List<SampleThing> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the sample things where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SampleThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of sample things
	* @param end the upper bound of the range of sample things (not inclusive)
	* @return the range of matching sample things
	*/
	public java.util.List<SampleThing> findByUuid(java.lang.String uuid,
		int start, int end);

	/**
	* Returns an ordered range of all the sample things where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SampleThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of sample things
	* @param end the upper bound of the range of sample things (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sample things
	*/
	public java.util.List<SampleThing> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleThing> orderByComparator);

	/**
	* Returns an ordered range of all the sample things where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SampleThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of sample things
	* @param end the upper bound of the range of sample things (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching sample things
	*/
	public java.util.List<SampleThing> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleThing> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first sample thing in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sample thing
	* @throws NoSuchThingException if a matching sample thing could not be found
	*/
	public SampleThing findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SampleThing> orderByComparator)
		throws NoSuchThingException;

	/**
	* Returns the first sample thing in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sample thing, or <code>null</code> if a matching sample thing could not be found
	*/
	public SampleThing fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SampleThing> orderByComparator);

	/**
	* Returns the last sample thing in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sample thing
	* @throws NoSuchThingException if a matching sample thing could not be found
	*/
	public SampleThing findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SampleThing> orderByComparator)
		throws NoSuchThingException;

	/**
	* Returns the last sample thing in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sample thing, or <code>null</code> if a matching sample thing could not be found
	*/
	public SampleThing fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SampleThing> orderByComparator);

	/**
	* Returns the sample things before and after the current sample thing in the ordered set where uuid = &#63;.
	*
	* @param sampleId the primary key of the current sample thing
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sample thing
	* @throws NoSuchThingException if a sample thing with the primary key could not be found
	*/
	public SampleThing[] findByUuid_PrevAndNext(long sampleId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SampleThing> orderByComparator)
		throws NoSuchThingException;

	/**
	* Removes all the sample things where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of sample things where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching sample things
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the sample thing where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchThingException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching sample thing
	* @throws NoSuchThingException if a matching sample thing could not be found
	*/
	public SampleThing findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchThingException;

	/**
	* Returns the sample thing where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching sample thing, or <code>null</code> if a matching sample thing could not be found
	*/
	public SampleThing fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the sample thing where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching sample thing, or <code>null</code> if a matching sample thing could not be found
	*/
	public SampleThing fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the sample thing where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the sample thing that was removed
	*/
	public SampleThing removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchThingException;

	/**
	* Returns the number of sample things where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching sample things
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the sample things where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching sample things
	*/
	public java.util.List<SampleThing> findByUuid_C(java.lang.String uuid,
		long companyId);

	/**
	* Returns a range of all the sample things where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SampleThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of sample things
	* @param end the upper bound of the range of sample things (not inclusive)
	* @return the range of matching sample things
	*/
	public java.util.List<SampleThing> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

	/**
	* Returns an ordered range of all the sample things where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SampleThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of sample things
	* @param end the upper bound of the range of sample things (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sample things
	*/
	public java.util.List<SampleThing> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleThing> orderByComparator);

	/**
	* Returns an ordered range of all the sample things where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SampleThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of sample things
	* @param end the upper bound of the range of sample things (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching sample things
	*/
	public java.util.List<SampleThing> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleThing> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first sample thing in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sample thing
	* @throws NoSuchThingException if a matching sample thing could not be found
	*/
	public SampleThing findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SampleThing> orderByComparator)
		throws NoSuchThingException;

	/**
	* Returns the first sample thing in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sample thing, or <code>null</code> if a matching sample thing could not be found
	*/
	public SampleThing fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SampleThing> orderByComparator);

	/**
	* Returns the last sample thing in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sample thing
	* @throws NoSuchThingException if a matching sample thing could not be found
	*/
	public SampleThing findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SampleThing> orderByComparator)
		throws NoSuchThingException;

	/**
	* Returns the last sample thing in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sample thing, or <code>null</code> if a matching sample thing could not be found
	*/
	public SampleThing fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SampleThing> orderByComparator);

	/**
	* Returns the sample things before and after the current sample thing in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param sampleId the primary key of the current sample thing
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sample thing
	* @throws NoSuchThingException if a sample thing with the primary key could not be found
	*/
	public SampleThing[] findByUuid_C_PrevAndNext(long sampleId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SampleThing> orderByComparator)
		throws NoSuchThingException;

	/**
	* Removes all the sample things where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of sample things where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching sample things
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the sample things where someString = &#63;.
	*
	* @param someString the some string
	* @return the matching sample things
	*/
	public java.util.List<SampleThing> findBySomeString(
		java.lang.String someString);

	/**
	* Returns a range of all the sample things where someString = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SampleThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param someString the some string
	* @param start the lower bound of the range of sample things
	* @param end the upper bound of the range of sample things (not inclusive)
	* @return the range of matching sample things
	*/
	public java.util.List<SampleThing> findBySomeString(
		java.lang.String someString, int start, int end);

	/**
	* Returns an ordered range of all the sample things where someString = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SampleThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param someString the some string
	* @param start the lower bound of the range of sample things
	* @param end the upper bound of the range of sample things (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sample things
	*/
	public java.util.List<SampleThing> findBySomeString(
		java.lang.String someString, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleThing> orderByComparator);

	/**
	* Returns an ordered range of all the sample things where someString = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SampleThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param someString the some string
	* @param start the lower bound of the range of sample things
	* @param end the upper bound of the range of sample things (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching sample things
	*/
	public java.util.List<SampleThing> findBySomeString(
		java.lang.String someString, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleThing> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first sample thing in the ordered set where someString = &#63;.
	*
	* @param someString the some string
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sample thing
	* @throws NoSuchThingException if a matching sample thing could not be found
	*/
	public SampleThing findBySomeString_First(java.lang.String someString,
		com.liferay.portal.kernel.util.OrderByComparator<SampleThing> orderByComparator)
		throws NoSuchThingException;

	/**
	* Returns the first sample thing in the ordered set where someString = &#63;.
	*
	* @param someString the some string
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sample thing, or <code>null</code> if a matching sample thing could not be found
	*/
	public SampleThing fetchBySomeString_First(java.lang.String someString,
		com.liferay.portal.kernel.util.OrderByComparator<SampleThing> orderByComparator);

	/**
	* Returns the last sample thing in the ordered set where someString = &#63;.
	*
	* @param someString the some string
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sample thing
	* @throws NoSuchThingException if a matching sample thing could not be found
	*/
	public SampleThing findBySomeString_Last(java.lang.String someString,
		com.liferay.portal.kernel.util.OrderByComparator<SampleThing> orderByComparator)
		throws NoSuchThingException;

	/**
	* Returns the last sample thing in the ordered set where someString = &#63;.
	*
	* @param someString the some string
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sample thing, or <code>null</code> if a matching sample thing could not be found
	*/
	public SampleThing fetchBySomeString_Last(java.lang.String someString,
		com.liferay.portal.kernel.util.OrderByComparator<SampleThing> orderByComparator);

	/**
	* Returns the sample things before and after the current sample thing in the ordered set where someString = &#63;.
	*
	* @param sampleId the primary key of the current sample thing
	* @param someString the some string
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sample thing
	* @throws NoSuchThingException if a sample thing with the primary key could not be found
	*/
	public SampleThing[] findBySomeString_PrevAndNext(long sampleId,
		java.lang.String someString,
		com.liferay.portal.kernel.util.OrderByComparator<SampleThing> orderByComparator)
		throws NoSuchThingException;

	/**
	* Removes all the sample things where someString = &#63; from the database.
	*
	* @param someString the some string
	*/
	public void removeBySomeString(java.lang.String someString);

	/**
	* Returns the number of sample things where someString = &#63;.
	*
	* @param someString the some string
	* @return the number of matching sample things
	*/
	public int countBySomeString(java.lang.String someString);

	/**
	* Caches the sample thing in the entity cache if it is enabled.
	*
	* @param sampleThing the sample thing
	*/
	public void cacheResult(SampleThing sampleThing);

	/**
	* Caches the sample things in the entity cache if it is enabled.
	*
	* @param sampleThings the sample things
	*/
	public void cacheResult(java.util.List<SampleThing> sampleThings);

	/**
	* Creates a new sample thing with the primary key. Does not add the sample thing to the database.
	*
	* @param sampleId the primary key for the new sample thing
	* @return the new sample thing
	*/
	public SampleThing create(long sampleId);

	/**
	* Removes the sample thing with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sampleId the primary key of the sample thing
	* @return the sample thing that was removed
	* @throws NoSuchThingException if a sample thing with the primary key could not be found
	*/
	public SampleThing remove(long sampleId) throws NoSuchThingException;

	public SampleThing updateImpl(SampleThing sampleThing);

	/**
	* Returns the sample thing with the primary key or throws a {@link NoSuchThingException} if it could not be found.
	*
	* @param sampleId the primary key of the sample thing
	* @return the sample thing
	* @throws NoSuchThingException if a sample thing with the primary key could not be found
	*/
	public SampleThing findByPrimaryKey(long sampleId)
		throws NoSuchThingException;

	/**
	* Returns the sample thing with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param sampleId the primary key of the sample thing
	* @return the sample thing, or <code>null</code> if a sample thing with the primary key could not be found
	*/
	public SampleThing fetchByPrimaryKey(long sampleId);

	@Override
	public java.util.Map<java.io.Serializable, SampleThing> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the sample things.
	*
	* @return the sample things
	*/
	public java.util.List<SampleThing> findAll();

	/**
	* Returns a range of all the sample things.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SampleThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sample things
	* @param end the upper bound of the range of sample things (not inclusive)
	* @return the range of sample things
	*/
	public java.util.List<SampleThing> findAll(int start, int end);

	/**
	* Returns an ordered range of all the sample things.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SampleThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sample things
	* @param end the upper bound of the range of sample things (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of sample things
	*/
	public java.util.List<SampleThing> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleThing> orderByComparator);

	/**
	* Returns an ordered range of all the sample things.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SampleThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sample things
	* @param end the upper bound of the range of sample things (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of sample things
	*/
	public java.util.List<SampleThing> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleThing> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the sample things from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of sample things.
	*
	* @return the number of sample things
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}