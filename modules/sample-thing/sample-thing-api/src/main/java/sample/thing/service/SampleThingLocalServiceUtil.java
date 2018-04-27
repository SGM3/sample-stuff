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

package sample.thing.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for SampleThing. This utility wraps
 * {@link sample.thing.service.impl.SampleThingLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SampleThingLocalService
 * @see sample.thing.service.base.SampleThingLocalServiceBaseImpl
 * @see sample.thing.service.impl.SampleThingLocalServiceImpl
 * @generated
 */
@ProviderType
public class SampleThingLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link sample.thing.service.impl.SampleThingLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the sample thing to the database. Also notifies the appropriate model listeners.
	*
	* @param sampleThing the sample thing
	* @return the sample thing that was added
	*/
	public static sample.thing.model.SampleThing addSampleThing(
		sample.thing.model.SampleThing sampleThing) {
		return getService().addSampleThing(sampleThing);
	}

	/**
	* Creates a new sample thing with the primary key. Does not add the sample thing to the database.
	*
	* @param sampleId the primary key for the new sample thing
	* @return the new sample thing
	*/
	public static sample.thing.model.SampleThing createSampleThing(
		long sampleId) {
		return getService().createSampleThing(sampleId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the sample thing with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sampleId the primary key of the sample thing
	* @return the sample thing that was removed
	* @throws PortalException if a sample thing with the primary key could not be found
	*/
	public static sample.thing.model.SampleThing deleteSampleThing(
		long sampleId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteSampleThing(sampleId);
	}

	/**
	* Deletes the sample thing from the database. Also notifies the appropriate model listeners.
	*
	* @param sampleThing the sample thing
	* @return the sample thing that was removed
	*/
	public static sample.thing.model.SampleThing deleteSampleThing(
		sample.thing.model.SampleThing sampleThing) {
		return getService().deleteSampleThing(sampleThing);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link sample.thing.model.impl.SampleThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link sample.thing.model.impl.SampleThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static sample.thing.model.SampleThing fetchSampleThing(long sampleId) {
		return getService().fetchSampleThing(sampleId);
	}

	/**
	* Returns the sample thing matching the UUID and group.
	*
	* @param uuid the sample thing's UUID
	* @param groupId the primary key of the group
	* @return the matching sample thing, or <code>null</code> if a matching sample thing could not be found
	*/
	public static sample.thing.model.SampleThing fetchSampleThingByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchSampleThingByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the sample thing with the primary key.
	*
	* @param sampleId the primary key of the sample thing
	* @return the sample thing
	* @throws PortalException if a sample thing with the primary key could not be found
	*/
	public static sample.thing.model.SampleThing getSampleThing(long sampleId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getSampleThing(sampleId);
	}

	/**
	* Returns the sample thing matching the UUID and group.
	*
	* @param uuid the sample thing's UUID
	* @param groupId the primary key of the group
	* @return the matching sample thing
	* @throws PortalException if a matching sample thing could not be found
	*/
	public static sample.thing.model.SampleThing getSampleThingByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getSampleThingByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the sample things.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link sample.thing.model.impl.SampleThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sample things
	* @param end the upper bound of the range of sample things (not inclusive)
	* @return the range of sample things
	*/
	public static java.util.List<sample.thing.model.SampleThing> getSampleThings(
		int start, int end) {
		return getService().getSampleThings(start, end);
	}

	/**
	* Returns all the sample things matching the UUID and company.
	*
	* @param uuid the UUID of the sample things
	* @param companyId the primary key of the company
	* @return the matching sample things, or an empty list if no matches were found
	*/
	public static java.util.List<sample.thing.model.SampleThing> getSampleThingsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getSampleThingsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of sample things matching the UUID and company.
	*
	* @param uuid the UUID of the sample things
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of sample things
	* @param end the upper bound of the range of sample things (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching sample things, or an empty list if no matches were found
	*/
	public static java.util.List<sample.thing.model.SampleThing> getSampleThingsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<sample.thing.model.SampleThing> orderByComparator) {
		return getService()
				   .getSampleThingsByUuidAndCompanyId(uuid, companyId, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of sample things.
	*
	* @return the number of sample things
	*/
	public static int getSampleThingsCount() {
		return getService().getSampleThingsCount();
	}

	/**
	* Updates the sample thing in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param sampleThing the sample thing
	* @return the sample thing that was updated
	*/
	public static sample.thing.model.SampleThing updateSampleThing(
		sample.thing.model.SampleThing sampleThing) {
		return getService().updateSampleThing(sampleThing);
	}

	public static SampleThingLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SampleThingLocalService, SampleThingLocalService> _serviceTracker =
		ServiceTrackerFactory.open(SampleThingLocalService.class);
}