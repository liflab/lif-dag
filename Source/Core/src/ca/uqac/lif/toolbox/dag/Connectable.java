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

import ca.uqac.lif.toolbox.dag.Endpoint.DownEndpoint;
import ca.uqac.lif.toolbox.dag.Endpoint.UpEndpoint;

/**
 * An object having an number of upstream and downstream {@link Endpoints}
 * that can be used to link it to other objects. The figure below illustrates
 * these concepts.
 * <p>
 * <img src="{@docRoot}/doc-files/Circuit.png" alt="Circuit" />
 * <p>
 * It shows three connectable objects labeled <i>a</i>, <i>b</i> and <i>c</i>.
 * Cyan triangles show the <em>upstream</em> endpoints for each of these
 * objects, while triangles in magenta represent the <em>downstream</em>
 * endpoints. Both types of endpoints are given a unique index starting at 0.
 * The number of (up/down) endpoints is called the (up/down) <em>arity</em>
 * of the object. Some downstream endpoints are connected to upstream
 * endpoints, which is represented by a solid line.
 *    
 * @author Sylvain Hallé
 */
public interface Connectable
{
	/**
	 * Gets the upstream arity of the object, i.e.<!-- --> the number of upstream
	 * endpoints it possesses. The {@link Connectable} interface makes no
	 * assumption on this value, which is allowed to change during the lifetime
	 * of an object (although the interface defines no explicit means of doing
	 * so).
	 * @return The arity, which is always positive or equal to 0
	 */
	public int getUpArity();
	
	/**
	 * Gets the downstream arity of the object, i.e.<!-- --> the number of
	 * downstream endpoints it possesses. The {@link Connectable} interface makes
	 * no assumption on this value, which is allowed to change during the
	 * lifetime of an object (although the interface defines no explicit means of
	 * doing so).
	 * @return The arity, which is always positive or equal to 0
	 */
	public int getDownArity();
	
	/**
	 * Gets the upstream endpoint at given index.
	 * @param index The index
	 * @return The endpoint; must not be {@code null}
	 * @throws IndexOutOfBoundsException If {@code index} is negative or higher
	 * than or equal to the object's upstream arity
	 */
	/*@ non_null @*/ public UpEndpoint getUpEndpoint(int index) throws IndexOutOfBoundsException;
	
	/**
	 * Gets the downstream endpoint at given index.
	 * @param index The index
	 * @return The endpoint; must not be {@code null}
	 * @throws IndexOutOfBoundsException If {@code index} is negative or higher
	 * than or equal to the object's downstream arity
	 */
	/*@ non_null @*/ public DownEndpoint getDownEndpoint(int index) throws IndexOutOfBoundsException;
	
	/**
	 * Connects an upstream endpoint of an object to a downstream endpoint of
	 * another object.
	 * @param index The index of the upstream endpoint on the current object
	 * @param e The downstream endpoint to connect it to
	 * @throws IndexOutOfBoundsException If {@code index} is negative or higher
	 * than or equal to the object's upstream arity
	 */
	public void connectUpEndpoint(int index, DownEndpoint e) throws IndexOutOfBoundsException;
	
	/**
	 * Connects a downstream endpoint of an object to an upstream endpoint of
	 * another object.
	 * @param index The index of the downstream endpoint on the current object
	 * @param e The upstream endpoint to connect it to
	 * @throws IndexOutOfBoundsException If {@code index} is negative or higher
	 * than or equal to the object's downstream arity
	 */
	public void connectDownEndpoint(int index, UpEndpoint e) throws IndexOutOfBoundsException;
}
