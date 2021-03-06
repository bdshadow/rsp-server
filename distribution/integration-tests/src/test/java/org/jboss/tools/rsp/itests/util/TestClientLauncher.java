/*******************************************************************************
 * Copyright (c) 2018 Red Hat, Inc. Distributed under license by Red Hat, Inc.
 * All rights reserved. This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Red Hat, Inc.
 ******************************************************************************/
package org.jboss.tools.rsp.itests.util;

import java.net.Socket;
import org.jboss.tools.rsp.api.RSPServer;
import org.jboss.tools.rsp.api.SocketLauncher;
import org.jboss.tools.rsp.client.cli.ServerManagementCLI;

/**
 *
 * @author jrichter
 */
public class TestClientLauncher {

    private TestClient myClient;
    private SocketLauncher<RSPServer> launcher;
    private Socket socket;
    private String host;
    private int port;
    private boolean connectionOpen = false;

    public TestClientLauncher(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void launch() throws Exception {
        TestClient client = new TestClient();
        this.socket = new Socket(host, port);
        this.launcher = new SocketLauncher<>(client, RSPServer.class, socket);
        launcher.startListening().thenRun(() -> clientClosed());
        client.initialize(launcher.getRemoteProxy(), new ServerManagementCLI());
        myClient = client;
        connectionOpen = true;
    }

    private void clientClosed() {
        this.myClient = null;
        connectionOpen = false;
    }

    public void closeConnection() {
        if (launcher != null) {
            launcher.close();
        }
    }

    public TestClient getClient() {
        return this.myClient;
    }

    public boolean isConnectionActive() {
        return connectionOpen;
    }

    public RSPServer getServerProxy() {
        if (myClient != null) {
            return myClient.getProxy();
        }
        return null;
    }
}
