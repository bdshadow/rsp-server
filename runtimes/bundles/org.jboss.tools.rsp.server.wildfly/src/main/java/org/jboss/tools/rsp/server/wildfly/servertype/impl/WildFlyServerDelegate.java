/*******************************************************************************
 * Copyright (c) 2018 Red Hat, Inc. Distributed under license by Red Hat, Inc.
 * All rights reserved. This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Red Hat, Inc.
 ******************************************************************************/
package org.jboss.tools.rsp.server.wildfly.servertype.impl;

import org.jboss.tools.rsp.api.ServerManagementAPIConstants;
import org.jboss.tools.rsp.server.spi.launchers.IShutdownLauncher;
import org.jboss.tools.rsp.server.spi.launchers.IStartLauncher;
import org.jboss.tools.rsp.server.spi.servertype.IServer;
import org.jboss.tools.rsp.server.wildfly.servertype.AbstractJBossServerDelegate;
import org.jboss.tools.rsp.server.wildfly.servertype.publishing.IJBossPublishController;
import org.jboss.tools.rsp.server.wildfly.servertype.publishing.WildFlyPublishController;

public class WildFlyServerDelegate extends AbstractJBossServerDelegate {
	public WildFlyServerDelegate(IServer server) {
		super(server);
		setServerState(ServerManagementAPIConstants.STATE_STOPPED);
	}
	protected IStartLauncher getStartLauncher() {
		return new WildFlyStartLauncher(this);
	}
	
	protected IShutdownLauncher getStopLauncher() {
		return new WildFlyStopLauncher(this);
	}
	@Override
	protected String getPollURL(IServer server) {
		// TODO?
		return "http://localhost:8080";
	}
	@Override
	protected IJBossPublishController createPublishController() {
		return new WildFlyPublishController(getServer(), this);
	}
}
