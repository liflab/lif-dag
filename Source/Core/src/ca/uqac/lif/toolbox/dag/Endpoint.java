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
package ca.uqac.lif.toolbox.dag;

/**
 * An indexed location on a {@link Connectable} object that can be connected
 * to another such object. Endpoints exist in two versions: "upstream" and
 * "downstream". An upstream endpoint can only be connected to a downstream
 * endpoint, and vice versa.
 * 
 * @author Sylvain Hallé
 */
public interface Endpoint
{
	/**
	 * Get the index of this endpoint.
	 * @return The index
	 */
	public int getIndex();
	
	/**
	 * Gets the object this endpoint belongs to. 
	 * @return The object
	 */
	public Connectable getOwner();
	
	/**
	 * Gets the endpoint on another {@link Connectable} object this endpoint is
	 * connected to.
	 * @return The other endpoint, or {@code null} if this endpoint is not
	 * connected to another object
	 */
	public Endpoint connectedTo();
	
	/**
	 * The upstream endpoint of a {@link Connectable} object. 
	 */
	public static interface UpEndpoint extends Endpoint
	{
		@Override
		public DownEndpoint connectedTo();
	}
	
	/**
	 * The downstream endpoint of a {@link Connectable} object. 
	 */
	public static interface DownEndpoint extends Endpoint
	{
		@Override
		public UpEndpoint connectedTo();
	}
}
