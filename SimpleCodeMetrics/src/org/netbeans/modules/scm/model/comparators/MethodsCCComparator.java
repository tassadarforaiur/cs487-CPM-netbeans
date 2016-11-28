/*
 *
 * Copyright 2008 Krzysztof Dębski
 * This program is distributed under the terms of the GNU General Public License 3
 * 
 */

package org.netbeans.modules.scm.model.comparators;

import java.util.Comparator;
import org.netbeans.modules.scm.model.MethodInfo;

public class MethodsCCComparator implements Comparator<MethodInfo>{

    public int compare(MethodInfo m1, MethodInfo m2) {
        return m1.getCyclomaticComplexity() - m2.getCyclomaticComplexity();
    }

}
