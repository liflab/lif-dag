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

public class ConnectableConnectorException extends RuntimeException
{
	/**
	 * Dummy UID.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Creates an exception from another throwable object.
	 * @param t The throwable object
	 */
	public ConnectableConnectorException(Throwable t)
	{
		super(t);
	}
	
	/**
	 * Creates an exception with a textual message.
	 * @param message The message
	 */
	public ConnectableConnectorException(String message)
	{
		super(message);
	}
}
