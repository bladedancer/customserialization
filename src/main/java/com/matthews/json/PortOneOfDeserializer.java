package com.matthews.json;

import com.matthews.model.PortNumber;
import com.matthews.model.PortOneOf;
import com.matthews.model.PortVar;

public class PortOneOfDeserializer extends CustomDeserializer<PortOneOf> {
    @Override
    protected Class<? extends PortOneOf> getTargetClass(final Class nodeClass) {
        if (nodeClass == Integer.class) {
            return PortNumber.class;
        } else {
            return PortVar.class;
        }
    }
}
