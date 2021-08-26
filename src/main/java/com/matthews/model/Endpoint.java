package com.matthews.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endpoint {
    private PortOneOf port;
    private HostOneOf host;
}
