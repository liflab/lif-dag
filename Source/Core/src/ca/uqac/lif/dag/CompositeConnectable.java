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

/**
 * A connectable object containing other connectable objects. Composite objects
 * present the feature that their upstream (resp. downstream) endpoints can be
 * associated to upstream (resp. downstream) endpoints of the objects they
 * contain.
 * <p>
 * <img src="{@docRoot}/doc-files/Composite.png" alt="Composite object" />
 * <p>
 * The figure above shows a composite object (the large box) containing
 * connected objects labeled <i>a</i>, <i>b</i> and <i>c</i>. Upstream endpoint
 * 0 of the composite object is associated to upstream endpoint 1 of <i>a</i>,
 * and downstream endpoint 0 is associated to downstream endpoint 0 of <i>c</i>
 * (dashed lines).
 * 
 * @author Sylvain Hallé
 */
public interface CompositeConnectable extends Connectable
{
	/**
	 * Adds a connectable object to the composite object.
	 * @param c The object to add
	 */
	public void add(Connectable c);
	
	/**
	 * Associates an upstream endpoint of the composite connectable to the
	 * upstream endpoint of an object it contains.
	 * @param outer_index The index of the upstream endpoint of the composite
	 * connectable
	 * @param c The connectable object to associate the endpoint to
	 * @param inner_index The index of the upstream endpoint on that connectable
	 * object
	 */
	public void associateUpEndpoint(int outer_index, Connectable c, int inner_index);
	
	/**
	 * Associates a downstream endpoint of the composite connectable to the
	 * downstream endpoint of an object it contains.
	 * @param outer_index The index of the downstream endpoint of the composite
	 * connectable
	 * @param c The connectable object to associate the endpoint to
	 * @param inner_index The index of the downstream endpoint on that
	 * connectable object
	 */
	public void associateDownEndpoint(int outer_index, Connectable c, int inner_index);
}
