package org.openmbee.mdk.model;

import com.nomagic.magicdraw.core.Application;
import org.openmbee.mdk.api.incubating.convert.Converters;
import org.openmbee.mdk.validation.ValidationRule;
import org.openmbee.mdk.validation.ValidationRuleViolation;
import org.openmbee.mdk.validation.ValidationSuite;
import org.openmbee.mdk.validation.ViolationSeverity;
import org.openmbee.mdk.docgen.validation.*;

public class DocGenValidationDBSwitch extends DocGenValidationSwitch<Object> {

    @Override
    public Object caseRule(Rule object) {
        ViolationSeverity vs = null;
        if (object.getSeverity() == Severity.DEBUG) {
            vs = ViolationSeverity.DEBUG;
        }
        else if (object.getSeverity() == Severity.ERROR) {
            vs = ViolationSeverity.ERROR;
        }
        else if (object.getSeverity() == Severity.FATAL) {
            vs = ViolationSeverity.FATAL;
        }
        else if (object.getSeverity() == Severity.INFO) {
            vs = ViolationSeverity.INFO;
        }
        else {
            vs = ViolationSeverity.WARNING;
        }
        ValidationRule res = new ValidationRule(object.getName(), object.getDescription(), vs);
        for (Violation v : object.getViolations()) {
            res.addViolation((ValidationRuleViolation) this.doSwitch(v));
        }
        return res;
    }

    @Override
    public Object caseViolation(Violation object) {
        if (object.getElementId() != null) {
            ValidationRuleViolation res = new ValidationRuleViolation(Converters.getIdToElementConverter()
                    .apply(object.getElementId(), Application.getInstance().getProject()), object.getComment());
            return res;
        }
        return null;
    }

    @Override
    public Object caseSuite(Suite object) {
        ValidationSuite res = new ValidationSuite(object.getName());
        for (Rule r : object.getRules()) {
            res.addValidationRule((ValidationRule) this.doSwitch(r));
        }
        res.setOwnSection(object.isOwnSection());
        res.setShowDetail(object.isShowDetail());
        res.setShowSummary(object.isShowSummary());
        return res;
    }

}
