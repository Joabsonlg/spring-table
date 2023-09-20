package com.joabsonlg.additenstable;

import java.util.ArrayList;
import java.util.List;

public class Agreement {
    private List<Client> clients;

    public Agreement() {
        super();
        clients = new ArrayList<>();
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
