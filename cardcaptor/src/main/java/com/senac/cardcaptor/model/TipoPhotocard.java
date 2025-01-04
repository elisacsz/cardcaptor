package com.senac.cardcaptor.model;

/**
 *
 * @author elisa
 */
public enum TipoPhotocard {
    REGULAR("Regular"),
    LUCKY_DRAW("Lucky Draw"),
    POB("POB"),
    FANSIGN("Fansign"),
    BROADCAST("Broadcast"),
    MERCH("Merch"),
    OUTRO("Outro tipo");

    private final String descricao;

    TipoPhotocard(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
