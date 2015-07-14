/*******************************************************************************
 * Copyright (c) 2004, 2009 Tasktop Technologies and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tasktop Technologies - initial API and implementation
 *******************************************************************************/

package com.tasktop.internal.thoughtworks.mingle.ui;

import java.util.Map;

import org.eclipse.mylyn.internal.tasks.ui.editors.TaskEditorPeoplePart;
import org.eclipse.mylyn.tasks.core.data.TaskAttribute;
import org.eclipse.mylyn.tasks.core.data.TaskAttributeMetaData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;

public class MingleTaskEditorPeoplePart extends TaskEditorPeoplePart {

	private static final int LIMIT = 5;

	@Override
	protected void createAttributeEditors(FormToolkit toolkit, Composite peopleComposite) {
		int i = 0;
		Map<String, TaskAttribute> attributes = getTaskData().getRoot().getAttributes();
		for (TaskAttribute attribute : attributes.values()) {
			final TaskAttributeMetaData metaData = attribute.getMetaData();
			if (metaData != null && TaskAttribute.TYPE_PERSON.equals(metaData.getType())) {
				addAttribute(peopleComposite, toolkit, attribute);
				i++;
				if (i > LIMIT) {
					break;
				}
			}
		}
	}
}
