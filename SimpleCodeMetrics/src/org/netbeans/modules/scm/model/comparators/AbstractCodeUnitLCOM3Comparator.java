/*
 *
 * Copyright 2008 Krzysztof Dębski
 * This program is distributed under the terms of the GNU General Public License 3
 * 
 */

package org.netbeans.modules.scm.model.comparators;

import java.util.Comparator;
import org.netbeans.modules.scm.model.AbstractCodeUnitInfo;


public class AbstractCodeUnitLCOM3Comparator implements Comparator<AbstractCodeUnitInfo> {

    public int compare(AbstractCodeUnitInfo a1, AbstractCodeUnitInfo a2) {
        double d = a1.getLcom3() - a2.getLcom3();
        return d == 0. ? 0 : d < 0. ? -1 : 1;
    }
}
