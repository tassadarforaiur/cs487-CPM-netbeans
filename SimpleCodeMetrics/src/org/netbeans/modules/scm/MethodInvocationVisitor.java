/*
 *
 * Copyright 2008 Krzysztof Dębski
 * This program is distributed under the terms of the GNU General Public License 3
 * 
 */

package org.netbeans.modules.scm;

import com.sun.source.tree.MethodInvocationTree;
import com.sun.source.util.TreeScanner;
import java.util.HashSet;
import java.util.Set;

class MethodInvocationVisitor extends TreeScanner<Set<String>, Set<String>> {

        @Override
        public Set<String> visitMethodInvocation(MethodInvocationTree node, Set<String> in) {
            Set<String> superRes = super.visitMethodInvocation(node, in);
            if (superRes == null) {
                superRes = new HashSet<String>();
            }
            if (node != null) {
                superRes.add(node.getMethodSelect().toString());
            }
            return superRes;
        }

        @Override
        public Set<String> reduce(Set<String> s1, Set<String> s2) {
            if (s1 == null) {
                return (s2 == null ? new HashSet<String>() : s2);
            }
            if (s2 == null) {
                return s1;
            }
            if (s1.size() > s2.size()) {
                s1.addAll(s2);
                return s1;
            } else {
                s2.addAll(s1);
                return s2;
            }
        }
    }
