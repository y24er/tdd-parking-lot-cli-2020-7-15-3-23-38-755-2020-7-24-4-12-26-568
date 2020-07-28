package com.oocl.cultivation;

public class ErrorMessage {
    public enum Message {
        NULL_TICKET("Please provide your parking ticket."),
        UNRECOGNIZED_TICKET("Unrecognized parking ticket."),
        NON_POSITION("Not enough position.");
        private String message;

        Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public String toString() {
            return getMessage() ;
        }
    }

}