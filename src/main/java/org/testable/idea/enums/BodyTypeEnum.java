package org.testable.idea.enums;

public enum BodyTypeEnum {
    DEFAULT_BODY(1, "返回默认值"),
    RANDOM_VALUE_BODY(2, "返回随机值"),
    ;

    private int id;
    private String desc;

    BodyTypeEnum(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
