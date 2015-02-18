package net.sourceforge.guacamole.net.basic.redirectlogout;

/*
 *  Guacamole - Clientless Remote Desktop
 *  Copyright (C) 2010  Michael Jumper
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sourceforge.guacamole.net.basic.redirectlogout.RedirectLogoutGuacamoleProperties;
import org.glyptodon.guacamole.GuacamoleException;
import org.glyptodon.guacamole.properties.GuacamoleProperties;

/**
 * Logs out the current user by invalidating the associated HttpSession and
 * redirecting the user to the defined url.
 *
 * @author Thomas Kriener
 */
public class RedirectLogout extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    throws IOException {

        // Invalidate session, if any
        HttpSession httpSession = request.getSession(false);
        if (httpSession != null)
            httpSession.invalidate();
        
        // Redirect to index by default
        String redirectUrl="index.xhtml";
        try {        
            redirectUrl = GuacamoleProperties.getProperty(RedirectLogoutGuacamoleProperties.REDIRECT_URL,"index.html");
        } catch (GuacamoleException ex) {
            Logger.getLogger(RedirectLogout.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        // Redirect to defined url
        response.sendRedirect(redirectUrl);

    }

}

