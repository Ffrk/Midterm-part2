package com.ziwei.midtermpart2.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.io.Serializable;

public class ProcessorsModel implements Serializable {

    @NotBlank
    private String processorName = "";


    @NotBlank
    @Pattern(regexp = "(Intel|AMD|Apple)?")
    private String manuFactur = "";

    public ProcessorsModel() {
    }

    public ProcessorsModel(String firstName) {
        this.processorName = processorName;

    }

    public String getProcessorName() {
        return processorName;
    }

    public void setProcessorName(String processorName) {
        this.processorName = processorName;
    }

    @Override
    public String toString() {
        return "ProcessorsModel{" +
                "firstName='" + processorName + '\'' +
                '}';
    }


}
