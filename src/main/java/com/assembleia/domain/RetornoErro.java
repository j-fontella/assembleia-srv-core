package com.assembleia.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class RetornoErro {
    private final List<String> erros = new ArrayList<>();
}
