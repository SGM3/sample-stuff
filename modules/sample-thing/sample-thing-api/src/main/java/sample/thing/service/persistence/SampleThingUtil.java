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

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import sample.thing.model.SampleThing;

import java.util.List;

/**
 * The persistence utility for the sample thing service. This utility wraps {@link sample.thing.service.persistence.impl.SampleThingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SampleThingPersistence
 * @see sample.thing.service.persistence.impl.SampleThingPersistenceImpl
 * @generated
 */
@ProviderType
public class SampleThingUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(SampleThing sampleThing) {
		getPersistence().clearCache(sampleThing);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SampleThing> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SampleThing> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SampleThing> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SampleThing> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SampleThing update(SampleThing sampleThing) {
		return getPersistence().update(sampleThing);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SampleThing update(SampleThing sampleThing,
		ServiceContext serviceContext) {
		return getPersistence().update(sampleThing, serviceContext);
	}

	/**
	* Returns all the sample things where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching sample things
	*/
	public static List<SampleThing> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<SampleThing> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<SampleThing> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<SampleThing> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<SampleThing> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<SampleThing> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first sample thing in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sample thing
	* @throws NoSuchThingException if a matching sample thing could not be found
	*/
	public static SampleThing findByUuid_First(java.lang.String uuid,
		OrderByComparator<SampleThing> orderByComparator)
		throws sample.thing.exception.NoSuchThingException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first sample thing in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sample thing, or <code>null</code> if a matching sample thing could not be found
	*/
	public static SampleThing fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<SampleThing> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last sample thing in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sample thing
	* @throws NoSuchThingException if a matching sample thing could not be found
	*/
	public static SampleThing findByUuid_Last(java.lang.String uuid,
		OrderByComparator<SampleThing> orderByComparator)
		throws sample.thing.exception.NoSuchThingException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last sample thing in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sample thing, or <code>null</code> if a matching sample thing could not be found
	*/
	public static SampleThing fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<SampleThing> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the sample things before and after the current sample thing in the ordered set where uuid = &#63;.
	*
	* @param sampleId the primary key of the current sample thing
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sample thing
	* @throws NoSuchThingException if a sample thing with the primary key could not be found
	*/
	public static SampleThing[] findByUuid_PrevAndNext(long sampleId,
		java.lang.String uuid, OrderByComparator<SampleThing> orderByComparator)
		throws sample.thing.exception.NoSuchThingException {
		return getPersistence()
				   .findByUuid_PrevAndNext(sampleId, uuid, orderByComparator);
	}

	/**
	* Removes all the sample things where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of sample things where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching sample things
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the sample thing where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchThingException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching sample thing
	* @throws NoSuchThingException if a matching sample thing could not be found
	*/
	public static SampleThing findByUUID_G(java.lang.String uuid, long groupId)
		throws sample.thing.exception.NoSuchThingException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the sample thing where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching sample thing, or <code>null</code> if a matching sample thing could not be found
	*/
	public static SampleThing fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the sample thing where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching sample thing, or <code>null</code> if a matching sample thing could not be found
	*/
	public static SampleThing fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the sample thing where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the sample thing that was removed
	*/
	public static SampleThing removeByUUID_G(java.lang.String uuid, long groupId)
		throws sample.thing.exception.NoSuchThingException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of sample things where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching sample things
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the sample things where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching sample things
	*/
	public static List<SampleThing> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<SampleThing> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<SampleThing> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<SampleThing> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<SampleThing> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<SampleThing> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first sample thing in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sample thing
	* @throws NoSuchThingException if a matching sample thing could not be found
	*/
	public static SampleThing findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<SampleThing> orderByComparator)
		throws sample.thing.exception.NoSuchThingException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first sample thing in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sample thing, or <code>null</code> if a matching sample thing could not be found
	*/
	public static SampleThing fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<SampleThing> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last sample thing in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sample thing
	* @throws NoSuchThingException if a matching sample thing could not be found
	*/
	public static SampleThing findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<SampleThing> orderByComparator)
		throws sample.thing.exception.NoSuchThingException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last sample thing in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sample thing, or <code>null</code> if a matching sample thing could not be found
	*/
	public static SampleThing fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<SampleThing> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

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
	public static SampleThing[] findByUuid_C_PrevAndNext(long sampleId,
		java.lang.String uuid, long companyId,
		OrderByComparator<SampleThing> orderByComparator)
		throws sample.thing.exception.NoSuchThingException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(sampleId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the sample things where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of sample things where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching sample things
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the sample things where someString = &#63;.
	*
	* @param someString the some string
	* @return the matching sample things
	*/
	public static List<SampleThing> findBySomeString(
		java.lang.String someString) {
		return getPersistence().findBySomeString(someString);
	}

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
	public static List<SampleThing> findBySomeString(
		java.lang.String someString, int start, int end) {
		return getPersistence().findBySomeString(someString, start, end);
	}

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
	public static List<SampleThing> findBySomeString(
		java.lang.String someString, int start, int end,
		OrderByComparator<SampleThing> orderByComparator) {
		return getPersistence()
				   .findBySomeString(someString, start, end, orderByComparator);
	}

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
	public static List<SampleThing> findBySomeString(
		java.lang.String someString, int start, int end,
		OrderByComparator<SampleThing> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBySomeString(someString, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first sample thing in the ordered set where someString = &#63;.
	*
	* @param someString the some string
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sample thing
	* @throws NoSuchThingException if a matching sample thing could not be found
	*/
	public static SampleThing findBySomeString_First(
		java.lang.String someString,
		OrderByComparator<SampleThing> orderByComparator)
		throws sample.thing.exception.NoSuchThingException {
		return getPersistence()
				   .findBySomeString_First(someString, orderByComparator);
	}

	/**
	* Returns the first sample thing in the ordered set where someString = &#63;.
	*
	* @param someString the some string
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sample thing, or <code>null</code> if a matching sample thing could not be found
	*/
	public static SampleThing fetchBySomeString_First(
		java.lang.String someString,
		OrderByComparator<SampleThing> orderByComparator) {
		return getPersistence()
				   .fetchBySomeString_First(someString, orderByComparator);
	}

	/**
	* Returns the last sample thing in the ordered set where someString = &#63;.
	*
	* @param someString the some string
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sample thing
	* @throws NoSuchThingException if a matching sample thing could not be found
	*/
	public static SampleThing findBySomeString_Last(
		java.lang.String someString,
		OrderByComparator<SampleThing> orderByComparator)
		throws sample.thing.exception.NoSuchThingException {
		return getPersistence()
				   .findBySomeString_Last(someString, orderByComparator);
	}

	/**
	* Returns the last sample thing in the ordered set where someString = &#63;.
	*
	* @param someString the some string
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sample thing, or <code>null</code> if a matching sample thing could not be found
	*/
	public static SampleThing fetchBySomeString_Last(
		java.lang.String someString,
		OrderByComparator<SampleThing> orderByComparator) {
		return getPersistence()
				   .fetchBySomeString_Last(someString, orderByComparator);
	}

	/**
	* Returns the sample things before and after the current sample thing in the ordered set where someString = &#63;.
	*
	* @param sampleId the primary key of the current sample thing
	* @param someString the some string
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sample thing
	* @throws NoSuchThingException if a sample thing with the primary key could not be found
	*/
	public static SampleThing[] findBySomeString_PrevAndNext(long sampleId,
		java.lang.String someString,
		OrderByComparator<SampleThing> orderByComparator)
		throws sample.thing.exception.NoSuchThingException {
		return getPersistence()
				   .findBySomeString_PrevAndNext(sampleId, someString,
			orderByComparator);
	}

	/**
	* Removes all the sample things where someString = &#63; from the database.
	*
	* @param someString the some string
	*/
	public static void removeBySomeString(java.lang.String someString) {
		getPersistence().removeBySomeString(someString);
	}

	/**
	* Returns the number of sample things where someString = &#63;.
	*
	* @param someString the some string
	* @return the number of matching sample things
	*/
	public static int countBySomeString(java.lang.String someString) {
		return getPersistence().countBySomeString(someString);
	}

	/**
	* Caches the sample thing in the entity cache if it is enabled.
	*
	* @param sampleThing the sample thing
	*/
	public static void cacheResult(SampleThing sampleThing) {
		getPersistence().cacheResult(sampleThing);
	}

	/**
	* Caches the sample things in the entity cache if it is enabled.
	*
	* @param sampleThings the sample things
	*/
	public static void cacheResult(List<SampleThing> sampleThings) {
		getPersistence().cacheResult(sampleThings);
	}

	/**
	* Creates a new sample thing with the primary key. Does not add the sample thing to the database.
	*
	* @param sampleId the primary key for the new sample thing
	* @return the new sample thing
	*/
	public static SampleThing create(long sampleId) {
		return getPersistence().create(sampleId);
	}

	/**
	* Removes the sample thing with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sampleId the primary key of the sample thing
	* @return the sample thing that was removed
	* @throws NoSuchThingException if a sample thing with the primary key could not be found
	*/
	public static SampleThing remove(long sampleId)
		throws sample.thing.exception.NoSuchThingException {
		return getPersistence().remove(sampleId);
	}

	public static SampleThing updateImpl(SampleThing sampleThing) {
		return getPersistence().updateImpl(sampleThing);
	}

	/**
	* Returns the sample thing with the primary key or throws a {@link NoSuchThingException} if it could not be found.
	*
	* @param sampleId the primary key of the sample thing
	* @return the sample thing
	* @throws NoSuchThingException if a sample thing with the primary key could not be found
	*/
	public static SampleThing findByPrimaryKey(long sampleId)
		throws sample.thing.exception.NoSuchThingException {
		return getPersistence().findByPrimaryKey(sampleId);
	}

	/**
	* Returns the sample thing with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param sampleId the primary key of the sample thing
	* @return the sample thing, or <code>null</code> if a sample thing with the primary key could not be found
	*/
	public static SampleThing fetchByPrimaryKey(long sampleId) {
		return getPersistence().fetchByPrimaryKey(sampleId);
	}

	public static java.util.Map<java.io.Serializable, SampleThing> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the sample things.
	*
	* @return the sample things
	*/
	public static List<SampleThing> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<SampleThing> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<SampleThing> findAll(int start, int end,
		OrderByComparator<SampleThing> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<SampleThing> findAll(int start, int end,
		OrderByComparator<SampleThing> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the sample things from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of sample things.
	*
	* @return the number of sample things
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static SampleThingPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SampleThingPersistence, SampleThingPersistence> _serviceTracker =
		ServiceTrackerFactory.open(SampleThingPersistence.class);
}