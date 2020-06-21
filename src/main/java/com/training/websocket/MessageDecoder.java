package com.training.websocket;

import com.google.gson.Gson;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class MessageDecoder implements Decoder.Text<Message>{

    private static final Gson gson = new Gson();

    @Override
    public Message decode(String str) throws DecodeException {
        return gson.fromJson(str, Message.class);
    }

    @Override
    public boolean willDecode(String str) {
        return str != null;
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
