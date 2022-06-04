package org.testable.idea.action;

import org.testable.idea.enums.BodyTypeEnum;

public class GenerateDefaultValueTestCaseAction extends GenerateMethodToTestCaseAction {
    @Override
    protected BodyTypeEnum getBodyTypeEnum() {
        return BodyTypeEnum.DEFAULT_BODY;
    }
}
