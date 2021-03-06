/*******************************************************************************
 * Copyright (c) 2000, 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.jboss.tools.rsp.eclipse.debug.core;


/**
 * A debug event set listener registers with the debug plug-in
 * to receive event notification from programs being run or debugged.
 * <p>
 * When more than one event is reported, each event has occurred at the
 * same location in a target program. For example, a breakpoint may
 * reside at the same location at which a step request completes. In
 * this case the breakpoint event and step end event are reported together
 * in the same event set.
 * </p>
 * <p>
 * Clients may implement this interface.
 * </p>
 * @see DebugEvent
 * @since 2.0
 */
public interface IDebugEventSetListener {
	/**
	 * Notifies this listener of the given debug events.
	 * All of the events in the given event collection occurred
	 * at the same location the program be run or debugged.
	 *
	 * @param events the debug events
	 */
	public void handleDebugEvents(DebugEvent[] events);
}
