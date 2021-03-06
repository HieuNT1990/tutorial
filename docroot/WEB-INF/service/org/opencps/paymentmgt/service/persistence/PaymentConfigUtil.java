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

package org.opencps.paymentmgt.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.opencps.paymentmgt.model.PaymentConfig;

import java.util.List;

/**
 * The persistence utility for the Payment configuration service. This utility wraps {@link PaymentConfigPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author trungdk
 * @see PaymentConfigPersistence
 * @see PaymentConfigPersistenceImpl
 * @generated
 */
public class PaymentConfigUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(PaymentConfig paymentConfig) {
		getPersistence().clearCache(paymentConfig);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PaymentConfig> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PaymentConfig> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PaymentConfig> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static PaymentConfig update(PaymentConfig paymentConfig)
		throws SystemException {
		return getPersistence().update(paymentConfig);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static PaymentConfig update(PaymentConfig paymentConfig,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(paymentConfig, serviceContext);
	}

	/**
	* Returns the Payment configuration where groupId = &#63; and govAgencyOrganizationId = &#63; or throws a {@link org.opencps.paymentmgt.NoSuchPaymentConfigException} if it could not be found.
	*
	* @param groupId the group ID
	* @param govAgencyOrganizationId the gov agency organization ID
	* @return the matching Payment configuration
	* @throws org.opencps.paymentmgt.NoSuchPaymentConfigException if a matching Payment configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.paymentmgt.model.PaymentConfig findByGovAgency(
		long groupId, long govAgencyOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.paymentmgt.NoSuchPaymentConfigException {
		return getPersistence().findByGovAgency(groupId, govAgencyOrganizationId);
	}

	/**
	* Returns the Payment configuration where groupId = &#63; and govAgencyOrganizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param govAgencyOrganizationId the gov agency organization ID
	* @return the matching Payment configuration, or <code>null</code> if a matching Payment configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.paymentmgt.model.PaymentConfig fetchByGovAgency(
		long groupId, long govAgencyOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGovAgency(groupId, govAgencyOrganizationId);
	}

	/**
	* Returns the Payment configuration where groupId = &#63; and govAgencyOrganizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param govAgencyOrganizationId the gov agency organization ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching Payment configuration, or <code>null</code> if a matching Payment configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.paymentmgt.model.PaymentConfig fetchByGovAgency(
		long groupId, long govAgencyOrganizationId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGovAgency(groupId, govAgencyOrganizationId,
			retrieveFromCache);
	}

	/**
	* Removes the Payment configuration where groupId = &#63; and govAgencyOrganizationId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param govAgencyOrganizationId the gov agency organization ID
	* @return the Payment configuration that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.paymentmgt.model.PaymentConfig removeByGovAgency(
		long groupId, long govAgencyOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.paymentmgt.NoSuchPaymentConfigException {
		return getPersistence()
				   .removeByGovAgency(groupId, govAgencyOrganizationId);
	}

	/**
	* Returns the number of Payment configurations where groupId = &#63; and govAgencyOrganizationId = &#63;.
	*
	* @param groupId the group ID
	* @param govAgencyOrganizationId the gov agency organization ID
	* @return the number of matching Payment configurations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGovAgency(long groupId,
		long govAgencyOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByGovAgency(groupId, govAgencyOrganizationId);
	}

	/**
	* Caches the Payment configuration in the entity cache if it is enabled.
	*
	* @param paymentConfig the Payment configuration
	*/
	public static void cacheResult(
		org.opencps.paymentmgt.model.PaymentConfig paymentConfig) {
		getPersistence().cacheResult(paymentConfig);
	}

	/**
	* Caches the Payment configurations in the entity cache if it is enabled.
	*
	* @param paymentConfigs the Payment configurations
	*/
	public static void cacheResult(
		java.util.List<org.opencps.paymentmgt.model.PaymentConfig> paymentConfigs) {
		getPersistence().cacheResult(paymentConfigs);
	}

	/**
	* Creates a new Payment configuration with the primary key. Does not add the Payment configuration to the database.
	*
	* @param paymentConfigId the primary key for the new Payment configuration
	* @return the new Payment configuration
	*/
	public static org.opencps.paymentmgt.model.PaymentConfig create(
		long paymentConfigId) {
		return getPersistence().create(paymentConfigId);
	}

	/**
	* Removes the Payment configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param paymentConfigId the primary key of the Payment configuration
	* @return the Payment configuration that was removed
	* @throws org.opencps.paymentmgt.NoSuchPaymentConfigException if a Payment configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.paymentmgt.model.PaymentConfig remove(
		long paymentConfigId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.paymentmgt.NoSuchPaymentConfigException {
		return getPersistence().remove(paymentConfigId);
	}

	public static org.opencps.paymentmgt.model.PaymentConfig updateImpl(
		org.opencps.paymentmgt.model.PaymentConfig paymentConfig)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(paymentConfig);
	}

	/**
	* Returns the Payment configuration with the primary key or throws a {@link org.opencps.paymentmgt.NoSuchPaymentConfigException} if it could not be found.
	*
	* @param paymentConfigId the primary key of the Payment configuration
	* @return the Payment configuration
	* @throws org.opencps.paymentmgt.NoSuchPaymentConfigException if a Payment configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.paymentmgt.model.PaymentConfig findByPrimaryKey(
		long paymentConfigId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.paymentmgt.NoSuchPaymentConfigException {
		return getPersistence().findByPrimaryKey(paymentConfigId);
	}

	/**
	* Returns the Payment configuration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param paymentConfigId the primary key of the Payment configuration
	* @return the Payment configuration, or <code>null</code> if a Payment configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.paymentmgt.model.PaymentConfig fetchByPrimaryKey(
		long paymentConfigId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(paymentConfigId);
	}

	/**
	* Returns all the Payment configurations.
	*
	* @return the Payment configurations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.paymentmgt.model.PaymentConfig> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the Payment configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.paymentmgt.model.impl.PaymentConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Payment configurations
	* @param end the upper bound of the range of Payment configurations (not inclusive)
	* @return the range of Payment configurations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.paymentmgt.model.PaymentConfig> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the Payment configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.paymentmgt.model.impl.PaymentConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Payment configurations
	* @param end the upper bound of the range of Payment configurations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of Payment configurations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.paymentmgt.model.PaymentConfig> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the Payment configurations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of Payment configurations.
	*
	* @return the number of Payment configurations
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PaymentConfigPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PaymentConfigPersistence)PortletBeanLocatorUtil.locate(org.opencps.paymentmgt.service.ClpSerializer.getServletContextName(),
					PaymentConfigPersistence.class.getName());

			ReferenceRegistry.registerReference(PaymentConfigUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PaymentConfigPersistence persistence) {
	}

	private static PaymentConfigPersistence _persistence;
}