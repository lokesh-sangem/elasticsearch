package com.tac.optimized_es.entity;

public enum TaskPriority {

    URGENT("urgent"),
    HIGH("high"),
    NORMAL("normal"),
    LOW("low");

    private final String priority;

    TaskPriority(String priority) {
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }
}
