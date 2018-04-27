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

package sample.thing.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import sample.thing.exception.NoSuchThingException;

import sample.thing.model.SampleThing;
import sample.thing.model.impl.SampleThingImpl;
import sample.thing.model.impl.SampleThingModelImpl;

import sample.thing.service.persistence.SampleThingPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the sample thing service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SampleThingPersistence
 * @see sample.thing.service.persistence.SampleThingUtil
 * @generated
 */
@ProviderType
public class SampleThingPersistenceImpl extends BasePersistenceImpl<SampleThing>
	implements SampleThingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SampleThingUtil} to access the sample thing persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SampleThingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SampleThingModelImpl.ENTITY_CACHE_ENABLED,
			SampleThingModelImpl.FINDER_CACHE_ENABLED, SampleThingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SampleThingModelImpl.ENTITY_CACHE_ENABLED,
			SampleThingModelImpl.FINDER_CACHE_ENABLED, SampleThingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SampleThingModelImpl.ENTITY_CACHE_ENABLED,
			SampleThingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(SampleThingModelImpl.ENTITY_CACHE_ENABLED,
			SampleThingModelImpl.FINDER_CACHE_ENABLED, SampleThingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(SampleThingModelImpl.ENTITY_CACHE_ENABLED,
			SampleThingModelImpl.FINDER_CACHE_ENABLED, SampleThingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			SampleThingModelImpl.UUID_COLUMN_BITMASK |
			SampleThingModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(SampleThingModelImpl.ENTITY_CACHE_ENABLED,
			SampleThingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the sample things where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching sample things
	 */
	@Override
	public List<SampleThing> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SampleThing> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<SampleThing> findByUuid(String uuid, int start, int end,
		OrderByComparator<SampleThing> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<SampleThing> findByUuid(String uuid, int start, int end,
		OrderByComparator<SampleThing> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<SampleThing> list = null;

		if (retrieveFromCache) {
			list = (List<SampleThing>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SampleThing sampleThing : list) {
					if (!Objects.equals(uuid, sampleThing.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SAMPLETHING_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SampleThingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<SampleThing>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SampleThing>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first sample thing in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample thing
	 * @throws NoSuchThingException if a matching sample thing could not be found
	 */
	@Override
	public SampleThing findByUuid_First(String uuid,
		OrderByComparator<SampleThing> orderByComparator)
		throws NoSuchThingException {
		SampleThing sampleThing = fetchByUuid_First(uuid, orderByComparator);

		if (sampleThing != null) {
			return sampleThing;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchThingException(msg.toString());
	}

	/**
	 * Returns the first sample thing in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample thing, or <code>null</code> if a matching sample thing could not be found
	 */
	@Override
	public SampleThing fetchByUuid_First(String uuid,
		OrderByComparator<SampleThing> orderByComparator) {
		List<SampleThing> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sample thing in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample thing
	 * @throws NoSuchThingException if a matching sample thing could not be found
	 */
	@Override
	public SampleThing findByUuid_Last(String uuid,
		OrderByComparator<SampleThing> orderByComparator)
		throws NoSuchThingException {
		SampleThing sampleThing = fetchByUuid_Last(uuid, orderByComparator);

		if (sampleThing != null) {
			return sampleThing;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchThingException(msg.toString());
	}

	/**
	 * Returns the last sample thing in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample thing, or <code>null</code> if a matching sample thing could not be found
	 */
	@Override
	public SampleThing fetchByUuid_Last(String uuid,
		OrderByComparator<SampleThing> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SampleThing> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SampleThing[] findByUuid_PrevAndNext(long sampleId, String uuid,
		OrderByComparator<SampleThing> orderByComparator)
		throws NoSuchThingException {
		SampleThing sampleThing = findByPrimaryKey(sampleId);

		Session session = null;

		try {
			session = openSession();

			SampleThing[] array = new SampleThingImpl[3];

			array[0] = getByUuid_PrevAndNext(session, sampleThing, uuid,
					orderByComparator, true);

			array[1] = sampleThing;

			array[2] = getByUuid_PrevAndNext(session, sampleThing, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SampleThing getByUuid_PrevAndNext(Session session,
		SampleThing sampleThing, String uuid,
		OrderByComparator<SampleThing> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SAMPLETHING_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SampleThingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(sampleThing);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SampleThing> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sample things where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (SampleThing sampleThing : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(sampleThing);
		}
	}

	/**
	 * Returns the number of sample things where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching sample things
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SAMPLETHING_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "sampleThing.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "sampleThing.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(sampleThing.uuid IS NULL OR sampleThing.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(SampleThingModelImpl.ENTITY_CACHE_ENABLED,
			SampleThingModelImpl.FINDER_CACHE_ENABLED, SampleThingImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			SampleThingModelImpl.UUID_COLUMN_BITMASK |
			SampleThingModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(SampleThingModelImpl.ENTITY_CACHE_ENABLED,
			SampleThingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the sample thing where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchThingException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sample thing
	 * @throws NoSuchThingException if a matching sample thing could not be found
	 */
	@Override
	public SampleThing findByUUID_G(String uuid, long groupId)
		throws NoSuchThingException {
		SampleThing sampleThing = fetchByUUID_G(uuid, groupId);

		if (sampleThing == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchThingException(msg.toString());
		}

		return sampleThing;
	}

	/**
	 * Returns the sample thing where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sample thing, or <code>null</code> if a matching sample thing could not be found
	 */
	@Override
	public SampleThing fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the sample thing where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching sample thing, or <code>null</code> if a matching sample thing could not be found
	 */
	@Override
	public SampleThing fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof SampleThing) {
			SampleThing sampleThing = (SampleThing)result;

			if (!Objects.equals(uuid, sampleThing.getUuid()) ||
					(groupId != sampleThing.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SAMPLETHING_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<SampleThing> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					SampleThing sampleThing = list.get(0);

					result = sampleThing;

					cacheResult(sampleThing);

					if ((sampleThing.getUuid() == null) ||
							!sampleThing.getUuid().equals(uuid) ||
							(sampleThing.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, sampleThing);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (SampleThing)result;
		}
	}

	/**
	 * Removes the sample thing where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the sample thing that was removed
	 */
	@Override
	public SampleThing removeByUUID_G(String uuid, long groupId)
		throws NoSuchThingException {
		SampleThing sampleThing = findByUUID_G(uuid, groupId);

		return remove(sampleThing);
	}

	/**
	 * Returns the number of sample things where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching sample things
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SAMPLETHING_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "sampleThing.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "sampleThing.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(sampleThing.uuid IS NULL OR sampleThing.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "sampleThing.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(SampleThingModelImpl.ENTITY_CACHE_ENABLED,
			SampleThingModelImpl.FINDER_CACHE_ENABLED, SampleThingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(SampleThingModelImpl.ENTITY_CACHE_ENABLED,
			SampleThingModelImpl.FINDER_CACHE_ENABLED, SampleThingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			SampleThingModelImpl.UUID_COLUMN_BITMASK |
			SampleThingModelImpl.COMPANYID_COLUMN_BITMASK |
			SampleThingModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(SampleThingModelImpl.ENTITY_CACHE_ENABLED,
			SampleThingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the sample things where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching sample things
	 */
	@Override
	public List<SampleThing> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<SampleThing> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<SampleThing> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<SampleThing> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<SampleThing> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<SampleThing> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<SampleThing> list = null;

		if (retrieveFromCache) {
			list = (List<SampleThing>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SampleThing sampleThing : list) {
					if (!Objects.equals(uuid, sampleThing.getUuid()) ||
							(companyId != sampleThing.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_SAMPLETHING_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SampleThingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<SampleThing>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SampleThing>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public SampleThing findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<SampleThing> orderByComparator)
		throws NoSuchThingException {
		SampleThing sampleThing = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (sampleThing != null) {
			return sampleThing;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchThingException(msg.toString());
	}

	/**
	 * Returns the first sample thing in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample thing, or <code>null</code> if a matching sample thing could not be found
	 */
	@Override
	public SampleThing fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<SampleThing> orderByComparator) {
		List<SampleThing> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SampleThing findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<SampleThing> orderByComparator)
		throws NoSuchThingException {
		SampleThing sampleThing = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (sampleThing != null) {
			return sampleThing;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchThingException(msg.toString());
	}

	/**
	 * Returns the last sample thing in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample thing, or <code>null</code> if a matching sample thing could not be found
	 */
	@Override
	public SampleThing fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<SampleThing> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SampleThing> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SampleThing[] findByUuid_C_PrevAndNext(long sampleId, String uuid,
		long companyId, OrderByComparator<SampleThing> orderByComparator)
		throws NoSuchThingException {
		SampleThing sampleThing = findByPrimaryKey(sampleId);

		Session session = null;

		try {
			session = openSession();

			SampleThing[] array = new SampleThingImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, sampleThing, uuid,
					companyId, orderByComparator, true);

			array[1] = sampleThing;

			array[2] = getByUuid_C_PrevAndNext(session, sampleThing, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SampleThing getByUuid_C_PrevAndNext(Session session,
		SampleThing sampleThing, String uuid, long companyId,
		OrderByComparator<SampleThing> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_SAMPLETHING_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SampleThingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(sampleThing);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SampleThing> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sample things where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (SampleThing sampleThing : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(sampleThing);
		}
	}

	/**
	 * Returns the number of sample things where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching sample things
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SAMPLETHING_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "sampleThing.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "sampleThing.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(sampleThing.uuid IS NULL OR sampleThing.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "sampleThing.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SOMESTRING =
		new FinderPath(SampleThingModelImpl.ENTITY_CACHE_ENABLED,
			SampleThingModelImpl.FINDER_CACHE_ENABLED, SampleThingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySomeString",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOMESTRING =
		new FinderPath(SampleThingModelImpl.ENTITY_CACHE_ENABLED,
			SampleThingModelImpl.FINDER_CACHE_ENABLED, SampleThingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySomeString",
			new String[] { String.class.getName() },
			SampleThingModelImpl.SOMESTRING_COLUMN_BITMASK |
			SampleThingModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SOMESTRING = new FinderPath(SampleThingModelImpl.ENTITY_CACHE_ENABLED,
			SampleThingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySomeString",
			new String[] { String.class.getName() });

	/**
	 * Returns all the sample things where someString = &#63;.
	 *
	 * @param someString the some string
	 * @return the matching sample things
	 */
	@Override
	public List<SampleThing> findBySomeString(String someString) {
		return findBySomeString(someString, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<SampleThing> findBySomeString(String someString, int start,
		int end) {
		return findBySomeString(someString, start, end, null);
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
	@Override
	public List<SampleThing> findBySomeString(String someString, int start,
		int end, OrderByComparator<SampleThing> orderByComparator) {
		return findBySomeString(someString, start, end, orderByComparator, true);
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
	@Override
	public List<SampleThing> findBySomeString(String someString, int start,
		int end, OrderByComparator<SampleThing> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOMESTRING;
			finderArgs = new Object[] { someString };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SOMESTRING;
			finderArgs = new Object[] { someString, start, end, orderByComparator };
		}

		List<SampleThing> list = null;

		if (retrieveFromCache) {
			list = (List<SampleThing>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SampleThing sampleThing : list) {
					if (!Objects.equals(someString, sampleThing.getSomeString())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SAMPLETHING_WHERE);

			boolean bindSomeString = false;

			if (someString == null) {
				query.append(_FINDER_COLUMN_SOMESTRING_SOMESTRING_1);
			}
			else if (someString.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SOMESTRING_SOMESTRING_3);
			}
			else {
				bindSomeString = true;

				query.append(_FINDER_COLUMN_SOMESTRING_SOMESTRING_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SampleThingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSomeString) {
					qPos.add(someString);
				}

				if (!pagination) {
					list = (List<SampleThing>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SampleThing>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first sample thing in the ordered set where someString = &#63;.
	 *
	 * @param someString the some string
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample thing
	 * @throws NoSuchThingException if a matching sample thing could not be found
	 */
	@Override
	public SampleThing findBySomeString_First(String someString,
		OrderByComparator<SampleThing> orderByComparator)
		throws NoSuchThingException {
		SampleThing sampleThing = fetchBySomeString_First(someString,
				orderByComparator);

		if (sampleThing != null) {
			return sampleThing;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("someString=");
		msg.append(someString);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchThingException(msg.toString());
	}

	/**
	 * Returns the first sample thing in the ordered set where someString = &#63;.
	 *
	 * @param someString the some string
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample thing, or <code>null</code> if a matching sample thing could not be found
	 */
	@Override
	public SampleThing fetchBySomeString_First(String someString,
		OrderByComparator<SampleThing> orderByComparator) {
		List<SampleThing> list = findBySomeString(someString, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sample thing in the ordered set where someString = &#63;.
	 *
	 * @param someString the some string
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample thing
	 * @throws NoSuchThingException if a matching sample thing could not be found
	 */
	@Override
	public SampleThing findBySomeString_Last(String someString,
		OrderByComparator<SampleThing> orderByComparator)
		throws NoSuchThingException {
		SampleThing sampleThing = fetchBySomeString_Last(someString,
				orderByComparator);

		if (sampleThing != null) {
			return sampleThing;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("someString=");
		msg.append(someString);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchThingException(msg.toString());
	}

	/**
	 * Returns the last sample thing in the ordered set where someString = &#63;.
	 *
	 * @param someString the some string
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample thing, or <code>null</code> if a matching sample thing could not be found
	 */
	@Override
	public SampleThing fetchBySomeString_Last(String someString,
		OrderByComparator<SampleThing> orderByComparator) {
		int count = countBySomeString(someString);

		if (count == 0) {
			return null;
		}

		List<SampleThing> list = findBySomeString(someString, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SampleThing[] findBySomeString_PrevAndNext(long sampleId,
		String someString, OrderByComparator<SampleThing> orderByComparator)
		throws NoSuchThingException {
		SampleThing sampleThing = findByPrimaryKey(sampleId);

		Session session = null;

		try {
			session = openSession();

			SampleThing[] array = new SampleThingImpl[3];

			array[0] = getBySomeString_PrevAndNext(session, sampleThing,
					someString, orderByComparator, true);

			array[1] = sampleThing;

			array[2] = getBySomeString_PrevAndNext(session, sampleThing,
					someString, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SampleThing getBySomeString_PrevAndNext(Session session,
		SampleThing sampleThing, String someString,
		OrderByComparator<SampleThing> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SAMPLETHING_WHERE);

		boolean bindSomeString = false;

		if (someString == null) {
			query.append(_FINDER_COLUMN_SOMESTRING_SOMESTRING_1);
		}
		else if (someString.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_SOMESTRING_SOMESTRING_3);
		}
		else {
			bindSomeString = true;

			query.append(_FINDER_COLUMN_SOMESTRING_SOMESTRING_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SampleThingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindSomeString) {
			qPos.add(someString);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(sampleThing);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SampleThing> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sample things where someString = &#63; from the database.
	 *
	 * @param someString the some string
	 */
	@Override
	public void removeBySomeString(String someString) {
		for (SampleThing sampleThing : findBySomeString(someString,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(sampleThing);
		}
	}

	/**
	 * Returns the number of sample things where someString = &#63;.
	 *
	 * @param someString the some string
	 * @return the number of matching sample things
	 */
	@Override
	public int countBySomeString(String someString) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SOMESTRING;

		Object[] finderArgs = new Object[] { someString };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SAMPLETHING_WHERE);

			boolean bindSomeString = false;

			if (someString == null) {
				query.append(_FINDER_COLUMN_SOMESTRING_SOMESTRING_1);
			}
			else if (someString.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SOMESTRING_SOMESTRING_3);
			}
			else {
				bindSomeString = true;

				query.append(_FINDER_COLUMN_SOMESTRING_SOMESTRING_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSomeString) {
					qPos.add(someString);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SOMESTRING_SOMESTRING_1 = "sampleThing.someString IS NULL";
	private static final String _FINDER_COLUMN_SOMESTRING_SOMESTRING_2 = "sampleThing.someString = ?";
	private static final String _FINDER_COLUMN_SOMESTRING_SOMESTRING_3 = "(sampleThing.someString IS NULL OR sampleThing.someString = '')";

	public SampleThingPersistenceImpl() {
		setModelClass(SampleThing.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the sample thing in the entity cache if it is enabled.
	 *
	 * @param sampleThing the sample thing
	 */
	@Override
	public void cacheResult(SampleThing sampleThing) {
		entityCache.putResult(SampleThingModelImpl.ENTITY_CACHE_ENABLED,
			SampleThingImpl.class, sampleThing.getPrimaryKey(), sampleThing);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { sampleThing.getUuid(), sampleThing.getGroupId() },
			sampleThing);

		sampleThing.resetOriginalValues();
	}

	/**
	 * Caches the sample things in the entity cache if it is enabled.
	 *
	 * @param sampleThings the sample things
	 */
	@Override
	public void cacheResult(List<SampleThing> sampleThings) {
		for (SampleThing sampleThing : sampleThings) {
			if (entityCache.getResult(
						SampleThingModelImpl.ENTITY_CACHE_ENABLED,
						SampleThingImpl.class, sampleThing.getPrimaryKey()) == null) {
				cacheResult(sampleThing);
			}
			else {
				sampleThing.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all sample things.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SampleThingImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sample thing.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SampleThing sampleThing) {
		entityCache.removeResult(SampleThingModelImpl.ENTITY_CACHE_ENABLED,
			SampleThingImpl.class, sampleThing.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((SampleThingModelImpl)sampleThing, true);
	}

	@Override
	public void clearCache(List<SampleThing> sampleThings) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SampleThing sampleThing : sampleThings) {
			entityCache.removeResult(SampleThingModelImpl.ENTITY_CACHE_ENABLED,
				SampleThingImpl.class, sampleThing.getPrimaryKey());

			clearUniqueFindersCache((SampleThingModelImpl)sampleThing, true);
		}
	}

	protected void cacheUniqueFindersCache(
		SampleThingModelImpl sampleThingModelImpl) {
		Object[] args = new Object[] {
				sampleThingModelImpl.getUuid(),
				sampleThingModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
			sampleThingModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		SampleThingModelImpl sampleThingModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					sampleThingModelImpl.getUuid(),
					sampleThingModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((sampleThingModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					sampleThingModelImpl.getOriginalUuid(),
					sampleThingModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new sample thing with the primary key. Does not add the sample thing to the database.
	 *
	 * @param sampleId the primary key for the new sample thing
	 * @return the new sample thing
	 */
	@Override
	public SampleThing create(long sampleId) {
		SampleThing sampleThing = new SampleThingImpl();

		sampleThing.setNew(true);
		sampleThing.setPrimaryKey(sampleId);

		String uuid = PortalUUIDUtil.generate();

		sampleThing.setUuid(uuid);

		sampleThing.setCompanyId(companyProvider.getCompanyId());

		return sampleThing;
	}

	/**
	 * Removes the sample thing with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sampleId the primary key of the sample thing
	 * @return the sample thing that was removed
	 * @throws NoSuchThingException if a sample thing with the primary key could not be found
	 */
	@Override
	public SampleThing remove(long sampleId) throws NoSuchThingException {
		return remove((Serializable)sampleId);
	}

	/**
	 * Removes the sample thing with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sample thing
	 * @return the sample thing that was removed
	 * @throws NoSuchThingException if a sample thing with the primary key could not be found
	 */
	@Override
	public SampleThing remove(Serializable primaryKey)
		throws NoSuchThingException {
		Session session = null;

		try {
			session = openSession();

			SampleThing sampleThing = (SampleThing)session.get(SampleThingImpl.class,
					primaryKey);

			if (sampleThing == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchThingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(sampleThing);
		}
		catch (NoSuchThingException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected SampleThing removeImpl(SampleThing sampleThing) {
		sampleThing = toUnwrappedModel(sampleThing);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(sampleThing)) {
				sampleThing = (SampleThing)session.get(SampleThingImpl.class,
						sampleThing.getPrimaryKeyObj());
			}

			if (sampleThing != null) {
				session.delete(sampleThing);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (sampleThing != null) {
			clearCache(sampleThing);
		}

		return sampleThing;
	}

	@Override
	public SampleThing updateImpl(SampleThing sampleThing) {
		sampleThing = toUnwrappedModel(sampleThing);

		boolean isNew = sampleThing.isNew();

		SampleThingModelImpl sampleThingModelImpl = (SampleThingModelImpl)sampleThing;

		if (Validator.isNull(sampleThing.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			sampleThing.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (sampleThing.getCreateDate() == null)) {
			if (serviceContext == null) {
				sampleThing.setCreateDate(now);
			}
			else {
				sampleThing.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!sampleThingModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				sampleThing.setModifiedDate(now);
			}
			else {
				sampleThing.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (sampleThing.isNew()) {
				session.save(sampleThing);

				sampleThing.setNew(false);
			}
			else {
				sampleThing = (SampleThing)session.merge(sampleThing);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!SampleThingModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { sampleThingModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					sampleThingModelImpl.getUuid(),
					sampleThingModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] { sampleThingModelImpl.getSomeString() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_SOMESTRING, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOMESTRING,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((sampleThingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						sampleThingModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { sampleThingModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((sampleThingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						sampleThingModelImpl.getOriginalUuid(),
						sampleThingModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						sampleThingModelImpl.getUuid(),
						sampleThingModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((sampleThingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOMESTRING.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						sampleThingModelImpl.getOriginalSomeString()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SOMESTRING, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOMESTRING,
					args);

				args = new Object[] { sampleThingModelImpl.getSomeString() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SOMESTRING, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOMESTRING,
					args);
			}
		}

		entityCache.putResult(SampleThingModelImpl.ENTITY_CACHE_ENABLED,
			SampleThingImpl.class, sampleThing.getPrimaryKey(), sampleThing,
			false);

		clearUniqueFindersCache(sampleThingModelImpl, false);
		cacheUniqueFindersCache(sampleThingModelImpl);

		sampleThing.resetOriginalValues();

		return sampleThing;
	}

	protected SampleThing toUnwrappedModel(SampleThing sampleThing) {
		if (sampleThing instanceof SampleThingImpl) {
			return sampleThing;
		}

		SampleThingImpl sampleThingImpl = new SampleThingImpl();

		sampleThingImpl.setNew(sampleThing.isNew());
		sampleThingImpl.setPrimaryKey(sampleThing.getPrimaryKey());

		sampleThingImpl.setUuid(sampleThing.getUuid());
		sampleThingImpl.setSampleId(sampleThing.getSampleId());
		sampleThingImpl.setGroupId(sampleThing.getGroupId());
		sampleThingImpl.setCompanyId(sampleThing.getCompanyId());
		sampleThingImpl.setUserId(sampleThing.getUserId());
		sampleThingImpl.setUserName(sampleThing.getUserName());
		sampleThingImpl.setCreateDate(sampleThing.getCreateDate());
		sampleThingImpl.setModifiedDate(sampleThing.getModifiedDate());
		sampleThingImpl.setStatus(sampleThing.getStatus());
		sampleThingImpl.setStatusByUserId(sampleThing.getStatusByUserId());
		sampleThingImpl.setStatusByUserName(sampleThing.getStatusByUserName());
		sampleThingImpl.setStatusDate(sampleThing.getStatusDate());
		sampleThingImpl.setSomeString(sampleThing.getSomeString());
		sampleThingImpl.setSomeBoolean(sampleThing.isSomeBoolean());
		sampleThingImpl.setSomeInt(sampleThing.getSomeInt());
		sampleThingImpl.setSomeDate(sampleThing.getSomeDate());

		return sampleThingImpl;
	}

	/**
	 * Returns the sample thing with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the sample thing
	 * @return the sample thing
	 * @throws NoSuchThingException if a sample thing with the primary key could not be found
	 */
	@Override
	public SampleThing findByPrimaryKey(Serializable primaryKey)
		throws NoSuchThingException {
		SampleThing sampleThing = fetchByPrimaryKey(primaryKey);

		if (sampleThing == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchThingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return sampleThing;
	}

	/**
	 * Returns the sample thing with the primary key or throws a {@link NoSuchThingException} if it could not be found.
	 *
	 * @param sampleId the primary key of the sample thing
	 * @return the sample thing
	 * @throws NoSuchThingException if a sample thing with the primary key could not be found
	 */
	@Override
	public SampleThing findByPrimaryKey(long sampleId)
		throws NoSuchThingException {
		return findByPrimaryKey((Serializable)sampleId);
	}

	/**
	 * Returns the sample thing with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sample thing
	 * @return the sample thing, or <code>null</code> if a sample thing with the primary key could not be found
	 */
	@Override
	public SampleThing fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(SampleThingModelImpl.ENTITY_CACHE_ENABLED,
				SampleThingImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		SampleThing sampleThing = (SampleThing)serializable;

		if (sampleThing == null) {
			Session session = null;

			try {
				session = openSession();

				sampleThing = (SampleThing)session.get(SampleThingImpl.class,
						primaryKey);

				if (sampleThing != null) {
					cacheResult(sampleThing);
				}
				else {
					entityCache.putResult(SampleThingModelImpl.ENTITY_CACHE_ENABLED,
						SampleThingImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(SampleThingModelImpl.ENTITY_CACHE_ENABLED,
					SampleThingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return sampleThing;
	}

	/**
	 * Returns the sample thing with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sampleId the primary key of the sample thing
	 * @return the sample thing, or <code>null</code> if a sample thing with the primary key could not be found
	 */
	@Override
	public SampleThing fetchByPrimaryKey(long sampleId) {
		return fetchByPrimaryKey((Serializable)sampleId);
	}

	@Override
	public Map<Serializable, SampleThing> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, SampleThing> map = new HashMap<Serializable, SampleThing>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			SampleThing sampleThing = fetchByPrimaryKey(primaryKey);

			if (sampleThing != null) {
				map.put(primaryKey, sampleThing);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(SampleThingModelImpl.ENTITY_CACHE_ENABLED,
					SampleThingImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (SampleThing)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SAMPLETHING_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (SampleThing sampleThing : (List<SampleThing>)q.list()) {
				map.put(sampleThing.getPrimaryKeyObj(), sampleThing);

				cacheResult(sampleThing);

				uncachedPrimaryKeys.remove(sampleThing.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(SampleThingModelImpl.ENTITY_CACHE_ENABLED,
					SampleThingImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the sample things.
	 *
	 * @return the sample things
	 */
	@Override
	public List<SampleThing> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SampleThing> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<SampleThing> findAll(int start, int end,
		OrderByComparator<SampleThing> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<SampleThing> findAll(int start, int end,
		OrderByComparator<SampleThing> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<SampleThing> list = null;

		if (retrieveFromCache) {
			list = (List<SampleThing>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SAMPLETHING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SAMPLETHING;

				if (pagination) {
					sql = sql.concat(SampleThingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SampleThing>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SampleThing>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the sample things from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SampleThing sampleThing : findAll()) {
			remove(sampleThing);
		}
	}

	/**
	 * Returns the number of sample things.
	 *
	 * @return the number of sample things
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SAMPLETHING);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SampleThingModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sample thing persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(SampleThingImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SAMPLETHING = "SELECT sampleThing FROM SampleThing sampleThing";
	private static final String _SQL_SELECT_SAMPLETHING_WHERE_PKS_IN = "SELECT sampleThing FROM SampleThing sampleThing WHERE sampleId IN (";
	private static final String _SQL_SELECT_SAMPLETHING_WHERE = "SELECT sampleThing FROM SampleThing sampleThing WHERE ";
	private static final String _SQL_COUNT_SAMPLETHING = "SELECT COUNT(sampleThing) FROM SampleThing sampleThing";
	private static final String _SQL_COUNT_SAMPLETHING_WHERE = "SELECT COUNT(sampleThing) FROM SampleThing sampleThing WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "sampleThing.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SampleThing exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SampleThing exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(SampleThingPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}