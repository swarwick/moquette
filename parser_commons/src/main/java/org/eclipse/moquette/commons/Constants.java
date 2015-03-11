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
package org.eclipse.moquette.commons;

import java.io.File;

/**
 * Contains some useful constants.
 */
public class Constants {
    public static final int PORT = 1883;
    public static final int WEBSOCKET_PORT = 8080;
    public static final String HOST = "0.0.0.0";
    public static final int DEFAULT_CONNECT_TIMEOUT = 10;
    public static final String DEFAULT_MOQUETTE_STORE_MAP_DB_FILENAME = "moquette_store.mapdb";
    public static final String DEFAULT_PERSISTENT_PATH = System.getProperty("user.home") + File.separator + DEFAULT_MOQUETTE_STORE_MAP_DB_FILENAME;
    public static final String PERSISTENT_STORE_PROPERTY_NAME = "persistence_store";
}
