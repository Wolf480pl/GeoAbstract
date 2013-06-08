/*
 * This file is part of GeoAbstract.
 *
 * Copyright (c) 2013 Wolf480pl <wolf480@interia.pl>
 * GeoAbstract is licensed under the GNU Lesser General Public License.
 *
 * GeoAbstract is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * GeoAbstract is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
/*
 * This file is part of SpoutAPI.
 *
 * Copyright (c) 2011-2012, Spout LLC <http://www.spout.org/>
 * SpoutAPI is licensed under the Spout License Version 1.
 *
 * SpoutAPI is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option)
 * any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the Spout License Version 1.
 *
 * SpoutAPI is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License for
 * more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the Spout License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://spout.in/licensev1> for the full license, including
 * the MIT license.
 */
package com.github.wolf480pl.geoabstract.util.math;

import static org.junit.Assert.assertEquals;

import static com.github.wolf480pl.geoabstract.util.math.GenericMath.*;

import org.junit.Test;

public final class GenericMathTest {
	
	@Test
	public void testMod() {
		
		for (int i = -15; i <= 15; i++) {
			modCheck(i, 5);
		}
		
	}
	
	private final void modCheck(final int a, final int d) {
		
		int newA = a;
		
		while (newA <= 0) {
			newA += d;
		}
		
		assertEquals("Mod check failed for " + a + " mod " + d, (newA % d), mod(a, d));
		
		assertEquals("Mod check failed for " + a + " mod " + d, (newA % d), mod((float) a, (float) d), 0.001F);

		assertEquals("Mod check failed for " + a + " mod " + d, (newA % d), mod((double) a, (double) d), 0.001D);
	}

}
