package com.abilia;

public class WsEvent {

    private String type;
    private int owner;
    private long revision;

    public WsEvent(String type, int owner, long revision) {
        this.type = type;
        this.owner = owner;
        this.revision = revision;
    }

    public String getType() {
        return type;
    }

    public int getOwner() {
        return owner;
    }

    public long getRevision() {
        return revision;
    }
}
