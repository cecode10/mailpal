package com.mailpal.mail.connector;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

import java.util.Properties;

/**
 * Simple IMAP connector
 *
 * @author tsv
 * @since 17.07.2016.
 */
public class ImapConnector {

    public int connect() throws MessagingException {

        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        Session session = Session.getInstance(props, null);
        Store store = session.getStore();
        store.connect("imap.web.de", "cecode@web.de", "cecode123");
        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);
        Message msg = inbox.getMessage(inbox.getMessageCount());
        return msg.getSize();
    }
}
