package com.training.websocket;

import com.google.gson.Gson;

import javax.websocket.*;

public class MessageEncoder implements Encoder.Text<Message>{

    private static final Gson gson = new Gson();

    @Override
    public String encode(Message object) throws EncodeException {
        return gson.toJson(object);
    }

    @Override
    public void init(EndpointConfig config) {
        // custom initialize logic
    }

    @Override
    public void destroy() {
        // close resource
    }

}
