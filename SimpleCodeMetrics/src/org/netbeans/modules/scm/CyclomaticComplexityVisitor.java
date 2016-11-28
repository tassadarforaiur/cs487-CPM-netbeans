/*
 *
 * Copyright 2008 Krzysztof Dębski
 * This program is distributed under the terms of the GNU General Public License 3
 * 
 */

package org.netbeans.modules.scm;

import com.sun.source.tree.CaseTree;
import com.sun.source.tree.ConditionalExpressionTree;
import com.sun.source.tree.DoWhileLoopTree;
import com.sun.source.tree.ForLoopTree;
import com.sun.source.tree.IfTree;
import com.sun.source.tree.WhileLoopTree;
import com.sun.source.util.TreeScanner;

class CyclomaticComplexityVisitor extends TreeScanner<Integer, Integer> {

    @Override
    public Integer visitForLoop(ForLoopTree node, Integer p) {
        return super.visitForLoop(node, p) + 1;
    }

    @Override
    public Integer visitWhileLoop(WhileLoopTree node, Integer p) {
        return super.visitWhileLoop(node, p) + 1;
    }

    @Override
    public Integer visitDoWhileLoop(DoWhileLoopTree node, Integer p) {
        return super.visitDoWhileLoop(node, p) + 1;
    }

    @Override
    public Integer visitIf(IfTree node, Integer p) {
        return super.visitIf(node, p) + 1;
    }

    @Override
    public Integer visitCase(CaseTree node, Integer p) {
        return super.visitCase(node, p) + 1;
    }

    @Override
    public Integer visitConditionalExpression(ConditionalExpressionTree node, Integer p) {
        return super.visitConditionalExpression(node, p) + 1;
    }

    @Override
    public Integer reduce(Integer r1, Integer r2) {
        return (r1 == null ? 0 : r1) + (r2 == null ? 0 : r2);
    }
}