/*
 *
 * Copyright 2008 Krzysztof Dębski
 * This program is distributed under the terms of the GNU General Public License 3
 * 
 */

package org.netbeans.modules.scm.model.comparators;

import java.util.Comparator;
import org.netbeans.modules.scm.model.AbstractCodeUnitInfo;

public class AbstractCodeUnitNumberOfClassesComparator implements  Comparator<AbstractCodeUnitInfo>{

    public int compare(AbstractCodeUnitInfo p1, AbstractCodeUnitInfo p2) {
        return p1.getClassesCount() - p2.getClassesCount();
    }



}
