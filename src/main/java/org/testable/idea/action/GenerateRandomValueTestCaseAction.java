package org.testable.idea.action;

import org.testable.idea.enums.BodyTypeEnum;

public class GenerateRandomValueTestCaseAction extends GenerateMethodToTestCaseAction {
    @Override
    protected BodyTypeEnum getBodyTypeEnum() {
        return BodyTypeEnum.RANDOM_VALUE_BODY;
    }
}
