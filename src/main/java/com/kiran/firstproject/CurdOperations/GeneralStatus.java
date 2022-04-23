package com.kiran.firstproject.CurdOperations;

import javax.persistence.Column;

public class GeneralStatus {
    String status;

    public GeneralStatus(String status, String description) {
        this.status = status;
        this.description = description;
    }

    String description;

}
