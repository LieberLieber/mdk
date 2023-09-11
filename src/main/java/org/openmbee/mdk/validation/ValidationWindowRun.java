package org.openmbee.mdk.validation;

import com.nomagic.magicdraw.annotation.Annotation;
import com.nomagic.magicdraw.validation.RuleViolationResult;
import com.nomagic.magicdraw.validation.ValidationRunData;

import java.util.List;
import java.util.Map;

public class ValidationWindowRun {

    public String title;
    public String id;
    public ValidationRunData runData;
    public List<RuleViolationResult> results;
    public Map<Annotation, RuleViolationResult> mapping;

    public ValidationWindowRun(String title, String id, ValidationRunData runData, List<RuleViolationResult> results, Map<Annotation, RuleViolationResult> mapping) {
        this.title = title;
        this.id = id;
        this.runData = runData;
        this.results = results;
        this.mapping = mapping;
    }
}
