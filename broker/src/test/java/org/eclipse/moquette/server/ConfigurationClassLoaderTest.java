/*
 * Copyright (c) 2012-2014 The original author or authors
 * ------------------------------------------------------
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 *
 * The Eclipse Public License is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * The Apache License v2.0 is available at
 * http://www.opensource.org/licenses/apache2.0.php
 *
 * You may elect to redistribute this code under either of these licenses.
 */
package org.eclipse.moquette.server;

import org.fusesource.mqtt.client.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.eclipse.moquette.commons.Constants.PERSISTENT_STORE_PROPERTY_NAME;
import static org.eclipse.moquette.commons.Constants.AUTHENTICATOR_CLASS_NAME;
import static org.eclipse.moquette.commons.Constants.AUTHORIZATOR_CLASS_NAME;
import org.eclipse.moquette.spi.impl.security.IAuthenticator;
import org.eclipse.moquette.spi.impl.security.IAuthorizator;

import static org.junit.Assert.*;

/**
 *
 * @author luca <luca.capra@create-net.org> 
 */
public class ConfigurationClassLoaderTest implements IAuthenticator, IAuthorizator {
    private static final Logger LOG = LoggerFactory.getLogger(ConfigurationClassLoaderTest.class);

    Server m_server;
    MQTT m_mqtt;
    BlockingConnection m_subscriber;
    BlockingConnection m_publisher;
    
    protected void startServer(Properties props) throws IOException {
        m_server = new Server();        
        m_server.startServer(props);
    }


    @After
    public void tearDown() throws Exception {
        m_server.stopServer();
        File dbFile = new File(m_server.getProperties().getProperty(PERSISTENT_STORE_PROPERTY_NAME));
        if (dbFile.exists()) {
            dbFile.delete();
        }
    }
    
    @Test
    public void loadAuthenticator() throws Exception {
        Properties props = new Properties(IntegrationUtils.prepareTestPropeties());
        props.setProperty(AUTHENTICATOR_CLASS_NAME, "org.eclipse.moquette.server.ConfigurationClassLoaderTest");
        startServer(props);
        assertTrue(true);
        m_server.stopServer();
    }
    
    @Test
    public void loadAuthorizator() throws Exception {
        Properties props = new Properties(IntegrationUtils.prepareTestPropeties());
        props.setProperty(AUTHORIZATOR_CLASS_NAME, "org.eclipse.moquette.server.ConfigurationClassLoaderTest");
        startServer(props);
        assertTrue(true);
        m_server.stopServer();
    }

    @Override
    public boolean checkValid(String username, String password) {
        return true;
    }

    @Override
    public boolean canWrite(String topic, String user, String client) {
        return true;
    }

    @Override
    public boolean canRead(String topic, String user, String client) {
        return true;
    }
    
}
