package com.github.log;

import org.apache.logging.log4j.core.config.plugins.Plugin;

import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Set;

/**
 * Created by jianghang on 2018/5/6.
 */
public class DataInputMain {

    public static void main(String[] args) throws IOException {
        URL url = new URL("file:/Users/jianghang/Documents/code/Log-Action/target/classes/META-INF/org/apache/logging/log4j/core/config/plugins/Log4j2Plugins.dat");
        DataInputStream in = new DataInputStream(new BufferedInputStream(url.openStream()));

        final int count = in.readInt();
        for (int i = 0; i < count; i++) {
            final String category = in.readUTF();
            System.out.println("category: " + category);
            final int entries = in.readInt();
            for (int j = 0; j < entries; j++) {
                System.out.println(in.readUTF());
                System.out.println(in.readUTF());
                System.out.println(in.readUTF());
                System.out.println(in.readBoolean());

            }
        }
    }
}
