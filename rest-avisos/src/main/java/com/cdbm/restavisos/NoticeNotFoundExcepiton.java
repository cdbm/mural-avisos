package com.cdbm.restavisos;

class NoticeNotFoundException extends RuntimeException {

    NoticeNotFoundException(Long id) {
        super("Could not find notice " + id);
    }
}