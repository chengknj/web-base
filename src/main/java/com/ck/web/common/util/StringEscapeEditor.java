package com.ck.web.common.util;

import java.beans.PropertyEditorSupport;

/**
 * Created by tianshuo on 2016/3/8.
 */
public class StringEscapeEditor extends PropertyEditorSupport {
    public StringEscapeEditor() {
        super();
    }


    public void setAsText(String text) {

        if (text == null) {

            setValue(null);

        } else {
            setValue(XssUtil.xssEncode(text));
        }

    }

    public String getAsText() {
        Object value = getValue();
        return value != null ? value.toString() : "";
    }
}
