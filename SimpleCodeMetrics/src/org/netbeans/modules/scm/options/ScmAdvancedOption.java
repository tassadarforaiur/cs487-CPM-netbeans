/*
 *
 * Copyright 2008 Krzysztof Dębski
 * This program is distributed under the terms of the GNU General Public License 3
 * 
 */

package org.netbeans.modules.scm.options;

import org.netbeans.spi.options.AdvancedOption;
import org.netbeans.spi.options.OptionsPanelController;
import org.openide.util.NbBundle;

public final class ScmAdvancedOption extends AdvancedOption {

    public String getDisplayName() {
        return NbBundle.getMessage(ScmAdvancedOption.class, "AdvancedOption_DisplayName_Scm");
    }

    public String getTooltip() {
        return NbBundle.getMessage(ScmAdvancedOption.class, "AdvancedOption_Tooltip_Scm");
    }

    public OptionsPanelController create() {
        return new ScmOptionsPanelController();
    }
}
