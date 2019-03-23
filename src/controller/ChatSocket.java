package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Message;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;

@ServerEndpoint(value = "/ChatSocket")
public class ChatSocket {
    private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());
    private static final List<Message> messages = new ArrayList<>();

    @OnOpen
    public void onOpen(Session session) throws IOException, EncodeException {
        sessions.add(session);
        ObjectMapper mapper = new ObjectMapper();
        session.getBasicRemote().sendText(mapper.writeValueAsString(messages));
    }

    @OnMessage
    public void onMessage(Session session, String message) throws IOException, EncodeException {
        ObjectMapper mapper = new ObjectMapper();
        Message messageObject = mapper.readValue(message, Message.class);
        sendCommentToAll(messageObject);
        messages.add(messageObject);
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
    }

    private void sendCommentToAll(Message message) throws IOException, EncodeException {
        //noinspection Duplicates
        for (Session s : sessions) {
            List<Message> result = new ArrayList<>();
            result.add(message);
            ObjectMapper mapper = new ObjectMapper();
            s.getBasicRemote().sendText(mapper.writeValueAsString(result));
        }
    }
}
