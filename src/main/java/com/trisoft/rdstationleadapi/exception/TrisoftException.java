package com.trisoft.rdstationleadapi.exception;

public class TrisoftException extends Exception{

    private String trisoftCode;

    /**
     *
     * @param trisoftCode : Código para exibir mensagem no cliente.
     * @param message : Mensagem do possível erro.
     */
    public TrisoftException(String trisoftCode, String message) {
        super(message);
        this.trisoftCode = trisoftCode;
    }

    public TrisoftException(String message) {
        super(message);
    }

    public String getTrisoftCode() {
        return trisoftCode;
    }

    public void setTrisoftCode(String groupCode) {
        this.trisoftCode = trisoftCode;
    }

}

