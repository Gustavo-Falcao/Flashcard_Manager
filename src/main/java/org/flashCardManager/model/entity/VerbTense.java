package org.flashCardManager.model.entity;

public enum VerbTense {
    PRESENT_SIMPLE,
    PRESENT_CONTINUOUS,
    PRESENT_PERFECT,
    PRESENT_PERFECT_CONTINUOUS,
    PAST_SIMPLE,
    PAST_CONTINUOUS,
    PAST_PERFECT,
    PAST_PERFECT_CONTINUOUS,
    FUTURE_SIMPLE,
    FUTURE_CONTINUOUS,
    FUTURE_PERFECT,
    FUTURE_PERFECT_CONTINUOUS;

    public String toShort() {
        return switch (this) {
            case PRESENT_SIMPLE -> "Pres. Simple";
            case PRESENT_CONTINUOUS -> "Pres. Continuous";
            case PRESENT_PERFECT -> "Pres. Perfect";
            case PRESENT_PERFECT_CONTINUOUS -> "Pres. Perf. Cont.";
            case PAST_SIMPLE -> "Past Simple";
            case PAST_CONTINUOUS -> "Past Cont.";
            case PAST_PERFECT -> "Past Perf.";
            case PAST_PERFECT_CONTINUOUS -> "Past Perf. Cont.";
            case FUTURE_SIMPLE -> "Fut. Simple";
            case FUTURE_CONTINUOUS -> "Fut. Continuous";
            case FUTURE_PERFECT -> "Fut. Perfect";
            case FUTURE_PERFECT_CONTINUOUS -> "Fut. Perf. Cont.";
        };
    }
}
