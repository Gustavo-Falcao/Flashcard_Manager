package org.flashCardManager.model.entity;

public enum Context {
    ADJECTIVE,
    ADVERB,
    FIGURATIVE,
    FORMAL,
    INFORMAL,
    LITERAL,
    NOUN,
    PHRASE,
    PREPOSITION,
    SLANG,
    VERB;

    public String toShow() {
        return switch (this) {
            case ADJECTIVE -> "Adjective";
            case ADVERB -> "Adverb";
            case FIGURATIVE -> "Figurative";
            case FORMAL -> "Formal";
            case INFORMAL -> "Informal";
            case LITERAL -> "Literal";
            case NOUN -> "Noun";
            case PHRASE -> "Phrase";
            case PREPOSITION -> "Preposition";
            case SLANG -> "Slang";
            case VERB -> "Verb";
        };
    }

}
