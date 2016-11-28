/*
 *
 * Copyright 2008 Krzysztof Dębski
 * This program is distributed under the terms of the GNU General Public License 3
 * 
 */

package org.netbeans.modules.scm.model.comparators;

import java.util.Comparator;
import org.netbeans.modules.scm.model.AbstractCodeUnitInfo;

public class AbstractCodeUnitLCOM1Comparator implements  Comparator<AbstractCodeUnitInfo>{

    public int compare(AbstractCodeUnitInfo a1, AbstractCodeUnitInfo a2) {
        return a1.getLcom1() - a2.getLcom1();
    }

}
