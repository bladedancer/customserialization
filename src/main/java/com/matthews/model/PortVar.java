package com.matthews.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PortVar implements PortOneOf{
    private String var;
    private String description;
    private int value;
}
