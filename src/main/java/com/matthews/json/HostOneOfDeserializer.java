package com.matthews.json;

import com.matthews.model.HostOneOf;
import com.matthews.model.HostString;
import com.matthews.model.HostVar;

public class HostOneOfDeserializer extends CustomDeserializer<HostOneOf> {
    @Override
    protected Class<? extends HostOneOf> getTargetClass(final Class nodeClass) {
        if (nodeClass == String.class) {
            return HostString.class;
        } else {
            return HostVar.class;
        }
    }
}
