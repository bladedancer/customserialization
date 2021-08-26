package com.matthews.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;

import java.io.IOException;

public abstract class CustomDeserializer<T> extends JsonDeserializer<T> {

    protected abstract Class<? extends T> getTargetClass(Class valueClass);

    @Override
    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();

        TreeNode node = mapper.readTree(jsonParser);

        if (node instanceof IntNode) {
            return mapper.treeToValue(node, getTargetClass(Integer.class));
        } else if (node instanceof ObjectNode) {
            return mapper.treeToValue(node, getTargetClass(Object.class));
        }  else if (node instanceof TextNode) {
            return mapper.treeToValue(node, getTargetClass(String.class));
        }
        return null;
    }
}
