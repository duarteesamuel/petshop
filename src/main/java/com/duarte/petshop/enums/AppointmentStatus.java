package com.duarte.petshop.enums;

public enum AppointmentStatus {
    SCHEDULED("Agendado"),
    COMPLETED("Concluída"),
    CANCELED("Cancelada");

    private String status;

    AppointmentStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
