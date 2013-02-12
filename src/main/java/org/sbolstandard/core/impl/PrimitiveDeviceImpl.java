/*
 * Copyright (c) 2012 Clark & Parsia, LLC. <http://www.clarkparsia.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.sbolstandard.core.impl;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.sbolstandard.core.DnaComponent;
import org.sbolstandard.core.PrimitiveDevice;

/**
 * @author Ernst Oberortner
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrimitiveDevice")
public class PrimitiveDeviceImpl 
		extends DeviceImpl 
		implements PrimitiveDevice {

	@XmlElement(name = "component")
	protected final List<DnaComponentWrapper> components = 
		new ArrayList<DnaComponentWrapper>();
	
	@XmlTransient
	protected final WrappedList<DnaComponentImpl, DnaComponentWrapper> wrappedComponents = new WrappedList<DnaComponentImpl, DnaComponentWrapper>(
	                DnaComponentWrapper.class, components);

	/**
     * {@inheritDoc}
     */
	@SuppressWarnings("unchecked")
	public List<DnaComponent> getComponents() {
		return (List) wrappedComponents;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addComponent(DnaComponent component) {
		getComponents().add(component);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeComponent(DnaComponent component) {
		getComponents().remove(component);
	}
	
	@XmlAccessorType(XmlAccessType.PROPERTY)
	@XmlType(name = "")
	public static class DnaComponentWrapper extends WrappedValue<DnaComponentImpl> {
		@XmlElement(name = "DnaComponent")
		@Override
		public DnaComponentImpl getValue() {
			return super.getValue();
		}

		@Override
		public void setValue(DnaComponentImpl value) {
			super.setValue(value);
		}
	}
}