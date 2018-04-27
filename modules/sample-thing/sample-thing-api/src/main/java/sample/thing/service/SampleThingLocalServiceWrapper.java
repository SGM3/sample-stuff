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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SampleThingLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SampleThingLocalService
 * @generated
 */
@ProviderType
public class SampleThingLocalServiceWrapper implements SampleThingLocalService,
	ServiceWrapper<SampleThingLocalService> {
	public SampleThingLocalServiceWrapper(
		SampleThingLocalService sampleThingLocalService) {
		_sampleThingLocalService = sampleThingLocalService;
	}

	/**
	* Adds the sample thing to the database. Also notifies the appropriate model listeners.
	*
	* @param sampleThing the sample thing
	* @return the sample thing that was added
	*/
	@Override
	public sample.thing.model.SampleThing addSampleThing(
		sample.thing.model.SampleThing sampleThing) {
		return _sampleThingLocalService.addSampleThing(sampleThing);
	}

	/**
	* Creates a new sample thing with the primary key. Does not add the sample thing to the database.
	*
	* @param sampleId the primary key for the new sample thing
	* @return the new sample thing
	*/
	@Override
	public sample.thing.model.SampleThing createSampleThing(long sampleId) {
		return _sampleThingLocalService.createSampleThing(sampleId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _sampleThingLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the sample thing with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sampleId the primary key of the sample thing
	* @return the sample thing that was removed
	* @throws PortalException if a sample thing with the primary key could not be found
	*/
	@Override
	public sample.thing.model.SampleThing deleteSampleThing(long sampleId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _sampleThingLocalService.deleteSampleThing(sampleId);
	}

	/**
	* Deletes the sample thing from the database. Also notifies the appropriate model listeners.
	*
	* @param sampleThing the sample thing
	* @return the sample thing that was removed
	*/
	@Override
	public sample.thing.model.SampleThing deleteSampleThing(
		sample.thing.model.SampleThing sampleThing) {
		return _sampleThingLocalService.deleteSampleThing(sampleThing);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _sampleThingLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _sampleThingLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _sampleThingLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _sampleThingLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _sampleThingLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _sampleThingLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public sample.thing.model.SampleThing fetchSampleThing(long sampleId) {
		return _sampleThingLocalService.fetchSampleThing(sampleId);
	}

	/**
	* Returns the sample thing matching the UUID and group.
	*
	* @param uuid the sample thing's UUID
	* @param groupId the primary key of the group
	* @return the matching sample thing, or <code>null</code> if a matching sample thing could not be found
	*/
	@Override
	public sample.thing.model.SampleThing fetchSampleThingByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _sampleThingLocalService.fetchSampleThingByUuidAndGroupId(uuid,
			groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _sampleThingLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _sampleThingLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _sampleThingLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _sampleThingLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _sampleThingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the sample thing with the primary key.
	*
	* @param sampleId the primary key of the sample thing
	* @return the sample thing
	* @throws PortalException if a sample thing with the primary key could not be found
	*/
	@Override
	public sample.thing.model.SampleThing getSampleThing(long sampleId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _sampleThingLocalService.getSampleThing(sampleId);
	}

	/**
	* Returns the sample thing matching the UUID and group.
	*
	* @param uuid the sample thing's UUID
	* @param groupId the primary key of the group
	* @return the matching sample thing
	* @throws PortalException if a matching sample thing could not be found
	*/
	@Override
	public sample.thing.model.SampleThing getSampleThingByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _sampleThingLocalService.getSampleThingByUuidAndGroupId(uuid,
			groupId);
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
	@Override
	public java.util.List<sample.thing.model.SampleThing> getSampleThings(
		int start, int end) {
		return _sampleThingLocalService.getSampleThings(start, end);
	}

	/**
	* Returns all the sample things matching the UUID and company.
	*
	* @param uuid the UUID of the sample things
	* @param companyId the primary key of the company
	* @return the matching sample things, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<sample.thing.model.SampleThing> getSampleThingsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _sampleThingLocalService.getSampleThingsByUuidAndCompanyId(uuid,
			companyId);
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
	@Override
	public java.util.List<sample.thing.model.SampleThing> getSampleThingsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<sample.thing.model.SampleThing> orderByComparator) {
		return _sampleThingLocalService.getSampleThingsByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	/**
	* Returns the number of sample things.
	*
	* @return the number of sample things
	*/
	@Override
	public int getSampleThingsCount() {
		return _sampleThingLocalService.getSampleThingsCount();
	}

	/**
	* Updates the sample thing in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param sampleThing the sample thing
	* @return the sample thing that was updated
	*/
	@Override
	public sample.thing.model.SampleThing updateSampleThing(
		sample.thing.model.SampleThing sampleThing) {
		return _sampleThingLocalService.updateSampleThing(sampleThing);
	}

	@Override
	public SampleThingLocalService getWrappedService() {
		return _sampleThingLocalService;
	}

	@Override
	public void setWrappedService(
		SampleThingLocalService sampleThingLocalService) {
		_sampleThingLocalService = sampleThingLocalService;
	}

	private SampleThingLocalService _sampleThingLocalService;
}