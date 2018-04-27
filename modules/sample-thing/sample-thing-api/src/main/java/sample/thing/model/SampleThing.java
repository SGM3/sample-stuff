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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the SampleThing service. Represents a row in the &quot;Sample_SampleThing&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see SampleThingModel
 * @see sample.thing.model.impl.SampleThingImpl
 * @see sample.thing.model.impl.SampleThingModelImpl
 * @generated
 */
@ImplementationClassName("sample.thing.model.impl.SampleThingImpl")
@ProviderType
public interface SampleThing extends SampleThingModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link sample.thing.model.impl.SampleThingImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<SampleThing, Long> SAMPLE_ID_ACCESSOR = new Accessor<SampleThing, Long>() {
			@Override
			public Long get(SampleThing sampleThing) {
				return sampleThing.getSampleId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<SampleThing> getTypeClass() {
				return SampleThing.class;
			}
		};
}