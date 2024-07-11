/*
    A toolbox of common classes and interfaces
    Copyright (C) 2022-2024 Sylvain Hallé

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published
    by the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ca.uqac.lif.dag;

import ca.uqac.lif.dag.Endpoint.DownEndpoint;
import ca.uqac.lif.dag.Endpoint.UpEndpoint;

/**
 * Provides utility methods for connecting objects.
 * 
 * @author Sylvain Hallé
 */
public interface ConnectableConnector
{
	/**
	 * Makes a bidirectional link between the downstream endpoint of an object
	 * and the upstream endpoint of another object. 
	 * @param i1 The index of the downstream endpoint on the first object
	 * @param c1 The first object
	 * @param i2 The index of the upstream endpoint on the secod object
	 * @param c2 The second object
	 * @throws ConnectableConnectorException If either of the endpoint indices
	 * is out of bounds or the endpoint is null
	 */
	public static void connect(int i1, Connectable c1, int i2, Connectable c2) throws ConnectableConnectorException
	{
		try
		{
			DownEndpoint e1 = c1.getDownEndpoint(i1);
			if (e1 == null)
			{
				throw new ConnectableConnectorException("Down endpoint is null");
			}
			UpEndpoint e2 = c2.getUpEndpoint(i2);
			if (e2 == null)
			{
				throw new ConnectableConnectorException("Up endpoint is null");
			}
			c1.connectDownEndpoint(i1, e2);
			c2.connectUpEndpoint(i2, e1);
		}
		catch (IndexOutOfBoundsException e)
		{
			throw new ConnectableConnectorException(e);
		}
	}
}
