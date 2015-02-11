/*
 * Copyright (C) 2013 Glyptodon LLC
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.glyptodon.guacamole.net.auth;

import org.glyptodon.guacamole.GuacamoleException;
import org.glyptodon.guacamole.net.auth.permission.ObjectPermissionSet;
import org.glyptodon.guacamole.net.auth.permission.SystemPermissionSet;


/**
 * A user of the Guacamole web application.
 *
 * @author Michael Jumper
 */
public interface User {

    /**
     * Returns the name of this user, which must be unique across all users.
     * All users must have a deterministic, unique username which may not be
     * null.
     *
     * @return
     *     The unique username of this user, which may not be null.
     */
    public String getUsername();

    /**
     * Sets the name of this user, which must be unique across all users.
     *
     * @param username  The name of this user.
     */
    public void setUsername(String username);

    /**
     * Returns this user's password. Note that the password returned may be
     * hashed or completely arbitrary.
     *
     * @return A String which may (or may not) be the user's password.
     */
    public String getPassword();

    /**
     * Sets this user's password. Note that while this function is guaranteed
     * to change the password of this User object, there is no guarantee that
     * getPassword() will return the value given to setPassword().
     *
     * @param password The password to set.
     */
    public void setPassword(String password);

    /**
     * Lists all permissions given to this user.
     *
     * @return A Set of all permissions granted to this user.
     *
     * @throws GuacamoleException  If an error occurs while retrieving
     *                             permissions, or if reading all permissions
     *                             is not allowed.
     */
    SystemPermissionSet getSystemPermissions() throws GuacamoleException;

    /**
     * Lists all permissions given to this user.
     *
     * @return A Set of all permissions granted to this user.
     *
     * @throws GuacamoleException  If an error occurs while retrieving
     *                             permissions, or if reading all permissions
     *                             is not allowed.
     */
    ObjectPermissionSet<String, Connection> getConnectionPermissions() throws GuacamoleException;

    /**
     * Lists all permissions given to this user.
     *
     * @return A Set of all permissions granted to this user.
     *
     * @throws GuacamoleException  If an error occurs while retrieving
     *                             permissions, or if reading all permissions
     *                             is not allowed.
     */
    ObjectPermissionSet<String, ConnectionGroup> getConnectionGroupPermissions() throws GuacamoleException;

    /**
     * Lists all permissions given to this user.
     *
     * @return A Set of all permissions granted to this user.
     *
     * @throws GuacamoleException  If an error occurs while retrieving
     *                             permissions, or if reading all permissions
     *                             is not allowed.
     */
    ObjectPermissionSet<String, User> getUserPermissions() throws GuacamoleException;

}
