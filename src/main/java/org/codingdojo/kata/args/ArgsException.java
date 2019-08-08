package org.codingdojo.kata.args;

class ArgsException extends RuntimeException {
    ArgsException(String message) {
        super(message);
    }
}

class LabelNotFound extends ArgsException {
    LabelNotFound(String label) {
        super(label);
    }
}

class InvalidSchema extends ArgsException {
    InvalidSchema(String schemaText) {
        super(schemaText);
    }
}